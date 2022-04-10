package br.dev.kuhn.handyzabbix.expo.modules.constants;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.constants.ConstantsInterface;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u0001H\u0018H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u0001H\bJ\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u001bH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo24974d2 = {"Lexpo/modules/constants/ConstantsModule;", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistryDelegate;)V", "constantsService", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "getConstantsService", "()Lexpo/modules/interfaces/constants/ConstantsInterface;", "constantsService$delegate", "Lkotlin/Lazy;", "getConstants", "", "", "", "getName", "getWebViewUserAgentAsync", "", "promise", "Lexpo/modules/core/Promise;", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ConstantsModule.kt */
public final class ConstantsModule extends ExportedModule {
    private final Lazy constantsService$delegate;
    /* access modifiers changed from: private */
    public final ModuleRegistryDelegate moduleRegistryDelegate;

    private final ConstantsInterface getConstantsService() {
        return (ConstantsInterface) this.constantsService$delegate.getValue();
    }

    public String getName() {
        return "ExponentConstants";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConstantsModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new ModuleRegistryDelegate() : moduleRegistryDelegate2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstantsModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleRegistryDelegate2, "moduleRegistryDelegate");
        this.moduleRegistryDelegate = moduleRegistryDelegate2;
        this.constantsService$delegate = LazyKt.lazy(new ConstantsModule$$special$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate access$getModuleRegistryDelegate$p = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new ConstantsModule$moduleRegistry$$inlined$getFromModuleRegistry$1(access$getModuleRegistryDelegate$p));
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> constants = getConstantsService().getConstants();
        Intrinsics.checkNotNullExpressionValue(constants, "constantsService.constants");
        return constants;
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    @ExpoMethod
    public final void getWebViewUserAgentAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.resolve(System.getProperty("http.agent"));
    }
}
