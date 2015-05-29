package com.orzsite.eatwhat.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.orzsite.eatwhat.R;

/**
 * Created by Jimmy on 15/5/28.
 */
public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_setting_pref);
    }
}
