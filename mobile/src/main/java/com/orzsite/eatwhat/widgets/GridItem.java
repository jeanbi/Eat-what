package com.orzsite.eatwhat.widgets;
/**
 * @copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * @license: GNU General Public License 2.0
 * @date: 2015-06-01
 */

import android.content.Context;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/6/1.
 */
public class GridItem extends RelativeLayout implements Checkable {

    public GridItem(Context context) {
        super(context);
    }

    @Override
    public void setChecked(boolean checked) {

    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {

    }
}
