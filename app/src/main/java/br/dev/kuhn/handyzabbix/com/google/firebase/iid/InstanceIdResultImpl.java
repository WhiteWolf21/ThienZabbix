package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@20.2.3 */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: id */
    private final String f238id;
    private final String token;

    InstanceIdResultImpl(String str, String str2) {
        this.f238id = str;
        this.token = str2;
    }

    public final String getId() {
        return this.f238id;
    }

    public final String getToken() {
        return this.token;
    }
}
