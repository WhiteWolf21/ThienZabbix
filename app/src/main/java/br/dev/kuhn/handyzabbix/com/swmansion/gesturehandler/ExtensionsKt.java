package com.swmansion.gesturehandler;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24973d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo24974d2 = {"UIManager", "Lcom/facebook/react/uimanager/UIManagerModule;", "Lcom/facebook/react/bridge/ReactContext;", "getUIManager", "(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/uimanager/UIManagerModule;", "deviceEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "getDeviceEventEmitter", "(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "react-native-gesture-handler_release"}, mo24975k = 2, mo24976mv = {1, 5, 1}, mo24978xi = 48)
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        JavaScriptModule jSModule = reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        Intrinsics.checkNotNullExpressionValue(jSModule, "this.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)");
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
    }

    public static final UIManagerModule getUIManager(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        NativeModule nativeModule = reactContext.getNativeModule(UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        Intrinsics.checkNotNullExpressionValue(nativeModule, "this.getNativeModule(UIManagerModule::class.java)!!");
        return (UIManagerModule) nativeModule;
    }
}
