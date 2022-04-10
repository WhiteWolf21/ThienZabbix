package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import expo.modules.filesystem.FileSystemModule;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo24974d2 = {"expo/modules/filesystem/FileSystemModule$ProgressResponseBody$source$1", "Lokio/ForwardingSource;", "totalBytesRead", "", "getTotalBytesRead", "()J", "setTotalBytesRead", "(J)V", "read", "sink", "Lokio/Buffer;", "byteCount", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$ProgressResponseBody$source$1 extends ForwardingSource {
    final /* synthetic */ Source $source;
    final /* synthetic */ FileSystemModule.ProgressResponseBody this$0;
    private long totalBytesRead;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileSystemModule$ProgressResponseBody$source$1(FileSystemModule.ProgressResponseBody progressResponseBody, Source source, Source source2) {
        super(source2);
        this.this$0 = progressResponseBody;
        this.$source = source;
    }

    public final long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public final void setTotalBytesRead(long j) {
        this.totalBytesRead = j;
    }

    public long read(Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long read = super.read(buffer, j);
        long j2 = -1;
        int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
        this.totalBytesRead += i != 0 ? read : 0;
        FileSystemModule.ProgressListener access$getProgressListener$p = this.this$0.progressListener;
        long j3 = this.totalBytesRead;
        ResponseBody access$getResponseBody$p = this.this$0.responseBody;
        if (access$getResponseBody$p != null) {
            j2 = access$getResponseBody$p.contentLength();
        }
        access$getProgressListener$p.update(j3, j2, i == 0);
        return read;
    }
}
