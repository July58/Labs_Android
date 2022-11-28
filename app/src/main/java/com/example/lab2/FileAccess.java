package com.example.lab2;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileAccess {
    private final static String FILE_NAME = "content.txt";
    Context context;

    public FileAccess(Context context) {
        this.context = context;
    }

    public void saveText(View view,String text){

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILE_NAME, Context.MODE_APPEND);
            text = text + '\n';
            fos.write(text.getBytes());
            Toast.makeText(context, "Файл збережено", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void openText(View view, TextView textView){

        FileInputStream fin = null;

        try {
            fin = context.openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            if (text.equals("")){
                Toast.makeText(context, "Файл пустий", Toast.LENGTH_SHORT).show();
            }
            textView.setText(text);
        }
        catch(IOException ex) {

            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
