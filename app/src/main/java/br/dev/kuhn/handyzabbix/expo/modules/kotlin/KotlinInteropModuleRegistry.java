package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ViewManager;
import expo.modules.kotlin.methods.AnyMethod;
import expo.modules.kotlin.views.GroupViewManagerWrapper;
import expo.modules.kotlin.views.SimpleViewManagerWrapper;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerWrapperDelegate;
import expo.modules.kotlin.views.ViewWrapperDelegateHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018Jb\u0010\u0019\u001a*\u0012\b\u0012\u00060\u0013j\u0002`\u001b\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aj\u0002`\u001d0\u001c0\u001a22\b\u0002\u0010\u001e\u001a,\u0012\u0004\u0012\u00020\u0013\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aj\u0002`\u001d0\u001c\u0012\u0004\u0012\u00020\u00110\u001fJ\u0014\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0\u001cJ(\u0010\"\u001a$\u0012\b\u0012\u00060\u0013j\u0002`\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aj\u0002`#0\u001aJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cJ\"\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001c2\u0014\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0\u001cJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0011J\u0014\u0010,\u001a\u00020\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006."}, mo24974d2 = {"Lexpo/modules/kotlin/KotlinInteropModuleRegistry;", "", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "callMethod", "", "moduleName", "", "method", "arguments", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "exportMethods", "", "Lexpo/modules/kotlin/ModuleName;", "", "Lexpo/modules/kotlin/ModuleMethodInfo;", "exportKey", "Lkotlin/Function2;", "exportViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "exportedModulesConstants", "Lexpo/modules/kotlin/ModuleConstants;", "exportedViewManagersNames", "extractViewManagersDelegateHolders", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewManagers", "hasModule", "", "name", "onDestroy", "updateModuleHoldersInViewManagers", "viewWrapperHolders", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: KotlinInteropModuleRegistry.kt */
public final class KotlinInteropModuleRegistry {
    private final AppContext appContext;

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewManager.ViewManagerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ViewManager.ViewManagerType.SIMPLE.ordinal()] = 1;
            iArr[ViewManager.ViewManagerType.GROUP.ordinal()] = 2;
        }
    }

    public KotlinInteropModuleRegistry(ModulesProvider modulesProvider, ModuleRegistry moduleRegistry, WeakReference<ReactApplicationContext> weakReference) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(moduleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(weakReference, "reactContext");
        this.appContext = new AppContext(modulesProvider, moduleRegistry, weakReference);
    }

    private final ModuleRegistry getRegistry() {
        return this.appContext.getRegistry();
    }

    public final boolean hasModule(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return getRegistry().hasModule(str);
    }

    public final void callMethod(String str, String str2, ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "moduleName");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(readableArray, "arguments");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ModuleHolder moduleHolder = getRegistry().getModuleHolder(str);
        if (moduleHolder != null) {
            moduleHolder.call(str2, readableArray, promise);
        }
    }

    public final Map<String, Map<String, Object>> exportedModulesConstants() {
        Iterable<ModuleHolder> registry = getRegistry();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(registry, 10));
        for (ModuleHolder moduleHolder : registry) {
            arrayList.add(TuplesKt.m176to(moduleHolder.getName(), moduleHolder.getDefinition().getConstantsProvider().invoke()));
        }
        return MapsKt.toMap((List) arrayList);
    }

    public static /* synthetic */ Map exportMethods$default(KotlinInteropModuleRegistry kotlinInteropModuleRegistry, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = KotlinInteropModuleRegistry$exportMethods$1.INSTANCE;
        }
        return kotlinInteropModuleRegistry.exportMethods(function2);
    }

    public final Map<String, List<Map<String, Object>>> exportMethods(Function2<? super String, ? super List<? extends Map<String, ? extends Object>>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "exportKey");
        Iterable<ModuleHolder> registry = getRegistry();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(registry, 10));
        for (ModuleHolder moduleHolder : registry) {
            Map<String, AnyMethod> methods = moduleHolder.getDefinition().getMethods();
            Collection arrayList2 = new ArrayList(methods.size());
            for (Map.Entry next : methods.entrySet()) {
                arrayList2.add(MapsKt.mapOf(TuplesKt.m176to("name", (String) next.getKey()), TuplesKt.m176to("argumentsCount", Integer.valueOf(((AnyMethod) next.getValue()).getArgsCount()))));
            }
            List list = (List) arrayList2;
            function2.invoke(moduleHolder.getName(), list);
            arrayList.add(TuplesKt.m176to(moduleHolder.getName(), list));
        }
        return MapsKt.toMap((List) arrayList);
    }

    public final List<com.facebook.react.uimanager.ViewManager<?, ?>> exportViewManagers() {
        com.facebook.react.uimanager.ViewManager viewManager;
        Collection arrayList = new ArrayList();
        Iterator it = getRegistry().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ModuleHolder) next).getDefinition().getViewManagerDefinition() == null) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterable<ModuleHolder> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ModuleHolder moduleHolder : iterable) {
            ViewManagerWrapperDelegate viewManagerWrapperDelegate = new ViewManagerWrapperDelegate(moduleHolder);
            ViewManagerDefinition viewManagerDefinition = moduleHolder.getDefinition().getViewManagerDefinition();
            Intrinsics.checkNotNull(viewManagerDefinition);
            int i = WhenMappings.$EnumSwitchMapping$0[viewManagerDefinition.getViewManagerType().ordinal()];
            if (i == 1) {
                viewManager = new SimpleViewManagerWrapper(viewManagerWrapperDelegate);
            } else if (i == 2) {
                viewManager = new GroupViewManagerWrapper(viewManagerWrapperDelegate);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList2.add(viewManager);
        }
        return (List) arrayList2;
    }

    public final List<ViewWrapperDelegateHolder> extractViewManagersDelegateHolders(List<? extends com.facebook.react.uimanager.ViewManager<?, ?>> list) {
        Intrinsics.checkNotNullParameter(list, "viewManagers");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof ViewWrapperDelegateHolder) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void updateModuleHoldersInViewManagers(List<? extends ViewWrapperDelegateHolder> list) {
        Intrinsics.checkNotNullParameter(list, "viewWrapperHolders");
        Iterable<ViewWrapperDelegateHolder> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ViewWrapperDelegateHolder viewWrapperDelegate : iterable) {
            arrayList.add(viewWrapperDelegate.getViewWrapperDelegate());
        }
        for (ViewManagerWrapperDelegate viewManagerWrapperDelegate : (List) arrayList) {
            ModuleHolder moduleHolder = getRegistry().getModuleHolder(viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName());
            if (moduleHolder != null) {
                viewManagerWrapperDelegate.setModuleHolder$expo_modules_core_release(moduleHolder);
            } else {
                throw new IllegalArgumentException(("Cannot update the module holder for " + viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName() + FilenameUtils.EXTENSION_SEPARATOR).toString());
            }
        }
    }

    public final List<String> exportedViewManagersNames() {
        Collection arrayList = new ArrayList();
        for (Object next : getRegistry()) {
            if (((ModuleHolder) next).getDefinition().getViewManagerDefinition() != null) {
                arrayList.add(next);
            }
        }
        Iterable<ModuleHolder> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ModuleHolder definition : iterable) {
            arrayList2.add(definition.getDefinition().getName());
        }
        return (List) arrayList2;
    }

    public final void onDestroy() {
        this.appContext.onDestroy();
    }
}
