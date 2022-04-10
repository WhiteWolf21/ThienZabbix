package br.dev.kuhn.handyzabbix;

import android.content.Context;
import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import expo.modules.ReactActivityDelegateWrapper;

public class MainActivity extends ReactActivity {
    protected ReactActivityDelegate createReactActivityDelegate() {
        return (ReactActivityDelegate)new ReactActivityDelegateWrapper(this, new ReactActivityDelegate(this, getMainComponentName()) {
            protected ReactRootView createRootView() {
                return (ReactRootView)new RNGestureHandlerEnabledRootView((Context)MainActivity.this);
            }
        });
    }

    protected String getMainComponentName() {
        return "main";
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(null);
    }
}
