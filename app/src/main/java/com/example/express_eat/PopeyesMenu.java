package com.example.express_eat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PopeyesMenu extends AppCompatActivity implements View.OnClickListener {

    Button burger, combo, fries, drinks, btn_five;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);

        layout = findViewById(R.id.layout_food);
        burger = findViewById(R.id.btn_food_one);
        combo = findViewById(R.id.btn_food_two);
        fries = findViewById(R.id.btn_food_three);
        drinks = findViewById(R.id.btn_food_four);
        btn_five = findViewById(R.id.btn_food_five);

        burger.setText("Burgers");
        combo.setText("Combo");
        fries.setText("Fries");
        drinks.setText("Drinks");
        btn_five.setVisibility(View.GONE);
        layout.setBackgroundResource(R.drawable.popeyes_food_bg);

        burger.setOnClickListener(this);
        combo.setOnClickListener(this);
        fries.setOnClickListener(this);
        drinks.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Popeyes_Food.class);
        switch(v.getId()){
            case R.id.btn_food_one:
                intent.putExtra("CATEGORY", "burger");
                break;
            case R.id.btn_food_two:
                intent.putExtra("CATEGORY", "combo");
                break;
            case R.id.btn_food_three:
                intent.putExtra("CATEGORY", "fries");
                break;
            case R.id.btn_food_four:
                intent.putExtra("CATEGORY", "drinks");
                break;
        }
        startActivity(intent);

    }
}