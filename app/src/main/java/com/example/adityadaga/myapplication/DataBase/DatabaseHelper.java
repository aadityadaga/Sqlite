package com.example.adityadaga.myapplication.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "UserDetails";
    public static final String COLUMN_EMAIL = "Email";

    public static final String COLUMN_PASSWORD = "Password";

    private static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "( " + COLUMN_EMAIL + " TEXT UNIQUE, " + COLUMN_PASSWORD + " TEXT )";


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME,null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
