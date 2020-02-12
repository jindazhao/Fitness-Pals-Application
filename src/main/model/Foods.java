package model;

import java.util.ArrayList;

// Represents a list of foods
public class Foods {
    ArrayList<Food> foodlist;


    // EFFECTS: constructs an empty list of foods
    public Foods() {
        foodlist = new ArrayList<Food>();



    }

    // MODIFIES: this
    // EFFECTS: adds a food onto food list
    public void addFood(Food item) {
        foodlist.add(item);

    }

    // EFFECTS: returns total number of foods
    public int getTotalNumberOfFoods() {
        return foodlist.size();

    }





}
