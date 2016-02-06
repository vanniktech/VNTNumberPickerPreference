package com.vanniktech.vntnumberpickerpreference.sample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    public static Intent start(final Activity activity) {
        return new Intent(activity, SettingsActivity.class);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.frame_layout);
        this.getFragmentManager().beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener {
        private Preference preferenceCallback;
        private Preference preferenceCustomSummary;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            this.addPreferencesFromResource(R.xml.preferences);

            preferenceCallback = this.findPreference("preference_callback");
            preferenceCallback.setOnPreferenceChangeListener(this);

            preferenceCustomSummary = this.findPreference("preference_custom_summary");
            this.getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public boolean onPreferenceChange(final Preference preference, final Object newValue) {
            if (preference.equals(preferenceCallback)) {
                final int value = (int) newValue;
                Toast.makeText(getActivity(), "New value is " + value, Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        }

        @Override
        public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String key) {
            if (preferenceCustomSummary != null && key.equals(preferenceCustomSummary.getKey())) {
                final int value = sharedPreferences.getInt(key, 0);
                preferenceCustomSummary.setSummary("My custom summary text. Value is " + value);
            }
        }
    }
}
