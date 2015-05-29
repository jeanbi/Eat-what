package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.fragments.ImportFragment;

/**
 * Created by Jimmy on 15/5/29.
 */
public class BatchImportActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        ImportFragment fragment = new ImportFragment();
        replaceFragment(fragment);
    }
}
