package br.dev.kuhn.handyzabbix.expo.modules.kotlin;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo24974d2 = {"Lexpo/modules/kotlin/KPromiseWrapper;", "Lexpo/modules/kotlin/Promise;", "bridgePromise", "Lcom/facebook/react/bridge/Promise;", "(Lcom/facebook/react/bridge/Promise;)V", "reject", "", "code", "", "message", "cause", "", "resolve", "value", "", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: KPromiseWrapper.kt */
public final class KPromiseWrapper implements Promise {
    private final Promise bridgePromise;

    public KPromiseWrapper(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "bridgePromise");
        this.bridgePromise = promise;
    }

    public void reject(CodedException codedException) {
        Intrinsics.checkNotNullParameter(codedException, NotificationsService.EXCEPTION_KEY);
        Promise.DefaultImpls.reject(this, codedException);
    }

    public void resolve(Object obj) {
        com.facebook.react.bridge.Promise promise = this.bridgePromise;
        if (obj instanceof Unit) {
            obj = null;
        } else if (obj instanceof Bundle) {
            obj = Arguments.fromBundle((Bundle) obj);
        } else if (obj instanceof List) {
            obj = Arguments.fromList((List) obj);
        }
        promise.resolve(obj);
    }

    public void reject(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "code");
        this.bridgePromise.reject(str, str2, th);
    }
}
