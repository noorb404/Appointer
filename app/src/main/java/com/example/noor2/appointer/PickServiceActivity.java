package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.noor2.appointer.StartActivity.CustomersDataBase;
import static com.example.noor2.appointer.StartActivity.USER;

public class PickServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_service);

        Button menS=(Button)findViewById(R.id.menservice);
        Button womenS=(Button)findViewById(R.id.womenservice);
        Button bothS=(Button)findViewById(R.id.bothservice);

        menS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER.setServices("men");
                CustomersDataBase.addData(USER);
                if(USER.getUserKind().equals("customer")) {
                    Intent business = new Intent(getApplicationContext(), AppointerActivity.class);
                    startActivity(business);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }else
                    {
                        Intent WorkHours=new Intent(getApplicationContext(),WorkingHoursActivity.class);
                        startActivity(WorkHours);
                    }
            }
        });
        womenS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER.setServices("women");
                CustomersDataBase.addData(USER);
                if(USER.getUserKind().equals("customer")) {
                    Intent business = new Intent(getApplicationContext(), AppointerActivity.class);
                    startActivity(business);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }else
                {
                    Intent WorkHours=new Intent(getApplicationContext(),WorkingHoursActivity.class);
                    startActivity(WorkHours);
                }
            }
        });
        bothS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER.setServices("both");
                CustomersDataBase.addData(USER);
                if(USER.getUserKind().equals("customer")) {
                    Intent business = new Intent(getApplicationContext(), AppointerActivity.class);
                    startActivity(business);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }else
                {
                    Intent WorkHours=new Intent(getApplicationContext(),WorkingHoursActivity.class);
                    startActivity(WorkHours);
                }
            }
        });
    }
}
