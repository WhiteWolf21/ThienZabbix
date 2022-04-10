package br.dev.kuhn.handyzabbix.expo.modules.kotlin.modules;

import android.app.Activity;
import expo.modules.kotlin.events.OnActivityResultPayload;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo24974d2 = {"<anonymous>", "", "sender", "Landroid/app/Activity;", "payload", "Lexpo/modules/kotlin/events/OnActivityResultPayload;", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder$onActivityResult$1 extends Lambda implements Function2<Activity, OnActivityResultPayload, Unit> {
    final /* synthetic */ Function2 $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDefinitionBuilder$onActivityResult$1(Function2 function2) {
        super(2);
        this.$body = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Activity) obj, (OnActivityResultPayload) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
        Intrinsics.checkNotNullParameter(activity, "sender");
        Intrinsics.checkNotNullParameter(onActivityResultPayload, "payload");
        this.$body.invoke(activity, onActivityResultPayload);
    }
}
