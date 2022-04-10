package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import expo.modules.core.Promise;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24974d2 = {"<anonymous>", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: AuthenticationHelper.kt */
final class AuthenticationHelper$openAuthenticationPrompt$1 implements Runnable {
    final /* synthetic */ Cipher $cipher;
    final /* synthetic */ EncryptionCallback $encryptionCallback;
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ GCMParameterSpec $gcmParameterSpec;
    final /* synthetic */ PostEncryptionCallback $postEncryptionCallback;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ BiometricPrompt.PromptInfo $promptInfo;
    final /* synthetic */ AuthenticationHelper this$0;

    AuthenticationHelper$openAuthenticationPrompt$1(AuthenticationHelper authenticationHelper, FragmentActivity fragmentActivity, Promise promise, EncryptionCallback encryptionCallback, GCMParameterSpec gCMParameterSpec, PostEncryptionCallback postEncryptionCallback, BiometricPrompt.PromptInfo promptInfo, Cipher cipher) {
        this.this$0 = authenticationHelper;
        this.$fragmentActivity = fragmentActivity;
        this.$promise = promise;
        this.$encryptionCallback = encryptionCallback;
        this.$gcmParameterSpec = gCMParameterSpec;
        this.$postEncryptionCallback = postEncryptionCallback;
        this.$promptInfo = promptInfo;
        this.$cipher = cipher;
    }

    public final void run() {
        this.this$0.isAuthenticating = true;
        new BiometricPrompt(this.$fragmentActivity, ContextCompat.getMainExecutor(this.this$0.context), (BiometricPrompt.AuthenticationCallback) new BiometricPrompt.AuthenticationCallback(this) {
            final /* synthetic */ AuthenticationHelper$openAuthenticationPrompt$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                Intrinsics.checkNotNullParameter(authenticationResult, "result");
                super.onAuthenticationSucceeded(authenticationResult);
                this.this$0.this$0.isAuthenticating = false;
                BiometricPrompt.CryptoObject cryptoObject = authenticationResult.getCryptoObject();
                Intrinsics.checkNotNull(cryptoObject);
                Intrinsics.checkNotNullExpressionValue(cryptoObject, "result.cryptoObject!!");
                Cipher cipher = cryptoObject.getCipher();
                Intrinsics.checkNotNull(cipher);
                Intrinsics.checkNotNullExpressionValue(cipher, "result.cryptoObject!!.cipher!!");
                this.this$0.this$0.handleEncryptionCallback(this.this$0.$promise, this.this$0.$encryptionCallback, cipher, this.this$0.$gcmParameterSpec, new C1768x6f9b1a11(this));
            }

            public void onAuthenticationError(int i, CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "errString");
                super.onAuthenticationError(i, charSequence);
                this.this$0.this$0.isAuthenticating = false;
                if (i == 10 || i == 13) {
                    this.this$0.$promise.reject("ERR_SECURESTORE_AUTH_CANCELLED", "User canceled the authentication");
                } else {
                    this.this$0.$promise.reject("ERR_SECURESTORE_AUTH_FAILURE", "Could not authenticate the user");
                }
            }
        }).authenticate(this.$promptInfo, new BiometricPrompt.CryptoObject(this.$cipher));
    }
}
