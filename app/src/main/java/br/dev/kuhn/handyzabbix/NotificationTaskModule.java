package br.dev.kuhn.handyzabbix;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import br.dev.kuhn.handyzabbix.com.facebook.react.bridge.ReactApplicationContext;
import br.dev.kuhn.handyzabbix.com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import br.dev.kuhn.handyzabbix.javax.annotation.Nonnull;

public class NotificationTaskModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "HandyZabbixNotificationModule";

    private static ReactApplicationContext reactContext;

    public NotificationTaskModule(@Nonnull ReactApplicationContext paramReactApplicationContext) {
        super(paramReactApplicationContext);
        reactContext = paramReactApplicationContext;
    }

    @ReactMethod
    public void cancelTask() {
        disableBootReceiver();
        Intent intent = new Intent(reactContext.getApplicationContext(), NotificationTaskReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)reactContext, 65556, intent, 134217728);
        ((AlarmManager)reactContext.getSystemService("alarm")).cancel(pendingIntent);
    }

    public void disableBootReceiver() {
        ComponentName componentName = new ComponentName((Context)reactContext, NotificationBootBroadcastReceiver.class);
        reactContext.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
    }

    public void enableBootReceiver() {
        ComponentName componentName = new ComponentName((Context)reactContext, NotificationBootBroadcastReceiver.class);
        reactContext.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
    }

    @Nonnull
    public String getName() {
        return "HandyZabbixNotificationModule";
    }

    @ReactMethod
    public void scheduleTask(int paramInt) {
        enableBootReceiver();
        SharedPreferences.Editor editor = getCurrentActivity().getSharedPreferences("HandyZabbixPreferences", 0).edit();
        editor.putInt("taskInterval", paramInt);
        editor.apply();
        Intent intent = new Intent(reactContext.getApplicationContext(), NotificationTaskReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)reactContext, 65556, intent, 134217728);
        long l = System.currentTimeMillis();
        ((AlarmManager)reactContext.getSystemService("alarm")).setInexactRepeating(0, l, paramInt, pendingIntent);
    }
}
