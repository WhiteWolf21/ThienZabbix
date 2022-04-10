package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

public final class Common {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zai> CLIENT_KEY;
    private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> zaph;
    public static final zac zapi = new zad();

    static {
        Api.ClientKey<zai> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zab zab = new zab();
        zaph = zab;
        API = new Api<>("Common.API", zab, clientKey);
    }
}
