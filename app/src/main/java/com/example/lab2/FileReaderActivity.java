package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FileReaderActivity extends AppCompatActivity {

    private TextView textView;
    public View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_reader);
        textView = findViewById(R.id.textContent);
        FileAccess fileAccess = new FileAccess(this);
        fileAccess.openText(view, textView);
    }
}