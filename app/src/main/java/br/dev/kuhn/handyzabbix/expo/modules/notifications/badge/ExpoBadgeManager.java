package br.dev.kuhn.handyzabbix.expo.modules.notifications.badge;

import android.content.Context;
import android.util.Log;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.notifications.badge.interfaces.BadgeManager;
import p010me.leolin.shortcutbadger.ShortcutBadgeException;
import p010me.leolin.shortcutbadger.ShortcutBadger;

public class ExpoBadgeManager implements SingletonModule, BadgeManager {
    private static final String SINGLETON_NAME = "BadgeManager";
    private int mBadgeCount = 0;
    private Context mContext;

    public String getName() {
        return SINGLETON_NAME;
    }

    public ExpoBadgeManager(Context context) {
        this.mContext = context;
    }

    public int getBadgeCount() {
        return this.mBadgeCount;
    }

    public boolean setBadgeCount(int i) {
        try {
            ShortcutBadger.applyCountOrThrow(this.mContext.getApplicationContext(), i);
            this.mBadgeCount = i;
            return true;
        } catch (ShortcutBadgeException e) {
            Log.d("expo-notifications", "Could not have set badge count: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
