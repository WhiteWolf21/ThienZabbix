package br.dev.kuhn.handyzabbix.graphs;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.dev.kuhn.handyzabbix.graphs.GraphViewManager;

public class GraphViewPackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext) {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext) {
        return Arrays.asList(new ViewManager[] { (ViewManager)new GraphViewManager() });
    }
}
