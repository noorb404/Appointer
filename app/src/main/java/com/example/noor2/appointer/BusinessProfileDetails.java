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

import java.util.Map;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.DESTINATION;
import static com.example.noor2.appointer.StartActivity.USER;

public class BusinessProfileDetails extends AppCompatActivity {

    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile_details);

        img=R.drawable.topa;
        /*goldLine*/
        final TextView goldl=findViewById(R.id.degoldline);
        /*INNER Buttons*/
        final Button SERVICEbtn=findViewById(R.id.SERVICESbtn);
        final Button PRODUCTSb=findViewById(R.id.PRODUCTSbtn);
        final Button HAIRCUTSb=findViewById(R.id.HAIRCUTSbtn);
        final Button SCHEDULEb=findViewById(R.id.SCHEDULEbtn);
        /*OUT Buttons*/
        final Button backbtn=findViewById(R.id.backbtn);
        final Button app=findViewById(R.id.appBtn);
        final Button profile=findViewById(R.id.profilebtn);
        final Button business=findViewById(R.id.businessbtn);
        final Button search=findViewById(R.id.searchBtn);
        /*OPEN HOURS*/
        final TextView sunday=findViewById(R.id.sun);
        final TextView monday=findViewById(R.id.mon);
        final TextView tuesday=findViewById(R.id.tue);
        final TextView wednesday=findViewById(R.id.wed);
        final TextView thursday=findViewById(R.id.thu);
        final TextView friday=findViewById(R.id.fri);
        final TextView saturday=findViewById(R.id.sat);


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

        if(DESTINATION.getBUSINESS().getOpenHours().size()!=0 && BusinessFlag==0) {
            sunday.setText(DESTINATION.getBUSINESS().getOpenHours().get("sunday"));
            monday.setText(DESTINATION.getBUSINESS().getOpenHours().get("monday"));
            tuesday.setText(DESTINATION.getBUSINESS().getOpenHours().get("tuesday"));
            wednesday.setText(DESTINATION.getBUSINESS().getOpenHours().get("wednesday"));
            thursday.setText(DESTINATION.getBUSINESS().getOpenHours().get("thursday"));
            friday.setText(DESTINATION.getBUSINESS().getOpenHours().get("friday"));
            saturday.setText(DESTINATION.getBUSINESS().getOpenHours().get("saturday"));
        }else if(USER.getBUSINESS().getOpenHours().size()!=0 && BusinessFlag==1)
        {
            sunday.setText(USER.getBUSINESS().getOpenHours().get("sunday"));
            monday.setText(USER.getBUSINESS().getOpenHours().get("monday"));
            tuesday.setText(USER.getBUSINESS().getOpenHours().get("tuesday"));
            wednesday.setText(USER.getBUSINESS().getOpenHours().get("wednesday"));
            thursday.setText(USER.getBUSINESS().getOpenHours().get("thursday"));
            friday.setText(USER.getBUSINESS().getOpenHours().get("friday"));
            saturday.setText(USER.getBUSINESS().getOpenHours().get("saturday"));
        }

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


        SCHEDULEb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPD=new Intent(getApplicationContext(),BusinessProfileSchedule.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileDetails.this,p);
                startActivity(businessPD,options.toBundle());
            }
        });
        SERVICEbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPS=new Intent(getApplicationContext(),BusinessProfileServices.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileDetails.this,p);
                startActivity(businessPS,options.toBundle());
            }
        });
        PRODUCTSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPP=new Intent(getApplicationContext(),BusinessProfileProducts.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileDetails.this,p);
                startActivity(businessPP,options.toBundle());
            }
        });
        HAIRCUTSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPH=new Intent(getApplicationContext(),BusinessProfileHaircuts.class);
                Pair p;
                p= new Pair<View,String>(goldl,"goldtransition") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileDetails.this,p);
                startActivity(businessPH,options.toBundle());
            }
        });
        initStaffMembers();
    }
    private void initStaffMembers()
    {
       if(BusinessFlag==1) {
           if(USER.getBUSINESS().getStaffMembers().size()==0)
           {
               StaffMembers m=new StaffMembers(USER.getUserName(),USER.getPhoneNumber(),img);
               USER.getBUSINESS().getStaffMembers().add(m);
           }
           LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
           RecyclerView recyclerView = findViewById(R.id.StaffMembersList);
           recyclerView.setLayoutManager(layoutManager);
           StaffMembersViewAdapter staffMembersViewAdapter = new StaffMembersViewAdapter(USER.getBUSINESS().getStaffMembers(), this);
           recyclerView.setAdapter(staffMembersViewAdapter);
       }else
           {
               LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
               RecyclerView recyclerView = findViewById(R.id.StaffMembersList);
               recyclerView.setLayoutManager(layoutManager);
               StaffMembersViewAdapter staffMembersViewAdapter = new StaffMembersViewAdapter(DESTINATION.getBUSINESS().getStaffMembers(), this);
               recyclerView.setAdapter(staffMembersViewAdapter);
           }
    }
}
