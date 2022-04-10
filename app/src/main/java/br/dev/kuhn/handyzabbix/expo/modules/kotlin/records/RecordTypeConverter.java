package br.dev.kuhn.handyzabbix.expo.modules.kotlin.records;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.allocators.ObjectConstructor;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.allocators.ObjectConstructorFactory;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProvider;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\"\u0004\b\u0001\u0010\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, mo24974d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter;", "T", "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/types/TypeConverter;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "objectConstructorFactory", "Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "getType", "()Lkotlin/reflect/KType;", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Lexpo/modules/kotlin/records/Record;", "getObjectConstructor", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: RecordTypeConverter.kt */
public final class RecordTypeConverter<T extends Record> extends TypeConverter<T> {
    private final TypeConverterProvider converterProvider;
    private final ObjectConstructorFactory objectConstructorFactory = new ObjectConstructorFactory();
    private final KType type;

    public final KType getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, NotificationsService.EVENT_TYPE_KEY);
        this.converterProvider = typeConverterProvider;
        this.type = kType;
    }

    public T convertNonOptional(Dynamic dynamic) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableMap asMap = dynamic.asMap();
        KClassifier classifier = this.type.getClassifier();
        Objects.requireNonNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        KClass kClass = (KClass) classifier;
        T construct = getObjectConstructor(JvmClassMappingKt.getJavaClass(kClass)).construct();
        Iterable<KProperty1> memberProperties = KClasses.getMemberProperties(kClass);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberProperties, 10));
        for (KProperty1 kProperty1 : memberProperties) {
            Iterator it = kProperty1.getAnnotations().iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Annotation) obj) instanceof Field) {
                    break;
                }
            }
            Field field = (Field) obj;
            if (field != null) {
                String key = field.key();
                if (!Intrinsics.areEqual((Object) key, (Object) "")) {
                    str = key;
                }
                if (str == null) {
                    str = kProperty1.getName();
                }
                if (asMap.hasKey(str)) {
                    Dynamic dynamic2 = asMap.getDynamic(str);
                    Intrinsics.checkNotNullExpressionValue(dynamic2, "jsMap.getDynamic(jsKey)");
                    Field javaField = ReflectJvmMapping.getJavaField(kProperty1);
                    Intrinsics.checkNotNull(javaField);
                    Object convert = this.converterProvider.obtainTypeConverter(kProperty1.getReturnType()).convert(dynamic2);
                    javaField.setAccessible(true);
                    javaField.set(construct, convert);
                }
            }
            arrayList.add(Unit.INSTANCE);
        }
        List list = (List) arrayList;
        Objects.requireNonNull(construct, "null cannot be cast to non-null type T");
        return (Record) construct;
    }

    private final <T> ObjectConstructor<T> getObjectConstructor(Class<T> cls) {
        return this.objectConstructorFactory.get(cls);
    }
}
