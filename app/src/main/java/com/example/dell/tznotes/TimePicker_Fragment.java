package com.example.dell.tznotes;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class TimePicker_Fragment extends DialogFragment {
    Calendar calendar=Calendar.getInstance();
    int hours=calendar.get(Calendar.HOUR_OF_DAY);
    int minutes=calendar.get(Calendar.MINUTE);
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener) getActivity(),hours,minutes,android.text.format.DateFormat.is24HourFormat(getActivity()));

    }
}
