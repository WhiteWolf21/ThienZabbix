package br.dev.kuhn.handyzabbix.expo.modules.adapters.react.services;

import com.facebook.react.modules.systeminfo.ReactNativeVersion;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.RuntimeEnvironmentInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RuntimeEnvironmentModule implements InternalModule, RuntimeEnvironmentInterface {
    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    public String platformName() {
        return "React Native";
    }

    public List<? extends Class> getExportedInterfaces() {
        return Collections.singletonList(RuntimeEnvironmentInterface.class);
    }

    public RuntimeEnvironmentInterface.PlatformVersion platformVersion() {
        final Map<String, Object> map = ReactNativeVersion.VERSION;
        return new RuntimeEnvironmentInterface.PlatformVersion() {
            public int major() {
                return ((Integer) map.get("major")).intValue();
            }

            public int minor() {
                return ((Integer) map.get("minor")).intValue();
            }

            public int patch() {
                return ((Integer) map.get("patch")).intValue();
            }

            public String prerelease() {
                return (String) map.get("prerelease");
            }
        };
    }
}
