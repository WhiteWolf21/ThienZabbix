package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import com.facebook.react.bridge.BaseJavaModule;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, mo24974d2 = {"<anonymous>", "", "R", "P0", "P1", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder$function$5 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function2 $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDefinitionBuilder$function$5(Function2 function2) {
        super(2);
        this.$body = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Function2 function2 = this.$body;
        Object obj = objArr[0];
        Intrinsics.reifiedOperationMarker(1, "P0");
        Intrinsics.reifiedOperationMarker(1, "P1");
        function2.invoke(obj, promise);
    }
}
