package br.dev.kuhn.handyzabbix.expo.modules.core.interfaces;

public interface Consumer<T> {
    void apply(T t);
}
