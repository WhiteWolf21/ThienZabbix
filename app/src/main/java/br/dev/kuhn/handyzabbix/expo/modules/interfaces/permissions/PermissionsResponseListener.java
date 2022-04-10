package br.dev.kuhn.handyzabbix.expo.modules.interfaces.permissions;

import java.util.Map;

@FunctionalInterface
public interface PermissionsResponseListener {
    void onResult(Map<String, PermissionsResponse> map);
}
