package com.facebook.react.devsupport;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.react.C0873R;

public class DevSettingsActivity extends PreferenceActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getApplication().getResources().getString(C0873R.string.catalyst_settings_title));
        addPreferencesFromResource(C0873R.xml.rn_dev_preferences);
    }
}
