package com.example.express_eat.model;

public class Food {
    private int id;
    private String foodName;
    private String foodPrice;
    //private int foodImage;

    public Food() {

    }

    public Food(String foodName, String foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Food(int id, String foodName, String foodPrice) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    /*public Food(int id, String foodName, String foodPrice, int foodImage) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }


    /*public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public int getFoodImage() {
        return foodImage;
    }*/
}

