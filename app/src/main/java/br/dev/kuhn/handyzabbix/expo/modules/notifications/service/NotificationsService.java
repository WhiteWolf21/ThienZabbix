package br.dev.kuhn.handyzabbix.expo.modules.notifications.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.core.app.RemoteInput;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.Notification;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationAction;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationBehavior;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationCategory;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationRequest;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationResponse;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.TextInputNotificationAction;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.TextInputNotificationResponse;
import expo.modules.notifications.service.delegates.ExpoCategoriesDelegate;
import expo.modules.notifications.service.delegates.ExpoHandlingDelegate;
import expo.modules.notifications.service.delegates.ExpoPresentationDelegate;
import expo.modules.notifications.service.delegates.ExpoSchedulingDelegate;
import expo.modules.notifications.service.interfaces.CategoriesDelegate;
import expo.modules.notifications.service.interfaces.HandlingDelegate;
import expo.modules.notifications.service.interfaces.PresentationDelegate;
import expo.modules.notifications.service.interfaces.SchedulingDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p014io.FilenameUtils;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006%"}, mo24974d2 = {"Lexpo/modules/notifications/service/NotificationsService;", "Landroid/content/BroadcastReceiver;", "()V", "getCategoriesDelegate", "Lexpo/modules/notifications/service/interfaces/CategoriesDelegate;", "context", "Landroid/content/Context;", "getHandlingDelegate", "Lexpo/modules/notifications/service/interfaces/HandlingDelegate;", "getPresentationDelegate", "Lexpo/modules/notifications/service/interfaces/PresentationDelegate;", "getSchedulingDelegate", "Lexpo/modules/notifications/service/interfaces/SchedulingDelegate;", "handleIntent", "", "intent", "Landroid/content/Intent;", "onDeleteCategory", "Landroid/os/Bundle;", "onDismissAllNotifications", "onDismissNotifications", "onGetAllPresentedNotifications", "onGetAllScheduledNotifications", "onGetCategories", "onGetScheduledNotification", "onNotificationTriggered", "onNotificationsDropped", "onPresentNotification", "onReceive", "onReceiveNotification", "onReceiveNotificationResponse", "onRemoveAllScheduledNotifications", "onRemoveScheduledNotifications", "onScheduleNotification", "onSetCategory", "onSetupScheduledNotifications", "Companion", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: NotificationsService.kt */
public class NotificationsService extends BroadcastReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DELETE_CATEGORY_TYPE = "deleteCategory";
    private static final String DISMISS_ALL_TYPE = "dismissAll";
    private static final String DISMISS_SELECTED_TYPE = "dismissSelected";
    private static final String DROPPED_TYPE = "dropped";
    public static final int ERROR_CODE = 1;
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EXCEPTION_KEY = "exception";
    private static final String GET_ALL_DISPLAYED_TYPE = "getAllDisplayed";
    private static final String GET_ALL_SCHEDULED_TYPE = "getAllScheduled";
    private static final String GET_CATEGORIES_TYPE = "getCategories";
    private static final String GET_SCHEDULED_TYPE = "getScheduled";
    public static final String IDENTIFIERS_KEY = "identifiers";
    public static final String IDENTIFIER_KEY = "identifier";
    public static final String NOTIFICATIONS_KEY = "notifications";
    public static final String NOTIFICATION_ACTION_KEY = "notificationAction";
    public static final String NOTIFICATION_BEHAVIOR_KEY = "notificationBehavior";
    public static final String NOTIFICATION_CATEGORIES_KEY = "notificationCategories";
    public static final String NOTIFICATION_CATEGORY_KEY = "notificationCategory";
    public static final String NOTIFICATION_EVENT_ACTION = "expo.modules.notifications.NOTIFICATION_EVENT";
    public static final String NOTIFICATION_KEY = "notification";
    public static final String NOTIFICATION_REQUESTS_KEY = "notificationRequests";
    public static final String NOTIFICATION_REQUEST_KEY = "notificationRequest";
    public static final String NOTIFICATION_RESPONSE_KEY = "notificationResponse";
    private static final String PRESENT_TYPE = "present";
    public static final String RECEIVER_KEY = "receiver";
    private static final String RECEIVE_RESPONSE_TYPE = "receiveResponse";
    private static final String RECEIVE_TYPE = "receive";
    private static final String REMOVE_ALL_TYPE = "removeAll";
    private static final String REMOVE_SELECTED_TYPE = "removeSelected";
    private static final String SCHEDULE_TYPE = "schedule";
    /* access modifiers changed from: private */
    public static final List<String> SETUP_ACTIONS = CollectionsKt.listOf("android.intent.action.BOOT_COMPLETED", "android.intent.action.REBOOT", "android.intent.action.MY_PACKAGE_REPLACED", "android.intent.action.QUICKBOOT_POWERON", "com.htc.intent.action.QUICKBOOT_POWERON");
    private static final String SET_CATEGORY_TYPE = "setCategory";
    public static final String SUCCEEDED_KEY = "succeeded";
    public static final int SUCCESS_CODE = 0;
    public static final String TEXT_INPUT_NOTIFICATION_RESPONSE_KEY = "textInputNotificationResponse";
    private static final String TRIGGER_TYPE = "trigger";
    public static final String USER_TEXT_RESPONSE_KEY = "userTextResponse";

    @Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00106\u001a\u00020\u0004J\"\u00107\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J-\u0010;\u001a\u0002082\u0006\u0010/\u001a\u0002002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040=2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:¢\u0006\u0002\u0010>J\u001a\u0010?\u001a\u0002082\u0006\u0010/\u001a\u0002002\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010@\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u0010A\u001a\u00020BJ\u0018\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010/\u001a\u0002002\u0006\u0010A\u001a\u00020BJ\u001a\u0010E\u001a\u0002082\u0006\u0010/\u001a\u0002002\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u001a\u0010F\u001a\u0002082\u0006\u0010/\u001a\u0002002\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J\u001a\u0010H\u001a\u0002082\u0006\u0010/\u001a\u0002002\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010A\u001a\u00020BJ\"\u0010K\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J\b\u0010L\u001a\u00020MH\u0004J\u0010\u0010N\u001a\u00020M2\u0006\u00106\u001a\u00020\u0004H\u0004J\u000e\u0010O\u001a\u0002082\u0006\u0010/\u001a\u000200J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020SH\u0002J.\u0010T\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\"\u0010W\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u001a\u0010X\u001a\u0002082\u0006\u0010/\u001a\u0002002\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J\"\u0010Y\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J(\u0010Z\u001a\u0002082\u0006\u0010/\u001a\u0002002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040[2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J\"\u0010\\\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u0010]\u001a\u00020^2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010:J\"\u0010_\u001a\u0002082\u0006\u0010/\u001a\u0002002\u0006\u0010`\u001a\u00020a2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010b\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010c\u001a\u00020JJ-\u0010d\u001a\u0004\u0018\u0001He\"\u0004\b\u0000\u0010e2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0g2\b\u0010h\u001a\u0004\u0018\u00010QH\u0002¢\u0006\u0002\u0010iR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006j"}, mo24974d2 = {"Lexpo/modules/notifications/service/NotificationsService$Companion;", "", "()V", "DELETE_CATEGORY_TYPE", "", "DISMISS_ALL_TYPE", "DISMISS_SELECTED_TYPE", "DROPPED_TYPE", "ERROR_CODE", "", "EVENT_TYPE_KEY", "EXCEPTION_KEY", "GET_ALL_DISPLAYED_TYPE", "GET_ALL_SCHEDULED_TYPE", "GET_CATEGORIES_TYPE", "GET_SCHEDULED_TYPE", "IDENTIFIERS_KEY", "IDENTIFIER_KEY", "NOTIFICATIONS_KEY", "NOTIFICATION_ACTION_KEY", "NOTIFICATION_BEHAVIOR_KEY", "NOTIFICATION_CATEGORIES_KEY", "NOTIFICATION_CATEGORY_KEY", "NOTIFICATION_EVENT_ACTION", "NOTIFICATION_KEY", "NOTIFICATION_REQUESTS_KEY", "NOTIFICATION_REQUEST_KEY", "NOTIFICATION_RESPONSE_KEY", "PRESENT_TYPE", "RECEIVER_KEY", "RECEIVE_RESPONSE_TYPE", "RECEIVE_TYPE", "REMOVE_ALL_TYPE", "REMOVE_SELECTED_TYPE", "SCHEDULE_TYPE", "SETUP_ACTIONS", "", "getSETUP_ACTIONS", "()Ljava/util/List;", "SET_CATEGORY_TYPE", "SUCCEEDED_KEY", "SUCCESS_CODE", "TEXT_INPUT_NOTIFICATION_RESPONSE_KEY", "TRIGGER_TYPE", "USER_TEXT_RESPONSE_KEY", "createNotificationResponseIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "notification", "Lexpo/modules/notifications/notifications/model/Notification;", "action", "Lexpo/modules/notifications/notifications/model/NotificationAction;", "createNotificationTrigger", "identifier", "deleteCategory", "", "receiver", "Landroid/os/ResultReceiver;", "dismiss", "identifiers", "", "(Landroid/content/Context;[Ljava/lang/String;Landroid/os/ResultReceiver;)V", "dismissAll", "doWork", "intent", "Landroid/content/Intent;", "findDesignatedBroadcastReceiver", "Landroid/content/pm/ActivityInfo;", "getAllPresented", "getAllScheduledNotifications", "resultReceiver", "getCategories", "getNotificationResponseFromIntent", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "getScheduledNotification", "getUriBuilder", "Landroid/net/Uri$Builder;", "getUriBuilderForIdentifier", "handleDropped", "marshalObject", "", "objectToMarshal", "Landroid/os/Parcelable;", "present", "behavior", "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "receive", "removeAllScheduledNotifications", "removeScheduledNotification", "removeScheduledNotifications", "", "schedule", "notificationRequest", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "setCategory", "category", "Lexpo/modules/notifications/notifications/model/NotificationCategory;", "setNotificationResponseToIntent", "notificationResponse", "unmarshalObject", "T", "creator", "Landroid/os/Parcelable$Creator;", "byteArray", "(Landroid/os/Parcelable$Creator;[B)Ljava/lang/Object;", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
    /* compiled from: NotificationsService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getSETUP_ACTIONS() {
            return NotificationsService.SETUP_ACTIONS;
        }

        public static /* synthetic */ void getAllPresented$default(Companion companion, Context context, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 2) != 0) {
                resultReceiver = null;
            }
            companion.getAllPresented(context, resultReceiver);
        }

        public final void getAllPresented(Context context, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.GET_ALL_DISPLAYED_TYPE);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void present$default(Companion companion, Context context, Notification notification, NotificationBehavior notificationBehavior, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                notificationBehavior = null;
            }
            if ((i & 8) != 0) {
                resultReceiver = null;
            }
            companion.present(context, notification, notificationBehavior, resultReceiver);
        }

        public final void present(Context context, Notification notification, NotificationBehavior notificationBehavior, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notification, NotificationsService.NOTIFICATION_KEY);
            Companion companion = this;
            NotificationRequest notificationRequest = notification.getNotificationRequest();
            Intrinsics.checkNotNullExpressionValue(notificationRequest, "notification.notificationRequest");
            String identifier = notificationRequest.getIdentifier();
            Intrinsics.checkNotNullExpressionValue(identifier, "notification.notificationRequest.identifier");
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilderForIdentifier(identifier).appendPath(NotificationsService.PRESENT_TYPE).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.PRESENT_TYPE);
            intent.putExtra(NotificationsService.NOTIFICATION_KEY, notification);
            intent.putExtra(NotificationsService.NOTIFICATION_BEHAVIOR_KEY, notificationBehavior);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void receive$default(Companion companion, Context context, Notification notification, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.receive(context, notification, resultReceiver);
        }

        public final void receive(Context context, Notification notification, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notification, NotificationsService.NOTIFICATION_KEY);
            Companion companion = this;
            NotificationRequest notificationRequest = notification.getNotificationRequest();
            Intrinsics.checkNotNullExpressionValue(notificationRequest, "notification.notificationRequest");
            String identifier = notificationRequest.getIdentifier();
            Intrinsics.checkNotNullExpressionValue(identifier, "notification.notificationRequest.identifier");
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilderForIdentifier(identifier).appendPath(NotificationsService.RECEIVE_TYPE).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.RECEIVE_TYPE);
            intent.putExtra(NotificationsService.NOTIFICATION_KEY, notification);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void dismiss$default(Companion companion, Context context, String[] strArr, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.dismiss(context, strArr, resultReceiver);
        }

        public final void dismiss(Context context, String[] strArr, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strArr, NotificationsService.IDENTIFIERS_KEY);
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("dismiss").build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.DISMISS_SELECTED_TYPE);
            intent.putExtra(NotificationsService.IDENTIFIERS_KEY, strArr);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void dismissAll$default(Companion companion, Context context, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 2) != 0) {
                resultReceiver = null;
            }
            companion.dismissAll(context, resultReceiver);
        }

        public final void dismissAll(Context context, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("dismiss").build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.DISMISS_ALL_TYPE);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public final void handleDropped(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION);
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.DROPPED_TYPE);
            Unit unit = Unit.INSTANCE;
            doWork(context, intent);
        }

        public static /* synthetic */ void getCategories$default(Companion companion, Context context, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 2) != 0) {
                resultReceiver = null;
            }
            companion.getCategories(context, resultReceiver);
        }

        public final void getCategories(Context context, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("categories").build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.GET_CATEGORIES_TYPE);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void setCategory$default(Companion companion, Context context, NotificationCategory notificationCategory, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.setCategory(context, notificationCategory, resultReceiver);
        }

        public final void setCategory(Context context, NotificationCategory notificationCategory, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notificationCategory, "category");
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("categories").appendPath(notificationCategory.getIdentifier()).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.SET_CATEGORY_TYPE);
            intent.putExtra(NotificationsService.NOTIFICATION_CATEGORY_KEY, notificationCategory);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void deleteCategory$default(Companion companion, Context context, String str, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.deleteCategory(context, str, resultReceiver);
        }

        public final void deleteCategory(Context context, String str, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, NotificationsService.IDENTIFIER_KEY);
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("categories").appendPath(str).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.DELETE_CATEGORY_TYPE);
            intent.putExtra(NotificationsService.IDENTIFIER_KEY, str);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void getAllScheduledNotifications$default(Companion companion, Context context, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 2) != 0) {
                resultReceiver = null;
            }
            companion.getAllScheduledNotifications(context, resultReceiver);
        }

        public final void getAllScheduledNotifications(Context context, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION);
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.GET_ALL_SCHEDULED_TYPE);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            doWork(context, intent);
        }

        public static /* synthetic */ void getScheduledNotification$default(Companion companion, Context context, String str, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.getScheduledNotification(context, str, resultReceiver);
        }

        public final void getScheduledNotification(Context context, String str, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, NotificationsService.IDENTIFIER_KEY);
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("scheduled").appendPath(str).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.GET_SCHEDULED_TYPE);
            intent.putExtra(NotificationsService.IDENTIFIER_KEY, str);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void schedule$default(Companion companion, Context context, NotificationRequest notificationRequest, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.schedule(context, notificationRequest, resultReceiver);
        }

        public final void schedule(Context context, NotificationRequest notificationRequest, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notificationRequest, NotificationsService.NOTIFICATION_REQUEST_KEY);
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("scheduled").appendPath(notificationRequest.getIdentifier()).build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.SCHEDULE_TYPE);
            intent.putExtra(NotificationsService.NOTIFICATION_REQUEST_KEY, notificationRequest);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void removeScheduledNotification$default(Companion companion, Context context, String str, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.removeScheduledNotification(context, str, resultReceiver);
        }

        public final void removeScheduledNotification(Context context, String str, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, NotificationsService.IDENTIFIER_KEY);
            removeScheduledNotifications(context, CollectionsKt.listOf(str), resultReceiver);
        }

        public static /* synthetic */ void removeScheduledNotifications$default(Companion companion, Context context, Collection collection, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 4) != 0) {
                resultReceiver = null;
            }
            companion.removeScheduledNotifications(context, collection, resultReceiver);
        }

        public final void removeScheduledNotifications(Context context, Collection<String> collection, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(collection, NotificationsService.IDENTIFIERS_KEY);
            Companion companion = this;
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION, companion.getUriBuilder().appendPath("scheduled").build());
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.REMOVE_SELECTED_TYPE);
            Object[] array = collection.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            intent.putExtra(NotificationsService.IDENTIFIERS_KEY, (String[]) array);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            companion.doWork(context, intent);
        }

        public static /* synthetic */ void removeAllScheduledNotifications$default(Companion companion, Context context, ResultReceiver resultReceiver, int i, Object obj) {
            if ((i & 2) != 0) {
                resultReceiver = null;
            }
            companion.removeAllScheduledNotifications(context, resultReceiver);
        }

        public final void removeAllScheduledNotifications(Context context, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(NotificationsService.NOTIFICATION_EVENT_ACTION);
            intent.putExtra(NotificationsService.EVENT_TYPE_KEY, NotificationsService.REMOVE_ALL_TYPE);
            intent.putExtra(NotificationsService.RECEIVER_KEY, resultReceiver);
            Unit unit = Unit.INSTANCE;
            doWork(context, intent);
        }

        public final void doWork(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            ActivityInfo findDesignatedBroadcastReceiver = findDesignatedBroadcastReceiver(context, intent);
            if (findDesignatedBroadcastReceiver != null) {
                intent.setComponent(new ComponentName(findDesignatedBroadcastReceiver.packageName, findDesignatedBroadcastReceiver.name));
                context.sendBroadcast(intent);
                return;
            }
            Log.e("expo-notifications", "No service capable of handling notifications found (intent = " + intent.getAction() + "). Ensure that you have configured your AndroidManifest.xml properly.");
        }

        /* access modifiers changed from: protected */
        public final Uri.Builder getUriBuilder() {
            Uri.Builder buildUpon = Uri.parse("expo-notifications://notifications/").buildUpon();
            Intrinsics.checkNotNullExpressionValue(buildUpon, "Uri.parse(\"expo-notifica…ifications/\").buildUpon()");
            return buildUpon;
        }

        /* access modifiers changed from: protected */
        public final Uri.Builder getUriBuilderForIdentifier(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationsService.IDENTIFIER_KEY);
            Uri.Builder appendPath = getUriBuilder().appendPath(str);
            Intrinsics.checkNotNullExpressionValue(appendPath, "getUriBuilder().appendPath(identifier)");
            return appendPath;
        }

        public final ActivityInfo findDesignatedBroadcastReceiver(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intent intent2 = new Intent(intent.getAction()).setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent2, "Intent(intent.action).se…kage(context.packageName)");
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 0);
            Intrinsics.checkNotNullExpressionValue(queryBroadcastReceivers, "context.packageManager.q…eceivers(searchIntent, 0)");
            ResolveInfo resolveInfo = (ResolveInfo) CollectionsKt.firstOrNull(queryBroadcastReceivers);
            if (resolveInfo != null) {
                return resolveInfo.activityInfo;
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x004e, code lost:
            r8 = r8.getClassName();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.app.PendingIntent createNotificationTrigger(android.content.Context r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "identifier"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                android.content.Intent r1 = new android.content.Intent
                r2 = r6
                expo.modules.notifications.service.NotificationsService$Companion r2 = (expo.modules.notifications.service.NotificationsService.Companion) r2
                android.net.Uri$Builder r2 = r2.getUriBuilder()
                java.lang.String r3 = "scheduled"
                android.net.Uri$Builder r2 = r2.appendPath(r3)
                android.net.Uri$Builder r2 = r2.appendPath(r8)
                java.lang.String r3 = "trigger"
                android.net.Uri$Builder r2 = r2.appendPath(r3)
                android.net.Uri r2 = r2.build()
                java.lang.String r4 = "expo.modules.notifications.NOTIFICATION_EVENT"
                r1.<init>(r4, r2)
                expo.modules.notifications.service.NotificationsService$Companion r2 = expo.modules.notifications.service.NotificationsService.Companion
                android.content.pm.ActivityInfo r2 = r2.findDesignatedBroadcastReceiver(r7, r1)
                if (r2 == 0) goto L_0x0040
                android.content.ComponentName r4 = new android.content.ComponentName
                java.lang.String r5 = r2.packageName
                java.lang.String r2 = r2.name
                r4.<init>(r5, r2)
                r1.setComponent(r4)
            L_0x0040:
                java.lang.String r2 = "type"
                r1.putExtra(r2, r3)
                r1.putExtra(r0, r8)
                android.content.ComponentName r8 = r1.getComponent()
                if (r8 == 0) goto L_0x0059
                java.lang.String r8 = r8.getClassName()
                if (r8 == 0) goto L_0x0059
                int r8 = r8.hashCode()
                goto L_0x005f
            L_0x0059:
                java.lang.Class<expo.modules.notifications.service.NotificationsService> r8 = expo.modules.notifications.service.NotificationsService.class
                int r8 = r8.hashCode()
            L_0x005f:
                r0 = 134217728(0x8000000, float:3.85186E-34)
                android.app.PendingIntent r7 = android.app.PendingIntent.getBroadcast(r7, r8, r1, r0)
                java.lang.String r8 = "PendingIntent.getBroadca…AG_UPDATE_CURRENT\n      )"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.NotificationsService.Companion.createNotificationTrigger(android.content.Context, java.lang.String):android.app.PendingIntent");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x006d, code lost:
            r7 = r7.getClassName();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.app.PendingIntent createNotificationResponseIntent(android.content.Context r6, Notification r7, NotificationAction r8) {
            /*
                r5 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "notification"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r1 = "action"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
                android.content.Intent r1 = new android.content.Intent
                r2 = r5
                expo.modules.notifications.service.NotificationsService$Companion r2 = (expo.modules.notifications.service.NotificationsService.Companion) r2
                android.net.Uri$Builder r2 = r2.getUriBuilder()
                expo.modules.notifications.notifications.model.NotificationRequest r3 = r7.getNotificationRequest()
                java.lang.String r4 = "notification.notificationRequest"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                java.lang.String r3 = r3.getIdentifier()
                android.net.Uri$Builder r2 = r2.appendPath(r3)
                java.lang.String r3 = "actions"
                android.net.Uri$Builder r2 = r2.appendPath(r3)
                java.lang.String r3 = r8.getIdentifier()
                android.net.Uri$Builder r2 = r2.appendPath(r3)
                android.net.Uri r2 = r2.build()
                java.lang.String r3 = "expo.modules.notifications.NOTIFICATION_EVENT"
                r1.<init>(r3, r2)
                expo.modules.notifications.service.NotificationsService$Companion r2 = expo.modules.notifications.service.NotificationsService.Companion
                android.content.pm.ActivityInfo r2 = r2.findDesignatedBroadcastReceiver(r6, r1)
                if (r2 == 0) goto L_0x0054
                android.content.ComponentName r3 = new android.content.ComponentName
                java.lang.String r4 = r2.packageName
                java.lang.String r2 = r2.name
                r3.<init>(r4, r2)
                r1.setComponent(r3)
            L_0x0054:
                java.lang.String r2 = "type"
                java.lang.String r3 = "receiveResponse"
                r1.putExtra(r2, r3)
                android.os.Parcelable r7 = (android.os.Parcelable) r7
                r1.putExtra(r0, r7)
                android.os.Parcelable r8 = (android.os.Parcelable) r8
                java.lang.String r7 = "notificationAction"
                r1.putExtra(r7, r8)
                android.content.ComponentName r7 = r1.getComponent()
                if (r7 == 0) goto L_0x0078
                java.lang.String r7 = r7.getClassName()
                if (r7 == 0) goto L_0x0078
                int r7 = r7.hashCode()
                goto L_0x007e
            L_0x0078:
                java.lang.Class<expo.modules.notifications.service.NotificationsService> r7 = expo.modules.notifications.service.NotificationsService.class
                int r7 = r7.hashCode()
            L_0x007e:
                r8 = 134217728(0x8000000, float:3.85186E-34)
                android.app.PendingIntent r6 = android.app.PendingIntent.getBroadcast(r6, r7, r1, r8)
                java.lang.String r7 = "PendingIntent.getBroadca…AG_UPDATE_CURRENT\n      )"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.NotificationsService.Companion.createNotificationResponseIntent(android.content.Context, expo.modules.notifications.notifications.model.Notification, expo.modules.notifications.notifications.model.NotificationAction):android.app.PendingIntent");
        }

        public final NotificationResponse getNotificationResponseFromIntent(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            byte[] byteArrayExtra = intent.getByteArrayExtra(NotificationsService.NOTIFICATION_RESPONSE_KEY);
            if (byteArrayExtra != null) {
                Companion companion = NotificationsService.Companion;
                Parcelable.Creator creator = NotificationResponse.CREATOR;
                Intrinsics.checkNotNullExpressionValue(creator, "NotificationResponse.CREATOR");
                return (NotificationResponse) companion.unmarshalObject(creator, byteArrayExtra);
            }
            byte[] byteArrayExtra2 = intent.getByteArrayExtra(NotificationsService.TEXT_INPUT_NOTIFICATION_RESPONSE_KEY);
            if (byteArrayExtra2 == null) {
                return null;
            }
            Companion companion2 = NotificationsService.Companion;
            Parcelable.Creator creator2 = TextInputNotificationResponse.CREATOR;
            Intrinsics.checkNotNullExpressionValue(creator2, "TextInputNotificationResponse.CREATOR");
            return (NotificationResponse) companion2.unmarshalObject(creator2, byteArrayExtra2);
        }

        public final void setNotificationResponseToIntent(Intent intent, NotificationResponse notificationResponse) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            String str = NotificationsService.NOTIFICATION_RESPONSE_KEY;
            Intrinsics.checkNotNullParameter(notificationResponse, str);
            try {
                if (notificationResponse instanceof TextInputNotificationResponse) {
                    str = NotificationsService.TEXT_INPUT_NOTIFICATION_RESPONSE_KEY;
                }
                Intrinsics.checkNotNullExpressionValue(intent.putExtra(str, marshalObject(notificationResponse)), "intent.putExtra(keyToPut…ct(notificationResponse))");
            } catch (Exception e) {
                Log.e("expo-notifications", "Could not marshal notification response: " + notificationResponse.getActionIdentifier() + FilenameUtils.EXTENSION_SEPARATOR);
                e.printStackTrace();
            }
        }

        private final byte[] marshalObject(Parcelable parcelable) {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            Intrinsics.checkNotNullExpressionValue(marshall, "parcel.marshall()");
            obtain.recycle();
            return marshall;
        }

        private final <T> T unmarshalObject(Parcelable.Creator<T> creator, byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                Parcel obtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                T createFromParcel = creator.createFromParcel(obtain);
                obtain.recycle();
                return createFromParcel;
            } catch (Exception e) {
                Log.e("expo-notifications", "Could not unmarshall NotificationResponse from Intent.extra.", e);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public PresentationDelegate getPresentationDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ExpoPresentationDelegate(context);
    }

    /* access modifiers changed from: protected */
    public HandlingDelegate getHandlingDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ExpoHandlingDelegate(context);
    }

    /* access modifiers changed from: protected */
    public CategoriesDelegate getCategoriesDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ExpoCategoriesDelegate(context);
    }

    /* access modifiers changed from: protected */
    public SchedulingDelegate getSchedulingDelegate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ExpoSchedulingDelegate(context);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new NotificationsService$onReceive$1(this, context, intent, goAsync()), 31, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x011f, code lost:
        r1.send(0, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            if (r7 == 0) goto L_0x001a
            java.util.List<java.lang.String> r0 = SETUP_ACTIONS
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.String r1 = r7.getAction()
            boolean r0 = kotlin.collections.CollectionsKt.contains(r0, r1)
            if (r0 == 0) goto L_0x001a
            r5.onSetupScheduledNotifications(r6, r7)
            goto L_0x017e
        L_0x001a:
            r0 = 0
            if (r7 == 0) goto L_0x0022
            java.lang.String r1 = r7.getAction()
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.String r2 = ". Ignoring."
            java.lang.String r3 = "expo.modules.notifications.NOTIFICATION_EVENT"
            if (r1 != r3) goto L_0x017f
            android.os.Bundle r1 = r7.getExtras()
            if (r1 == 0) goto L_0x0036
            java.lang.String r3 = "receiver"
            java.lang.Object r1 = r1.get(r3)
            goto L_0x0037
        L_0x0036:
            r1 = r0
        L_0x0037:
            boolean r3 = r1 instanceof android.os.ResultReceiver
            if (r3 != 0) goto L_0x003c
            r1 = r0
        L_0x003c:
            android.os.ResultReceiver r1 = (android.os.ResultReceiver) r1
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0140 }
            java.lang.String r3 = "type"
            java.lang.String r3 = r7.getStringExtra(r3)     // Catch:{ Exception -> 0x0140 }
            if (r3 == 0) goto L_0x0124
            int r4 = r3.hashCode()     // Catch:{ Exception -> 0x0140 }
            switch(r4) {
                case -2144315324: goto L_0x0112;
                case -2002465847: goto L_0x0105;
                case -1734918526: goto L_0x00f8;
                case -1326613834: goto L_0x00eb;
                case -1059891784: goto L_0x00df;
                case -697920873: goto L_0x00d3;
                case -577380539: goto L_0x00c7;
                case -402879681: goto L_0x00bb;
                case -318277445: goto L_0x00af;
                case -170315273: goto L_0x00a1;
                case 648465079: goto L_0x0094;
                case 998768146: goto L_0x0086;
                case 1082290915: goto L_0x0079;
                case 1282345597: goto L_0x006c;
                case 1925736384: goto L_0x005f;
                case 2039831424: goto L_0x0051;
                default: goto L_0x004f;
            }     // Catch:{ Exception -> 0x0140 }
        L_0x004f:
            goto L_0x0124
        L_0x0051:
            java.lang.String r0 = "setCategory"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onSetCategory(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x005f:
            java.lang.String r4 = "dropped"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onNotificationsDropped(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x006c:
            java.lang.String r4 = "removeAll"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onRemoveAllScheduledNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x0079:
            java.lang.String r4 = "receive"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onReceiveNotification(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x0086:
            java.lang.String r0 = "getCategories"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onGetCategories(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x0094:
            java.lang.String r4 = "dismissAll"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onDismissAllNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00a1:
            java.lang.String r0 = "getScheduled"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onGetScheduledNotification(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00af:
            java.lang.String r4 = "present"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onPresentNotification(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00bb:
            java.lang.String r4 = "removeSelected"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onRemoveScheduledNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00c7:
            java.lang.String r4 = "dismissSelected"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onDismissNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00d3:
            java.lang.String r4 = "schedule"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onScheduleNotification(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00df:
            java.lang.String r4 = "trigger"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onNotificationTriggered(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00eb:
            java.lang.String r0 = "getAllDisplayed"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onGetAllPresentedNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x00f8:
            java.lang.String r0 = "getAllScheduled"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onGetAllScheduledNotifications(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x0105:
            java.lang.String r0 = "deleteCategory"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0124
            android.os.Bundle r0 = r5.onDeleteCategory(r6, r7)     // Catch:{ Exception -> 0x0140 }
            goto L_0x011d
        L_0x0112:
            java.lang.String r4 = "receiveResponse"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x0124
            r5.onReceiveNotificationResponse(r6, r7)     // Catch:{ Exception -> 0x0140 }
        L_0x011d:
            if (r1 == 0) goto L_0x017e
            r6 = 0
            r1.send(r6, r0)     // Catch:{ Exception -> 0x0140 }
            goto L_0x017e
        L_0x0124:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0140 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0140 }
            r0.<init>()     // Catch:{ Exception -> 0x0140 }
            java.lang.String r4 = "Received event of unrecognized type: "
            r0.append(r4)     // Catch:{ Exception -> 0x0140 }
            r0.append(r3)     // Catch:{ Exception -> 0x0140 }
            r0.append(r2)     // Catch:{ Exception -> 0x0140 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0140 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0140 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x0140 }
            throw r6     // Catch:{ Exception -> 0x0140 }
        L_0x0140:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Action "
            r0.append(r2)
            java.lang.String r7 = r7.getAction()
            r0.append(r7)
            java.lang.String r7 = " failed: "
            r0.append(r7)
            java.lang.String r7 = r6.getMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "expo-notifications"
            android.util.Log.e(r0, r7)
            r6.printStackTrace()
            if (r1 == 0) goto L_0x017e
            r7 = 1
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r2 = "exception"
            r0.putSerializable(r2, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r1.send(r7, r0)
        L_0x017e:
            return
        L_0x017f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Received intent of unrecognized action: "
            r1.append(r3)
            if (r7 == 0) goto L_0x0191
            java.lang.String r0 = r7.getAction()
        L_0x0191:
            r1.append(r0)
            r1.append(r2)
            java.lang.String r7 = r1.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.NotificationsService.handleIntent(android.content.Context, android.content.Intent):void");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPresentNotification(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            expo.modules.notifications.service.interfaces.PresentationDelegate r4 = r3.getPresentationDelegate(r4)
            android.os.Bundle r0 = r5.getExtras()
            r1 = 0
            if (r0 == 0) goto L_0x001e
            java.lang.String r2 = "notification"
            android.os.Parcelable r0 = r0.getParcelable(r2)
            expo.modules.notifications.notifications.model.Notification r0 = (expo.modules.notifications.notifications.model.Notification) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L_0x0031
            java.lang.String r1 = "notificationBehavior"
            android.os.Parcelable r5 = r5.getParcelable(r1)
            r1 = r5
            expo.modules.notifications.notifications.model.NotificationBehavior r1 = (expo.modules.notifications.notifications.model.NotificationBehavior) r1
        L_0x0031:
            r4.presentNotification(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.NotificationsService.onPresentNotification(android.content.Context, android.content.Intent):void");
    }

    public Bundle onGetAllPresentedNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NOTIFICATIONS_KEY, new ArrayList(getPresentationDelegate(context).getAllPresentedNotifications()));
        return bundle;
    }

    public void onDismissNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        PresentationDelegate presentationDelegate = getPresentationDelegate(context);
        Bundle extras = intent.getExtras();
        String[] stringArray = extras != null ? extras.getStringArray(IDENTIFIERS_KEY) : null;
        Intrinsics.checkNotNull(stringArray);
        Intrinsics.checkNotNullExpressionValue(stringArray, "intent.extras?.getStringArray(IDENTIFIERS_KEY)!!");
        presentationDelegate.dismissNotifications(ArraysKt.asList((T[]) stringArray));
    }

    public void onDismissAllNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        getPresentationDelegate(context).dismissAllNotifications();
    }

    public void onReceiveNotification(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        HandlingDelegate handlingDelegate = getHandlingDelegate(context);
        Parcelable parcelableExtra = intent.getParcelableExtra(NOTIFICATION_KEY);
        Intrinsics.checkNotNull(parcelableExtra);
        handlingDelegate.handleNotification((Notification) parcelableExtra);
    }

    public void onReceiveNotificationResponse(Context context, Intent intent) {
        NotificationResponse notificationResponse;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Parcelable parcelableExtra = intent.getParcelableExtra(NOTIFICATION_KEY);
        Intrinsics.checkNotNull(parcelableExtra);
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtr…tion>(NOTIFICATION_KEY)!!");
        Notification notification = (Notification) parcelableExtra;
        Parcelable parcelableExtra2 = intent.getParcelableExtra(NOTIFICATION_ACTION_KEY);
        Intrinsics.checkNotNull(parcelableExtra2);
        Intrinsics.checkNotNullExpressionValue(parcelableExtra2, "intent.getParcelableExtr…OTIFICATION_ACTION_KEY)!!");
        NotificationAction notificationAction = (NotificationAction) parcelableExtra2;
        if (notificationAction instanceof TextInputNotificationAction) {
            notificationResponse = new TextInputNotificationResponse(notificationAction, notification, RemoteInput.getResultsFromIntent(intent).getString(USER_TEXT_RESPONSE_KEY));
        } else {
            notificationResponse = new NotificationResponse(notificationAction, notification);
        }
        getHandlingDelegate(context).handleNotificationResponse(notificationResponse);
    }

    public void onNotificationsDropped(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        getHandlingDelegate(context).handleNotificationsDropped();
    }

    public Bundle onGetCategories(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NOTIFICATION_CATEGORIES_KEY, new ArrayList(getCategoriesDelegate(context).getCategories()));
        return bundle;
    }

    public Bundle onSetCategory(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        CategoriesDelegate categoriesDelegate = getCategoriesDelegate(context);
        Parcelable parcelableExtra = intent.getParcelableExtra(NOTIFICATION_CATEGORY_KEY);
        Intrinsics.checkNotNull(parcelableExtra);
        bundle.putParcelable(NOTIFICATION_CATEGORY_KEY, categoriesDelegate.setCategory((NotificationCategory) parcelableExtra));
        return bundle;
    }

    public Bundle onDeleteCategory(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        CategoriesDelegate categoriesDelegate = getCategoriesDelegate(context);
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString(IDENTIFIER_KEY) : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "intent.extras?.getString(IDENTIFIER_KEY)!!");
        bundle.putBoolean(SUCCEEDED_KEY, categoriesDelegate.deleteCategory(string));
        return bundle;
    }

    public Bundle onGetAllScheduledNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NOTIFICATION_REQUESTS_KEY, new ArrayList(getSchedulingDelegate(context).getAllScheduledNotifications()));
        return bundle;
    }

    public Bundle onGetScheduledNotification(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        SchedulingDelegate schedulingDelegate = getSchedulingDelegate(context);
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString(IDENTIFIER_KEY) : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "intent.extras?.getString(IDENTIFIER_KEY)!!");
        bundle.putParcelable(NOTIFICATION_REQUEST_KEY, schedulingDelegate.getScheduledNotification(string));
        return bundle;
    }

    public void onScheduleNotification(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        SchedulingDelegate schedulingDelegate = getSchedulingDelegate(context);
        Bundle extras = intent.getExtras();
        NotificationRequest notificationRequest = extras != null ? (NotificationRequest) extras.getParcelable(NOTIFICATION_REQUEST_KEY) : null;
        Intrinsics.checkNotNull(notificationRequest);
        schedulingDelegate.scheduleNotification(notificationRequest);
    }

    public void onNotificationTriggered(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        SchedulingDelegate schedulingDelegate = getSchedulingDelegate(context);
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString(IDENTIFIER_KEY) : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "intent.extras?.getString(IDENTIFIER_KEY)!!");
        schedulingDelegate.triggerNotification(string);
    }

    public void onRemoveScheduledNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        SchedulingDelegate schedulingDelegate = getSchedulingDelegate(context);
        Bundle extras = intent.getExtras();
        String[] stringArray = extras != null ? extras.getStringArray(IDENTIFIERS_KEY) : null;
        Intrinsics.checkNotNull(stringArray);
        Intrinsics.checkNotNullExpressionValue(stringArray, "intent.extras?.getStringArray(IDENTIFIERS_KEY)!!");
        schedulingDelegate.removeScheduledNotifications(ArraysKt.asList((T[]) stringArray));
    }

    public void onRemoveAllScheduledNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        getSchedulingDelegate(context).removeAllScheduledNotifications();
    }

    public void onSetupScheduledNotifications(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        getSchedulingDelegate(context).setupScheduledNotifications();
    }
}
