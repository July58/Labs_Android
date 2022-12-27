package com.example.lab4.video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.lab4.R;
import com.example.lab4.audio.AudioModel;

import java.util.ArrayList;

public class VideoPlayerActivity extends AppCompatActivity {


    VideoView videoPlayer;
    ArrayList<VideoModel> videoList;
    VideoModel currentVideo;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoPlayer = findViewById(R.id.videoView);

        videoList = (ArrayList<VideoModel>) getIntent().getSerializableExtra("list");
        index = getIntent().getIntExtra("position", -1);
        currentVideo = videoList.get(index);

        Uri myVideoUri= Uri.parse(currentVideo.getPath());
        if(currentVideo.getPath().contains("https")){
            videoPlayer.setVideoPath(currentVideo.getPath());
        }else {
        videoPlayer.setVideoURI(myVideoUri);}

        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

    }


}