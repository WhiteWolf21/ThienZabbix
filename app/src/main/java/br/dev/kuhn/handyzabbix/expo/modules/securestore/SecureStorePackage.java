package br.dev.kuhn.handyzabbix.expo.modules.securestore;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.ExportedModule;
import java.util.Collections;
import java.util.List;

public class SecureStorePackage extends BasePackage {
    public List<ExportedModule> createExportedModules(Context context) {
        return Collections.singletonList(new SecureStoreModule(context));
    }
}
