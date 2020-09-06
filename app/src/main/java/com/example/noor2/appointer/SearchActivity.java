package com.example.noor2.appointer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.USER;

public class SearchActivity extends AppCompatActivity {
    private ArrayList<Integer> imgs=new ArrayList<>();
    private  ArrayList<String> names=new ArrayList<>();
    private  ArrayList<String> locations=new ArrayList<>();

    ListView SearchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imgs.add(R.drawable.topa);
        imgs.add(R.drawable.tope);
        imgs.add(R.drawable.topd);
        imgs.add(R.drawable.topb);
        imgs.add(R.drawable.topc);


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

        final Button appointer=findViewById(R.id.appBtn);
        final Button profile=findViewById(R.id.profilebtn);
        final Button business=findViewById(R.id.businessbtn);



        /*BUTTONS*/
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
        appointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /*FILL AUTO SEARCH LIST*/
        initSearchResults();
    }

    private void initSearchResults()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView=findViewById(R.id.searchList);
        recyclerView.setLayoutManager(layoutManager);
        SearchResultViewAdapter searchResultViewAdapter =new SearchResultViewAdapter(imgs,names,locations,this);
        recyclerView.setAdapter(searchResultViewAdapter);
    }

    /*TAKE A SEAT SERVICE ADAPTER*/
    /* ADAPTER FOR THE LISTVIEW FOR SEARCH RESULTS*/
  /*  class SearchAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> names;
        ArrayList<String> locations;
        ArrayList<Integer> imgs;

        SearchAdapter(Context c, ArrayList<String> n,ArrayList<String> l,ArrayList<Integer> t)
        {
            super(c,R.layout.activity_searchresult,R.id.servicename,n);
            this.context=c;
            this.locations=l;
            this.imgs=t;
            this.names=n;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View searchR = layoutInflater.inflate(R.layout.activity_searchresult,parent,false);

            TextView name=searchR.findViewById(R.id.SsaloonName);
            ImageView photo=searchR.findViewById(R.id.SsaloonPhoto);
            TextView location=searchR.findViewById(R.id.SsaloonLoaction);
            name.setText(names.get(position));

            Glide.with(this.context)
                    .asBitmap()
                    .load(imgs.get(position))
                    .into(photo);

            location.setText(locations.get(position));
            return searchR;
        }
    }*/
}
