package br.dev.kuhn.handyzabbix.expo.modules;

import com.facebook.react.ReactInstanceManager;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo24974d2 = {"<anonymous>", "Lcom/facebook/react/ReactInstanceManager;", "it", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "invoke"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ReactNativeHostWrapper.kt */
final class ReactNativeHostWrapper$createReactInstanceManager$result$1 extends Lambda implements Function1<ReactNativeHostHandler, ReactInstanceManager> {
    final /* synthetic */ boolean $developerSupport;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReactNativeHostWrapper$createReactInstanceManager$result$1(boolean z) {
        super(1);
        this.$developerSupport = z;
    }

    public final ReactInstanceManager invoke(ReactNativeHostHandler reactNativeHostHandler) {
        return reactNativeHostHandler.createReactInstanceManager(this.$developerSupport);
    }
}
