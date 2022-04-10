package br.dev.kuhn.handyzabbix.expo.modules.splashscreen.exceptions;

import expo.modules.core.errors.CodedException;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo24974d2 = {"Lexpo/modules/splashscreen/exceptions/NoContentViewException;", "Lexpo/modules/core/errors/CodedException;", "()V", "getCode", "", "expo-splash-screen_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: NoContentViewException.kt */
public final class NoContentViewException extends CodedException {
    public String getCode() {
        return "ERR_NO_CONTENT_VIEW_FOUND";
    }

    public NoContentViewException() {
        super("ContentView is not yet available. Call 'SplashScreen.show(...)' once 'setContentView()' is called.");
    }
}
