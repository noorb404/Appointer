package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.USER;

public class CustomerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        /*NAME*/
        TextView Name=findViewById(R.id.cusName);
        Name.setText(USER.getUserName());

        /*BUTTONS*/
        final Button appointerBtn =findViewById(R.id.appBtn);
        final Button accountD =findViewById(R.id.accountdetails);
        final Button payments=findViewById(R.id.payments);
        final Button settings=findViewById(R.id.settings);
        final Button feedback=findViewById(R.id.feedback);
        final Button about=findViewById(R.id.about);
        final Button LOGOUT=findViewById(R.id.logout);
        final Button business=findViewById(R.id.businessbtn);




        /*ON CLICK*/
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
        accountD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountDetails=new Intent(getApplicationContext(),AccountDetailsActivity.class);
                startActivity(accountDetails);
            }
        });
        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountPayments=new Intent(getApplicationContext(),PaymentsActivty.class);
                startActivity(accountPayments);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountSettings=new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(accountSettings);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountFeedback=new Intent(getApplicationContext(),FeedbackActivity.class);
                startActivity(accountFeedback);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountAbout=new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(accountAbout);
            }
        });
        appointerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appoiter=new Intent(getApplicationContext(),AppointerActivity.class);
                startActivity(appoiter);
            }
        });
    }
}
