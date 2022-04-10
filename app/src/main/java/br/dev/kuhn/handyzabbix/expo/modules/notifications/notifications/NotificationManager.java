package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications;

import expo.modules.core.interfaces.SingletonModule;
import expo.modules.notifications.notifications.interfaces.NotificationListener;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.delegates.ExpoHandlingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.WeakHashMap;

public class NotificationManager implements SingletonModule, expo.modules.notifications.notifications.interfaces.NotificationManager {
    private static final String SINGLETON_NAME = "NotificationManager";
    private WeakHashMap<NotificationListener, WeakReference<NotificationListener>> mListenerReferenceMap = new WeakHashMap<>();
    private Collection<NotificationResponse> mPendingNotificationResponses = new ArrayList();

    public String getName() {
        return SINGLETON_NAME;
    }

    public NotificationManager() {
        ExpoHandlingDelegate.Companion.addListener(this);
    }

    public void addListener(NotificationListener notificationListener) {
        if (!this.mListenerReferenceMap.containsKey(notificationListener)) {
            this.mListenerReferenceMap.put(notificationListener, new WeakReference(notificationListener));
            if (!this.mPendingNotificationResponses.isEmpty()) {
                for (NotificationResponse onNotificationResponseReceived : this.mPendingNotificationResponses) {
                    notificationListener.onNotificationResponseReceived(onNotificationResponseReceived);
                }
            }
        }
    }

    public void removeListener(NotificationListener notificationListener) {
        this.mListenerReferenceMap.remove(notificationListener);
    }

    public void onNotificationReceived(Notification notification) {
        for (WeakReference<NotificationListener> weakReference : this.mListenerReferenceMap.values()) {
            NotificationListener notificationListener = (NotificationListener) weakReference.get();
            if (notificationListener != null) {
                notificationListener.onNotificationReceived(notification);
            }
        }
    }

    public void onNotificationResponseReceived(NotificationResponse notificationResponse) {
        if (this.mListenerReferenceMap.isEmpty()) {
            this.mPendingNotificationResponses.add(notificationResponse);
            return;
        }
        for (WeakReference<NotificationListener> weakReference : this.mListenerReferenceMap.values()) {
            NotificationListener notificationListener = (NotificationListener) weakReference.get();
            if (notificationListener != null) {
                notificationListener.onNotificationResponseReceived(notificationResponse);
            }
        }
    }

    public void onNotificationsDropped() {
        for (WeakReference<NotificationListener> weakReference : this.mListenerReferenceMap.values()) {
            NotificationListener notificationListener = (NotificationListener) weakReference.get();
            if (notificationListener != null) {
                notificationListener.onNotificationsDropped();
            }
        }
    }
}
