package com.example.lab4.audio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import com.example.lab4.R;

import java.io.File;
import java.util.ArrayList;

public class AudioActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView no_songs;

    ArrayList<AudioModel> songsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        recyclerView = findViewById(R.id.recycler_view);
        no_songs = findViewById(R.id.no_songs_text);

        String filename = "android.resource://" + this.getPackageName() + "/raw/last_christmas";
        AudioModel audioModel = new AudioModel(filename, "Last Christmas");
        AudioModel audioModel1 = new AudioModel("https://cdn.pixabay.com/download/audio/2022/12/04/audio_5db5205c8a.mp3?filename=jingle-bells-christmas-hip-hop-128137.mp3", "Jingle_Bells");
        songsList.add(audioModel1);
        songsList.add(audioModel);


        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while(cursor.moveToNext()){
            AudioModel songData = new AudioModel(cursor.getString(1),cursor.getString(0));
            if(new File(songData.getPath()).exists())
                songsList.add(songData);
        }
        cursor.close();
        if(songsList.size()==0){
          no_songs.setVisibility(View.VISIBLE);
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ListAdapterAudio(songsList,getApplicationContext()));
        }




    }






}