package com.example.dell.tznotes;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.AlarmReceiverController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

//    TimePicker timePicker;
    ArrayList<PendingIntent> intentArray;
    public static int i;
    long alarm_time;
    ImageView mTimebtn,mDatebtn;
    DatePickerDialog mDatePickerDialog;
    Calendar mCalender;
    Button mAlarmBtn;
    Calendar calendar;
    int mDay,mMonth,mYear,mHour,mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alarm);

        mTimebtn=(ImageView) findViewById(R.id.timeimage_id);
        mDatebtn=(ImageView) findViewById(R.id.dateimage_id);
        mAlarmBtn=(Button) findViewById(R.id.setalarm_btn_id);

        calendar = Calendar.getInstance();
        mYear=calendar.get(Calendar.YEAR);
        mMonth=calendar.get(Calendar.MONTH);
        mDay=calendar.get(Calendar.DAY_OF_MONTH);


        mTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment timepicker=new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"time picker");

            }
        });
        mDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Alarm.this, "Select Date", Toast.LENGTH_SHORT).show();
                mCalender = Calendar.getInstance();
                int day = mCalender.get(Calendar.DAY_OF_MONTH);
                int month = mCalender.get(Calendar.MONTH);
                int year = mCalender.get(Calendar.YEAR);

                mDatePickerDialog = new DatePickerDialog(Alarm.this,
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int imYear, int imMonth, int imDay) {
                        TextView date = (TextView) findViewById(R.id.date_txt_id);
                        date.setText(imDay + "/" + (imMonth + 1) + "/" + imYear);

                        mDay=imDay;
                        mMonth=imMonth;
                        mYear=imYear;

                    }
                }, day, month, year);

                mDatePickerDialog.show();
            }
        });

        mAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                calendar.set(calendar.get(Calendar.YEAR),
//                        calendar.get(Calendar.MONTH),
//                        calendar.get(Calendar.DAY_OF_MONTH),
//                        mHour, mMinute, 0);

                if (mHour!=0 && mMinute!=0) {
                    GregorianCalendar calendar = new GregorianCalendar(mYear, mMonth, mDay, mHour, mMinute);
                    /** Converting the date and time in to milliseconds elapsed since epoch */
                    alarm_time = calendar.getTimeInMillis();

                    setAlarm(alarm_time);
                }else
                    Toast.makeText(Alarm.this,"Select Time First",Toast.LENGTH_SHORT).show();
            }
        });




//
////        timePicker = (TimePicker) findViewById(R.id.timePicker);
//
//        //attaching clicklistener on button
//        findViewById(R.id.buttonAlarm).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Calendar calendar = Calendar.getInstance();
//
//                if (android.os.Build.VERSION.SDK_INT >= 23) {
//
////                        DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);
////
////                        /** Getting a reference to TimePicker object available in the MainActivity */
////                        TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
////
////                        int year = dpDate.getYear();
////                        int month = dpDate.getMonth();
////                        int day = dpDate.getDayOfMonth();
////                        int hour = tpTime.getCurrentHour();
////                        int minute = tpTime.getCurrentMinute();
////
////                        /** Creating a calendar object corresponding to the date and time set by the user */
////                        GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);
////
////                        /** Converting the date and time in to milliseconds elapsed since epoch */
////                        long alarm_time = calendar.getTimeInMillis();
//
//
//                    calendar.set(calendar.get(Calendar.YEAR),
//                            calendar.get(Calendar.MONTH),
//                            calendar.get(Calendar.DAY_OF_MONTH),
//                            timePicker.getHour(), timePicker.getMinute(), 0);
//                } else {
////                        //==================================
////                        /** Getting a reference to DatePicker object available in the MainActivity */
////                        DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);
////
////                        /** Getting a reference to TimePicker object available in the MainActivity */
////                        TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
////
////                        int year = dpDate.getYear();
////                        int month = dpDate.getMonth();
////                        int day = dpDate.getDayOfMonth();
////                        int hour = tpTime.getCurrentHour();
////                        int minute = tpTime.getCurrentMinute();
////
////                        /** Creating a calendar object corresponding to the date and time set by the user */
////                        GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);
////
////                        /** Converting the date and time in to milliseconds elapsed since epoch */
////                        alarm_time = calendar.getTimeInMillis();
//                    //========================================
//                    calendar.set(calendar.get(Calendar.YEAR),
//                            calendar.get(Calendar.MONTH),
//                            calendar.get(Calendar.DAY_OF_MONTH),
//                            timePicker.getCurrentHour(),
//                            timePicker.getCurrentMinute(),
//                            0);
//                }
//
////                setAlarm(alarm_time);
//                setAlarm(calendar.getTimeInMillis());
//
//            }
//        });
    }

    private void setAlarm(long timeinMilllis) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(this, AlarmReceiverController.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeinMilllis, AlarmManager.INTERVAL_DAY,
                pendingIntent);

//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//        intentArray = new ArrayList<PendingIntent>();
//
//        for( i = 0; i < 10; ++i)
//        {
//            Intent intent = new Intent(this, Alarm.class);
//            // Loop counter `i` is used as a `requestCode`
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i, intent, 0);
//
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeinMilllis, AlarmManager.INTERVAL_DAY,
//                pendingIntent);
//
//            intentArray.add(pendingIntent);
//        }

        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int Minute) {
        TextView textView=(TextView) findViewById(R.id.time_txt_id);
        textView.setText("Hour: "+hourOfDay+"Minute: "+Minute);
        this.mMinute=Minute;
        this.mHour=hourOfDay;
    }

    public static class TimePickerFragment extends DialogFragment{
        Calendar calendar=Calendar.getInstance();
        int hours=calendar.get(Calendar.HOUR_OF_DAY);
        int minutes=calendar.get(Calendar.MINUTE);
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener)
                    getActivity(),hours,minutes,android.text.format.DateFormat.is24HourFormat(getActivity()));

        }
    }
}
