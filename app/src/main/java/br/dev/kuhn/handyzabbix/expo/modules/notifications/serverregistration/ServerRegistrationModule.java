package br.dev.kuhn.handyzabbix.expo.modules.notifications.serverregistration;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;

public class ServerRegistrationModule extends ExportedModule {
    private static final String EXPORTED_NAME = "NotificationsServerRegistrationModule";
    protected InstallationId mInstallationId;
    private RegistrationInfo mRegistrationInfo;

    public String getName() {
        return EXPORTED_NAME;
    }

    public ServerRegistrationModule(Context context) {
        super(context);
        this.mInstallationId = new InstallationId(context);
        this.mRegistrationInfo = new RegistrationInfo(context);
    }

    @ExpoMethod
    public void getInstallationIdAsync(Promise promise) {
        promise.resolve(this.mInstallationId.getOrCreateUUID());
    }

    @ExpoMethod
    public void getRegistrationInfoAsync(Promise promise) {
        promise.resolve(this.mRegistrationInfo.get());
    }

    @ExpoMethod
    public void setRegistrationInfoAsync(String str, Promise promise) {
        this.mRegistrationInfo.set(str);
        promise.resolve((Object) null);
    }
}
