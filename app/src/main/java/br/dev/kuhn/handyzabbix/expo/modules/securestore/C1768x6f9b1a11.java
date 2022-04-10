package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.Promise;
import br.dev.kuhn.handyzabbix.expo.modules.securestore.AuthenticationHelper$openAuthenticationPrompt$1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo24974d2 = {"<anonymous>", "", "promise", "Lexpo/modules/core/Promise;", "result", "", "run"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* renamed from: expo.modules.securestore.AuthenticationHelper$openAuthenticationPrompt$1$1$onAuthenticationSucceeded$1 */
/* compiled from: AuthenticationHelper.kt */
final class C1768x6f9b1a11 implements PostEncryptionCallback {
    final /* synthetic */ AuthenticationHelper$openAuthenticationPrompt$1.C17671 this$0;

    C1768x6f9b1a11(AuthenticationHelper$openAuthenticationPrompt$1.C17671 r1) {
        this.this$0 = r1;
    }

    public final void run(Promise promise, Object obj) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(obj, "result");
        ((JSONObject) obj).put(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, true);
        PostEncryptionCallback postEncryptionCallback = this.this$0.this$0.$postEncryptionCallback;
        if (postEncryptionCallback != null) {
            postEncryptionCallback.run(promise, obj);
        }
    }
}
