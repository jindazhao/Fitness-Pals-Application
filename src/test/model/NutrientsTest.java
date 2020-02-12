package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NutrientsTest {

    Nutrients mynutrients;
    Nutrient vitaminB;
    Nutrient vitaminC;


    @BeforeEach
    void runBefore() {

        mynutrients = new Nutrients();
        vitaminB = new Nutrient("Vitamin B", 30);
        vitaminC = new Nutrient("Vitamin C", 40);



    }

    @Test
    void testConstructor() {
        assertEquals(0, mynutrients.getTotalNumberOfNutrients());

    }

    @Test
    void testAddOneNutrient() {
        mynutrients.addNutrient(vitaminB);
        assertEquals(1, mynutrients.getTotalNumberOfNutrients());

    }

    @Test
    void testAddMultipleNutrients() {
        mynutrients.addNutrient(vitaminB);
        mynutrients.addNutrient(vitaminC);
        assertEquals(2, mynutrients.getTotalNumberOfNutrients());
        assertEquals(mynutrients, mynutrients.getNutrients());

    }

}
