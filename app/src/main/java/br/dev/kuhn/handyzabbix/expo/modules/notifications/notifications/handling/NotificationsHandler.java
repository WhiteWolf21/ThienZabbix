package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.handling;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces.NotificationListener;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.interfaces.NotificationManager;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationResponse;
import java.util.HashMap;
import java.util.Map;

public class NotificationsHandler extends ExportedModule implements NotificationListener {
    private static final String EXPORTED_NAME = "ExpoNotificationsHandlerModule";
    private static final String PRIORITY_KEY = "priority";
    private static final String SHOULD_PLAY_SOUND_KEY = "shouldPlaySound";
    private static final String SHOULD_SET_BADGE_KEY = "shouldSetBadge";
    private static final String SHOULD_SHOW_ALERT_KEY = "shouldShowAlert";
    private Handler mHandler = null;
    private ModuleRegistry mModuleRegistry;
    private NotificationManager mNotificationManager;
    private HandlerThread mNotificationsHandlerThread = null;
    private Map<String, SingleNotificationHandlerTask> mTasksMap = new HashMap();

    public String getName() {
        return EXPORTED_NAME;
    }

    public /* synthetic */ boolean onNotificationResponseReceived(NotificationResponse notificationResponse) {
        return NotificationListener.CC.$default$onNotificationResponseReceived(this, notificationResponse);
    }

    public /* synthetic */ void onNotificationsDropped() {
        NotificationListener.CC.$default$onNotificationsDropped(this);
    }

    public NotificationsHandler(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
        NotificationManager notificationManager = (NotificationManager) moduleRegistry.getSingletonModule("NotificationManager", NotificationManager.class);
        this.mNotificationManager = notificationManager;
        notificationManager.addListener(this);
        HandlerThread handlerThread = new HandlerThread("NotificationsHandlerThread - " + getClass().toString());
        this.mNotificationsHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mNotificationsHandlerThread.getLooper());
    }

    public void onDestroy() {
        this.mNotificationManager.removeListener(this);
        for (SingleNotificationHandlerTask stop : this.mTasksMap.values()) {
            stop.stop();
        }
        this.mNotificationsHandlerThread.quit();
    }

    @ExpoMethod
    public void handleNotificationAsync(String str, ReadableArguments readableArguments, Promise promise) {
        SingleNotificationHandlerTask singleNotificationHandlerTask = this.mTasksMap.get(str);
        if (singleNotificationHandlerTask == null) {
            promise.reject("ERR_NOTIFICATION_HANDLED", String.format("Failed to handle notification %s, it has already been handled.", new Object[]{str}));
            return;
        }
        singleNotificationHandlerTask.handleResponse(new NotificationBehavior(readableArguments.getBoolean(SHOULD_SHOW_ALERT_KEY), readableArguments.getBoolean(SHOULD_PLAY_SOUND_KEY), readableArguments.getBoolean(SHOULD_SET_BADGE_KEY), readableArguments.getString("priority")), promise);
    }

    public void onNotificationReceived(Notification notification) {
        SingleNotificationHandlerTask singleNotificationHandlerTask = new SingleNotificationHandlerTask(getContext(), this.mHandler, this.mModuleRegistry, notification, this);
        this.mTasksMap.put(singleNotificationHandlerTask.getIdentifier(), singleNotificationHandlerTask);
        singleNotificationHandlerTask.start();
    }

    /* access modifiers changed from: package-private */
    public void onTaskFinished(SingleNotificationHandlerTask singleNotificationHandlerTask) {
        this.mTasksMap.remove(singleNotificationHandlerTask.getIdentifier());
    }
}
