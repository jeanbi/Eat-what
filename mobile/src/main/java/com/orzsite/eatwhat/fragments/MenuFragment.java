package com.orzsite.eatwhat.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orzsite.eatwhat.R;

/**
 * Created by Jimmy on 15/5/29.
 */
public class MenuFragment extends BaseFragment {
    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    protected void fillViews(View view) {

    }
}
