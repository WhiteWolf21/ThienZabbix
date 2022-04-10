package br.dev.kuhn.handyzabbix.expo.modules.adapters.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.adapters.react.views.SimpleViewManagerAdapter;
import expo.modules.adapters.react.views.ViewGroupManagerAdapter;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.kotlin.KotlinInteropModuleRegistry;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.views.ViewWrapperDelegateHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuleRegistryAdapter implements ReactPackage {
    protected ReactModuleRegistryProvider mModuleRegistryProvider;
    protected ModulesProvider mModulesProvider;
    private NativeModulesProxy mModulesProxy;
    protected ReactAdapterPackage mReactAdapterPackage = new ReactAdapterPackage();
    private List<ViewWrapperDelegateHolder> mWrapperDelegateHolders = null;

    public ModuleRegistryAdapter(List<Package> list) {
        this.mModuleRegistryProvider = new ReactModuleRegistryProvider(list, (List<SingletonModule>) null);
    }

    public ModuleRegistryAdapter(ReactModuleRegistryProvider reactModuleRegistryProvider) {
        this.mModuleRegistryProvider = reactModuleRegistryProvider;
    }

    public ModuleRegistryAdapter(ReactModuleRegistryProvider reactModuleRegistryProvider, ModulesProvider modulesProvider) {
        this.mModuleRegistryProvider = reactModuleRegistryProvider;
        this.mModulesProvider = modulesProvider;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ModuleRegistry moduleRegistry = this.mModuleRegistryProvider.get(reactApplicationContext);
        for (InternalModule registerInternalModule : this.mReactAdapterPackage.createInternalModules(reactApplicationContext)) {
            moduleRegistry.registerInternalModule(registerInternalModule);
        }
        List<NativeModule> nativeModulesFromModuleRegistry = getNativeModulesFromModuleRegistry(reactApplicationContext, moduleRegistry);
        if (this.mWrapperDelegateHolders != null) {
            this.mModulesProxy.getKotlinInteropModuleRegistry().updateModuleHoldersInViewManagers(this.mWrapperDelegateHolders);
        }
        return nativeModulesFromModuleRegistry;
    }

    /* access modifiers changed from: protected */
    public List<NativeModule> getNativeModulesFromModuleRegistry(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry) {
        ArrayList arrayList = new ArrayList(2);
        NativeModulesProxy createNativeModulesProxy = createNativeModulesProxy(reactApplicationContext, moduleRegistry);
        this.mModulesProxy = createNativeModulesProxy;
        arrayList.add(createNativeModulesProxy);
        arrayList.add(new ModuleRegistryReadyNotifier(moduleRegistry));
        for (ReactPackage createNativeModules : ((ReactPackagesProvider) moduleRegistry.getModule(ReactPackagesProvider.class)).getReactPackages()) {
            arrayList.addAll(createNativeModules.createNativeModules(reactApplicationContext));
        }
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList(this.mModuleRegistryProvider.getReactViewManagers(reactApplicationContext));
        for (expo.modules.core.ViewManager next : this.mModuleRegistryProvider.getViewManagers(reactApplicationContext)) {
            int i = C16881.$SwitchMap$expo$modules$core$ViewManager$ViewManagerType[next.getViewManagerType().ordinal()];
            if (i == 1) {
                arrayList.add(new ViewGroupManagerAdapter(next));
            } else if (i == 2) {
                arrayList.add(new SimpleViewManagerAdapter(next));
            }
        }
        NativeModulesProxy nativeModulesProxy = this.mModulesProxy;
        Objects.requireNonNull(nativeModulesProxy);
        KotlinInteropModuleRegistry kotlinInteropModuleRegistry = nativeModulesProxy.getKotlinInteropModuleRegistry();
        List<ViewManager<?, ?>> exportViewManagers = kotlinInteropModuleRegistry.exportViewManagers();
        this.mWrapperDelegateHolders = kotlinInteropModuleRegistry.extractViewManagersDelegateHolders(exportViewManagers);
        arrayList.addAll(exportViewManagers);
        return arrayList;
    }

    /* renamed from: expo.modules.adapters.react.ModuleRegistryAdapter$1 */
    static /* synthetic */ class C16881 {
        static final /* synthetic */ int[] $SwitchMap$expo$modules$core$ViewManager$ViewManagerType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                expo.modules.core.ViewManager$ViewManagerType[] r0 = expo.modules.core.ViewManager.ViewManagerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$expo$modules$core$ViewManager$ViewManagerType = r0
                expo.modules.core.ViewManager$ViewManagerType r1 = expo.modules.core.ViewManager.ViewManagerType.GROUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$expo$modules$core$ViewManager$ViewManagerType     // Catch:{ NoSuchFieldError -> 0x001d }
                expo.modules.core.ViewManager$ViewManagerType r1 = expo.modules.core.ViewManager.ViewManagerType.SIMPLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.adapters.react.ModuleRegistryAdapter.C16881.<clinit>():void");
        }
    }

    private NativeModulesProxy createNativeModulesProxy(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry) {
        ModulesProvider modulesProvider = this.mModulesProvider;
        if (modulesProvider != null) {
            return new NativeModulesProxy(reactApplicationContext, moduleRegistry, modulesProvider);
        }
        return new NativeModulesProxy(reactApplicationContext, moduleRegistry);
    }
}
