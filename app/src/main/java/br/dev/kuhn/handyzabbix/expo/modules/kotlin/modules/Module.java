package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import android.os.Bundle;
import expo.modules.core.interfaces.services.EventEmitter;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.AppContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo24974d2 = {"Lexpo/modules/kotlin/modules/Module;", "", "()V", "_appContext", "Lexpo/modules/kotlin/AppContext;", "get_appContext$expo_modules_core_release", "()Lexpo/modules/kotlin/AppContext;", "set_appContext$expo_modules_core_release", "(Lexpo/modules/kotlin/AppContext;)V", "appContext", "getAppContext", "moduleEventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "getModuleEventEmitter", "()Lexpo/modules/core/interfaces/services/EventEmitter;", "moduleEventEmitter$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "sendEvent", "", "name", "", "body", "Landroid/os/Bundle;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: Module.kt */
public abstract class Module {
    private AppContext _appContext;
    private final Lazy moduleEventEmitter$delegate = LazyKt.lazy(new Module$moduleEventEmitter$2(this));

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter$delegate.getValue();
    }

    public abstract ModuleDefinitionData definition();

    public final AppContext get_appContext$expo_modules_core_release() {
        return this._appContext;
    }

    public final void set_appContext$expo_modules_core_release(AppContext appContext) {
        this._appContext = appContext;
    }

    public final AppContext getAppContext() {
        AppContext appContext = this._appContext;
        if (appContext != null) {
            return appContext;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the app context.".toString());
    }

    public final void sendEvent(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(str, bundle);
        }
    }
}
