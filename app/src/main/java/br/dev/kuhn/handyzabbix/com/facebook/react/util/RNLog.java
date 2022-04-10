package com.facebook.react.util;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.google.firebase.messaging.Constants;

public class RNLog {
    public static final int ADVICE = 4;
    public static final int ERROR = 6;
    public static final int LOG = 2;
    public static final int MINIMUM_LEVEL_FOR_UI = 5;
    public static final int TRACE = 3;
    public static final int WARN = 5;

    private static String levelToString(int i) {
        String str = "log";
        if (!(i == 2 || i == 3)) {
            str = "warn";
            if (!(i == 4 || i == 5)) {
                return i != 6 ? "none" : Constants.IPC_BUNDLE_KEY_SEND_ERROR;
            }
        }
        return str;
    }

    /* renamed from: l */
    public static void m133l(String str) {
        FLog.m60i(ReactConstants.TAG, str);
    }

    /* renamed from: t */
    public static void m134t(String str) {
        FLog.m60i(ReactConstants.TAG, str);
    }

    /* renamed from: a */
    public static void m130a(String str) {
        FLog.m88w(ReactConstants.TAG, "(ADVICE)" + str);
    }

    /* renamed from: w */
    public static void m135w(ReactContext reactContext, String str) {
        logInternal(reactContext, str, 5);
        FLog.m88w(ReactConstants.TAG, str);
    }

    /* renamed from: e */
    public static void m131e(ReactContext reactContext, String str) {
        logInternal(reactContext, str, 6);
        FLog.m48e(ReactConstants.TAG, str);
    }

    /* renamed from: e */
    public static void m132e(String str) {
        FLog.m48e(ReactConstants.TAG, str);
    }

    private static void logInternal(ReactContext reactContext, String str, int i) {
        if (i >= 5 && reactContext != null && str != null) {
            ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(levelToString(i), str);
        }
    }
}
