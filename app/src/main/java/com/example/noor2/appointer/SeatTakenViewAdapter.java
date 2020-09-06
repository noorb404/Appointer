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

import static com.example.noor2.appointer.StartActivity.DESTINATION;
import static com.example.noor2.appointer.StartActivity.USER;

public class SeatTakenViewAdapter extends RecyclerView.Adapter<SeatTakenViewAdapter.ViewHolder> {

    private ArrayList<Services> Service;
    private Context mContext;

    public SeatTakenViewAdapter(ArrayList<Services> serivce, Context c)
    {
        this.Service=serivce;
        this.mContext=c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seatstaken,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

       if(Service.get(position).getCustomerName()!=null) {
           holder.customername.setText(Service.get(position).getCustomerName());
           holder.servicedetails.setText(Service.get(position).getSerivcePrice());
           holder.servicetime.setText(Service.get(position).getServiceTime());
       }
       holder.DELETESEAT.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ///TODO DELETE THE PRESSED SEAT FROM BACKEND USERNAME IS IN USER, AND UPDATE .
               USER.getBUSINESS().getFreeTime().remove(Service.get(position).getServiceTime());// BACK TO THIS "BUG"
           }
       });

    }
    @Override
    public int getItemCount() {
        return Service.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button DELETESEAT;
        TextView customername;
        TextView servicetime;
        TextView servicedetails;

        ViewHolder(View itemView)
        {
            super(itemView);
            DELETESEAT=itemView.findViewById(R.id.deleteID);
            customername=itemView.findViewById(R.id.customerName);
            servicedetails=itemView.findViewById(R.id.details);
            servicetime=itemView.findViewById(R.id.timeID);
        }
    }
}
