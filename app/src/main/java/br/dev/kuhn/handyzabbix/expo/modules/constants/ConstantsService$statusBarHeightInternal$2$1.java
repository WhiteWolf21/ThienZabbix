package br.dev.kuhn.handyzabbix.expo.modules.constants;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0006"}, mo24974d2 = {"<anonymous>", "", "p1", "Lkotlin/ParameterName;", "name", "p0", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ConstantsService.kt */
final /* synthetic */ class ConstantsService$statusBarHeightInternal$2$1 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    ConstantsService$statusBarHeightInternal$2$1(Resources resources) {
        super(1, resources, Resources.class, "getDimensionPixelSize", "getDimensionPixelSize(I)I", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke(((Number) obj).intValue()));
    }

    public final int invoke(int i) {
        return ((Resources) this.receiver).getDimensionPixelSize(i);
    }
}
