package com.example.lab4.audio;

import android.content.res.AssetFileDescriptor;

import java.io.Serializable;

public class AudioModel implements Serializable {
    String path;
    String title;

    public AudioModel(String path, String title) {
        this.path = path;
        this.title = title;

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}