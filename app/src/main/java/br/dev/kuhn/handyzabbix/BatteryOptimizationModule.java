package br.dev.kuhn.handyzabbix;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import com.facebook.react.bridge.Promise;
import br.dev.kuhn.handyzabbix.com.facebook.react.bridge.ReactApplicationContext;
import br.dev.kuhn.handyzabbix.com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import br.dev.kuhn.handyzabbix.javax.annotation.Nonnull;

public class BatteryOptimizationModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "BatteryOptimizationModule";

    private static ReactApplicationContext reactContext;

    public BatteryOptimizationModule(@Nonnull String paramReactApplicationContext) {
        super(paramReactApplicationContext);
        reactContext = paramReactApplicationContext;
    }

    @ReactMethod
    public void checkStatus(Promise paramPromise) {
        try {
            String str = getReactApplicationContext().getPackageName();
            boolean bool = ((PowerManager)getReactApplicationContext().getSystemService("power")).isIgnoringBatteryOptimizations(str);
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(bool);
            stringBuilder.append("");
            paramPromise.resolve(stringBuilder.toString());
        } catch (Exception exception) {
            paramPromise.reject("br.dev.kuhn.handyzabbix Error", exception);
        }
    }

    @ReactMethod
    public void disableBatteryOptimization(Promise paramPromise) {
        try {
            Activity activity = getCurrentActivity();
            String str = getReactApplicationContext().getPackageName();
            Intent intent = new Intent();
            this("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", str, null));
            activity.startActivity(intent);
            paramPromise.resolve("");
        } catch (Exception exception) {
            paramPromise.reject("br.dev.kuhn.handyzabbix Error", exception);
        }
    }

    @Nonnull
    public String getName() {
        return "BatteryOptimizationModule";
    }
}
