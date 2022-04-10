package br.dev.kuhn.handyzabbix.expo.modules.notifications.service.interfaces;

import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.model.NotificationCategory;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(mo24972bv = {1, 0, 3}, mo24973d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, mo24974d2 = {"Lexpo/modules/notifications/service/interfaces/CategoriesDelegate;", "", "deleteCategory", "", "identifier", "", "getCategories", "", "Lexpo/modules/notifications/notifications/model/NotificationCategory;", "setCategory", "category", "expo-notifications_release"}, mo24975k = 1, mo24976mv = {1, 4, 1})
/* compiled from: CategoriesDelegate.kt */
public interface CategoriesDelegate {
    boolean deleteCategory(String str);

    Collection<NotificationCategory> getCategories();

    NotificationCategory setCategory(NotificationCategory notificationCategory);
}
