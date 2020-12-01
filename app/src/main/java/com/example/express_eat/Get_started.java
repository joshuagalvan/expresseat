package com.example.express_eat;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Get_started extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout slide_show_panel;
    private Button login;
    private TextView create_acount;
    private int dot_count;
    private int current_position = 0;
    private Timer timer;
    private ImageView[] dots;


    public void automaticSlideshow() {


        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (current_position == dot_count)
                    current_position = 0;

                viewPager.setCurrentItem(current_position++, true);


            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 250, 2500);

    }

    private void indicator() {

        slideshow_design getStartedOnboarding = new slideshow_design(this);
        dot_count = getStartedOnboarding.getCount();
        dots = new ImageView[dot_count];

        for (int i = 0; i < dot_count; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.startpage_nonactive_dot_indicator));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(10, 0, 10, 0);

            slide_show_panel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.startpage_active_dot_indicator));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dot_count; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.startpage_nonactive_dot_indicator));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.startpage_active_dot_indicator));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }
    public void openLogIN(){

        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);

    }
    public void openRegister(){

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    // Main Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        login = (Button) findViewById(R.id.login);
        create_acount = (TextView) findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openLogIN();
            }
        });
        create_acount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
        viewPager = (ViewPager) findViewById(R.id.Slideshow);
        slide_show_panel = (LinearLayout) findViewById(R.id.DotIndicators);
        slideshow_design slideshow_design = new slideshow_design(this);
        viewPager.setAdapter(slideshow_design);
        automaticSlideshow();
        indicator();

    }
}