package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodsTest {

    Foods myfoods;
    Food banana;
    Food apple;




    @BeforeEach
    void runBefore() {

        myfoods = new Foods();
        banana = new Food("Banana", 2, 10);
        apple = new Food("Apple", 3, 10);
    }

    @Test
    void testConstructor() {
        assertEquals(0, myfoods.getTotalNumberOfFoods());

    }

    @Test
    void testAddOneFood() {
        myfoods.addFood(banana);
        assertEquals(1, myfoods.getTotalNumberOfFoods());

    }

    @Test
    void testAddMultipleFoods() {
        myfoods.addFood(banana);
        myfoods.addFood(apple);
        myfoods.addFood(banana);
        assertEquals(3, myfoods.getTotalNumberOfFoods());

    }



}
