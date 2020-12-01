package com.example.express_eat;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Restaurant extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout slide_show_panel;
    private Button home, offer, cart;
    private CardView mcdo, jollibee, burgerking, popeyes,wendys,dominos;
    private ImageView settings;
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

        Slideshow getStartedOnboarding = new Slideshow(this);
        dot_count = getStartedOnboarding.getCount();
        dots = new ImageView[dot_count];

        for (int i = 0; i < dot_count; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(10, 0, 10, 0);

            slide_show_panel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dot_count; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }
    public void  openCart(){
        Intent intent = new Intent(this, MyCart.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openOffers(){
        Intent intent = new Intent(this, Offers.class);
        startActivity(intent);

    }
    public void return_to_restaurants(){
        Intent intent = new Intent(this, Restaurant.class);
        startActivity(intent);
    }
    public void openMcdo(){
        Intent intent = new Intent(this, McdonaldsMenu.class);
        startActivity(intent);

    }
    public void openJollibee(){
        Intent intent = new Intent(this, JollibeeMenu.class);
        startActivity(intent);

    }
    public void openWendys(){
        Intent intent = new Intent(this, WendysMenu.class);
        startActivity(intent);

    }
    public void openBurgerKing(){
        Intent intent = new Intent(this, BurgerKingMenu.class);
        startActivity(intent);

    }
    public void openPopeyes(){
        Intent intent = new Intent(this, PopeyesMenu.class);
        startActivity(intent);

    }
    public void openDominos(){
        Intent intent = new Intent(this, DominosMenu.class);
        startActivity(intent);

    }


    // Main Method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        home = (Button) findViewById(R.id.home_icon);
        cart = (Button) findViewById(R.id.cart_icon);
        offer = (Button) findViewById(R.id.offers_icon);
        settings = (ImageView) findViewById(R.id.menu_icon);
        mcdo = (CardView) findViewById(R.id.crd_mcdo) ;
        jollibee = (CardView) findViewById(R.id.crd_jollibee) ;
        burgerking = (CardView) findViewById(R.id.crd_burgerking) ;
        popeyes = (CardView) findViewById(R.id.crd_popeyes) ;
        wendys = (CardView) findViewById(R.id.crd_wendys) ;
        dominos = (CardView) findViewById(R.id.crd_dominos) ;
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                return_to_restaurants();
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openCart();
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOffers();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
        mcdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMcdo();
            }
        });
        jollibee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJollibee();
            }
        });
        burgerking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBurgerKing();
            }
        });
        popeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopeyes();
            }
        });
        wendys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWendys();
            }
        });
        dominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDominos();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.Slideshow);
        slide_show_panel = (LinearLayout) findViewById(R.id.DotIndicators);
        Slideshow restaurant_slideshow = new Slideshow(this);
        viewPager.setAdapter(restaurant_slideshow);
        automaticSlideshow();
        indicator();
    }
}