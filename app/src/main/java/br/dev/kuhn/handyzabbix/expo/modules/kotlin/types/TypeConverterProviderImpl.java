package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception.MissingTypeConverter;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.records.Record;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.records.RecordTypeConverter;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo24974d2 = {"Lexpo/modules/kotlin/types/TypeConverterProviderImpl;", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "()V", "cachedConverters", "", "Lkotlin/reflect/KType;", "Lexpo/modules/kotlin/types/TypeConverter;", "createCashedConverters", "isOptional", "", "obtainTypeConverter", "type", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: TypeConverterProvider.kt */
public final class TypeConverterProviderImpl implements TypeConverterProvider {
    public static final TypeConverterProviderImpl INSTANCE;
    private static final Map<KType, TypeConverter<?>> cachedConverters;

    static {
        TypeConverterProviderImpl typeConverterProviderImpl = new TypeConverterProviderImpl();
        INSTANCE = typeConverterProviderImpl;
        cachedConverters = MapsKt.plus(typeConverterProviderImpl.createCashedConverters(false), typeConverterProviderImpl.createCashedConverters(true));
    }

    private TypeConverterProviderImpl() {
    }

    public TypeConverter<?> obtainTypeConverter(KType kType) {
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        TypeConverter<?> typeConverter = cachedConverters.get(kType);
        if (typeConverter != null) {
            return typeConverter;
        }
        KClassifier classifier = kType.getClassifier();
        if (!(classifier instanceof KClass)) {
            classifier = null;
        }
        KClass kClass = (KClass) classifier;
        if (kClass == null) {
            throw new MissingTypeConverter(kType);
        } else if (JvmClassMappingKt.getJavaClass(kClass).isArray()) {
            return new ArrayTypeConverter(this, kType);
        } else {
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(List.class))) {
                return new ListTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Map.class))) {
                return new MapTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
                return new PairTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class))) {
                return new ArrayTypeConverter(this, kType);
            }
            if (JvmClassMappingKt.getJavaClass(kClass).isEnum()) {
                Objects.requireNonNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Enum<*>>");
                return new EnumTypeConverter(kClass, kType.isMarkedNullable());
            } else if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Record.class))) {
                return new RecordTypeConverter<>(this, kType);
            } else {
                throw new MissingTypeConverter(kType);
            }
        }
    }

    private final Map<KType, TypeConverter<?>> createCashedConverters(boolean z) {
        IntTypeConverter intTypeConverter = new IntTypeConverter(z);
        DoubleTypeConverter doubleTypeConverter = new DoubleTypeConverter(z);
        FloatTypeConverter floatTypeConverter = new FloatTypeConverter(z);
        BoolTypeConverter boolTypeConverter = new BoolTypeConverter(z);
        boolean z2 = z;
        boolean z3 = z;
        return MapsKt.mapOf(TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Integer.TYPE), (List) null, z2, (List) null, 5, (Object) null), intTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Integer.class), (List) null, z2, (List) null, 5, (Object) null), intTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Double.TYPE), (List) null, z3, (List) null, 5, (Object) null), doubleTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Double.class), (List) null, z3, (List) null, 5, (Object) null), doubleTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float.TYPE), (List) null, z3, (List) null, 5, (Object) null), floatTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float.class), (List) null, z3, (List) null, 5, (Object) null), floatTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Boolean.TYPE), (List) null, z3, (List) null, 5, (Object) null), boolTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, z3, (List) null, 5, (Object) null), boolTypeConverter), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(String.class), (List) null, z3, (List) null, 5, (Object) null), new StringTypeConverter(z)), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableArray.class), (List) null, z3, (List) null, 5, (Object) null), new ReadableArrayTypeConverter(z)), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableMap.class), (List) null, z3, (List) null, 5, (Object) null), new ReadableMapTypeConverter(z)), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(int[].class), (List) null, z3, (List) null, 5, (Object) null), new PrimitiveIntArrayTypeConverter(z)), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(double[].class), (List) null, z3, (List) null, 5, (Object) null), new PrimitiveDoubleArrayTypeConverter(z)), TuplesKt.m176to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(float[].class), (List) null, z3, (List) null, 5, (Object) null), new PrimitiveFloatArrayTypeConverter(z)));
    }
}
