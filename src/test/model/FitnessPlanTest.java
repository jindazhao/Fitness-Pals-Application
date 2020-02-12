package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessPlanTest {

    FitnessPlan myfitnessplan;
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
        myfitnessplan = new FitnessPlan();
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
    void testConstructor() {
        assertEquals(null, myfitnessplan.getFitnessPlanName());
        assertEquals(0, myfitnessplan.getTotalNumberOfGoals());


    }

    @Test
    void testAddOneGoal() {

        myfitnessplan.addGoal(myfirstgoal);
        myfitnessplan.updateFitnessPlanName("Lose Weight");
        assertEquals("Lose Weight", myfitnessplan.getFitnessPlanName() );
        assertEquals(1, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose Weight\n", myfitnessplan.getGoals());








    }

    @Test
    void testAddMultipleGoals() {
        myfitnessplan.updateFitnessPlanName("Lose Weight");
        myfitnessplan.addGoal(myfirstgoal);
        myfitnessplan.addGoal(mysecondgoal);
        assertEquals("Lose Weight", myfitnessplan.getFitnessPlanName());
        assertEquals(2, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose Weight\nLose More Weight and Get More Sleep\n", myfitnessplan.getGoals());
        myfitnessplan.getGoalThatHasDateOf("01/01/2020");
        assertEquals(1, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose More Weight and Get More Sleep\n", myfitnessplan.getGoals());




    }




}


