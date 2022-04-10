package br.dev.kuhn.handyzabbix.expo.modules.splashscreen;

import android.app.Activity;
import com.facebook.react.ReactRootView;
import expo.modules.splashscreen.singletons.SplashScreen;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: SplashScreenReactActivityLifecycleListener.kt */
final class SplashScreenReactActivityLifecycleListener$onCreate$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SplashScreenReactActivityLifecycleListener this$0;

    SplashScreenReactActivityLifecycleListener$onCreate$1(SplashScreenReactActivityLifecycleListener splashScreenReactActivityLifecycleListener, Activity activity) {
        this.this$0 = splashScreenReactActivityLifecycleListener;
        this.$activity = activity;
    }

    public final void run() {
        Activity activity = this.$activity;
        SplashScreen.show$default(activity, this.this$0.getResizeMode(activity), ReactRootView.class, this.this$0.getStatusBarTranslucent(this.$activity), (SplashScreenViewProvider) null, (Function0) null, (Function1) null, 112, (Object) null);
    }
}
