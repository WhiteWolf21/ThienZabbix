package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 92\u00020\u0001:\u00039:;B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0004J\u0006\u0010\u001f\u001a\u00020\u0017J\b\u0010 \u001a\u00020\u0017H\u0004J\u0016\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0015J\b\u0010$\u001a\u00020\u0017H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\u0006\u00100\u001a\u00020\u0017J\u0012\u00101\u001a\u00020\u00172\n\u00102\u001a\u0006\u0012\u0002\b\u00030\bJ\b\u00103\u001a\u0004\u0018\u000104J\b\u00105\u001a\u0004\u0018\u000106J\u0012\u00107\u001a\u00020\u00172\n\u00102\u001a\u0006\u0012\u0002\b\u00030\bJ\b\u00108\u001a\u00020\u0017H\u0002R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u00020\u0004X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenFragment;", "Landroidx/fragment/app/Fragment;", "()V", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", "mChildScreenContainers", "", "mProgress", "", "screen", "getScreen$annotations", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "shouldUpdateOnResume", "", "dispatchEvent", "", "event", "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "fragment", "dispatchEventInChildContainers", "dispatchHeaderBackButtonClickedEvent", "dispatchOnAppear", "dispatchOnDisappear", "dispatchOnWillAppear", "dispatchOnWillDisappear", "dispatchTransitionProgress", "alpha", "closing", "onContainerUpdate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewAnimationEnd", "onViewAnimationStart", "registerChildScreenContainer", "screenContainer", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "unregisterChildScreenContainer", "updateWindowTraits", "Companion", "ScreenLifecycleEvent", "ScreensFrameLayout", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
/* compiled from: ScreenFragment.kt */
public class ScreenFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<ScreenContainer<?>> mChildScreenContainers = new ArrayList();
    private float mProgress = -1.0f;
    public Screen screen;
    private boolean shouldUpdateOnResume;

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "", "(Ljava/lang/String;I)V", "Appear", "WillAppear", "Disappear", "WillDisappear", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenFragment.kt */
    public enum ScreenLifecycleEvent {
        Appear,
        WillAppear,
        Disappear,
        WillDisappear
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenLifecycleEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ScreenLifecycleEvent.WillAppear.ordinal()] = 1;
            iArr[ScreenLifecycleEvent.Appear.ordinal()] = 2;
            iArr[ScreenLifecycleEvent.WillDisappear.ordinal()] = 3;
            iArr[ScreenLifecycleEvent.Disappear.ordinal()] = 4;
        }
    }

    public static /* synthetic */ void getScreen$annotations() {
    }

    @JvmStatic
    protected static final View recycleView(View view) {
        return Companion.recycleView(view);
    }

    public final Screen getScreen() {
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        return screen2;
    }

    public final void setScreen(Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "<set-?>");
        this.screen = screen2;
    }

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public ScreenFragment(Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "screenView");
        this.screen = screen2;
    }

    public void onResume() {
        super.onResume();
        if (this.shouldUpdateOnResume) {
            this.shouldUpdateOnResume = false;
            ScreenWindowTraits screenWindowTraits = ScreenWindowTraits.INSTANCE;
            Screen screen2 = this.screen;
            if (screen2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            screenWindowTraits.trySetWindowTraits$react_native_screens_release(screen2, tryGetActivity(), tryGetContext());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScreensFrameLayout screensFrameLayout;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            screensFrameLayout = new ScreensFrameLayout(context);
        } else {
            screensFrameLayout = null;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        screen2.setLayoutParams(layoutParams);
        if (screensFrameLayout != null) {
            Companion companion = Companion;
            Screen screen3 = this.screen;
            if (screen3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            screensFrameLayout.addView(companion.recycleView(screen3));
        }
        return screensFrameLayout;
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreensFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearFocus", "", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenFragment.kt */
    private static final class ScreensFrameLayout extends FrameLayout {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensFrameLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    public void onContainerUpdate() {
        updateWindowTraits();
    }

    private final void updateWindowTraits() {
        Activity activity = getActivity();
        if (activity == null) {
            this.shouldUpdateOnResume = true;
            return;
        }
        ScreenWindowTraits screenWindowTraits = ScreenWindowTraits.INSTANCE;
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        screenWindowTraits.trySetWindowTraits$react_native_screens_release(screen2, activity, tryGetContext());
    }

    public final Activity tryGetActivity() {
        ScreenFragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        Context context = screen2.getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        Screen screen3 = this.screen;
        if (screen3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        for (ViewParent container = screen3.getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    public final ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        }
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        if (screen2.getContext() instanceof ReactContext) {
            Screen screen3 = this.screen;
            if (screen3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            Context context2 = screen3.getContext();
            Objects.requireNonNull(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        }
        Screen screen4 = this.screen;
        if (screen4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        for (ViewParent container = screen4.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen5 = (Screen) container;
                if (screen5.getContext() instanceof ReactContext) {
                    Context context3 = screen5.getContext();
                    Objects.requireNonNull(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    return (ReactContext) context3;
                }
            }
        }
        return null;
    }

    public final List<ScreenContainer<?>> getChildScreenContainers() {
        return this.mChildScreenContainers;
    }

    public final void dispatchOnWillAppear() {
        dispatchEvent(ScreenLifecycleEvent.WillAppear, this);
        dispatchTransitionProgress(0.0f, false);
    }

    public final void dispatchOnAppear() {
        dispatchEvent(ScreenLifecycleEvent.Appear, this);
        dispatchTransitionProgress(1.0f, false);
    }

    /* access modifiers changed from: protected */
    public final void dispatchOnWillDisappear() {
        dispatchEvent(ScreenLifecycleEvent.WillDisappear, this);
        dispatchTransitionProgress(0.0f, true);
    }

    /* access modifiers changed from: protected */
    public final void dispatchOnDisappear() {
        dispatchEvent(ScreenLifecycleEvent.Disappear, this);
        dispatchTransitionProgress(1.0f, true);
    }

    private final void dispatchEvent(ScreenLifecycleEvent screenLifecycleEvent, ScreenFragment screenFragment) {
        Event event;
        EventDispatcher eventDispatcher;
        if (screenFragment instanceof ScreenStackFragment) {
            Screen screen2 = screenFragment.screen;
            if (screen2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            int i = WhenMappings.$EnumSwitchMapping$0[screenLifecycleEvent.ordinal()];
            if (i == 1) {
                event = new ScreenWillAppearEvent(screen2.getId());
            } else if (i == 2) {
                event = new ScreenAppearEvent(screen2.getId());
            } else if (i == 3) {
                event = new ScreenWillDisappearEvent(screen2.getId());
            } else if (i == 4) {
                event = new ScreenDisappearEvent(screen2.getId());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Context context = screen2.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
            if (!(uIManagerModule == null || (eventDispatcher = uIManagerModule.getEventDispatcher()) == null)) {
                eventDispatcher.dispatchEvent(event);
            }
            screenFragment.dispatchEventInChildContainers(screenLifecycleEvent);
        }
    }

    private final void dispatchEventInChildContainers(ScreenLifecycleEvent screenLifecycleEvent) {
        Screen topScreen;
        Screen topScreen2;
        ScreenFragment fragment;
        for (ScreenContainer next : this.mChildScreenContainers) {
            if (next.getScreenCount() > 0 && (topScreen = next.getTopScreen()) != null) {
                if (!((topScreen.getStackAnimation() == Screen.StackAnimation.NONE && !isRemoving()) || (topScreen2 = next.getTopScreen()) == null || (fragment = topScreen2.getFragment()) == null)) {
                    dispatchEvent(screenLifecycleEvent, fragment);
                }
            }
        }
    }

    public final void dispatchHeaderBackButtonClickedEvent() {
        EventDispatcher eventDispatcher;
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        Context context = screen2.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null && (eventDispatcher = uIManagerModule.getEventDispatcher()) != null) {
            Screen screen3 = this.screen;
            if (screen3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            eventDispatcher.dispatchEvent(new HeaderBackButtonClickedEvent(screen3.getId()));
        }
    }

    public final void dispatchTransitionProgress(float f, boolean z) {
        EventDispatcher eventDispatcher;
        if ((this instanceof ScreenStackFragment) && this.mProgress != f) {
            float max = Math.max(0.0f, Math.min(1.0f, f));
            this.mProgress = max;
            short s = (short) (max == 0.0f ? 1 : max == 1.0f ? 2 : 3);
            Screen screen2 = this.screen;
            if (screen2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            ScreenContainer<?> container = screen2.getContainer();
            boolean goingForward = container instanceof ScreenStack ? ((ScreenStack) container).getGoingForward() : false;
            Screen screen3 = this.screen;
            if (screen3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            Context context = screen3.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null && (eventDispatcher = uIManagerModule.getEventDispatcher()) != null) {
                Screen screen4 = this.screen;
                if (screen4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screen");
                }
                eventDispatcher.dispatchEvent(new ScreenTransitionProgressEvent(screen4.getId(), this.mProgress, z, goingForward, s));
            }
        }
    }

    public final void registerChildScreenContainer(ScreenContainer<?> screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "screenContainer");
        this.mChildScreenContainers.add(screenContainer);
    }

    public final void unregisterChildScreenContainer(ScreenContainer<?> screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "screenContainer");
        this.mChildScreenContainers.remove(screenContainer);
    }

    public final void onViewAnimationStart() {
        if (isResumed()) {
            UiThreadUtil.runOnUiThread(new ScreenFragment$onViewAnimationStart$1(this));
        } else {
            dispatchOnWillDisappear();
        }
    }

    public void onViewAnimationEnd() {
        if (isResumed()) {
            UiThreadUtil.runOnUiThread(new ScreenFragment$onViewAnimationEnd$1(this));
        } else {
            dispatchOnDisappear();
        }
    }

    public void onDestroy() {
        EventDispatcher eventDispatcher;
        super.onDestroy();
        Screen screen2 = this.screen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        ScreenContainer<?> container = screen2.getContainer();
        if (container == null || !container.hasScreen(this)) {
            Screen screen3 = this.screen;
            if (screen3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screen");
            }
            if (screen3.getContext() instanceof ReactContext) {
                Screen screen4 = this.screen;
                if (screen4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screen");
                }
                Context context = screen4.getContext();
                Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
                if (!(uIManagerModule == null || (eventDispatcher = uIManagerModule.getEventDispatcher()) == null)) {
                    Screen screen5 = this.screen;
                    if (screen5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("screen");
                    }
                    eventDispatcher.dispatchEvent(new ScreenDismissedEvent(screen5.getId()));
                }
            }
        }
        this.mChildScreenContainers.clear();
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0005¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$Companion;", "", "()V", "recycleView", "Landroid/view/View;", "view", "react-native-screens_release"}, mo24975k = 1, mo24976mv = {1, 4, 0})
    /* compiled from: ScreenFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: protected */
        @JvmStatic
        public final View recycleView(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.endViewTransition(view);
                viewGroup.removeView(view);
            }
            view.setVisibility(0);
            return view;
        }
    }
}
