package com.facebook.common.logging;

public interface LoggingDelegate {
    /* renamed from: d */
    void mo11767d(String str, String str2);

    /* renamed from: d */
    void mo11768d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo11769e(String str, String str2);

    /* renamed from: e */
    void mo11770e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo11772i(String str, String str2);

    /* renamed from: i */
    void mo11773i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo11778v(String str, String str2);

    /* renamed from: v */
    void mo11779v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo11780w(String str, String str2);

    /* renamed from: w */
    void mo11781w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
