package com.example.noor2.appointer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.DESTINATION;
import static com.example.noor2.appointer.StartActivity.SERVICE;
import static com.example.noor2.appointer.StartActivity.USER;

public class BusinessProfileSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(BusinessFlag==1)
            setContentView(R.layout.activity_bussines_proifle_schedule);
        else
            setContentView(R.layout.activity_business_profile_schedule_customer);

        /*goldLine*/
        final TextView goldl=findViewById(R.id.scgoldline);
        /*INNER Buttons*/
        final Button SERVICEbtn=findViewById(R.id.SERVICESbtn);
        final Button PRODUCTSb=findViewById(R.id.PRODUCTSbtn);
        final Button HAIRCUTSb=findViewById(R.id.HAIRCUTSbtn);
        final Button DETAILSb=findViewById(R.id.DETAILSbtn);
        /*OUT Buttons*/
        final Button backbtn=findViewById(R.id.backbtn);
        final Button app=findViewById(R.id.appBtn);
        final Button profile=findViewById(R.id.profilebtn);
        final Button business=findViewById(R.id.businessbtn);
        final Button search=findViewById(R.id.searchBtn);

        final Button camBtn=findViewById(R.id.camBtn);
        final Button Customers1=findViewById(R.id.CustomersBtn1);
        final TextView Customers2=findViewById(R.id.CustomersBtn2);
        final Button addService = findViewById(R.id.addServiceBtn);
        if(BusinessFlag==0) {
            camBtn.setVisibility(View.INVISIBLE);
            Customers1.setVisibility(View.INVISIBLE);
            Customers2.setVisibility(View.INVISIBLE);
            addService.setVisibility(View.INVISIBLE);
        }

        final Button back=findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


       if(DESTINATION.getBUSINESS().getFreeTime().size()!=0 && DESTINATION.getBUSINESS().getScheduleSeatsTaken().size()!=0) {
         if(BusinessFlag==1)
           initFreeTime();
         initServices();
       }

        /*ON CLICK*/
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(search);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent app=new Intent(getApplicationContext(),AppointerActivity.class);
                startActivity(app);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent app=new Intent(getApplicationContext(),AppointerActivity.class);
                startActivity(app);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile=new Intent(getApplicationContext(),CustomerProfileActivity.class);
                startActivity(profile);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent business=new Intent(getApplicationContext(),BusinessProfileServices.class);
                startActivity(business);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });


        DETAILSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPD=new Intent(getApplicationContext(),BusinessProfileDetails.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileSchedule.this,p);
                startActivity(businessPD,options.toBundle());

            }
        });
        SERVICEbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPS=new Intent(getApplicationContext(),BusinessProfileServices.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileSchedule.this,p);
                startActivity(businessPS,options.toBundle());
            }
        });
        PRODUCTSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPP=new Intent(getApplicationContext(),BusinessProfileProducts.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileSchedule.this,p);
                startActivity(businessPP,options.toBundle());
            }
        });
        HAIRCUTSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPH=new Intent(getApplicationContext(),BusinessProfileHaircuts.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileSchedule.this,p);
                startActivity(businessPH,options.toBundle());
            }
        });

    }

    private void initFreeTime()
    {
        if(BusinessFlag==0) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            RecyclerView recyclerView = findViewById(R.id.EmptySeats);
            recyclerView.setLayoutManager(layoutManager);
            ScheduleFreeSeatsViewAdapter scheduleFreeSeatsViewAdapter = new ScheduleFreeSeatsViewAdapter(DESTINATION.getBUSINESS().getFreeTime(), this);
            recyclerView.setAdapter(scheduleFreeSeatsViewAdapter);
        }else if(USER.getBUSINESS().getFreeTime().size()!=0)
            {
                LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                RecyclerView recyclerView = findViewById(R.id.EmptySeats);
                recyclerView.setLayoutManager(layoutManager);
                ScheduleFreeSeatsViewAdapter scheduleFreeSeatsViewAdapter = new ScheduleFreeSeatsViewAdapter(USER.getBUSINESS().getFreeTime(), this);
                recyclerView.setAdapter(scheduleFreeSeatsViewAdapter);
            }
    }
    private void initServices()
    {
        if(BusinessFlag==0){
            LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            RecyclerView recyclerView=findViewById(R.id.SeatsTaken);
            recyclerView.setLayoutManager(layoutManager);
            SeatTakenViewAdapter seatTakenViewAdapter =new SeatTakenViewAdapter(DESTINATION.getBUSINESS().getScheduleSeatsTaken(),this);
            recyclerView.setAdapter(seatTakenViewAdapter);
        }else if(USER.getBUSINESS().getScheduleSeatsTaken().size()!=0)
            {
                LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                RecyclerView recyclerView=findViewById(R.id.SeatsTaken);
                recyclerView.setLayoutManager(layoutManager);
                SeatTakenViewAdapter seatTakenViewAdapter =new SeatTakenViewAdapter(USER.getBUSINESS().getScheduleSeatsTaken(),this);
                recyclerView.setAdapter(seatTakenViewAdapter);
            }
    }
}
