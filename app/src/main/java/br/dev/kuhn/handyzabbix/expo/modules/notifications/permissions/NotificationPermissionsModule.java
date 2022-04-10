package br.dev.kuhn.handyzabbix.expo.modules.notifications.permissions;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import expo.modules.core.ExportedModule;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.notifications.service.NotificationsService;

public class NotificationPermissionsModule extends ExportedModule {
    private static final String ANDROID_RESPONSE_KEY = "android";
    private static final String EXPORTED_NAME = "ExpoNotificationPermissionsModule";
    private static final String IMPORTANCE_KEY = "importance";
    private static final String INTERRUPTION_FILTER_KEY = "interruptionFilter";

    public String getName() {
        return EXPORTED_NAME;
    }

    public NotificationPermissionsModule(Context context) {
        super(context);
    }

    @ExpoMethod
    public void getPermissionsAsync(Promise promise) {
        promise.resolve(getPermissionsBundle());
    }

    @ExpoMethod
    public void requestPermissionsAsync(ReadableArguments readableArguments, Promise promise) {
        promise.resolve(getPermissionsBundle());
    }

    private Bundle getPermissionsBundle() {
        NotificationManagerCompat from = NotificationManagerCompat.from(getContext());
        boolean areNotificationsEnabled = from.areNotificationsEnabled();
        PermissionsStatus permissionsStatus = areNotificationsEnabled ? PermissionsStatus.GRANTED : PermissionsStatus.DENIED;
        Bundle bundle = new Bundle();
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, areNotificationsEnabled);
        bundle.putString("status", permissionsStatus.getStatus());
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, PermissionsStatus.GRANTED == permissionsStatus);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("importance", from.getImportance());
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(NotificationsService.NOTIFICATION_KEY);
        if (Build.VERSION.SDK_INT >= 23 && notificationManager != null) {
            bundle2.putInt(INTERRUPTION_FILTER_KEY, notificationManager.getCurrentInterruptionFilter());
        }
        bundle.putBundle(ANDROID_RESPONSE_KEY, bundle2);
        return bundle;
    }
}
