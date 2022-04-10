package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/ManualGestureHandler;", "Lcom/swmansion/gesturehandler/GestureHandler;", "()V", "onHandle", "", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: ManualGestureHandler.kt */
public final class ManualGestureHandler extends GestureHandler<ManualGestureHandler> {
    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (getState() == 0) {
            begin();
        }
    }
}
