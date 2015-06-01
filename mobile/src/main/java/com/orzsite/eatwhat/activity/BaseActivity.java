package com.orzsite.eatwhat.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.orzsite.eatwhat.MyApplication;
import com.orzsite.eatwhat.R;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/28.
 */
public class BaseActivity extends AppCompatActivity {
    protected Context context = this;
    private FrameLayout container;
    private Toolbar toolbar;
    private Fragment _fragment = null;

    protected MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        application = (MyApplication) getApplication();

        container = (FrameLayout) findViewById(R.id.container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            setHomeUpEnabled(true);
        }

    }

    /**
     * HomeUpButton of toolbar status.
     *
     * @param enable
     */
    protected void setHomeUpEnabled(boolean enable) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
    }

    /**
     * 设置界面的标题
     *
     * @param resourceId
     */
    protected void setPageTitle(int resourceId) {
        getSupportActionBar().setTitle(resourceId);
    }

    /**
     * 将界面的内容替换成fragment
     *
     * @param fragment
     */
    protected void replaceFragment(Fragment fragment) {
        container.removeAllViews();
        FragmentManager manager = getSupportFragmentManager();
        if (_fragment == null) {
            manager.beginTransaction().add(R.id.container, fragment).commit();
        } else {
            manager.beginTransaction().replace(R.id.container, fragment).commit();
        }

        _fragment = fragment;
    }

    /**
     * The default up button action handler.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
