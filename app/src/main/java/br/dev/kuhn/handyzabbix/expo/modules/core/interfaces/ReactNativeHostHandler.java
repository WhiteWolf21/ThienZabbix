package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;

public interface ReactNativeHostHandler {

    /* renamed from: expo.modules.core.interfaces.ReactNativeHostHandler$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ReactInstanceManager $default$createReactInstanceManager(ReactNativeHostHandler reactNativeHostHandler, boolean z) {
            return null;
        }

        public static String $default$getBundleAssetName(ReactNativeHostHandler reactNativeHostHandler, boolean z) {
            return null;
        }

        public static String $default$getJSBundleFile(ReactNativeHostHandler reactNativeHostHandler, boolean z) {
            return null;
        }

        public static void $default$onDidCreateReactInstanceManager(ReactNativeHostHandler reactNativeHostHandler, ReactInstanceManager reactInstanceManager, boolean z) {
        }

        public static void $default$onRegisterJSIModules(ReactNativeHostHandler reactNativeHostHandler, ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, boolean z) {
        }

        public static void $default$onWillCreateReactInstanceManager(ReactNativeHostHandler reactNativeHostHandler, boolean z) {
        }
    }

    ReactInstanceManager createReactInstanceManager(boolean z);

    String getBundleAssetName(boolean z);

    String getJSBundleFile(boolean z);

    void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager, boolean z);

    void onRegisterJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, boolean z);

    void onWillCreateReactInstanceManager(boolean z);
}
