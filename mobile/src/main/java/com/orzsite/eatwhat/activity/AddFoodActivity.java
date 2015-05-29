package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.fragments.AddFoodFragment;

/**
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
