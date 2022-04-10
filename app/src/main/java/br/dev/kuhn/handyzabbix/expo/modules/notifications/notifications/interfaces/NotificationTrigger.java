package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces;

import android.os.Parcelable;

public interface NotificationTrigger extends Parcelable {

    /* renamed from: expo.modules.notifications.notifications.interfaces.NotificationTrigger$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getNotificationChannel(NotificationTrigger notificationTrigger) {
            return null;
        }
    }

    String getNotificationChannel();
}
