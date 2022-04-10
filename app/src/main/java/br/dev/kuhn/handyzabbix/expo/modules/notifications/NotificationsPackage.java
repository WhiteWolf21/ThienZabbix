package br.dev.kuhn.handyzabbix.expo.modules.notifications;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.ExportedModule;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.notifications.badge.BadgeModule;
import expo.modules.notifications.badge.ExpoBadgeManager;
import expo.modules.notifications.notifications.NotificationManager;
import expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule;
import expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule;
import expo.modules.notifications.notifications.categories.serializers.ExpoNotificationsCategoriesSerializer;
import expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider;
import expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule;
import expo.modules.notifications.notifications.channels.NotificationChannelManagerModule;
import expo.modules.notifications.notifications.emitting.NotificationsEmitter;
import expo.modules.notifications.notifications.handling.NotificationsHandler;
import expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule;
import expo.modules.notifications.notifications.scheduling.NotificationScheduler;
import expo.modules.notifications.permissions.NotificationPermissionsModule;
import expo.modules.notifications.serverregistration.ServerRegistrationModule;
import expo.modules.notifications.tokens.PushTokenManager;
import expo.modules.notifications.tokens.PushTokenModule;
import java.util.Arrays;
import java.util.List;

public class NotificationsPackage extends BasePackage {
    public List<ExportedModule> createExportedModules(Context context) {
        return Arrays.asList(new ExportedModule[]{new BadgeModule(context), new PushTokenModule(context), new NotificationsEmitter(context), new NotificationsHandler(context), new NotificationScheduler(context), new ServerRegistrationModule(context), new NotificationPermissionsModule(context), new NotificationChannelManagerModule(context), new ExpoNotificationPresentationModule(context), new NotificationChannelGroupManagerModule(context), new ExpoNotificationCategoriesModule(context), new ExpoBackgroundNotificationTasksModule(context)});
    }

    public List<SingletonModule> createSingletonModules(Context context) {
        return Arrays.asList(new SingletonModule[]{new PushTokenManager(), new NotificationManager(), new ExpoBadgeManager(context)});
    }

    public List<InternalModule> createInternalModules(Context context) {
        return Arrays.asList(new InternalModule[]{new AndroidXNotificationsChannelsProvider(context), new ExpoNotificationsCategoriesSerializer()});
    }
}
