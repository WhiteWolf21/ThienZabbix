package br.dev.kuhn.handyzabbix.expo.modules.interfaces.barcodescanner;

import android.content.Context;

public interface BarCodeScannerProviderInterface {
    BarCodeScannerInterface createBarCodeDetectorWithContext(Context context);
}
