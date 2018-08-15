package com.example.dell.tznotes;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class AlertDialogClass extends AppCompatActivity {
    AlertDialog.Builder mAlertDlgBuilder;
    AlertDialog mAlertDialog;
    View mDialogView = null;
    Button mOKBtn, mCancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = getLayoutInflater();

        // Build the dialog
        mAlertDlgBuilder = new AlertDialog.Builder(this);
        mDialogView = inflater.inflate(R.layout.activity_alert_dialog_class, null);
        mOKBtn = (Button)mDialogView.findViewById(R.id.ID_Ok);
        mCancelBtn = (Button)mDialogView.findViewById(R.id.ID_Cancel);
        mOKBtn.setOnClickListener(mDialogbuttonClickListener);
        mCancelBtn.setOnClickListener(mDialogbuttonClickListener);
        mAlertDlgBuilder.setCancelable(false);
        mAlertDlgBuilder.setInverseBackgroundForced(true);
        mAlertDlgBuilder.setView(mDialogView);
        mAlertDialog = mAlertDlgBuilder.create();
        mAlertDialog.show();

    }
    View.OnClickListener mDialogbuttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ID_Ok)
            {
                mAlertDialog.dismiss();
                finish();
            }
            else if(v.getId() == R.id.ID_Cancel)
            {
                mAlertDialog.dismiss();
                finish();
            }
        }
    };
}