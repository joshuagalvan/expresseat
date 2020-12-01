package com.example.express_eat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class start_page extends AppCompatActivity {

    private Button getStarted;
    private Animation scaleUP, scaleDOWN;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        scaleUP = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDOWN = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        getStarted = (Button) findViewById(R.id.started);

        getStarted.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openGetStartedPage();
            }
        });

    }
    public void openGetStartedPage() {

        Intent intent = new Intent(this, Get_started.class);
        startActivity(intent);

    }
}