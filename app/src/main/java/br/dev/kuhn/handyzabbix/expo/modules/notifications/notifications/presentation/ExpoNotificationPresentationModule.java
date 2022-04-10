package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.presentation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import expo.modules.core.ExportedModule;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.ArgumentsNotificationContentBuilder;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Collection;

public class ExpoNotificationPresentationModule extends ExportedModule {
    private static final String EXPORTED_NAME = "ExpoNotificationPresenter";

    public String getName() {
        return EXPORTED_NAME;
    }

    public ExpoNotificationPresentationModule(Context context) {
        super(context);
    }

    @ExpoMethod
    public void presentNotificationAsync(final String str, ReadableArguments readableArguments, final Promise promise) {
        NotificationsService.Companion.present(getContext(), new Notification(createNotificationRequest(str, new ArgumentsNotificationContentBuilder(getContext()).setPayload(readableArguments).build(), (NotificationTrigger) null)), (NotificationBehavior) null, new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    promise.resolve(str);
                    return;
                }
                promise.reject("ERR_NOTIFICATION_PRESENTATION_FAILED", "Notification could not be presented.", (Exception) bundle.getSerializable(NotificationsService.EXCEPTION_KEY));
            }
        });
    }

    @ExpoMethod
    public void getPresentedNotificationsAsync(final Promise promise) {
        NotificationsService.Companion.getAllPresented(getContext(), new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(NotificationsService.NOTIFICATIONS_KEY);
                if (i != 0 || parcelableArrayList == null) {
                    promise.reject("ERR_NOTIFICATIONS_FETCH_FAILED", "A list of displayed notifications could not be fetched.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
                    return;
                }
                promise.resolve(ExpoNotificationPresentationModule.this.serializeNotifications(parcelableArrayList));
            }
        });
    }

    @ExpoMethod
    public void dismissNotificationAsync(String str, final Promise promise) {
        NotificationsService.Companion.dismiss(getContext(), new String[]{str}, new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    promise.resolve((Object) null);
                    return;
                }
                promise.reject("ERR_NOTIFICATION_DISMISSAL_FAILED", "Notification could not be dismissed.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
            }
        });
    }

    @ExpoMethod
    public void dismissAllNotificationsAsync(final Promise promise) {
        NotificationsService.Companion.dismissAll(getContext(), new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    promise.resolve((Object) null);
                    return;
                }
                promise.reject("ERR_NOTIFICATIONS_DISMISSAL_FAILED", "Notifications could not be dismissed.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
            }
        });
    }

    /* access modifiers changed from: protected */
    public NotificationRequest createNotificationRequest(String str, NotificationContent notificationContent, NotificationTrigger notificationTrigger) {
        return new NotificationRequest(str, notificationContent, (NotificationTrigger) null);
    }

    /* access modifiers changed from: protected */
    public ArrayList<Bundle> serializeNotifications(Collection<Notification> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (Notification bundle : collection) {
            arrayList.add(NotificationSerializer.toBundle(bundle));
        }
        return arrayList;
    }
}
