package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.scheduling;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import expo.modules.core.ExportedModule;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.core.interfaces.ExpoMethod;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.ArgumentsNotificationContentBuilder;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.triggers.ChannelAwareTrigger;
import expo.modules.notifications.notifications.triggers.DailyTrigger;
import expo.modules.notifications.notifications.triggers.DateTrigger;
import expo.modules.notifications.notifications.triggers.TimeIntervalTrigger;
import expo.modules.notifications.notifications.triggers.WeeklyTrigger;
import expo.modules.notifications.notifications.triggers.YearlyTrigger;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class NotificationScheduler extends ExportedModule {
    private static final String EXPORTED_NAME = "ExpoNotificationScheduler";
    protected static Handler HANDLER = new Handler(Looper.getMainLooper());

    public String getName() {
        return EXPORTED_NAME;
    }

    public NotificationScheduler(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public Context getSchedulingContext() {
        return getContext();
    }

    @ExpoMethod
    public void getAllScheduledNotificationsAsync(final Promise promise) {
        NotificationsService.Companion.getAllScheduledNotifications(getSchedulingContext(), new ResultReceiver(HANDLER) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList(NotificationsService.NOTIFICATION_REQUESTS_KEY);
                    if (parcelableArrayList == null) {
                        promise.reject("ERR_NOTIFICATIONS_FAILED_TO_FETCH", "Failed to fetch scheduled notifications.");
                    } else {
                        promise.resolve(NotificationScheduler.this.serializeScheduledNotificationRequests(parcelableArrayList));
                    }
                } else {
                    promise.reject("ERR_NOTIFICATIONS_FAILED_TO_FETCH", "Failed to fetch scheduled notifications.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
                }
            }
        });
    }

    @ExpoMethod
    public void scheduleNotificationAsync(final String str, ReadableArguments readableArguments, ReadableArguments readableArguments2, final Promise promise) {
        try {
            NotificationsService.Companion.schedule(getSchedulingContext(), createNotificationRequest(str, new ArgumentsNotificationContentBuilder(getContext()).setPayload(readableArguments).build(), triggerFromParams(readableArguments2)), new ResultReceiver(HANDLER) {
                /* access modifiers changed from: protected */
                public void onReceiveResult(int i, Bundle bundle) {
                    super.onReceiveResult(i, bundle);
                    if (i == 0) {
                        promise.resolve(str);
                        return;
                    }
                    Exception exc = (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY);
                    if (exc == null) {
                        promise.reject("ERR_NOTIFICATIONS_FAILED_TO_SCHEDULE", "Failed to schedule notification.");
                        return;
                    }
                    Promise promise = promise;
                    promise.reject("ERR_NOTIFICATIONS_FAILED_TO_SCHEDULE", "Failed to schedule the notification. " + exc.getMessage(), exc);
                }
            });
        } catch (InvalidArgumentException e) {
            promise.reject("ERR_NOTIFICATIONS_FAILED_TO_SCHEDULE", "Failed to schedule the notification. " + e.getMessage(), e);
        } catch (NullPointerException e2) {
            promise.reject("ERR_NOTIFICATIONS_FAILED_TO_SCHEDULE", "Failed to schedule the notification. Encountered unexpected null value. " + e2.getMessage(), e2);
        }
    }

    @ExpoMethod
    public void cancelScheduledNotificationAsync(String str, final Promise promise) {
        NotificationsService.Companion.removeScheduledNotification(getSchedulingContext(), str, new ResultReceiver(HANDLER) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    promise.resolve((Object) null);
                    return;
                }
                promise.reject("ERR_NOTIFICATIONS_FAILED_TO_CANCEL", "Failed to cancel notification.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
            }
        });
    }

    @ExpoMethod
    public void cancelAllScheduledNotificationsAsync(final Promise promise) {
        NotificationsService.Companion.removeAllScheduledNotifications(getSchedulingContext(), new ResultReceiver(HANDLER) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                if (i == 0) {
                    promise.resolve((Object) null);
                    return;
                }
                promise.reject("ERR_NOTIFICATIONS_FAILED_TO_CANCEL", "Failed to cancel all notifications.", (Exception) bundle.getParcelable(NotificationsService.EXCEPTION_KEY));
            }
        });
    }

    @ExpoMethod
    public void getNextTriggerDateAsync(ReadableArguments readableArguments, Promise promise) {
        String str;
        try {
            NotificationTrigger triggerFromParams = triggerFromParams(readableArguments);
            if (triggerFromParams instanceof SchedulableNotificationTrigger) {
                Date nextTriggerDate = ((SchedulableNotificationTrigger) triggerFromParams).nextTriggerDate();
                if (nextTriggerDate == null) {
                    promise.resolve((Object) null);
                } else {
                    promise.resolve(Double.valueOf((double) nextTriggerDate.getTime()));
                }
            } else {
                if (triggerFromParams == null) {
                    str = "null";
                } else {
                    str = triggerFromParams.getClass().getName();
                }
                promise.reject("ERR_NOTIFICATIONS_INVALID_CALENDAR_TRIGGER", String.format("It is not possible to get next trigger date for triggers other than calendar-based. Provided trigger resulted in %s trigger.", new Object[]{str}));
            }
        } catch (InvalidArgumentException e) {
            promise.reject("ERR_NOTIFICATIONS_FAILED_TO_GET_NEXT_TRIGGER_DATE", "Failed to get next trigger date for the trigger. " + e.getMessage(), e);
        } catch (NullPointerException e2) {
            promise.reject("ERR_NOTIFICATIONS_FAILED_TO_GET_NEXT_TRIGGER_DATE", "Failed to get next trigger date for the trigger. Encountered unexpected null value. " + e2.getMessage(), e2);
        }
    }

    /* access modifiers changed from: protected */
    public NotificationTrigger triggerFromParams(ReadableArguments readableArguments) throws InvalidArgumentException {
        if (readableArguments == null) {
            return null;
        }
        String string = readableArguments.getString("channelId", (String) null);
        String string2 = readableArguments.getString(NotificationsService.EVENT_TYPE_KEY);
        string2.hashCode();
        char c = 65535;
        switch (string2.hashCode()) {
            case -791707519:
                if (string2.equals("weekly")) {
                    c = 0;
                    break;
                }
                break;
            case -734561654:
                if (string2.equals("yearly")) {
                    c = 1;
                    break;
                }
                break;
            case 3076014:
                if (string2.equals("date")) {
                    c = 2;
                    break;
                }
                break;
            case 95346201:
                if (string2.equals("daily")) {
                    c = 3;
                    break;
                }
                break;
            case 738950403:
                if (string2.equals("channel")) {
                    c = 4;
                    break;
                }
                break;
            case 913014450:
                if (string2.equals("timeInterval")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if ((readableArguments.get("weekday") instanceof Number) && (readableArguments.get("hour") instanceof Number) && (readableArguments.get("minute") instanceof Number)) {
                    return new WeeklyTrigger(((Number) readableArguments.get("weekday")).intValue(), ((Number) readableArguments.get("hour")).intValue(), ((Number) readableArguments.get("minute")).intValue(), string);
                }
                throw new InvalidArgumentException("Invalid value(s) provided for weekly trigger.");
            case 1:
                if (!(readableArguments.get("day") instanceof Number) || !(readableArguments.get("month") instanceof Number) || !(readableArguments.get("hour") instanceof Number) || !(readableArguments.get("minute") instanceof Number)) {
                    throw new InvalidArgumentException("Invalid value(s) provided for yearly trigger.");
                }
                return new YearlyTrigger(((Number) readableArguments.get("day")).intValue(), ((Number) readableArguments.get("month")).intValue(), ((Number) readableArguments.get("hour")).intValue(), ((Number) readableArguments.get("minute")).intValue(), string);
            case 2:
                if (readableArguments.get("timestamp") instanceof Number) {
                    return new DateTrigger(((Number) readableArguments.get("timestamp")).longValue(), string);
                }
                throw new InvalidArgumentException("Invalid value provided as date of trigger.");
            case 3:
                if ((readableArguments.get("hour") instanceof Number) && (readableArguments.get("minute") instanceof Number)) {
                    return new DailyTrigger(((Number) readableArguments.get("hour")).intValue(), ((Number) readableArguments.get("minute")).intValue(), string);
                }
                throw new InvalidArgumentException("Invalid value(s) provided for daily trigger.");
            case 4:
                return new ChannelAwareTrigger(string);
            case 5:
                if (readableArguments.get("seconds") instanceof Number) {
                    return new TimeIntervalTrigger(((Number) readableArguments.get("seconds")).longValue(), readableArguments.getBoolean("repeats"), string);
                }
                throw new InvalidArgumentException("Invalid value provided as interval of trigger.");
            default:
                throw new InvalidArgumentException("Trigger of type: " + readableArguments.getString(NotificationsService.EVENT_TYPE_KEY) + " is not supported on Android.");
        }
    }

    /* access modifiers changed from: protected */
    public NotificationRequest createNotificationRequest(String str, NotificationContent notificationContent, NotificationTrigger notificationTrigger) {
        return new NotificationRequest(str, notificationContent, notificationTrigger);
    }

    /* access modifiers changed from: protected */
    public Collection<Bundle> serializeScheduledNotificationRequests(Collection<NotificationRequest> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (NotificationRequest bundle : collection) {
            arrayList.add(NotificationSerializer.toBundle(bundle));
        }
        return arrayList;
    }
}
