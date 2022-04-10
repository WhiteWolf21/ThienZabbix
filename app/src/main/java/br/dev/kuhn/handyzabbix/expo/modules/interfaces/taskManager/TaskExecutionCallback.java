package br.dev.kuhn.handyzabbix.expo.modules.interfaces.taskManager;

import java.util.Map;

public interface TaskExecutionCallback {
    void onFinished(Map<String, Object> map);
}
