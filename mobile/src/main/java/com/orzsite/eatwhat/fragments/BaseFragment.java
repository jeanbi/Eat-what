package com.orzsite.eatwhat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initFragment(inflater, container);
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        fillViews(view);
    }

    /**
     * Initialize the fragment when it entered stacks
     * @param inflater
     * @param container
     * @return
     */
    protected abstract View initFragment(LayoutInflater inflater, ViewGroup container);

    /**
     * When fragment were initialized, it could be activated.
     * @param view
     */
    protected abstract void fillViews(View view);
}
