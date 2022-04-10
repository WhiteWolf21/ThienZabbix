package br.dev.kuhn.handyzabbix.com.facebook.react.bridge;

import android.app.Activity;
import com.facebook.infer.annotation.Assertions;

public abstract class ReactContextBaseJavaModule extends com.facebook.react.bridge.BaseJavaModule {
    private final ReactApplicationContext mReactApplicationContext;

    public ReactContextBaseJavaModule(br.dev.kuhn.handyzabbix.com.facebook.react.bridge.ReactApplicationContext paramReactApplicationContext) {
        this.mReactApplicationContext = null;
    }

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContext() {
        return (ReactApplicationContext) Assertions.assertNotNull(this.mReactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveCatalystInstance() || this.mReactApplicationContext.isBridgeless()) {
            return this.mReactApplicationContext;
        }
        com.facebook.react.bridge.ReactSoftException.logSoftException("ReactContextBaseJavaModule", new RuntimeException("Catalyst Instance has already disappeared: requested by " + getName()));
        return null;
    }

    /* access modifiers changed from: protected */
    public final Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }
}
