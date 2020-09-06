package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.USER;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final Button BackButton=findViewById(R.id.whiteback);

        final Button Search=findViewById(R.id.searchBtn);
        final Button app=findViewById(R.id.appBtn);
        final Button business=findViewById(R.id.businessbtn);


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
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search =new Intent(getApplicationContext(),SearchActivity.class);
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
                Intent search =new Intent(getApplicationContext(),AppointerActivity.class);
                startActivity(search);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });


        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
