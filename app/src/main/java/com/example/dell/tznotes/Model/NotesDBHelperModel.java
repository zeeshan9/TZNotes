package com.example.dell.tznotes.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHelperModel extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tznotesdatabase.db";

    private static final String CREATE_TABLE_NOTES = " CREATE TABLE "+
            NotesContractProviderModel.NotesClass.TABLE_NAME+" ( "+
            NotesContractProviderModel.NotesClass._id+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_TITLE + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_DETAILS + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_DATE + " TEXT NOT NULL , "+
            NotesContractProviderModel.NotesClass.COLUMN_NOTE_ADDED_TIME+" TEXT NOT NULL  ) ; ";

    private static final String DELETE_TABLE_NOTES = " DROP TABLE IF EXISTS "+
            NotesContractProviderModel.NotesClass.TABLE_NAME;

    public NotesDBHelperModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE_NOTES);
        onCreate(db);
    }
}
