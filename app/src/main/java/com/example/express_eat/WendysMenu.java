package com.example.express_eat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WendysMenu extends AppCompatActivity implements View.OnClickListener {

    Button burger, drinks, fambox, whattabox, btn_five;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);

        layout = findViewById(R.id.layout_food);
        burger = findViewById(R.id.btn_food_one);
        drinks = findViewById(R.id.btn_food_two);
        fambox = findViewById(R.id.btn_food_three);
        whattabox = findViewById(R.id.btn_food_four);
        btn_five = findViewById(R.id.btn_food_five);

        burger.setText("Burgers");
        drinks.setText("Drinks");
        fambox.setText("Fambox");
        whattabox.setText("Whattabox");
        btn_five.setVisibility(View.GONE);
        layout.setBackgroundResource(R.drawable.wendys_food_bg);

        burger.setOnClickListener(this);
        drinks.setOnClickListener(this);
        fambox.setOnClickListener(this);
        whattabox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Wendys_Food.class);
        switch (v.getId()) {
            case R.id.btn_food_one:
                intent.putExtra("CATEGORY", "burger");
                break;
            case R.id.btn_food_two:
                intent.putExtra("CATEGORY", "drinks");
                break;
            case R.id.btn_food_three:
                intent.putExtra("CATEGORY", "fambox");
                break;
            case R.id.btn_food_four:
                intent.putExtra("CATEGORY", "whattabox");
                break;
        }
        startActivity(intent);

    }
}