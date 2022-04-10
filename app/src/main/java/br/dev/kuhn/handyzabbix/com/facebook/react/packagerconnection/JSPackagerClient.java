package com.facebook.react.packagerconnection;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {
    private static final int PROTOCOL_VERSION = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "JSPackagerClient";
    private Map<String, RequestHandler> mRequestHandlers;
    /* access modifiers changed from: private */
    public ReconnectingWebSocket mWebSocket;

    private class ResponderImpl implements Responder {
        private Object mId;

        public ResponderImpl(Object obj) {
            this.mId = obj;
        }

        public void respond(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("result", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e) {
                FLog.m49e(JSPackagerClient.TAG, "Responding failed", (Throwable) e);
            }
        }

        public void error(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e) {
                FLog.m49e(JSPackagerClient.TAG, "Responding with error failed", (Throwable) e);
            }
        }
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map) {
        this(str, packagerConnectionSettings, map, (ReconnectingWebSocket.ConnectionCallback) null);
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map, ReconnectingWebSocket.ConnectionCallback connectionCallback) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("ws").encodedAuthority(packagerConnectionSettings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", packagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", str);
        this.mWebSocket = new ReconnectingWebSocket(builder.build().toString(), this, connectionCallback);
        this.mRequestHandlers = map;
    }

    public void init() {
        this.mWebSocket.connect();
    }

    public void close() {
        this.mWebSocket.closeQuietly();
    }

    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("version");
            String optString = jSONObject.optString("method");
            Object opt = jSONObject.opt("id");
            Object opt2 = jSONObject.opt("params");
            if (optInt != 2) {
                String str2 = TAG;
                FLog.m48e(str2, "Message with incompatible or missing version of protocol received: " + optInt);
            } else if (optString == null) {
                abortOnMessage(opt, "No method provided");
            } else {
                RequestHandler requestHandler = this.mRequestHandlers.get(optString);
                if (requestHandler == null) {
                    abortOnMessage(opt, "No request handler for method: " + optString);
                } else if (opt == null) {
                    requestHandler.onNotification(opt2);
                } else {
                    requestHandler.onRequest(opt2, new ResponderImpl(opt));
                }
            }
        } catch (Exception e) {
            FLog.m49e(TAG, "Handling the message failed", (Throwable) e);
        }
    }

    public void onMessage(ByteString byteString) {
        FLog.m88w(TAG, "Websocket received message with payload of unexpected type binary");
    }

    private void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            new ResponderImpl(obj).error(str);
        }
        String str2 = TAG;
        FLog.m48e(str2, "Handling the message failed with reason: " + str);
    }
}
