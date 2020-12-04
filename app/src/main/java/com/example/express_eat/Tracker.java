package com.example.express_eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;

public class Tracker extends AppCompatActivity {
    private Timer timer;
    int count = 0;
    private ImageView order_submitted, order_processed, order_prepared, order_deliver;
    private View v_order_confirmed,  v_order_placed, v_order_pickup, v_order_processed;
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

    public void timer() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {

                    try {
                        Thread.sleep(2000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                count++;

                                if (count == 1){
                                    v_order_placed.setBackground((getResources()
                                            .getDrawable(R.drawable.shape_status_completed)));
                                    order_submitted.setImageResource(R.drawable.order_submitted);
                                }
                                if (count == 5){
                                    v_order_confirmed.setBackground((getResources()
                                            .getDrawable(R.drawable.shape_status_completed)));
                                    order_processed.setImageResource(R.drawable.order_processed);
                                }
                                if (count == 10){
                                    v_order_processed.setBackground((getResources()
                                            .getDrawable(R.drawable.shape_status_completed)));
                                    order_prepared.setImageResource(R.drawable.order_being_prepared);
                                }
                                if (count == 15){
                                    v_order_pickup.setBackground((getResources()
                                            .getDrawable(R.drawable.shape_status_completed)));
                                    order_deliver.setImageResource(R.drawable.order_delivery);
                                }
                                if (count == 20)
                                {
                                    Toast.makeText(Tracker.this, "Your food has now arrived!" +
                                            "", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        order_submitted = findViewById(R.id.orderplaced);
        v_order_placed = findViewById(R.id.view_order_placed);

        order_processed = findViewById(R.id.img_orderconfirmed);
        v_order_confirmed = findViewById(R.id.view_order_confirmed);

        order_prepared = findViewById(R.id.orderprocessed);
        v_order_processed = findViewById(R.id.view_order_processed);

        order_deliver = findViewById(R.id.orderpickup);
        v_order_pickup = findViewById(R.id.view_order_pickup);

        timer();

        home =  findViewById(R.id.home_icon);


        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                return_to_restaurants();
            }
        });

    }
}
