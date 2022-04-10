package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo24974d2 = {"<anonymous>", "Lokhttp3/RequestBody;", "requestBody", "decorate"}, mo24975k = 3, mo24976mv = {1, 4, 1})
/* compiled from: FileSystemModule.kt */
final class FileSystemModule$uploadAsync$request$1 implements RequestBodyDecorator {
    public static final FileSystemModule$uploadAsync$request$1 INSTANCE = new FileSystemModule$uploadAsync$request$1();

    FileSystemModule$uploadAsync$request$1() {
    }

    public final RequestBody decorate(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        return requestBody;
    }
}
