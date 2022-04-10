package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.GestureHandlerInteractionController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ \u0010\u0014\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0017\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0018\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0019\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "Lcom/swmansion/gesturehandler/GestureHandlerInteractionController;", "()V", "simultaneousRelations", "Landroid/util/SparseArray;", "", "waitForRelations", "configureInteractions", "", "handler", "Lcom/swmansion/gesturehandler/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "convertHandlerTagsArray", "key", "", "dropRelationsForHandlerWithTag", "handlerTag", "", "reset", "shouldHandlerBeCancelledBy", "", "otherHandler", "shouldRecognizeSimultaneously", "shouldRequireHandlerToWaitForFailure", "shouldWaitForHandlerFailure", "Companion", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: RNGestureHandlerInteractionManager.kt */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SIMULTANEOUS_HANDLERS = "simultaneousHandlers";
    private static final String KEY_WAIT_FOR = "waitFor";
    private final SparseArray<int[]> simultaneousRelations = new SparseArray<>();
    private final SparseArray<int[]> waitForRelations = new SparseArray<>();

    public boolean shouldHandlerBeCancelledBy(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }

    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }

    public final void dropRelationsForHandlerWithTag(int i) {
        this.waitForRelations.remove(i);
        this.simultaneousRelations.remove(i);
    }

    private final int[] convertHandlerTagsArray(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        Intrinsics.checkNotNull(array);
        Intrinsics.checkNotNullExpressionValue(array, "config.getArray(key)!!");
        int size = array.size();
        int[] iArr = new int[size];
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                iArr[i2] = array.getInt(i2);
                if (i3 > i) {
                    break;
                }
                i2 = i3;
            }
        }
        return iArr;
    }

    public final void configureInteractions(GestureHandler<?> gestureHandler, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(readableMap, "config");
        gestureHandler.setInteractionController(this);
        if (readableMap.hasKey(KEY_WAIT_FOR)) {
            this.waitForRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_WAIT_FOR));
        }
        if (readableMap.hasKey(KEY_SIMULTANEOUS_HANDLERS)) {
            this.simultaneousRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_SIMULTANEOUS_HANDLERS));
        }
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        int[] iArr = this.waitForRelations.get(gestureHandler.getTag());
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] == gestureHandler2.getTag()) {
                return true;
            }
        }
        return false;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        int[] iArr = this.simultaneousRelations.get(gestureHandler.getTag());
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] == gestureHandler2.getTag()) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        this.waitForRelations.clear();
        this.simultaneousRelations.clear();
    }

    @Metadata(mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager$Companion;", "", "()V", "KEY_SIMULTANEOUS_HANDLERS", "", "KEY_WAIT_FOR", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerInteractionManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
