package br.dev.kuhn.handyzabbix.expo.modules.notifications.service.interfaces;

import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.Notification;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationResponse;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, mo24974d2 = {"Lexpo/modules/notifications/service/interfaces/HandlingDelegate;", "", "handleNotification", "", "notification", "Lexpo/modules/notifications/notifications/model/Notification;", "handleNotificationResponse", "notificationResponse", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "handleNotificationsDropped", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: HandlingDelegate.kt */
public interface HandlingDelegate {
    void handleNotification(Notification notification);

    void handleNotificationResponse(NotificationResponse notificationResponse);

    void handleNotificationsDropped();
}
