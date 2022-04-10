package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public interface ReactActivityLifecycleListener {

    /* renamed from: expo.modules.core.interfaces.ReactActivityLifecycleListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$onBackPressed(ReactActivityLifecycleListener reactActivityLifecycleListener) {
            return false;
        }

        public static void $default$onCreate(ReactActivityLifecycleListener reactActivityLifecycleListener, Activity activity, Bundle bundle) {
        }

        public static void $default$onDestroy(ReactActivityLifecycleListener reactActivityLifecycleListener, Activity activity) {
        }

        public static boolean $default$onNewIntent(ReactActivityLifecycleListener reactActivityLifecycleListener, Intent intent) {
            return false;
        }

        public static void $default$onPause(ReactActivityLifecycleListener reactActivityLifecycleListener, Activity activity) {
        }

        public static void $default$onResume(ReactActivityLifecycleListener reactActivityLifecycleListener, Activity activity) {
        }
    }

    boolean onBackPressed();

    void onCreate(Activity activity, Bundle bundle);

    void onDestroy(Activity activity);

    boolean onNewIntent(Intent intent);

    void onPause(Activity activity);

    void onResume(Activity activity);
}
