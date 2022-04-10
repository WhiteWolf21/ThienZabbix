package br.dev.kuhn.handyzabbix.graphs.pie_exploded;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PieExplodedViewPackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext) {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext) {
        return Arrays.asList(new ViewManager[] { (ViewManager)new PieExplodedViewManager() });
    }
}