package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity {

    private EditText user_field;
    private Button ok;
    private Button cancel;
    private RadioGroup radios;
    private RadioButton font;
    private TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_field = findViewById(R.id.user_field);
        ok = findViewById(R.id.ok);
        cancel = findViewById(R.id.cancel);
        textView3 = findViewById(R.id.textView3);
        radios = findViewById(R.id.radios);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonok(View view) {

        if (user_field.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Текст не введено", Toast.LENGTH_LONG).show();
        } else {
            buttoncheck();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttoncheck() {

        Integer radioId = radios.getCheckedRadioButtonId();
        font = findViewById(radioId);

        if (radioId.equals(null)){
            Toast.makeText(MainActivity.this, "Зробіть вибір шрифту!!!!!", Toast.LENGTH_LONG).show();
        }

        switch (radioId) {
            case R.id.rsanserifblack:

                Typeface san_serif_black = getResources().getFont(R.font.sants_serif_black);
                textView3.setTypeface(san_serif_black);
                writetext();
                break;
            case R.id.rcursive:
                Typeface cursive = getResources().getFont(R.font.cursive);
                textView3.setTypeface(cursive);
                writetext();
                break;
            case R.id.rcasual:

                Typeface casual = getResources().getFont(R.font.casual);
                textView3.setTypeface(casual);
                writetext();
                break;
            case R.id.rmonospace:

                Typeface fontmonospace = Typeface.MONOSPACE;
                textView3.setTypeface(fontmonospace);
                writetext();
                break;
            default:
                Toast.makeText(MainActivity.this, "Зробіть вибір шрифту", Toast.LENGTH_LONG).show();
                break;
        }
        radios.clearCheck();

    }

    public void buttoncancel(View view) {
        textView3.setText("");
    }

    public void writetext() {
        String text = user_field.getText().toString();
        textView3.setText(text);
    }
}
