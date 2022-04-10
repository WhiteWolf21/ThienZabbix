package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import expo.modules.core.interfaces.services.EventEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "Lexpo/modules/core/interfaces/services/EventEmitter;", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: Module.kt */
final class Module$moduleEventEmitter$2 extends Lambda implements Function0<EventEmitter> {
    final /* synthetic */ Module this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Module$moduleEventEmitter$2(Module module) {
        super(0);
        this.this$0 = module;
    }

    public final EventEmitter invoke() {
        return this.this$0.getAppContext().eventEmitter(this.this$0);
    }
}
