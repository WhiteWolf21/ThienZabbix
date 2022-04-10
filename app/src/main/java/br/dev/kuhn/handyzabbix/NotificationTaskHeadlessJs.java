package br.dev.kuhn.handyzabbix;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

public class NotificationTaskHeadlessJs extends HeadlessJsTaskService {
    protected HeadlessJsTaskConfig getTaskConfig(Intent paramIntent) {
        WritableMap writableMap;
        Bundle bundle = paramIntent.getExtras();
        if (bundle != null) {
            writableMap = Arguments.fromBundle(bundle);
        } else {
            writableMap = Arguments.createMap();
        }
        return new HeadlessJsTaskConfig("HandyZabbixNotificationTaskHeadlessJs", writableMap, 5000L, true);
    }
}
