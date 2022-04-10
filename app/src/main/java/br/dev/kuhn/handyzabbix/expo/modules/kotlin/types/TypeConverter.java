package br.dev.kuhn.handyzabbix.expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.reactcommunity.rndatetimepicker.RNConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo24974d2 = {"Lexpo/modules/kotlin/types/TypeConverter;", "Type", "", "isOptional", "", "(Z)V", "convert", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "convertNonOptional", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: TypeConverter.kt */
public abstract class TypeConverter<Type> {
    private final boolean isOptional;

    public abstract Type convertNonOptional(Dynamic dynamic);

    public TypeConverter(boolean z) {
        this.isOptional = z;
    }

    public Type convert(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, RNConstants.ARG_VALUE);
        if (!dynamic.isNull()) {
            return convertNonOptional(dynamic);
        }
        if (this.isOptional) {
            return null;
        }
        throw new IllegalArgumentException();
    }
}
