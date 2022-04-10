package br.dev.kuhn.handyzabbix;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBootBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            char c2;
            PendingIntent pendingIntent = PendingIntent.getBroadcast(paramContext, 65556, new Intent(paramContext, NotificationTaskReceiver.class), 134217728);
            char c1 = '_';
            try {
                c2 = (char) paramIntent.getIntExtra("taskInterval", 60000);
            } catch (Exception exception) {
                c2 = c1;
            }
            long l = System.currentTimeMillis();
            ((AlarmManager)paramContext.getSystemService(Context.ALARM_SERVICE)).setInexactRepeating(AlarmManager.ELAPSED_REALTIME, l, c2, pendingIntent);
        }
    }
}
