package com.example.firebaseloginregistrationdataindataretrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Loginbtn, Registrationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main Page");

        Loginbtn = findViewById(R.id.LoginButton_ID);
        Registrationbtn=findViewById(R.id.RegistrationButton_ID);

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(),Login.class);
                startActivity(loginIntent);

            }
        });

        Registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegIntent = new Intent(getApplicationContext(),Registration.class);
                startActivity(RegIntent);



            }
        });

    }
}
