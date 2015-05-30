package com.orzsite.eatwhat.activity;

import android.os.Bundle;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.fragments.ImportFragment;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
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
