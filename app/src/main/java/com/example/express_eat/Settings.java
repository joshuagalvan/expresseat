package com.example.express_eat;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Settings extends AppCompatActivity {

    private TextView e_logout, order_tracker;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    public void openOrder_Tracker(){

        Intent b = new Intent(Settings.this, Tracker.class);
        startActivity(b);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        order_tracker = findViewById(R.id.order_tracker);
        order_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder_Tracker();
            }
        });
        e_logout = (TextView) findViewById(R.id.logout);

        e_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == e_logout) {
                    Intent b = new Intent(Settings.this, LogIn.class);
                    startActivity(b);
                    finish();

                }
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User");
        userID = user.getUid();


        final TextView nameTextView = (TextView) findViewById(R.id.name1);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile !=null){
                    String username = userProfile.username;

                    nameTextView.setText("Welcome!, "+username);
                    nameTextView.setPaintFlags(nameTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Settings.this, "Something wrong happened", Toast.LENGTH_LONG).show();

            }
        });
    }
}