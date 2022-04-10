package com.facebook.react.uimanager;

import java.util.Arrays;
import java.util.HashSet;

public class ViewProps {
    public static final String ACCESSIBILITY_ACTIONS = "accessibilityActions";
    public static final String ACCESSIBILITY_HINT = "accessibilityHint";
    public static final String ACCESSIBILITY_LABEL = "accessibilityLabel";
    public static final String ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
    public static final String ACCESSIBILITY_ROLE = "accessibilityRole";
    public static final String ACCESSIBILITY_STATE = "accessibilityState";
    public static final String ACCESSIBILITY_VALUE = "accessibilityValue";
    public static final String ADJUSTS_FONT_SIZE_TO_FIT = "adjustsFontSizeToFit";
    public static final String ALIGN_CONTENT = "alignContent";
    public static final String ALIGN_ITEMS = "alignItems";
    public static final String ALIGN_SELF = "alignSelf";
    public static final String ALLOW_FONT_SCALING = "allowFontScaling";
    public static final String ASPECT_RATIO = "aspectRatio";
    public static final String AUTO = "auto";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
    public static final String BORDER_BOTTOM_END_RADIUS = "borderBottomEndRadius";
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_BOTTOM_START_RADIUS = "borderBottomStartRadius";
    public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
    public static final String BORDER_COLOR = "borderColor";
    public static final String BORDER_END_COLOR = "borderEndColor";
    public static final String BORDER_END_WIDTH = "borderEndWidth";
    public static final String BORDER_LEFT_COLOR = "borderLeftColor";
    public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_RIGHT_COLOR = "borderRightColor";
    public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};
    public static final String BORDER_START_COLOR = "borderStartColor";
    public static final String BORDER_START_WIDTH = "borderStartWidth";
    public static final String BORDER_TOP_COLOR = "borderTopColor";
    public static final String BORDER_TOP_END_RADIUS = "borderTopEndRadius";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String BORDER_TOP_START_RADIUS = "borderTopStartRadius";
    public static final String BORDER_TOP_WIDTH = "borderTopWidth";
    public static final String BORDER_WIDTH = "borderWidth";
    public static final String BOTTOM = "bottom";
    public static final String BOX_NONE = "box-none";
    public static final String COLLAPSABLE = "collapsable";
    public static final String COLOR = "color";
    public static final String DISPLAY = "display";
    public static final String ELEVATION = "elevation";
    public static final String ELLIPSIZE_MODE = "ellipsizeMode";
    public static final String ENABLED = "enabled";
    public static final String END = "end";
    public static final String FLEX = "flex";
    public static final String FLEX_BASIS = "flexBasis";
    public static final String FLEX_DIRECTION = "flexDirection";
    public static final String FLEX_GROW = "flexGrow";
    public static final String FLEX_SHRINK = "flexShrink";
    public static final String FLEX_WRAP = "flexWrap";
    public static final String FONT_FAMILY = "fontFamily";
    public static final String FONT_SIZE = "fontSize";
    public static final String FONT_STYLE = "fontStyle";
    public static final String FONT_VARIANT = "fontVariant";
    public static final String FONT_WEIGHT = "fontWeight";
    public static final String HEIGHT = "height";
    public static final String HIDDEN = "hidden";
    public static final String IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
    public static final String INCLUDE_FONT_PADDING = "includeFontPadding";
    public static final String IS_ATTACHMENT = "isAttachment";
    public static final String JUSTIFY_CONTENT = "justifyContent";
    public static final String LAYOUT_DIRECTION = "layoutDirection";
    private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet<>(Arrays.asList(new String[]{ALIGN_SELF, ALIGN_ITEMS, COLLAPSABLE, FLEX, FLEX_BASIS, FLEX_DIRECTION, FLEX_GROW, FLEX_SHRINK, FLEX_WRAP, JUSTIFY_CONTENT, ALIGN_CONTENT, "display", POSITION, RIGHT, TOP, BOTTOM, LEFT, START, END, "width", "height", MIN_WIDTH, MAX_WIDTH, MIN_HEIGHT, MAX_HEIGHT, MARGIN, MARGIN_VERTICAL, MARGIN_HORIZONTAL, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM, MARGIN_START, MARGIN_END, PADDING, PADDING_VERTICAL, PADDING_HORIZONTAL, PADDING_LEFT, PADDING_RIGHT, PADDING_TOP, PADDING_BOTTOM, PADDING_START, PADDING_END}));
    public static final String LEFT = "left";
    public static final String LETTER_SPACING = "letterSpacing";
    public static final String LINE_HEIGHT = "lineHeight";
    public static final String MARGIN = "margin";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String MARGIN_END = "marginEnd";
    public static final String MARGIN_HORIZONTAL = "marginHorizontal";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_START = "marginStart";
    public static final String MARGIN_TOP = "marginTop";
    public static final String MARGIN_VERTICAL = "marginVertical";
    public static final String MAX_FONT_SIZE_MULTIPLIER = "maxFontSizeMultiplier";
    public static final String MAX_HEIGHT = "maxHeight";
    public static final String MAX_WIDTH = "maxWidth";
    public static final String MINIMUM_FONT_SCALE = "minimumFontScale";
    public static final String MIN_HEIGHT = "minHeight";
    public static final String MIN_WIDTH = "minWidth";
    public static final String NATIVE_ID = "nativeID";
    public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
    public static final String NONE = "none";
    public static final String NUMBER_OF_LINES = "numberOfLines";

    /* renamed from: ON */
    public static final String f170ON = "on";
    public static final String ON_LAYOUT = "onLayout";
    public static final String OPACITY = "opacity";
    public static final String OVERFLOW = "overflow";
    public static final String PADDING = "padding";
    public static final String PADDING_BOTTOM = "paddingBottom";
    public static final String PADDING_END = "paddingEnd";
    public static final String PADDING_HORIZONTAL = "paddingHorizontal";
    public static final String PADDING_LEFT = "paddingLeft";
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};
    public static final String PADDING_RIGHT = "paddingRight";
    public static final String PADDING_START = "paddingStart";
    public static final String PADDING_TOP = "paddingTop";
    public static final String PADDING_VERTICAL = "paddingVertical";
    public static final String POINTER_EVENTS = "pointerEvents";
    public static final String POSITION = "position";
    public static final int[] POSITION_SPACING_TYPES = {4, 5, 1, 3};
    public static final String RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
    public static final String RESIZE_METHOD = "resizeMethod";
    public static final String RESIZE_MODE = "resizeMode";
    public static final String RIGHT = "right";
    public static final String ROTATION = "rotation";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String SCROLL = "scroll";
    public static final String SHADOW_COLOR = "shadowColor";
    public static final String START = "start";
    public static final String TEST_ID = "testID";
    public static final String TEXT_ALIGN = "textAlign";
    public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
    public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";
    public static final String TEXT_DECORATION_LINE = "textDecorationLine";
    public static final String TOP = "top";
    public static final String TRANSFORM = "transform";
    public static final String TRANSLATE_X = "translateX";
    public static final String TRANSLATE_Y = "translateY";
    public static final String VIEW_CLASS_NAME = "RCTView";
    public static final String VISIBLE = "visible";
    public static final String WIDTH = "width";
    public static final String Z_INDEX = "zIndex";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isLayoutOnly(com.facebook.react.bridge.ReadableMap r19, java.lang.String r20) {
        /*
            r0 = r19
            r1 = r20
            java.util.HashSet<java.lang.String> r2 = LAYOUT_ONLY_PROPS
            boolean r2 = r2.contains(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            return r3
        L_0x000e:
            java.lang.String r2 = "pointerEvents"
            boolean r2 = r2.equals(r1)
            r4 = 0
            if (r2 == 0) goto L_0x002e
            java.lang.String r0 = r19.getString(r20)
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "box-none"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            return r3
        L_0x002e:
            r20.hashCode()
            int r5 = r20.hashCode()
            java.lang.String r6 = "overflow"
            java.lang.String r7 = "borderLeftWidth"
            java.lang.String r8 = "borderLeftColor"
            java.lang.String r9 = "opacity"
            java.lang.String r10 = "borderBottomWidth"
            java.lang.String r11 = "borderBottomColor"
            java.lang.String r12 = "borderTopWidth"
            java.lang.String r13 = "borderTopColor"
            java.lang.String r14 = "borderRightWidth"
            java.lang.String r15 = "borderRightColor"
            java.lang.String r2 = "borderWidth"
            switch(r5) {
                case -1989576717: goto L_0x00d4;
                case -1971292586: goto L_0x00c9;
                case -1470826662: goto L_0x00be;
                case -1452542531: goto L_0x00b3;
                case -1308858324: goto L_0x00a8;
                case -1290574193: goto L_0x009d;
                case -1267206133: goto L_0x0092;
                case -242276144: goto L_0x0087;
                case -223992013: goto L_0x007b;
                case 529642498: goto L_0x006e;
                case 741115130: goto L_0x0061;
                case 1349188574: goto L_0x0052;
                default: goto L_0x004e;
            }
        L_0x004e:
            r16 = -1
            goto L_0x00de
        L_0x0052:
            java.lang.String r5 = "borderRadius"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x005b
            goto L_0x004e
        L_0x005b:
            r1 = 11
            r16 = 11
            goto L_0x00de
        L_0x0061:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0068
            goto L_0x004e
        L_0x0068:
            r1 = 10
            r16 = 10
            goto L_0x00de
        L_0x006e:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0075
            goto L_0x004e
        L_0x0075:
            r1 = 9
            r16 = 9
            goto L_0x00de
        L_0x007b:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0082
            goto L_0x004e
        L_0x0082:
            r1 = 8
            r16 = 8
            goto L_0x00de
        L_0x0087:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x008e
            goto L_0x004e
        L_0x008e:
            r1 = 7
            r16 = 7
            goto L_0x00de
        L_0x0092:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0099
            goto L_0x004e
        L_0x0099:
            r1 = 6
            r16 = 6
            goto L_0x00de
        L_0x009d:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x00a4
            goto L_0x004e
        L_0x00a4:
            r1 = 5
            r16 = 5
            goto L_0x00de
        L_0x00a8:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x00af
            goto L_0x004e
        L_0x00af:
            r1 = 4
            r16 = 4
            goto L_0x00de
        L_0x00b3:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00ba
            goto L_0x004e
        L_0x00ba:
            r1 = 3
            r16 = 3
            goto L_0x00de
        L_0x00be:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x00c5
            goto L_0x004e
        L_0x00c5:
            r1 = 2
            r16 = 2
            goto L_0x00de
        L_0x00c9:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00d1
            goto L_0x004e
        L_0x00d1:
            r16 = 1
            goto L_0x00de
        L_0x00d4:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x00dc
            goto L_0x004e
        L_0x00dc:
            r16 = 0
        L_0x00de:
            r17 = 0
            switch(r16) {
                case 0: goto L_0x01b3;
                case 1: goto L_0x01a2;
                case 2: goto L_0x0193;
                case 3: goto L_0x0182;
                case 4: goto L_0x0173;
                case 5: goto L_0x0162;
                case 6: goto L_0x014f;
                case 7: goto L_0x0140;
                case 8: goto L_0x012f;
                case 9: goto L_0x011a;
                case 10: goto L_0x0109;
                case 11: goto L_0x00e4;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            return r4
        L_0x00e4:
            java.lang.String r1 = "backgroundColor"
            boolean r5 = r0.hasKey(r1)
            if (r5 == 0) goto L_0x00f3
            int r1 = r0.getInt(r1)
            if (r1 == 0) goto L_0x00f3
            return r4
        L_0x00f3:
            boolean r1 = r0.hasKey(r2)
            if (r1 == 0) goto L_0x0108
            boolean r1 = r0.isNull(r2)
            if (r1 != 0) goto L_0x0108
            double r0 = r0.getDouble(r2)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x0108
            return r4
        L_0x0108:
            return r3
        L_0x0109:
            boolean r1 = r0.isNull(r2)
            if (r1 != 0) goto L_0x0119
            double r0 = r0.getDouble(r2)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x0118
            goto L_0x0119
        L_0x0118:
            r3 = 0
        L_0x0119:
            return r3
        L_0x011a:
            boolean r1 = r0.isNull(r6)
            if (r1 != 0) goto L_0x012e
            java.lang.String r0 = r0.getString(r6)
            java.lang.String r1 = "visible"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x012d
            goto L_0x012e
        L_0x012d:
            r3 = 0
        L_0x012e:
            return r3
        L_0x012f:
            boolean r1 = r0.isNull(r7)
            if (r1 != 0) goto L_0x013f
            double r0 = r0.getDouble(r7)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x013e
            goto L_0x013f
        L_0x013e:
            r3 = 0
        L_0x013f:
            return r3
        L_0x0140:
            boolean r1 = r0.isNull(r8)
            if (r1 != 0) goto L_0x014d
            int r0 = r0.getInt(r8)
            if (r0 != 0) goto L_0x014d
            goto L_0x014e
        L_0x014d:
            r3 = 0
        L_0x014e:
            return r3
        L_0x014f:
            boolean r1 = r0.isNull(r9)
            if (r1 != 0) goto L_0x0161
            double r0 = r0.getDouble(r9)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0160
            goto L_0x0161
        L_0x0160:
            r3 = 0
        L_0x0161:
            return r3
        L_0x0162:
            boolean r1 = r0.isNull(r10)
            if (r1 != 0) goto L_0x0172
            double r0 = r0.getDouble(r10)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x0171
            goto L_0x0172
        L_0x0171:
            r3 = 0
        L_0x0172:
            return r3
        L_0x0173:
            boolean r1 = r0.isNull(r11)
            if (r1 != 0) goto L_0x0180
            int r0 = r0.getInt(r11)
            if (r0 != 0) goto L_0x0180
            goto L_0x0181
        L_0x0180:
            r3 = 0
        L_0x0181:
            return r3
        L_0x0182:
            boolean r1 = r0.isNull(r12)
            if (r1 != 0) goto L_0x0192
            double r0 = r0.getDouble(r12)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x0191
            goto L_0x0192
        L_0x0191:
            r3 = 0
        L_0x0192:
            return r3
        L_0x0193:
            boolean r1 = r0.isNull(r13)
            if (r1 != 0) goto L_0x01a0
            int r0 = r0.getInt(r13)
            if (r0 != 0) goto L_0x01a0
            goto L_0x01a1
        L_0x01a0:
            r3 = 0
        L_0x01a1:
            return r3
        L_0x01a2:
            boolean r1 = r0.isNull(r14)
            if (r1 != 0) goto L_0x01b2
            double r0 = r0.getDouble(r14)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r3 = 0
        L_0x01b2:
            return r3
        L_0x01b3:
            boolean r1 = r0.isNull(r15)
            if (r1 != 0) goto L_0x01c0
            int r0 = r0.getInt(r15)
            if (r0 != 0) goto L_0x01c0
            goto L_0x01c1
        L_0x01c0:
            r3 = 0
        L_0x01c1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewProps.isLayoutOnly(com.facebook.react.bridge.ReadableMap, java.lang.String):boolean");
    }
}
