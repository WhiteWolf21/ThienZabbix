package com.swmansion.gesturehandler;

import android.view.ScaleGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo24974d2 = {"com/swmansion/gesturehandler/PinchGestureHandler$gestureListener$1", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: PinchGestureHandler.kt */
public final class PinchGestureHandler$gestureListener$1 implements ScaleGestureDetector.OnScaleGestureListener {
    final /* synthetic */ PinchGestureHandler this$0;

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
    }

    PinchGestureHandler$gestureListener$1(PinchGestureHandler pinchGestureHandler) {
        this.this$0 = pinchGestureHandler;
        pinchGestureHandler.setShouldCancelWhenOutside(false);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
        double scale = this.this$0.getScale();
        PinchGestureHandler pinchGestureHandler = this.this$0;
        pinchGestureHandler.scale = pinchGestureHandler.getScale() * ((double) scaleGestureDetector.getScaleFactor());
        long timeDelta = scaleGestureDetector.getTimeDelta();
        if (timeDelta > 0) {
            PinchGestureHandler pinchGestureHandler2 = this.this$0;
            pinchGestureHandler2.velocity = (pinchGestureHandler2.getScale() - scale) / ((double) timeDelta);
        }
        if (Math.abs(this.this$0.startingSpan - scaleGestureDetector.getCurrentSpan()) < this.this$0.spanSlop || this.this$0.getState() != 2) {
            return true;
        }
        this.this$0.activate();
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
        this.this$0.startingSpan = scaleGestureDetector.getCurrentSpan();
        return true;
    }
}
