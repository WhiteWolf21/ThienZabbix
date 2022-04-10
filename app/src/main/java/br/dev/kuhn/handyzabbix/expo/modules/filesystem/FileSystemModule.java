package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.services.UIManager;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.filesystem.Permission;
import br.dev.kuhn.handyzabbix.expo.modules.interfaces.permissions.PermissionsResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.p014io.FileUtils;
import org.apache.commons.p014io.FilenameUtils;
import org.apache.commons.p014io.IOUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\f\u0001\u0001\u0001\u0001\u0001\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010 \u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J.\u0010&\u001a\u0004\u0018\u00010'2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J.\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J>\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0002J2\u00102\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J<\u00103\u001a\u00020!2\u0006\u00100\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\u0006\u0010%\u001a\u00020\u000bH\u0007J\u0018\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007JJ\u00106\u001a\u00020!2\u0006\u00100\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\b\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u001fH\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>H\u0002J \u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#H\u0016J\u0018\u0010B\u001a\u00020!2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J \u0010C\u001a\u00020\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000bH\u0007J0\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J\u0010\u0010I\u001a\u00020J2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020JH\u0002J\b\u0010N\u001a\u00020\u0011H\u0016J\u0012\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0010\u0010S\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000bH\u0007J2\u0010T\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J$\u0010U\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010V\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J\u0010\u0010W\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001f\u0010X\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u0001HZHZ0Y\"\u0006\b\u0000\u0010Z\u0018\u0001H\bJ(\u0010\\\u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J\u0018\u0010]\u001a\u00020!2\u0006\u00105\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J*\u0010^\u001a\u00020!2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0017J\u0010\u0010f\u001a\u00020!2\u0006\u0010X\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020eH\u0016J\u0010\u0010j\u001a\u00020J2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0012\u0010k\u001a\u00020J2\b\u0010l\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010m\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0002J\u001a\u0010n\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020>0o2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0018\u0010r\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010o2\u0006\u0010<\u001a\u00020\u001bH\u0002J2\u0010s\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J4\u0010t\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\u0006\u0010%\u001a\u00020\u000bH\u0007J4\u0010u\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\u0006\u0010%\u001a\u00020\u000bH\u0007J\u001a\u0010v\u001a\u00020!2\b\u0010w\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020\u000bH\u0007J \u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00020P2\u0006\u0010z\u001a\u00020\u001f2\u0006\u0010{\u001a\u00020\u001aH\u0002J\u0010\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020H\u0002J5\u0010\u0001\u001a\u00020!2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J=\u0010\u0001\u001a\u00020!2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J>\u0010\u0001\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\u0016\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010%\u001a\u00020\u000bH\u0007J\r\u0010\u0001\u001a\u00020!*\u00020\u001bH\u0002J\r\u0010\u0001\u001a\u00020!*\u00020\u001bH\u0002J\r\u0010\u0001\u001a\u00020\u001f*\u00020\u001bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001c¨\u0006\u0001"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule;", "Lexpo/modules/core/ExportedModule;", "Lexpo/modules/core/interfaces/ActivityEventListener;", "context", "Landroid/content/Context;", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistryDelegate;)V", "client", "Lokhttp3/OkHttpClient;", "dirPermissionsRequest", "Lexpo/modules/core/Promise;", "okHttpClient", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "taskHandlers", "", "", "Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "uIManager", "Lexpo/modules/core/interfaces/services/UIManager;", "getUIManager", "()Lexpo/modules/core/interfaces/services/UIManager;", "uIManager$delegate", "Lkotlin/Lazy;", "isSAFUri", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "contentUriFromFile", "file", "Ljava/io/File;", "copyAsync", "", "options", "", "", "promise", "createRequestBody", "Lokhttp3/RequestBody;", "decorator", "Lexpo/modules/filesystem/RequestBodyDecorator;", "createSAFFileAsync", "uriStr", "fileName", "mimeType", "createUploadRequest", "Lokhttp3/Request;", "url", "fileUriString", "deleteAsync", "downloadAsync", "downloadResumablePauseAsync", "uuid", "downloadResumableStartAsync", "fileUriStr", "resumeData", "ensureDirExists", "dir", "ensurePermission", "uri", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "errorMsg", "forceDelete", "getConstants", "getContentUriAsync", "getEncodingFromOptions", "getFileSize", "", "getFreeDiskStorageAsync", "getInfoAsync", "_uriStr", "getInputStream", "Ljava/io/InputStream;", "getInputStreamBytes", "", "inputStream", "getName", "getNearestSAFFile", "Landroidx/documentfile/provider/DocumentFile;", "getOutputStream", "Ljava/io/OutputStream;", "getTotalDiskCapacityAsync", "makeDirectoryAsync", "makeSAFDirectoryAsync", "dirName", "md5", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "moveAsync", "networkTaskCancelAsync", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "onNewIntent", "intent", "openAssetInputStream", "openResourceInputStream", "resourceName", "parseFileUri", "permissionsForPath", "Ljava/util/EnumSet;", "path", "permissionsForSAFUri", "permissionsForUri", "readAsStringAsync", "readDirectoryAsync", "readSAFDirectoryAsync", "requestDirectoryPermissionsAsync", "initialFileUrl", "transformFilesFromSAF", "documentFile", "outputDir", "copy", "translateHeaders", "Landroid/os/Bundle;", "headers", "Lokhttp3/Headers;", "uploadAsync", "uploadTaskStartAsync", "writeAsStringAsync", "string", "checkIfFileDirExists", "checkIfFileExists", "toFile", "DownloadResumableTask", "DownloadResumableTaskParams", "DownloadTaskHandler", "ProgressListener", "ProgressResponseBody", "TaskHandler", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
public class FileSystemModule extends ExportedModule implements ActivityEventListener {
    private OkHttpClient client;
    private Promise dirPermissionsRequest;
    /* access modifiers changed from: private */
    public final ModuleRegistryDelegate moduleRegistryDelegate;
    private final Map<String, TaskHandler> taskHandlers;
    private final Lazy uIManager$delegate;

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$ProgressListener;", "", "update", "", "bytesRead", "", "contentLength", "done", "", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    public interface ProgressListener {
        void update(long j, long j2, boolean z);
    }

    private final UIManager getUIManager() {
        return (UIManager) this.uIManager$delegate.getValue();
    }

    public String getName() {
        return "ExponentFileSystem";
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileSystemModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new ModuleRegistryDelegate() : moduleRegistryDelegate2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleRegistryDelegate2, "moduleRegistryDelegate");
        this.moduleRegistryDelegate = moduleRegistryDelegate2;
        try {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            File filesDir = context2.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "getContext().filesDir");
            ensureDirExists(filesDir);
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext()");
            File cacheDir = context3.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getContext().cacheDir");
            ensureDirExists(cacheDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.uIManager$delegate = LazyKt.lazy(new FileSystemModule$$special$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
        this.taskHandlers = new HashMap();
    }

    /* access modifiers changed from: private */
    public final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate access$getModuleRegistryDelegate$p = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new FileSystemModule$moduleRegistry$$inlined$getFromModuleRegistry$1(access$getModuleRegistryDelegate$p));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    public Map<String, Object> getConstants() {
        StringBuilder sb = new StringBuilder();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        sb.append(Uri.fromFile(context.getFilesDir()).toString());
        sb.append("/");
        StringBuilder sb2 = new StringBuilder();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        sb2.append(Uri.fromFile(context2.getCacheDir()).toString());
        sb2.append("/");
        return MapsKt.mapOf(TuplesKt.m176to("documentDirectory", sb.toString()), TuplesKt.m176to("cacheDirectory", sb2.toString()), TuplesKt.m176to("bundleDirectory", "asset:///"));
    }

    private final void checkIfFileExists(Uri uri) throws IOException {
        File file = toFile(uri);
        if (!file.exists()) {
            throw new IOException("Directory for '" + file.getPath() + "' doesn't exist.");
        }
    }

    private final void checkIfFileDirExists(Uri uri) throws IOException {
        File file = toFile(uri);
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            throw new IOException("Directory for '" + file.getPath() + "' doesn't exist. Please make sure directory '" + file.getParent() + "' exists before calling downloadAsync.");
        }
    }

    private final EnumSet<Permission> permissionsForUri(Uri uri) {
        if (isSAFUri(uri)) {
            return permissionsForSAFUri(uri);
        }
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_CONTENT_SCHEME)) {
            return EnumSet.of(Permission.READ);
        }
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_ASSET_SCHEME)) {
            return EnumSet.of(Permission.READ);
        }
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            return permissionsForPath(uri.getPath());
        }
        if (uri.getScheme() == null) {
            return EnumSet.of(Permission.READ);
        }
        return EnumSet.noneOf(Permission.class);
    }

    private final EnumSet<Permission> permissionsForSAFUri(Uri uri) {
        DocumentFile nearestSAFFile = getNearestSAFFile(uri);
        EnumSet<Permission> noneOf = EnumSet.noneOf(Permission.class);
        if (nearestSAFFile != null) {
            if (nearestSAFFile.canRead()) {
                noneOf.add(Permission.READ);
            }
            if (nearestSAFFile.canWrite()) {
                noneOf.add(Permission.WRITE);
            }
        }
        Intrinsics.checkNotNullExpressionValue(noneOf, "EnumSet.noneOf(Permissio…)\n        }\n      }\n    }");
        return noneOf;
    }

    private final void ensurePermission(Uri uri, Permission permission, String str) throws IOException {
        EnumSet<Permission> permissionsForUri = permissionsForUri(uri);
        if (permissionsForUri == null || !permissionsForUri.contains(permission)) {
            throw new IOException(str);
        }
    }

    private final void ensurePermission(Uri uri, Permission permission) throws IOException {
        if (permission == Permission.READ) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't readable.");
        }
        if (permission == Permission.WRITE) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't writable.");
        }
        ensurePermission(uri, permission, "Location '" + uri + "' doesn't have permission '" + permission.name() + "'.");
    }

    private final InputStream openAssetInputStream(Uri uri) throws IOException {
        String path = uri.getPath();
        if (path != null) {
            String substring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            InputStream open = context.getAssets().open(substring);
            Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(asset)");
            return open;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final InputStream openResourceInputStream(String str) throws IOException {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int identifier = resources.getIdentifier(str, "raw", context2.getPackageName());
        if (identifier == 0) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            Resources resources2 = context3.getResources();
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            identifier = resources2.getIdentifier(str, "drawable", context4.getPackageName());
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found with the name '" + str + '\'');
            }
        }
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        InputStream openRawResource = context5.getResources().openRawResource(identifier);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRawResource(resourceId)");
        return openRawResource;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|67) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r0 = new android.os.Bundle();
        r0.putBoolean("exists", false);
        r0.putBoolean("isDirectory", false);
        r3 = kotlin.Unit.INSTANCE;
        r2.resolve(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0191 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013f A[Catch:{ FileNotFoundException -> 0x0191 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0189 A[Catch:{ FileNotFoundException -> 0x0191 }] */
    @expo.modules.core.interfaces.ExpoMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getInfoAsync(java.lang.String r17, java.util.Map<java.lang.String, ? extends java.lang.Object> r18, expo.modules.core.Promise r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            java.lang.String r3 = "content"
            java.lang.String r4 = "file"
            java.lang.String r5 = "uri"
            java.lang.String r6 = "_uriStr"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            java.lang.String r6 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            android.net.Uri r6 = android.net.Uri.parse(r17)     // Catch:{ Exception -> 0x01a3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r8 = r6.getScheme()     // Catch:{ Exception -> 0x01a3 }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r4)     // Catch:{ Exception -> 0x01a3 }
            if (r8 == 0) goto L_0x0037
            java.lang.String r7 = r16.parseFileUri(r17)     // Catch:{ Exception -> 0x01a3 }
            android.net.Uri r8 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x01a3 }
            goto L_0x0038
        L_0x0037:
            r8 = r6
        L_0x0038:
            java.lang.String r9 = "absoluteUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ Exception -> 0x01a3 }
            expo.modules.interfaces.filesystem.Permission r9 = expo.modules.interfaces.filesystem.Permission.READ     // Catch:{ Exception -> 0x01a3 }
            r1.ensurePermission(r8, r9)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r9 = r6.getScheme()     // Catch:{ Exception -> 0x01a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r9 = "size"
            java.lang.String r10 = "isDirectory"
            r11 = 1
            java.lang.String r12 = "exists"
            java.lang.String r13 = "md5"
            r14 = 0
            if (r4 == 0) goto L_0x00c5
            java.io.File r3 = r1.toFile(r8)     // Catch:{ Exception -> 0x01a3 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x01a3 }
            if (r4 == 0) goto L_0x00b3
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x01a3 }
            r4.<init>()     // Catch:{ Exception -> 0x01a3 }
            r4.putBoolean(r12, r11)     // Catch:{ Exception -> 0x01a3 }
            boolean r6 = r3.isDirectory()     // Catch:{ Exception -> 0x01a3 }
            r4.putBoolean(r10, r6)     // Catch:{ Exception -> 0x01a3 }
            android.net.Uri r6 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a3 }
            r4.putString(r5, r6)     // Catch:{ Exception -> 0x01a3 }
            long r5 = r1.getFileSize(r3)     // Catch:{ Exception -> 0x01a3 }
            double r5 = (double) r5     // Catch:{ Exception -> 0x01a3 }
            r4.putDouble(r9, r5)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r5 = "modificationTime"
            r6 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            long r8 = r3.lastModified()     // Catch:{ Exception -> 0x01a3 }
            double r8 = (double) r8     // Catch:{ Exception -> 0x01a3 }
            double r8 = r8 * r6
            r4.putDouble(r5, r8)     // Catch:{ Exception -> 0x01a3 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ Exception -> 0x01a3 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r11)     // Catch:{ Exception -> 0x01a3 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ Exception -> 0x01a3 }
            if (r5 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            if (r0 == 0) goto L_0x00ac
            java.lang.String r0 = r1.md5(r3)     // Catch:{ Exception -> 0x01a3 }
            r4.putString(r13, r0)     // Catch:{ Exception -> 0x01a3 }
        L_0x00ac:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01a3 }
            r2.resolve(r4)     // Catch:{ Exception -> 0x01a3 }
            goto L_0x01b6
        L_0x00b3:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x01a3 }
            r0.<init>()     // Catch:{ Exception -> 0x01a3 }
            r0.putBoolean(r12, r14)     // Catch:{ Exception -> 0x01a3 }
            r0.putBoolean(r10, r14)     // Catch:{ Exception -> 0x01a3 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01a3 }
            r2.resolve(r0)     // Catch:{ Exception -> 0x01a3 }
            goto L_0x01b6
        L_0x00c5:
            java.lang.String r4 = r6.getScheme()     // Catch:{ Exception -> 0x01a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r8 = "asset"
            if (r4 != 0) goto L_0x0100
            java.lang.String r4 = r6.getScheme()     // Catch:{ Exception -> 0x01a3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r8)     // Catch:{ Exception -> 0x01a3 }
            if (r4 != 0) goto L_0x0100
            java.lang.String r4 = r6.getScheme()     // Catch:{ Exception -> 0x01a3 }
            if (r4 != 0) goto L_0x00e2
            goto L_0x0100
        L_0x00e2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x01a3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a3 }
            r3.<init>()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r4 = "Unsupported scheme for location '"
            r3.append(r4)     // Catch:{ Exception -> 0x01a3 }
            r3.append(r6)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r4 = "'."
            r3.append(r4)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01a3 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x01a3 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x01a3 }
            throw r0     // Catch:{ Exception -> 0x01a3 }
        L_0x0100:
            java.lang.String r4 = r6.getScheme()     // Catch:{ FileNotFoundException -> 0x0191 }
            if (r4 != 0) goto L_0x0107
            goto L_0x0139
        L_0x0107:
            int r15 = r4.hashCode()     // Catch:{ FileNotFoundException -> 0x0191 }
            r14 = 93121264(0x58ceaf0, float:1.3251839E-35)
            if (r15 == r14) goto L_0x012e
            r8 = 951530617(0x38b73479, float:8.735894E-5)
            if (r15 == r8) goto L_0x0116
            goto L_0x0139
        L_0x0116:
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0191 }
            if (r3 == 0) goto L_0x0139
            android.content.Context r3 = r16.getContext()     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x0191 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0191 }
            java.io.InputStream r3 = r3.openInputStream(r6)     // Catch:{ FileNotFoundException -> 0x0191 }
            goto L_0x013d
        L_0x012e:
            boolean r3 = r4.equals(r8)     // Catch:{ FileNotFoundException -> 0x0191 }
            if (r3 == 0) goto L_0x0139
            java.io.InputStream r3 = r1.openAssetInputStream(r6)     // Catch:{ FileNotFoundException -> 0x0191 }
            goto L_0x013d
        L_0x0139:
            java.io.InputStream r3 = r1.openResourceInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0191 }
        L_0x013d:
            if (r3 == 0) goto L_0x0189
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ FileNotFoundException -> 0x0191 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0191 }
            r4.putBoolean(r12, r11)     // Catch:{ FileNotFoundException -> 0x0191 }
            r7 = 0
            r4.putBoolean(r10, r7)     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x0191 }
            r4.putString(r5, r6)     // Catch:{ FileNotFoundException -> 0x0191 }
            int r5 = r3.available()     // Catch:{ FileNotFoundException -> 0x0191 }
            double r5 = (double) r5     // Catch:{ FileNotFoundException -> 0x0191 }
            r4.putDouble(r9, r5)     // Catch:{ FileNotFoundException -> 0x0191 }
            boolean r5 = r0.containsKey(r13)     // Catch:{ FileNotFoundException -> 0x0191 }
            if (r5 == 0) goto L_0x0183
            java.lang.Object r0 = r0.get(r13)     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r11)     // Catch:{ FileNotFoundException -> 0x0191 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ FileNotFoundException -> 0x0191 }
            if (r0 == 0) goto L_0x0183
            byte[] r0 = org.apache.commons.codec.digest.DigestUtils.md5((java.io.InputStream) r3)     // Catch:{ FileNotFoundException -> 0x0191 }
            char[] r0 = org.apache.commons.codec.binary.Hex.encodeHex(r0)     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.String r3 = "Hex.encodeHex(md5bytes)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.String r3 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0191 }
            r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0191 }
            r4.putString(r13, r3)     // Catch:{ FileNotFoundException -> 0x0191 }
        L_0x0183:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ FileNotFoundException -> 0x0191 }
            r2.resolve(r4)     // Catch:{ FileNotFoundException -> 0x0191 }
            goto L_0x01b6
        L_0x0189:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0191 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0191 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ FileNotFoundException -> 0x0191 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0191 }
        L_0x0191:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x01a3 }
            r0.<init>()     // Catch:{ Exception -> 0x01a3 }
            r3 = 0
            r0.putBoolean(r12, r3)     // Catch:{ Exception -> 0x01a3 }
            r0.putBoolean(r10, r3)     // Catch:{ Exception -> 0x01a3 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01a3 }
            r2.resolve(r0)     // Catch:{ Exception -> 0x01a3 }
            goto L_0x01b6
        L_0x01a3:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01b1
            java.lang.String r4 = expo.modules.filesystem.FileSystemModuleKt.TAG
            android.util.Log.e(r4, r3)
        L_0x01b1:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.reject(r0)
        L_0x01b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.getInfoAsync(java.lang.String, java.util.Map, expo.modules.core.Promise):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        throw r0;
     */
    @expo.modules.core.interfaces.ExpoMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readAsStringAsync(java.lang.String r9, java.util.Map<java.lang.String, ? extends java.lang.Object> r10, expo.modules.core.Promise r11) {
        /*
            r8 = this;
            java.lang.String r0 = "position"
            java.lang.String r1 = "length"
            java.lang.String r2 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            android.net.Uri r2 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x010c }
            java.lang.String r3 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x010c }
            expo.modules.interfaces.filesystem.Permission r3 = expo.modules.interfaces.filesystem.Permission.READ     // Catch:{ Exception -> 0x010c }
            r8.ensurePermission(r2, r3)     // Catch:{ Exception -> 0x010c }
            java.lang.String r3 = r8.getEncodingFromOptions(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.String r4 = "base64"
            r5 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r3, r4, r5)     // Catch:{ Exception -> 0x010c }
            if (r3 == 0) goto L_0x008d
            java.io.InputStream r9 = r8.getInputStream(r2)     // Catch:{ Exception -> 0x010c }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ Exception -> 0x010c }
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ Exception -> 0x010c }
            r3 = r9
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x0086 }
            boolean r4 = r10.containsKey(r1)     // Catch:{ all -> 0x0086 }
            r5 = 2
            if (r4 == 0) goto L_0x0078
            boolean r4 = r10.containsKey(r0)     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x0078
            java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Number"
            if (r1 == 0) goto L_0x0072
            java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ all -> 0x0086 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0086 }
            if (r10 == 0) goto L_0x006c
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ all -> 0x0086 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0086 }
            byte[] r0 = new byte[r1]     // Catch:{ all -> 0x0086 }
            long r6 = (long) r10     // Catch:{ all -> 0x0086 }
            r3.skip(r6)     // Catch:{ all -> 0x0086 }
            r10 = 0
            int r1 = r3.read(r0, r10, r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = android.util.Base64.encodeToString(r0, r10, r1, r5)     // Catch:{ all -> 0x0086 }
            goto L_0x0080
        L_0x006c:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ all -> 0x0086 }
            r10.<init>(r4)     // Catch:{ all -> 0x0086 }
            throw r10     // Catch:{ all -> 0x0086 }
        L_0x0072:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ all -> 0x0086 }
            r10.<init>(r4)     // Catch:{ all -> 0x0086 }
            throw r10     // Catch:{ all -> 0x0086 }
        L_0x0078:
            byte[] r10 = r8.getInputStreamBytes(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = android.util.Base64.encodeToString(r10, r5)     // Catch:{ all -> 0x0086 }
        L_0x0080:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0086 }
            kotlin.p008io.CloseableKt.closeFinally(r9, r2)     // Catch:{ Exception -> 0x010c }
            goto L_0x00ea
        L_0x0086:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r9, r10)     // Catch:{ Exception -> 0x010c }
            throw r0     // Catch:{ Exception -> 0x010c }
        L_0x008d:
            java.lang.String r10 = r2.getScheme()     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "file"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ Exception -> 0x010c }
            if (r10 == 0) goto L_0x00aa
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x010c }
            java.io.File r10 = r8.toFile(r2)     // Catch:{ Exception -> 0x010c }
            r9.<init>(r10)     // Catch:{ Exception -> 0x010c }
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch:{ Exception -> 0x010c }
            java.lang.String r9 = org.apache.commons.p014io.IOUtils.toString((java.io.InputStream) r9)     // Catch:{ Exception -> 0x010c }
        L_0x00a8:
            r10 = r9
            goto L_0x00ea
        L_0x00aa:
            java.lang.String r10 = r2.getScheme()     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "asset"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ Exception -> 0x010c }
            if (r10 == 0) goto L_0x00bf
            java.io.InputStream r9 = r8.openAssetInputStream(r2)     // Catch:{ Exception -> 0x010c }
            java.lang.String r9 = org.apache.commons.p014io.IOUtils.toString((java.io.InputStream) r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x00a8
        L_0x00bf:
            java.lang.String r10 = r2.getScheme()     // Catch:{ Exception -> 0x010c }
            if (r10 != 0) goto L_0x00ce
            java.io.InputStream r9 = r8.openResourceInputStream(r9)     // Catch:{ Exception -> 0x010c }
            java.lang.String r9 = org.apache.commons.p014io.IOUtils.toString((java.io.InputStream) r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x00a8
        L_0x00ce:
            boolean r9 = r8.isSAFUri(r2)     // Catch:{ Exception -> 0x010c }
            if (r9 == 0) goto L_0x00ee
            android.content.Context r9 = r8.getContext()     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x010c }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x010c }
            java.io.InputStream r9 = r9.openInputStream(r2)     // Catch:{ Exception -> 0x010c }
            java.lang.String r9 = org.apache.commons.p014io.IOUtils.toString((java.io.InputStream) r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x00a8
        L_0x00ea:
            r11.resolve(r10)     // Catch:{ Exception -> 0x010c }
            goto L_0x011f
        L_0x00ee:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010c }
            r10.<init>()     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "Unsupported scheme for location '"
            r10.append(r0)     // Catch:{ Exception -> 0x010c }
            r10.append(r2)     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "'."
            r10.append(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x010c }
            r9.<init>(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x010c }
            throw r9     // Catch:{ Exception -> 0x010c }
        L_0x010c:
            r9 = move-exception
            java.lang.String r10 = r9.getMessage()
            if (r10 == 0) goto L_0x011a
            java.lang.String r0 = expo.modules.filesystem.FileSystemModuleKt.TAG
            android.util.Log.e(r0, r10)
        L_0x011a:
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r11.reject(r9)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.readAsStringAsync(java.lang.String, java.util.Map, expo.modules.core.Promise):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        throw r7;
     */
    @expo.modules.core.interfaces.ExpoMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeAsStringAsync(java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, ? extends java.lang.Object> r7, expo.modules.core.Promise r8) {
        /*
            r4 = this;
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ Exception -> 0x0066 }
            expo.modules.interfaces.filesystem.Permission r0 = expo.modules.interfaces.filesystem.Permission.WRITE     // Catch:{ Exception -> 0x0066 }
            r4.ensurePermission(r5, r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r7 = r4.getEncodingFromOptions(r7)     // Catch:{ Exception -> 0x0066 }
            java.io.OutputStream r5 = r4.getOutputStream(r5)     // Catch:{ Exception -> 0x0066 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ Exception -> 0x0066 }
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ Exception -> 0x0066 }
            r2 = r5
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "base64"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x003a
            r7 = 0
            byte[] r6 = android.util.Base64.decode(r6, r7)     // Catch:{ all -> 0x005f }
            r2.write(r6)     // Catch:{ all -> 0x005f }
            goto L_0x004f
        L_0x003a:
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005f }
            r7.<init>(r2)     // Catch:{ all -> 0x005f }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x005f }
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x005f }
            r3 = r7
            java.io.OutputStreamWriter r3 = (java.io.OutputStreamWriter) r3     // Catch:{ all -> 0x0058 }
            r3.write(r6)     // Catch:{ all -> 0x0058 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0058 }
            kotlin.p008io.CloseableKt.closeFinally(r7, r2)     // Catch:{ all -> 0x005f }
        L_0x004f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005f }
            kotlin.p008io.CloseableKt.closeFinally(r5, r1)     // Catch:{ Exception -> 0x0066 }
            r8.resolve(r0)     // Catch:{ Exception -> 0x0066 }
            goto L_0x0079
        L_0x0058:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005a }
        L_0x005a:
            r0 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r7, r6)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ all -> 0x005f }
        L_0x005f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r7 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r5, r6)     // Catch:{ Exception -> 0x0066 }
            throw r7     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x0074
            java.lang.String r7 = expo.modules.filesystem.FileSystemModuleKt.TAG
            android.util.Log.e(r7, r6)
        L_0x0074:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r8.reject(r5)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.writeAsStringAsync(java.lang.String, java.lang.String, java.util.Map, expo.modules.core.Promise):void");
    }

    @ExpoMethod
    public final void deleteAsync(String str, Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(map, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
            Intrinsics.checkNotNullExpressionValue(withAppendedPath, "appendedUri");
            Permission permission = Permission.WRITE;
            ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't deletable.");
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                File file = toFile(parse);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        FileUtils.forceDelete(file);
                    } else {
                        forceDelete(file);
                    }
                    promise.resolve((Object) null);
                    return;
                }
                if (map.containsKey("idempotent")) {
                    Object obj = map.get("idempotent");
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    } else if (((Boolean) obj).booleanValue()) {
                        promise.resolve((Object) null);
                        return;
                    }
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_FIND_FILE", "File '" + parse + "' could not be deleted because it could not be found");
            } else if (isSAFUri(parse)) {
                DocumentFile nearestSAFFile = getNearestSAFFile(parse);
                if (nearestSAFFile == null || !nearestSAFFile.exists()) {
                    if (map.containsKey("idempotent")) {
                        Object obj2 = map.get("idempotent");
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        } else if (((Boolean) obj2).booleanValue()) {
                            promise.resolve((Object) null);
                            return;
                        }
                    }
                    promise.reject("ERR_FILESYSTEM_CANNOT_FIND_FILE", "File '" + parse + "' could not be deleted because it could not be found");
                    return;
                }
                nearestSAFFile.delete();
                promise.resolve((Object) null);
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void moveAsync(Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(map, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            if (!map.containsKey("from")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
                return;
            }
            Uri parse = Uri.parse((String) map.get("from"));
            Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
            Intrinsics.checkNotNullExpressionValue(withAppendedPath, "Uri.withAppendedPath(fromUri, \"..\")");
            Permission permission = Permission.WRITE;
            ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't movable.");
            if (!map.containsKey(TypedValues.Transition.S_TO)) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            Uri parse2 = Uri.parse((String) map.get(TypedValues.Transition.S_TO));
            Intrinsics.checkNotNullExpressionValue(parse2, "toUri");
            ensurePermission(parse2, Permission.WRITE);
            Intrinsics.checkNotNullExpressionValue(parse, "fromUri");
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                if (toFile(parse).renameTo(toFile(parse2))) {
                    promise.resolve((Object) null);
                    return;
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_MOVE_FILE", "File '" + parse + "' could not be moved to '" + parse2 + '\'');
            } else if (isSAFUri(parse)) {
                DocumentFile nearestSAFFile = getNearestSAFFile(parse);
                if (nearestSAFFile != null) {
                    if (nearestSAFFile.exists()) {
                        transformFilesFromSAF(nearestSAFFile, new File(parse2.getPath()), false);
                        promise.resolve((Object) null);
                        return;
                    }
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_MOVE_FILE", "File '" + parse + "' could not be moved to '" + parse2 + '\'');
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void copyAsync(Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(map, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            if (!map.containsKey("from")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
                return;
            }
            Uri parse = Uri.parse((String) map.get("from"));
            Intrinsics.checkNotNullExpressionValue(parse, "fromUri");
            ensurePermission(parse, Permission.READ);
            if (!map.containsKey(TypedValues.Transition.S_TO)) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            Uri parse2 = Uri.parse((String) map.get(TypedValues.Transition.S_TO));
            Intrinsics.checkNotNullExpressionValue(parse2, "toUri");
            ensurePermission(parse2, Permission.WRITE);
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                File file = toFile(parse);
                File file2 = toFile(parse2);
                if (file.isDirectory()) {
                    FileUtils.copyDirectory(file, file2);
                } else {
                    FileUtils.copyFile(file, file2);
                }
                promise.resolve((Object) null);
            } else if (isSAFUri(parse)) {
                DocumentFile nearestSAFFile = getNearestSAFFile(parse);
                if (nearestSAFFile != null) {
                    if (nearestSAFFile.exists()) {
                        transformFilesFromSAF(nearestSAFFile, new File(parse2.getPath()), true);
                        promise.resolve((Object) null);
                        return;
                    }
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_FIND_FILE", "File '" + parse + "' could not be copied because it could not be found");
            } else if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_CONTENT_SCHEME)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                IOUtils.copy(context.getContentResolver().openInputStream(parse), (OutputStream) new FileOutputStream(toFile(parse2)));
                promise.resolve((Object) null);
            } else if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_ASSET_SCHEME)) {
                IOUtils.copy(openAssetInputStream(parse), (OutputStream) new FileOutputStream(toFile(parse2)));
                promise.resolve((Object) null);
            } else if (parse.getScheme() == null) {
                IOUtils.copy(openResourceInputStream((String) map.get("from")), (OutputStream) new FileOutputStream(toFile(parse2)));
                promise.resolve((Object) null);
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a1, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void transformFilesFromSAF(androidx.documentfile.provider.DocumentFile r7, java.io.File r8, boolean r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r7.exists()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x001e
            boolean r0 = r8.mkdirs()
            if (r0 == 0) goto L_0x0014
            goto L_0x001e
        L_0x0014:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Couldn't create folder in output dir."
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L_0x001e:
            boolean r0 = r7.isDirectory()
            if (r0 == 0) goto L_0x004a
            androidx.documentfile.provider.DocumentFile[] r0 = r7.listFiles()
            int r1 = r0.length
            r2 = 0
        L_0x002a:
            if (r2 >= r1) goto L_0x0044
            r3 = r0[r2]
            java.lang.String r4 = r7.getName()
            if (r4 == 0) goto L_0x0041
            java.lang.String r5 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.io.File r5 = new java.io.File
            r5.<init>(r8, r4)
            r6.transformFilesFromSAF(r3, r5, r9)
        L_0x0041:
            int r2 = r2 + 1
            goto L_0x002a
        L_0x0044:
            if (r9 != 0) goto L_0x0049
            r7.delete()
        L_0x0049:
            return
        L_0x004a:
            java.lang.String r0 = r7.getName()
            if (r0 == 0) goto L_0x00a2
            java.io.File r1 = new java.io.File
            java.lang.String r8 = r8.getPath()
            r1.<init>(r8, r0)
            android.content.Context r8 = r6.getContext()
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            android.content.ContentResolver r8 = r8.getContentResolver()
            android.net.Uri r0 = r7.getUri()
            java.io.InputStream r8 = r8.openInputStream(r0)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r0 = 0
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r8
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x009b }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
            r4.<init>(r1)     // Catch:{ all -> 0x009b }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x009b }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x009b }
            r1 = r4
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0094 }
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x0094 }
            org.apache.commons.p014io.IOUtils.copy((java.io.InputStream) r3, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0094 }
            kotlin.p008io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x009b }
            kotlin.p008io.CloseableKt.closeFinally(r8, r2)
            if (r9 != 0) goto L_0x00a2
            r7.delete()
            goto L_0x00a2
        L_0x0094:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r9 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r4, r7)     // Catch:{ all -> 0x009b }
            throw r9     // Catch:{ all -> 0x009b }
        L_0x009b:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x009d }
        L_0x009d:
            r9 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r8, r7)
            throw r9
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.transformFilesFromSAF(androidx.documentfile.provider.DocumentFile, java.io.File, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[Catch:{ Exception -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054 A[Catch:{ Exception -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[Catch:{ Exception -> 0x009e }] */
    @expo.modules.core.interfaces.ExpoMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeDirectoryAsync(java.lang.String r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6, expo.modules.core.Promise r7) {
        /*
            r4 = this;
            java.lang.String r0 = "intermediates"
            java.lang.String r1 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.String r1 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch:{ Exception -> 0x009e }
            expo.modules.interfaces.filesystem.Permission r1 = expo.modules.interfaces.filesystem.Permission.WRITE     // Catch:{ Exception -> 0x009e }
            r4.ensurePermission(r5, r1)     // Catch:{ Exception -> 0x009e }
            java.lang.String r1 = r5.getScheme()     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = "file"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x009e }
            if (r1 == 0) goto L_0x0080
            java.io.File r1 = r4.toFile(r5)     // Catch:{ Exception -> 0x009e }
            boolean r2 = r1.isDirectory()     // Catch:{ Exception -> 0x009e }
            boolean r3 = r6.containsKey(r0)     // Catch:{ Exception -> 0x009e }
            if (r3 == 0) goto L_0x004c
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x0044
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x009e }
            boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x0044:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Boolean"
            r5.<init>(r6)     // Catch:{ Exception -> 0x009e }
            throw r5     // Catch:{ Exception -> 0x009e }
        L_0x004c:
            r6 = 0
        L_0x004d:
            if (r6 == 0) goto L_0x0054
            boolean r0 = r1.mkdirs()     // Catch:{ Exception -> 0x009e }
            goto L_0x0058
        L_0x0054:
            boolean r0 = r1.mkdir()     // Catch:{ Exception -> 0x009e }
        L_0x0058:
            if (r0 != 0) goto L_0x007b
            if (r6 == 0) goto L_0x005f
            if (r2 == 0) goto L_0x005f
            goto L_0x007b
        L_0x005f:
            java.lang.String r6 = "ERR_FILESYSTEM_CANNOT_CREATE_DIRECTORY"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r0.<init>()     // Catch:{ Exception -> 0x009e }
            java.lang.String r1 = "Directory '"
            r0.append(r1)     // Catch:{ Exception -> 0x009e }
            r0.append(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.String r5 = "' could not be created or already exists."
            r0.append(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x009e }
            r7.reject((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x009e }
            goto L_0x00b1
        L_0x007b:
            r5 = 0
            r7.resolve(r5)     // Catch:{ Exception -> 0x009e }
            goto L_0x00b1
        L_0x0080:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ Exception -> 0x009e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r0.<init>()     // Catch:{ Exception -> 0x009e }
            java.lang.String r1 = "Unsupported scheme for location '"
            r0.append(r1)     // Catch:{ Exception -> 0x009e }
            r0.append(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.String r5 = "'."
            r0.append(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x009e }
            r6.<init>(r5)     // Catch:{ Exception -> 0x009e }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x009e }
            throw r6     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x00ac
            java.lang.String r0 = expo.modules.filesystem.FileSystemModuleKt.TAG
            android.util.Log.e(r0, r6)
        L_0x00ac:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r7.reject(r5)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.makeDirectoryAsync(java.lang.String, java.util.Map, expo.modules.core.Promise):void");
    }

    @ExpoMethod
    public final void readDirectoryAsync(String str, Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            ensurePermission(parse, Permission.READ);
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                File[] listFiles = toFile(parse).listFiles();
                if (listFiles != null) {
                    Collection arrayList = new ArrayList(listFiles.length);
                    for (File file : listFiles) {
                        Intrinsics.checkNotNullExpressionValue(file, "it");
                        arrayList.add(file.getName());
                    }
                    promise.resolve((List) arrayList);
                    return;
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_READ_DIRECTORY", "Directory '" + parse + "' could not be read.");
            } else if (isSAFUri(parse)) {
                promise.reject("ERR_FILESYSTEM_UNSUPPORTED_SCHEME", "Can't read Storage Access Framework directory, use StorageAccessFramework.readDirectoryAsync() instead.");
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void getTotalDiskCapacityAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            File dataDirectory = Environment.getDataDirectory();
            Intrinsics.checkNotNullExpressionValue(dataDirectory, "Environment.getDataDirectory()");
            StatFs statFs = new StatFs(dataDirectory.getAbsolutePath());
            promise.resolve(Double.valueOf(Math.min(BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - ((double) 1))));
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject("ERR_FILESYSTEM_CANNOT_DETERMINE_DISK_CAPACITY", "Unable to access total disk capacity", e);
        }
    }

    @ExpoMethod
    public final void getFreeDiskStorageAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            File dataDirectory = Environment.getDataDirectory();
            Intrinsics.checkNotNullExpressionValue(dataDirectory, "Environment.getDataDirectory()");
            StatFs statFs = new StatFs(dataDirectory.getAbsolutePath());
            promise.resolve(Double.valueOf(Math.min(BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - ((double) 1))));
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject("ERR_FILESYSTEM_CANNOT_DETERMINE_DISK_CAPACITY", "Unable to determine free disk storage capacity", e);
        }
    }

    @ExpoMethod
    public final void getContentUriAsync(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "fileUri");
            ensurePermission(parse, Permission.WRITE);
            ensurePermission(parse, Permission.READ);
            checkIfFileDirExists(parse);
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                promise.resolve(contentUriFromFile(toFile(parse)).toString());
                return;
            }
            promise.reject("ERR_FILESYSTEM_CANNOT_READ_DIRECTORY", "No readable files with the uri '" + str + "'. Please use other uri.");
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void readSAFDirectoryAsync(String str, Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            ensurePermission(parse, Permission.READ);
            if (isSAFUri(parse)) {
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), parse);
                if (fromTreeUri != null && fromTreeUri.exists()) {
                    if (fromTreeUri.isDirectory()) {
                        DocumentFile[] listFiles = fromTreeUri.listFiles();
                        Intrinsics.checkNotNullExpressionValue(listFiles, "file.listFiles()");
                        Collection arrayList = new ArrayList(listFiles.length);
                        for (DocumentFile documentFile : listFiles) {
                            Intrinsics.checkNotNullExpressionValue(documentFile, "it");
                            arrayList.add(documentFile.getUri().toString());
                        }
                        promise.resolve((List) arrayList);
                        return;
                    }
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_READ_DIRECTORY", "Uri '" + parse + "' doesn't exist or isn't a directory.");
                return;
            }
            throw new IOException("The URI '" + parse + "' is not a Storage Access Framework URI. Try using FileSystem.readDirectoryAsync instead.");
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void makeSAFDirectoryAsync(String str, String str2, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            ensurePermission(parse, Permission.WRITE);
            if (isSAFUri(parse)) {
                DocumentFile nearestSAFFile = getNearestSAFFile(parse);
                if (nearestSAFFile != null) {
                    if (!nearestSAFFile.isDirectory()) {
                        promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_DIRECTORY", "Provided uri '" + parse + "' is not pointing to a directory.");
                        return;
                    }
                }
                DocumentFile documentFile = null;
                if (!(str2 == null || nearestSAFFile == null)) {
                    documentFile = nearestSAFFile.createDirectory(str2);
                }
                if (documentFile == null) {
                    promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_DIRECTORY", "Unknown error.");
                } else {
                    promise.resolve(documentFile.getUri().toString());
                }
            } else {
                throw new IOException("The URI '" + parse + "' is not a Storage Access Framework URI. Try using FileSystem.makeDirectoryAsync instead.");
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void createSAFFileAsync(String str, String str2, String str3, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            ensurePermission(parse, Permission.WRITE);
            if (isSAFUri(parse)) {
                DocumentFile nearestSAFFile = getNearestSAFFile(parse);
                if (nearestSAFFile != null) {
                    if (nearestSAFFile.isDirectory()) {
                        if (str3 != null) {
                            if (str2 != null) {
                                DocumentFile createFile = nearestSAFFile.createFile(str3, str2);
                                if (createFile == null) {
                                    promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_FILE", "Unknown error.");
                                    return;
                                } else {
                                    promise.resolve(createFile.getUri().toString());
                                    return;
                                }
                            }
                        }
                        promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_FILE", "Parameters fileName and mimeType can not be null.");
                        return;
                    }
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_FILE", "Provided uri '" + parse + "' is not pointing to a directory.");
                return;
            }
            throw new IOException("The URI '" + parse + "' is not a Storage Access Framework URI.");
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public final void requestDirectoryPermissionsAsync(String str, Promise promise) {
        Uri parse;
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.dirPermissionsRequest != null) {
            promise.reject("ERR_FILESYSTEM_CANNOT_ASK_FOR_PERMISSIONS", "You have an unfinished permission request.");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (!(Build.VERSION.SDK_INT < 26 || str == null || (parse = Uri.parse(str)) == null)) {
                intent.putExtra("android.provider.extra.INITIAL_URI", parse);
            }
            Activity currentActivity = ((ActivityProvider) LazyKt.lazy(new C1712x53e7ed52(this.moduleRegistryDelegate)).getValue()).getCurrentActivity();
            if (currentActivity == null) {
                promise.reject("ERR_FILESYSTEM_CANNOT_ASK_FOR_PERMISSIONS", "Can't find activity.");
                return;
            }
            getUIManager().registerActivityEventListener(this);
            this.dirPermissionsRequest = promise;
            currentActivity.startActivityForResult(intent, 5394);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject("ERR_FILESYSTEM_CANNOT_ASK_FOR_PERMISSIONS", "Can't ask for permissions.", e);
        }
    }

    private final Request createUploadRequest(String str, String str2, Map<String, ? extends Object> map, Promise promise, RequestBodyDecorator requestBodyDecorator) {
        Map map2;
        try {
            Uri parse = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(parse, "fileUri");
            ensurePermission(parse, Permission.READ);
            checkIfFileExists(parse);
            if (!map.containsKey("httpMethod")) {
                promise.reject("ERR_FILESYSTEM_MISSING_HTTP_METHOD", "Missing HTTP method.", (Throwable) null);
                return null;
            }
            String str3 = (String) map.get("httpMethod");
            if (!map.containsKey("uploadType")) {
                promise.reject("ERR_FILESYSTEM_MISSING_UPLOAD_TYPE", "Missing upload type.", (Throwable) null);
                return null;
            }
            Request.Builder url = new Request.Builder().url(str);
            if (map.containsKey("headers") && (map2 = (Map) map.get("headers")) != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    url.addHeader((String) entry.getKey(), entry.getValue().toString());
                }
            }
            return url.method(str3, createRequestBody(map, requestBodyDecorator, toFile(parse))).build();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
        if (r1 != null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009c, code lost:
        if (r5 != null) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.RequestBody createRequestBody(java.util.Map<java.lang.String, ? extends java.lang.Object> r5, RequestBodyDecorator r6, java.io.File r7) {
        /*
            r4 = this;
            expo.modules.filesystem.UploadType$Companion r0 = expo.modules.filesystem.UploadType.Companion
            java.lang.String r1 = "uploadType"
            java.lang.Object r2 = r5.get(r1)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Double"
            java.util.Objects.requireNonNull(r2, r3)
            java.lang.Double r2 = (java.lang.Double) r2
            double r2 = r2.doubleValue()
            int r2 = (int) r2
            expo.modules.filesystem.UploadType r0 = r0.fromInt(r2)
            expo.modules.filesystem.UploadType r2 = expo.modules.filesystem.UploadType.BINARY_CONTENT
            if (r0 != r2) goto L_0x002c
            r5 = 0
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create((okhttp3.MediaType) r5, (java.io.File) r7)
            java.lang.String r7 = "RequestBody.create(null, file)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            okhttp3.RequestBody r5 = r6.decorate(r5)
            goto L_0x00c1
        L_0x002c:
            expo.modules.filesystem.UploadType r2 = expo.modules.filesystem.UploadType.MULTIPART
            if (r0 != r2) goto L_0x00c2
            okhttp3.MultipartBody$Builder r0 = new okhttp3.MultipartBody$Builder
            r0.<init>()
            okhttp3.MediaType r1 = okhttp3.MultipartBody.FORM
            okhttp3.MultipartBody$Builder r0 = r0.setType(r1)
            java.lang.String r1 = "parameters"
            java.lang.Object r1 = r5.get(r1)
            if (r1 == 0) goto L_0x0070
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>"
            java.util.Objects.requireNonNull(r1, r2)
            java.util.Map r1 = (java.util.Map) r1
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0052:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0070
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = r2.toString()
            r0.addFormDataPart(r3, r2)
            goto L_0x0052
        L_0x0070:
            java.lang.String r1 = "mimeType"
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            if (r1 == 0) goto L_0x0082
            java.util.Objects.requireNonNull(r1, r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0082
            goto L_0x008f
        L_0x0082:
            java.lang.String r1 = r7.getName()
            java.lang.String r1 = java.net.URLConnection.guessContentTypeFromName(r1)
            java.lang.String r3 = "URLConnection.guessContentTypeFromName(file.name)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
        L_0x008f:
            java.lang.String r3 = "fieldName"
            java.lang.Object r5 = r5.get(r3)
            if (r5 == 0) goto L_0x009f
            java.util.Objects.requireNonNull(r5, r2)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x009f
            goto L_0x00a3
        L_0x009f:
            java.lang.String r5 = r7.getName()
        L_0x00a3:
            java.lang.String r2 = r7.getName()
            okhttp3.MediaType r1 = okhttp3.MediaType.parse(r1)
            okhttp3.RequestBody r7 = okhttp3.RequestBody.create((okhttp3.MediaType) r1, (java.io.File) r7)
            java.lang.String r1 = "RequestBody.create(Media…pe.parse(mimeType), file)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            okhttp3.RequestBody r6 = r6.decorate(r7)
            r0.addFormDataPart(r5, r2, r6)
            okhttp3.MultipartBody r5 = r0.build()
            okhttp3.RequestBody r5 = (okhttp3.RequestBody) r5
        L_0x00c1:
            return r5
        L_0x00c2:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "ERR_FILESYSTEM_INVALID_UPLOAD_TYPE. "
            r7.append(r0)
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r0 = 1
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r3 = 0
            java.lang.Object r5 = r5.get(r1)
            r2[r3] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r2, r0)
            java.lang.String r0 = "Invalid upload type: %s."
            java.lang.String r5 = java.lang.String.format(r0, r5)
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.createRequestBody(java.util.Map, expo.modules.filesystem.RequestBodyDecorator, java.io.File):okhttp3.RequestBody");
    }

    @ExpoMethod
    public final void uploadAsync(String str, String str2, Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        Intrinsics.checkNotNullParameter(str2, "fileUriString");
        Intrinsics.checkNotNullParameter(map, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Request createUploadRequest = createUploadRequest(str, str2, map, promise, FileSystemModule$uploadAsync$request$1.INSTANCE);
        if (createUploadRequest != null) {
            OkHttpClient okHttpClient = getOkHttpClient();
            if (okHttpClient != null) {
                okHttpClient.newCall(createUploadRequest).enqueue(new FileSystemModule$uploadAsync$$inlined$let$lambda$1(this, createUploadRequest, promise));
                return;
            }
            FileSystemModule fileSystemModule = this;
            promise.reject(new NullPointerException("okHttpClient is null"));
        }
    }

    @ExpoMethod
    public final void uploadTaskStartAsync(String str, String str2, String str3, Map<String, ? extends Object> map, Promise promise) {
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        Intrinsics.checkNotNullParameter(str2, "fileUriString");
        Intrinsics.checkNotNullParameter(str3, "uuid");
        Intrinsics.checkNotNullParameter(map, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Request createUploadRequest = createUploadRequest(str, str2, map, promise, new FileSystemModule$uploadTaskStartAsync$request$1(new FileSystemModule$uploadTaskStartAsync$progressListener$1(this, str3)));
        if (createUploadRequest != null) {
            OkHttpClient okHttpClient = getOkHttpClient();
            Intrinsics.checkNotNull(okHttpClient);
            Call newCall = okHttpClient.newCall(createUploadRequest);
            Map<String, TaskHandler> map2 = this.taskHandlers;
            Intrinsics.checkNotNullExpressionValue(newCall, NotificationCompat.CATEGORY_CALL);
            map2.put(str3, new TaskHandler(newCall));
            newCall.enqueue(new FileSystemModule$uploadTaskStartAsync$1(this, promise));
        }
    }

    @ExpoMethod
    public final void downloadAsync(String str, String str2, Map<String, ? extends Object> map, Promise promise) {
        Call newCall;
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Uri parse = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            ensurePermission(parse, Permission.WRITE);
            checkIfFileDirExists(parse);
            Object obj = null;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(context.getResources().getIdentifier(str, "raw", context.getPackageName()))));
                File file = toFile(parse);
                file.delete();
                BufferedSink buffer2 = Okio.buffer(Okio.sink(file));
                buffer2.writeAll(buffer);
                buffer2.close();
                Bundle bundle = new Bundle();
                bundle.putString("uri", Uri.fromFile(file).toString());
                Object obj2 = map != null ? map.get("md5") : null;
                if (Intrinsics.areEqual((Object) obj2, (Object) true)) {
                    obj = obj2;
                }
                if (obj != null) {
                    bundle.putString("md5", md5(file));
                }
                promise.resolve(bundle);
            } else if (Intrinsics.areEqual((Object) UriUtil.LOCAL_FILE_SCHEME, (Object) parse.getScheme())) {
                Request.Builder url = new Request.Builder().url(str);
                if (map != null && map.containsKey("headers")) {
                    try {
                        Map map2 = (Map) map.get("headers");
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                url.addHeader((String) entry.getKey(), entry.getValue().toString());
                            }
                        }
                    } catch (ClassCastException e) {
                        promise.reject("ERR_FILESYSTEM_INVALID_HEADERS", "Invalid headers dictionary. Keys and values should be strings.", e);
                        return;
                    }
                }
                OkHttpClient okHttpClient = getOkHttpClient();
                if (okHttpClient == null || (newCall = okHttpClient.newCall(url.build())) == null) {
                    FileSystemModule fileSystemModule = this;
                    promise.reject(new NullPointerException("okHttpClient is null"));
                    return;
                }
                newCall.enqueue(new FileSystemModule$downloadAsync$4(this, promise, parse, map));
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(e2);
        }
    }

    @ExpoMethod
    public final void networkTaskCancelAsync(String str, Promise promise) {
        Call call;
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        TaskHandler taskHandler = this.taskHandlers.get(str);
        if (!(taskHandler == null || (call = taskHandler.getCall()) == null)) {
            call.cancel();
        }
        promise.resolve((Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        r1 = (r3 = r3.newBuilder()).addNetworkInterceptor(new expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$client$1(r1));
     */
    @expo.modules.core.interfaces.ExpoMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void downloadResumableStartAsync(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, ? extends java.lang.Object> r13, java.lang.String r14, expo.modules.core.Promise r15) {
        /*
            r9 = this;
            java.lang.String r0 = "headers"
            java.lang.String r1 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "fileUriStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            java.lang.String r1 = "uuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "fileUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)     // Catch:{ Exception -> 0x0116 }
            r9.checkIfFileDirExists(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r11.getScheme()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = "file"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0116 }
            r2 = 1
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x00f8
            expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$progressListener$1 r1 = new expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$progressListener$1     // Catch:{ Exception -> 0x0116 }
            r1.<init>(r9, r14, r12)     // Catch:{ Exception -> 0x0116 }
            expo.modules.filesystem.FileSystemModule$ProgressListener r1 = (expo.modules.filesystem.FileSystemModule.ProgressListener) r1     // Catch:{ Exception -> 0x0116 }
            okhttp3.OkHttpClient r3 = r9.getOkHttpClient()     // Catch:{ Exception -> 0x0116 }
            if (r3 == 0) goto L_0x005a
            okhttp3.OkHttpClient$Builder r3 = r3.newBuilder()     // Catch:{ Exception -> 0x0116 }
            if (r3 == 0) goto L_0x005a
            expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$client$1 r4 = new expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$client$1     // Catch:{ Exception -> 0x0116 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0116 }
            okhttp3.Interceptor r4 = (okhttp3.Interceptor) r4     // Catch:{ Exception -> 0x0116 }
            okhttp3.OkHttpClient$Builder r1 = r3.addNetworkInterceptor(r4)     // Catch:{ Exception -> 0x0116 }
            if (r1 == 0) goto L_0x005a
            okhttp3.OkHttpClient r1 = r1.build()     // Catch:{ Exception -> 0x0116 }
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            if (r1 != 0) goto L_0x006a
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0116 }
            java.lang.String r11 = "okHttpClient is null"
            r10.<init>(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ Exception -> 0x0116 }
            r15.reject(r10)     // Catch:{ Exception -> 0x0116 }
            return
        L_0x006a:
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0116 }
            r3.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r4 = "Range"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r5.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r6 = "bytes="
            r5.append(r6)     // Catch:{ Exception -> 0x0116 }
            r5.append(r14)     // Catch:{ Exception -> 0x0116 }
            r6 = 45
            r5.append(r6)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0116 }
            r3.addHeader(r4, r5)     // Catch:{ Exception -> 0x0116 }
            boolean r4 = r13.containsKey(r0)     // Catch:{ Exception -> 0x0116 }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r0 = r13.get(r0)     // Catch:{ Exception -> 0x0116 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00be
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0116 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0116 }
        L_0x00a0:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x0116 }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x0116 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x0116 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0116 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0116 }
            r3.addHeader(r5, r4)     // Catch:{ Exception -> 0x0116 }
            goto L_0x00a0
        L_0x00be:
            expo.modules.filesystem.FileSystemModule$DownloadResumableTask r0 = new expo.modules.filesystem.FileSystemModule$DownloadResumableTask     // Catch:{ Exception -> 0x0116 }
            r0.<init>()     // Catch:{ Exception -> 0x0116 }
            okhttp3.Request$Builder r10 = r3.url((java.lang.String) r10)     // Catch:{ Exception -> 0x0116 }
            okhttp3.Request r10 = r10.build()     // Catch:{ Exception -> 0x0116 }
            okhttp3.Call r5 = r1.newCall(r10)     // Catch:{ Exception -> 0x0116 }
            java.util.Map<java.lang.String, expo.modules.filesystem.FileSystemModule$TaskHandler> r10 = r9.taskHandlers     // Catch:{ Exception -> 0x0116 }
            expo.modules.filesystem.FileSystemModule$DownloadTaskHandler r1 = new expo.modules.filesystem.FileSystemModule$DownloadTaskHandler     // Catch:{ Exception -> 0x0116 }
            java.lang.String r3 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)     // Catch:{ Exception -> 0x0116 }
            r1.<init>(r11, r5)     // Catch:{ Exception -> 0x0116 }
            r10.put(r12, r1)     // Catch:{ Exception -> 0x0116 }
            expo.modules.filesystem.FileSystemModule$DownloadResumableTaskParams r10 = new expo.modules.filesystem.FileSystemModule$DownloadResumableTaskParams     // Catch:{ Exception -> 0x0116 }
            java.io.File r6 = r9.toFile(r11)     // Catch:{ Exception -> 0x0116 }
            r11 = 0
            if (r14 == 0) goto L_0x00e9
            r7 = 1
            goto L_0x00ea
        L_0x00e9:
            r7 = 0
        L_0x00ea:
            r3 = r10
            r4 = r13
            r8 = r15
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0116 }
            expo.modules.filesystem.FileSystemModule$DownloadResumableTaskParams[] r12 = new expo.modules.filesystem.FileSystemModule.DownloadResumableTaskParams[r2]     // Catch:{ Exception -> 0x0116 }
            r12[r11] = r10     // Catch:{ Exception -> 0x0116 }
            r0.execute(r12)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0129
        L_0x00f8:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r12.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r13 = "Unsupported scheme for location '"
            r12.append(r13)     // Catch:{ Exception -> 0x0116 }
            r12.append(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r11 = "'."
            r12.append(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0116 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0116 }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ Exception -> 0x0116 }
            throw r10     // Catch:{ Exception -> 0x0116 }
        L_0x0116:
            r10 = move-exception
            java.lang.String r11 = r10.getMessage()
            if (r11 == 0) goto L_0x0124
            java.lang.String r12 = expo.modules.filesystem.FileSystemModuleKt.TAG
            android.util.Log.e(r12, r11)
        L_0x0124:
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            r15.reject(r10)
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.downloadResumableStartAsync(java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, expo.modules.core.Promise):void");
    }

    @ExpoMethod
    public final void downloadResumablePauseAsync(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        TaskHandler taskHandler = this.taskHandlers.get(str);
        if (taskHandler == null) {
            Exception iOException = new IOException("No download object available");
            String message = iOException.getMessage();
            if (message != null) {
                Log.e(FileSystemModuleKt.TAG, message);
            }
            promise.reject(iOException);
        } else if (!(taskHandler instanceof DownloadTaskHandler)) {
            promise.reject("ERR_FILESYSTEM_CANNOT_FIND_TASK", "Cannot find task.");
        } else {
            taskHandler.getCall().cancel();
            this.taskHandlers.remove(str);
            try {
                File file = toFile(((DownloadTaskHandler) taskHandler).getFileUri());
                Bundle bundle = new Bundle();
                bundle.putString("resumeData", String.valueOf(file.length()));
                promise.resolve(bundle);
            } catch (Exception e) {
                String message2 = e.getMessage();
                if (message2 != null) {
                    Log.e(FileSystemModuleKt.TAG, message2);
                }
                promise.reject(e);
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (i == 5394 && this.dirPermissionsRequest != null) {
            Bundle bundle = new Bundle();
            if (i2 != -1 || intent == null) {
                bundle.putBoolean(PermissionsResponse.GRANTED_KEY, false);
            } else {
                Uri data = intent.getData();
                int flags = intent.getFlags() & 3;
                if (data != null) {
                    activity.getContentResolver().takePersistableUriPermission(data, flags);
                }
                bundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
                bundle.putString("directoryUri", String.valueOf(data));
            }
            Promise promise = this.dirPermissionsRequest;
            if (promise != null) {
                promise.resolve(bundle);
            }
            getUIManager().unregisterActivityEventListener(this);
            this.dirPermissionsRequest = null;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;", "", "options", "", "", "call", "Lokhttp3/Call;", "file", "Ljava/io/File;", "isResume", "", "promise", "Lexpo/modules/core/Promise;", "(Ljava/util/Map;Lokhttp3/Call;Ljava/io/File;ZLexpo/modules/core/Promise;)V", "getCall", "()Lokhttp3/Call;", "setCall", "(Lokhttp3/Call;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "()Z", "setResume", "(Z)V", "getOptions", "()Ljava/util/Map;", "setOptions", "(Ljava/util/Map;)V", "getPromise", "()Lexpo/modules/core/Promise;", "setPromise", "(Lexpo/modules/core/Promise;)V", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    private static final class DownloadResumableTaskParams {
        private Call call;
        private File file;
        private boolean isResume;
        private Map<String, ? extends Object> options;
        private Promise promise;

        public DownloadResumableTaskParams(Map<String, ? extends Object> map, Call call2, File file2, boolean z, Promise promise2) {
            Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(file2, UriUtil.LOCAL_FILE_SCHEME);
            Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
            this.options = map;
            this.call = call2;
            this.file = file2;
            this.isResume = z;
            this.promise = promise2;
        }

        public final Call getCall() {
            return this.call;
        }

        public final File getFile() {
            return this.file;
        }

        public final Map<String, Object> getOptions() {
            return this.options;
        }

        public final Promise getPromise() {
            return this.promise;
        }

        public final boolean isResume() {
            return this.isResume;
        }

        public final void setCall(Call call2) {
            Intrinsics.checkNotNullParameter(call2, "<set-?>");
            this.call = call2;
        }

        public final void setFile(File file2) {
            Intrinsics.checkNotNullParameter(file2, "<set-?>");
            this.file = file2;
        }

        public final void setOptions(Map<String, ? extends Object> map) {
            this.options = map;
        }

        public final void setPromise(Promise promise2) {
            Intrinsics.checkNotNullParameter(promise2, "<set-?>");
            this.promise = promise2;
        }

        public final void setResume(boolean z) {
            this.isResume = z;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTask;", "Landroid/os/AsyncTask;", "Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;", "Ljava/lang/Void;", "(Lexpo/modules/filesystem/FileSystemModule;)V", "doInBackground", "params", "", "([Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;)Ljava/lang/Void;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    private final class DownloadResumableTask extends AsyncTask<DownloadResumableTaskParams, Void, Void> {
        public DownloadResumableTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(DownloadResumableTaskParams... downloadResumableTaskParamsArr) {
            Intrinsics.checkNotNullParameter(downloadResumableTaskParamsArr, "params");
            DownloadResumableTaskParams downloadResumableTaskParams = downloadResumableTaskParamsArr[0];
            Call call = downloadResumableTaskParams != null ? downloadResumableTaskParams.getCall() : null;
            DownloadResumableTaskParams downloadResumableTaskParams2 = downloadResumableTaskParamsArr[0];
            Promise promise = downloadResumableTaskParams2 != null ? downloadResumableTaskParams2.getPromise() : null;
            DownloadResumableTaskParams downloadResumableTaskParams3 = downloadResumableTaskParamsArr[0];
            File file = downloadResumableTaskParams3 != null ? downloadResumableTaskParams3.getFile() : null;
            DownloadResumableTaskParams downloadResumableTaskParams4 = downloadResumableTaskParamsArr[0];
            Boolean valueOf = downloadResumableTaskParams4 != null ? Boolean.valueOf(downloadResumableTaskParams4.isResume()) : null;
            DownloadResumableTaskParams downloadResumableTaskParams5 = downloadResumableTaskParamsArr[0];
            Map<String, Object> options = downloadResumableTaskParams5 != null ? downloadResumableTaskParams5.getOptions() : null;
            try {
                Intrinsics.checkNotNull(call);
                Response execute = call.execute();
                ResponseBody body = execute.body();
                Intrinsics.checkNotNull(body);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(body.byteStream());
                FileOutputStream fileOutputStream = new FileOutputStream(file, Intrinsics.areEqual((Object) valueOf, (Object) true));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Bundle bundle = new Bundle();
                bundle.putString("uri", Uri.fromFile(file).toString());
                bundle.putInt("status", execute.code());
                FileSystemModule fileSystemModule = FileSystemModule.this;
                Headers headers = execute.headers();
                Intrinsics.checkNotNullExpressionValue(headers, "response.headers()");
                bundle.putBundle("headers", fileSystemModule.translateHeaders(headers));
                Object obj = options != null ? options.get("md5") : null;
                if (!Intrinsics.areEqual(obj, (Object) true)) {
                    obj = null;
                }
                if (obj != null) {
                    bundle.putString("md5", file != null ? FileSystemModule.this.md5(file) : null);
                }
                execute.close();
                if (promise != null) {
                    promise.resolve(bundle);
                }
            } catch (Exception e) {
                if (call == null || !call.isCanceled()) {
                    String message = e.getMessage();
                    if (message != null) {
                        Log.e(FileSystemModuleKt.TAG, message);
                    }
                    if (promise != null) {
                        promise.reject(e);
                    }
                } else {
                    if (promise != null) {
                        promise.resolve((Object) null);
                    }
                    return null;
                }
            }
            return null;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "", "call", "Lokhttp3/Call;", "(Lokhttp3/Call;)V", "getCall", "()Lokhttp3/Call;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    private static class TaskHandler {
        private final Call call;

        public TaskHandler(Call call2) {
            Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
            this.call = call2;
        }

        public final Call getCall() {
            return this.call;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$DownloadTaskHandler;", "Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "fileUri", "Landroid/net/Uri;", "call", "Lokhttp3/Call;", "(Landroid/net/Uri;Lokhttp3/Call;)V", "getFileUri", "()Landroid/net/Uri;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    private static final class DownloadTaskHandler extends TaskHandler {
        private final Uri fileUri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DownloadTaskHandler(Uri uri, Call call) {
            super(call);
            Intrinsics.checkNotNullParameter(uri, "fileUri");
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            this.fileUri = uri;
        }

        public final Uri getFileUri() {
            return this.fileUri;
        }
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo24974d2 = {"Lexpo/modules/filesystem/FileSystemModule$ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lexpo/modules/filesystem/FileSystemModule$ProgressListener;", "(Lokhttp3/ResponseBody;Lexpo/modules/filesystem/FileSystemModule$ProgressListener;)V", "bufferedSource", "Lokio/BufferedSource;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/Source;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: FileSystemModule.kt */
    private static final class ProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        /* access modifiers changed from: private */
        public final ProgressListener progressListener;
        /* access modifiers changed from: private */
        public final ResponseBody responseBody;

        public ProgressResponseBody(ResponseBody responseBody2, ProgressListener progressListener2) {
            Intrinsics.checkNotNullParameter(progressListener2, "progressListener");
            this.responseBody = responseBody2;
            this.progressListener = progressListener2;
        }

        public MediaType contentType() {
            ResponseBody responseBody2 = this.responseBody;
            if (responseBody2 != null) {
                return responseBody2.contentType();
            }
            return null;
        }

        public long contentLength() {
            ResponseBody responseBody2 = this.responseBody;
            if (responseBody2 != null) {
                return responseBody2.contentLength();
            }
            return -1;
        }

        public BufferedSource source() {
            BufferedSource bufferedSource2 = this.bufferedSource;
            if (bufferedSource2 != null) {
                return bufferedSource2;
            }
            ResponseBody responseBody2 = this.responseBody;
            Intrinsics.checkNotNull(responseBody2);
            BufferedSource source = responseBody2.source();
            Intrinsics.checkNotNullExpressionValue(source, "responseBody!!.source()");
            BufferedSource buffer = Okio.buffer(source(source));
            Intrinsics.checkNotNullExpressionValue(buffer, "Okio.buffer(source(responseBody!!.source()))");
            return buffer;
        }

        private final Source source(Source source) {
            return new FileSystemModule$ProgressResponseBody$source$1(this, source, source);
        }
    }

    private final synchronized OkHttpClient getOkHttpClient() {
        if (this.client == null) {
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS);
            writeTimeout.cookieJar(new JavaNetCookieJar((CookieHandler) LazyKt.lazy(new FileSystemModule$okHttpClient$$inlined$moduleRegistry$1(this.moduleRegistryDelegate)).getValue()));
            this.client = writeTimeout.build();
        }
        return this.client;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String md5(java.io.File r4) throws java.io.IOException {
        /*
            r3 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            java.io.InputStream r0 = (java.io.InputStream) r0
            java.io.Closeable r0 = (java.io.Closeable) r0
            r4 = 0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r1 = r0
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0025 }
            byte[] r1 = org.apache.commons.codec.digest.DigestUtils.md5((java.io.InputStream) r1)     // Catch:{ all -> 0x0025 }
            char[] r1 = org.apache.commons.codec.binary.Hex.encodeHex(r1)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = "Hex.encodeHex(md5bytes)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0025 }
            r2.<init>(r1)     // Catch:{ all -> 0x0025 }
            kotlin.p008io.CloseableKt.closeFinally(r0, r4)
            return r2
        L_0x0025:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.md5(java.io.File):java.lang.String");
    }

    private final void ensureDirExists(File file) throws IOException {
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IOException("Couldn't create directory '" + file + '\'');
        }
    }

    private final void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                IOException e = null;
                for (File file2 : listFiles) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(file2, "f");
                        forceDelete(file2);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (e != null) {
                    throw e;
                } else if (!file.delete()) {
                    throw new IOException("Unable to delete directory " + file + FilenameUtils.EXTENSION_SEPARATOR);
                }
            } else {
                throw new IOException("Failed to list contents of " + file);
            }
        } else if (!file.delete()) {
            throw new IOException("Unable to delete file: " + file);
        }
    }

    private final long getFileSize(File file) {
        Object obj;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        Collection arrayList = new ArrayList(listFiles.length);
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "it");
            arrayList.add(Long.valueOf(getFileSize(file2)));
        }
        Iterator it = ((List) arrayList).iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            while (it.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() + ((Number) it.next()).longValue());
            }
            obj = next;
        }
        Long l = (Long) obj;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    private final String getEncodingFromOptions(Map<String, ? extends Object> map) {
        if (!map.containsKey("encoding") || !(map.get("encoding") instanceof String)) {
            return "utf8";
        }
        Object obj = map.get("encoding");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final InputStream getInputStream(Uri uri) throws IOException {
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            return new FileInputStream(toFile(uri));
        }
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_ASSET_SCHEME)) {
            return openAssetInputStream(uri);
        }
        if (isSAFUri(uri)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            Intrinsics.checkNotNull(openInputStream);
            Intrinsics.checkNotNullExpressionValue(openInputStream, "context.contentResolver.openInputStream(uri)!!");
            return openInputStream;
        }
        throw new IOException("Unsupported scheme for location '" + uri + "'.");
    }

    private final OutputStream getOutputStream(Uri uri) throws IOException {
        OutputStream outputStream;
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            outputStream = new FileOutputStream(toFile(uri));
        } else if (isSAFUri(uri)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            outputStream = context.getContentResolver().openOutputStream(uri);
            Intrinsics.checkNotNull(outputStream);
        } else {
            throw new IOException("Unsupported scheme for location '" + uri + "'.");
        }
        Intrinsics.checkNotNullExpressionValue(outputStream, "when {\n    uri.scheme ==…or location '$uri'.\")\n  }");
        return outputStream;
    }

    private final DocumentFile getNearestSAFFile(Uri uri) {
        DocumentFile fromSingleUri = DocumentFile.fromSingleUri(getContext(), uri);
        return (fromSingleUri == null || !fromSingleUri.isFile()) ? DocumentFile.fromTreeUri(getContext(), uri) : fromSingleUri;
    }

    /* access modifiers changed from: private */
    public final File toFile(Uri uri) {
        return new File(uri.getPath());
    }

    private final boolean isSAFUri(Uri uri) {
        if (!Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_CONTENT_SCHEME)) {
            return false;
        }
        String host = uri.getHost();
        return host != null ? StringsKt.startsWith$default(host, "com.android.externalstorage", false, 2, (Object) null) : false;
    }

    private final String parseFileUri(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null) + 3);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final byte[] getInputStreamBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "byteBuffer.toByteArray()");
        return byteArray;
    }

    /* access modifiers changed from: private */
    public final Bundle translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (bundle.get(name) != null) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return bundle;
    }

    private final EnumSet<Permission> permissionsForPath(String str) {
        return ((FilePermissionModuleInterface) LazyKt.lazy(new FileSystemModule$permissionsForPath$$inlined$moduleRegistry$1(this.moduleRegistryDelegate)).getValue()).getPathPermissions(getContext(), str);
    }

    private final Uri contentUriFromFile(File file) {
        Activity currentActivity = ((ActivityProvider) LazyKt.lazy(new FileSystemModule$contentUriFromFile$$inlined$moduleRegistry$1(this.moduleRegistryDelegate)).getValue()).getCurrentActivity();
        Intrinsics.checkNotNullExpressionValue(currentActivity, "activityProvider.currentActivity");
        Application application = currentActivity.getApplication();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        sb.append(application.getPackageName());
        sb.append(".FileSystemFileProvider");
        Uri uriForFile = FileProvider.getUriForFile(application, sb.toString(), file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…ystemFileProvider\", file)");
        return uriForFile;
    }
}
