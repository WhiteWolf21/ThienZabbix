package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.reactcommunity.rndatetimepicker.RNConstants;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.ReadableTypeExtensionsKt;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception.IncompatibleArgTypeException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001f\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J5\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\fH\u0002¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo24974d2 = {"Lexpo/modules/kotlin/types/EnumTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "", "enumClass", "Lkotlin/reflect/KClass;", "isOptional", "", "(Lkotlin/reflect/KClass;Z)V", "convertEnumWithParameter", "jsValue", "Lcom/facebook/react/bridge/Dynamic;", "enumConstants", "", "parameterName", "", "(Lcom/facebook/react/bridge/Dynamic;[Ljava/lang/Enum;Ljava/lang/String;)Ljava/lang/Enum;", "convertEnumWithoutParameter", "(Lcom/facebook/react/bridge/Dynamic;[Ljava/lang/Enum;)Ljava/lang/Enum;", "convertNonOptional", "value", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: EnumTypeConverter.kt */
public final class EnumTypeConverter extends TypeConverter<Enum<?>> {
    private final KClass<Enum<?>> enumClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumTypeConverter(KClass<Enum<?>> kClass, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(kClass, "enumClass");
        this.enumClass = kClass;
    }

    public Enum<?> convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        Object[] enumConstants = JvmClassMappingKt.getJavaClass(this.enumClass).getEnumConstants();
        if (enumConstants != null) {
            Enum[] enumArr = (Enum[]) enumConstants;
            if (!(enumArr.length == 0)) {
                KFunction<Enum<?>> primaryConstructor = KClasses.getPrimaryConstructor(this.enumClass);
                if (primaryConstructor == null) {
                    throw new IllegalArgumentException("Cannot convert js value to enum without the primary constructor.".toString());
                } else if (primaryConstructor.getParameters().isEmpty()) {
                    return convertEnumWithoutParameter(dynamic, enumArr);
                } else {
                    if (primaryConstructor.getParameters().size() == 1) {
                        String name = ((KParameter) CollectionsKt.first(primaryConstructor.getParameters())).getName();
                        Intrinsics.checkNotNull(name);
                        return convertEnumWithParameter(dynamic, enumArr, name);
                    }
                    ReadableType type = dynamic.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "value.type");
                    throw new IncompatibleArgTypeException(ReadableTypeExtensionsKt.toKType(type), KClassifiers.createType$default(this.enumClass, (List) null, false, (List) null, 7, (Object) null), (Throwable) null, 4, (DefaultConstructorMarker) null);
                }
            } else {
                throw new IllegalArgumentException("Passed enum type is empty.".toString());
            }
        } else {
            throw new IllegalArgumentException("Passed type is not an enum type.".toString());
        }
    }

    private final Enum<?> convertEnumWithoutParameter(Dynamic dynamic, Enum<?>[] enumArr) {
        Enum<?> enumR;
        String asString = dynamic.asString();
        int length = enumArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                enumR = null;
                break;
            }
            enumR = enumArr[i];
            if (Intrinsics.areEqual((Object) enumR.name(), (Object) asString)) {
                break;
            }
            i++;
        }
        if (enumR != null) {
            return enumR;
        }
        throw new IllegalArgumentException(("Couldn't convert " + dynamic.asString() + " to " + this.enumClass.getSimpleName() + FilenameUtils.EXTENSION_SEPARATOR).toString());
    }

    private final Enum<?> convertEnumWithParameter(Dynamic dynamic, Enum<?>[] enumArr, String str) {
        Enum<?> enumR;
        Object obj;
        Object obj2;
        Iterator it = KClasses.getDeclaredMemberProperties(this.enumClass).iterator();
        while (true) {
            enumR = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((KProperty1) obj).getName(), (Object) str)) {
                break;
            }
        }
        KProperty1 kProperty1 = (KProperty1) obj;
        if (kProperty1 != null) {
            if (Intrinsics.areEqual((Object) kProperty1.getReturnType().getClassifier(), (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                obj2 = dynamic.asString();
            } else {
                obj2 = Integer.valueOf(dynamic.asInt());
            }
            int length = enumArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Enum<?> enumR2 = enumArr[i];
                if (Intrinsics.areEqual(kProperty1.get(enumR2), obj2)) {
                    enumR = enumR2;
                    break;
                }
                i++;
            }
            if (enumR != null) {
                return enumR;
            }
            throw new IllegalArgumentException(("Couldn't convert " + dynamic.asString() + " to " + this.enumClass.getSimpleName() + " where " + str + " is the enum parameter. ").toString());
        }
        throw new IllegalArgumentException(("Cannot find a property for " + str + " parameter.").toString());
    }
}
