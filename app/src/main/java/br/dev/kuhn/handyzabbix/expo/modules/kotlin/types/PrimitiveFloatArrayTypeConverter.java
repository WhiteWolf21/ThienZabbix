package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.reactcommunity.rndatetimepicker.RNConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/kotlin/types/PrimitiveFloatArrayTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "", "isOptional", "", "(Z)V", "convertNonOptional", "value", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: BasicTypeConverters.kt */
public final class PrimitiveFloatArrayTypeConverter extends TypeConverter<float[]> {
    public PrimitiveFloatArrayTypeConverter(boolean z) {
        super(z);
    }

    public float[] convertNonOptional(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        ReadableArray asArray = dynamic.asArray();
        int size = asArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) asArray.getDouble(i);
        }
        return fArr;
    }
}
