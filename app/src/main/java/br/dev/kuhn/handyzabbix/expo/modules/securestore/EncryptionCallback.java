package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import expo.modules.core.Promise;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import org.json.JSONException;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo24974d2 = {"Lexpo/modules/securestore/EncryptionCallback;", "", "run", "promise", "Lexpo/modules/core/Promise;", "cipher", "Ljavax/crypto/Cipher;", "gcmParameterSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "postEncryptionCallback", "Lexpo/modules/securestore/PostEncryptionCallback;", "expo-secure-store_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: EncryptionCallback.kt */
public interface EncryptionCallback {
    Object run(Promise promise, Cipher cipher, GCMParameterSpec gCMParameterSpec, PostEncryptionCallback postEncryptionCallback) throws GeneralSecurityException, JSONException;
}
