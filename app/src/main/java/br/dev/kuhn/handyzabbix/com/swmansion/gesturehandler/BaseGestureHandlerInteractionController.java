package com.swmansion.gesturehandler;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J \u0010\b\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J \u0010\t\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016¨\u0006\n"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/BaseGestureHandlerInteractionController;", "Lcom/swmansion/gesturehandler/GestureHandlerInteractionController;", "()V", "shouldRecognizeSimultaneously", "", "handler", "Lcom/swmansion/gesturehandler/GestureHandler;", "otherHandler", "shouldRequireHandlerToWaitForFailure", "shouldWaitForHandlerFailure", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: BaseGestureHandlerInteractionController.kt */
public abstract class BaseGestureHandlerInteractionController implements GestureHandlerInteractionController {
    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }

    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }
}
