package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo24974d2 = {"Lexpo/modules/kotlin/types/MapTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "valueConverter", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: MapTypeConverter.kt */
public final class MapTypeConverter extends TypeConverter<Map<?, ?>> {
    private final TypeConverter<?> valueConverter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        if (Intrinsics.areEqual((Object) ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType(), (Object) Reflection.typeOf(String.class))) {
            KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
            if (type != null) {
                this.valueConverter = typeConverterProvider.obtainTypeConverter(type);
                return;
            }
            throw new IllegalArgumentException("The map type should contain the key type.".toString());
        }
        throw new IllegalArgumentException(("The map key type should be String, but received " + ((KTypeProjection) CollectionsKt.first(kType.getArguments())) + FilenameUtils.EXTENSION_SEPARATOR).toString());
    }

    public Map<?, ?> convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableMap asMap = dynamic.asMap();
        Map<?, ?> linkedHashMap = new LinkedHashMap<>();
        Intrinsics.checkNotNullExpressionValue(asMap, "jsMap");
        Iterator<Map.Entry<String, Object>> entryIterator = asMap.getEntryIterator();
        Intrinsics.checkNotNullExpressionValue(entryIterator, "jsMap.entryIterator");
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            String str = (String) next.getKey();
            Dynamic dynamicFromObject = new DynamicFromObject(next.getValue());
            Intrinsics.checkNotNullExpressionValue(str, "key");
            linkedHashMap.put(str, this.valueConverter.convert(dynamicFromObject));
            Unit unit = Unit.INSTANCE;
            dynamicFromObject.recycle();
        }
        return linkedHashMap;
    }
}
