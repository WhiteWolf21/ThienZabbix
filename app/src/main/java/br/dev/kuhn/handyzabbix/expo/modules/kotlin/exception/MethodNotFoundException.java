package br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/kotlin/exception/MethodNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "methodName", "", "moduleName", "(Ljava/lang/String;Ljava/lang/String;)V", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: CodedException.kt */
public final class MethodNotFoundException extends CodedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MethodNotFoundException(String str, String str2) {
        super("Cannot fund method " + str + " in module " + str2);
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "moduleName");
    }
}
