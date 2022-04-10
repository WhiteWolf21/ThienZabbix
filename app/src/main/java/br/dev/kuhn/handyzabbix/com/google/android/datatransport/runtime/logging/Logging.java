package com.google.android.datatransport.runtime.logging;

import android.util.Log;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class Logging {
    private Logging() {
    }

    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: d */
    public static void m138d(String str, String str2) {
        Log.d(getTag(str), str2);
    }

    /* renamed from: d */
    public static void m139d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: d */
    public static void m140d(String str, String str2, Object obj, Object obj2) {
        Log.d(getTag(str), String.format(str2, new Object[]{obj, obj2}));
    }

    /* renamed from: d */
    public static void m141d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }

    /* renamed from: i */
    public static void m143i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    /* renamed from: e */
    public static void m142e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    /* renamed from: w */
    public static void m144w(String str, String str2, Object obj) {
        Log.w(getTag(str), String.format(str2, new Object[]{obj}));
    }
}
