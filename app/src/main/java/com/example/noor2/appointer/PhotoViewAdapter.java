package com.example.noor2.appointer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.SERVICE;

public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewAdapter.ViewHolder> {

    private  ArrayList<Integer> Photos=new ArrayList<>();
    private Context mContext;

    public PhotoViewAdapter(ArrayList<Integer> photos, Context c)
    {
        this.Photos=photos;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_photos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(Photos.get(position))
                .into(holder.photos);
    }


    @Override
    public int getItemCount() {
        return Photos.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
       ImageView photos;

        ViewHolder(View itemView)
        {
            super(itemView);
            photos=itemView.findViewById(R.id.PhotoID);

        }
    }
}
