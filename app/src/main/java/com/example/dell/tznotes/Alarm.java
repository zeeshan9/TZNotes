package com.example.dell.tznotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.AlarmReceiverController;

import java.util.ArrayList;
import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    TimePicker timePicker;
    ArrayList<PendingIntent> intentArray;
    public static int i;
    long alarm_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alarm);


        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //attaching clicklistener on button
        findViewById(R.id.buttonAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();

                if (android.os.Build.VERSION.SDK_INT >= 23) {

//                        DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);
//
//                        /** Getting a reference to TimePicker object available in the MainActivity */
//                        TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
//
//                        int year = dpDate.getYear();
//                        int month = dpDate.getMonth();
//                        int day = dpDate.getDayOfMonth();
//                        int hour = tpTime.getCurrentHour();
//                        int minute = tpTime.getCurrentMinute();
//
//                        /** Creating a calendar object corresponding to the date and time set by the user */
//                        GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);
//
//                        /** Converting the date and time in to milliseconds elapsed since epoch */
//                        long alarm_time = calendar.getTimeInMillis();


                    calendar.set(calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getHour(), timePicker.getMinute(), 0);
                } else {
//                        //==================================
//                        /** Getting a reference to DatePicker object available in the MainActivity */
//                        DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);
//
//                        /** Getting a reference to TimePicker object available in the MainActivity */
//                        TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
//
//                        int year = dpDate.getYear();
//                        int month = dpDate.getMonth();
//                        int day = dpDate.getDayOfMonth();
//                        int hour = tpTime.getCurrentHour();
//                        int minute = tpTime.getCurrentMinute();
//
//                        /** Creating a calendar object corresponding to the date and time set by the user */
//                        GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);
//
//                        /** Converting the date and time in to milliseconds elapsed since epoch */
//                        alarm_time = calendar.getTimeInMillis();
                    //========================================
                    calendar.set(calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute(),
                            0);
                }

//                setAlarm(alarm_time);
                setAlarm(calendar.getTimeInMillis());

            }
        });
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

}
