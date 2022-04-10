package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import com.facebook.react.bridge.ReadableArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo24974d2 = {"iterator", "Lexpo/modules/kotlin/ReadableArrayIterator;", "Lcom/facebook/react/bridge/ReadableArray;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: ReadableArrayIterator.kt */
public final class ReadableArrayIteratorKt {
    public static final ReadableArrayIterator iterator(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "$this$iterator");
        return new ReadableArrayIterator(readableArray);
    }
}
