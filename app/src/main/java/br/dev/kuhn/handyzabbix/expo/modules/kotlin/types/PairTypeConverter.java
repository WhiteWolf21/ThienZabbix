package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo24974d2 = {"Lexpo/modules/kotlin/types/PairTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "Lkotlin/Pair;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "firstConverter", "secondConverter", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: PairTypeConverter.kt */
public final class PairTypeConverter extends TypeConverter<Pair<?, ?>> {
    private final TypeConverter<?> firstConverter;
    private final TypeConverter<?> secondConverter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 0);
        KType kType2 = null;
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            this.firstConverter = typeConverterProvider.obtainTypeConverter(type);
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            kType2 = kTypeProjection2 != null ? kTypeProjection2.getType() : kType2;
            if (kType2 != null) {
                this.secondConverter = typeConverterProvider.obtainTypeConverter(kType2);
                return;
            }
            throw new IllegalArgumentException("The pair type should contain the type of the second parameter.".toString());
        }
        throw new IllegalArgumentException("The pair type should contain the type of the first parameter.".toString());
    }

    public Pair<?, ?> convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableArray asArray = dynamic.asArray();
        TypeConverter<?> typeConverter = this.firstConverter;
        Dynamic dynamic2 = asArray.getDynamic(0);
        Intrinsics.checkNotNullExpressionValue(dynamic2, "jsArray.getDynamic(0)");
        Object convert = typeConverter.convert(dynamic2);
        TypeConverter<?> typeConverter2 = this.secondConverter;
        Dynamic dynamic3 = asArray.getDynamic(1);
        Intrinsics.checkNotNullExpressionValue(dynamic3, "jsArray.getDynamic(1)");
        return new Pair<>(convert, typeConverter2.convert(dynamic3));
    }
}
