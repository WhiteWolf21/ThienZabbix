package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import kotlin.Metadata;
import okhttp3.RequestBody;

@FunctionalInterface
@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo24974d2 = {"Lexpo/modules/filesystem/RequestBodyDecorator;", "", "decorate", "Lokhttp3/RequestBody;", "requestBody", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: CountingRequestBody.kt */
public interface RequestBodyDecorator {
    RequestBody decorate(RequestBody requestBody);
}
