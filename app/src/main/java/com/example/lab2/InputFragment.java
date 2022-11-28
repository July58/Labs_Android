package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class InputFragment extends Fragment {

    private EditText user_field;
    private Button ok;
    private RadioGroup radios;
    private RadioButton font;


    interface OnFragmentSendDataListener {
        void onSendData(String text, Typeface typeface);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "should implement interface OnFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        user_field = view.findViewById(R.id.user_field);
        ok = view.findViewById(R.id.ok);
        radios = view.findViewById(R.id.radios);


        ok.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                int radioId = radios.getCheckedRadioButtonId();
                font = view.findViewById(radioId);
                if (user_field.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "Текст не введено", Toast.LENGTH_LONG).show();
                } else {
                    if (radioId == -1) {
                        Toast.makeText(getActivity(), "Зробіть вибір шрифту", Toast.LENGTH_LONG).show();
                    } else {
                       Typeface typeface = buttonCheck(radioId);
                       String text = String.valueOf(user_field.getText());
                       fragmentSendDataListener.onSendData(text, typeface);
                       FileAccess fileAccess = new FileAccess(getActivity());
                       fileAccess.saveText(view, text);

                    }

                }


            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Typeface buttonCheck(int radioId) {
        switch (radioId){
            case (R.id.monospace): return Typeface.MONOSPACE;
            case (R.id.casual): return getResources().getFont(R.font.casual);
            case (R.id.sans_serif_black): return getResources().getFont(R.font.sants_serif_black);
            case (R.id.cursive): return getResources().getFont(R.font.cursive);

        }

        return Typeface.DEFAULT;
    }




}


