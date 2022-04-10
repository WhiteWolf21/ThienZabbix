package br.dev.kuhn.handyzabbix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationTaskReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 65556;

    public void onReceive(Context paramContext, Intent paramIntent) {
        paramContext.startService(new Intent(paramContext, NotificationTaskService.class));
    }
}
