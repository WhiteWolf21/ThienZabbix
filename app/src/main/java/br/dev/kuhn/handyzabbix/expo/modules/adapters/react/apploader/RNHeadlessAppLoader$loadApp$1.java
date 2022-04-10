package br.dev.kuhn.handyzabbix.expo.modules.adapters.react.apploader;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import br.dev.kuhn.handyzabbix.expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo24974d2 = {"<anonymous>", "", "it", "Lcom/facebook/react/bridge/ReactContext;", "kotlin.jvm.PlatformType", "onReactContextInitialized"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: RNHeadlessAppLoader.kt */
final class RNHeadlessAppLoader$loadApp$1 implements ReactInstanceManager.ReactInstanceEventListener {
    final /* synthetic */ Consumer $callback;
    final /* synthetic */ HeadlessAppLoader.Params $params;

    RNHeadlessAppLoader$loadApp$1(HeadlessAppLoader.Params params, Consumer consumer) {
        this.$params = params;
        this.$callback = consumer;
    }

    public final void onReactContextInitialized(ReactContext reactContext) {
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppLoaded(this.$params.getAppScopeKey());
        Consumer consumer = this.$callback;
        if (consumer != null) {
            consumer.apply(true);
        }
    }
}
