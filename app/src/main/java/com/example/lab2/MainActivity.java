package com.example.lab2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.Fragment;
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
    private RadioGroup radios;
    private RadioButton font;
    OutputFragment output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_field = findViewById(R.id.user_field);
        ok = findViewById(R.id.ok);
        radios = findViewById(R.id.radios);
        FragmentManager fragmentManager = getSupportFragmentManager();
        output = (OutputFragment) fragmentManager.findFragmentById(R.id.fragment_output);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonOk(View view) {
        int radioId = radios.getCheckedRadioButtonId();
        font = findViewById(radioId);
        if (user_field.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Текст не введено", Toast.LENGTH_LONG).show();
        } else {
            if (radioId == -1) {
                Toast.makeText(MainActivity.this, "Зробіть вибір шрифту!!!!!", Toast.LENGTH_LONG).show();
            } else {
                buttonCheck(radioId);
                writeText();
            }

        }
    }


    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonCheck(int radioId) {
        switch (radioId) {
            case R.id.rsanserifblack:

                Typeface san_serif_black = getResources().getFont(R.font.sants_serif_black);
                changeFont(san_serif_black);


                break;
            case R.id.rcursive:
                Typeface cursive = getResources().getFont(R.font.cursive);
                changeFont(cursive);

                break;
            case R.id.rcasual:

                Typeface casual = getResources().getFont(R.font.casual);
                changeFont(casual);

                break;
            case R.id.rmonospace:

                Typeface fontmonospace = Typeface.MONOSPACE;
                changeFont(fontmonospace);

                break;

        }


    }

    public void changeFont(Typeface font) {

        ((TextView) output.getView().findViewById(R.id.textView3)).setTypeface(font);

    }


    public void writeText() {
        String text = user_field.getText().toString();
        ((TextView) output.getView().findViewById(R.id.textView3)).setText(text);

    }
}
