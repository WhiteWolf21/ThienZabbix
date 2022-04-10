package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import expo.modules.core.Promise;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import org.json.JSONException;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\u0007"}, mo24974d2 = {"Lexpo/modules/securestore/PostEncryptionCallback;", "", "run", "", "promise", "Lexpo/modules/core/Promise;", "result", "expo-secure-store_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: PostEncryptionCallback.kt */
public interface PostEncryptionCallback {
    void run(Promise promise, Object obj) throws JSONException, GeneralSecurityException;
}
