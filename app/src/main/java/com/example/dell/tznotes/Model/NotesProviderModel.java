package com.example.dell.tznotes.Model;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class NotesProviderModel extends ContentProvider {

    private static final int NOTES = 100;
    private static final int NOTES_ID = 101;

    private static final UriMatcher sUriMatcher  =new UriMatcher(UriMatcher.NO_MATCH);

    private NotesDBHelperModel mDbHelper;

    static{
        sUriMatcher.addURI(NotesContractProviderModel.CONTENT_AUTHORITY,
                NotesContractProviderModel.NotesClass.PATH_ACCOUNT,NOTES);
        sUriMatcher.addURI(NotesContractProviderModel.CONTENT_AUTHORITY,
                NotesContractProviderModel.NotesClass.PATH_ACCOUNT+"/#",NOTES_ID);

    }


    @Override
    public boolean onCreate() {
        mDbHelper = new NotesDBHelperModel(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        final int match = sUriMatcher.match(uri);

        switch (match) {
            case NOTES:
                cursor = database.query(NotesContractProviderModel.NotesClass.TABLE_NAME,
                        projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case NOTES_ID:
                selection = NotesContractProviderModel.NotesClass._id + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(NotesContractProviderModel.NotesClass.TABLE_NAME,
                        projection, selection, selectionArgs, null, null, sortOrder);
                break;

            default:
                cursor = null;

        }
        return cursor;
    }
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = sUriMatcher.match(uri);

        // Get writeable database
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        long id;

        switch (match){
            case NOTES:
                // Insert the new pet with the given values
                id = database.insert(NotesContractProviderModel.NotesClass.TABLE_NAME
                        , null, values);

            default:
                id = -2;

        }
        if(id == -1){
            return null;
        }
        else {
            // Return the new URI with the ID (of the newly inserted row) appended at the end
            return ContentUris.withAppendedId(uri, id);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
