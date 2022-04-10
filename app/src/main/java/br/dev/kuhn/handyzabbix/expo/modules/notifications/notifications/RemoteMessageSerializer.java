package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.service.NotificationsService;
import java.util.Map;

public class RemoteMessageSerializer {
    public static Bundle toBundle(RemoteMessage remoteMessage) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_COLLAPSE_KEY, remoteMessage.getCollapseKey());
        bundle.putBundle("data", toBundle(remoteMessage.getData()));
        bundle.putString("from", remoteMessage.getFrom());
        bundle.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, remoteMessage.getMessageId());
        bundle.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, remoteMessage.getMessageType());
        bundle.putBundle(NotificationsService.NOTIFICATION_KEY, toBundle(remoteMessage.getNotification()));
        bundle.putInt("originalPriority", remoteMessage.getOriginalPriority());
        bundle.putInt(Constants.FirelogAnalytics.PARAM_PRIORITY, remoteMessage.getPriority());
        bundle.putLong("sentTime", remoteMessage.getSentTime());
        bundle.putString(TypedValues.Transition.S_TO, remoteMessage.getTo());
        bundle.putInt(Constants.FirelogAnalytics.PARAM_TTL, remoteMessage.getTtl());
        return bundle;
    }

    private static Bundle toBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    private static Bundle toBundle(RemoteMessage.Notification notification) {
        if (notification == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("body", notification.getBody());
        bundle.putStringArray("bodyLocalizationArgs", notification.getBodyLocalizationArgs());
        bundle.putString("bodyLocalizationKey", notification.getBodyLocalizationKey());
        bundle.putString("channelId", notification.getChannelId());
        bundle.putString("clickAction", notification.getClickAction());
        bundle.putString("color", notification.getColor());
        bundle.putBoolean("usesDefaultLightSettings", notification.getDefaultLightSettings());
        bundle.putBoolean("usesDefaultSound", notification.getDefaultSound());
        bundle.putBoolean("usesDefaultVibrateSettings", notification.getDefaultVibrateSettings());
        if (notification.getEventTime() != null) {
            bundle.putLong("eventTime", notification.getEventTime().longValue());
        } else {
            bundle.putString("eventTime", (String) null);
        }
        bundle.putString("icon", notification.getIcon());
        if (notification.getImageUrl() != null) {
            bundle.putString("imageUrl", notification.getImageUrl().toString());
        } else {
            bundle.putString("imageUrl", (String) null);
        }
        bundle.putIntArray("lightSettings", notification.getLightSettings());
        if (notification.getLink() != null) {
            bundle.putString("link", notification.getLink().toString());
        } else {
            bundle.putString("link", (String) null);
        }
        bundle.putBoolean("localOnly", notification.getLocalOnly());
        if (notification.getNotificationCount() != null) {
            bundle.putInt("notificationCount", notification.getNotificationCount().intValue());
        } else {
            bundle.putString("notificationCount", (String) null);
        }
        if (notification.getNotificationPriority() != null) {
            bundle.putInt("notificationPriority", notification.getNotificationPriority().intValue());
        } else {
            bundle.putString("notificationPriority", (String) null);
        }
        bundle.putString(NotificationsChannelSerializer.SOUND_KEY, notification.getSound());
        bundle.putBoolean("sticky", notification.getSticky());
        bundle.putString("tag", notification.getTag());
        bundle.putString("ticker", notification.getTicker());
        bundle.putString("title", notification.getTitle());
        bundle.putStringArray("titleLocalizationArgs", notification.getTitleLocalizationArgs());
        bundle.putString("titleLocalizationKey", notification.getTitleLocalizationKey());
        bundle.putLongArray("vibrateTimings", notification.getVibrateTimings());
        if (notification.getVisibility() != null) {
            bundle.putInt("visibility", notification.getVisibility().intValue());
        } else {
            bundle.putString("visibility", (String) null);
        }
        return bundle;
    }
}
