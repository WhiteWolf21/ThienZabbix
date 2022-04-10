package br.dev.kuhn.handyzabbix.expo.modules.adapters.reanimated;

import android.content.Context;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.EXReanimatedAdapter;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.util.Collections;
import java.util.List;

public class EXReanimatedPackage implements Package {
    public /* synthetic */ List createApplicationLifecycleListeners(Context context) {
        return Package.CC.$default$createApplicationLifecycleListeners(this, context);
    }

    public /* synthetic */ List createExportedModules(Context context) {
        return Package.CC.$default$createExportedModules(this, context);
    }

    public /* synthetic */ List createInternalModules(Context context) {
        return Package.CC.$default$createInternalModules(this, context);
    }

    public /* synthetic */ List createReactActivityHandlers(Context context) {
        return Package.CC.$default$createReactActivityHandlers(this, context);
    }

    public /* synthetic */ List createReactActivityLifecycleListeners(Context context) {
        return Package.CC.$default$createReactActivityLifecycleListeners(this, context);
    }

    public /* synthetic */ List createSingletonModules(Context context) {
        return Package.CC.$default$createSingletonModules(this, context);
    }

    public /* synthetic */ List createViewManagers(Context context) {
        return Package.CC.$default$createViewManagers(this, context);
    }

    public List<? extends ReactNativeHostHandler> createReactNativeHostHandlers(Context context) {
        return Collections.singletonList(new ReactNativeHostHandler() {
            public /* synthetic */ ReactInstanceManager createReactInstanceManager(boolean z) {
                return ReactNativeHostHandler.CC.$default$createReactInstanceManager(this, z);
            }

            public /* synthetic */ String getBundleAssetName(boolean z) {
                return ReactNativeHostHandler.CC.$default$getBundleAssetName(this, z);
            }

            public /* synthetic */ String getJSBundleFile(boolean z) {
                return ReactNativeHostHandler.CC.$default$getJSBundleFile(this, z);
            }

            public /* synthetic */ void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager, boolean z) {
                ReactNativeHostHandler.CC.$default$onDidCreateReactInstanceManager(this, reactInstanceManager, z);
            }

            public /* synthetic */ void onWillCreateReactInstanceManager(boolean z) {
                ReactNativeHostHandler.CC.$default$onWillCreateReactInstanceManager(this, z);
            }

            public void onRegisterJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, boolean z) {
                EXReanimatedAdapter.registerJSIModules(reactApplicationContext, javaScriptContextHolder);
            }
        });
    }
}
