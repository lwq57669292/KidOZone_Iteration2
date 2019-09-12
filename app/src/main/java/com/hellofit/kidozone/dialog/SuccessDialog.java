package com.hellofit.kidozone.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.hellofit.kidozone.R;


public class SuccessDialog extends DialogFragment {

    public OnButtonClickListener buttonClickListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Success!");
        return builder.create();

    }

    public void addButtonClickListener(OnButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    public interface OnButtonClickListener {
    }
}
