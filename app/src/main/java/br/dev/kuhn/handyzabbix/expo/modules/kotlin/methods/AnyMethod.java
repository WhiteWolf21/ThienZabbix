package br.dev.kuhn.handyzabbix.expo.modules.kotlin.methods;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.Promise;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.ReadableArrayIterator;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.ReadableArrayIteratorKt;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception.CodedException;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception.InvalidArgsNumberException;
import br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J)\u0010\u0015\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H ¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0019R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo24974d2 = {"Lexpo/modules/kotlin/methods/AnyMethod;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "argsCount", "", "getArgsCount", "()I", "[Lexpo/modules/kotlin/types/AnyType;", "getName", "()Ljava/lang/String;", "call", "", "args", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "callImplementation", "callImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "convertArgs", "(Lcom/facebook/react/bridge/ReadableArray;)[Ljava/lang/Object;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AnyMethod.kt */
public abstract class AnyMethod {
    private final AnyType[] desiredArgsTypes;
    private final String name;

    public abstract void callImplementation$expo_modules_core_release(Object[] objArr, Promise promise) throws CodedException;

    public AnyMethod(String str, AnyType[] anyTypeArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        this.name = str;
        this.desiredArgsTypes = anyTypeArr;
    }

    /* access modifiers changed from: protected */
    public final String getName() {
        return this.name;
    }

    public final void call(ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(readableArray, "args");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.desiredArgsTypes.length != readableArray.size()) {
            promise.reject(new InvalidArgsNumberException(readableArray.size(), this.desiredArgsTypes.length));
            return;
        }
        try {
            callImplementation$expo_modules_core_release(convertArgs(readableArray), promise);
        } catch (CodedException e) {
            promise.reject(e);
        } catch (Throwable th) {
            promise.reject(new UnexpectedException(th));
        }
    }

    public final int getArgsCount() {
        return this.desiredArgsTypes.length;
    }

    private final Object[] convertArgs(ReadableArray readableArray) throws CodedException {
        int length = this.desiredArgsTypes.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = null;
        }
        ReadableArrayIterator it = ReadableArrayIteratorKt.iterator(readableArray);
        for (IndexedValue indexedValue : ArraysKt.withIndex((T[]) this.desiredArgsTypes)) {
            int component1 = indexedValue.component1();
            Dynamic next = it.next();
            objArr[component1] = ((AnyType) indexedValue.component2()).convert(next);
            Unit unit = Unit.INSTANCE;
            next.recycle();
        }
        return objArr;
    }
}
