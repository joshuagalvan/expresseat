package com.example.express_eat.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.express_eat.R;
import com.example.express_eat.database.DatabaseHelper;
import com.example.express_eat.model.Food;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    List<Food> foodList;
    //int images[];
    Context context;

    public CartAdapter(Context ctx, List<Food> food /*,int [] images*/){
        context = ctx;
        //this.images = images;
        foodList = food;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cartholder, parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") final int position){
        Food food = foodList.get(position);
        holder.foodText.setText(food.getFoodName());
        holder.foodPrice.setText("₱" + food.getFoodPrice()+ ".00");

        //holder.foodImage.setImageResource(images[food.getFoodImage()]);
    }

    @Override
    public int getItemCount(){
        return foodList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        Button delete;
        TextView foodText,foodPrice;
        ElegantNumberButton btn_quantity;

        public CartViewHolder(@NonNull View itemView){
            super(itemView);
            foodImage = itemView.findViewById(R.id.cartimage);
            foodText = itemView.findViewById(R.id.cartname);
            foodPrice = itemView.findViewById(R.id.cartprice);
            delete = itemView.findViewById(R.id.cartremove);
            btn_quantity = itemView.findViewById(R.id.numberbutton);

            delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    Food food = foodList.get(position);
                    DatabaseHelper db = new DatabaseHelper(context);
                    db.deleteFood(food.getId());
                    foodList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
