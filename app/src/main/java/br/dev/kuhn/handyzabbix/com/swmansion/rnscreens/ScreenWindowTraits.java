package com.swmansion.rnscreens;

import android.app.Activity;
import android.os.Build;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\nH\u0000¢\u0006\u0002\b\rJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J)\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0002\b\u001bJ\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u001dJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u001fJ)\u0010 \u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b!J)\u0010\"\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b#J)\u0010$\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b%R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenWindowTraits;", "", "()V", "mDefaultStatusBarColor", "", "Ljava/lang/Integer;", "mDidSetOrientation", "", "mDidSetStatusBarAppearance", "applyDidSetOrientation", "", "applyDidSetOrientation$react_native_screens_release", "applyDidSetStatusBarAppearance", "applyDidSetStatusBarAppearance$react_native_screens_release", "checkTraitForScreen", "screen", "Lcom/swmansion/rnscreens/Screen;", "trait", "Lcom/swmansion/rnscreens/Screen$WindowTraits;", "childScreenWithTraitSet", "findParentWithTraitSet", "findScreenForTrait", "setColor", "activity", "Landroid/app/Activity;", "context", "Lcom/facebook/react/bridge/ReactContext;", "setColor$react_native_screens_release", "setHidden", "setHidden$react_native_screens_release", "setOrientation", "setOrientation$react_native_screens_release", "setStyle", "setStyle$react_native_screens_release", "setTranslucent", "setTranslucent$react_native_screens_release", "trySetWindowTraits", "trySetWindowTraits$react_native_screens_release", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits {
    public static final ScreenWindowTraits INSTANCE = new ScreenWindowTraits();
    private static Integer mDefaultStatusBarColor;
    private static boolean mDidSetOrientation;
    private static boolean mDidSetStatusBarAppearance;

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.WindowTraits.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Screen.WindowTraits.ORIENTATION.ordinal()] = 1;
            iArr[Screen.WindowTraits.COLOR.ordinal()] = 2;
            iArr[Screen.WindowTraits.STYLE.ordinal()] = 3;
            iArr[Screen.WindowTraits.TRANSLUCENT.ordinal()] = 4;
            iArr[Screen.WindowTraits.HIDDEN.ordinal()] = 5;
            iArr[Screen.WindowTraits.ANIMATED.ordinal()] = 6;
        }
    }

    private ScreenWindowTraits() {
    }

    public final void applyDidSetOrientation$react_native_screens_release() {
        mDidSetOrientation = true;
    }

    public final void applyDidSetStatusBarAppearance$react_native_screens_release() {
        mDidSetStatusBarAppearance = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = r2.getScreenOrientation();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOrientation$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.ORIENTATION
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001b
            java.lang.Integer r2 = r2.getScreenOrientation()
            if (r2 == 0) goto L_0x001b
            int r2 = r2.intValue()
            goto L_0x001c
        L_0x001b:
            r2 = -1
        L_0x001c:
            r3.setRequestedOrientation(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setOrientation$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        r8 = r8.isStatusBarAnimated();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setColor$react_native_screens_release(com.swmansion.rnscreens.Screen r8, android.app.Activity r9, com.facebook.react.bridge.ReactContext r10) {
        /*
            r7 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 == 0) goto L_0x005d
            if (r10 == 0) goto L_0x005d
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0010
            goto L_0x005d
        L_0x0010:
            java.lang.Integer r0 = mDefaultStatusBarColor
            if (r0 != 0) goto L_0x0027
            android.view.Window r0 = r9.getWindow()
            java.lang.String r1 = "activity.window"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r0 = r0.getStatusBarColor()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            mDefaultStatusBarColor = r0
        L_0x0027:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.COLOR
            com.swmansion.rnscreens.Screen r0 = r7.findScreenForTrait(r8, r0)
            com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.ANIMATED
            com.swmansion.rnscreens.Screen r8 = r7.findScreenForTrait(r8, r1)
            if (r0 == 0) goto L_0x003c
            java.lang.Integer r0 = r0.getStatusBarColor()
            if (r0 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            java.lang.Integer r0 = mDefaultStatusBarColor
        L_0x003e:
            r3 = r0
            if (r8 == 0) goto L_0x004d
            java.lang.Boolean r8 = r8.isStatusBarAnimated()
            if (r8 == 0) goto L_0x004d
            boolean r8 = r8.booleanValue()
            r4 = r8
            goto L_0x004f
        L_0x004d:
            r8 = 0
            r4 = 0
        L_0x004f:
            com.swmansion.rnscreens.ScreenWindowTraits$setColor$1 r8 = new com.swmansion.rnscreens.ScreenWindowTraits$setColor$1
            r1 = r8
            r2 = r9
            r5 = r10
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Runnable r8 = (java.lang.Runnable) r8
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r8)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setColor$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity, com.facebook.react.bridge.ReactContext):void");
    }

    public final void setStyle$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        String str;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null && reactContext != null) {
            Screen findScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.STYLE);
            if (findScreenForTrait == null || (str = findScreenForTrait.getStatusBarStyle()) == null) {
                str = "light";
            }
            if (Build.VERSION.SDK_INT >= 23) {
                UiThreadUtil.runOnUiThread(new ScreenWindowTraits$setStyle$1(activity, str));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r2 = r2.isStatusBarTranslucent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3, com.facebook.react.bridge.ReactContext r4) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0028
            if (r4 != 0) goto L_0x000a
            goto L_0x0028
        L_0x000a:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.TRANSLUCENT
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001d
            java.lang.Boolean r2 = r2.isStatusBarTranslucent()
            if (r2 == 0) goto L_0x001d
            boolean r2 = r2.booleanValue()
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1 r0 = new com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1
            r0.<init>(r3, r2, r4, r4)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity, com.facebook.react.bridge.ReactContext):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = r2.isStatusBarHidden();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setHidden$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.HIDDEN
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001b
            java.lang.Boolean r2 = r2.isStatusBarHidden()
            if (r2 == 0) goto L_0x001b
            boolean r2 = r2.booleanValue()
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            com.swmansion.rnscreens.ScreenWindowTraits$setHidden$1 r0 = new com.swmansion.rnscreens.ScreenWindowTraits$setHidden$1
            r0.<init>(r2, r3)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setHidden$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    public final void trySetWindowTraits$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (mDidSetOrientation) {
            setOrientation$react_native_screens_release(screen, activity);
        }
        if (mDidSetStatusBarAppearance) {
            setColor$react_native_screens_release(screen, activity, reactContext);
            setStyle$react_native_screens_release(screen, activity, reactContext);
            setTranslucent$react_native_screens_release(screen, activity, reactContext);
            setHidden$react_native_screens_release(screen, activity);
        }
    }

    private final Screen findScreenForTrait(Screen screen, Screen.WindowTraits windowTraits) {
        Screen childScreenWithTraitSet = childScreenWithTraitSet(screen, windowTraits);
        if (childScreenWithTraitSet != null) {
            return childScreenWithTraitSet;
        }
        return checkTraitForScreen(screen, windowTraits) ? screen : findParentWithTraitSet(screen, windowTraits);
    }

    private final Screen findParentWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        for (ViewParent container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (checkTraitForScreen(screen2, windowTraits)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    private final Screen childScreenWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        ScreenFragment fragment;
        if (screen == null || (fragment = screen.getFragment()) == null) {
            return null;
        }
        for (ScreenContainer<?> topScreen : fragment.getChildScreenContainers()) {
            Screen topScreen2 = topScreen.getTopScreen();
            ScreenWindowTraits screenWindowTraits = INSTANCE;
            Screen childScreenWithTraitSet = screenWindowTraits.childScreenWithTraitSet(topScreen2, windowTraits);
            if (childScreenWithTraitSet != null) {
                return childScreenWithTraitSet;
            }
            if (topScreen2 != null && screenWindowTraits.checkTraitForScreen(topScreen2, windowTraits)) {
                return topScreen2;
            }
        }
        return null;
    }

    private final boolean checkTraitForScreen(Screen screen, Screen.WindowTraits windowTraits) {
        switch (WhenMappings.$EnumSwitchMapping$0[windowTraits.ordinal()]) {
            case 1:
                if (screen.getScreenOrientation() != null) {
                    return true;
                }
                break;
            case 2:
                if (screen.getStatusBarColor() != null) {
                    return true;
                }
                break;
            case 3:
                if (screen.getStatusBarStyle() != null) {
                    return true;
                }
                break;
            case 4:
                if (screen.isStatusBarTranslucent() != null) {
                    return true;
                }
                break;
            case 5:
                if (screen.isStatusBarHidden() != null) {
                    return true;
                }
                break;
            case 6:
                if (screen.isStatusBarAnimated() != null) {
                    return true;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return false;
    }
}
