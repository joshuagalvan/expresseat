package com.example.express_eat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.express_eat.model.Food;
import com.example.express_eat.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.FOOD_NAME + " TEXT, " + Util.FOOD_PRICE + " INTEGER/*,*/ "  + /*Util.FOOD_IMAGE + " INTEGER " +*/")";
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        onCreate(db);
    }

    //Create
    public void addFood(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.FOOD_NAME, food.getFoodName());
        values.put(Util.FOOD_PRICE, food.getFoodPrice());
        //values.put(Util.FOOD_IMAGE, food.getFoodImage());

        db.insert(Util.TABLE_NAME, null, values);
        db.close();
    }

    //Read
    public List<Food> getAllFood(){
        ArrayList<Food> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME + " ORDER BY " + Util.KEY_ID + " DESC";
        Cursor cursor = db.rawQuery(selectAll, null);
        if(cursor.moveToFirst()){
            do{
                Food food = new Food();
                food.setId(cursor.getInt(0));
                food.setFoodName((cursor.getString(1)));
                food.setFoodPrice(cursor.getString(2));
                //food.setFoodImage(cursor.getInt(3));
                foodList.add(food);
            }
            while(cursor.moveToNext());
        }
        return foodList;
    }

    //Delete
    public void deleteFood(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
