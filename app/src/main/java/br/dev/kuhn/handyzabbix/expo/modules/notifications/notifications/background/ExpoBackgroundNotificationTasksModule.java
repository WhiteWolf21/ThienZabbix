package br.dev.kuhn.handyzabbix.expo.modules.notifications.notifications.background;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import java.util.Collections;
import org.unimodules.interfaces.taskManager.TaskManagerInterface;

public class ExpoBackgroundNotificationTasksModule extends ExportedModule {
    private TaskManagerInterface mTaskManager;

    public String getName() {
        return "ExpoBackgroundNotificationTasksModule";
    }

    public ExpoBackgroundNotificationTasksModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mTaskManager = (TaskManagerInterface) moduleRegistry.getModule(TaskManagerInterface.class);
    }

    @ExpoMethod
    public void registerTaskAsync(String str, Promise promise) {
        try {
            this.mTaskManager.registerTask(str, BackgroundRemoteNotificationTaskConsumer.class, Collections.emptyMap());
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void unregisterTaskAsync(String str, Promise promise) {
        try {
            this.mTaskManager.unregisterTask(str, BackgroundRemoteNotificationTaskConsumer.class);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
