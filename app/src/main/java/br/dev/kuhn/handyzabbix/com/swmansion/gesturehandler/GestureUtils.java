package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/GestureUtils;", "", "()V", "getLastPointerX", "", "event", "Landroid/view/MotionEvent;", "averageTouches", "", "getLastPointerY", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: GestureUtils.kt */
public final class GestureUtils {
    public static final GestureUtils INSTANCE = new GestureUtils();

    private GestureUtils() {
    }

    public final float getLastPointerX(MotionEvent motionEvent, boolean z) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            if (pointerCount > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i + 1;
                    if (i != actionIndex) {
                        f += motionEvent.getX(i) + rawX;
                        i2++;
                    }
                    if (i3 >= pointerCount) {
                        break;
                    }
                    i = i3;
                }
                i = i2;
            }
            return f / ((float) i);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getX(pointerCount2) + rawX;
    }

    public final float getLastPointerY(MotionEvent motionEvent, boolean z) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            if (pointerCount > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i + 1;
                    if (i != actionIndex) {
                        f += motionEvent.getY(i) + rawY;
                        i2++;
                    }
                    if (i3 >= pointerCount) {
                        break;
                    }
                    i = i3;
                }
                i = i2;
            }
            return f / ((float) i);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getY(pointerCount2) + rawY;
    }
}
