package com.example.lab4.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.R;

import java.util.ArrayList;

public class ListAdapterAudio extends RecyclerView.Adapter<ListAdapterAudio.ViewHolder> {

    ArrayList<AudioModel> songsList;
    Context context;

    public ListAdapterAudio(ArrayList<AudioModel> songsList, Context context) {
        this.songsList = songsList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new ListAdapterAudio.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterAudio.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AudioModel songData = songsList.get(position);
        holder.titleTextView.setText(songData.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayerAudio.getInstance().reset();
                MediaPlayerAudio.currentIndex = position;
                Intent intent = new Intent(context,AudioPlayerActivity.class);
                intent.putExtra("list",songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text);


        }
    }
}
