package br.dev.kuhn.handyzabbix.expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004BM\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R>\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo24974d2 = {"Lexpo/modules/kotlin/views/ConcreteViewProp;", "ViewType", "Landroid/view/View;", "PropType", "Lexpo/modules/kotlin/views/AnyViewProp;", "name", "", "propType", "Lexpo/modules/kotlin/types/AnyType;", "setter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "view", "prop", "", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function2;)V", "set", "Lcom/facebook/react/bridge/Dynamic;", "onView", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ConcreteViewProp.kt */
public final class ConcreteViewProp<ViewType extends View, PropType> extends AnyViewProp {
    private final AnyType propType;
    private final Function2<ViewType, PropType, Unit> setter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConcreteViewProp(String str, AnyType anyType, Function2<? super ViewType, ? super PropType, Unit> function2) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyType, "propType");
        Intrinsics.checkNotNullParameter(function2, "setter");
        this.propType = anyType;
        this.setter = function2;
    }

    public void set(Dynamic dynamic, View view) {
        Intrinsics.checkNotNullParameter(dynamic, "prop");
        Intrinsics.checkNotNullParameter(view, "onView");
        this.setter.invoke(view, this.propType.convert(dynamic));
    }
}
