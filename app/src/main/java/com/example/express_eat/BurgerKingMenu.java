package com.example.express_eat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BurgerKingMenu extends AppCompatActivity implements View.OnClickListener {

    Button burger, special, drinks, btn_four, btn_five;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);

        layout = findViewById(R.id.layout_food);

        burger = findViewById(R.id.btn_food_one);
        special = findViewById(R.id.btn_food_two);
        drinks = findViewById(R.id.btn_food_three);
        btn_four = findViewById(R.id.btn_food_four);
        btn_five = findViewById(R.id.btn_food_five);

        burger.setText("Burgers");
        special.setText("Specials");
        drinks.setText("Drinks");
        btn_four.setVisibility(View.GONE);
        btn_five.setVisibility(View.GONE);
        layout.setBackgroundResource(R.drawable.burgerking_food_bg);

        burger.setOnClickListener(this);
        special.setOnClickListener(this);
        drinks.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,BurgerKing_Food.class);
        switch(v.getId()){
            case R.id.btn_food_one:
                intent.putExtra("CATEGORY", "burger");
                break;
            case R.id.btn_food_two:
                intent.putExtra("CATEGORY", "specials");
                break;
            case R.id.btn_food_three:
                intent.putExtra("CATEGORY", "drinks");
                break;
        }
        startActivity(intent);
    }
}