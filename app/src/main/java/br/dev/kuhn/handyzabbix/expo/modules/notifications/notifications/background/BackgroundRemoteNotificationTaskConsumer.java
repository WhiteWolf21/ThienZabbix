package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.background;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.service.delegates.FirebaseMessagingDelegate;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.unimodules.interfaces.taskManager.TaskConsumer;
import org.unimodules.interfaces.taskManager.TaskConsumerInterface;
import org.unimodules.interfaces.taskManager.TaskExecutionCallback;
import org.unimodules.interfaces.taskManager.TaskInterface;
import org.unimodules.interfaces.taskManager.TaskManagerUtilsInterface;

public class BackgroundRemoteNotificationTaskConsumer extends TaskConsumer implements TaskConsumerInterface {
    private static final String NOTIFICATION_KEY = "notification";
    private static final String TAG = "BackgroundRemoteNotificationTaskConsumer";
    private TaskInterface mTask;

    public String taskType() {
        return "remote-notification";
    }

    public BackgroundRemoteNotificationTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        FirebaseMessagingDelegate.Companion.addBackgroundTaskConsumer(this);
    }

    public void didRegister(TaskInterface taskInterface) {
        this.mTask = taskInterface;
    }

    public void didUnregister() {
        this.mTask = null;
    }

    public void scheduleJob(Bundle bundle) {
        Context context = getContext();
        boolean isAtLeast = ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
        if (context != null && this.mTask != null && !isAtLeast) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("notification", bundleToJson(bundle).toString());
            getTaskManagerUtils().scheduleJob(context, this.mTask, Collections.singletonList(persistableBundle));
        }
    }

    public boolean didExecuteJob(final JobService jobService, final JobParameters jobParameters) {
        if (this.mTask == null) {
            return false;
        }
        for (PersistableBundle string : getTaskManagerUtils().extractDataFromJobParams(jobParameters)) {
            Bundle bundle = new Bundle();
            bundle.putBundle("notification", jsonStringToBundle(string.getString("notification")));
            this.mTask.execute(bundle, (Error) null, new TaskExecutionCallback() {
                public void onFinished(Map<String, Object> map) {
                    jobService.jobFinished(jobParameters, false);
                }
            });
        }
        return true;
    }

    private static JSONObject bundleToJson(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                if (bundle.get(str) instanceof Bundle) {
                    jSONObject.put(str, bundleToJson((Bundle) bundle.get(str)));
                } else {
                    jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
                }
            } catch (JSONException e) {
                Log.e("expo-notifications", "Could not create JSON object from notification bundle. " + e.getMessage());
            }
        }
        return jSONObject;
    }

    private static Bundle jsonStringToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            return NotificationSerializer.toBundle(new JSONObject(str));
        } catch (JSONException e) {
            Log.e("expo-notifications", "Could not parse notification from JSON string. " + e.getMessage());
            return bundle;
        }
    }
}
