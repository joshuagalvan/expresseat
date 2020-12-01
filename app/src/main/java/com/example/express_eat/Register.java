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
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText eUsername, eEmail, ePassword, Re_enter, eLocation;
    private Button eSubmit;
    private TextView eLogin;
    public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        eUsername = findViewById(R.id.username);
        eEmail = findViewById(R.id.email);
        ePassword = findViewById(R.id.password);
        Re_enter = findViewById(R.id.reenterpassword);
        eLocation = findViewById(R.id.location);
        eSubmit = findViewById(R.id.submit);
        eLogin = findViewById(R.id.login);

        eSubmit.setOnClickListener(this);
        eLogin.setOnClickListener(this);

    }

    public void registerUser() {
        final String username = eUsername.getText().toString().trim();
        final String email = eEmail.getText().toString().trim();
        String password = ePassword.getText().toString().trim();
        String re_enter = Re_enter.getText().toString().trim();
        final String location = eLocation.getText().toString().trim();

        if (username.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter email username.", Toast.LENGTH_SHORT).show();
            return;
            
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter username.", Toast.LENGTH_SHORT).show();
            return;

        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;

        } else if (TextUtils.isEmpty(re_enter)) {
            Toast.makeText(getApplicationContext(), "Please re enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(location)) {
            Toast.makeText(getApplicationContext(), "Please put your location.", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    User user = new User(username, email, location);

                    FirebaseDatabase.getInstance().getReference("User")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Register.this, LogIn.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Register.this, "Please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

            public void onClick(View view) {

                if (view == eSubmit) {
                    registerUser();

                }

                if (view == eLogin) {
                    Intent b = new Intent(Register.this, LogIn.class);
                    startActivity(b);
                    finish();

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == eSubmit) {
            registerUser();

        }

        if (view == eLogin) {
            Intent b = new Intent(Register.this, LogIn.class);
            startActivity(b);
            finish();

        }
    }
}