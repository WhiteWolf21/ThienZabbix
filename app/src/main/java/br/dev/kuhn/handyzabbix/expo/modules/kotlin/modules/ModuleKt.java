package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, mo24974d2 = {"ModuleDefinition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "", "Lkotlin/ExtensionFunctionType;", "expo-modules-core_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: Module.kt */
public final class ModuleKt {
    public static final ModuleDefinitionData ModuleDefinition(Function1<? super ModuleDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder();
        function1.invoke(moduleDefinitionBuilder);
        return moduleDefinitionBuilder.build();
    }
}
