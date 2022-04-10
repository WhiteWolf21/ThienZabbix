package com.google.android.gms.common.config;

import android.content.Context;
import android.util.Log;
import java.util.HashSet;

public abstract class GservicesValue<T> {
    private static final Object sLock = new Object();
    private static zza zzbm;
    private static int zzbn;
    private static Context zzbo;
    private static HashSet<String> zzbp;
    protected final String mKey;
    protected final T zzbq;
    private T zzbr = null;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);
    }

    public static boolean isInitialized() {
        synchronized (sLock) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract T zzd(String str);

    private static boolean zzi() {
        synchronized (sLock) {
        }
        return false;
    }

    protected GservicesValue(String str, T t) {
        this.mKey = str;
        this.zzbq = t;
    }

    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzbr = t;
        synchronized (sLock) {
            zzi();
        }
    }

    public void resetOverride() {
        this.zzbr = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3 = zzd(r4.mKey);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0030, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0035, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0036, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0039, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r4 = this;
            T r0 = r4.zzbr
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = sLock
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            monitor-enter(r1)
            r2 = 0
            zzbp = r2     // Catch:{ all -> 0x003a }
            zzbo = r2     // Catch:{ all -> 0x003a }
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r1 = r4.mKey     // Catch:{ SecurityException -> 0x0020 }
            java.lang.Object r1 = r4.zzd(r1)     // Catch:{ SecurityException -> 0x0020 }
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x001e:
            r1 = move-exception
            goto L_0x0036
        L_0x0020:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x001e }
            java.lang.String r3 = r4.mKey     // Catch:{ all -> 0x0031 }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ all -> 0x0031 }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001e }
            android.os.StrictMode.setThreadPolicy(r0)
            return r3
        L_0x0031:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001e }
            throw r3     // Catch:{ all -> 0x001e }
        L_0x0036:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x003a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.get():java.lang.Object");
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zzd(str, f);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }
}
