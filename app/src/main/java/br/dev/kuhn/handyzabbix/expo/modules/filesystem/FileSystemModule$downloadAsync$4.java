package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.core.Promise;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo24974d2 = {"expo/modules/filesystem/FileSystemModule$downloadAsync$4", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$downloadAsync$4 implements Callback {
    final /* synthetic */ Map $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ FileSystemModule this$0;

    FileSystemModule$downloadAsync$4(FileSystemModule fileSystemModule, Promise promise, Uri uri, Map map) {
        this.this$0 = fileSystemModule;
        this.$promise = promise;
        this.$uri = uri;
        this.$options = map;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        Log.e(FileSystemModuleKt.TAG, String.valueOf(iOException.getMessage()));
        this.$promise.reject(iOException);
    }

    public void onResponse(Call call, Response response) throws IOException {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        FileSystemModule fileSystemModule = this.this$0;
        Uri uri = this.$uri;
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        File access$toFile = fileSystemModule.toFile(uri);
        access$toFile.delete();
        BufferedSink buffer = Okio.buffer(Okio.sink(access$toFile));
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        buffer.writeAll(body.source());
        buffer.close();
        Bundle bundle = new Bundle();
        bundle.putString("uri", Uri.fromFile(access$toFile).toString());
        bundle.putInt("status", response.code());
        FileSystemModule fileSystemModule2 = this.this$0;
        Headers headers = response.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "response.headers()");
        bundle.putBundle("headers", fileSystemModule2.translateHeaders(headers));
        Map map = this.$options;
        if (Intrinsics.areEqual(map != null ? map.get("md5") : null, (Object) true)) {
            bundle.putString("md5", this.this$0.md5(access$toFile));
        }
        response.close();
        this.$promise.resolve(bundle);
    }
}
