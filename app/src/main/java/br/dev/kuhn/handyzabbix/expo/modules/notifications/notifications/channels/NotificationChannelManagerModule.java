package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.channels;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.enums.NotificationImportance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NotificationChannelManagerModule extends ExportedModule {
    private static final String EXPORTED_NAME = "ExpoNotificationChannelManager";
    private NotificationsChannelManager mChannelManager;
    private NotificationsChannelSerializer mChannelSerializer;

    public String getName() {
        return EXPORTED_NAME;
    }

    public NotificationChannelManagerModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        NotificationsChannelsProvider notificationsChannelsProvider = (NotificationsChannelsProvider) moduleRegistry.getModule(NotificationsChannelsProvider.class);
        this.mChannelManager = notificationsChannelsProvider.getChannelManager();
        this.mChannelSerializer = notificationsChannelsProvider.getChannelSerializer();
    }

    @ExpoMethod
    public void getNotificationChannelAsync(String str, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
        } else {
            promise.resolve(this.mChannelSerializer.toBundle(this.mChannelManager.getNotificationChannel(str)));
        }
    }

    @ExpoMethod
    public void getNotificationChannelsAsync(Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve(Collections.EMPTY_LIST);
            return;
        }
        List<NotificationChannel> notificationChannels = this.mChannelManager.getNotificationChannels();
        ArrayList arrayList = new ArrayList(notificationChannels.size());
        for (NotificationChannel bundle : notificationChannels) {
            arrayList.add(this.mChannelSerializer.toBundle(bundle));
        }
        promise.resolve(arrayList);
    }

    @ExpoMethod
    public void setNotificationChannelAsync(String str, ReadableArguments readableArguments, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        promise.resolve(this.mChannelSerializer.toBundle(this.mChannelManager.createNotificationChannel(str, getNameFromOptions(readableArguments), getImportanceFromOptions(readableArguments), readableArguments)));
    }

    @ExpoMethod
    public void deleteNotificationChannelAsync(String str, Promise promise) {
        if (Build.VERSION.SDK_INT < 26) {
            promise.resolve((Object) null);
            return;
        }
        this.mChannelManager.deleteNotificationChannel(str);
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: protected */
    public CharSequence getNameFromOptions(ReadableArguments readableArguments) {
        return readableArguments.getString("name");
    }

    /* access modifiers changed from: protected */
    public int getImportanceFromOptions(ReadableArguments readableArguments) {
        NotificationImportance fromEnumValue = NotificationImportance.fromEnumValue(readableArguments.getInt(NotificationsChannelSerializer.IMPORTANCE_KEY, NotificationImportance.DEFAULT.getEnumValue()));
        Objects.requireNonNull(fromEnumValue);
        return fromEnumValue.getNativeValue();
    }
}
