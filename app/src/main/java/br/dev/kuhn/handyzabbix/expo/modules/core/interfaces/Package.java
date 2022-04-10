package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

import android.content.Context;
import br.dev.kuhn.handyzabbix.expo.modules.core.ExportedModule;
import br.dev.kuhn.handyzabbix.expo.modules.core.ViewManager;
import java.util.Collections;
import java.util.List;

public interface Package {
    List<? extends ApplicationLifecycleListener> createApplicationLifecycleListeners(Context context);

    List<? extends ExportedModule> createExportedModules(Context context);

    List<? extends InternalModule> createInternalModules(Context context);

    List<? extends ReactActivityHandler> createReactActivityHandlers(Context context);

    List<? extends ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context context);

    List<? extends ReactNativeHostHandler> createReactNativeHostHandlers(Context context);

    List<? extends SingletonModule> createSingletonModules(Context context);

    List<? extends ViewManager> createViewManagers(Context context);

    /* renamed from: expo.modules.core.interfaces.Package$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$createInternalModules(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createExportedModules(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createViewManagers(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createSingletonModules(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createApplicationLifecycleListeners(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createReactNativeHostHandlers(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createReactActivityLifecycleListeners(Package _this, Context context) {
            return Collections.emptyList();
        }

        public static List $default$createReactActivityHandlers(Package _this, Context context) {
            return Collections.emptyList();
        }
    }
}
