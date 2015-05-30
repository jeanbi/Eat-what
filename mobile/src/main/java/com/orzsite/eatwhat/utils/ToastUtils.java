package com.orzsite.eatwhat.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class ToastUtils {

    public static void showToast(Context context, int source) {
        Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
