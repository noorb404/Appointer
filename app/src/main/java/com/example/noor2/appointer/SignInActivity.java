package com.example.noor2.appointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.noor2.appointer.StartActivity.CustomersDataBase;
import static com.example.noor2.appointer.StartActivity.USER;

public class SignInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Button signuptxt = findViewById(R.id.SignUpButton);
        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(signup);
            }
        });

        final Button log = findViewById(R.id.LoginButton);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //NEED TO CHECK IF USERNAME AND PASSWORD WORKS.

                int success = CheckUserName();
                if (success == 1) {
                    Intent business = new Intent(getApplicationContext(), AppointerActivity.class);
                    startActivity(business);

                }
            }
        });
    }

    public int CheckUserName() {
        String UserName,Password;
        /*EDIT TEXT ---> USER PASS PHONE..*/


        final EditText usr =findViewById(R.id.UsernameEditTxt);
        final EditText pwd =findViewById(R.id.PasswordEditTxt);

        UserName=usr.getText().toString();
        Password=pwd.getText().toString();


            if(CustomersDataBase.CheckUserName(UserName,Password,"signin"))//ALREADY EXIST
            {
                Toast.makeText(SignInActivity.this, "Incorrect username/password, Please try again.", Toast.LENGTH_SHORT).show();
                return 0;
            }
        USER=CustomersDataBase.GetData(UserName);

        return 1;
    }

}
