package com.example.dell.tznotes.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class NotesDBHelperModel extends SQLiteOpenHelper {
    Context context;
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "tznotesdatabase.db";



    private static final String CREATE_TABLE_NOTES = " CREATE TABLE "+
            NotesContractProviderModel.NotesClass.TABLE_NAME+" ( "+
            NotesContractProviderModel.NotesClass._id+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_TITLE + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_DETAILS + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_DATE + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_TIME+" TEXT NOT NULL  ) ; ";

    //        Alarmtable
    private static final String  CREATE_ALARM_TABLE="CREATE TABLE " +
            NotesContractProviderModel.AlarmTable.TABLE_NAME + " (" +
            NotesContractProviderModel.AlarmTable.ALARM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NotesContractProviderModel.AlarmTable.DATE_COLUMN +" VARCHAR2(255), " +
            NotesContractProviderModel.AlarmTable.TIME_COLUMN +" VARCHAR2(255), " +
            NotesContractProviderModel.AlarmTable.CONTENTDISCRIPTION_COLUMN +" VARCHAR2(255));";

    private static final String DELETE_TABLE_NOTES = " DROP TABLE IF EXISTS "+
            NotesContractProviderModel.NotesClass.TABLE_NAME;

    public NotesDBHelperModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_NOTES);
        db.execSQL(CREATE_ALARM_TABLE);

        Toast.makeText(context,"OnCreate called",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE_NOTES);
        onCreate(db);
    }


}
