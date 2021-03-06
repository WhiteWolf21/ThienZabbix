package com.facebook.common.logging;

import java.util.Locale;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m76v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m77v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m78v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m79v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m80v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m68v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m69v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m70v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m71v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m68v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m72v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m82v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m83v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11779v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m74v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11778v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m75v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11779v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m81v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11779v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m73v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo11779v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m36d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m37d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m38d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m39d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m40d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m28d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m29d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m30d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m31d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m32d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m42d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m36d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m43d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m41d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m34d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11767d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m35d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11768d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m41d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11768d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m33d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo11768d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m60i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m61i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m62i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m63i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m64i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m52i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m53i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m54i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m55i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m56i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m66i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m67i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11773i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m58i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11772i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m59i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo11773i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m65i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11773i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m57i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo11773i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m88w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11780w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m84w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11780w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m90w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11780w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m91w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11781w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m86w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11780w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m87w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m85w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m89w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11781w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m85w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo11781w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m48e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11769e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m44e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11769e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m50e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11769e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m51e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11770e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m46e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11769e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m47e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11770e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m49e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11770e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m45e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo11770e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
