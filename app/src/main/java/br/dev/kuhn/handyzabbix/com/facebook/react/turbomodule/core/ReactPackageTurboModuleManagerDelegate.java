package com.facebook.react.turbomodule.core;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactPackage;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.List;

public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {
    private final List<TurboReactPackage> mPackages = new ArrayList();
    private final ReactApplicationContext mReactApplicationContext;

    protected ReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        this.mReactApplicationContext = reactApplicationContext;
        for (ReactPackage next : list) {
            if (next instanceof TurboReactPackage) {
                this.mPackages.add((TurboReactPackage) next);
            }
        }
    }

    public TurboModule getModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && !(resolveModule instanceof CxxModuleWrapper)) {
            return resolveModule;
        }
        return null;
    }

    public CxxModuleWrapper getLegacyCxxModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && (resolveModule instanceof CxxModuleWrapper)) {
            return (CxxModuleWrapper) resolveModule;
        }
        return null;
    }

    private TurboModule resolveModule(String str) {
        NativeModule nativeModule = null;
        for (TurboReactPackage module : this.mPackages) {
            try {
                NativeModule module2 = module.getModule(str, this.mReactApplicationContext);
                if (nativeModule == null || (module2 != null && module2.canOverrideExistingModule())) {
                    nativeModule = module2;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (nativeModule instanceof TurboModule) {
            return (TurboModule) nativeModule;
        }
        return null;
    }

    public List<String> getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        for (TurboReactPackage reactModuleInfoProvider : this.mPackages) {
            for (ReactModuleInfo next : reactModuleInfoProvider.getReactModuleInfoProvider().getReactModuleInfos().values()) {
                if (next.isTurboModule() && next.needsEagerInit()) {
                    arrayList.add(next.name());
                }
            }
        }
        return arrayList;
    }

    public static abstract class Builder {
        private ReactApplicationContext mContext;
        private List<ReactPackage> mPackages;

        /* access modifiers changed from: protected */
        public abstract ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list);

        public Builder setPackages(List<ReactPackage> list) {
            this.mPackages = new ArrayList(list);
            return this;
        }

        public Builder setReactApplicationContext(ReactApplicationContext reactApplicationContext) {
            this.mContext = reactApplicationContext;
            return this;
        }

        public ReactPackageTurboModuleManagerDelegate build() {
            Assertions.assertNotNull(this.mContext, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            Assertions.assertNotNull(this.mPackages, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return build(this.mContext, this.mPackages);
        }
    }
}
