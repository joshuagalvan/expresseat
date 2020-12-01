package com.example.express_eat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class BurgerKing_Food extends AppCompatActivity {
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
                name = getResources().getStringArray(R.array.burgerkingburgers);
                price = getResources().getStringArray(R.array.burgerkingburgersprices);
                image = new int[] {R.drawable.angryhopper,R.drawable.angryhopperjrr,R.drawable.fourheesehoppereal,
                        R.drawable.whopper, R.drawable.pepperoni_bacon_whopper_jr_};
                break;
            case "specials":
                name = getResources().getStringArray(R.array.burgerkingspecials);
                price = getResources().getStringArray(R.array.burgerkingspecialsprices);
                image = new int[] {R.drawable.doubleaconingjreall,R.drawable.singlebaconkingjrmeal,
                        R.drawable.doublebbqbaconingreal, R.drawable.single_bacon_king};
                break;
            case "drinks":
                name = getResources().getStringArray(R.array.burgerkingdrinks);
                price = getResources().getStringArray(R.array.burgerkingdrinksprices);
                image = new int[] {R.drawable.cola,R.drawable.minute_maid_orange,R.drawable.bottled_water};
                break;
        }
        cart = findViewById(R.id.cart_icon);
        home = findViewById(R.id.home_icon);
        offer = findViewById(R.id.offers_icon);
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