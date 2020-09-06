package com.example.noor2.appointer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.USER;

public class AccountDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        int color= Color.parseColor("#9A7D2C");



        final EditText name=findViewById(R.id.cusName);
        final EditText email=findViewById(R.id.cusEmail);
        final EditText phone=findViewById(R.id.cusPhone);

        final Button men = findViewById(R.id.men);
        final Button women = findViewById(R.id.women);
        final Button both=findViewById(R.id.both);

        final Button BackButton=findViewById(R.id.whiteback);
        final Button Search=findViewById(R.id.searchBtn);
        final Button app=findViewById(R.id.appBtn);
        final Button business=findViewById(R.id.businessbtn);




        name.setText(USER.getUserName());
        email.setText(USER.getEmail());
        phone.setText(USER.getPhoneNumber());

        switch (USER.getServices())
        {
            case "men":
                men.setTextColor(color);
                break;
            case "women":
                women.setTextColor(color);
                break;
            case "both":
                both.setTextColor(color);
                break;


        }

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
