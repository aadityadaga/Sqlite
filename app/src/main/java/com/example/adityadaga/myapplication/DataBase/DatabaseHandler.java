package com.example.adityadaga.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.adityadaga.myapplication.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DatabaseHandler(Context c) {
        context = c;
    }

    public DatabaseHandler open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void insert(String name, String pass) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_EMAIL, name);
        contentValue.put(DatabaseHelper.COLUMN_PASSWORD, pass);
        long data =  database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        if(data != 0.0){
            Toast.makeText(context, "Register Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Data> getAll() {
        Cursor mcursor = database.rawQuery("Select * From " + DatabaseHelper.TABLE_NAME, null);
        List<Data> mList = new ArrayList<>();
        while (mcursor.moveToNext()) {
            String column_name = mcursor.getString(0);
            String columnPhn = mcursor.getString(1);
            Data mData = new Data(column_name, columnPhn);
            mList.add(mData);
        }
        return mList;
    }

    public boolean checkUser(String email, String password) {

        String selection = DatabaseHelper.COLUMN_EMAIL + " = ?" + " AND " + DatabaseHelper.COLUMN_PASSWORD + " = ?";
        String[] Column ={DatabaseHelper.COLUMN_EMAIL, DatabaseHelper.COLUMN_PASSWORD};
        String[] selectionArgs = {email, password};

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, Column,selection, selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();

        cursor.close();
        database.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}



