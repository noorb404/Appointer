package com.example.noor2.appointer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.SERVICE;

public class    FavoritsViewAdapter extends RecyclerView.Adapter<FavoritsViewAdapter.ViewHolder> {

    private ArrayList<Integer> images=new ArrayList<>();
    private  ArrayList<String> names=new ArrayList<>();
      private Context mContext;

    public FavoritsViewAdapter(ArrayList<Integer> imgs, ArrayList<String> names, Context c)
    {
        this.images=imgs;
        this.names=names;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_favorits,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(images.get(position))
                .into(holder.saloonPhoto);
        holder.saloonName.setText(names.get(position));
        holder.saloonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SERVICE.setProName(names.get(position));
                BusinessFlag=0;//TO SHOW DESTINATION INTO NOT USER.
                ///TODO LOAD PROFESSIONAL DATA TO <<DESTINATION>> (USER VARIABLE) DEFINED IN START ACTIVITY.
                /* LOAD EVERY THING -> LOOK AT User CLASS AND Business CLASS.!! */
                Intent businessProfile=new Intent(mContext,BusinessProfileServices.class);
                mContext.startActivity(businessProfile);
            }
        });
    }


    @Override
    public int getItemCount() {
        return names.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView saloonPhoto;
        TextView saloonName;

        ViewHolder(View itemView)
        {
            super(itemView);
            saloonPhoto=itemView.findViewById(R.id.saloonPhoto);
            saloonName=itemView.findViewById(R.id.BarberName);

        }
    }
}
