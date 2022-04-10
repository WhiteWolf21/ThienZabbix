package br.dev.kuhn.handyzabbix.expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo24974d2 = {"Lexpo/modules/kotlin/views/AnyViewProp;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "set", "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AnyViewProp.kt */
public abstract class AnyViewProp {
    private final String name;

    public abstract void set(Dynamic dynamic, View view);

    public AnyViewProp(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
