package com.example.express_eat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Dominos_Food extends AppCompatActivity {
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

            case "pizza":
                name = getResources().getStringArray(R.array.dominospizza);
                price = getResources().getStringArray(R.array.dominospizzaprices);
                image =new int[] {R.drawable.pepperoniizza,R.drawable.vegetarianizza,R.drawable.cheeseania,
                        R.drawable.ham_and_cheese,R.drawable.hawaiianlassic,};
                break;
            case "drinks":
                name = getResources().getStringArray(R.array.dominosdrinks);
                price = getResources().getStringArray(R.array.dominosdrinksprices);
                image = new int[] {R.drawable.cola,R.drawable.sprite1_5,R.drawable.sprite_,
                        R.drawable.lycheeea,R.drawable.realifepple};
                break;
            case "pasta":
                name = getResources().getStringArray(R.array.dominospasta);
                price = getResources().getStringArray(R.array.dominospastaprices);
                image =new int[] {R.drawable.cheesy_baked_macaroni,R.drawable.italianausagearinara,
                                    R.drawable.chicken_carbonara,};
                break;
            case "others":
                name = getResources().getStringArray(R.array.dominosothers);
                price = getResources().getStringArray(R.array.dominoothersprices);
                image = new int[] {R.drawable.fried_chicken,R.drawable.cheesy_chips,
                        R.drawable.garlic_bread,R.drawable.calzone_solo_italian_sausage,
                        R.drawable.potato_wedges,R.drawable.loadededgesheesyacon,};

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