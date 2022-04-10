package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.channels;

import android.app.NotificationChannelGroup;
import android.content.Context;
import android.os.Build;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelGroupSerializer;
import java.util.ArrayList;
import java.util.List;

public class NotificationChannelGroupManagerModule extends ExportedModule {
    private static final String EXPORTED_NAME = "ExpoNotificationChannelGroupManager";
    private NotificationsChannelGroupManager mGroupManager;
    private NotificationsChannelGroupSerializer mGroupSerializer;

    public String getName() {
        return EXPORTED_NAME;
    }

    public NotificationChannelGroupManagerModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        NotificationsChannelsProvider notificationsChannelsProvider = (NotificationsChannelsProvider) moduleRegistry.getModule(NotificationsChannelsProvider.class);
        this.mGroupManager = notificationsChannelsProvider.getGroupManager();
        this.mGroupSerializer = notificationsChannelsProvider.getGroupSerializer();
    }

    @ExpoMethod
    public void getNotificationChannelGroupAsync(String str, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        promise.resolve(this.mGroupSerializer.toBundle(this.mGroupManager.getNotificationChannelGroup(str)));
    }

    @ExpoMethod
    public void getNotificationChannelGroupsAsync(Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        List<NotificationChannelGroup> notificationChannelGroups = this.mGroupManager.getNotificationChannelGroups();
        ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
        for (NotificationChannelGroup bundle : notificationChannelGroups) {
            arrayList.add(this.mGroupSerializer.toBundle(bundle));
        }
        promise.resolve(arrayList);
    }

    @ExpoMethod
    public void setNotificationChannelGroupAsync(String str, ReadableArguments readableArguments, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        promise.resolve(this.mGroupSerializer.toBundle(this.mGroupManager.createNotificationChannelGroup(str, getNameFromOptions(readableArguments), readableArguments)));
    }

    @ExpoMethod
    public void deleteNotificationChannelGroupAsync(String str, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        this.mGroupManager.deleteNotificationChannelGroup(str);
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: protected */
    public CharSequence getNameFromOptions(ReadableArguments readableArguments) {
        return readableArguments.getString("name");
    }
}
