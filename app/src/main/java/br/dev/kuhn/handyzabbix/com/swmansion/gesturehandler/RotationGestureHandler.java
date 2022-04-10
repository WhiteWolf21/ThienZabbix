package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import com.github.mikephil.charting.utils.Utils;
import com.swmansion.gesturehandler.RotationGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001d"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/RotationGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "()V", "anchorX", "", "getAnchorX", "()F", "anchorY", "getAnchorY", "gestureListener", "Lcom/swmansion/gesturehandler/RotationGestureDetector$OnRotationGestureListener;", "<set-?>", "", "rotation", "getRotation", "()D", "rotationGestureDetector", "Lcom/swmansion/gesturehandler/RotationGestureDetector;", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "onReset", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: RotationGestureHandler.kt */
public final class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double ROTATION_RECOGNITION_THRESHOLD = 0.08726646259971647d;
    private final RotationGestureDetector.OnRotationGestureListener gestureListener = new RotationGestureHandler$gestureListener$1(this);
    /* access modifiers changed from: private */
    public double rotation;
    private RotationGestureDetector rotationGestureDetector;
    /* access modifiers changed from: private */
    public double velocity;

    public RotationGestureHandler() {
        setShouldCancelWhenOutside(false);
    }

    public final double getRotation() {
        return this.rotation;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getAnchorX() {
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 == null) {
            return Float.NaN;
        }
        return rotationGestureDetector2.getAnchorX();
    }

    public final float getAnchorY() {
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 == null) {
            return Float.NaN;
        }
        return rotationGestureDetector2.getAnchorY();
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (getState() == 0) {
            this.velocity = Utils.DOUBLE_EPSILON;
            this.rotation = Utils.DOUBLE_EPSILON;
            this.rotationGestureDetector = new RotationGestureDetector(this.gestureListener);
            begin();
        }
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 != null) {
            rotationGestureDetector2.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1) {
            return;
        }
        if (getState() == 4) {
            end();
        } else {
            fail();
        }
    }

    public void activate(boolean z) {
        if (getState() != 4) {
            this.rotation = Utils.DOUBLE_EPSILON;
            this.velocity = Utils.DOUBLE_EPSILON;
        }
        super.activate(z);
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.rotationGestureDetector = null;
        this.velocity = Utils.DOUBLE_EPSILON;
        this.rotation = Utils.DOUBLE_EPSILON;
    }

    @Metadata(mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/RotationGestureHandler$Companion;", "", "()V", "ROTATION_RECOGNITION_THRESHOLD", "", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RotationGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
