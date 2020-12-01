package com.example.express_eat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDisplay extends AppCompatActivity {

    ImageView displayimage;
    TextView displayname, displayprice;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);

        displayimage = findViewById(R.id.displayimage);
        displayname = findViewById(R.id.displayname);
        displayprice = findViewById(R.id.displayprice);

        getData();
        setData();

    }

    private void getData()
    {
        if(getIntent().hasExtra("images") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2"))
        {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("images", 1);
        }else
            {
                Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
            }
    }

    private void setData()
    {
        displayname.setText(data1);
        displayprice.setText("₱"+ data2 + ".00");
        displayimage.setImageResource(myImage);
    }

}