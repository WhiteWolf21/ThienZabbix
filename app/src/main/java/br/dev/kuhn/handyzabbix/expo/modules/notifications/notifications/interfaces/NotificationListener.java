package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces;

import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;

public interface NotificationListener {

    /* renamed from: expo.modules.notifications.notifications.interfaces.NotificationListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onNotificationReceived(NotificationListener notificationListener, Notification notification) {
        }

        public static boolean $default$onNotificationResponseReceived(NotificationListener notificationListener, NotificationResponse notificationResponse) {
            return false;
        }

        public static void $default$onNotificationsDropped(NotificationListener notificationListener) {
        }
    }

    void onNotificationReceived(Notification notification);

    boolean onNotificationResponseReceived(NotificationResponse notificationResponse);

    void onNotificationsDropped();
}
