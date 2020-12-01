package com.example.express_eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Offers extends AppCompatActivity {

    private Button home, offer, cart;

    public void  openCart(){
        Intent intent = new Intent(this, MyCart.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        cart = findViewById(R.id.cart_icon);
        home =  findViewById(R.id.home_icon);
        offer =  findViewById(R.id.offers_icon);
        cart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openCart();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                return_to_restaurants();
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOffers();
            }
        });


    }
}