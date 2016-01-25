package com.vanniktech.vntnumberpickerpreference.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class VNTNumberPickerPreferenceApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
