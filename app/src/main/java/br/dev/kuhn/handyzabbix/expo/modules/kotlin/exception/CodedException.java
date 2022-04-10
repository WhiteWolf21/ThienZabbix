package br.dev.kuhn.handyzabbix.expo.modules.kotlin.exception;

import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0016\u0018\u0000 \u00102\u00060\u0001j\u0002`\u0002:\u0001\u0010B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nB\u0007\b\u0016¢\u0006\u0002\u0010\u000bB\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo24974d2 = {"Lexpo/modules/kotlin/exception/CodedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "cause", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;)V", "(Ljava/lang/Throwable;)V", "()V", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "providedCode", "Companion", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: CodedException.kt */
public class CodedException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String providedCode;

    public CodedException(String str, Throwable th) {
        super(str, th);
    }

    public final String getCode() {
        String str = this.providedCode;
        return str != null ? str : Companion.inferCode(getClass());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CodedException(String str, String str2, Throwable th) {
        this(str2, th);
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.providedCode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CodedException(String str) {
        this(str, (Throwable) null);
        Intrinsics.checkNotNullParameter(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CodedException(Throwable th) {
        this(th.getLocalizedMessage(), th);
        Intrinsics.checkNotNullParameter(th, "cause");
    }

    public CodedException() {
        this((String) null, (Throwable) null);
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¨\u0006\u0007"}, mo24974d2 = {"Lexpo/modules/kotlin/exception/CodedException$Companion;", "", "()V", "inferCode", "", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: CodedException.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String inferCode(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (simpleName != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("ERR_");
                Regex regex = new Regex("(Exception)$");
                String replace = new Regex("(.)([A-Z])").replace((CharSequence) regex.replace((CharSequence) simpleName, ""), "$1_$2");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                Objects.requireNonNull(replace, "null cannot be cast to non-null type java.lang.String");
                String upperCase = replace.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                sb.append(upperCase);
                return sb.toString();
            }
            throw new IllegalArgumentException("Cannot infer code name from class name. We don't support anonymous classes.".toString());
        }
    }
}
