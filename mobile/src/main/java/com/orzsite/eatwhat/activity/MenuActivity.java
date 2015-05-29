package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.fragments.MenuFragment;

/**
 * Created by Jimmy on 15/5/29.
 */
public class MenuActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            return;
        }

        setPageTitle(R.string.action_menu);

        MenuFragment fragment = new MenuFragment();
        replaceFragment(fragment);
    }
}
