package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

import android.app.Application;
import android.content.res.Configuration;

public interface ApplicationLifecycleListener {

    /* renamed from: expo.modules.core.interfaces.ApplicationLifecycleListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onConfigurationChanged(ApplicationLifecycleListener applicationLifecycleListener, Configuration configuration) {
        }

        public static void $default$onCreate(ApplicationLifecycleListener applicationLifecycleListener, Application application) {
        }
    }

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Application application);
}
