package br.dev.kuhn.handyzabbix.expo.modules.constants;

import android.content.Context;
import android.content.SharedPreferences;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.serverregistration.InstallationId;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo24974d2 = {"Lexpo/modules/constants/ExponentInstallationId;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mSharedPreferences", "Landroid/content/SharedPreferences;", "nonBackedUpUuidFile", "Ljava/io/File;", "getNonBackedUpUuidFile", "()Ljava/io/File;", "uuid", "", "getOrCreateUUID", "getUUID", "Companion", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ExponentInstallationId.kt */
public final class ExponentInstallationId {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LEGACY_UUID_KEY = "uuid";
    public static final String UUID_FILE_NAME = "expo_installation_uuid.txt";
    private final Context context;
    private final SharedPreferences mSharedPreferences;
    private String uuid;

    public ExponentInstallationId(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(InstallationId.LEGACY_PREFERENCES_FILE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.mSharedPreferences = sharedPreferences;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0080, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0084, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getUUID() {
        /*
            r7 = this;
            java.lang.String r0 = r7.uuid
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.io.File r0 = r7.getNonBackedUpUuidFile()
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x004d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x004d }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x004d }
            r3 = r1
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x004d }
            r4 = r2
            java.io.FileReader r4 = (java.io.FileReader) r4     // Catch:{ all -> 0x0046 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0046 }
            java.io.Reader r4 = (java.io.Reader) r4     // Catch:{ all -> 0x0046 }
            r5.<init>(r4)     // Catch:{ all -> 0x0046 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x0046 }
            r4 = r1
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0046 }
            r6 = r5
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x003f }
            java.lang.String r6 = r6.readLine()     // Catch:{ all -> 0x003f }
            java.util.UUID r6 = java.util.UUID.fromString(r6)     // Catch:{ all -> 0x003f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x003f }
            r7.uuid = r6     // Catch:{ all -> 0x003f }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003f }
            kotlin.p008io.CloseableKt.closeFinally(r5, r4)     // Catch:{ all -> 0x0046 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0046 }
            kotlin.p008io.CloseableKt.closeFinally(r2, r3)     // Catch:{ Exception -> 0x004d }
            goto L_0x0057
        L_0x003f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r4 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r5, r3)     // Catch:{ all -> 0x0046 }
            throw r4     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r4 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r2, r3)     // Catch:{ Exception -> 0x004d }
            throw r4     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            r2 = move-exception
            boolean r3 = r2 instanceof java.io.IOException
            if (r3 == 0) goto L_0x0053
            goto L_0x0057
        L_0x0053:
            boolean r3 = r2 instanceof java.lang.IllegalArgumentException
            if (r3 == 0) goto L_0x00b1
        L_0x0057:
            java.lang.String r2 = r7.uuid
            if (r2 == 0) goto L_0x005c
            return r2
        L_0x005c:
            android.content.SharedPreferences r2 = r7.mSharedPreferences
            java.lang.String r3 = "uuid"
            java.lang.String r2 = r2.getString(r3, r1)
            if (r2 == 0) goto L_0x00ae
            r7.uuid = r2
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x0085 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0085 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ IOException -> 0x0085 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ IOException -> 0x0085 }
            r0 = r4
            java.io.FileWriter r0 = (java.io.FileWriter) r0     // Catch:{ all -> 0x007e }
            r0.write(r2)     // Catch:{ all -> 0x007e }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007e }
            kotlin.p008io.CloseableKt.closeFinally(r4, r1)     // Catch:{ IOException -> 0x0085 }
            r0 = 1
            goto L_0x009f
        L_0x007e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r4, r0)     // Catch:{ IOException -> 0x0085 }
            throw r1     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.String r1 = expo.modules.constants.ExponentInstallationIdKt.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Error while migrating UUID from legacy storage. "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
            r0 = 0
        L_0x009f:
            if (r0 == 0) goto L_0x00ae
            android.content.SharedPreferences r0 = r7.mSharedPreferences
            android.content.SharedPreferences$Editor r0 = r0.edit()
            android.content.SharedPreferences$Editor r0 = r0.remove(r3)
            r0.apply()
        L_0x00ae:
            java.lang.String r0 = r7.uuid
            return r0
        L_0x00b1:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.constants.ExponentInstallationId.getUUID():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getOrCreateUUID() {
        /*
            r4 = this;
            java.lang.String r0 = r4.getUUID()
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r4.uuid = r0
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ IOException -> 0x0034 }
            java.io.File r1 = r4.getNonBackedUpUuidFile()     // Catch:{ IOException -> 0x0034 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0034 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ IOException -> 0x0034 }
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ IOException -> 0x0034 }
            r2 = r0
            java.io.FileWriter r2 = (java.io.FileWriter) r2     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r4.uuid     // Catch:{ all -> 0x002d }
            r2.write(r3)     // Catch:{ all -> 0x002d }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            kotlin.p008io.CloseableKt.closeFinally(r0, r1)     // Catch:{ IOException -> 0x0034 }
            goto L_0x004d
        L_0x002d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002f }
        L_0x002f:
            r2 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r0, r1)     // Catch:{ IOException -> 0x0034 }
            throw r2     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            java.lang.String r1 = expo.modules.constants.ExponentInstallationIdKt.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error while writing new UUID. "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
        L_0x004d:
            java.lang.String r0 = r4.uuid
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.constants.ExponentInstallationId.getOrCreateUUID():java.lang.String");
    }

    private final File getNonBackedUpUuidFile() {
        return new File(this.context.getNoBackupFilesDir(), "expo_installation_uuid.txt");
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/constants/ExponentInstallationId$Companion;", "", "()V", "LEGACY_UUID_KEY", "", "UUID_FILE_NAME", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: ExponentInstallationId.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
