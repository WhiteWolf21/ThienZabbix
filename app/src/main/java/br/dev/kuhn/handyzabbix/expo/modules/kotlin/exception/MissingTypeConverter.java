package br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo24974d2 = {"Lexpo/modules/kotlin/exception/MissingTypeConverter;", "Lexpo/modules/kotlin/exception/CodedException;", "forType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)V", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: CodedException.kt */
public final class MissingTypeConverter extends CodedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissingTypeConverter(KType kType) {
        super("Cannot find type converter for " + kType + FilenameUtils.EXTENSION_SEPARATOR);
        Intrinsics.checkNotNullParameter(kType, "forType");
    }
}
