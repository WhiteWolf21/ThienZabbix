package br.dev.kuhn.handyzabbix.com.facebook.react.bridge;

import android.content.Context;

public class ReactApplicationContext extends com.facebook.react.bridge.ReactContext {
    public ReactApplicationContext(Context context) {
        super(context.getApplicationContext());
    }
}
