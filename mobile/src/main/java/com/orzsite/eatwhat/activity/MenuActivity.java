package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.fragments.MenuFragment;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
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
