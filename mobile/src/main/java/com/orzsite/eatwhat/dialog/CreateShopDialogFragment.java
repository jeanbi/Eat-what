package com.orzsite.eatwhat.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.bean.Shop;
import com.orzsite.eatwhat.dao.DbHelper;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class CreateShopDialogFragment extends DialogFragment {

    private EditText etShopName;
    private OnPositiveButtonClickListener buttonClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_create_shop_dialog, null);

        etShopName = (EditText) view.findViewById(R.id.tv_shop_name);
        builder.setView(view);
        builder.setPositiveButton(R.string.positive_button_for_create_shop, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DbHelper helper = new DbHelper(getActivity());

                Shop shop = new Shop();
                shop.setName(etShopName.getText().toString());
                Shop newShop = helper.saveShop(shop);
                if (newShop != null && buttonClickListener != null) {
                    buttonClickListener.onDaoSuccess(newShop);
                }
                dismiss();
            }
        }).setNegativeButton(R.string.negative_button_for_create_shop, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return builder.create();
    }

    public void setOnPositiveButtonClickListener(OnPositiveButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public static interface OnPositiveButtonClickListener {
        void onDaoSuccess(Shop newShop);
    }
}
