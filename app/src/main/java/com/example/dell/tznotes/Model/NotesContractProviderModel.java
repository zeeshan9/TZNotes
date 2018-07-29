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

    public static final String PATH_ALARM = AlarmTable.TABLE_NAME;

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

    public static final class AlarmTable implements BaseColumns
    {
        public static final Uri CONTENT_URI_ALARM_TABLE = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ALARM);

        public static final String TABLE_NAME = "alarm";

        public static final String ALARM_ID = BaseColumns._ID;
        public static final String DATE_COLUMN = "date";
        public static final String TIME_COLUMN = "time";
        public static final String CONTENTDISCRIPTION_COLUMN = "contentdiscription";


    }

}
