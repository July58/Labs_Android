package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

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
       // InputFragment inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_input);

        Intent intent = new Intent(this, ReaderActivity.class);

        startActivity(intent);
    }
}



