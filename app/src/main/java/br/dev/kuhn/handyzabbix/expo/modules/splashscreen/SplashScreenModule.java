package br.dev.kuhn.handyzabbix.expo.modules.splashscreen;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.splashscreen.singletons.SplashScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo24974d2 = {"Lexpo/modules/splashscreen/SplashScreenModule;", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getName", "", "hideAsync", "", "promise", "Lexpo/modules/core/Promise;", "onCreate", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "preventAutoHideAsync", "Companion", "expo-splash-screen_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: SplashScreenModule.kt */
public final class SplashScreenModule extends ExportedModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ERROR_TAG = "ERR_SPLASH_SCREEN";
    private static final String NAME = "ExpoSplashScreen";
    private ActivityProvider activityProvider;

    public String getName() {
        return NAME;
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/splashscreen/SplashScreenModule$Companion;", "", "()V", "ERROR_TAG", "", "NAME", "expo-splash-screen_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: SplashScreenModule.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashScreenModule(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        Object module = moduleRegistry.getModule(ActivityProvider.class);
        Intrinsics.checkNotNullExpressionValue(module, "moduleRegistry.getModule…vityProvider::class.java)");
        this.activityProvider = (ActivityProvider) module;
    }

    @ExpoMethod
    public final void preventAutoHideAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ActivityProvider activityProvider2 = this.activityProvider;
        if (activityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityProvider");
        }
        Activity currentActivity = activityProvider2.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(new CurrentActivityNotFoundException());
        } else {
            SplashScreen.INSTANCE.preventAutoHide(currentActivity, new SplashScreenModule$preventAutoHideAsync$1(promise), new SplashScreenModule$preventAutoHideAsync$2(promise));
        }
    }

    @ExpoMethod
    public final void hideAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ActivityProvider activityProvider2 = this.activityProvider;
        if (activityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityProvider");
        }
        Activity currentActivity = activityProvider2.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(new CurrentActivityNotFoundException());
        } else {
            SplashScreen.INSTANCE.hide(currentActivity, new SplashScreenModule$hideAsync$1(promise), new SplashScreenModule$hideAsync$2(promise));
        }
    }
}
