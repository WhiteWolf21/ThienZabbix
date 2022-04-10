package com.swmansion.gesturehandler;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0014J\b\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/LongPressGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultMaxDistSq", "", "duration", "", "getDuration", "()I", "handler", "Landroid/os/Handler;", "maxDistSq", "minDurationMs", "", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "previousTime", "startTime", "startX", "startY", "dispatchHandlerUpdate", "", "event", "Landroid/view/MotionEvent;", "dispatchStateChange", "newState", "prevState", "onHandle", "onStateChange", "previousState", "resetConfig", "setMaxDist", "maxDist", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: LongPressGestureHandler.kt */
public final class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_MAX_DIST_DP = 10.0f;
    private static final long DEFAULT_MIN_DURATION_MS = 500;
    private final float defaultMaxDistSq;
    private Handler handler;
    private float maxDistSq;
    private long minDurationMs = DEFAULT_MIN_DURATION_MS;
    private long previousTime;
    private long startTime;
    private float startX;
    private float startY;

    public LongPressGestureHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setShouldCancelWhenOutside(true);
        float f = context.getResources().getDisplayMetrics().density * DEFAULT_MAX_DIST_DP;
        this.defaultMaxDistSq = f;
        this.maxDistSq = f;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final int getDuration() {
        return (int) (this.previousTime - this.startTime);
    }

    public void resetConfig() {
        super.resetConfig();
        this.minDurationMs = DEFAULT_MIN_DURATION_MS;
        this.maxDistSq = this.defaultMaxDistSq;
    }

    public final LongPressGestureHandler setMaxDist(float f) {
        this.maxDistSq = f * f;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (getState() == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.previousTime = uptimeMillis;
            this.startTime = uptimeMillis;
            begin();
            this.startX = motionEvent.getRawX();
            this.startY = motionEvent.getRawY();
            Handler handler2 = new Handler();
            this.handler = handler2;
            long j = this.minDurationMs;
            if (j > 0) {
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(new Runnable() {
                    public final void run() {
                        LongPressGestureHandler.m204onHandle$lambda0(LongPressGestureHandler.this);
                    }
                }, this.minDurationMs);
            } else if (j == 0) {
                activate();
            }
        }
        if (motionEvent.getActionMasked() == 1) {
            Handler handler3 = this.handler;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages((Object) null);
                this.handler = null;
            }
            if (getState() == 4) {
                end();
            } else {
                fail();
            }
        } else {
            float rawX = motionEvent.getRawX() - this.startX;
            float rawY = motionEvent.getRawY() - this.startY;
            if ((rawX * rawX) + (rawY * rawY) <= this.maxDistSq) {
                return;
            }
            if (getState() == 4) {
                cancel();
            } else {
                fail();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onHandle$lambda-0  reason: not valid java name */
    public static final void m204onHandle$lambda0(LongPressGestureHandler longPressGestureHandler) {
        Intrinsics.checkNotNullParameter(longPressGestureHandler, "this$0");
        longPressGestureHandler.activate();
    }

    /* access modifiers changed from: protected */
    public void onStateChange(int i, int i2) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
    }

    public void dispatchStateChange(int i, int i2) {
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchStateChange(i, i2);
    }

    public void dispatchHandlerUpdate(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchHandlerUpdate(motionEvent);
    }

    @Metadata(mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/LongPressGestureHandler$Companion;", "", "()V", "DEFAULT_MAX_DIST_DP", "", "DEFAULT_MIN_DURATION_MS", "", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: LongPressGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
