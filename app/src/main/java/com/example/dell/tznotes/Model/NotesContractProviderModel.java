package com.example.dell.tznotes.Model;

import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;

public class NotesContractProviderModel {

    public static final String CONTENT_AUTHORITY = "com.example.dell.tznotes.Model";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private NotesContractProviderModel(Context context) {}

    /* Inner class that defines the table contents */
    public static class NotesClass implements BaseColumns {
        public static final String TABLE_NAME = "Notes";
        public static final String _id = BaseColumns._ID;
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_DETAILS = "note_details";
        public static final String COLUMN_NOTE_ADDED_DATE = "note_added_date";
        public static final String COLUMN_NOTE_ADDED_TIME = "note_added_time";


        public static final String PATH_ACCOUNT = TABLE_NAME;

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ACCOUNT);

    }

    public static class TodoClass implements BaseColumns {
        public static final String TABLE_NAME = "Todo";
        public static final String _id = BaseColumns._ID;
        public static final String COLUMN_TODO_TITLE = "todo_title";
        public static final String COLUMN_TODO_DETAILS = "todo_details";
        public static final String COLUMN_TODO_CURRENT_DATE = "todo_current_date";
        public static final String COLUMN_TODO_CURRENT_TIME = "todo_current_time";
        public static final String COLUMN_TODO_SELECTED_DATE = "todo_selected_date";
        public static final String COLUMN_TODO_SELECTED_TIME = "todo_selected_time";


        public static final String PATH_ACCOUNT = TABLE_NAME;

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ACCOUNT);

    }

}
