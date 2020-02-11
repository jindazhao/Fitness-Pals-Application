package model;

// EFFECTS: Represents a nutrient with a name and a quantity
public class Nutrient {
    private String nutrientname;
    private double nutrientquant;


    // EFFECTS: constructs a nutrient with a name and quantity
    public Nutrient(String nutrientname, double nutrientquant) {
        this.nutrientname = nutrientname;
        this.nutrientquant = nutrientquant;

    }

    // EFFECTS: returns the name of the nutrient
    public String getNutrientName() {
        return nutrientname;

    }

    // EFFECTS: returns the quantity of the nutrient
    public double getNutrientQuant() {
        return nutrientquant;

    }

}
