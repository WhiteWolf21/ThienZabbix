package br.dev.kuhn.handyzabbix.expo.modules;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\bH\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001b\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\u0006\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0002\u0010#R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo24974d2 = {"Lexpo/modules/ReactNativeHostWrapper;", "Lcom/facebook/react/ReactNativeHost;", "application", "Landroid/app/Application;", "host", "(Landroid/app/Application;Lcom/facebook/react/ReactNativeHost;)V", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactNativeHostHandlers", "", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "createReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getBundleAssetName", "getJSBundleFile", "getJSIModulePackage", "Lcom/facebook/react/bridge/JSIModulePackage;", "getJSMainModuleName", "getJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "getPackages", "", "Lcom/facebook/react/ReactPackage;", "getRedBoxHandler", "Lcom/facebook/react/devsupport/RedBoxHandler;", "getUIImplementationProvider", "Lcom/facebook/react/uimanager/UIImplementationProvider;", "getUseDeveloperSupport", "", "invokeDelegateMethod", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "JSIModuleContainerPackage", "expo_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ReactNativeHostWrapper.kt */
public final class ReactNativeHostWrapper extends ReactNativeHost {
    private final ReactNativeHost host;
    private final ArrayMap<String, Method> methodMap;
    /* access modifiers changed from: private */
    public final List<ReactNativeHostHandler> reactNativeHostHandlers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactNativeHostWrapper(Application application, ReactNativeHost reactNativeHost) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(reactNativeHost, "host");
        this.host = reactNativeHost;
        Collection arrayList = new ArrayList();
        for (Package createReactNativeHostHandlers : ExpoModulesPackage.Companion.getPackageList()) {
            CollectionsKt.addAll(arrayList, createReactNativeHostHandlers.createReactNativeHostHandlers(application));
        }
        this.reactNativeHostHandlers = (List) arrayList;
        this.methodMap = new ArrayMap<>();
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager createReactInstanceManager() {
        boolean useDeveloperSupport = getUseDeveloperSupport();
        for (ReactNativeHostHandler onWillCreateReactInstanceManager : this.reactNativeHostHandlers) {
            onWillCreateReactInstanceManager.onWillCreateReactInstanceManager(useDeveloperSupport);
        }
        ReactInstanceManager reactInstanceManager = (ReactInstanceManager) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapper$createReactInstanceManager$result$1(useDeveloperSupport)));
        if (reactInstanceManager == null) {
            reactInstanceManager = super.createReactInstanceManager();
        }
        for (ReactNativeHostHandler onDidCreateReactInstanceManager : this.reactNativeHostHandlers) {
            onDidCreateReactInstanceManager.onDidCreateReactInstanceManager(reactInstanceManager, useDeveloperSupport);
        }
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "result");
        return reactInstanceManager;
    }

    /* access modifiers changed from: protected */
    public RedBoxHandler getRedBoxHandler() {
        return (RedBoxHandler) invokeDelegateMethod("getRedBoxHandler");
    }

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return (JavaScriptExecutorFactory) invokeDelegateMethod("getJavaScriptExecutorFactory");
    }

    /* access modifiers changed from: protected */
    public UIImplementationProvider getUIImplementationProvider() {
        return (UIImplementationProvider) invokeDelegateMethod("getUIImplementationProvider");
    }

    /* access modifiers changed from: protected */
    public JSIModulePackage getJSIModulePackage() {
        return new JSIModuleContainerPackage((JSIModulePackage) invokeDelegateMethod("getJSIModulePackage"));
    }

    /* access modifiers changed from: protected */
    public String getJSMainModuleName() {
        return (String) invokeDelegateMethod("getJSMainModuleName");
    }

    /* access modifiers changed from: protected */
    public String getJSBundleFile() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapper$getJSBundleFile$1(this)));
        return str != null ? str : (String) invokeDelegateMethod("getJSBundleFile");
    }

    /* access modifiers changed from: protected */
    public String getBundleAssetName() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapper$getBundleAssetName$1(this)));
        return str != null ? str : (String) invokeDelegateMethod("getBundleAssetName");
    }

    public boolean getUseDeveloperSupport() {
        return this.host.getUseDeveloperSupport();
    }

    /* access modifiers changed from: protected */
    public List<ReactPackage> getPackages() {
        return (List) invokeDelegateMethod("getPackages");
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo24974d2 = {"Lexpo/modules/ReactNativeHostWrapper$JSIModuleContainerPackage;", "Lcom/facebook/react/bridge/JSIModulePackage;", "userJSIModulePackage", "(Lexpo/modules/ReactNativeHostWrapper;Lcom/facebook/react/bridge/JSIModulePackage;)V", "getJSIModules", "", "Lcom/facebook/react/bridge/JSIModuleSpec;", "Lcom/facebook/react/bridge/JSIModule;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "jsContext", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "expo_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: ReactNativeHostWrapper.kt */
    public final class JSIModuleContainerPackage implements JSIModulePackage {
        private final JSIModulePackage userJSIModulePackage;

        public JSIModuleContainerPackage(JSIModulePackage jSIModulePackage) {
            this.userJSIModulePackage = jSIModulePackage;
        }

        public List<JSIModuleSpec<JSIModule>> getJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder) {
            Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
            Intrinsics.checkNotNullParameter(javaScriptContextHolder, "jsContext");
            for (ReactNativeHostHandler onRegisterJSIModules : ReactNativeHostWrapper.this.reactNativeHostHandlers) {
                onRegisterJSIModules.onRegisterJSIModules(reactApplicationContext, javaScriptContextHolder, ReactNativeHostWrapper.this.getUseDeveloperSupport());
            }
            JSIModulePackage jSIModulePackage = this.userJSIModulePackage;
            if (jSIModulePackage != null) {
                jSIModulePackage.getJSIModules(reactApplicationContext, javaScriptContextHolder);
            }
            return CollectionsKt.emptyList();
        }
    }

    private final <T> T invokeDelegateMethod(String str) {
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactNativeHost.class.getDeclaredMethod(str, new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        return method.invoke(this.host, new Object[0]);
    }
}
