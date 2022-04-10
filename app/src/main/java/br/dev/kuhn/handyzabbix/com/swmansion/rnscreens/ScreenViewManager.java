package com.swmansion.rnscreens;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\tH\u0007J\u001a\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0007J\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u001f\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\tH\u0007J\u001f\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010$¨\u0006*"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "()V", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setActivityState", "", "view", "activityState", "", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setGestureEnabled", "gestureEnabled", "", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setReplaceAnimation", "animation", "setScreenOrientation", "screenOrientation", "setStackAnimation", "setStackPresentation", "presentation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarColor", "statusBarColor", "setStatusBarHidden", "statusBarHidden", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Boolean;)V", "setStatusBarStyle", "statusBarStyle", "setStatusBarTranslucent", "statusBarTranslucent", "Companion", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
@ReactModule(name = "RNSScreen")
/* compiled from: ScreenViewManager.kt */
public final class ScreenViewManager extends ViewGroupManager<Screen> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreen";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new Screen(themedReactContext);
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        if (num != null) {
            if (num.intValue() == 0) {
                screen.setActivityState(Screen.ActivityState.INACTIVE);
            } else if (num.intValue() == 1) {
                screen.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
            } else if (num.intValue() == 2) {
                screen.setActivityState(Screen.ActivityState.ON_TOP);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r4.equals("modal") != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r4.equals("transparentModal") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r3.setStackPresentation(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown presentation type " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        if (r4.equals("formSheet") != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r4.equals("fullScreenModal") != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r4.equals("containedTransparentModal") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r4.equals("containedModal") != false) goto L_0x003e;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setStackPresentation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "presentation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.hashCode()
            switch(r0) {
                case -76271493: goto L_0x004c;
                case 3452698: goto L_0x0041;
                case 104069805: goto L_0x0036;
                case 438078970: goto L_0x002d;
                case 955284238: goto L_0x0024;
                case 1171936146: goto L_0x001b;
                case 1798290171: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x005a
        L_0x0012:
            java.lang.String r0 = "formSheet"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            goto L_0x003e
        L_0x001b:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            goto L_0x003e
        L_0x0024:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            goto L_0x0054
        L_0x002d:
            java.lang.String r0 = "containedModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            goto L_0x003e
        L_0x0036:
            java.lang.String r0 = "modal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
        L_0x003e:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L_0x0056
        L_0x0041:
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L_0x0056
        L_0x004c:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
        L_0x0054:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L_0x0056:
            r3.setStackPresentation(r4)
            return
        L_0x005a:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown presentation type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r4.equals("flip") != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r4.equals("simple_push") != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown animation type " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r4.equals("default") != false) goto L_0x006d;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setStackAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0009
            goto L_0x006d
        L_0x0009:
            int r0 = r4.hashCode()
            switch(r0) {
                case -1418955385: goto L_0x0065;
                case -427095442: goto L_0x005a;
                case -349395819: goto L_0x004f;
                case 3135100: goto L_0x0044;
                case 3145837: goto L_0x003b;
                case 3387192: goto L_0x0030;
                case 182437661: goto L_0x0025;
                case 1544803905: goto L_0x001c;
                case 1601504978: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0073
        L_0x0011:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_BOTTOM
            goto L_0x006f
        L_0x001c:
            java.lang.String r0 = "default"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            goto L_0x006d
        L_0x0025:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE_FROM_BOTTOM
            goto L_0x006f
        L_0x0030:
            java.lang.String r0 = "none"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            goto L_0x006f
        L_0x003b:
            java.lang.String r0 = "flip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            goto L_0x006d
        L_0x0044:
            java.lang.String r0 = "fade"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE
            goto L_0x006f
        L_0x004f:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_RIGHT
            goto L_0x006f
        L_0x005a:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_LEFT
            goto L_0x006f
        L_0x0065:
            java.lang.String r0 = "simple_push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
        L_0x006d:
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.DEFAULT
        L_0x006f:
            r3.setStackAnimation(r4)
            return
        L_0x0073:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown animation type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public final void setGestureEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setGestureEnabled(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r4.equals("pop") != false) goto L_0x0029;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "replaceAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setReplaceAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            int r0 = r4.hashCode()
            r1 = 111185(0x1b251, float:1.55803E-40)
            if (r0 == r1) goto L_0x0021
            r1 = 3452698(0x34af1a, float:4.83826E-39)
            if (r0 != r1) goto L_0x002f
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x002f
            com.swmansion.rnscreens.Screen$ReplaceAnimation r4 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            goto L_0x002b
        L_0x0021:
            java.lang.String r0 = "pop"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x002f
        L_0x0029:
            com.swmansion.rnscreens.Screen$ReplaceAnimation r4 = com.swmansion.rnscreens.Screen.ReplaceAnimation.POP
        L_0x002b:
            r3.setReplaceAnimation(r4)
            return
        L_0x002f:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown replace animation type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setReplaceAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(name = "screenOrientation")
    public final void setScreenOrientation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setScreenOrientation(str);
    }

    @ReactProp(name = "statusBarAnimation")
    public final void setStatusBarAnimation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        boolean z = true;
        if (str == null || !(!Intrinsics.areEqual((Object) "none", (Object) str))) {
            z = false;
        }
        screen.setStatusBarAnimated(Boolean.valueOf(z));
    }

    @ReactProp(name = "statusBarColor")
    public final void setStatusBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarColor(num);
    }

    @ReactProp(name = "statusBarStyle")
    public final void setStatusBarStyle(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarStyle(str);
    }

    @ReactProp(name = "statusBarTranslucent")
    public final void setStatusBarTranslucent(Screen screen, Boolean bool) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarTranslucent(bool);
    }

    @ReactProp(name = "statusBarHidden")
    public final void setStatusBarHidden(Screen screen, Boolean bool) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarHidden(bool);
    }

    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public final void setNativeBackButtonDismissalEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNativeBackButtonDismissalEnabled(z);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.m129of(ScreenDismissedEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onDismissed"), ScreenWillAppearEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onWillAppear"), ScreenAppearEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onAppear"), ScreenWillDisappearEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onWillDisappear"), ScreenDisappearEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onDisappear"), StackFinishTransitioningEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onFinishTransitioning"), ScreenTransitionProgressEvent.EVENT_NAME, MapBuilder.m123of("registrationName", "onTransitionProgress"));
        Intrinsics.checkNotNullExpressionValue(of, "MapBuilder.of(\n         …itionProgress\")\n        )");
        Map of2 = MapBuilder.m123of("registrationName", "onHeaderBackButtonClicked");
        Intrinsics.checkNotNullExpressionValue(of2, "MapBuilder.of(\"registrat…HeaderBackButtonClicked\")");
        of.put(HeaderBackButtonClickedEvent.EVENT_NAME, of2);
        return of;
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenViewManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
