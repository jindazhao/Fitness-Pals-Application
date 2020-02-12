package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoalTest {


    Goal mysecondgoal;
    Goal myfirstgoal;
    Foods myfoods;
    Food banana;
    Food apple;
    Nutrients mynutrients;
    Nutrient vitaminB;
    Nutrient vitaminC;
    Exercises myexercises;
    Exercise crunches;
    Exercise planks;



    @BeforeEach
    void runBefore() {

        myfoods = new Foods();
        banana = new Food("Banana", 2, 10);
        apple = new Food("Apple", 3, 10);
        mynutrients = new Nutrients();
        vitaminB = new Nutrient("Vitamin B", 30);
        vitaminC = new Nutrient("Vitamin C", 40);
        myexercises = new Exercises();
        crunches = new Exercise("Crunches", 100, 10);
        planks = new Exercise("Planks", 100, 10);

        myfirstgoal = new Goal("Lose Weight", "01/01/2020", myexercises,
                1500, myfoods, mynutrients, 120 );
        mysecondgoal = new Goal("Lose More Weight and Get More Sleep", "01/02/2020", myexercises,
                2000, myfoods, mynutrients, 300 );

    }



    @Test
    void testGetters() {
        assertEquals("Lose Weight", myfirstgoal.getDescription());
        assertEquals("01/01/2020", myfirstgoal.getDate());


    }





}
