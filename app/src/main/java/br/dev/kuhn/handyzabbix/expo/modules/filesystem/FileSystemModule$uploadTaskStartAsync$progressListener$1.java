package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import android.os.Bundle;
import expo.modules.core.interfaces.services.EventEmitter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo24974d2 = {"expo/modules/filesystem/FileSystemModule$uploadTaskStartAsync$progressListener$1", "Lexpo/modules/filesystem/CountingRequestListener;", "mLastUpdate", "", "onProgress", "", "bytesWritten", "contentLength", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$uploadTaskStartAsync$progressListener$1 implements CountingRequestListener {
    final /* synthetic */ String $uuid;
    private long mLastUpdate = -1;
    final /* synthetic */ FileSystemModule this$0;

    FileSystemModule$uploadTaskStartAsync$progressListener$1(FileSystemModule fileSystemModule, String str) {
        this.this$0 = fileSystemModule;
        this.$uuid = str;
    }

    public void onProgress(long j, long j2) {
        Lazy lazy = LazyKt.lazy(new C1714xf6841b9a(this.this$0.moduleRegistryDelegate));
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.mLastUpdate + 100 || j == j2) {
            this.mLastUpdate = currentTimeMillis;
            bundle2.putDouble("totalByteSent", (double) j);
            bundle2.putDouble("totalBytesExpectedToSend", (double) j2);
            bundle.putString("uuid", this.$uuid);
            bundle.putBundle("data", bundle2);
            ((EventEmitter) lazy.getValue()).emit("expo-file-system.uploadProgress", bundle);
        }
    }
}
