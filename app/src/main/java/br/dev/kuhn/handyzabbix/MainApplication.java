package br.dev.kuhn.handyzabbix;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import br.dev.kuhn.handyzabbix.graphs.GraphViewPackage;
import br.dev.kuhn.handyzabbix.graphs.pie_exploded.PieExplodedViewPackage;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.ReanimatedJSIModulePackage;
import expo.modules.ApplicationLifecycleDispatcher;
import expo.modules.ReactNativeHostWrapper;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {
    private final ReactNativeHost mReactNativeHost = (ReactNativeHost)new ReactNativeHostWrapper(this, new ReactNativeHost(this) {
        protected JSIModulePackage getJSIModulePackage() {
            return (JSIModulePackage)new ReanimatedJSIModulePackage();
        }

        protected String getJSMainModuleName() {
            return "index";
        }

        protected List<ReactPackage> getPackages() {
            ArrayList<BatteryOptimizationPackage> arrayList = (new PackageList(this)).getPackages();
            arrayList.add(new BatteryOptimizationPackage());
            arrayList.add(new NotificationTaskPackage());
            arrayList.add(new GraphViewPackage());
            arrayList.add(new PieExplodedViewPackage());
            return (List)arrayList;
        }

        public boolean getUseDeveloperSupport() {
            return false;
        }
    });

    private static void initializeFlipper(Context paramContext, ReactInstanceManager paramReactInstanceManager) {}

    public ReactNativeHost getReactNativeHost() {
        return this.mReactNativeHost;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        ApplicationLifecycleDispatcher.onConfigurationChanged(this, paramConfiguration);
    }

    public void onCreate() {
        super.onCreate();
        SoLoader.init((Context)this, false);
        initializeFlipper((Context)this, getReactNativeHost().getReactInstanceManager());
        ApplicationLifecycleDispatcher.onApplicationCreate(this);
    }
}
