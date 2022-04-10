package br.dev.kuhn.handyzabbix.expo.modules.adapters.react.apploader;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: RNHeadlessAppLoader.kt */
final class RNHeadlessAppLoader$invalidateApp$1 implements Runnable {
    final /* synthetic */ ReactInstanceManager $appRecord;
    final /* synthetic */ String $appScopeKey;

    RNHeadlessAppLoader$invalidateApp$1(ReactInstanceManager reactInstanceManager, String str) {
        this.$appRecord = reactInstanceManager;
        this.$appScopeKey = str;
    }

    public final void run() {
        if (this.$appRecord.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            this.$appRecord.destroy();
        }
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(this.$appScopeKey);
        Map access$getAppRecords$p = RNHeadlessAppLoaderKt.appRecords;
        String str = this.$appScopeKey;
        Objects.requireNonNull(access$getAppRecords$p, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        TypeIntrinsics.asMutableMap(access$getAppRecords$p).remove(str);
    }
}
