package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.noor2.appointer.StartActivity.USER;
import static com.example.noor2.appointer.StartActivity.WorkHoursFlag;

public class CustomerStartBusiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_start_business);

        Button startBus=findViewById(R.id.startbusiness);
        final Button app=findViewById(R.id.appBtn);
        final Button profile=findViewById(R.id.profilebtn);
        final Button business=findViewById(R.id.businessbtn);
        final Button search=findViewById(R.id.searchBtn);

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
                if(USER.getUserKind().equals("business")) {
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
        startBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///TODO UPDATE IN DATA BASE
                USER.setUserKind("business");
                WorkHoursFlag=1;
                Intent workingHours=new Intent(getApplicationContext(),WorkingHoursActivity.class);
                startActivity(workingHours);
            }
        });
    }
}
