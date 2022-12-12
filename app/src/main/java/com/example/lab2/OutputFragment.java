package com.example.lab2;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class OutputFragment extends Fragment {

    private TextView textView3;
    private Button cancel;

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_output, container, false);
       cancel = v.findViewById(R.id.cancel);
       textView3 = v.findViewById(R.id.textView3);

      cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               textView3.setText("");

                         }
       });

    return v;}

    public void setNewText(String text, Typeface typeface) {
        textView3 = getView().findViewById(R.id.textView3);
        textView3.setTypeface(typeface);
        textView3.setText(text);


    }
}