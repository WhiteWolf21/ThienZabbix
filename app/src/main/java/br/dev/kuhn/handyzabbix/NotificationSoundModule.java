package br.dev.kuhn.handyzabbix;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Parcelable;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.PrintStream;
import br.dev.kuhn.handyzabbix.javax.annotation.Nonnull;

import br.dev.kuhn.handyzabbix.javax.annotation.Nonnull;

public class NotificationSoundModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "NotificationSoundModule";

    private static ReactApplicationContext reactContext;

    private final ActivityEventListener mActivityEventListener;

    public NotificationSoundModule(@Nonnull ReactApplicationContext paramReactApplicationContext) {
        super(paramReactApplicationContext);
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() {
            public void onActivityResult(Activity param1Activity, int param1Int1, int param1Int2, Intent param1Intent) {
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NotificationSound=Called this method");
                stringBuilder.append(param1Int2);
                stringBuilder.append("request code");
                stringBuilder.append(param1Int1);
                printStream.println(stringBuilder.toString());
                if (param1Int2 == -1 && param1Int1 == 5) {
                    Uri uri = (Uri)param1Intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                    if (uri != null) {
                        RingtoneManager.getDefaultUri(2);
                        PrintStream printStream1 = System.out;
                        StringBuilder stringBuilder1 = new StringBuilder();
                        stringBuilder1.append("NotificationSound=");
                        stringBuilder1.append(uri.toString());
                        printStream1.println(stringBuilder1.toString());
                    } else {
                        System.out.println("NotificationSound=CANCELPRESS");
                    }
                }
            }
        };
        this.mActivityEventListener = (ActivityEventListener)baseActivityEventListener;
        paramReactApplicationContext.addActivityEventListener((ActivityEventListener)baseActivityEventListener);
        reactContext = paramReactApplicationContext;
    }

    @Nonnull
    public String getName() {
        return "NotificationSoundModule";
    }

    @ReactMethod
    public void getSoundList(Promise paramPromise) {
        Activity activity = getCurrentActivity();
        NotificationManager notificationManager = (NotificationManager)activity.getSystemService(NotificationManager.class);
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        intent.putExtra("android.intent.extra.ringtone.TITLE", "Select Tone");
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", (Parcelable)null);
        activity.startActivityForResult(intent, 5);
    }
}
