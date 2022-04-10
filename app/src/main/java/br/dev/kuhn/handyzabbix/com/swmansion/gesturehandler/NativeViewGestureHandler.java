package com.swmansion.gesturehandler;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0016J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0010\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u0014\u0010\u0012\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/NativeViewGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "()V", "disallowInterruption", "", "shouldActivateOnStart", "afterGestureEnd", "", "canStart", "onCancel", "onHandle", "event", "Landroid/view/MotionEvent;", "resetConfig", "setDisallowInterruption", "setShouldActivateOnStart", "shouldBeCancelledBy", "handler", "shouldRecognizeSimultaneously", "Companion", "StateChangeHook", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: NativeViewGestureHandler.kt */
public final class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean disallowInterruption;
    private boolean shouldActivateOnStart;

    @Metadata(mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/NativeViewGestureHandler$StateChangeHook;", "", "afterGestureEnd", "", "canStart", "", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public interface StateChangeHook {
        void afterGestureEnd();

        boolean canStart();
    }

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    public void resetConfig() {
        super.resetConfig();
        this.shouldActivateOnStart = false;
        this.disallowInterruption = false;
    }

    public final NativeViewGestureHandler setShouldActivateOnStart(boolean z) {
        NativeViewGestureHandler nativeViewGestureHandler = this;
        nativeViewGestureHandler.shouldActivateOnStart = z;
        return nativeViewGestureHandler;
    }

    public final NativeViewGestureHandler setDisallowInterruption(boolean z) {
        NativeViewGestureHandler nativeViewGestureHandler = this;
        nativeViewGestureHandler.disallowInterruption = z;
        return nativeViewGestureHandler;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if ((gestureHandler instanceof NativeViewGestureHandler) && gestureHandler.getState() == 4 && ((NativeViewGestureHandler) gestureHandler).disallowInterruption) {
            return false;
        }
        boolean z = !this.disallowInterruption;
        int state = gestureHandler.getState();
        if ((getState() != 4 || state != 4 || !z) && getState() == 4 && z) {
            return true;
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        return !this.disallowInterruption;
    }

    private final boolean canStart() {
        View view = getView();
        if (view instanceof StateChangeHook) {
            return ((StateChangeHook) view).canStart();
        }
        return true;
    }

    private final void afterGestureEnd() {
        View view = getView();
        if (view instanceof StateChangeHook) {
            ((StateChangeHook) view).afterGestureEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        View view = getView();
        Intrinsics.checkNotNull(view);
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            if ((getState() == 0 || getState() == 2) && view.isPressed()) {
                activate();
            }
            end();
            afterGestureEnd();
        } else if (getState() == 0 || getState() == 2) {
            if (this.shouldActivateOnStart) {
                boolean unused = Companion.tryIntercept(view, motionEvent);
                view.onTouchEvent(motionEvent);
                activate();
            } else if (Companion.tryIntercept(view, motionEvent)) {
                view.onTouchEvent(motionEvent);
                activate();
            } else if (getState() == 2) {
            } else {
                if (canStart()) {
                    begin();
                } else {
                    cancel();
                }
            }
        } else if (getState() == 4) {
            view.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        View view = getView();
        Intrinsics.checkNotNull(view);
        view.onTouchEvent(obtain);
    }

    @Metadata(mo24973d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/NativeViewGestureHandler$Companion;", "", "()V", "tryIntercept", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean tryIntercept(View view, MotionEvent motionEvent) {
            return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
        }
    }
}
