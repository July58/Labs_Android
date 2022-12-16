package com.example.lab2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lab2.R;
import com.example.lab2.db.DBManager;

public class ReaderActivity extends AppCompatActivity {

    private TextView textView;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_reader);
        textView = findViewById(R.id.textContent);
        dbManager = new DBManager(ReaderActivity.this);
        dbManager.openDB();
        openData();
    }

    public void openData(){
    for (String data: dbManager.readInfo()) {
           textView.append(data);
           textView.append("\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}