package com.example.lab4.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lab4.R;
import com.example.lab4.audio.ListAdapterAudio;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<VideoModel> video_list = new ArrayList<>();
    TextView no_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        recyclerView = findViewById(R.id.recycler_view);
        no_video = findViewById(R.id.no_video_text);
        String path = "android.resource://" + getPackageName() + "/";
        try {
            video_list = getRawFiles(path);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(video_list.size()==0){
           no_video.setVisibility(View.VISIBLE);
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ListAdapterVideo(video_list,getApplicationContext()));
        }


    }

    public ArrayList<VideoModel> getRawFiles(String path) throws IllegalAccessException {

        Field[] fields = R.raw.class.getFields();
        for(int count=0; count < fields.length; count++){

            int rid = fields[count].getInt(fields[count]);
            String filename = fields[count].getName();
            VideoModel videoModel = new VideoModel(path+rid, filename);
            if(videoModel.getTitle().contains("last")){ }
            else {
            video_list.add(videoModel);}
        }

        String videopath = "https://player.vimeo.com/external/474243696.sd.mp4?s=d801adbe729c8150e14b50500593636f32045cfe&profile_id=164&oauth2_token_id=57447761";
        VideoModel videoModel = new VideoModel(videopath, "Some Internet Video");
        video_list.add(videoModel);
        return video_list;
    }
}

