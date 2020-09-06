package com.example.noor2.appointer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddServiceActivity extends AppCompatActivity {

    private String ServiceName;
    private int Time;
    private int Price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        final EditText ServiceNametxt=findViewById(R.id.ServiceEditTxt);
        final EditText Timetxt=findViewById(R.id.TimeEditTxt);
        final EditText Pricetxt=findViewById(R.id.PriceEditTxt);

        Button addService =findViewById(R.id.AddButton);
        addService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceName=ServiceNametxt.getText().toString();
                Time= Integer.parseInt(Timetxt.getText().toString());
                Price=Integer.parseInt(Pricetxt.getText().toString());

                Intent input=new Intent();
                input.putExtra("service",ServiceName);
                input.putExtra("time",Time);
                input.putExtra("price",Price);
                setResult(Activity.RESULT_OK,input);
                finish();
            }
        });

    }
}
