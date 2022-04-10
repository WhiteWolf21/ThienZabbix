package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ABB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J \u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020$H\u0014J\f\u00105\u001a\u00060\bR\u00020\u0000H\u0002J\b\u00106\u001a\u00020$H\u0016J\u0006\u00107\u001a\u00020$J\u0014\u00108\u001a\u00020$2\n\u00109\u001a\u00060\bR\u00020\u0000H\u0002J\b\u0010:\u001a\u00020$H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0002R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0015j\b\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006C"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "goingForward", "", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "isDetachingCurrentScreen", "mDismissed", "", "mRemovalTransitionStarted", "mStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTopScreen", "previousChildrenCount", "", "reverseLastTwoChildren", "rootScreen", "Lcom/swmansion/rnscreens/Screen;", "getRootScreen", "()Lcom/swmansion/rnscreens/Screen;", "topScreen", "getTopScreen", "adapt", "screen", "dismiss", "", "screenFragment", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchOnFinishTransitioning", "drawAndRelease", "drawChild", "child", "Landroid/view/View;", "drawingTime", "", "endViewTransition", "view", "hasScreen", "Lcom/swmansion/rnscreens/ScreenFragment;", "notifyContainerUpdate", "obtainDrawingOp", "onUpdate", "onViewAppearTransitionEnd", "performDraw", "op", "removeAllScreens", "removeScreenAt", "index", "removeView", "startViewTransition", "turnOffA11yUnderTransparentScreen", "visibleBottom", "Companion", "DrawingOp", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: ScreenStack.kt */
public final class ScreenStack extends ScreenContainer<ScreenStackFragment> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<DrawingOp> drawingOpPool = new ArrayList();
    private final List<DrawingOp> drawingOps = new ArrayList();
    private boolean goingForward;
    private boolean isDetachingCurrentScreen;
    private final Set<ScreenStackFragment> mDismissed = new HashSet();
    private boolean mRemovalTransitionStarted;
    private final ArrayList<ScreenStackFragment> mStack = new ArrayList<>();
    private ScreenStackFragment mTopScreen;
    private int previousChildrenCount;
    private boolean reverseLastTwoChildren;

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 1;
            iArr[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 2;
            iArr[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 3;
            iArr[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 4;
            int[] iArr2 = new int[Screen.StackAnimation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 1;
            iArr2[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 2;
            iArr2[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 3;
            iArr2[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 4;
        }
    }

    public ScreenStack(Context context) {
        super(context);
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(ScreenStackFragment screenStackFragment) {
        Intrinsics.checkNotNullParameter(screenStackFragment, "screenFragment");
        this.mDismissed.add(screenStackFragment);
        performUpdatesNow();
    }

    public Screen getTopScreen() {
        ScreenStackFragment screenStackFragment = this.mTopScreen;
        if (screenStackFragment != null) {
            return screenStackFragment.getScreen();
        }
        return null;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            Screen screenAt = getScreenAt(i);
            if (!CollectionsKt.contains(this.mDismissed, screenAt.getFragment())) {
                return screenAt;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* access modifiers changed from: protected */
    public ScreenStackFragment adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.startViewTransition(view);
        this.mRemovalTransitionStarted = true;
    }

    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        if (this.mRemovalTransitionStarted) {
            this.mRemovalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (!this.mRemovalTransitionStarted) {
            dispatchOnFinishTransitioning();
        }
    }

    private final void dispatchOnFinishTransitioning() {
        EventDispatcher eventDispatcher;
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null && (eventDispatcher = uIManagerModule.getEventDispatcher()) != null) {
            eventDispatcher.dispatchEvent(new StackFinishTransitioningEvent(getId()));
        }
    }

    public void removeScreenAt(int i) {
        Screen screenAt = getScreenAt(i);
        Collection collection = this.mDismissed;
        ScreenFragment fragment = screenAt.getFragment();
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(collection).remove(fragment);
        super.removeScreenAt(i);
    }

    public void removeAllScreens() {
        this.mDismissed.clear();
        super.removeAllScreens();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return super.hasScreen(screenFragment) && !CollectionsKt.contains(this.mDismissed, screenFragment);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01dc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpdate() {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = r1
            com.swmansion.rnscreens.ScreenStackFragment r2 = (com.swmansion.rnscreens.ScreenStackFragment) r2
            r3 = 0
            r0.isDetachingCurrentScreen = r3
            java.util.ArrayList r4 = r0.mScreenFragments
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            int r4 = r4 + -1
            r5 = r4
            r4 = r2
        L_0x0015:
            if (r5 < 0) goto L_0x003d
            java.util.ArrayList r6 = r0.mScreenFragments
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r7 = "mScreenFragments[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.swmansion.rnscreens.ScreenStackFragment r6 = (com.swmansion.rnscreens.ScreenStackFragment) r6
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r0.mDismissed
            boolean r7 = r7.contains(r6)
            if (r7 != 0) goto L_0x003a
            if (r2 != 0) goto L_0x0030
            r2 = r6
            goto L_0x0031
        L_0x0030:
            r4 = r6
        L_0x0031:
            com.swmansion.rnscreens.ScreenStack$Companion r7 = Companion
            boolean r6 = r7.isTransparent(r6)
            if (r6 != 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r5 = r5 + -1
            goto L_0x0015
        L_0x003d:
            r5 = r1
            com.swmansion.rnscreens.Screen$StackAnimation r5 = (com.swmansion.rnscreens.Screen.StackAnimation) r5
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r6 = r0.mStack
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r6 = kotlin.collections.CollectionsKt.contains(r6, r2)
            r7 = 1
            if (r6 != 0) goto L_0x00b5
            com.swmansion.rnscreens.ScreenStackFragment r6 = r0.mTopScreen
            if (r6 == 0) goto L_0x0094
            if (r2 == 0) goto L_0x0094
            if (r6 == 0) goto L_0x005d
            java.util.ArrayList r5 = r0.mScreenFragments
            boolean r5 = r5.contains(r6)
            if (r5 != r7) goto L_0x005d
            r5 = 1
            goto L_0x005e
        L_0x005d:
            r5 = 0
        L_0x005e:
            com.swmansion.rnscreens.Screen r6 = r2.getScreen()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r6 = r6.getReplaceAnimation()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r8 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            if (r6 != r8) goto L_0x006c
            r6 = 1
            goto L_0x006d
        L_0x006c:
            r6 = 0
        L_0x006d:
            if (r5 != 0) goto L_0x0074
            if (r6 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r5 = 0
            goto L_0x0075
        L_0x0074:
            r5 = 1
        L_0x0075:
            if (r5 == 0) goto L_0x0080
            com.swmansion.rnscreens.Screen r1 = r2.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            goto L_0x008e
        L_0x0080:
            com.swmansion.rnscreens.ScreenStackFragment r6 = r0.mTopScreen
            if (r6 == 0) goto L_0x008e
            com.swmansion.rnscreens.Screen r6 = r6.getScreen()
            if (r6 == 0) goto L_0x008e
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r6.getStackAnimation()
        L_0x008e:
            r17 = r5
            r5 = r1
            r1 = r17
            goto L_0x00d2
        L_0x0094:
            if (r6 != 0) goto L_0x00d1
            if (r2 == 0) goto L_0x00d1
            com.swmansion.rnscreens.Screen$StackAnimation r5 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            com.swmansion.rnscreens.Screen r1 = r2.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            com.swmansion.rnscreens.Screen$StackAnimation r6 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            if (r1 == r6) goto L_0x00d1
            boolean r1 = r18.isNested()
            if (r1 != 0) goto L_0x00d1
            r0.goingForward = r7
            r2.dispatchOnWillAppear()
            r2.dispatchOnAppear()
            goto L_0x00d1
        L_0x00b5:
            com.swmansion.rnscreens.ScreenStackFragment r6 = r0.mTopScreen
            if (r6 == 0) goto L_0x00d1
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x00d1
            com.swmansion.rnscreens.ScreenStackFragment r5 = r0.mTopScreen
            if (r5 == 0) goto L_0x00ce
            com.swmansion.rnscreens.Screen r5 = r5.getScreen()
            if (r5 == 0) goto L_0x00ce
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r5.getStackAnimation()
        L_0x00ce:
            r5 = r1
            r1 = 0
            goto L_0x00d2
        L_0x00d1:
            r1 = 1
        L_0x00d2:
            androidx.fragment.app.FragmentTransaction r6 = r18.createTransaction()
            r8 = 4097(0x1001, float:5.741E-42)
            if (r5 == 0) goto L_0x0175
            java.lang.String r9 = "it.setCustomAnimations(\n…                        )"
            java.lang.String r10 = "it.setCustomAnimations(R…im.rns_slide_out_to_left)"
            java.lang.String r11 = "it.setCustomAnimations(R…m.rns_slide_out_to_right)"
            r12 = 4
            r13 = 3
            r14 = 2
            if (r1 == 0) goto L_0x012e
            if (r5 != 0) goto L_0x00e9
            goto L_0x0175
        L_0x00e9:
            int[] r15 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$0
            int r16 = r5.ordinal()
            r15 = r15[r16]
            if (r15 == r7) goto L_0x0122
            if (r15 == r14) goto L_0x0116
            if (r15 == r13) goto L_0x010a
            if (r15 == r12) goto L_0x00fb
            goto L_0x0175
        L_0x00fb:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_fade_from_bottom
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_no_animation_350
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r10)
            java.lang.String r10 = "it.setCustomAnimations(R…nim.rns_no_animation_350)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            goto L_0x0175
        L_0x010a:
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_slide_in_from_bottom
            int r11 = com.swmansion.rnscreens.C1661R.anim.rns_no_animation_medium
            androidx.fragment.app.FragmentTransaction r10 = r6.setCustomAnimations(r10, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            goto L_0x0175
        L_0x0116:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_slide_in_from_left
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_slide_out_to_right
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            goto L_0x0175
        L_0x0122:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_slide_in_from_right
            int r11 = com.swmansion.rnscreens.C1661R.anim.rns_slide_out_to_left
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            goto L_0x0175
        L_0x012e:
            r8 = 8194(0x2002, float:1.1482E-41)
            if (r5 != 0) goto L_0x0133
            goto L_0x0175
        L_0x0133:
            int[] r15 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$1
            int r16 = r5.ordinal()
            r15 = r15[r16]
            if (r15 == r7) goto L_0x016a
            if (r15 == r14) goto L_0x015e
            if (r15 == r13) goto L_0x0152
            if (r15 == r12) goto L_0x0144
            goto L_0x0175
        L_0x0144:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_no_animation_250
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_fade_to_bottom
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r10)
            java.lang.String r10 = "it.setCustomAnimations(R….anim.rns_fade_to_bottom)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            goto L_0x0175
        L_0x0152:
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_no_animation_medium
            int r11 = com.swmansion.rnscreens.C1661R.anim.rns_slide_out_to_bottom
            androidx.fragment.app.FragmentTransaction r10 = r6.setCustomAnimations(r10, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            goto L_0x0175
        L_0x015e:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_slide_in_from_right
            int r11 = com.swmansion.rnscreens.C1661R.anim.rns_slide_out_to_left
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            goto L_0x0175
        L_0x016a:
            int r9 = com.swmansion.rnscreens.C1661R.anim.rns_slide_in_from_left
            int r10 = com.swmansion.rnscreens.C1661R.anim.rns_slide_out_to_right
            androidx.fragment.app.FragmentTransaction r9 = r6.setCustomAnimations(r9, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
        L_0x0175:
            com.swmansion.rnscreens.Screen$StackAnimation r9 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            if (r5 != r9) goto L_0x017a
            r8 = 0
        L_0x017a:
            com.swmansion.rnscreens.Screen$StackAnimation r9 = com.swmansion.rnscreens.Screen.StackAnimation.FADE
            if (r5 != r9) goto L_0x0180
            r8 = 4099(0x1003, float:5.744E-42)
        L_0x0180:
            if (r5 == 0) goto L_0x018d
            com.swmansion.rnscreens.ScreenStack$Companion r9 = Companion
            boolean r5 = r9.isSystemAnimation(r5)
            if (r5 == 0) goto L_0x018d
            r6.setTransition(r8)
        L_0x018d:
            r0.goingForward = r1
            if (r1 == 0) goto L_0x019f
            if (r2 == 0) goto L_0x019f
            com.swmansion.rnscreens.ScreenStack$Companion r1 = Companion
            boolean r1 = r1.needsDrawReordering(r2)
            if (r1 == 0) goto L_0x019f
            if (r4 != 0) goto L_0x019f
            r0.isDetachingCurrentScreen = r7
        L_0x019f:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r0.mStack
            java.util.Iterator r1 = r1.iterator()
        L_0x01a5:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01c7
            java.lang.Object r5 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r5 = (com.swmansion.rnscreens.ScreenStackFragment) r5
            java.util.ArrayList r8 = r0.mScreenFragments
            boolean r8 = r8.contains(r5)
            if (r8 == 0) goto L_0x01c1
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r8 = r0.mDismissed
            boolean r8 = r8.contains(r5)
            if (r8 == 0) goto L_0x01a5
        L_0x01c1:
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            r6.remove(r5)
            goto L_0x01a5
        L_0x01c7:
            java.util.ArrayList r1 = r0.mScreenFragments
            java.util.Iterator r1 = r1.iterator()
        L_0x01cd:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01ec
            java.lang.Object r5 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r5 = (com.swmansion.rnscreens.ScreenStackFragment) r5
            if (r5 != r4) goto L_0x01dc
            goto L_0x01ec
        L_0x01dc:
            if (r5 == r2) goto L_0x01cd
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r8 = r0.mDismissed
            boolean r8 = r8.contains(r5)
            if (r8 != 0) goto L_0x01cd
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            r6.remove(r5)
            goto L_0x01cd
        L_0x01ec:
            if (r4 == 0) goto L_0x0220
            boolean r1 = r4.isAdded()
            if (r1 != 0) goto L_0x0220
            java.util.ArrayList r1 = r0.mScreenFragments
            java.util.Iterator r1 = r1.iterator()
        L_0x01fa:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0232
            java.lang.Object r5 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r5 = (com.swmansion.rnscreens.ScreenStackFragment) r5
            if (r7 == 0) goto L_0x020b
            if (r5 != r4) goto L_0x01fa
            r7 = 0
        L_0x020b:
            int r8 = r18.getId()
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            androidx.fragment.app.FragmentTransaction r5 = r6.add((int) r8, (androidx.fragment.app.Fragment) r5)
            com.swmansion.rnscreens.ScreenStack$onUpdate$1$1 r8 = new com.swmansion.rnscreens.ScreenStack$onUpdate$1$1
            r8.<init>(r2)
            java.lang.Runnable r8 = (java.lang.Runnable) r8
            r5.runOnCommit(r8)
            goto L_0x01fa
        L_0x0220:
            if (r2 == 0) goto L_0x0232
            boolean r1 = r2.isAdded()
            if (r1 != 0) goto L_0x0232
            int r1 = r18.getId()
            r3 = r2
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r6.add((int) r1, (androidx.fragment.app.Fragment) r3)
        L_0x0232:
            r0.mTopScreen = r2
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r0.mStack
            r1.clear()
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r0.mStack
            java.util.ArrayList r2 = r0.mScreenFragments
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            r0.turnOffA11yUnderTransparentScreen(r4)
            r6.commitNowAllowingStateLoss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.onUpdate():void");
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenStackFragment screenStackFragment) {
        ScreenStackFragment screenStackFragment2;
        if (this.mScreenFragments.size() > 1 && screenStackFragment != null && (screenStackFragment2 = this.mTopScreen) != null && Companion.isTransparent(screenStackFragment2)) {
            for (ScreenStackFragment screenStackFragment3 : CollectionsKt.asReversed(CollectionsKt.slice(this.mScreenFragments, RangesKt.until(0, this.mScreenFragments.size() - 1)))) {
                screenStackFragment3.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual((Object) screenStackFragment3, (Object) screenStackFragment)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyContainerUpdate() {
        Iterator<ScreenStackFragment> it = this.mStack.iterator();
        while (it.hasNext()) {
            it.next().onContainerUpdate();
        }
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isDetachingCurrentScreen) {
            this.isDetachingCurrentScreen = false;
            this.reverseLastTwoChildren = true;
        }
        super.removeView(view);
    }

    private final void drawAndRelease() {
        int size = this.drawingOps.size();
        for (int i = 0; i < size; i++) {
            DrawingOp drawingOp = this.drawingOps.get(i);
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
        this.drawingOps.clear();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.drawingOps.size() < this.previousChildrenCount) {
            this.reverseLastTwoChildren = false;
        }
        this.previousChildrenCount = this.drawingOps.size();
        if (this.reverseLastTwoChildren && this.drawingOps.size() >= 2) {
            List<DrawingOp> list = this.drawingOps;
            Collections.swap(list, list.size() - 1, this.drawingOps.size() - 2);
        }
        drawAndRelease();
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        this.drawingOps.add(obtainDrawingOp().set(canvas, view, j));
        return true;
    }

    /* access modifiers changed from: private */
    public final void performDraw(DrawingOp drawingOp) {
        super.drawChild(drawingOp.getCanvas(), drawingOp.getChild(), drawingOp.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List<DrawingOp> list = this.drawingOpPool;
        return list.remove(list.size() - 1);
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J)\u0010\u0017\u001a\u00060\u0000R\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "set", "Lcom/swmansion/rnscreens/ScreenStack;", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenStack.kt */
    private final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas2) {
            this.canvas = canvas2;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final DrawingOp set(Canvas canvas2, View view, long j) {
            this.canvas = canvas2;
            this.child = view;
            this.drawingTime = j;
            return this;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "()V", "isSystemAnimation", "", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "isTransparent", "fragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "needsDrawReordering", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenStack.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isSystemAnimation(Screen.StackAnimation stackAnimation) {
            return stackAnimation == Screen.StackAnimation.DEFAULT || stackAnimation == Screen.StackAnimation.FADE || stackAnimation == Screen.StackAnimation.NONE;
        }

        /* access modifiers changed from: private */
        public final boolean isTransparent(ScreenStackFragment screenStackFragment) {
            return screenStackFragment.getScreen().getStackPresentation() == Screen.StackPresentation.TRANSPARENT_MODAL;
        }

        /* access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenStackFragment screenStackFragment) {
            return screenStackFragment.getScreen().getStackAnimation() == Screen.StackAnimation.SLIDE_FROM_BOTTOM || screenStackFragment.getScreen().getStackAnimation() == Screen.StackAnimation.FADE_FROM_BOTTOM;
        }
    }
}
