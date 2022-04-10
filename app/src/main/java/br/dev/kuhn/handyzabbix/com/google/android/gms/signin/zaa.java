package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa {
    public static final Api<SignInOptions> API;
    private static final Api.ClientKey<SignInClientImpl> CLIENT_KEY;
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaph;
    private static final Scope zar = new Scope(Scopes.PROFILE);
    private static final Api.ClientKey<SignInClientImpl> zars;
    private static final Api.AbstractClientBuilder<SignInClientImpl, Object> zart;
    private static final Api<Object> zaru;
    private static final Scope zas = new Scope("email");

    static {
        Api.ClientKey<SignInClientImpl> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        Api.ClientKey<SignInClientImpl> clientKey2 = new Api.ClientKey<>();
        zars = clientKey2;
        zab zab = new zab();
        zaph = zab;
        zac zac = new zac();
        zart = zac;
        API = new Api<>("SignIn.API", zab, clientKey);
        zaru = new Api<>("SignIn.INTERNAL_API", zac, clientKey2);
    }
}
