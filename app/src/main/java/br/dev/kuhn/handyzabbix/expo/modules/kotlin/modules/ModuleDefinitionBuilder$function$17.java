package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import com.facebook.react.bridge.BaseJavaModule;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\u0006\b\b\u0010\n\u0018\u00012\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, mo24974d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder$function$17 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function8 $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDefinitionBuilder$function$17(Function8 function8) {
        super(2);
        this.$body = function8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Function8 function8 = this.$body;
        Object obj = objArr[0];
        Intrinsics.reifiedOperationMarker(1, "P0");
        Object obj2 = objArr[1];
        Intrinsics.reifiedOperationMarker(1, "P1");
        Object obj3 = objArr[2];
        Intrinsics.reifiedOperationMarker(1, "P2");
        Object obj4 = objArr[3];
        Intrinsics.reifiedOperationMarker(1, "P3");
        Object obj5 = objArr[4];
        Intrinsics.reifiedOperationMarker(1, "P4");
        Object obj6 = objArr[5];
        Intrinsics.reifiedOperationMarker(1, "P5");
        Object obj7 = objArr[6];
        Intrinsics.reifiedOperationMarker(1, "P6");
        Intrinsics.reifiedOperationMarker(1, "P7");
        function8.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, promise);
    }
}
