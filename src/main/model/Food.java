package model;

// Represents a food with a given name, quantity, and calories
public class Food {
    private String foodname;
    private double foodquant;
    private double foodcalories;

    // EFFECTS: constructs a food item with name, quantity, and calories
    public Food(String foodname, double foodquant, double foodcalories) {
        this.foodname = foodname;
        this.foodquant = foodquant;
        this.foodcalories = foodcalories;

    }
    // EFFECTS: returns name of food

    public String getFoodName() {
        return foodname;

    }
    // EFFECTS: returns quantity of food

    public double getFoodQuant() {
        return foodquant;

    }
    // EFFECTS: returns calories in food

    public double getFoodCalories() {
        return foodcalories;

    }






}

