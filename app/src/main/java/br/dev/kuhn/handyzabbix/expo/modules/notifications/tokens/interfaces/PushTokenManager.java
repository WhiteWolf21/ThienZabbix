package br.dev.kuhn.handyzabbix.expo.modules.notifications.tokens.interfaces;

public interface PushTokenManager {
    void addListener(PushTokenListener pushTokenListener);

    void removeListener(PushTokenListener pushTokenListener);
}
