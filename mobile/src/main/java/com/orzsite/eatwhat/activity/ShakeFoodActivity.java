package com.orzsite.eatwhat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.fragments.ShakeFragment;


public class ShakeFoodActivity extends BaseActivity {

    private boolean willExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            return;
        }

        ShakeFragment fragment = new ShakeFragment();
        replaceFragment(fragment);

        setHomeUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shake_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent intent = null;

        if (id == R.id.action_settings) {
            intent = new Intent(context, SettingsActivity.class);
        } else if (id == R.id.action_menu) {
            intent = new Intent(context, MenuActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (willExit) {
                finish();
            } else {
                Toast.makeText(context, R.string.confirm_exit, Toast.LENGTH_SHORT).show();
                willExit = true;
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
