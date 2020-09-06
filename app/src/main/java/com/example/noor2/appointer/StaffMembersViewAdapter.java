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

public class StaffMembersViewAdapter extends RecyclerView.Adapter<StaffMembersViewAdapter.ViewHolder> {

    private ArrayList<StaffMembers> Members;
    private Context mContext;

    public StaffMembersViewAdapter(ArrayList<StaffMembers> members, Context c)
    {
        this.Members=members;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_staff_members,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(Members.get(position).getImage())
                .into(holder.barberPhoto);
        holder.barberphone.setText(Members.get(position).getPhone());
        holder.barberName.setText(Members.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return Members.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView barberPhoto;
        TextView barberName;
        TextView barberphone;

        ViewHolder(View itemView)
        {
            super(itemView);
            barberPhoto=itemView.findViewById(R.id.barberPhoto);
            barberName=itemView.findViewById(R.id.BarberName);
            barberphone=itemView.findViewById(R.id.BarberPhone);
        }
    }
}
