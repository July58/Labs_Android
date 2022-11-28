package com.example.lab2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentSendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String text, Typeface typeface) {
    OutputFragment fragment = (OutputFragment) getSupportFragmentManager()
            .findFragmentById(R.id.fragment_output);
    if(fragment!= null)
        fragment.setNewText(text, typeface);
    }

    public void open(View view) {
        Intent intent = new Intent(MainActivity.this, FileReaderActivity.class);
        startActivity(intent);
    }
}



