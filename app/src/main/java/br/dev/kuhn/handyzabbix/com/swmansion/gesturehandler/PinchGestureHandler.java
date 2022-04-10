package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001e"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/PinchGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "()V", "focalPointX", "", "getFocalPointX", "()F", "focalPointY", "getFocalPointY", "gestureListener", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "<set-?>", "", "scale", "getScale", "()D", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "spanSlop", "startingSpan", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "onReset", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: PinchGestureHandler.kt */
public final class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    private final ScaleGestureDetector.OnScaleGestureListener gestureListener = new PinchGestureHandler$gestureListener$1(this);
    /* access modifiers changed from: private */
    public double scale;
    private ScaleGestureDetector scaleGestureDetector;
    /* access modifiers changed from: private */
    public float spanSlop;
    /* access modifiers changed from: private */
    public float startingSpan;
    /* access modifiers changed from: private */
    public double velocity;

    public final double getScale() {
        return this.scale;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getFocalPointX() {
        ScaleGestureDetector scaleGestureDetector2 = this.scaleGestureDetector;
        if (scaleGestureDetector2 == null) {
            return Float.NaN;
        }
        return scaleGestureDetector2.getFocusX();
    }

    public final float getFocalPointY() {
        ScaleGestureDetector scaleGestureDetector2 = this.scaleGestureDetector;
        if (scaleGestureDetector2 == null) {
            return Float.NaN;
        }
        return scaleGestureDetector2.getFocusY();
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (getState() == 0) {
            View view = getView();
            Intrinsics.checkNotNull(view);
            Context context = view.getContext();
            this.velocity = Utils.DOUBLE_EPSILON;
            this.scale = 1.0d;
            this.scaleGestureDetector = new ScaleGestureDetector(context, this.gestureListener);
            this.spanSlop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            begin();
        }
        ScaleGestureDetector scaleGestureDetector2 = this.scaleGestureDetector;
        if (scaleGestureDetector2 != null) {
            scaleGestureDetector2.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            pointerCount--;
        }
        if (getState() == 4 && pointerCount < 2) {
            end();
        } else if (motionEvent.getActionMasked() == 1) {
            fail();
        }
    }

    public void activate(boolean z) {
        if (getState() != 4) {
            this.velocity = Utils.DOUBLE_EPSILON;
            this.scale = 1.0d;
        }
        super.activate(z);
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.scaleGestureDetector = null;
        this.velocity = Utils.DOUBLE_EPSILON;
        this.scale = 1.0d;
    }
}
