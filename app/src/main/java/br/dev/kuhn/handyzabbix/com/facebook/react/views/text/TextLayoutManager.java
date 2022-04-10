package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.LruCache;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TextLayoutManager {
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING = false;
    private static final String INCLUDE_FONT_PADDING_KEY = "includeFontPadding";
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    private static final String MAXIMUM_NUMBER_OF_LINES_KEY = "maximumNumberOfLines";
    private static final String TAG = "TextLayoutManager";
    private static final String TEXT_BREAK_STRATEGY_KEY = "textBreakStrategy";
    private static final LruCache<String, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final LruCache<ReadableNativeMap, Spannable> sSpannableCacheV2 = new LruCache<>(100);
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache = new ConcurrentHashMap<>();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final int spannableCacheSize = 100;

    public static boolean isRTL(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("fragments");
        if (array.size() <= 0 || new TextAttributeProps(new ReactStylesDiffMap(array.getMap(0).getMap("textAttributes"))).mLayoutDirection != 1) {
            return false;
        }
        return DEFAULT_INCLUDE_FONT_PADDING;
    }

    public static void setCachedSpannabledForTag(int i, Spannable spannable) {
        sTagToSpannableCache.put(Integer.valueOf(i), spannable);
    }

    public static void deleteCachedSpannableForTag(int i) {
        sTagToSpannableCache.remove(Integer.valueOf(i));
    }

    private static void buildSpannableFromFragment(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int i;
        List<SetSpanOperation> list2 = list;
        int i2 = 0;
        for (int size = readableArray.size(); i2 < size; size = i) {
            ReadableMap map = readableArray.getMap(i2);
            int length = spannableStringBuilder.length();
            TextAttributeProps textAttributeProps = new TextAttributeProps(new ReactStylesDiffMap(map.getMap("textAttributes")));
            spannableStringBuilder.append(TextTransform.apply(map.getString(TypedValues.Custom.S_STRING), textAttributeProps.mTextTransform));
            int length2 = spannableStringBuilder.length();
            int i3 = map.hasKey("reactTag") ? map.getInt("reactTag") : -1;
            if (map.hasKey(ViewProps.IS_ATTACHMENT) && map.getBoolean(ViewProps.IS_ATTACHMENT)) {
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i3, (int) PixelUtil.toPixelFromSP(map.getDouble("width")), (int) PixelUtil.toPixelFromSP(map.getDouble("height")))));
            } else if (length2 >= length) {
                if (ReactAccessibilityDelegate.AccessibilityRole.LINK.equals(textAttributeProps.mAccessibilityRole)) {
                    list2.add(new SetSpanOperation(length, length2, new ReactClickableSpan(i3, textAttributeProps.mColor)));
                } else if (textAttributeProps.mIsColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(textAttributeProps.mColor)));
                }
                if (textAttributeProps.mIsBackgroundColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(textAttributeProps.mBackgroundColor)));
                }
                if (Build.VERSION.SDK_INT >= 21 && !Float.isNaN(textAttributeProps.getLetterSpacing())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(textAttributeProps.getLetterSpacing())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(textAttributeProps.mFontSize)));
                if (textAttributeProps.mFontStyle == -1 && textAttributeProps.mFontWeight == -1 && textAttributeProps.mFontFamily == null) {
                    i = size;
                } else {
                    i = size;
                    CustomStyleSpan customStyleSpan = r10;
                    CustomStyleSpan customStyleSpan2 = new CustomStyleSpan(textAttributeProps.mFontStyle, textAttributeProps.mFontWeight, textAttributeProps.mFontFeatureSettings, textAttributeProps.mFontFamily, context.getAssets());
                    list2.add(new SetSpanOperation(length, length2, customStyleSpan));
                }
                if (textAttributeProps.mIsUnderlineTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (textAttributeProps.mIsLineThroughTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!(textAttributeProps.mTextShadowOffsetDx == 0.0f && textAttributeProps.mTextShadowOffsetDy == 0.0f)) {
                    list2.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(textAttributeProps.mTextShadowOffsetDx, textAttributeProps.mTextShadowOffsetDy, textAttributeProps.mTextShadowRadius, textAttributeProps.mTextShadowColor)));
                }
                if (!Float.isNaN(textAttributeProps.getEffectiveLineHeight())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(textAttributeProps.getEffectiveLineHeight())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactTagSpan(i3)));
                i2++;
            }
            i = size;
            i2++;
        }
    }

    public static Spannable getOrCreateSpannableForText(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        String str = "";
        boolean z = ReactFeatureFlags.enableSpannableCacheByReadableNativeMapEquality;
        if (z) {
            synchronized (sSpannableCacheLock) {
                Spannable spannable = sSpannableCacheV2.get((ReadableNativeMap) readableMap);
                if (spannable != null) {
                    return spannable;
                }
            }
        } else {
            str = readableMap.toString();
            synchronized (sSpannableCacheLock) {
                Spannable spannable2 = sSpannableCache.get(str);
                if (spannable2 != null) {
                    return spannable2;
                }
            }
        }
        Spannable createSpannableFromAttributedString = createSpannableFromAttributedString(context, readableMap, reactTextViewManagerCallback);
        if (z) {
            synchronized (sSpannableCacheLock) {
                sSpannableCacheV2.put((ReadableNativeMap) readableMap, createSpannableFromAttributedString);
            }
        } else {
            synchronized (sSpannableCacheLock) {
                sSpannableCache.put(str, createSpannableFromAttributedString);
            }
        }
        return createSpannableFromAttributedString;
    }

    private static Spannable createSpannableFromAttributedString(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        buildSpannableFromFragment(context, readableMap.getArray("fragments"), spannableStringBuilder, arrayList);
        int i = 0;
        for (SetSpanOperation execute : arrayList) {
            execute.execute(spannableStringBuilder, i);
            i++;
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f, YogaMeasureMode yogaMeasureMode, boolean z, int i) {
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f2 = f;
        boolean z2 = z;
        int i2 = i;
        int length = spannable.length();
        boolean z3 = (yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f) ? DEFAULT_INCLUDE_FONT_PADDING : false;
        TextPaint textPaint = sTextPaintInstance;
        float desiredWidth = metrics2 == null ? Layout.getDesiredWidth(spannable2, textPaint) : Float.NaN;
        if (metrics2 == null && (z3 || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f2))) {
            int ceil = (int) Math.ceil((double) desiredWidth);
            if (Build.VERSION.SDK_INT < 23) {
                return new StaticLayout(spannable, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
            }
            return StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i2).setHyphenationFrequency(1).build();
        } else if (metrics2 != null && (z3 || ((float) metrics2.width) <= f2)) {
            return BoringLayout.make(spannable, textPaint, metrics2.width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, metrics, z);
        } else if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(spannable, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
        } else {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, (int) f2).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i2).setHyphenationFrequency(1);
            if (Build.VERSION.SDK_INT >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(DEFAULT_INCLUDE_FONT_PADDING);
            }
            return hyphenationFrequency.build();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a8, code lost:
        if (r11 > r21) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
        if (r1 > r23) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r18, com.facebook.react.bridge.ReadableMap r19, com.facebook.react.bridge.ReadableMap r20, float r21, com.facebook.yoga.YogaMeasureMode r22, float r23, com.facebook.yoga.YogaMeasureMode r24, com.facebook.react.views.text.ReactTextViewManagerCallback r25, float[] r26) {
        /*
            r0 = r19
            r1 = r20
            r8 = r22
            r9 = r24
            android.text.TextPaint r2 = sTextPaintInstance
            java.lang.String r3 = "cacheId"
            boolean r4 = r0.hasKey(r3)
            if (r4 == 0) goto L_0x0030
            int r0 = r0.getInt(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r3 = sTagToSpannableCache
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x002d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r3.get(r0)
            android.text.Spannable r0 = (android.text.Spannable) r0
            goto L_0x0038
        L_0x002d:
            r0 = 0
            return r0
        L_0x0030:
            r3 = r18
            r4 = r25
            android.text.Spannable r0 = getOrCreateSpannableForText(r3, r0, r4)
        L_0x0038:
            java.lang.String r3 = "textBreakStrategy"
            java.lang.String r3 = r1.getString(r3)
            int r7 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r3)
            java.lang.String r3 = "includeFontPadding"
            boolean r4 = r1.hasKey(r3)
            r10 = 1
            if (r4 == 0) goto L_0x0051
            boolean r3 = r1.getBoolean(r3)
            r6 = r3
            goto L_0x0052
        L_0x0051:
            r6 = 1
        L_0x0052:
            if (r0 == 0) goto L_0x0188
            android.text.BoringLayout$Metrics r3 = android.text.BoringLayout.isBoring(r0, r2)
            if (r3 != 0) goto L_0x005d
            android.text.Layout.getDesiredWidth(r0, r2)
        L_0x005d:
            com.facebook.yoga.YogaMeasureMode r2 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
            r11 = 0
            if (r8 == r2) goto L_0x0064
            int r2 = (r21 > r11 ? 1 : (r21 == r11 ? 0 : -1))
        L_0x0064:
            r2 = r0
            r4 = r21
            r5 = r22
            android.text.Layout r2 = createLayout(r2, r3, r4, r5, r6, r7)
            java.lang.String r3 = "maximumNumberOfLines"
            boolean r4 = r1.hasKey(r3)
            r5 = -1
            if (r4 == 0) goto L_0x007b
            int r1 = r1.getInt(r3)
            goto L_0x007c
        L_0x007b:
            r1 = -1
        L_0x007c:
            if (r1 == r5) goto L_0x008a
            if (r1 != 0) goto L_0x0081
            goto L_0x008a
        L_0x0081:
            int r3 = r2.getLineCount()
            int r1 = java.lang.Math.min(r1, r3)
            goto L_0x008e
        L_0x008a:
            int r1 = r2.getLineCount()
        L_0x008e:
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r8 != r3) goto L_0x0093
            goto L_0x00aa
        L_0x0093:
            r3 = 0
        L_0x0094:
            if (r3 >= r1) goto L_0x00a2
            float r6 = r2.getLineWidth(r3)
            int r7 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x009f
            r11 = r6
        L_0x009f:
            int r3 = r3 + 1
            goto L_0x0094
        L_0x00a2:
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r8 != r3) goto L_0x00ac
            int r3 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ac
        L_0x00aa:
            r11 = r21
        L_0x00ac:
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r9 == r3) goto L_0x00be
            int r1 = r1 - r10
            int r1 = r2.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r9 != r3) goto L_0x00c0
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c0
        L_0x00be:
            r1 = r23
        L_0x00c0:
            r3 = 0
            r6 = 0
        L_0x00c2:
            int r7 = r0.length()
            if (r3 >= r7) goto L_0x017b
            int r7 = r0.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            int r7 = r0.nextSpanTransition(r3, r7, r8)
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            java.lang.Object[] r3 = r0.getSpans(r3, r7, r8)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r3 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r3
            int r8 = r3.length
            r9 = 0
        L_0x00dc:
            if (r9 >= r8) goto L_0x0178
            r12 = r3[r9]
            int r13 = r0.getSpanStart(r12)
            int r14 = r2.getLineForOffset(r13)
            int r15 = r2.getEllipsisCount(r14)
            if (r15 <= 0) goto L_0x00f0
            r15 = 1
            goto L_0x00f1
        L_0x00f0:
            r15 = 0
        L_0x00f1:
            if (r15 == 0) goto L_0x0109
            int r15 = r2.getLineStart(r14)
            int r16 = r2.getEllipsisStart(r14)
            int r15 = r15 + r16
            if (r13 < r15) goto L_0x0109
            int r15 = r2.getLineEnd(r14)
            if (r13 < r15) goto L_0x0106
            goto L_0x0109
        L_0x0106:
            r5 = 1
            goto L_0x0172
        L_0x0109:
            int r15 = r12.getWidth()
            float r15 = (float) r15
            int r12 = r12.getHeight()
            float r12 = (float) r12
            boolean r4 = r2.isRtlCharAt(r13)
            int r10 = r2.getParagraphDirection(r14)
            if (r10 != r5) goto L_0x011f
            r10 = 1
            goto L_0x0120
        L_0x011f:
            r10 = 0
        L_0x0120:
            int r16 = r0.length()
            r17 = 1
            int r5 = r16 + -1
            if (r13 != r5) goto L_0x0139
            if (r10 == 0) goto L_0x0133
            float r4 = r2.getLineWidth(r14)
            float r4 = r11 - r4
            goto L_0x015a
        L_0x0133:
            float r4 = r2.getLineRight(r14)
            float r4 = r4 - r15
            goto L_0x015a
        L_0x0139:
            if (r10 != r4) goto L_0x013e
            r17 = 1
            goto L_0x0140
        L_0x013e:
            r17 = 0
        L_0x0140:
            if (r17 == 0) goto L_0x0147
            float r5 = r2.getPrimaryHorizontal(r13)
            goto L_0x014b
        L_0x0147:
            float r5 = r2.getSecondaryHorizontal(r13)
        L_0x014b:
            if (r10 == 0) goto L_0x0154
            float r10 = r2.getLineRight(r14)
            float r10 = r10 - r5
            float r5 = r11 - r10
        L_0x0154:
            if (r4 == 0) goto L_0x0159
            float r4 = r5 - r15
            goto L_0x015a
        L_0x0159:
            r4 = r5
        L_0x015a:
            int r5 = r2.getLineBaseline(r14)
            float r5 = (float) r5
            float r5 = r5 - r12
            int r10 = r6 * 2
            float r5 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r5)
            r26[r10] = r5
            r5 = 1
            int r10 = r10 + r5
            float r4 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r4)
            r26[r10] = r4
            int r6 = r6 + 1
        L_0x0172:
            int r9 = r9 + 1
            r5 = -1
            r10 = 1
            goto L_0x00dc
        L_0x0178:
            r3 = r7
            goto L_0x00c2
        L_0x017b:
            float r0 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r11)
            float r1 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r1)
            long r0 = com.facebook.yoga.YogaMeasureOutput.make((float) r0, (float) r1)
            return r0
        L_0x0188:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Spannable element has not been prepared in onBeforeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.measureText(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, com.facebook.react.views.text.ReactTextViewManagerCallback, float[]):long");
    }

    public static WritableArray measureLines(Context context, ReadableMap readableMap, ReadableMap readableMap2, float f) {
        TextPaint textPaint = sTextPaintInstance;
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, readableMap, (ReactTextViewManagerCallback) null);
        return FontMetricsUtil.getFontMetrics(orCreateSpannableForText, createLayout(orCreateSpannableForText, BoringLayout.isBoring(orCreateSpannableForText, textPaint), f, YogaMeasureMode.EXACTLY, readableMap2.hasKey("includeFontPadding") ? readableMap2.getBoolean("includeFontPadding") : DEFAULT_INCLUDE_FONT_PADDING, TextAttributeProps.getTextBreakStrategy(readableMap2.getString("textBreakStrategy"))), textPaint, context);
    }

    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }

        public void execute(Spannable spannable, int i) {
            int i2 = this.start;
            spannable.setSpan(this.what, i2, this.end, ((i << 16) & 16711680) | ((i2 == 0 ? 18 : 34) & -16711681));
        }
    }
}
