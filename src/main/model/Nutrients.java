package model;

import java.util.ArrayList;

// EFFECTS: Represents a list of nutrients
public class Nutrients {
    ArrayList<Nutrient> nutrientlist;



    // EFFECTS: constructs an empty nutrient list
    public Nutrients() {
        nutrientlist = new ArrayList<Nutrient>();

    }

    // MODIFIES: this
    // EFFECTS: adds a nutrient onto the nutrient list
    public void addNutrient(Nutrient nutrient) {
        nutrientlist.add(nutrient);

    }

    // EFFECTS: returns the total number of nutrients
    public int getTotalNumberOfNutrients() {
        return nutrientlist.size();

    }

    // EFFECTS: returns the list of nutrients
    public ArrayList<Nutrient> getNutrients() {
        return nutrientlist;

    }





}
