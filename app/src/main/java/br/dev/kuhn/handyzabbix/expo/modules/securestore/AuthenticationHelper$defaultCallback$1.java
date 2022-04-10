package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0012"}, mo24974d2 = {"expo/modules/securestore/AuthenticationHelper$defaultCallback$1", "Lexpo/modules/securestore/AuthenticationCallback;", "checkAuthentication", "", "promise", "Lexpo/modules/core/Promise;", "cipher", "Ljavax/crypto/Cipher;", "gcmParameterSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "options", "Lexpo/modules/core/arguments/ReadableArguments;", "encryptionCallback", "Lexpo/modules/securestore/EncryptionCallback;", "postEncryptionCallback", "Lexpo/modules/securestore/PostEncryptionCallback;", "requiresAuthentication", "", "expo-secure-store_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: AuthenticationHelper.kt */
public final class AuthenticationHelper$defaultCallback$1 implements AuthenticationCallback {
    final /* synthetic */ AuthenticationHelper this$0;

    AuthenticationHelper$defaultCallback$1(AuthenticationHelper authenticationHelper) {
        this.this$0 = authenticationHelper;
    }

    public void checkAuthentication(Promise promise, Cipher cipher, GCMParameterSpec gCMParameterSpec, ReadableArguments readableArguments, EncryptionCallback encryptionCallback, PostEncryptionCallback postEncryptionCallback) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(gCMParameterSpec, "gcmParameterSpec");
        Intrinsics.checkNotNullParameter(readableArguments, "options");
        Intrinsics.checkNotNullParameter(encryptionCallback, "encryptionCallback");
        checkAuthentication(promise, readableArguments.getBoolean(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, false), cipher, gCMParameterSpec, readableArguments, encryptionCallback, postEncryptionCallback);
    }

    public void checkAuthentication(Promise promise, boolean z, Cipher cipher, GCMParameterSpec gCMParameterSpec, ReadableArguments readableArguments, EncryptionCallback encryptionCallback, PostEncryptionCallback postEncryptionCallback) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(gCMParameterSpec, "gcmParameterSpec");
        Intrinsics.checkNotNullParameter(readableArguments, "options");
        Intrinsics.checkNotNullParameter(encryptionCallback, "encryptionCallback");
        if (z) {
            this.this$0.openAuthenticationPrompt(promise, readableArguments, encryptionCallback, cipher, gCMParameterSpec, postEncryptionCallback);
        } else {
            this.this$0.handleEncryptionCallback(promise, encryptionCallback, cipher, gCMParameterSpec, postEncryptionCallback);
        }
    }
}
