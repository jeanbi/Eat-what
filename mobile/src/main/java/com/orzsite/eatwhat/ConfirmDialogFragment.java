package com.orzsite.eatwhat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jimmy on 15/5/29.
 */
public class ConfirmDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.fragment_confirm_dialog, null);

        TextView title = (TextView) dialogView.findViewById(R.id.dialog_title);
        TextView content = (TextView) dialogView.findViewById(R.id.dialog_content);

        title.setText(R.string.confirm_title);
        content.setText(R.string.changed);
        dialog.setView(dialogView);
        dialog.setPositiveButton(R.string.btn_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (closeListener != null) {
                    closeListener.onClose();
                }
                dismiss();
            }
        }).setNegativeButton(R.string.btn_canel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return dialog.create();
    }

    public static interface OnDialogCloseListener {
        void onClose();
    }

    private OnDialogCloseListener closeListener;
    public void setOnDialogCloseListener(OnDialogCloseListener closeListener) {
        this.closeListener = closeListener;
    }
}
