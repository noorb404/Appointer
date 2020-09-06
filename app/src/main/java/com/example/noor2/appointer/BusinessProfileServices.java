package com.example.noor2.appointer;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.format.Time;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.DESTINATION;
import static com.example.noor2.appointer.StartActivity.USER;

public class BusinessProfileServices extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_business_profile_services);
            /*STARTING VARS*/

            /*GOLD LINE*/
            final TextView goldl=findViewById(R.id.segoldline);

            /*BUTTONS*/
            final Button camBtn=findViewById(R.id.camBtn);
            final Button Customers1=findViewById(R.id.CustomersBtn1);
            final TextView Customers2=findViewById(R.id.CustomersBtn2);
            final Button addService = findViewById(R.id.addServiceBtn);

            final Button DETAILSb=findViewById(R.id.DETAILSbtn);
            final Button PRODUCTSb=findViewById(R.id.PRODUCTSbtn);
            final Button HAIRCUTSb=findViewById(R.id.HAIRCUTSbtn);
            final Button SCHEDULEb=findViewById(R.id.SCHEDULEbtn);

            final Button backbtn=findViewById(R.id.backbtn);
            final Button app=findViewById(R.id.appBtn);
            final Button profile=findViewById(R.id.profilebtn);
            final Button business=findViewById(R.id.businessbtn);
            final Button search=findViewById(R.id.searchBtn);



            if(BusinessFlag==0) {
                camBtn.setVisibility(View.INVISIBLE);
                Customers1.setVisibility(View.INVISIBLE);
                Customers2.setVisibility(View.INVISIBLE);
                addService.setVisibility(View.INVISIBLE);
            }

            init();//FILL SERVICES FROM USER OR DESTINATION.

            /*ON CLICK LISTENER*/
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
            /*ADD SERVICE BUTTON*/
            addService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addService();
                }
            });

            /*GOLD LINE TRANSITION BUTTONS.*/
            SCHEDULEb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent businessPD=new Intent(getApplicationContext(),BusinessProfileSchedule.class);
                    Pair p;
                    p= new Pair<View,String>(goldl,"goldtransition") ;
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileServices.this,p);
                    startActivity(businessPD,options.toBundle());
                }
            });
            DETAILSb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent businessPD=new Intent(getApplicationContext(),BusinessProfileDetails.class);
                    Pair p;
                    p= new Pair<View,String>(goldl,"goldtransition") ;
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileServices.this,p);
                    startActivity(businessPD,options.toBundle());
                }
            });
            PRODUCTSb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent businessPP=new Intent(getApplicationContext(),BusinessProfileProducts.class);
                    Pair p;
                    p= new Pair<View,String>(goldl,"goldtransition") ;
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileServices.this,p);
                    startActivity(businessPP,options.toBundle());

                }
            });
            HAIRCUTSb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent businessPH=new Intent(getApplicationContext(),BusinessProfileHaircuts.class);
                    Pair p;
                    p= new Pair<View,String>(goldl,"goldtransition") ;
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileServices.this,p);
                    startActivity(businessPH,options.toBundle());

                }
            });


    }
    private  void init()
    {

            initServices();
    }
    private void initServices()
    {
        if(BusinessFlag==0) {
            if(DESTINATION.getBUSINESS().getServices().size()!=0) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                RecyclerView recyclerView = findViewById(R.id.servicesList);
                recyclerView.setLayoutManager(layoutManager);
                TakeASeatViewAdapter takeASeatViewAdapter = new TakeASeatViewAdapter(DESTINATION.getBUSINESS().getServices(), this);
                recyclerView.setAdapter(takeASeatViewAdapter);
            }
        }else if(USER.getBUSINESS().getServices().size()!=0)
            {
                LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                RecyclerView recyclerView = findViewById(R.id.servicesList);
                recyclerView.setLayoutManager(layoutManager);
                TakeASeatViewAdapter takeASeatViewAdapter = new TakeASeatViewAdapter(USER.getBUSINESS().getServices(), this);
                recyclerView.setAdapter(takeASeatViewAdapter);
            }
    }


    /* CALLED BY THE ADD SERVICE BUTTON  */
    private void addService()
    {
        Intent addService= new Intent(getApplicationContext(),AddServiceActivity.class);
        startActivityForResult(addService,111);
    }
    /*FINISH ADD SERVICE ACTIVITY RESULTS*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      switch (requestCode)
      {
          case 111:
              if(resultCode== Activity.RESULT_OK)
              {
                  String ServiceName = data.getStringExtra("service");
                  int Time=data.getIntExtra("time",-1);
                  int price=data.getIntExtra("price",-1);

                  if(Time!=-1 && price!=-1) {
                      Services s=new Services(1,ServiceName,Integer.toString(price),Integer.toString(Time),"","");
                      if(BusinessFlag==0)
                       DESTINATION.getBUSINESS().getServices().add(s);
                      else if(BusinessFlag==1)
                          USER.getBUSINESS().getServices().add(s);
                      init();

                  }
              }
      }
    }

    /*TAKE A SEAT SERVICE ADAPTER
    class ServicesAdapter extends ArrayAdapter<String>{
            Context context;
            String Servicess[];
            int price[];
            int time[];

            ServicesAdapter(Context c, String[] s,int[] p,int[] t)
            {
                super(c,R.layout.activity_takeaseat,R.id.servicename,s);
                this.context=c;
                this.price=p;
                this.time=t;
                this.Servicess=s;
            }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View takeaseat = layoutInflater.inflate(R.layout.activity_takeaseat,parent,false);
            TextView servic=takeaseat.findViewById(R.id.servicename);
            TextView tim=takeaseat.findViewById(R.id.time);
            TextView pric=takeaseat.findViewById(R.id.details);
            servic.setText(SERVICE[position]);
            pric.setText(Integer.toString(PRICE[position]));
            tim.setText(Integer.toString(TIME[position]));
            return takeaseat;
        }
    }*/
}
