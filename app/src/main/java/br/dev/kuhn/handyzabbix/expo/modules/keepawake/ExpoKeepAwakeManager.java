package br.dev.kuhn.handyzabbix.expo.modules.keepawake;

import android.app.Activity;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u0001H\u001aH\u001a0\u0019\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\bJ\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo24974d2 = {"Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "Lexpo/modules/core/interfaces/InternalModule;", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "(Lexpo/modules/core/ModuleRegistryDelegate;)V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "tags", "", "", "activate", "", "tag", "done", "Ljava/lang/Runnable;", "deactivate", "getExportedInterfaces", "", "Ljava/lang/Class;", "isActivated", "", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-keep-awake_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ExpoKeepAwakeManager.kt */
public final class ExpoKeepAwakeManager implements KeepAwakeManager, InternalModule {
    /* access modifiers changed from: private */
    public final ModuleRegistryDelegate moduleRegistryDelegate;
    private final Set<String> tags;

    public ExpoKeepAwakeManager() {
        this((ModuleRegistryDelegate) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    public ExpoKeepAwakeManager(ModuleRegistryDelegate moduleRegistryDelegate2) {
        Intrinsics.checkNotNullParameter(moduleRegistryDelegate2, "moduleRegistryDelegate");
        this.moduleRegistryDelegate = moduleRegistryDelegate2;
        this.tags = new HashSet();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpoKeepAwakeManager(ModuleRegistryDelegate moduleRegistryDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ModuleRegistryDelegate() : moduleRegistryDelegate2);
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate access$getModuleRegistryDelegate$p = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new C1723xb78f108f(access$getModuleRegistryDelegate$p));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    public void activate(String str, Runnable runnable) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(runnable, "done");
        Activity currentActivity = getCurrentActivity();
        if (!isActivated()) {
            currentActivity.runOnUiThread(new ExpoKeepAwakeManager$activate$1(currentActivity));
        }
        this.tags.add(str);
        runnable.run();
    }

    public void deactivate(String str, Runnable runnable) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(runnable, "done");
        Activity currentActivity = getCurrentActivity();
        if (this.tags.size() == 1 && this.tags.contains(str)) {
            currentActivity.runOnUiThread(new ExpoKeepAwakeManager$deactivate$1(currentActivity));
        }
        this.tags.remove(str);
        runnable.run();
    }

    public boolean isActivated() {
        return !this.tags.isEmpty();
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(KeepAwakeManager.class);
    }

    private final Activity getCurrentActivity() throws CurrentActivityNotFoundException {
        Lazy lazy = LazyKt.lazy(new ExpoKeepAwakeManager$currentActivity$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
        if (((ActivityProvider) lazy.getValue()).getCurrentActivity() != null) {
            Activity currentActivity = ((ActivityProvider) lazy.getValue()).getCurrentActivity();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "activityProvider.currentActivity");
            return currentActivity;
        }
        throw new CurrentActivityNotFoundException();
    }
}
