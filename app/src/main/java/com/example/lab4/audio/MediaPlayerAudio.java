package com.example.lab4.audio;

import android.media.MediaPlayer;

public class MediaPlayerAudio {
    static MediaPlayer instance;

    public static MediaPlayer getInstance(){
        if(instance == null){
            instance = new MediaPlayer();
        }
        return instance;
    }

    public static int currentIndex = -1;
}
