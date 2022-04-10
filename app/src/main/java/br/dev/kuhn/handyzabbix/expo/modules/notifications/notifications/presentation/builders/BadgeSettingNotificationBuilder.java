package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.presentation.builders;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import p010me.leolin.shortcutbadger.ShortcutBadger;

public class BadgeSettingNotificationBuilder extends ExpoNotificationBuilder {
    public static final String EXTRAS_BADGE_KEY = "badge";

    public BadgeSettingNotificationBuilder(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public NotificationCompat.Builder createBuilder() {
        NotificationCompat.Builder createBuilder = super.createBuilder();
        if (shouldSetBadge()) {
            Bundle extras = createBuilder.getExtras();
            extras.putInt(EXTRAS_BADGE_KEY, getBadgeCount());
            createBuilder.setExtras(extras);
        }
        return createBuilder;
    }

    public Notification build() {
        Notification build = super.build();
        if (shouldSetBadge()) {
            ShortcutBadger.applyNotification(getContext(), build, getBadgeCount());
        }
        return build;
    }

    private boolean shouldSetBadge() {
        boolean z = getNotificationBehavior() == null || getNotificationBehavior().shouldSetBadge();
        boolean z2 = getNotificationContent().getBadgeCount() != null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private int getBadgeCount() {
        Number badgeCount = getNotificationContent().getBadgeCount();
        if (badgeCount == null) {
            return 0;
        }
        return badgeCount.intValue();
    }
}
