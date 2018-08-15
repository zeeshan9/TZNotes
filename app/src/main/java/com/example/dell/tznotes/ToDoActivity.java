package com.example.dell.tznotes;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.dell.tznotes.Controller.Notes.NotesAdapter;
import com.example.dell.tznotes.Controller.Notes.TodoAdapter;
import com.example.dell.tznotes.Model.NotesContractProviderModel;

public class ToDoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TodoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        //Following code is to set floating button an action

        FloatingActionButton fab = findViewById(R.id.fab_todo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToDoActivity.this,AddNewTodoActivity.class);
                finish();
                startActivity(intent);
            }
        });

        //Following code is to set Recycler View


        String[] projection = {NotesContractProviderModel.TodoClass.COLUMN_TODO_TITLE,NotesContractProviderModel.TodoClass.COLUMN_TODO_DETAILS};



        Cursor cursor = getContentResolver().query(NotesContractProviderModel.TodoClass.CONTENT_URI,
                projection,null,null,null,null);


        mRecyclerView = (RecyclerView) findViewById(R.id.todo_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TodoAdapter(cursor);
        mRecyclerView.setAdapter(mAdapter);



    }
}
