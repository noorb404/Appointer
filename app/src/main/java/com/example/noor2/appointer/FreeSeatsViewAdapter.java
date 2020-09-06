package com.example.noor2.appointer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FreeSeatsViewAdapter extends RecyclerView.Adapter<FreeSeatsViewAdapter.ViewHolder> {

    ArrayList<String> FreeTime;
    private Context mContext;
    int i=0;

    public FreeSeatsViewAdapter(ArrayList<String> freeTime,Context c)
    {
        this.FreeTime=freeTime;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seats,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final int tmp=Color.parseColor("#000000");
        holder.freeSeat.setText(FreeTime.get(position));
        holder.freeSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.freeSeat.setTextColor(tmp);
            }
        });
    }


    @Override
    public int getItemCount() {
        return FreeTime.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button freeSeat;

        ViewHolder(View itemView)
        {
            super(itemView);
            freeSeat=itemView.findViewById(R.id.FreeSeats);

        }
    }
}
