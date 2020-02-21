package com.example.firebaseloginregistrationdataindataretrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registration extends AppCompatActivity {

    private EditText signUpEmailEditText , signUpPasswordEditText ;
    private Button SigUpButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setTitle("Registration");

        mAuth = FirebaseAuth.getInstance();



        //find EditText Sign In
        signUpEmailEditText=(EditText) findViewById(R.id.SignUpEmailUserEditText_ID);
        signUpPasswordEditText=(EditText)findViewById(R.id.SignUpPasswordlUserEditText_ID);



        //find Button Sign In
        SigUpButton=(Button) findViewById(R.id.SignUpButtonUser_ID);


        //Button Lisenner Add for next Activity And Registration Part
        SigUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SignUp Create a Function
                userRegister();

            }
        });



    }

    public void userRegister() {

        //input email passwor fron java class this

        String email =signUpEmailEditText.getText().toString().trim();
        String password =signUpPasswordEditText.getText().toString().trim();





        //checking the validity of the email
        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }

        if (password.length()<6){
            signUpPasswordEditText.setError("Minimum lenth of a password should be 6");
            signUpPasswordEditText.requestFocus();
            return;
        }





        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Registred is succesful",Toast.LENGTH_SHORT).show();
                    signUpEmailEditText.setText("");
                    signUpPasswordEditText.setText("");

                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                    }else {

                        Toast.makeText(getApplicationContext(),"Registred is not succesful",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }
}
