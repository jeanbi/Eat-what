package com.orzsite.eatwhat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jimmy on 15/5/29.
 */
public class DatabaseUtils extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "eat_what";

    public DatabaseUtils(Context context) {
        this(context, DB_VERSION);
    }

    public DatabaseUtils(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Create Shop Table

        //TODO Create Food Table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
