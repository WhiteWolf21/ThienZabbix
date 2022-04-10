package br.dev.kuhn.handyzabbix.expo.modules.keepawake;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: ExpoKeepAwakeManager.kt */
final class ExpoKeepAwakeManager$activate$1 implements Runnable {
    final /* synthetic */ Activity $activity;

    ExpoKeepAwakeManager$activate$1(Activity activity) {
        this.$activity = activity;
    }

    public final void run() {
        this.$activity.getWindow().addFlags(128);
    }
}
