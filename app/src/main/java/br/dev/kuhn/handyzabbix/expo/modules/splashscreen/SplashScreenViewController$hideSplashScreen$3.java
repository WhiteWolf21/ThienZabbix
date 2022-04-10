package br.dev.kuhn.handyzabbix.expo.modules.splashscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: SplashScreenViewController.kt */
final class SplashScreenViewController$hideSplashScreen$3 implements Runnable {
    final /* synthetic */ Function1 $successCallback;
    final /* synthetic */ SplashScreenViewController this$0;

    SplashScreenViewController$hideSplashScreen$3(SplashScreenViewController splashScreenViewController, Function1 function1) {
        this.this$0 = splashScreenViewController;
        this.$successCallback = function1;
    }

    public final void run() {
        this.this$0.contentView.removeView(this.this$0.splashScreenView);
        this.this$0.autoHideEnabled = true;
        this.this$0.splashScreenShown = false;
        this.$successCallback.invoke(true);
    }
}
