package com.example.dell.tznotes;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.BottomNavigationViewHelper;
import com.example.dell.tznotes.Model.NotesContractProviderModel;

import java.util.Calendar;
import java.util.Date;

public class AddNewNoteActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    EditText noteTitleEditTxt;
    EditText noteDetailEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

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

                Date currentTimeDate = Calendar.getInstance().getTime();

                String temp = ""+currentTimeDate.getMonth();
                int temp1 = Integer.parseInt(temp);
                temp1++;

                String temp2 = ""+currentTimeDate.getYear();
                int temp3 = Integer.parseInt(temp2);
                temp3 = temp3+1900;


                String currentDate = currentTimeDate.getDate()+"/"+temp1+"/"+temp3;

                String currentTime = currentTimeDate.getHours()+":"+currentTimeDate.getMinutes()+":"+currentTimeDate.getSeconds();

                noteTitleEditTxt = (EditText) findViewById(R.id.note_title_edit_txt);
                noteDetailEditTxt = (EditText) findViewById(R.id.note_detail_edit_txt);

                ContentValues newUserValues = new ContentValues();
                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_TITLE,noteTitleEditTxt.getText().toString());
                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_DETAILS,noteDetailEditTxt.getText().toString());
                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_DATE,currentDate);
                newUserValues.put(NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_TIME,currentTime);


                Uri newUri = getContentResolver().
                        insert(NotesContractProviderModel.NotesClass.CONTENT_URI, newUserValues);



                if(newUri == null){
                    Toast.makeText(AddNewNoteActivity.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddNewNoteActivity.this, "Data insertion successfully", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(this,NotesActivity.class);
                finish();
                startActivity(intent);

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

}
