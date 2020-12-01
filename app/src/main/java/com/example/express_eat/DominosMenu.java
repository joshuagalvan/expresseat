package com.example.express_eat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DominosMenu extends AppCompatActivity implements View.OnClickListener {
    Button others, drinks, pasta, pizza, btn_five;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);
        layout = findViewById(R.id.layout_food);
        others = findViewById(R.id.btn_food_one);
        drinks = findViewById(R.id.btn_food_two);
        pasta = findViewById(R.id.btn_food_three);
        pizza = findViewById(R.id.btn_food_four);
        btn_five = findViewById(R.id.btn_food_five);

        others.setText("Others");
        drinks.setText("Drinks");
        pasta.setText("Pasta");
        pizza.setText("Pizza");
        btn_five.setVisibility(View.GONE);
        layout.setBackgroundResource(R.drawable.dominos_food_bg);

        others.setOnClickListener(this);
        drinks.setOnClickListener(this);
        pasta.setOnClickListener(this);
        pizza.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Dominos_Food.class);
        switch(v.getId()){
            case R.id.btn_food_one:
                intent.putExtra("CATEGORY", "others");
                break;
            case R.id.btn_food_two:
                intent.putExtra("CATEGORY", "drinks");
                break;
            case R.id.btn_food_three:
                intent.putExtra("CATEGORY", "pasta");
                break;
            case R.id.btn_food_four:
                intent.putExtra("CATEGORY", "pizza");
                break;
        }
        startActivity(intent);


    }
}