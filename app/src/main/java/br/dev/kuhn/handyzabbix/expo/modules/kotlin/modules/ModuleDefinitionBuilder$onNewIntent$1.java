package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo24974d2 = {"<anonymous>", "", "it", "Landroid/content/Intent;", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder$onNewIntent$1 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ Function1 $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDefinitionBuilder$onNewIntent$1(Function1 function1) {
        super(1);
        this.$body = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "it");
        this.$body.invoke(intent);
    }
}
