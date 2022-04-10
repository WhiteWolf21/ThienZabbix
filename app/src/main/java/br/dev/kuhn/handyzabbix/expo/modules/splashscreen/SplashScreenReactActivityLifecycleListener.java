package br.dev.kuhn.handyzabbix.expo.modules.splashscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.splashscreen.SplashScreenImageResizeMode;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, mo24974d2 = {"Lexpo/modules/splashscreen/SplashScreenReactActivityLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getResizeMode", "Lexpo/modules/splashscreen/SplashScreenImageResizeMode;", "context", "getStatusBarTranslucent", "", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "expo-splash-screen_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: SplashScreenReactActivityLifecycleListener.kt */
public final class SplashScreenReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    public /* synthetic */ boolean onBackPressed() {
        return ReactActivityLifecycleListener.CC.$default$onBackPressed(this);
    }

    public /* synthetic */ void onDestroy(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onDestroy(this, activity);
    }

    public /* synthetic */ boolean onNewIntent(Intent intent) {
        return ReactActivityLifecycleListener.CC.$default$onNewIntent(this, intent);
    }

    public /* synthetic */ void onPause(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onPause(this, activity);
    }

    public /* synthetic */ void onResume(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onResume(this, activity);
    }

    public SplashScreenReactActivityLifecycleListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "activityContext");
    }

    public void onCreate(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        new Handler(activity.getMainLooper()).post(new SplashScreenReactActivityLifecycleListener$onCreate$1(this, activity));
    }

    /* access modifiers changed from: private */
    public final SplashScreenImageResizeMode getResizeMode(Context context) {
        SplashScreenImageResizeMode.Companion companion = SplashScreenImageResizeMode.Companion;
        String string = context.getString(C1777R.string.expo_splash_screen_resize_mode);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…plash_screen_resize_mode)");
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = string.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        SplashScreenImageResizeMode fromString = companion.fromString(lowerCase);
        return fromString != null ? fromString : SplashScreenImageResizeMode.CONTAIN;
    }

    /* access modifiers changed from: private */
    public final boolean getStatusBarTranslucent(Context context) {
        return Boolean.parseBoolean(context.getString(C1777R.string.expo_splash_screen_status_bar_translucent));
    }
}
