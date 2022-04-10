package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import expo.modules.filesystem.FileSystemModule;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, mo24974d2 = {"<anonymous>", "Lokhttp3/Response;", "kotlin.jvm.PlatformType", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
final class FileSystemModule$downloadResumableStartAsync$client$1 implements Interceptor {
    final /* synthetic */ FileSystemModule.ProgressListener $progressListener;

    FileSystemModule$downloadResumableStartAsync$client$1(FileSystemModule.ProgressListener progressListener) {
        this.$progressListener = progressListener;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new FileSystemModule.ProgressResponseBody(proceed.body(), this.$progressListener)).build();
    }
}
