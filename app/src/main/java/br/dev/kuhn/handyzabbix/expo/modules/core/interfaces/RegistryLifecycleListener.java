package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

import br.dev.kuhn.handyzabbix.expo.modules.core.ModuleRegistry;

public interface RegistryLifecycleListener {

    /* renamed from: expo.modules.core.interfaces.RegistryLifecycleListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCreate(RegistryLifecycleListener registryLifecycleListener, ModuleRegistry moduleRegistry) {
        }

        public static void $default$onDestroy(RegistryLifecycleListener registryLifecycleListener) {
        }
    }

    void onCreate(ModuleRegistry moduleRegistry);

    void onDestroy();
}
