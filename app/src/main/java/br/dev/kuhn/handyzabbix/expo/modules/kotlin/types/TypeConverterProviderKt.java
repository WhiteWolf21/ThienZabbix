package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0005H\b¨\u0006\n"}, mo24974d2 = {"convert", "T", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "", "type", "Lkotlin/reflect/KType;", "obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: TypeConverterProvider.kt */
public final class TypeConverterProviderKt {
    public static final /* synthetic */ <T> TypeConverter<T> obtainTypeConverter() {
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, "T");
        TypeConverter<?> obtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter((KType) null);
        Objects.requireNonNull(obtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.types.TypeConverter<T>");
        return obtainTypeConverter;
    }

    public static final /* synthetic */ <T> T convert(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, "T");
        T convert = typeConverterProviderImpl.obtainTypeConverter((KType) null).convert(dynamic);
        Intrinsics.reifiedOperationMarker(1, "T");
        return (Object) convert;
    }

    public static final Object convert(Dynamic dynamic, KType kType) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        return TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(kType).convert(dynamic);
    }
}
