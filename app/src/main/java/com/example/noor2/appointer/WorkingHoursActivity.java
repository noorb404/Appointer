package com.example.noor2.appointer;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.example.noor2.appointer.StartActivity.BusinessFlag;
import static com.example.noor2.appointer.StartActivity.DESTINATION;
import static com.example.noor2.appointer.StartActivity.USER;
import static com.example.noor2.appointer.StartActivity.WorkHoursFlag;

public class WorkingHoursActivity extends AppCompatActivity {

    int sunF=0,monF=0,tueF=0,wedF=0,thuF=0,friF=0,satF=0;
    private Map<String,String> openHours;
    int RED= Color.parseColor("#FF0000");
    int WHITE=Color.parseColor("#ffffff");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);

        openHours=new HashMap<>();

        final EditText sunFrom = findViewById(R.id.sunfrom);
        final EditText monFrom = findViewById(R.id.monfrom);
        final EditText tueFrom = findViewById(R.id.tuefrom);
        final EditText wedFrom = findViewById(R.id.wedfrom);
        final EditText thuFrom = findViewById(R.id.thufrom);
        final EditText friFrom = findViewById(R.id.frifrom);
        final EditText satFrom = findViewById(R.id.satfrom);

        final EditText sunto = findViewById(R.id.sunto);
        final EditText monto = findViewById(R.id.monto);
        final EditText tueto = findViewById(R.id.tueto);
        final EditText wedto = findViewById(R.id.wedto);
        final EditText thuto = findViewById(R.id.thuto);
        final EditText frito = findViewById(R.id.frito);
        final EditText satto = findViewById(R.id.satto);

        final Button sunClose=findViewById(R.id.sunclosed);
        final Button monClose=findViewById(R.id.monclosed);
        final Button tueClose=findViewById(R.id.tueclosed);
        final Button wedClose=findViewById(R.id.wedclosed);
        final Button thuClose=findViewById(R.id.thuclosed);
        final Button friClose=findViewById(R.id.friclosed);
        final Button satClose=findViewById(R.id.satclosed);




        Button SAVEHOURS=findViewById(R.id.savehours);
        SAVEHOURS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sunFrom.getText()!=null && sunto.getText()!=null)
                {
                    openHours.put("sunday",sunFrom.getText().toString()+" - "+sunto.getText().toString());
                }
                if(monFrom.getText()!=null && monto.getText()!=null)
                {
                    openHours.put("monday",monFrom.getText().toString()+" - "+monto.getText().toString());
                }
                if(tueFrom.getText()!=null && tueto.getText()!=null)
                {
                    openHours.put("tuesday",tueFrom.getText().toString()+" - "+tueto.getText().toString());
                }
                if(wedFrom.getText()!=null && wedto.getText()!=null)
                {
                    openHours.put("wednesday",wedFrom.getText().toString()+" - "+wedto.getText().toString());
                }
                if(thuFrom.getText()!=null && thuto.getText()!=null)
                {
                    openHours.put("thursday",thuFrom.getText().toString()+" - "+thuto.getText().toString());
                }
                if(friFrom.getText()!=null && frito.getText()!=null)
                {
                    openHours.put("friday",friFrom.getText().toString()+" - "+frito.getText().toString());
                }
                if(satFrom.getText()!=null && satto.getText()!=null)
                {
                    openHours.put("saturday",satFrom.getText().toString()+" - "+satto.getText().toString());
                }
                if(sunF==1)
                    openHours.put("sunday","closed");
                if(monF==1)
                    openHours.put("monday","closed");
                if(tueF==1)
                    openHours.put("tuesday","closed");
                if(wedF==1)
                    openHours.put("wednesday","closed");
                if(thuF==1)
                    openHours.put("thursday","closed");
                if(friF==1)
                    openHours.put("friday","closed");
                if(satF==1)
                    openHours.put("saturday","closed");

                if(USER.getUserKind().equals("customer")) {
                    DESTINATION.getBUSINESS().setOpenHours(openHours);
                    Intent app = new Intent(getApplicationContext(), AppointerActivity.class);
                    startActivity(app);
                }
                if(USER.getUserKind().equals("business"))
                {
                    USER.getBUSINESS().setOpenHours(openHours);
                    WorkHoursFlag=0;
                    BusinessFlag=1; //WHICH INFO TO SHOW . USER OR DESTINATION ..
                    Intent buss=new Intent(getApplicationContext(),BusinessProfileServices.class);
                    startActivity(buss);
                    finish();
                }
            }
        });




        sunClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sunF==0) {
                    sunF = 1;
                    sunClose.setTextColor(RED);
                }
                else{
                    sunF=0;
                    sunClose.setTextColor(WHITE);
                }
            }
        });
        monClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(monF==0) {
                    monF = 1;
                    monClose.setTextColor(RED);
                }
                else{
                    monF=0;
                    monClose.setTextColor(WHITE);
                }
            }
        });
        tueClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tueF==0) {
                    tueF = 1;
                    tueClose.setTextColor(RED);
                }
                else{
                    tueF=0;
                    tueClose.setTextColor(WHITE);
                }
            }
        });
        wedClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wedF==0) {
                    wedF = 1;
                    wedClose.setTextColor(RED);
                }
                else{
                    wedF=0;
                    wedClose.setTextColor(WHITE);
                }
            }
        });
        thuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thuF==0) {
                    thuF = 1;
                    thuClose.setTextColor(RED);
                }
                else{
                    thuF=0;
                    thuClose.setTextColor(WHITE);
                }
            }
        });
        friClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friF==0) {
                    friF = 1;
                    friClose.setTextColor(RED);
                }
                else{
                    friF=0;
                    friClose.setTextColor(WHITE);
                }
            }
        });
        satClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(satF==0) {
                    satF = 1;
                    satClose.setTextColor(RED);
                }
                else{
                    satF=0;
                    satClose.setTextColor(WHITE);
                }            }
        });




    }
}
