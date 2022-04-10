package br.dev.kuhn.handyzabbix;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotificationTaskPackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext) {
        return Arrays.asList(new NativeModule[] { (NativeModule)new NotificationTaskModule(paramReactApplicationContext) });
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext) {
        return Collections.emptyList();
    }
}
