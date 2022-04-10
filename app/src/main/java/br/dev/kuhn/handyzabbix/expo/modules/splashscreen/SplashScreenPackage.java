package br.dev.kuhn.handyzabbix.expo.modules.splashscreen;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.ExportedModule;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.splashscreen.singletons.SplashScreen;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, mo24974d2 = {"Lexpo/modules/splashscreen/SplashScreenPackage;", "Lexpo/modules/core/BasePackage;", "()V", "createExportedModules", "", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "createReactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "createSingletonModules", "Lexpo/modules/core/interfaces/SingletonModule;", "expo-splash-screen_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: SplashScreenPackage.kt */
public final class SplashScreenPackage extends BasePackage {
    public List<ExportedModule> createExportedModules(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new SplashScreenModule(context));
    }

    public List<SingletonModule> createSingletonModules(Context context) {
        return CollectionsKt.listOf(SplashScreen.INSTANCE);
    }

    public List<ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context context) {
        Intrinsics.checkNotNullParameter(context, "activityContext");
        return CollectionsKt.listOf(new SplashScreenReactActivityLifecycleListener(context));
    }
}
