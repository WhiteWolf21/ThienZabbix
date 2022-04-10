package br.dev.kuhn.handyzabbix.expo.modules.notifications.service.delegates;

import android.content.Context;
import android.content.SharedPreferences;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationCategory;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo24974d2 = {"Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allNotificationCategories", "", "Lexpo/modules/notifications/notifications/model/NotificationCategory;", "getAllNotificationCategories", "()Ljava/util/Collection;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getNotificationCategory", "identifier", "", "preferencesNotificationCategoryKey", "removeNotificationCategory", "", "saveNotificationCategory", "notificationCategory", "Companion", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: SharedPreferencesNotificationCategoriesStore.kt */
public final class SharedPreferencesNotificationCategoriesStore {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NOTIFICATION_CATEGORY_KEY_PREFIX = "notification_category-";
    private static final String SHARED_PREFERENCES_NAME = "expo.modules.notifications.SharedPreferencesNotificationCategoriesStore";
    private final SharedPreferences sharedPreferences;

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo24974d2 = {"Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore$Companion;", "", "()V", "NOTIFICATION_CATEGORY_KEY_PREFIX", "", "SHARED_PREFERENCES_NAME", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: SharedPreferencesNotificationCategoriesStore.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SharedPreferencesNotificationCategoriesStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final NotificationCategory getNotificationCategory(java.lang.String r6) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r5 = this;
            java.lang.String r0 = "identifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.content.SharedPreferences r0 = r5.sharedPreferences
            java.lang.String r6 = r5.preferencesNotificationCategoryKey(r6)
            r1 = 0
            java.lang.String r6 = r0.getString(r6, r1)
            if (r6 == 0) goto L_0x0075
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r2 = 2
            byte[] r6 = android.util.Base64.decode(r6, r2)
            r0.<init>(r6)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r6 = r1
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r2 = r0
            java.io.ByteArrayInputStream r2 = (java.io.ByteArrayInputStream) r2     // Catch:{ all -> 0x006e }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ all -> 0x006e }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x006e }
            r3.<init>(r2)     // Catch:{ all -> 0x006e }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x006e }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x006e }
            r2 = r3
            java.io.ObjectInputStream r2 = (java.io.ObjectInputStream) r2     // Catch:{ all -> 0x0067 }
            java.lang.Object r2 = r2.readObject()     // Catch:{ all -> 0x0067 }
            boolean r4 = r2 instanceof expo.modules.notifications.notifications.model.NotificationCategory     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x0044
            kotlin.p008io.CloseableKt.closeFinally(r3, r1)     // Catch:{ all -> 0x006e }
            kotlin.p008io.CloseableKt.closeFinally(r0, r6)
            r1 = r2
            expo.modules.notifications.notifications.model.NotificationCategory r1 = (expo.modules.notifications.notifications.model.NotificationCategory) r1
            goto L_0x0075
        L_0x0044:
            java.io.InvalidClassException r6 = new java.io.InvalidClassException     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "Expected serialized object to be an instance of "
            r1.append(r4)     // Catch:{ all -> 0x0067 }
            java.lang.Class<expo.modules.notifications.notifications.model.NotificationCategory> r4 = expo.modules.notifications.notifications.model.NotificationCategory.class
            r1.append(r4)     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = ". Found: "
            r1.append(r4)     // Catch:{ all -> 0x0067 }
            r1.append(r2)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0067 }
            r6.<init>(r1)     // Catch:{ all -> 0x0067 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x006e:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r1 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r0, r6)
            throw r1
        L_0x0075:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.delegates.SharedPreferencesNotificationCategoriesStore.getNotificationCategory(java.lang.String):expo.modules.notifications.notifications.model.NotificationCategory");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ca, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cd, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.p008io.CloseableKt.closeFinally(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        throw r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<NotificationCategory> getAllNotificationCategories() {
        /*
            r10 = this;
            android.content.SharedPreferences r0 = r10.sharedPreferences
            java.lang.String r1 = "sharedPreferences"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Map r0 = r0.getAll()
            java.lang.String r1 = "sharedPreferences\n        .all"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            r3 = 2
            r4 = 0
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r5 = r2.getKey()
            java.lang.String r6 = "it.key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            java.lang.String r7 = "notification_category-"
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r5, r7, r6, r3, r4)
            if (r3 == 0) goto L_0x001f
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            r1.put(r3, r2)
            goto L_0x001f
        L_0x004d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x005c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00d9
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            if (r2 == 0) goto L_0x00d2
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            byte[] r2 = android.util.Base64.decode(r2, r3)     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            r5.<init>(r2)     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            r2 = r4
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            r6 = r5
            java.io.ByteArrayInputStream r6 = (java.io.ByteArrayInputStream) r6     // Catch:{ all -> 0x00cb }
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch:{ all -> 0x00cb }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ all -> 0x00cb }
            r7.<init>(r6)     // Catch:{ all -> 0x00cb }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x00cb }
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00cb }
            r8 = r7
            java.io.ObjectInputStream r8 = (java.io.ObjectInputStream) r8     // Catch:{ all -> 0x00c4 }
            java.lang.Object r8 = r8.readObject()     // Catch:{ all -> 0x00c4 }
            boolean r9 = r8 instanceof expo.modules.notifications.notifications.model.NotificationCategory     // Catch:{ all -> 0x00c4 }
            if (r9 == 0) goto L_0x00a1
            kotlin.p008io.CloseableKt.closeFinally(r7, r6)     // Catch:{ all -> 0x00cb }
            kotlin.p008io.CloseableKt.closeFinally(r5, r2)     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            expo.modules.notifications.notifications.model.NotificationCategory r8 = (expo.modules.notifications.notifications.model.NotificationCategory) r8     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            goto L_0x00d3
        L_0x00a1:
            java.io.InvalidClassException r2 = new java.io.InvalidClassException     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r6.<init>()     // Catch:{ all -> 0x00c4 }
            java.lang.String r9 = "Expected serialized object to be an instance of "
            r6.append(r9)     // Catch:{ all -> 0x00c4 }
            java.lang.Class<expo.modules.notifications.notifications.model.NotificationCategory> r9 = expo.modules.notifications.notifications.model.NotificationCategory.class
            r6.append(r9)     // Catch:{ all -> 0x00c4 }
            java.lang.String r9 = ". Found: "
            r6.append(r9)     // Catch:{ all -> 0x00c4 }
            r6.append(r8)     // Catch:{ all -> 0x00c4 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c4 }
            r2.<init>(r6)     // Catch:{ all -> 0x00c4 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x00c4 }
            throw r2     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r6 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r7, r2)     // Catch:{ all -> 0x00cb }
            throw r6     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r6 = move-exception
            kotlin.p008io.CloseableKt.closeFinally(r5, r2)     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
            throw r6     // Catch:{ IOException | ClassNotFoundException -> 0x00d2 }
        L_0x00d2:
            r8 = r4
        L_0x00d3:
            if (r8 == 0) goto L_0x005c
            r0.add(r8)
            goto L_0x005c
        L_0x00d9:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.delegates.SharedPreferencesNotificationCategoriesStore.getAllNotificationCategories():java.util.Collection");
    }

    public final NotificationCategory saveNotificationCategory(NotificationCategory notificationCategory) throws IOException {
        Intrinsics.checkNotNullParameter(notificationCategory, NotificationsService.NOTIFICATION_CATEGORY_KEY);
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        String identifier = notificationCategory.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "notificationCategory.identifier");
        if (edit.putString(preferencesNotificationCategoryKey(identifier), Base64SerializationKt.encodedInBase64(notificationCategory)).commit()) {
            return notificationCategory;
        }
        return null;
    }

    public final boolean removeNotificationCategory(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationsService.IDENTIFIER_KEY);
        if (this.sharedPreferences.getString(preferencesNotificationCategoryKey(str), (String) null) == null) {
            return false;
        }
        return this.sharedPreferences.edit().remove(preferencesNotificationCategoryKey(str)).commit();
    }

    private final String preferencesNotificationCategoryKey(String str) {
        return NOTIFICATION_CATEGORY_KEY_PREFIX + str;
    }
}
