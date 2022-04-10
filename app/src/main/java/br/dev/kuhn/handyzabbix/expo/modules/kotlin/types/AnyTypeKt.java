package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo24974d2 = {"toAnyType", "Lexpo/modules/kotlin/types/AnyType;", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: AnyType.kt */
public final class AnyTypeKt {
    public static final AnyType toAnyType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "$this$toAnyType");
        return new AnyType(kType);
    }
}
