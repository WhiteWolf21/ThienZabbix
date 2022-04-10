package br.dev.kuhn.handyzabbix.expo.modules.constants;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.facebook.device.yearclass.YearClass;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.constants.ConstantsInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, mo24974d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appConfig", "", "getAppConfig", "()Ljava/lang/String;", "exponentInstallationId", "Lexpo/modules/constants/ExponentInstallationId;", "sessionId", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "getAppOwnership", "getAppScopeKey", "getConstants", "", "", "getDeviceName", "getDeviceYearClass", "getExportedInterfaces", "", "Ljava/lang/Class;", "getIsDevice", "", "getOrCreateInstallationId", "getStatusBarHeight", "getSystemFonts", "getSystemVersion", "Companion", "ExecutionEnvironment", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ConstantsService.kt */
public class ConstantsService implements InternalModule, ConstantsInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private final ExponentInstallationId exponentInstallationId;
    private final String sessionId;
    private int statusBarHeightInternal;

    public String getAppOwnership() {
        return "guest";
    }

    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    public ConstantsService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Integer valueOf = Integer.valueOf(context2.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        int i = 0;
        valueOf = !(valueOf.intValue() > 0) ? null : valueOf;
        this.statusBarHeightInternal = valueOf != null ? Companion.convertPixelsToDp((float) Integer.valueOf(((Number) new ConstantsService$statusBarHeightInternal$2$1(context2.getResources()).invoke(Integer.valueOf(valueOf.intValue()))).intValue()).intValue(), context2) : i;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        this.sessionId = uuid;
        this.exponentInstallationId = new ExponentInstallationId(context2);
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo24974d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: ConstantsService.kt */
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");
        
        private final String string;

        private ExecutionEnvironment(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ConstantsInterface.class);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m176to("sessionId", this.sessionId), TuplesKt.m176to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.m176to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.m176to("deviceYearClass", Integer.valueOf(getDeviceYearClass())), TuplesKt.m176to("deviceName", getDeviceName()), TuplesKt.m176to("isDevice", Boolean.valueOf(getIsDevice())), TuplesKt.m176to("systemFonts", getSystemFonts()), TuplesKt.m176to("systemVersion", getSystemVersion()), TuplesKt.m176to("installationId", getOrCreateInstallationId()), TuplesKt.m176to("manifest", getAppConfig()), TuplesKt.m176to("platform", MapsKt.mapOf(TuplesKt.m176to("android", MapsKt.emptyMap()))));
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            mutableMapOf.put("nativeAppVersion", packageInfo.versionName);
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(packageInfo, "pInfo");
            mutableMapOf.put("nativeBuildVersion", String.valueOf((int) companion.getLongVersionCode(packageInfo)));
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(ConstantsServiceKt.TAG, "Exception: ", e);
        }
        return mutableMapOf;
    }

    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    public String getDeviceName() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "Build.MODEL");
        return str;
    }

    public int getDeviceYearClass() {
        return YearClass.get(this.context);
    }

    public boolean getIsDevice() {
        Companion companion = Companion;
        return !companion.isRunningOnGenymotion() && !companion.isRunningOnStockEmulator();
    }

    public int getStatusBarHeight() {
        return this.statusBarHeightInternal;
    }

    public String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "Build.VERSION.RELEASE");
        return str;
    }

    public String getOrCreateInstallationId() {
        return this.exponentInstallationId.getOrCreateUUID();
    }

    public List<String> getSystemFonts() {
        return CollectionsKt.listOf("normal", "notoserif", "sans-serif", "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", "serif", "Roboto", "monospace");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getAppConfig() {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = r5.context     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            java.lang.String r2 = "app.config"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            r3 = r1
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x001f }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x001f }
            java.lang.String r3 = org.apache.commons.p014io.IOUtils.toString((java.io.InputStream) r3, (java.nio.charset.Charset) r4)     // Catch:{ all -> 0x001f }
            kotlin.p008io.CloseableKt.closeFinally(r1, r2)     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            return r3
        L_0x001f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r3 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r1, r2)     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
            throw r3     // Catch:{ FileNotFoundException -> 0x0032, Exception -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            java.lang.String r2 = expo.modules.constants.ConstantsServiceKt.TAG
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r3 = "Error reading embedded app config"
            android.util.Log.e(r2, r3, r1)
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.constants.ConstantsService.getAppConfig():java.lang.String");
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0011"}, mo24974d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "()V", "isRunningOnGenymotion", "", "()Z", "isRunningOnStockEmulator", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "getLongVersionCode", "", "info", "Landroid/content/pm/PackageInfo;", "expo-constants_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: ConstantsService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int convertPixelsToDp(float f, Context context) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            return (int) (f / (((float) resources.getDisplayMetrics().densityDpi) / 160.0f));
        }

        /* access modifiers changed from: private */
        public final boolean isRunningOnGenymotion() {
            String str = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(str, "Build.FINGERPRINT");
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "vbox", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final boolean isRunningOnStockEmulator() {
            String str = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(str, "Build.FINGERPRINT");
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "generic", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final long getLongVersionCode(PackageInfo packageInfo) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return (long) packageInfo.versionCode;
        }
    }
}
