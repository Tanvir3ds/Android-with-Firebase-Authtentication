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

public class Login extends AppCompatActivity {
    private TextView textView;
    private EditText SignInEmailEditTextUser, SignInPasswordEditTextUser;
    private Button SignInButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();





        //signup activity






        //  SignInEmailEditTextUser, SignInPasswordEditTextUser;
        // SignInButton;

        SignInEmailEditTextUser=findViewById(R.id.SignInEmailEditTextUser_ID);
        SignInPasswordEditTextUser=findViewById(R.id.SignInPasswordEditTextUser_ID);
        SignInButton=findViewById(R.id.SignInButton_ID);
        progressBar =(ProgressBar) findViewById(R.id.SignUpProgressBer_Id);

        //Login user part
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }



    public void userLogin() {

        //input email passwor fron java class this

        String email =SignInEmailEditTextUser.getText().toString().trim();
        String password =SignInPasswordEditTextUser.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            SignInEmailEditTextUser.setError("Enter an email address");
            SignInEmailEditTextUser.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            SignInEmailEditTextUser.setError("Enter a valid email address");
            SignInEmailEditTextUser.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            SignInPasswordEditTextUser.setError("Enter a password");
            SignInPasswordEditTextUser.requestFocus();
            return;
        }

        if (password.length()<6){
            SignInPasswordEditTextUser.setError("Minimum lenth of a password should be 6");
            SignInPasswordEditTextUser.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),ProductDataAdd.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {

                    Toast.makeText(getApplicationContext(),"Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




}