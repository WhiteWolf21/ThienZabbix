package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.categories;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.MapArguments;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.notifications.notifications.categories.serializers.NotificationsCategoriesSerializer;
import expo.modules.notifications.notifications.model.NotificationAction;
import expo.modules.notifications.notifications.model.NotificationCategory;
import expo.modules.notifications.notifications.model.TextInputNotificationAction;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ExpoNotificationCategoriesModule extends ExportedModule {
    private static final String BUTTON_TITLE_KEY = "buttonTitle";
    private static final String EXPORTED_NAME = "ExpoNotificationCategoriesModule";
    private static final String IDENTIFIER_KEY = "identifier";
    private static final String OPENS_APP_TO_FOREGROUND_KEY = "opensAppToForeground";
    private static final String OPTIONS_KEY = "options";
    private static final String PLACEHOLDER_KEY = "placeholder";
    private static final String TEXT_INPUT_OPTIONS_KEY = "textInput";
    protected NotificationsCategoriesSerializer mSerializer;

    public String getName() {
        return EXPORTED_NAME;
    }

    public ExpoNotificationCategoriesModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mSerializer = (NotificationsCategoriesSerializer) moduleRegistry.getModule(NotificationsCategoriesSerializer.class);
    }

    @ExpoMethod
    public void getNotificationCategoriesAsync(final Promise promise) {
        NotificationsService.Companion.getCategories(getContext(), new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(NotificationsService.NOTIFICATION_CATEGORIES_KEY);
                if (i != 0 || parcelableArrayList == null) {
                    promise.reject("ERR_CATEGORIES_FETCH_FAILED", "A list of notification categories could not be fetched.");
                } else {
                    promise.resolve(ExpoNotificationCategoriesModule.this.serializeCategories(parcelableArrayList));
                }
            }
        });
    }

    @ExpoMethod
    public void setNotificationCategoryAsync(String str, List<HashMap<String, Object>> list, HashMap<String, Object> hashMap, final Promise promise) {
        ArrayList arrayList = new ArrayList();
        for (HashMap<String, Object> mapArguments : list) {
            MapArguments mapArguments2 = new MapArguments(mapArguments);
            MapArguments mapArguments3 = new MapArguments(mapArguments2.getMap(OPTIONS_KEY, Collections.emptyMap()));
            MapArguments mapArguments4 = mapArguments2.containsKey(TEXT_INPUT_OPTIONS_KEY) ? new MapArguments(mapArguments2.getMap(TEXT_INPUT_OPTIONS_KEY)) : null;
            if (mapArguments4 != null) {
                arrayList.add(new TextInputNotificationAction(mapArguments2.getString("identifier", (String) null), mapArguments2.getString(BUTTON_TITLE_KEY, (String) null), mapArguments3.getBoolean(OPENS_APP_TO_FOREGROUND_KEY, true), mapArguments4.getString("placeholder", (String) null)));
            } else {
                arrayList.add(new NotificationAction(mapArguments2.getString("identifier", (String) null), mapArguments2.getString(BUTTON_TITLE_KEY, (String) null), mapArguments3.getBoolean(OPENS_APP_TO_FOREGROUND_KEY, true)));
            }
        }
        if (!arrayList.isEmpty()) {
            NotificationsService.Companion.setCategory(getContext(), new NotificationCategory(str, (List<NotificationAction>) arrayList), new ResultReceiver((Handler) null) {
                /* access modifiers changed from: protected */
                public void onReceiveResult(int i, Bundle bundle) {
                    NotificationCategory notificationCategory = (NotificationCategory) bundle.getParcelable(NotificationsService.NOTIFICATION_CATEGORY_KEY);
                    if (i != 0 || notificationCategory == null) {
                        promise.reject("ERR_CATEGORY_SET_FAILED", "The provided category could not be set.");
                    } else {
                        promise.resolve(ExpoNotificationCategoriesModule.this.mSerializer.toBundle(notificationCategory));
                    }
                }
            });
            return;
        }
        throw new InvalidArgumentException("Invalid arguments provided for notification category. Must provide at least one action.");
    }

    @ExpoMethod
    public void deleteNotificationCategoryAsync(String str, final Promise promise) {
        NotificationsService.Companion.deleteCategory(getContext(), str, new ResultReceiver((Handler) null) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                if (i == 0) {
                    promise.resolve(Boolean.valueOf(bundle.getBoolean(NotificationsService.SUCCEEDED_KEY)));
                } else {
                    promise.reject("ERR_CATEGORY_DELETE_FAILED", "The category could not be deleted.");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public ArrayList<Bundle> serializeCategories(Collection<NotificationCategory> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (NotificationCategory bundle : collection) {
            arrayList.add(this.mSerializer.toBundle(bundle));
        }
        return arrayList;
    }
}
