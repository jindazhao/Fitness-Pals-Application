package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    Food blueberries;

    @BeforeEach
    void runBefore() {
        blueberries = new Food("Blueberries", 3, 30);

    }

    @Test
    void testGetters() {
        assertEquals("Blueberries", blueberries.getFoodName());
        assertEquals(3, blueberries.getFoodQuant());
        assertEquals(30, blueberries.getFoodCalories());


    }
}
