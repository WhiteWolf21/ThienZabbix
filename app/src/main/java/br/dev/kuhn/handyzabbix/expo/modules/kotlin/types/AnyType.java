package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.reactcommunity.rndatetimepicker.RNConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000fR\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo24974d2 = {"Lexpo/modules/kotlin/types/AnyType;", "", "kType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)V", "converter", "Lexpo/modules/kotlin/types/TypeConverter;", "getConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "converter$delegate", "Lkotlin/Lazy;", "getKType", "()Lkotlin/reflect/KType;", "convert", "value", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AnyType.kt */
public final class AnyType {
    private final Lazy converter$delegate = LazyKt.lazy(new AnyType$converter$2(this));
    private final KType kType;

    private final TypeConverter<?> getConverter() {
        return (TypeConverter) this.converter$delegate.getValue();
    }

    public AnyType(KType kType2) {
        Intrinsics.checkNotNullParameter(kType2, "kType");
        this.kType = kType2;
    }

    public final KType getKType() {
        return this.kType;
    }

    public final Object convert(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        return getConverter().convert(dynamic);
    }
}
