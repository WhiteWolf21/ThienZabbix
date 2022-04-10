package br.dev.kuhn.handyzabbix.expo.modules.kotlin.allocators;

import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo24974d2 = {"<anonymous>", "T", "newInstance", "()Ljava/lang/Object;"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: UnsafeAllocator.kt */
final class UnsafeAllocator$Companion$createAllocator$3<T> implements UnsafeAllocator<T> {
    final /* synthetic */ Class $clazz;

    UnsafeAllocator$Companion$createAllocator$3(Class cls) {
        this.$clazz = cls;
    }

    public final T newInstance() {
        throw new IllegalArgumentException("Cannot allocate " + this.$clazz);
    }
}
