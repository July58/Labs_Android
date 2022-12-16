package com.example.lab2.db;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

public class MyDBHelper extends SQLiteOpenHelper {
     public static final String DB_Name = "my_db.db";
     public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS fonts ( _id INTEGER PRIMARY KEY, message TEXT, typeface TEXT)";
     public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DB_Name;
     public static final int DB_VERSION = 1;





    public MyDBHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(TABLE_STRUCTURE);
        } catch (SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int newVersion) {
       sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
       onCreate(sqLiteDatabase);
    }

}
