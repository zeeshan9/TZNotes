package com.example.dell.tznotes;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.BottomNavigationViewHelper;

public class AddNewNoteActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

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
