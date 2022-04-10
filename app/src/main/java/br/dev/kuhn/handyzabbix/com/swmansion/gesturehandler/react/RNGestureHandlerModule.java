package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.gesturehandler.ExtensionsKt;
import com.swmansion.gesturehandler.FlingGestureHandler;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.LongPressGestureHandler;
import com.swmansion.gesturehandler.ManualGestureHandler;
import com.swmansion.gesturehandler.NativeViewGestureHandler;
import com.swmansion.gesturehandler.PanGestureHandler;
import com.swmansion.gesturehandler.PinchGestureHandler;
import com.swmansion.gesturehandler.RotationGestureHandler;
import com.swmansion.gesturehandler.TapGestureHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0001\n\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\nBCDEFGHIJKB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J0\u0010\u001e\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0007J.\u0010&\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u000e\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001f0 H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010,\u001a\u00020\"H\u0016J\b\u0010-\u001a\u00020\u0019H\u0007J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u001dH\u0007J\b\u00100\u001a\u00020\u0019H\u0016J-\u00101\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010'\u001a\u0002H\u001f2\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104J5\u00105\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010'\u001a\u0002H\u001f2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0002¢\u0006\u0002\u00108J%\u00109\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010'\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u0017J\u0018\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\bH\u0002J\u000e\u0010@\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u0017J(\u0010A\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/swmansion/common/GestureHandlerStateManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "enqueuedRootViewInit", "", "", "eventListener", "com/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1;", "handlerFactories", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "[Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "interactionManager", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "registry", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getRegistry", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "roots", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "attachGestureHandler", "", "handlerTag", "viewTag", "useDeviceEvents", "", "createGestureHandler", "T", "Lcom/swmansion/gesturehandler/GestureHandler;", "handlerName", "", "config", "Lcom/facebook/react/bridge/ReadableMap;", "dropGestureHandler", "findFactoryForHandler", "handler", "findRootHelperForViewAncestor", "getConstants", "", "", "getName", "handleClearJSResponder", "handleSetJSResponder", "blockNativeResponder", "onCatalystInstanceDestroy", "onHandlerUpdate", "motionEvent", "Landroid/view/MotionEvent;", "(Lcom/swmansion/gesturehandler/GestureHandler;Landroid/view/MotionEvent;)V", "onStateChange", "newState", "oldState", "(Lcom/swmansion/gesturehandler/GestureHandler;II)V", "onTouchEvent", "(Lcom/swmansion/gesturehandler/GestureHandler;)V", "registerRootHelper", "root", "setGestureHandlerState", "tryInitializeHandlerForReactRootView", "ancestorViewTag", "unregisterRootHelper", "updateGestureHandler", "Companion", "FlingGestureHandlerFactory", "HandlerFactory", "LongPressGestureHandlerFactory", "ManualGestureHandlerFactory", "NativeViewGestureHandlerFactory", "PanGestureHandlerFactory", "PinchGestureHandlerFactory", "RotationGestureHandlerFactory", "TapGestureHandlerFactory", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
@ReactModule(name = "RNGestureHandlerModule")
/* compiled from: RNGestureHandlerModule.kt */
public final class RNGestureHandlerModule extends ReactContextBaseJavaModule implements GestureHandlerStateManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_DIRECTION = "direction";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HIT_SLOP = "hitSlop";
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    private static final String KEY_HIT_SLOP_HEIGHT = "height";
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    private static final String KEY_HIT_SLOP_LEFT = "left";
    private static final String KEY_HIT_SLOP_RIGHT = "right";
    private static final String KEY_HIT_SLOP_TOP = "top";
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    private static final String KEY_HIT_SLOP_WIDTH = "width";
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    private static final String KEY_MANUAL_ACTIVATION = "manualActivation";
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    private static final String KEY_PAN_MIN_DIST = "minDist";
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    private static final String KEY_TAP_MAX_DIST = "maxDist";
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String MODULE_NAME = "RNGestureHandlerModule";
    private final List<Integer> enqueuedRootViewInit = new ArrayList();
    private final RNGestureHandlerModule$eventListener$1 eventListener = new RNGestureHandlerModule$eventListener$1(this);
    private final HandlerFactory<?>[] handlerFactories = {new NativeViewGestureHandlerFactory(), new TapGestureHandlerFactory(), new LongPressGestureHandlerFactory(), new PanGestureHandlerFactory(), new PinchGestureHandlerFactory(), new RotationGestureHandlerFactory(), new FlingGestureHandlerFactory(), new ManualGestureHandlerFactory()};
    private final RNGestureHandlerInteractionManager interactionManager = new RNGestureHandlerInteractionManager();
    private final RNGestureHandlerRegistry registry = new RNGestureHandlerRegistry();
    private final List<RNGestureHandlerRootHelper> roots = new ArrayList();

    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public final void handleClearJSResponder() {
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Metadata(mo24973d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "T", "Lcom/swmansion/gesturehandler/GestureHandler;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/swmansion/gesturehandler/GestureHandler;Lcom/facebook/react/bridge/ReadableMap;)V", "create", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/swmansion/gesturehandler/GestureHandler;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "(Lcom/swmansion/gesturehandler/GestureHandler;Lcom/facebook/react/bridge/WritableMap;)V", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static abstract class HandlerFactory<T extends GestureHandler<T>> implements RNGestureHandlerEventDataExtractor<T> {
        public abstract T create(Context context);

        public abstract String getName();

        public abstract Class<T> getType();

        public void configure(T t, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(t, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            t.resetConfig();
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                t.setShouldCancelWhenOutside(readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (readableMap.hasKey("enabled")) {
                t.setEnabled(readableMap.getBoolean("enabled"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.Companion.handleHitSlopProperty(t, readableMap);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA)) {
                t.setNeedsPointerData(readableMap.getBoolean(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION)) {
                t.setManualActivation(readableMap.getBoolean(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION));
            }
        }

        public void extractEventData(T t, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(t, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) t.getNumberOfPointers());
        }
    }

    @Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$NativeViewGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/NativeViewGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {
        private final String name = "NativeViewGestureHandler";
        private final Class<NativeViewGestureHandler> type = NativeViewGestureHandler.class;

        public Class<NativeViewGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public NativeViewGestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        public void configure(NativeViewGestureHandler nativeViewGestureHandler, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(nativeViewGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                nativeViewGestureHandler.setShouldActivateOnStart(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                nativeViewGestureHandler.setDisallowInterruption(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION));
            }
        }

        public void extractEventData(NativeViewGestureHandler nativeViewGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(nativeViewGestureHandler, writableMap);
            writableMap.putBoolean("pointerInside", nativeViewGestureHandler.isWithinBounds());
        }
    }

    @Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$TapGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/TapGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {
        private final String name = "TapGestureHandler";
        private final Class<TapGestureHandler> type = TapGestureHandler.class;

        public Class<TapGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public TapGestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        public void configure(TapGestureHandler tapGestureHandler, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(tapGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(tapGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                tapGestureHandler.setNumberOfTaps(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                tapGestureHandler.setMaxDurationMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                tapGestureHandler.setMaxDelayMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                tapGestureHandler.setMaxDx(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                tapGestureHandler.setMaxDy(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)));
            }
            if (readableMap.hasKey("maxDist")) {
                tapGestureHandler.setMaxDist(PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist")));
            }
            if (readableMap.hasKey("minPointers")) {
                tapGestureHandler.setMinNumberOfPointers(readableMap.getInt("minPointers"));
            }
        }

        public void extractEventData(TapGestureHandler tapGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(tapGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(tapGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastAbsolutePositionY()));
        }
    }

    @Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$LongPressGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/LongPressGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {
        private final String name = "LongPressGestureHandler";
        private final Class<LongPressGestureHandler> type = LongPressGestureHandler.class;

        public Class<LongPressGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public LongPressGestureHandler create(Context context) {
            Intrinsics.checkNotNull(context);
            return new LongPressGestureHandler(context);
        }

        public void configure(LongPressGestureHandler longPressGestureHandler, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(longPressGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(longPressGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                longPressGestureHandler.setMinDurationMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS));
            }
            if (readableMap.hasKey("maxDist")) {
                longPressGestureHandler.setMaxDist(PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist")));
            }
        }

        public void extractEventData(LongPressGestureHandler longPressGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(longPressGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(longPressGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastAbsolutePositionY()));
            writableMap.putInt(TypedValues.Transition.S_DURATION, longPressGestureHandler.getDuration());
        }
    }

    @Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PanGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/PanGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {
        private final String name = "PanGestureHandler";
        private final Class<PanGestureHandler> type = PanGestureHandler.class;

        public Class<PanGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public PanGestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        public void configure(PanGestureHandler panGestureHandler, ReadableMap readableMap) {
            boolean z;
            Intrinsics.checkNotNullParameter(panGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(panGestureHandler, readableMap);
            boolean z2 = true;
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                panGestureHandler.setActiveOffsetXStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)));
                z = true;
            } else {
                z = false;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                panGestureHandler.setActiveOffsetXEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                panGestureHandler.setFailOffsetXStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                panGestureHandler.setFailOffsetXEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                panGestureHandler.setActiveOffsetYStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                panGestureHandler.setActiveOffsetYEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                panGestureHandler.setFailOffsetYStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                panGestureHandler.setFailOffsetYEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                panGestureHandler.setMinVelocity(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                panGestureHandler.setMinVelocityX(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                panGestureHandler.setMinVelocityY(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)));
            } else {
                z2 = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                panGestureHandler.setMinDist(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST)));
            } else if (z2) {
                panGestureHandler.setMinDist(Float.MAX_VALUE);
            }
            if (readableMap.hasKey("minPointers")) {
                panGestureHandler.setMinPointers(readableMap.getInt("minPointers"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                panGestureHandler.setMaxPointers(readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                panGestureHandler.setAverageTouches(readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES));
            }
        }

        public void extractEventData(PanGestureHandler panGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(panGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(panGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastAbsolutePositionY()));
            writableMap.putDouble("translationX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getTranslationX()));
            writableMap.putDouble("translationY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getTranslationY()));
            writableMap.putDouble("velocityX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getVelocityX()));
            writableMap.putDouble("velocityY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getVelocityY()));
        }
    }

    @Metadata(mo24973d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PinchGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/PinchGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "extractEventData", "", "handler", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {
        private final String name = "PinchGestureHandler";
        private final Class<PinchGestureHandler> type = PinchGestureHandler.class;

        public Class<PinchGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public PinchGestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        public void extractEventData(PinchGestureHandler pinchGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(pinchGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(pinchGestureHandler, writableMap);
            writableMap.putDouble("scale", pinchGestureHandler.getScale());
            writableMap.putDouble("focalX", (double) PixelUtil.toDIPFromPixel(pinchGestureHandler.getFocalPointX()));
            writableMap.putDouble("focalY", (double) PixelUtil.toDIPFromPixel(pinchGestureHandler.getFocalPointY()));
            writableMap.putDouble("velocity", pinchGestureHandler.getVelocity());
        }
    }

    @Metadata(mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$FlingGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/FlingGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {
        private final String name = "FlingGestureHandler";
        private final Class<FlingGestureHandler> type = FlingGestureHandler.class;

        public Class<FlingGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public FlingGestureHandler create(Context context) {
            return new FlingGestureHandler();
        }

        public void configure(FlingGestureHandler flingGestureHandler, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(flingGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(flingGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                flingGestureHandler.setNumberOfPointersRequired(readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                flingGestureHandler.setDirection(readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION));
            }
        }

        public void extractEventData(FlingGestureHandler flingGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(flingGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(flingGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastAbsolutePositionY()));
        }
    }

    @Metadata(mo24973d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$RotationGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/RotationGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "extractEventData", "", "handler", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {
        private final String name = "RotationGestureHandler";
        private final Class<RotationGestureHandler> type = RotationGestureHandler.class;

        public Class<RotationGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public RotationGestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        public void extractEventData(RotationGestureHandler rotationGestureHandler, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(rotationGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(rotationGestureHandler, writableMap);
            writableMap.putDouble("rotation", rotationGestureHandler.getRotation());
            writableMap.putDouble("anchorX", (double) PixelUtil.toDIPFromPixel(rotationGestureHandler.getAnchorX()));
            writableMap.putDouble("anchorY", (double) PixelUtil.toDIPFromPixel(rotationGestureHandler.getAnchorY()));
            writableMap.putDouble("velocity", rotationGestureHandler.getVelocity());
        }
    }

    @Metadata(mo24973d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$ManualGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/ManualGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    private static final class ManualGestureHandlerFactory extends HandlerFactory<ManualGestureHandler> {
        private final String name = "ManualGestureHandler";
        private final Class<ManualGestureHandler> type = ManualGestureHandler.class;

        public Class<ManualGestureHandler> getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public ManualGestureHandler create(Context context) {
            return new ManualGestureHandler();
        }
    }

    public final RNGestureHandlerRegistry getRegistry() {
        return this.registry;
    }

    @ReactMethod
    public final <T extends GestureHandler<T>> void createGestureHandler(String str, int i, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(str, "handlerName");
        Intrinsics.checkNotNullParameter(readableMap, "config");
        HandlerFactory[] handlerFactoryArr = this.handlerFactories;
        int length = handlerFactoryArr.length;
        int i2 = 0;
        while (i2 < length) {
            HandlerFactory handlerFactory = handlerFactoryArr[i2];
            i2++;
            if (Intrinsics.areEqual((Object) handlerFactory.getName(), (Object) str)) {
                GestureHandler create = handlerFactory.create(getReactApplicationContext());
                create.setTag(i);
                create.setOnTouchEventListener(this.eventListener);
                this.registry.registerHandler(create);
                this.interactionManager.configureInteractions(create, readableMap);
                handlerFactory.configure(create, readableMap);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException(Intrinsics.stringPlus("Invalid handler name ", str));
    }

    @ReactMethod
    public final void attachGestureHandler(int i, int i2, boolean z) {
        tryInitializeHandlerForReactRootView(i2);
        if (!this.registry.attachHandlerToView(i, i2, z)) {
            throw new JSApplicationIllegalArgumentException("Handler with tag " + i + " does not exists");
        }
    }

    @ReactMethod
    public final <T extends GestureHandler<T>> void updateGestureHandler(int i, ReadableMap readableMap) {
        HandlerFactory<T> findFactoryForHandler;
        Intrinsics.checkNotNullParameter(readableMap, "config");
        GestureHandler<?> handler = this.registry.getHandler(i);
        if (handler != null && (findFactoryForHandler = findFactoryForHandler(handler)) != null) {
            this.interactionManager.dropRelationsForHandlerWithTag(i);
            this.interactionManager.configureInteractions(handler, readableMap);
            findFactoryForHandler.configure(handler, readableMap);
        }
    }

    @ReactMethod
    public final void dropGestureHandler(int i) {
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        this.registry.dropHandler(i);
    }

    @ReactMethod
    public final void handleSetJSResponder(int i, boolean z) {
        RNGestureHandlerRootHelper findRootHelperForViewAncestor = findRootHelperForViewAncestor(i);
        if (findRootHelperForViewAncestor != null) {
            findRootHelperForViewAncestor.handleSetJSResponder(i, z);
        }
    }

    public void setGestureHandlerState(int i, int i2) {
        GestureHandler<?> handler = this.registry.getHandler(i);
        if (handler != null) {
            if (i2 == 1) {
                handler.fail();
            } else if (i2 == 2) {
                handler.begin();
            } else if (i2 == 3) {
                handler.cancel();
            } else if (i2 == 4) {
                handler.activate(true);
            } else if (i2 == 5) {
                handler.end();
            }
        }
    }

    public Map<String, Object> getConstants() {
        return MapsKt.mapOf(TuplesKt.m176to("State", MapsKt.mapOf(TuplesKt.m176to("UNDETERMINED", 0), TuplesKt.m176to("BEGAN", 2), TuplesKt.m176to("ACTIVE", 4), TuplesKt.m176to("CANCELLED", 3), TuplesKt.m176to("FAILED", 1), TuplesKt.m176to("END", 5))), TuplesKt.m176to("Direction", MapsKt.mapOf(TuplesKt.m176to("RIGHT", 1), TuplesKt.m176to("LEFT", 2), TuplesKt.m176to("UP", 4), TuplesKt.m176to("DOWN", 8))));
    }

    public void onCatalystInstanceDestroy() {
        this.registry.dropAllHandlers();
        this.interactionManager.reset();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                int size = this.roots.size();
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.roots.get(0);
                ViewGroup rootView = rNGestureHandlerRootHelper.getRootView();
                if (rootView instanceof RNGestureHandlerEnabledRootView) {
                    ((RNGestureHandlerEnabledRootView) rootView).tearDown();
                } else {
                    rNGestureHandlerRootHelper.tearDown();
                }
                if (this.roots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        super.onCatalystInstanceDestroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r6 = r5.enqueuedRootViewInit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        if (r5.enqueuedRootViewInit.contains(java.lang.Integer.valueOf(r1)) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.enqueuedRootViewInit.add(java.lang.Integer.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        r0.addUIBlock(new com.swmansion.gesturehandler.react.$$Lambda$RNGestureHandlerModule$rFBjKpHjubDBjol2teRu0H7hVU(r1, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void tryInitializeHandlerForReactRootView(int r6) {
        /*
            r5 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r5.getReactApplicationContext()
            java.lang.String r1 = "reactApplicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0
            com.facebook.react.uimanager.UIManagerModule r0 = com.swmansion.gesturehandler.ExtensionsKt.getUIManager(r0)
            int r1 = r0.resolveRootTagFromReactTag(r6)
            r2 = 1
            if (r1 < r2) goto L_0x006a
            java.util.List<com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper> r6 = r5.roots
            monitor-enter(r6)
            java.util.List<com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper> r2 = r5.roots     // Catch:{ all -> 0x0067 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0067 }
        L_0x001f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0067 }
            com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper r3 = (com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper) r3     // Catch:{ all -> 0x0067 }
            android.view.ViewGroup r3 = r3.getRootView()     // Catch:{ all -> 0x0067 }
            boolean r4 = r3 instanceof com.facebook.react.ReactRootView     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x001f
            com.facebook.react.ReactRootView r3 = (com.facebook.react.ReactRootView) r3     // Catch:{ all -> 0x0067 }
            int r3 = r3.getRootViewTag()     // Catch:{ all -> 0x0067 }
            if (r3 != r1) goto L_0x001f
            monitor-exit(r6)
            return
        L_0x003d:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0067 }
            monitor-exit(r6)
            java.util.List<java.lang.Integer> r6 = r5.enqueuedRootViewInit
            monitor-enter(r6)
            java.util.List<java.lang.Integer> r2 = r5.enqueuedRootViewInit     // Catch:{ all -> 0x0064 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0064 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0051
            monitor-exit(r6)
            return
        L_0x0051:
            java.util.List<java.lang.Integer> r2 = r5.enqueuedRootViewInit     // Catch:{ all -> 0x0064 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0064 }
            r2.add(r3)     // Catch:{ all -> 0x0064 }
            monitor-exit(r6)
            com.swmansion.gesturehandler.react.-$$Lambda$RNGestureHandlerModule$rFBjKp-HjubDBjol2teRu0H7hVU r6 = new com.swmansion.gesturehandler.react.-$$Lambda$RNGestureHandlerModule$rFBjKp-HjubDBjol2teRu0H7hVU
            r6.<init>(r1, r5)
            r0.addUIBlock(r6)
            return
        L_0x0064:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0067:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x006a:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r1 = "Could find root view for a given ancestor with tag "
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r6)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerModule.tryInitializeHandlerForReactRootView(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: tryInitializeHandlerForReactRootView$lambda-6  reason: not valid java name */
    public static final void m210tryInitializeHandlerForReactRootView$lambda6(int i, RNGestureHandlerModule rNGestureHandlerModule, NativeViewHierarchyManager nativeViewHierarchyManager) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerModule, "this$0");
        View resolveView = nativeViewHierarchyManager.resolveView(i);
        if (resolveView instanceof RNGestureHandlerEnabledRootView) {
            ((RNGestureHandlerEnabledRootView) resolveView).initialize();
        }
        synchronized (rNGestureHandlerModule.enqueuedRootViewInit) {
            rNGestureHandlerModule.enqueuedRootViewInit.remove(Integer.valueOf(i));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerRootHelper, "root");
        synchronized (this.roots) {
            if (!this.roots.contains(rNGestureHandlerRootHelper)) {
                this.roots.add(rNGestureHandlerRootHelper);
            } else {
                throw new IllegalStateException("Root helper" + rNGestureHandlerRootHelper + " already registered");
            }
        }
    }

    public final void unregisterRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerRootHelper, "root");
        synchronized (this.roots) {
            this.roots.remove(rNGestureHandlerRootHelper);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper findRootHelperForViewAncestor(int r8) {
        /*
            r7 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r7.getReactApplicationContext()
            java.lang.String r1 = "reactApplicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0
            com.facebook.react.uimanager.UIManagerModule r0 = com.swmansion.gesturehandler.ExtensionsKt.getUIManager(r0)
            int r8 = r0.resolveRootTagFromReactTag(r8)
            r0 = 0
            r1 = 1
            if (r8 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            java.util.List<com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper> r2 = r7.roots
            monitor-enter(r2)
            java.util.List<com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper> r3 = r7.roots     // Catch:{ all -> 0x004e }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x004e }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x004e }
        L_0x0023:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x004e }
            r5 = r4
            com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper r5 = (com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper) r5     // Catch:{ all -> 0x004e }
            android.view.ViewGroup r6 = r5.getRootView()     // Catch:{ all -> 0x004e }
            boolean r6 = r6 instanceof com.facebook.react.ReactRootView     // Catch:{ all -> 0x004e }
            if (r6 == 0) goto L_0x0046
            android.view.ViewGroup r5 = r5.getRootView()     // Catch:{ all -> 0x004e }
            com.facebook.react.ReactRootView r5 = (com.facebook.react.ReactRootView) r5     // Catch:{ all -> 0x004e }
            int r5 = r5.getRootViewTag()     // Catch:{ all -> 0x004e }
            if (r5 != r8) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            if (r5 == 0) goto L_0x0023
            r0 = r4
        L_0x004a:
            com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper r0 = (com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper) r0     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r0
        L_0x004e:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerModule.findRootHelperForViewAncestor(int):com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper");
    }

    private final <T extends GestureHandler<T>> HandlerFactory<T> findFactoryForHandler(GestureHandler<T> gestureHandler) {
        for (HandlerFactory<?> handlerFactory : this.handlerFactories) {
            if (Intrinsics.areEqual((Object) handlerFactory.getType(), (Object) gestureHandler.getClass())) {
                return handlerFactory;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onHandlerUpdate(T t, MotionEvent motionEvent) {
        if (t.getTag() >= 0 && t.getState() == 4) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(t);
            if (t.getUsesDeviceEvents()) {
                WritableMap createEventData = RNGestureHandlerEvent.Companion.createEventData(t, findFactoryForHandler);
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
                ExtensionsKt.getDeviceEventEmitter(reactApplicationContext).emit("onGestureHandlerEvent", createEventData);
                return;
            }
            ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "reactApplicationContext");
            ExtensionsKt.getUIManager(reactApplicationContext2).getEventDispatcher().dispatchEvent(RNGestureHandlerEvent.Companion.obtain(t, findFactoryForHandler));
        }
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onStateChange(T t, int i, int i2) {
        if (t.getTag() >= 0) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(t);
            if (t.getUsesDeviceEvents()) {
                WritableMap createEventData = RNGestureHandlerStateChangeEvent.Companion.createEventData(t, findFactoryForHandler, i, i2);
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
                ExtensionsKt.getDeviceEventEmitter(reactApplicationContext).emit(RNGestureHandlerStateChangeEvent.EVENT_NAME, createEventData);
                return;
            }
            ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "reactApplicationContext");
            ExtensionsKt.getUIManager(reactApplicationContext2).getEventDispatcher().dispatchEvent(RNGestureHandlerStateChangeEvent.Companion.obtain(t, i, i2, findFactoryForHandler));
        }
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onTouchEvent(T t) {
        if (t.getTag() >= 0) {
            if (t.getState() != 2 && t.getState() != 4 && t.getState() != 0 && t.getView() == null) {
                return;
            }
            if (t.getUsesDeviceEvents()) {
                WritableMap createEventData = RNGestureHandlerTouchEvent.Companion.createEventData(t);
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
                ExtensionsKt.getDeviceEventEmitter(reactApplicationContext).emit("onGestureHandlerEvent", createEventData);
                return;
            }
            ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "reactApplicationContext");
            ExtensionsKt.getUIManager(reactApplicationContext2).getEventDispatcher().dispatchEvent(RNGestureHandlerTouchEvent.Companion.obtain(t));
        }
    }

    @Metadata(mo24973d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010.\u001a\u00020/2\n\u00100\u001a\u0006\u0012\u0002\b\u0003012\u0006\u00102\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00064"}, mo24974d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$Companion;", "", "()V", "KEY_DIRECTION", "", "KEY_ENABLED", "KEY_HIT_SLOP", "KEY_HIT_SLOP_BOTTOM", "KEY_HIT_SLOP_HEIGHT", "KEY_HIT_SLOP_HORIZONTAL", "KEY_HIT_SLOP_LEFT", "KEY_HIT_SLOP_RIGHT", "KEY_HIT_SLOP_TOP", "KEY_HIT_SLOP_VERTICAL", "KEY_HIT_SLOP_WIDTH", "KEY_LONG_PRESS_MAX_DIST", "KEY_LONG_PRESS_MIN_DURATION_MS", "KEY_MANUAL_ACTIVATION", "KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION", "KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START", "KEY_NEEDS_POINTER_DATA", "KEY_NUMBER_OF_POINTERS", "KEY_PAN_ACTIVE_OFFSET_X_END", "KEY_PAN_ACTIVE_OFFSET_X_START", "KEY_PAN_ACTIVE_OFFSET_Y_END", "KEY_PAN_ACTIVE_OFFSET_Y_START", "KEY_PAN_AVG_TOUCHES", "KEY_PAN_FAIL_OFFSET_RANGE_X_END", "KEY_PAN_FAIL_OFFSET_RANGE_X_START", "KEY_PAN_FAIL_OFFSET_RANGE_Y_END", "KEY_PAN_FAIL_OFFSET_RANGE_Y_START", "KEY_PAN_MAX_POINTERS", "KEY_PAN_MIN_DIST", "KEY_PAN_MIN_POINTERS", "KEY_PAN_MIN_VELOCITY", "KEY_PAN_MIN_VELOCITY_X", "KEY_PAN_MIN_VELOCITY_Y", "KEY_SHOULD_CANCEL_WHEN_OUTSIDE", "KEY_TAP_MAX_DELAY_MS", "KEY_TAP_MAX_DELTA_X", "KEY_TAP_MAX_DELTA_Y", "KEY_TAP_MAX_DIST", "KEY_TAP_MAX_DURATION_MS", "KEY_TAP_MIN_POINTERS", "KEY_TAP_NUMBER_OF_TAPS", "MODULE_NAME", "handleHitSlopProperty", "", "handler", "Lcom/swmansion/gesturehandler/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-gesture-handler_release"}, mo24975k = 1, mo24976mv = {1, 5, 1}, mo24978xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void handleHitSlopProperty(GestureHandler<?> gestureHandler, ReadableMap readableMap) {
            float f;
            float f2;
            float f3;
            float f4;
            if (readableMap.getType(RNGestureHandlerModule.KEY_HIT_SLOP) == ReadableType.Number) {
                float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP));
                gestureHandler.setHitSlop(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
                return;
            }
            ReadableMap map = readableMap.getMap(RNGestureHandlerModule.KEY_HIT_SLOP);
            Intrinsics.checkNotNull(map);
            Intrinsics.checkNotNullExpressionValue(map, "config.getMap(KEY_HIT_SLOP)!!");
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL)) {
                f2 = PixelUtil.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL));
                f = f2;
            } else {
                f2 = Float.NaN;
                f = Float.NaN;
            }
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL)) {
                f4 = PixelUtil.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL));
                f3 = f4;
            } else {
                f4 = Float.NaN;
                f3 = Float.NaN;
            }
            if (map.hasKey("left")) {
                f2 = PixelUtil.toPixelFromDIP(map.getDouble("left"));
            }
            float f5 = f2;
            if (map.hasKey("top")) {
                f4 = PixelUtil.toPixelFromDIP(map.getDouble("top"));
            }
            float f6 = f4;
            if (map.hasKey("right")) {
                f = PixelUtil.toPixelFromDIP(map.getDouble("right"));
            }
            float f7 = f;
            if (map.hasKey("bottom")) {
                f3 = PixelUtil.toPixelFromDIP(map.getDouble("bottom"));
            }
            gestureHandler.setHitSlop(f5, f6, f7, f3, map.hasKey("width") ? PixelUtil.toPixelFromDIP(map.getDouble("width")) : Float.NaN, map.hasKey("height") ? PixelUtil.toPixelFromDIP(map.getDouble("height")) : Float.NaN);
        }
    }
}
