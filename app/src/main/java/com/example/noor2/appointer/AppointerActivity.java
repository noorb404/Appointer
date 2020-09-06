package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.CustomersDataBase;
import static com.example.noor2.appointer.StartActivity.USER;

public class AppointerActivity extends AppCompatActivity {

    private ArrayList<Integer> images=new ArrayList<>();
    private  ArrayList<String> names=new ArrayList<>();
    private  ArrayList<String> locations=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointer);
        images.add(R.drawable.topa);
        images.add(R.drawable.tope);
        images.add(R.drawable.topd);
        images.add(R.drawable.topb);
        images.add(R.drawable.topc);


        names.add("Saloon Amar");
        names.add("Saloon Morad");
        names.add("Saloon Nadav");
        names.add("Saloon Ameer");
        names.add("Saloon Bsher");


        locations.add("Arraba Hazfon");
        locations.add("Arraba Hazfon");
        locations.add("Kiryat Shmona");
        locations.add("Sakhnen");
        locations.add("Haifa");

        final Button searchT=findViewById(R.id.seachbtnt);
        final Button searchB=findViewById(R.id.searchBtn);
        final Button business=findViewById(R.id.businessbtn);
        final Button profileBtn=findViewById(R.id.profilebtn);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (USER.getUserKind().equals("business")) {
                    BusinessFlag=1;
                    Intent business = new Intent(getApplicationContext(), BusinessProfileServices.class);
                    startActivity(business);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }else
                    {
                        Intent business = new Intent(getApplicationContext(), CustomerStartBusiness.class);
                        startActivity(business);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finish();
                    }

            }
        });

        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search=new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(search);
            }
        });
        searchT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search=new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(search);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile=new Intent(getApplicationContext(),CustomerProfileActivity.class);
                startActivity(profile);
            }
        });
        initTopRated();
        initFavorits();
    }
    private void initTopRated()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView=findViewById(R.id.TopRatedrecycleid);
        recyclerView.setLayoutManager(layoutManager);
        TopRatedViewAdapter topRatedViewAdapter =new TopRatedViewAdapter(images,names,locations,this);
        recyclerView.setAdapter(topRatedViewAdapter);
    }
    private void initFavorits()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView=findViewById(R.id.Favoritsrecycleid);
        recyclerView.setLayoutManager(layoutManager);
        FavoritsViewAdapter favoritsViewAdapter =new FavoritsViewAdapter(images,names,this);
        recyclerView.setAdapter(favoritsViewAdapter);
    }
}
