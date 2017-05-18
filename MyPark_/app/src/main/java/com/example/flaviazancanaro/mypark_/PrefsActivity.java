package com.example.flaviazancanaro.mypark_;

/**
 * Created by flaviazancanaro on 11/5/17.
 */

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.flaviazancanaro.mypark_.R;


public class PrefsActivity extends AppCompatActivity {

    private static final String TAG = "PrefsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.prefs_content, new SettingsFragment())
                .commit();

    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
    }


}


