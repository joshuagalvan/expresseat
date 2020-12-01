package com.example.express_eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    private EditText e_email, e_password;
    private Button sign_in;
    private TextView forgot_pass, e_signup;
    private FirebaseAuth mAuth;

    public void openMenu() {

        Intent intent = new Intent(this, Restaurant.class);
        startActivity(intent);
    }

    public void openForgotPassword(){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        e_signup = (TextView) findViewById(R.id.SignUp);
        e_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
        e_email = (EditText) findViewById(R.id.txtEmail);
        e_password = (EditText) findViewById(R.id.txt_pass);
        sign_in = (Button) findViewById(R.id.submit_btn);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
        forgot_pass = (TextView) findViewById(R.id.txtforgot);
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgotPassword();
            }
        });
        mAuth = FirebaseAuth.getInstance();
        sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = e_email.getText().toString().trim();
                String password = e_password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter username.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LogIn.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(LogIn.this, Restaurant.class);
                            startActivity(a);
                            finish();
                        } else {
                            Toast.makeText(LogIn.this, "Login fail.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}