package com.example.noor2.appointer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class  StartActivity extends Activity {

    static DBHelper CustomersDataBase;
    static User USER;
    static User DESTINATION;
    static Services SERVICE;
    static int WorkHoursFlag;
    static int BusinessFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SERVICE=new Services(0,"","","","","");
        USER=new User(0,"","","","","","");
        DESTINATION=new User(0,"","","","","","");
        CustomersDataBase = new DBHelper(this);
        WorkHoursFlag=0;
        BusinessFlag=0;
        Thread t =new Thread()
        {
            @Override
            public void run(){
                try {
                    sleep(2*1000);
                    Intent i =new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(i);
                }catch (Exception e){

                }
            }
        };
        t.start();





    }
}
