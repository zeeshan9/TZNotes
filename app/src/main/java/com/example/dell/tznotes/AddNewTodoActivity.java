package com.example.dell.tznotes;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.dell.tznotes.Controller.Notes.BottomNavigationViewHelper;
import com.example.dell.tznotes.Model.NotesContractProviderModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewTodoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    int year, month, day, hour, minute;
    int yearFinal, monthFinal, dayFinal, hourFinal, minuteFinal;
    EditText todoTitleEditTxt , todoDetailEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_todo);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom);
        ActionBar toolbar = getSupportActionBar();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_note_action_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:

                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);



                DatePickerDialog datePickerDialog = new DatePickerDialog(AddNewTodoActivity.this,AddNewTodoActivity.this,year,month,day);
                datePickerDialog.show();

//                Date currentTimeDate = Calendar.getInstance().getTime();
//
//                String temp = ""+currentTimeDate.getMonth();
//                int temp1 = Integer.parseInt(temp);
//                temp1++;
//
//                String temp2 = ""+currentTimeDate.getYear();
//                int temp3 = Integer.parseInt(temp2);
//                temp3 = temp3+1900;
//
//
//                String currentDate = currentTimeDate.getDate()+"/"+temp1+"/"+temp3;
//
//                String currentTime = currentTimeDate.getHours()+":"+currentTimeDate.getMinutes()+":"+currentTimeDate.getSeconds();
//
//                noteTitleEditTxt = (EditText) findViewById(R.id.note_title_edit_txt);
//                noteDetailEditTxt = (EditText) findViewById(R.id.note_detail_edit_txt);
//
//                ContentValues newUserValues = new ContentValues();
//                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_TITLE,noteTitleEditTxt.getText().toString());
//                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_DETAILS,noteDetailEditTxt.getText().toString());
//                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_DATE,currentDate);
//                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_TIME,currentTime);
//
//
//                Uri newUri = getContentResolver().
//                        insert(NotesContractProviderModel.NotesClass.CONTENT_URI, newUserValues);
//
//
//
//                if(newUri == null){
//                    Toast.makeText(AddNewNoteActivity.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(AddNewNoteActivity.this, "Data insertion successfully", Toast.LENGTH_SHORT).show();
//
//                }
//                Intent intent = new Intent(this,NotesActivity.class);
//                finish();
//                startActivity(intent);

                return true;



            default:


                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // uncheck the other items.
//        int mMenuId = item.getItemId();
//        for (int i = 0; i < mBtmView.getMenu().size(); i++) {
//            MenuItem menuItem = mBtmView.getMenu().getItem(i);
//            boolean isChecked = menuItem.getItemId() == item.getItemId();
//            menuItem.setChecked(isChecked);
//        }

        switch (item.getItemId()) {
            case R.id.bold_item: {
                Toast.makeText(this,"Bold",Toast.LENGTH_LONG).show();

            }
            break;
            case R.id.italic_item: {
                Toast.makeText(this,"Italic",Toast.LENGTH_LONG).show();

            }
            break;
            case R.id.underline_item: {
                Toast.makeText(this,"Underline",Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.color_item: {
                Toast.makeText(this,"Color",Toast.LENGTH_LONG).show();

            }
            break;
            case R.id.align_item: {
                Toast.makeText(this,"Align",Toast.LENGTH_LONG).show();

            }
            break;
        }
        return true;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month + 1;
        dayFinal = dayOfMonth;



        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(AddNewTodoActivity.this,AddNewTodoActivity.this,hour,minute, android.text.format.DateFormat.is24HourFormat(this));
        timePickerDialog.show();

        todoTitleEditTxt = (EditText) findViewById(R.id.todo_title_edit_txt);
        todoDetailEditTxt = (EditText) findViewById(R.id.todo_detail_edit_txt);



    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hourFinal = hourOfDay;
        minuteFinal = minute;


        String selectedDate = dayFinal+"/"+monthFinal+"/"+yearFinal;

        String selectedTime = hourFinal+":"+minuteFinal;

                Date currentTimeDate = Calendar.getInstance().getTime();

                String temp = ""+currentTimeDate.getMonth();
                int temp1 = Integer.parseInt(temp);
                temp1++;

                String temp2 = ""+currentTimeDate.getYear();
                int temp3 = Integer.parseInt(temp2);
                temp3 = temp3+1900;


                String currentDate = currentTimeDate.getDate()+"/"+temp1+"/"+temp3;

                String currentTime = currentTimeDate.getHours()+":"+currentTimeDate.getMinutes()+":"+currentTimeDate.getSeconds();

                todoTitleEditTxt = (EditText) findViewById(R.id.todo_title_edit_txt);
                todoDetailEditTxt = (EditText) findViewById(R.id.todo_detail_edit_txt);

                ContentValues newUserValues = new ContentValues();
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_TITLE,todoTitleEditTxt.getText().toString());
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_DETAILS,todoDetailEditTxt.getText().toString());
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_CURRENT_DATE,currentDate);
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_CURRENT_TIME,currentTime);
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_SELECTED_DATE,selectedDate);
                newUserValues.put(NotesContractProviderModel.TodoClass.COLUMN_TODO_SELECTED_TIME,selectedTime);


                Uri newUri = getContentResolver().
                        insert(NotesContractProviderModel.TodoClass.CONTENT_URI, newUserValues);



                if(newUri == null){
                    Toast.makeText(AddNewTodoActivity.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddNewTodoActivity.this, "Data insertion successfully", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(this,ToDoActivity.class);
                finish();
                startActivity(intent);



    }
}
