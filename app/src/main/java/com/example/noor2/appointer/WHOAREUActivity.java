package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.noor2.appointer.StartActivity.USER;

public class WHOAREUActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whoareu);

        final Button bus = findViewById(R.id.startbusbtn);
        final Button cus = findViewById(R.id.startcustbtn);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER.setUserKind("business");
                Intent intent=new Intent(getApplicationContext(),PickServiceActivity.class);
                startActivity(intent);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER.setUserKind("customer");
                Intent intent=new Intent(getApplicationContext(),PickServiceActivity.class);
                startActivity(intent);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }
}
