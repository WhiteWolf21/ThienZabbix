package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/kotlin/types/TypeConverterProvider;", "", "obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "type", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: TypeConverterProvider.kt */
public interface TypeConverterProvider {
    TypeConverter<?> obtainTypeConverter(KType kType);
}
