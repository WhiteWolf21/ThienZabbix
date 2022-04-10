package br.dev.kuhn.handyzabbix.expo.modules.notifications.tokens;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.notifications.tokens.interfaces.PushTokenListener;
import expo.modules.notifications.tokens.interfaces.PushTokenManager;

public class PushTokenModule extends ExportedModule implements PushTokenListener {
    private static final String EXPORTED_NAME = "ExpoPushTokenManager";
    private static final String NEW_TOKEN_EVENT_NAME = "onDevicePushToken";
    private static final String NEW_TOKEN_EVENT_TOKEN_KEY = "devicePushToken";
    private static final String REGISTRATION_FAIL_CODE = "E_REGISTRATION_FAILED";
    private EventEmitter mEventEmitter;
    private PushTokenManager mPushTokenManager;

    public String getName() {
        return EXPORTED_NAME;
    }

    public PushTokenModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mEventEmitter = (EventEmitter) moduleRegistry.getModule(EventEmitter.class);
        PushTokenManager pushTokenManager = (PushTokenManager) moduleRegistry.getSingletonModule("PushTokenManager", PushTokenManager.class);
        this.mPushTokenManager = pushTokenManager;
        pushTokenManager.addListener(this);
    }

    public void onDestroy() {
        this.mPushTokenManager.removeListener(this);
    }

    @ExpoMethod
    public void getDevicePushTokenAsync(final Promise promise) {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            public void onComplete(Task<InstanceIdResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    String token = task.getResult().getToken();
                    promise.resolve(token);
                    PushTokenModule.this.onNewToken(token);
                } else if (task.getException() == null) {
                    promise.reject(PushTokenModule.REGISTRATION_FAIL_CODE, "Fetching the token failed.");
                } else {
                    Promise promise = promise;
                    promise.reject(PushTokenModule.REGISTRATION_FAIL_CODE, "Fetching the token failed: " + task.getException().getMessage(), task.getException());
                }
            }
        });
    }

    public void onNewToken(String str) {
        if (this.mEventEmitter != null) {
            Bundle bundle = new Bundle();
            bundle.putString(NEW_TOKEN_EVENT_TOKEN_KEY, str);
            this.mEventEmitter.emit(NEW_TOKEN_EVENT_NAME, bundle);
        }
    }
}
