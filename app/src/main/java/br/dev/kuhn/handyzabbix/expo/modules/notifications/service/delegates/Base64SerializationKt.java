package br.dev.kuhn.handyzabbix.expo.modules.notifications.service.delegates;

import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0005¨\u0006\u0006"}, mo24974d2 = {"asBase64EncodedObject", "T", "", "(Ljava/lang/String;)Ljava/lang/Object;", "encodedInBase64", "Ljava/io/Serializable;", "expo-notifications_release"}, mo24975k = 2, mo24976mv = {1, 4, 1})
/* compiled from: Base64Serialization.kt */
public final class Base64SerializationKt {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String encodedInBase64(java.io.Serializable r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "$this$encodedInBase64"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r0
            java.io.ByteArrayOutputStream r3 = (java.io.ByteArrayOutputStream) r3     // Catch:{ all -> 0x0041 }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0041 }
            r5 = r3
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0041 }
            r4.<init>(r5)     // Catch:{ all -> 0x0041 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x0041 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0041 }
            r5 = r4
            java.io.ObjectOutputStream r5 = (java.io.ObjectOutputStream) r5     // Catch:{ all -> 0x003a }
            r5.writeObject(r6)     // Catch:{ all -> 0x003a }
            byte[] r6 = r3.toByteArray()     // Catch:{ all -> 0x003a }
            r3 = 2
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r3)     // Catch:{ all -> 0x003a }
            kotlin.p008io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x0041 }
            kotlin.p008io.CloseableKt.closeFinally(r0, r2)
            java.lang.String r0 = "ByteArrayOutputStream().…Base64.NO_WRAP)\n    }\n  }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        L_0x003a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003c }
        L_0x003c:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r4, r6)     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.delegates.Base64SerializationKt.encodedInBase64(java.io.Serializable):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.p008io.CloseableKt.closeFinally(r6, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.p008io.CloseableKt.closeFinally(r1, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T asBase64EncodedObject(java.lang.String r8) throws java.io.IOException, java.lang.ClassNotFoundException, java.io.InvalidClassException {
        /*
            java.lang.String r0 = "T"
            java.lang.String r1 = "$this$asBase64EncodedObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r2 = 2
            byte[] r8 = android.util.Base64.decode(r8, r2)
            r1.<init>(r8)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r8 = 0
            r3 = r8
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r4 = 1
            r5 = r1
            java.io.ByteArrayInputStream r5 = (java.io.ByteArrayInputStream) r5     // Catch:{ all -> 0x007c }
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ all -> 0x007c }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ all -> 0x007c }
            r6.<init>(r5)     // Catch:{ all -> 0x007c }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x007c }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x007c }
            r5 = r6
            java.io.ObjectInputStream r5 = (java.io.ObjectInputStream) r5     // Catch:{ all -> 0x006f }
            java.lang.Object r5 = r5.readObject()     // Catch:{ all -> 0x006f }
            r7 = 3
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r7, r0)     // Catch:{ all -> 0x006f }
            boolean r7 = r5 instanceof java.lang.Object     // Catch:{ all -> 0x006f }
            if (r7 == 0) goto L_0x0048
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)     // Catch:{ all -> 0x007c }
            kotlin.p008io.CloseableKt.closeFinally(r6, r8)     // Catch:{ all -> 0x007c }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)     // Catch:{ all -> 0x007c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.p008io.CloseableKt.closeFinally(r1, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r5
        L_0x0048:
            java.io.InvalidClassException r8 = new java.io.InvalidClassException     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r2.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "Expected serialized object to be an instance of "
            r2.append(r3)     // Catch:{ all -> 0x006f }
            r3 = 4
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r3, r0)     // Catch:{ all -> 0x006f }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r2.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = ". Found: "
            r2.append(r0)     // Catch:{ all -> 0x006f }
            r2.append(r5)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x006f }
            r8.<init>(r0)     // Catch:{ all -> 0x006f }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x006f }
            throw r8     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)     // Catch:{ all -> 0x007c }
            kotlin.p008io.CloseableKt.closeFinally(r6, r8)     // Catch:{ all -> 0x007c }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x007e }
        L_0x007e:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlin.p008io.CloseableKt.closeFinally(r1, r8)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.delegates.Base64SerializationKt.asBase64EncodedObject(java.lang.String):java.lang.Object");
    }
}
