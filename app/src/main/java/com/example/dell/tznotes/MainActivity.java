package com.example.dell.tznotes;

import android.content.Intent;
import android.media.Ringtone;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.AlarmReceiverController;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    NavigationView mNavigationView;
    TextView mNotesTxt,mToDoList,mAlarmTxt,mPictureStory;
    AppCompatImageView appCompatImageView;

    public static boolean mMyAlarm=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (mMyAlarm==true) {
            AlarmReceiverController myAlarm=new AlarmReceiverController();
            Ringtone ringtone = myAlarm.getRingtone();
            ringtone.stop();
        }
        mNotesTxt=(TextView) findViewById(R.id.notes_txt_id);
        mAlarmTxt=(TextView) findViewById(R.id.alarm_txt_id);
        mPictureStory=(TextView) findViewById(R.id.picturestories_txt_id);

        mToDoList=(TextView) findViewById(R.id.todolist_txt_id);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Open,R.string.Close);

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        mActionBarDrawerToggle.setDrawerSlideAnimationEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        //Click Listener
        mNotesTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NotesActivity.class);
                startActivity(intent);
            }
        });

        mAlarmTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarmIntent = new Intent(MainActivity.this,Alarm.class);
                startActivity(alarmIntent);

            }
        });
        mPictureStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pictureintent = new Intent(MainActivity.this,PictureStory.class);
                startActivity(pictureintent);

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if (id==R.id.homeAsUp)
            Toast.makeText(this,"Home is selected", Toast.LENGTH_LONG).show();

        if (id==R.id.item_1) {
            Toast.makeText(this, "1 is selected", Toast.LENGTH_LONG).show();
            mDrawerLayout.closeDrawer(Gravity.START,true);
        }
        if (id==R.id.item_2)
            Toast.makeText(this,"2 is selected", Toast.LENGTH_LONG).show();
        if (id==R.id.item_3)
            Toast.makeText(this,"3 is selected", Toast.LENGTH_LONG).show();

        return false;
    }



}