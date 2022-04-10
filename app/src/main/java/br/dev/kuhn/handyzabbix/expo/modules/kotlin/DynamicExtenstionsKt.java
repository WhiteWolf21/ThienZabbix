package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import com.facebook.react.bridge.Dynamic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, mo24974d2 = {"recycle", "T", "Lcom/facebook/react/bridge/Dynamic;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/facebook/react/bridge/Dynamic;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: DynamicExtenstions.kt */
public final class DynamicExtenstionsKt {
    public static final <T> T recycle(Dynamic dynamic, Function1<? super Dynamic, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(dynamic, "$this$recycle");
        Intrinsics.checkNotNullParameter(function1, "block");
        T invoke = function1.invoke(dynamic);
        dynamic.recycle();
        return invoke;
    }
}
