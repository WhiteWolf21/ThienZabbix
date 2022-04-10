package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces;

import java.io.Serializable;
import java.util.Date;

public interface SchedulableNotificationTrigger extends NotificationTrigger, Serializable {
    Date nextTriggerDate();
}
