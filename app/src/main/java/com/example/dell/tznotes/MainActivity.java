package com.example.dell.tznotes;

import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    NavigationView mNavigationView;
    TextView mNotesTxt,mToDoList;
    AppCompatImageView appCompatImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotesTxt=(TextView) findViewById(R.id.feather);
        mNotesTxt.setClickable(true);

//       mNotesTxt.setOnClickListener();

//        mToDoList=(TextView) findViewById(R.id.todolist_txt_id);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Open,R.string.Close);

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        mActionBarDrawerToggle.setDrawerSlideAnimationEnabled(true);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

//        mToDoList=(TextView) frameLayout.findViewById(R.id.todolist_txt_id);
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