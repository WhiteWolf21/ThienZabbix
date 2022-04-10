package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClassifiers;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo24974d2 = {"toKType", "Lkotlin/reflect/KType;", "Lcom/facebook/react/bridge/ReadableType;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: ReadableTypeExtensions.kt */
public final class ReadableTypeExtensionsKt {

    @Metadata(mo24972bv = {1, 0, 3}, mo24975k = 3, mo24976mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ReadableType.Null.ordinal()] = 1;
            iArr[ReadableType.Boolean.ordinal()] = 2;
            iArr[ReadableType.Number.ordinal()] = 3;
            iArr[ReadableType.String.ordinal()] = 4;
            iArr[ReadableType.Map.ordinal()] = 5;
            iArr[ReadableType.Array.ordinal()] = 6;
        }
    }

    public static final KType toKType(ReadableType readableType) {
        Intrinsics.checkNotNullParameter(readableType, "$this$toKType");
        switch (WhenMappings.$EnumSwitchMapping$0[readableType.ordinal()]) {
            case 1:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Object.class), (List) null, true, (List) null, 5, (Object) null);
            case 2:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Boolean.TYPE), (List) null, false, (List) null, 7, (Object) null);
            case 3:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Number.class), (List) null, false, (List) null, 7, (Object) null);
            case 4:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(String.class), (List) null, false, (List) null, 7, (Object) null);
            case 5:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableMap.class), (List) null, false, (List) null, 7, (Object) null);
            case 6:
                return KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableArray.class), (List) null, false, (List) null, 7, (Object) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
