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

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        final Button signintxt = findViewById(R.id.Logintxtbtn);
        final Button signupbtn = findViewById(R.id.SignUpButton);

        /*BUTTONS ---> SIGN IN + SIGN UP*/
        signintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin = new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(signin);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int success=CheckUserName();
                if(success==1)
                {
                    Intent intent = new Intent(getApplicationContext(),WHOAREUActivity.class);
                    startActivity(intent);
                }
            }

        });
    }

    public int CheckUserName() {
        String UserName,Password,ConfPassword,PhoneNumber;
        /*EDIT TEXT ---> USER PASS PHONE..*/
        final EditText usr=findViewById(R.id.UsernameEditTxt);
        final EditText pas=findViewById(R.id.PasswordEditTxt);
        final EditText confpas=findViewById(R.id.ConfPasswordEditTxt);
        final EditText phone=findViewById(R.id.PhoneEditTxt);

        UserName=usr.getText().toString();
        Password=pas.getText().toString();
        ConfPassword=confpas.getText().toString();
        PhoneNumber=phone.getText().toString();

        if(!Password.equals(ConfPassword))
        {
            Toast.makeText(SignUpActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            return 0;
        }else
            {
                if(CustomersDataBase.CheckUserName(UserName,"","signup"))//ALREADY EXIST
                {
                    Toast.makeText(SignUpActivity.this, "Username is not available, Please choose another one.", Toast.LENGTH_SHORT).show();
                    return 0;
                }
            }
        USER.setEmail("");
        USER.setUserName(UserName);
        USER.setPassword(Password);
        USER.setPhoneNumber(PhoneNumber);

        return 1;
    }
}
