package com.example.express_eat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Popeyes_Food extends AppCompatActivity {

    RecyclerView recyclerView;
    String name[],price[];
    int image[];
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
        setContentView(R.layout.activity_foods_per_restaurant);
        String category = getIntent().getStringExtra("CATEGORY");
        switch(category){
            case "burger":
                name = getResources().getStringArray(R.array.popeyesburgers);
                price = getResources().getStringArray(R.array.popeyesburgersprices);
                image = new int[] {R.drawable.chicken_french_quarter,R.drawable.spicy_chicken_sandwich,
                        R.drawable.fishurger, R.drawable.u_s__spicy_chicken_sandwich,R.drawable.chicken_burger};
                break;
            case "combo":
                name = getResources().getStringArray(R.array.popeyescombodeals);
                price = getResources().getStringArray(R.array.popeyescombodealsprices);
                image = new int[] {R.drawable.sixpcsundleaa,R.drawable.twelve_pieces,
                        R.drawable.two_pieces_chicken___rice___drink, R.drawable.one_pc_chicken___rice___drink,};
                break;
            case "fries":
                name = getResources().getStringArray(R.array.popeyesfries);
                price = getResources().getStringArray(R.array.popeyesfriesprices);
                image =new int[] {R.drawable.regular_fries,R.drawable.cheeseries};
                break;
            case "drinks":
                name = getResources().getStringArray(R.array.popeyesdrinks);
                price = getResources().getStringArray(R.array.popeyesdrinksprices);
                image =new int[] {R.drawable.cola,R.drawable.sprite_,R.drawable.bottled_water,
                        R.drawable.dr_pepper};
                break;
        }
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

        recyclerView = findViewById(R.id.recyclerView);
        FoodAdapter foodAdapter = new FoodAdapter(this, name, price, image);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}