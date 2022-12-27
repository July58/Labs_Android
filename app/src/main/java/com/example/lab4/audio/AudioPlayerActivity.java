package com.example.lab4.audio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.lab4.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AudioPlayerActivity extends AppCompatActivity {

    TextView titleSong;
    SeekBar seekBar;
    ImageView pausePlay,nextBtn,previousBtn;
    ArrayList<AudioModel> songsList;
    AudioModel currentSong;
    MediaPlayer mediaPlayer = MediaPlayerAudio.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        titleSong = findViewById(R.id.song_title);
        seekBar = findViewById(R.id.seek_bar);
        pausePlay = findViewById(R.id.pause_play);
        nextBtn = findViewById(R.id.next);
        previousBtn = findViewById(R.id.previous);
        songsList = (ArrayList<AudioModel>) getIntent().getSerializableExtra("list");
        musicTask();

    }


    void musicTask(){
        currentSong = songsList.get(MediaPlayerAudio.currentIndex);
        titleSong.setText(currentSong.getTitle());
        pausePlay.setOnClickListener(v-> pausePlay());
        nextBtn.setOnClickListener(v-> playNextSong());
        previousBtn.setOnClickListener(v-> playPreviousSong());
        playMusic();
    }



    private void playMusic(){
        mediaPlayer.reset();
        try {
            if(currentSong.getPath().contains("raw")){
                mediaPlayer.setDataSource(this, Uri.parse(currentSong.getPath()));
            }else {
            mediaPlayer.setDataSource(currentSong.getPath());}
            mediaPlayer.prepare();
            mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void playNextSong(){
      if(MediaPlayerAudio.currentIndex== songsList.size()-1)
            return;
       MediaPlayerAudio.currentIndex +=1;
       mediaPlayer.reset();
       musicTask();

    }


    private void playPreviousSong(){
        if(MediaPlayerAudio.currentIndex== 0)
            return;
       MediaPlayerAudio.currentIndex -=1;
       mediaPlayer.reset();
       musicTask();
    }


    private void pausePlay(){
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }
}