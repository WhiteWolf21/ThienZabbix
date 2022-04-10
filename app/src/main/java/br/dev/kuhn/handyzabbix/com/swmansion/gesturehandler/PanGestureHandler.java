package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001EB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020+H\u0014J\b\u00101\u001a\u00020+H\u0016J\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u00107\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0006J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0006J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\b\u0010C\u001a\u00020\u000bH\u0002J\b\u0010D\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u001e\u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 ¨\u0006F"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/PanGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activeOffsetXEnd", "", "activeOffsetXStart", "activeOffsetYEnd", "activeOffsetYStart", "averageTouches", "", "defaultMinDistSq", "failOffsetXEnd", "failOffsetXStart", "failOffsetYEnd", "failOffsetYStart", "lastX", "lastY", "maxPointers", "", "minDistSq", "minPointers", "minVelocitySq", "minVelocityX", "minVelocityY", "offsetX", "offsetY", "startX", "startY", "translationX", "getTranslationX", "()F", "translationY", "getTranslationY", "velocityTracker", "Landroid/view/VelocityTracker;", "<set-?>", "velocityX", "getVelocityX", "velocityY", "getVelocityY", "activate", "", "force", "onHandle", "event", "Landroid/view/MotionEvent;", "onReset", "resetConfig", "setActiveOffsetXEnd", "setActiveOffsetXStart", "setActiveOffsetYEnd", "setActiveOffsetYStart", "setAverageTouches", "setFailOffsetXEnd", "setFailOffsetXStart", "setFailOffsetYEnd", "setFailOffsetYStart", "setMaxPointers", "setMinDist", "minDist", "setMinPointers", "setMinVelocity", "minVelocity", "setMinVelocityX", "setMinVelocityY", "shouldActivate", "shouldFail", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: PanGestureHandler.kt */
public final class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_MAX_POINTERS = 10;
    private static final int DEFAULT_MIN_POINTERS = 1;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static final float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private float activeOffsetXEnd = Float.MIN_VALUE;
    private float activeOffsetXStart = Float.MAX_VALUE;
    private float activeOffsetYEnd = Float.MIN_VALUE;
    private float activeOffsetYStart = Float.MAX_VALUE;
    private boolean averageTouches;
    private final float defaultMinDistSq;
    private float failOffsetXEnd = Float.MAX_VALUE;
    private float failOffsetXStart = Float.MIN_VALUE;
    private float failOffsetYEnd = Float.MAX_VALUE;
    private float failOffsetYStart = Float.MIN_VALUE;
    private float lastX;
    private float lastY;
    private int maxPointers = 10;
    private float minDistSq = Float.MIN_VALUE;
    private int minPointers = 1;
    private float minVelocitySq = Float.MAX_VALUE;
    private float minVelocityX = Float.MAX_VALUE;
    private float minVelocityY = Float.MAX_VALUE;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private VelocityTracker velocityTracker;
    private float velocityX;
    private float velocityY;

    public PanGestureHandler(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f = (float) (scaledTouchSlop * scaledTouchSlop);
        this.defaultMinDistSq = f;
        this.minDistSq = f;
    }

    public final float getVelocityX() {
        return this.velocityX;
    }

    public final float getVelocityY() {
        return this.velocityY;
    }

    public final float getTranslationX() {
        return (this.lastX - this.startX) + this.offsetX;
    }

    public final float getTranslationY() {
        return (this.lastY - this.startY) + this.offsetY;
    }

    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocitySq = Float.MAX_VALUE;
        this.minDistSq = this.defaultMinDistSq;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.averageTouches = false;
    }

    public final PanGestureHandler setActiveOffsetXStart(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.activeOffsetXStart = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setActiveOffsetXEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.activeOffsetXEnd = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setFailOffsetXStart(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.failOffsetXStart = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setFailOffsetXEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.failOffsetXEnd = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setActiveOffsetYStart(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.activeOffsetYStart = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setActiveOffsetYEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.activeOffsetYEnd = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setFailOffsetYStart(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.failOffsetYStart = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setFailOffsetYEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.failOffsetYEnd = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setMinDist(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.minDistSq = f * f;
        return panGestureHandler;
    }

    public final PanGestureHandler setMinPointers(int i) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.minPointers = i;
        return panGestureHandler;
    }

    public final PanGestureHandler setMaxPointers(int i) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.maxPointers = i;
        return panGestureHandler;
    }

    public final PanGestureHandler setAverageTouches(boolean z) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.averageTouches = z;
        return panGestureHandler;
    }

    public final PanGestureHandler setMinVelocity(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.minVelocitySq = f * f;
        return panGestureHandler;
    }

    public final PanGestureHandler setMinVelocityX(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.minVelocityX = f;
        return panGestureHandler;
    }

    public final PanGestureHandler setMinVelocityY(float f) {
        PanGestureHandler panGestureHandler = this;
        panGestureHandler.minVelocityY = f;
        return panGestureHandler;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x008c, code lost:
        if ((0.0f <= r1 && r1 <= r0) != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00af, code lost:
        if ((0.0f <= r5 && r5 <= r0) != false) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldActivate() {
        /*
            r8 = this;
            float r0 = r8.lastX
            float r1 = r8.startX
            float r0 = r0 - r1
            float r1 = r8.offsetX
            float r0 = r0 + r1
            float r1 = r8.activeOffsetXStart
            r2 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r3 = 0
            r4 = 1
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0015
            r5 = 1
            goto L_0x0016
        L_0x0015:
            r5 = 0
        L_0x0016:
            if (r5 != 0) goto L_0x001d
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            return r4
        L_0x001d:
            float r1 = r8.activeOffsetXEnd
            r5 = 1
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 != 0) goto L_0x0026
            r6 = 1
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            if (r6 != 0) goto L_0x002e
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            return r4
        L_0x002e:
            float r1 = r8.lastY
            float r6 = r8.startY
            float r1 = r1 - r6
            float r6 = r8.offsetY
            float r1 = r1 + r6
            float r6 = r8.activeOffsetYStart
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x003e
            r7 = 1
            goto L_0x003f
        L_0x003e:
            r7 = 0
        L_0x003f:
            if (r7 != 0) goto L_0x0046
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0046
            return r4
        L_0x0046:
            float r6 = r8.activeOffsetYEnd
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x004e
            r5 = 1
            goto L_0x004f
        L_0x004e:
            r5 = 0
        L_0x004f:
            if (r5 != 0) goto L_0x0056
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0056
            return r4
        L_0x0056:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r8.minDistSq
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 != 0) goto L_0x006b
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x006b
            return r4
        L_0x006b:
            float r0 = r8.velocityX
            float r1 = r8.minVelocityX
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0075
            r5 = 1
            goto L_0x0076
        L_0x0075:
            r5 = 0
        L_0x0076:
            r6 = 0
            if (r5 != 0) goto L_0x008f
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0081
            int r5 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r5 <= 0) goto L_0x008e
        L_0x0081:
            int r5 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x008b
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 > 0) goto L_0x008b
            r1 = 1
            goto L_0x008c
        L_0x008b:
            r1 = 0
        L_0x008c:
            if (r1 == 0) goto L_0x008f
        L_0x008e:
            return r4
        L_0x008f:
            float r1 = r8.velocityY
            float r5 = r8.minVelocityY
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0099
            r7 = 1
            goto L_0x009a
        L_0x0099:
            r7 = 0
        L_0x009a:
            if (r7 != 0) goto L_0x00b2
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a4
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00b1
        L_0x00a4:
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x00ae
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x00ae
            r5 = 1
            goto L_0x00af
        L_0x00ae:
            r5 = 0
        L_0x00af:
            if (r5 == 0) goto L_0x00b2
        L_0x00b1:
            return r4
        L_0x00b2:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r8.minVelocitySq
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x00bf
            r2 = 1
            goto L_0x00c0
        L_0x00bf:
            r2 = 0
        L_0x00c0:
            if (r2 != 0) goto L_0x00c7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c7
            r3 = 1
        L_0x00c7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.PanGestureHandler.shouldActivate():boolean");
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = this.failOffsetXStart;
        if (!(f2 == Float.MIN_VALUE) && f < f2) {
            return true;
        }
        float f3 = this.failOffsetXEnd;
        if (!(f3 == Float.MAX_VALUE) && f > f3) {
            return true;
        }
        float f4 = (this.lastY - this.startY) + this.offsetY;
        float f5 = this.failOffsetYStart;
        if (!(f5 == Float.MIN_VALUE) && f4 < f5) {
            return true;
        }
        float f6 = this.failOffsetYEnd;
        if ((f6 == Float.MAX_VALUE) || f4 <= f6) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int state = getState();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 5 || actionMasked == 6) {
            this.offsetX += this.lastX - this.startX;
            this.offsetY += this.lastY - this.startY;
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent, this.averageTouches);
            float lastPointerY = GestureUtils.INSTANCE.getLastPointerY(motionEvent, this.averageTouches);
            this.lastY = lastPointerY;
            this.startX = this.lastX;
            this.startY = lastPointerY;
        } else {
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent, this.averageTouches);
            this.lastY = GestureUtils.INSTANCE.getLastPointerY(motionEvent, this.averageTouches);
        }
        if (state != 0 || motionEvent.getPointerCount() < this.minPointers) {
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                Companion.addVelocityMovement(velocityTracker2, motionEvent);
                VelocityTracker velocityTracker3 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker3);
                velocityTracker3.computeCurrentVelocity(1000);
                VelocityTracker velocityTracker4 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker4);
                this.velocityX = velocityTracker4.getXVelocity();
                VelocityTracker velocityTracker5 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker5);
                this.velocityY = velocityTracker5.getYVelocity();
            }
        } else {
            this.startX = this.lastX;
            this.startY = this.lastY;
            this.offsetX = 0.0f;
            this.offsetY = 0.0f;
            this.velocityX = 0.0f;
            this.velocityY = 0.0f;
            VelocityTracker obtain = VelocityTracker.obtain();
            this.velocityTracker = obtain;
            Companion.addVelocityMovement(obtain, motionEvent);
            begin();
        }
        if (actionMasked == 1) {
            if (state == 4) {
                end();
            } else {
                fail();
            }
        } else if (actionMasked != 5 || motionEvent.getPointerCount() <= this.maxPointers) {
            if (actionMasked == 6 && state == 4 && motionEvent.getPointerCount() < this.minPointers) {
                fail();
            } else if (state != 2) {
            } else {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    activate();
                }
            }
        } else if (state == 4) {
            cancel();
        } else {
            fail();
        }
    }

    public void activate(boolean z) {
        if (getState() != 4) {
            this.startX = this.lastX;
            this.startY = this.lastY;
        }
        super.activate(z);
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    @Metadata(mo24973d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/PanGestureHandler$Companion;", "", "()V", "DEFAULT_MAX_POINTERS", "", "DEFAULT_MIN_POINTERS", "MAX_VALUE_IGNORE", "", "MIN_VALUE_IGNORE", "addVelocityMovement", "", "tracker", "Landroid/view/VelocityTracker;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: PanGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }
    }
}
