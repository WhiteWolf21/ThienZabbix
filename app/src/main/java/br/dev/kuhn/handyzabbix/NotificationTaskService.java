package br.dev.kuhn.handyzabbix;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.react.HeadlessJsTaskService;

public class NotificationTaskService extends Service {
    private void Task() {
        startService(new Intent((Context)this, NotificationTaskHeadlessJs.class));
        HeadlessJsTaskService.acquireWakeLockNow((Context)this);
    }

    public IBinder onBind(Intent paramIntent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        Task();
        return Service.START_NOT_STICKY;
    }
}
