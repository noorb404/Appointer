package com.example.noor2.appointer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.SERVICE;
import static com.example.noor2.appointer.StartActivity.USER;

public class OrderActivity extends AppCompatActivity {

    ArrayList<String> FreeTime=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        FreeTime.add("11:00");
        FreeTime.add("12:00");
        FreeTime.add("12:30");
        FreeTime.add("13:00");
        FreeTime.add("14:00");

        final Button back=findViewById(R.id.backbtn);
        final Button confirm=findViewById(R.id.ConfirmButton);

        final TextView servicename=findViewById(R.id.servicename);
        final TextView proname=findViewById(R.id.proname);
        final TextView time=findViewById(R.id.timeID);
        final TextView price=findViewById(R.id.priceID);
        servicename.setText(SERVICE.getServiceName());
        proname.setText(SERVICE.getProName());
        time.setText(SERVICE.getServiceTime());
        price.setText(SERVICE.getSerivcePrice()+"Shekels");



        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///TODO LOAD THE SERVICE IN THE PROFESSIONAL SCHEDULE AND REMOVE IT FROM FREE SEATS!
                // SEND TO THE PROFESSIONAL THE SERVICE.*******************  <-------------
                SERVICE.setCustomerName(USER.getUserName());
                SERVICE.setID(1);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        for(int i=0;i<FreeTime.size();i++)
         initFreeTime();
    }

    private void initFreeTime()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView=findViewById(R.id.FreeSeatsrecycleid);
        recyclerView.setLayoutManager(layoutManager);
        FreeSeatsViewAdapter freeSeatsViewAdapter =new FreeSeatsViewAdapter(FreeTime ,this);
        recyclerView.setAdapter(freeSeatsViewAdapter);
    }
}
