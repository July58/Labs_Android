package com.example.lab2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.lab2.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }

    public void openDB() {
        db = myDBHelper.getWritableDatabase();
    }


    public boolean insertToDB(String text, String typeface) {
        ContentValues cv = new ContentValues();
        cv.put("message", text);
        cv.put("typeface", typeface);
        db.insert("fonts", null, cv);
        return true;
    }

    public List<String> readInfo() {
        List<String> list = new ArrayList<>();
        Cursor cursor = db.query("fonts", null, null, null,
                null, null, null);
        while (cursor.moveToNext()) {
            int idmessage = cursor.getColumnIndex("message");
            int idfont = cursor.getColumnIndex("typeface");
            String text = cursor.getString(idmessage);
            String font = cursor.getString(idfont);
            list.add("Text: " + text + " Font: " + font);
        }

        cursor.close();
        return list;
    }

    public boolean isEmpty() {
        long NoOfRows = DatabaseUtils.queryNumEntries(db, "fonts");
        return (NoOfRows == 0);
    }

    public void closeDB() {
        myDBHelper.close();
    }


}
