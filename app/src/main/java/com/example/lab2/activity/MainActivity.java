package com.example.lab2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab2.R;
import com.example.lab2.db.DBManager;
import com.example.lab2.fragment.InputFragment;
import com.example.lab2.fragment.OutputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentSendDataListener {

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(MainActivity.this);
        dbManager.openDB();

    }

    @Override
    public void onSendData(String text, Typeface typeface) {
        OutputFragment fragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_output);
        if (fragment != null)
            fragment.setNewText(text, typeface);
    }

    public void open(View view) {

        if (dbManager.isEmpty()) {
            Toast.makeText(this, "Дані відсутні", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ReaderActivity.class);
            startActivity(intent);
        }
    }
}



