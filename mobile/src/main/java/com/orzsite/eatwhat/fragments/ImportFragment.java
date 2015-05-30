package com.orzsite.eatwhat.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orzsite.eatwhat.R;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public class ImportFragment extends BaseFragment {

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_batch_import, container, false);
    }

    @Override
    protected void fillViews(View view) {

    }
}
