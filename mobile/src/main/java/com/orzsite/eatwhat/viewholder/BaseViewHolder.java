package com.orzsite.eatwhat.viewholder;

import android.view.View;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public abstract class BaseViewHolder {

    private View base;
    public BaseViewHolder(View view) {
        base = view;
    }

    public View getViewById(int resourceId) {
        return base.findViewById(resourceId);
    }
}
