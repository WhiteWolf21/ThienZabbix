package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.emitting;

import android.content.Context;
import android.os.Bundle;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.services.EventEmitter;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.NotificationSerializer;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces.NotificationListener;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces.NotificationManager;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;

public class NotificationsEmitter extends ExportedModule implements NotificationListener {
    private static final String EXPORTED_NAME = "ExpoNotificationsEmitter";
    private static final String MESSAGES_DELETED_EVENT_NAME = "onNotificationsDeleted";
    private static final String NEW_MESSAGE_EVENT_NAME = "onDidReceiveNotification";
    private static final String NEW_RESPONSE_EVENT_NAME = "onDidReceiveNotificationResponse";
    private EventEmitter mEventEmitter;
    private NotificationResponse mLastNotificationResponse;
    private NotificationManager mNotificationManager;

    public String getName() {
        return EXPORTED_NAME;
    }

    public NotificationsEmitter(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mEventEmitter = (EventEmitter) moduleRegistry.getModule(EventEmitter.class);
        NotificationManager notificationManager = (NotificationManager) moduleRegistry.getSingletonModule("NotificationManager", NotificationManager.class);
        this.mNotificationManager = notificationManager;
        notificationManager.addListener(this);
    }

    public void onDestroy() {
        this.mNotificationManager.removeListener(this);
    }

    @ExpoMethod
    public void getLastNotificationResponseAsync(Promise promise) {
        NotificationResponse notificationResponse = this.mLastNotificationResponse;
        promise.resolve(notificationResponse != null ? NotificationSerializer.toBundle(notificationResponse) : null);
    }

    public void onNotificationReceived(Notification notification) {
        EventEmitter eventEmitter = this.mEventEmitter;
        if (eventEmitter != null) {
            eventEmitter.emit(NEW_MESSAGE_EVENT_NAME, NotificationSerializer.toBundle(notification));
        }
    }

    public boolean onNotificationResponseReceived(NotificationResponse notificationResponse) {
        this.mLastNotificationResponse = notificationResponse;
        EventEmitter eventEmitter = this.mEventEmitter;
        if (eventEmitter == null) {
            return false;
        }
        eventEmitter.emit(NEW_RESPONSE_EVENT_NAME, NotificationSerializer.toBundle(notificationResponse));
        return true;
    }

    public void onNotificationsDropped() {
        EventEmitter eventEmitter = this.mEventEmitter;
        if (eventEmitter != null) {
            eventEmitter.emit(MESSAGES_DELETED_EVENT_NAME, Bundle.EMPTY);
        }
    }
}
