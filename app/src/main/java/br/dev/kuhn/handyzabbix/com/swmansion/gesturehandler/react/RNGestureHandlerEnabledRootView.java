package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerEnabledRootView;", "Lcom/facebook/react/ReactRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "gestureRootHelper", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initialize", "", "requestDisallowInterceptTouchEvent", "disallowIntercept", "startReactApplication", "reactInstanceManager", "moduleName", "", "initialProperties", "Landroid/os/Bundle;", "tearDown", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
@Deprecated(message = "Use <GestureHandlerRootView /> component instead. Check gesture handler installation instructions in documentation for more information.")
/* compiled from: RNGestureHandlerEnabledRootView.kt */
public final class RNGestureHandlerEnabledRootView extends ReactRootView {
    private ReactInstanceManager _reactInstanceManager;
    private RNGestureHandlerRootHelper gestureRootHelper;

    public RNGestureHandlerEnabledRootView(Context context) {
        super(context);
    }

    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.gestureRootHelper;
        if (rNGestureHandlerRootHelper != null) {
            rNGestureHandlerRootHelper.requestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.gestureRootHelper;
        boolean z = false;
        if (rNGestureHandlerRootHelper != null && rNGestureHandlerRootHelper.dispatchTouchEvent(motionEvent)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void initialize() {
        if (this.gestureRootHelper == null) {
            ReactInstanceManager reactInstanceManager = this._reactInstanceManager;
            if (reactInstanceManager != null) {
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                Intrinsics.checkNotNull(currentReactContext);
                Intrinsics.checkNotNullExpressionValue(currentReactContext, "_reactInstanceManager.currentReactContext!!");
                this.gestureRootHelper = new RNGestureHandlerRootHelper(currentReactContext, this);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("_reactInstanceManager");
            throw null;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("GestureHandler already initialized for root view ", this).toString());
    }

    public final void tearDown() {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.gestureRootHelper;
        if (rNGestureHandlerRootHelper != null) {
            rNGestureHandlerRootHelper.tearDown();
            this.gestureRootHelper = null;
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        Intrinsics.checkNotNullParameter(str, "moduleName");
        super.startReactApplication(reactInstanceManager, str, bundle);
        this._reactInstanceManager = reactInstanceManager;
    }
}
