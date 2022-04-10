package br.dev.kuhn.handyzabbix.expo.modules.notifications.service.delegates;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.NotificationManager;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.Notification;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationBehavior;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationResponse;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.NotificationsService;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.service.interfaces.HandlingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, mo24974d2 = {"Lexpo/modules/notifications/service/delegates/ExpoHandlingDelegate;", "Lexpo/modules/notifications/service/interfaces/HandlingDelegate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getListeners", "", "Lexpo/modules/notifications/notifications/NotificationManager;", "getMainActivityLauncher", "Landroid/content/Intent;", "getNotificationActionLauncher", "handleNotification", "", "notification", "Lexpo/modules/notifications/notifications/model/Notification;", "handleNotificationResponse", "notificationResponse", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "handleNotificationsDropped", "isAppInForeground", "", "openAppToForeground", "Companion", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: ExpoHandlingDelegate.kt */
public final class ExpoHandlingDelegate implements HandlingDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OPEN_APP_INTENT_ACTION = "expo.modules.notifications.OPEN_APP_ACTION";
    /* access modifiers changed from: private */
    public static WeakHashMap<NotificationManager, WeakReference<NotificationManager>> sListenersReferences = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public static Collection<NotificationResponse> sPendingNotificationResponses = new ArrayList();
    private final Context context;

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, mo24974d2 = {"Lexpo/modules/notifications/service/delegates/ExpoHandlingDelegate$Companion;", "", "()V", "OPEN_APP_INTENT_ACTION", "", "sListenersReferences", "Ljava/util/WeakHashMap;", "Lexpo/modules/notifications/notifications/NotificationManager;", "Ljava/lang/ref/WeakReference;", "getSListenersReferences", "()Ljava/util/WeakHashMap;", "setSListenersReferences", "(Ljava/util/WeakHashMap;)V", "sPendingNotificationResponses", "", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "getSPendingNotificationResponses", "()Ljava/util/Collection;", "setSPendingNotificationResponses", "(Ljava/util/Collection;)V", "addListener", "", "listener", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: ExpoHandlingDelegate.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Collection<NotificationResponse> getSPendingNotificationResponses() {
            return ExpoHandlingDelegate.sPendingNotificationResponses;
        }

        /* access modifiers changed from: protected */
        public final void setSPendingNotificationResponses(Collection<NotificationResponse> collection) {
            Intrinsics.checkNotNullParameter(collection, "<set-?>");
            ExpoHandlingDelegate.sPendingNotificationResponses = collection;
        }

        /* access modifiers changed from: protected */
        public final WeakHashMap<NotificationManager, WeakReference<NotificationManager>> getSListenersReferences() {
            return ExpoHandlingDelegate.sListenersReferences;
        }

        /* access modifiers changed from: protected */
        public final void setSListenersReferences(WeakHashMap<NotificationManager, WeakReference<NotificationManager>> weakHashMap) {
            Intrinsics.checkNotNullParameter(weakHashMap, "<set-?>");
            ExpoHandlingDelegate.sListenersReferences = weakHashMap;
        }

        public final void addListener(NotificationManager notificationManager) {
            Intrinsics.checkNotNullParameter(notificationManager, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Companion companion = this;
            if (!companion.getSListenersReferences().containsKey(notificationManager)) {
                companion.getSListenersReferences().put(notificationManager, new WeakReference(notificationManager));
                if (!companion.getSPendingNotificationResponses().isEmpty()) {
                    Iterator<NotificationResponse> it = companion.getSPendingNotificationResponses().iterator();
                    while (it.hasNext()) {
                        notificationManager.onNotificationResponseReceived(it.next());
                        it.remove();
                    }
                }
            }
        }
    }

    public ExpoHandlingDelegate(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    public final boolean isAppInForeground() {
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "ProcessLifecycleOwner.get().lifecycle");
        return lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public final List<NotificationManager> getListeners() {
        Collection<WeakReference<NotificationManager>> values = sListenersReferences.values();
        Intrinsics.checkNotNullExpressionValue(values, "sListenersReferences.values");
        Collection arrayList = new ArrayList();
        for (WeakReference weakReference : values) {
            NotificationManager notificationManager = (NotificationManager) weakReference.get();
            if (notificationManager != null) {
                arrayList.add(notificationManager);
            }
        }
        return (List) arrayList;
    }

    public void handleNotification(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, NotificationsService.NOTIFICATION_KEY);
        if (isAppInForeground()) {
            for (NotificationManager onNotificationReceived : getListeners()) {
                onNotificationReceived.onNotificationReceived(notification);
            }
            return;
        }
        NotificationsService.Companion.present$default(NotificationsService.Companion, this.context, notification, (NotificationBehavior) null, (ResultReceiver) null, 12, (Object) null);
    }

    public void handleNotificationResponse(NotificationResponse notificationResponse) {
        Intrinsics.checkNotNullParameter(notificationResponse, NotificationsService.NOTIFICATION_RESPONSE_KEY);
        if (notificationResponse.getAction().opensAppToForeground()) {
            openAppToForeground(this.context, notificationResponse);
        }
        if (getListeners().isEmpty()) {
            sPendingNotificationResponses.add(notificationResponse);
            return;
        }
        for (NotificationManager onNotificationResponseReceived : getListeners()) {
            onNotificationResponseReceived.onNotificationResponseReceived(notificationResponse);
        }
    }

    /* access modifiers changed from: protected */
    public final void openAppToForeground(Context context2, NotificationResponse notificationResponse) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(notificationResponse, NotificationsService.NOTIFICATION_RESPONSE_KEY);
        Intent notificationActionLauncher = getNotificationActionLauncher(context2);
        if (notificationActionLauncher == null) {
            notificationActionLauncher = getMainActivityLauncher(context2);
        }
        if (notificationActionLauncher != null) {
            NotificationsService.Companion.setNotificationResponseToIntent(notificationActionLauncher, notificationResponse);
            context2.startActivity(notificationActionLauncher);
            return;
        }
        Log.w("expo-notifications", "No launch intent found for application. Interacting with the notification won't open the app. The implementation uses `getLaunchIntentForPackage` to find appropriate activity.");
    }

    private final Intent getNotificationActionLauncher(Context context2) {
        Intent intent = new Intent(OPEN_APP_INTENT_ACTION);
        intent.addFlags(268435456);
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        intent.setPackage(applicationContext.getPackageName());
        if (context2.getPackageManager().resolveActivity(intent, 0) != null) {
            return intent;
        }
        return null;
    }

    private final Intent getMainActivityLauncher(Context context2) {
        return context2.getPackageManager().getLaunchIntentForPackage(context2.getPackageName());
    }

    public void handleNotificationsDropped() {
        for (NotificationManager onNotificationsDropped : getListeners()) {
            onNotificationsDropped.onNotificationsDropped();
        }
    }
}
