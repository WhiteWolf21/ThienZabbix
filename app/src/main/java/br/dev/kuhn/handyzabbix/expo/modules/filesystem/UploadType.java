package br.dev.kuhn.handyzabbix.expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, mo24974d2 = {"Lexpo/modules/filesystem/UploadType;", "", "value", "", "(Ljava/lang/String;II)V", "INVALID", "BINARY_CONTENT", "MULTIPART", "Companion", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: UploadType.kt */
public enum UploadType {
    INVALID(-1),
    BINARY_CONTENT(0),
    MULTIPART(1);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final int value;

    private UploadType(int i) {
        this.value = i;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo24974d2 = {"Lexpo/modules/filesystem/UploadType$Companion;", "", "()V", "fromInt", "Lexpo/modules/filesystem/UploadType;", "value", "", "expo-file-system_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: UploadType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UploadType fromInt(int i) {
            UploadType uploadType;
            UploadType[] values = UploadType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    uploadType = null;
                    break;
                }
                uploadType = values[i2];
                if (i == uploadType.value) {
                    break;
                }
                i2++;
            }
            return uploadType != null ? uploadType : UploadType.INVALID;
        }
    }
}
