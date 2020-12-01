package com.example.express_eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.express_eat.database.DatabaseHelper;
import com.example.express_eat.model.Food;

import java.util.List;

public class Summary extends AppCompatActivity {

    TextView totalprice, totalwithdelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Button send = (Button) findViewById(R.id.sendorder);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RGroup);

        DatabaseHelper db = new DatabaseHelper(this);
        totalprice = findViewById(R.id.subtotal);
        totalwithdelivery = findViewById(R.id.total);
        int feewithdelivery = 0;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Summary.this, OrderDone.class);
                startActivity(intent);
            }
        });

        int total = 0;
        List<Food> cart = db.getAllFood();
        for(Food food: cart) {
            total += (Integer.parseInt(food.getFoodPrice()));
        }


        totalprice.setText("₱" + String.valueOf(total) + ".00");

        feewithdelivery = total + 30;

        totalwithdelivery.setText("₱" + String.valueOf(feewithdelivery) + ".00");
    }
}