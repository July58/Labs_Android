package com.example.lab4.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.R;

import com.example.lab4.audio.AudioPlayerActivity;
import com.example.lab4.audio.ListAdapterAudio;
import com.example.lab4.audio.MediaPlayerAudio;

import java.util.ArrayList;


public class ListAdapterVideo extends  RecyclerView.Adapter<ListAdapterVideo.ViewHolder> {

    ArrayList<VideoModel> videoList;
    Context context;

    public ListAdapterVideo(ArrayList<VideoModel> videoListList, Context context) {
        this.videoList = videoListList;
        this.context = context;
    }


    @Override
    public ListAdapterVideo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new ListAdapterVideo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterVideo.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        VideoModel videoData = videoList.get(position);
        holder.titleTextView.setText(videoData.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.putExtra("list",videoList);
                intent.putExtra("position", position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text);


        }
    }
}
