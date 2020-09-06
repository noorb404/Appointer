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

public class TakeASeatViewAdapter extends RecyclerView.Adapter<TakeASeatViewAdapter.ViewHolder> {

    private ArrayList<Services> Service;
    private Context mContext;

    public TakeASeatViewAdapter(ArrayList<Services> service, Context c)
    {
        this.Service=service;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_takeaseat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.servicename.setText(Service.get(position).getServiceName());
        holder.servicedetails.setText(Service.get(position).getSerivcePrice());
        holder.servicetime.setText(Service.get(position).getServiceTime());

        holder.TAKEASEAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SERVICE.setSerivcePrice(Service.get(position).getSerivcePrice());
                SERVICE.setServiceTime(Service.get(position).getServiceTime());
                SERVICE.setServiceName(Service.get(position).getServiceName());
                Intent Appointment=new Intent(mContext,OrderActivity.class);
                mContext.startActivity(Appointment);
            }
        });
    }


    @Override
    public int getItemCount() {
        return Service.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button TAKEASEAT;
        TextView servicename;
        TextView servicetime;
        TextView servicedetails;

        ViewHolder(View itemView)
        {
            super(itemView);
            TAKEASEAT=itemView.findViewById(R.id.takeaseat);
            servicename=itemView.findViewById(R.id.servicename);
            servicedetails=itemView.findViewById(R.id.details);
            servicetime=itemView.findViewById(R.id.timeID);
        }
    }
}
