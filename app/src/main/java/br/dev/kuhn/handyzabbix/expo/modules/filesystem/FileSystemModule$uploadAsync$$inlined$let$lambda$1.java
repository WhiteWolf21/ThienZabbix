package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.core.Promise;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, mo24974d2 = {"expo/modules/filesystem/FileSystemModule$uploadAsync$1$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$uploadAsync$$inlined$let$lambda$1 implements Callback {
    final /* synthetic */ Promise $promise$inlined;
    final /* synthetic */ Request $request$inlined;
    final /* synthetic */ FileSystemModule this$0;

    FileSystemModule$uploadAsync$$inlined$let$lambda$1(FileSystemModule fileSystemModule, Request request, Promise promise) {
        this.this$0 = fileSystemModule;
        this.$request$inlined = request;
        this.$promise$inlined = promise;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        Log.e(FileSystemModuleKt.TAG, String.valueOf(iOException.getMessage()));
        this.$promise$inlined.reject(iOException);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        ResponseBody body = response.body();
        bundle.putString("body", body != null ? body.string() : null);
        bundle.putInt("status", response.code());
        FileSystemModule fileSystemModule = this.this$0;
        Headers headers = response.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "response.headers()");
        bundle.putBundle("headers", fileSystemModule.translateHeaders(headers));
        response.close();
        this.$promise$inlined.resolve(bundle);
    }
}
