package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo24974d2 = {"Lexpo/modules/kotlin/types/ListTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "elementConverter", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ListTypeConverter.kt */
public final class ListTypeConverter extends TypeConverter<List<?>> {
    private final TypeConverter<?> elementConverter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
        if (type != null) {
            this.elementConverter = typeConverterProvider.obtainTypeConverter(type);
            return;
        }
        throw new IllegalArgumentException("The list type should contain the type of elements.".toString());
    }

    public List<?> convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableArray asArray = dynamic.asArray();
        int size = asArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Dynamic dynamic2 = asArray.getDynamic(i);
            Intrinsics.checkNotNullExpressionValue(dynamic2, "jsArray.getDynamic(index)");
            Object convert = this.elementConverter.convert(dynamic2);
            dynamic2.recycle();
            arrayList.add(convert);
        }
        return arrayList;
    }
}
