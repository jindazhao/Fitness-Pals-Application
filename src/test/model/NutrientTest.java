package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NutrientTest {

    Nutrient vitaminb;


    @BeforeEach
    void runBefore() {
        vitaminb = new Nutrient("Vitamin-B", 40);

    }

    @Test
    void testGetters() {
        assertEquals("Vitamin-B", vitaminb.getNutrientName());
        assertEquals(40, vitaminb.getNutrientQuant());


    }
}
