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
import static com.example.noor2.appointer.StartActivity.USER;

public class BusinessProfileHaircuts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile_haircuts);


        /*Buttons*/
        final Button SERVICEbtn = findViewById(R.id.SERVICESbtn);
        final Button DETAILSb = findViewById(R.id.DETAILSbtn);
        final Button PRODUCTSb = findViewById(R.id.PRODUCTSbtn);
        final Button SCHEDULEb = findViewById(R.id.SCHEDULEbtn);
        /*goldline*/
        final TextView goldl = findViewById(R.id.hagoldline);

        final Button backbtn = findViewById(R.id.backbtn);
        final Button app = findViewById(R.id.appBtn);
        final Button profile = findViewById(R.id.profilebtn);
        final Button business = findViewById(R.id.businessbtn);
        final Button search = findViewById(R.id.searchBtn);

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

           initPhotos();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search = new Intent(getApplicationContext(), SearchActivity.class);
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
                Intent app = new Intent(getApplicationContext(), AppointerActivity.class);
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
                Intent app = new Intent(getApplicationContext(), AppointerActivity.class);
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
                Intent profile = new Intent(getApplicationContext(), CustomerProfileActivity.class);
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
                Intent business = new Intent(getApplicationContext(), BusinessProfileServices.class);
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
                Intent businessPD = new Intent(getApplicationContext(), BusinessProfileSchedule.class);
                Pair p;
                p = new Pair<View, String>(goldl, "goldtransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileHaircuts.this, p);
                startActivity(businessPD, options.toBundle());
            }
        });
        SERVICEbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPS = new Intent(getApplicationContext(), BusinessProfileServices.class);
                Pair p;
                p = new Pair<View, String>(goldl, "goldtransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileHaircuts.this, p);
                startActivity(businessPS, options.toBundle());

            }
        });
        DETAILSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPD = new Intent(getApplicationContext(), BusinessProfileDetails.class);
                Pair p;
                p = new Pair<View, String>(goldl, "goldtransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileHaircuts.this, p);
                startActivity(businessPD, options.toBundle());

            }
        });
        PRODUCTSb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent businessPP = new Intent(getApplicationContext(), BusinessProfileProducts.class);
                Pair p;
                p = new Pair<View, String>(goldl, "goldtransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BusinessProfileHaircuts.this, p);
                startActivity(businessPP, options.toBundle());

            }
        });
    }

    private void initPhotos() {
        if (DESTINATION.getBUSINESS().getImages().size()!=0 && BusinessFlag==0) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            RecyclerView recyclerView = findViewById(R.id.HaircutsList);
            recyclerView.setLayoutManager(layoutManager);
            PhotoViewAdapter photoViewAdapter = new PhotoViewAdapter(DESTINATION.getBUSINESS().getImages(), this);
            recyclerView.setAdapter(photoViewAdapter);

        }else if(USER.getBUSINESS().getImages().size()!=0 && BusinessFlag==1) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            RecyclerView recyclerView = findViewById(R.id.HaircutsList);
            recyclerView.setLayoutManager(layoutManager);
            PhotoViewAdapter photoViewAdapter = new PhotoViewAdapter(USER.getBUSINESS().getImages(), this);
            recyclerView.setAdapter(photoViewAdapter);

        }

    }
}