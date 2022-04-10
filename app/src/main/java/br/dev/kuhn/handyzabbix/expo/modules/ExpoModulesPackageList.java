package br.dev.kuhn.handyzabbix.expo.modules;

import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.adapters.reanimated.EXReanimatedPackage;
import expo.modules.application.ApplicationPackage;
import expo.modules.constants.ConstantsPackage;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.errorrecovery.ErrorRecoveryPackage;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderPackage;
import expo.modules.keepawake.KeepAwakePackage;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.modules.Module;
import expo.modules.notifications.NotificationsPackage;
import expo.modules.securestore.SecureStorePackage;
import expo.modules.splashscreen.SplashScreenPackage;
import java.util.Arrays;
import java.util.List;

public class ExpoModulesPackageList implements ModulesProvider {

    private static class LazyHolder {
        static final List<Class<? extends Module>> modulesList = Arrays.asList(new Class[0]);
        static final List<Package> packagesList = Arrays.asList(new Package[]{new ReactAdapterPackage(), new EXReanimatedPackage(), new ApplicationPackage(), new ConstantsPackage(), new BasePackage(), new ErrorRecoveryPackage(), new FileSystemPackage(), new FontLoaderPackage(), new KeepAwakePackage(), new NotificationsPackage(), new SecureStorePackage(), new SplashScreenPackage()});

        private LazyHolder() {
        }
    }

    public static List<Package> getPackageList() {
        return LazyHolder.packagesList;
    }

    public List<Class<? extends Module>> getModulesList() {
        return LazyHolder.modulesList;
    }
}
