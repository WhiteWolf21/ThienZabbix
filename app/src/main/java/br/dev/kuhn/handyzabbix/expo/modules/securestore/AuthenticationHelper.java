package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.services.UIManager;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ:\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo24974d2 = {"Lexpo/modules/securestore/AuthenticationHelper;", "", "context", "Landroid/content/Context;", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistry;)V", "defaultCallback", "Lexpo/modules/securestore/AuthenticationCallback;", "getDefaultCallback", "()Lexpo/modules/securestore/AuthenticationCallback;", "isAuthenticating", "", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "kotlin.jvm.PlatformType", "getCurrentActivity", "Landroid/app/Activity;", "handleEncryptionCallback", "", "promise", "Lexpo/modules/core/Promise;", "encryptionCallback", "Lexpo/modules/securestore/EncryptionCallback;", "cipher", "Ljavax/crypto/Cipher;", "gcmParameterSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "postEncryptionCallback", "Lexpo/modules/securestore/PostEncryptionCallback;", "openAuthenticationPrompt", "options", "Lexpo/modules/core/arguments/ReadableArguments;", "Companion", "expo-secure-store_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AuthenticationHelper.kt */
public final class AuthenticationHelper {
    private static final String AUTHENTICATION_PROMPT_PROPERTY = "authenticationPrompt";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUIRE_AUTHENTICATION_PROPERTY = "requireAuthentication";
    /* access modifiers changed from: private */
    public final Context context;
    private final AuthenticationCallback defaultCallback = new AuthenticationHelper$defaultCallback$1(this);
    /* access modifiers changed from: private */
    public boolean isAuthenticating;
    private final ModuleRegistry moduleRegistry;
    private final UIManager uiManager;

    public AuthenticationHelper(Context context2, ModuleRegistry moduleRegistry2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(moduleRegistry2, "moduleRegistry");
        this.context = context2;
        this.moduleRegistry = moduleRegistry2;
        this.uiManager = (UIManager) moduleRegistry2.getModule(UIManager.class);
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/securestore/AuthenticationHelper$Companion;", "", "()V", "AUTHENTICATION_PROMPT_PROPERTY", "", "REQUIRE_AUTHENTICATION_PROPERTY", "expo-secure-store_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: AuthenticationHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final AuthenticationCallback getDefaultCallback() {
        return this.defaultCallback;
    }

    public final void handleEncryptionCallback(Promise promise, EncryptionCallback encryptionCallback, Cipher cipher, GCMParameterSpec gCMParameterSpec, PostEncryptionCallback postEncryptionCallback) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(encryptionCallback, "encryptionCallback");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(gCMParameterSpec, "gcmParameterSpec");
        try {
            encryptionCallback.run(promise, cipher, gCMParameterSpec, postEncryptionCallback);
        } catch (GeneralSecurityException e) {
            Throwable th = e;
            Log.w("ExpoSecureStore", th);
            promise.reject("ERR_SECURESTORE_ENCRYPT_FAILURE", "Could not encrypt/decrypt the value for SecureStore", th);
        } catch (JSONException e2) {
            Throwable th2 = e2;
            Log.w("ExpoSecureStore", th2);
            promise.reject("ERR_SECURESTORE_ENCODE_FAILURE", "Could not create an encrypted JSON item for SecureStore", th2);
        }
    }

    /* access modifiers changed from: private */
    public final void openAuthenticationPrompt(Promise promise, ReadableArguments readableArguments, EncryptionCallback encryptionCallback, Cipher cipher, GCMParameterSpec gCMParameterSpec, PostEncryptionCallback postEncryptionCallback) {
        Promise promise2 = promise;
        if (Build.VERSION.SDK_INT < 23) {
            promise.reject("ERR_SECURESTORE_AUTH_NOT_AVAILABLE", "Biometric authentication requires Android API 23");
        } else if (this.isAuthenticating) {
            promise.reject("ERR_SECURESTORE_AUTH_IN_PROGRESS", "Authentication is already in progress");
        } else {
            BiometricManager from = BiometricManager.from(this.context);
            Intrinsics.checkNotNullExpressionValue(from, "BiometricManager.from(context)");
            int canAuthenticate = from.canAuthenticate(15);
            if (canAuthenticate != 1) {
                if (canAuthenticate == 11) {
                    promise.reject("ERR_SECURESTORE_AUTH_NOT_CONFIGURED", "No biometrics are currently enrolled");
                    return;
                } else if (canAuthenticate != 12) {
                    ReadableArguments readableArguments2 = readableArguments;
                    BiometricPrompt.PromptInfo build = new BiometricPrompt.PromptInfo.Builder().setTitle(readableArguments.getString(AUTHENTICATION_PROMPT_PROPERTY, " ")).setNegativeButtonText(this.context.getString(17039360)).build();
                    Intrinsics.checkNotNullExpressionValue(build, "PromptInfo.Builder()\n   …g.cancel))\n      .build()");
                    FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
                    if (fragmentActivity == null) {
                        promise.reject("ERR_SECURESTORE_APP_BACKGROUNDED", "Cannot display biometric prompt when the app is not in the foreground");
                        return;
                    } else {
                        this.uiManager.runOnUiQueueThread(new AuthenticationHelper$openAuthenticationPrompt$1(this, fragmentActivity, promise, encryptionCallback, gCMParameterSpec, postEncryptionCallback, build, cipher));
                        return;
                    }
                }
            }
            promise.reject("ERR_SECURESTORE_AUTH_NOT_AVAILABLE", "No hardware available for biometric authentication. Use expo-local-authentication to check if the device supports it.");
        }
    }

    private final Activity getCurrentActivity() {
        Object module = this.moduleRegistry.getModule(ActivityProvider.class);
        Intrinsics.checkNotNullExpressionValue(module, "moduleRegistry.getModule…vityProvider::class.java)");
        return ((ActivityProvider) module).getCurrentActivity();
    }
}
