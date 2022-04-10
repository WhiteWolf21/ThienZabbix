package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J!\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u0002H\u0017¢\u0006\u0002\u0010\u0019J/\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u0002H\u00172\u0006\u0010\u001b\u001a\u0002H\u001a¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo24974d2 = {"Lexpo/modules/kotlin/ModuleRegistry;", "", "Lexpo/modules/kotlin/ModuleHolder;", "appContext", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/ref/WeakReference;)V", "registry", "", "", "getModule", "Lexpo/modules/kotlin/modules/Module;", "name", "getModuleHolder", "module", "hasModule", "", "iterator", "", "post", "", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "register", "provider", "Lexpo/modules/kotlin/ModulesProvider;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ModuleRegistry.kt */
public final class ModuleRegistry implements Iterable<ModuleHolder>, KMappedMarker {
    private final WeakReference<AppContext> appContext;
    private final Map<String, ModuleHolder> registry = new LinkedHashMap();

    public ModuleRegistry(WeakReference<AppContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "appContext");
        this.appContext = weakReference;
    }

    public final void register(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        ModuleHolder moduleHolder = new ModuleHolder(module);
        Object obj = this.appContext.get();
        if (obj != null) {
            module.set_appContext$expo_modules_core_release((AppContext) obj);
            moduleHolder.post(EventName.MODULE_CREATE);
            this.registry.put(moduleHolder.getName(), moduleHolder);
            return;
        }
        throw new IllegalArgumentException("Cannot create a module for invalid app context.".toString());
    }

    public final ModuleRegistry register(ModulesProvider modulesProvider) {
        Intrinsics.checkNotNullParameter(modulesProvider, "provider");
        ModuleRegistry moduleRegistry = this;
        for (Class newInstance : modulesProvider.getModulesList()) {
            Module module = (Module) newInstance.newInstance();
            Intrinsics.checkNotNullExpressionValue(module, "module");
            moduleRegistry.register(module);
        }
        return moduleRegistry;
    }

    public final boolean hasModule(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.registry.containsKey(str);
    }

    public final Module getModule(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ModuleHolder moduleHolder = this.registry.get(str);
        if (moduleHolder != null) {
            return moduleHolder.getModule();
        }
        return null;
    }

    public final ModuleHolder getModuleHolder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.registry.get(str);
    }

    public final ModuleHolder getModuleHolder(Module module) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(module, "module");
        Iterator it = this.registry.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ModuleHolder) obj).getModule() == module) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (ModuleHolder) obj;
    }

    public Iterator<ModuleHolder> iterator() {
        return this.registry.values().iterator();
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName);
        }
    }

    public final <Sender> void post(EventName eventName, Sender sender) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, sender);
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, sender, payload);
        }
    }
}
