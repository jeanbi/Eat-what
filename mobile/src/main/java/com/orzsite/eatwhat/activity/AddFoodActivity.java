package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.fragments.AddFoodFragment;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public class AddFoodActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AddFoodFragment fragment = new AddFoodFragment();
        replaceFragment(fragment);
    }
}
