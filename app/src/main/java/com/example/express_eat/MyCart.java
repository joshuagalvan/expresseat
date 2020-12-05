package com.example.express_eat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.express_eat.adapter.CartAdapter;
import com.example.express_eat.database.DatabaseHelper;
import com.example.express_eat.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;

    int images[];
    List<Food> foodArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        images = new int[]{R.drawable.exeatlogo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,
                R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,R.drawable.expresseat_logo,};

        DatabaseHelper db = new DatabaseHelper(this);
        sqLiteDatabase = db.getReadableDatabase();
        Button add = (Button) findViewById(R.id.addtocart);
        Button proceed = (Button) findViewById(R.id.proceedbtn);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCart.this, Summary.class);
                startActivity(intent);
            }
        });


        List<Food> foodList = db.getAllFood();
        for(Food food: foodList) {
            foodArrayList.add(food);
        }

        Log.d("Size", String.valueOf(foodArrayList.size()));
        recyclerView = findViewById(R.id.cartrecyler);
        CartAdapter myAdapter = new CartAdapter(this, foodArrayList, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (myAdapter.getItemCount() == 0)
        {
            setContentView(R.layout.activity_my_order_empty);
        }
    }
}