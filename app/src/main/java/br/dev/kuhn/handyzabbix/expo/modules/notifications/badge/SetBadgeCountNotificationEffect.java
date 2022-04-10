package br.dev.kuhn.handyzabbix.expo.modules.notifications.badge;

import android.app.Notification;
import android.content.Context;
import android.util.Log;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.errors.CodedRuntimeException;
import expo.modules.notifications.badge.interfaces.BadgeManager;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.presentation.effects.BaseNotificationEffect;

public class SetBadgeCountNotificationEffect extends BaseNotificationEffect {
    private static final String EXTRAS_BADGE_KEY = "badge";
    private BadgeManager mBadgeManager;

    public SetBadgeCountNotificationEffect(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        super.onCreate(moduleRegistry);
        this.mBadgeManager = (BadgeManager) moduleRegistry.getSingletonModule("BadgeManager", BadgeManager.class);
    }

    public boolean onNotificationPresented(String str, int i, Notification notification) {
        return applyBadgeFromNotification(notification);
    }

    public boolean onNotificationPresentationFailed(String str, int i, Notification notification) {
        return applyBadgeFromNotification(notification);
    }

    private boolean applyBadgeFromNotification(Notification notification) {
        BadgeManager badgeManager;
        try {
            if (notification.extras.get("badge") == null || (badgeManager = this.mBadgeManager) == null) {
                return false;
            }
            badgeManager.setBadgeCount(notification.extras.getInt("badge"));
            return true;
        } catch (CodedRuntimeException e) {
            Log.e(e.getCode(), e.getMessage());
            return false;
        }
    }
}
