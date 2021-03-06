package br.dev.kuhn.handyzabbix.expo.modules.notifications.badge;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.notifications.badge.interfaces.BadgeManager;

public class BadgeModule extends ExportedModule {
    private static final String EXPORTED_NAME = "ExpoBadgeModule";
    private BadgeManager mBadgeManager;

    public String getName() {
        return EXPORTED_NAME;
    }

    public BadgeModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mBadgeManager = (BadgeManager) moduleRegistry.getSingletonModule("BadgeManager", BadgeManager.class);
    }

    @ExpoMethod
    public void getBadgeCountAsync(Promise promise) {
        promise.resolve(Integer.valueOf(this.mBadgeManager.getBadgeCount()));
    }

    @ExpoMethod
    public void setBadgeCountAsync(int i, Promise promise) {
        promise.resolve(Boolean.valueOf(this.mBadgeManager.setBadgeCount(i)));
    }
}
