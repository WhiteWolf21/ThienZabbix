package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.lang.reflect.Array;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo24974d2 = {"Lexpo/modules/kotlin/types/ArrayTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "arrayElementConverter", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)[Ljava/lang/Object;", "createTypedArray", "", "size", "", "(I)[Ljava/lang/Object;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ArrayTypeConverter.kt */
public final class ArrayTypeConverter extends TypeConverter<Object[]> {
    private final TypeConverter<?> arrayElementConverter;
    private final KType type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        this.type = kType;
        KType type2 = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
        if (type2 != null) {
            this.arrayElementConverter = typeConverterProvider.obtainTypeConverter(type2);
            return;
        }
        throw new IllegalArgumentException("The array type should contain the type of the elements.".toString());
    }

    public Object[] convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableArray asArray = dynamic.asArray();
        Object[] createTypedArray = createTypedArray(asArray.size());
        int size = asArray.size();
        for (int i = 0; i < size; i++) {
            Dynamic dynamic2 = asArray.getDynamic(i);
            Intrinsics.checkNotNullExpressionValue(dynamic2, "jsArray\n        .getDynamic(i)");
            Object convert = this.arrayElementConverter.convert(dynamic2);
            dynamic2.recycle();
            createTypedArray[i] = convert;
        }
        return createTypedArray;
    }

    private final Object[] createTypedArray(int i) {
        KType type2 = ((KTypeProjection) CollectionsKt.first(this.type.getArguments())).getType();
        Intrinsics.checkNotNull(type2);
        KClassifier classifier = type2.getClassifier();
        Objects.requireNonNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass((KClass) classifier), i);
        Objects.requireNonNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return (Object[]) newInstance;
    }
}
