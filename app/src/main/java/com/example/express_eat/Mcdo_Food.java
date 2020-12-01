package com.example.express_eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Mcdo_Food extends AppCompatActivity {

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_per_restaurant);

        String category = getIntent().getStringExtra("CATEGORY");
        switch(category){
            case "burger":
                name = getResources().getStringArray(R.array.mcdoburgers);
                price = getResources().getStringArray(R.array.mcdoburgerprices);
                image = new int[] {R.drawable.burgermcdoo,R.drawable.cheeseburgerr,
                        R.drawable.mcchickennn,R.drawable.cheessyburgermcdoo,
                        R.drawable.cheeseburger_deluxe,R.drawable.quarter_pounder_with_cheese,
                        R.drawable.doublebigmacc};
                break;
            case "fries":
                name = getResources().getStringArray(R.array.mcdofries);
                price = getResources().getStringArray(R.array.mcdofriesprices);
                image = new int[] {R.drawable.regularfriess,R.drawable.mediumfriess,
                        R.drawable.bfffriess,R.drawable.shakehakeriescheesee,R.drawable.shakehakeriesbbqq};
                break;
            case "drinks":
                name = getResources().getStringArray(R.array.mcdodrinks);
                price = getResources().getStringArray(R.array.mcdodrinksprices);
                image =new int[] {R.drawable.mcfloatttt,R.drawable.strawberryhakee,R.drawable.winterelonilkea};
                break;
            case "rice_meals":
                name = getResources().getStringArray(R.array.mcdoricemeals);
                price = getResources().getStringArray(R.array.mcdoricemealsprices);
                image = new int[] {R.drawable.chickenalaking,R.drawable.chickenfillett,
                        R.drawable.onepiecechickenn,R.drawable.twoieceshicken,R.drawable.chickenatsu,
                        R.drawable.onepieceushroomepperteak};
                break;
            case "desserts":
                name = getResources().getStringArray(R.array.mcdodesserts);
                price = getResources().getStringArray(R.array.mcdodessertsprices);
                image = new int[] {R.drawable.caramelsundae,R.drawable.chocolateundae,
                        R.drawable.coffee_mcflurry,R.drawable.mcflurryyy,};
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
