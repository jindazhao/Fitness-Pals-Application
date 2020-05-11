package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessPlanTest {

    FitnessPlan myfitnessplan;
    Goal mysecondgoal;
    Goal myfirstgoal;
    Exercise crunches;
    Exercise planks;

    @BeforeEach
    void runBefore() {
        myfitnessplan = new FitnessPlan();

        crunches = new Exercise("Crunches", 100, 10);
        planks = new Exercise("Planks", 100, 10);

        myfirstgoal = new Goal("Lose Weight", "01/01/2020", crunches, false);
        mysecondgoal = new Goal("Lose More Weight and Get More Sleep", "01/02/2020", planks, false);
    }

    @Test
    void testConstructor() {
        try {
            assertEquals(null, myfitnessplan.getFitnessPlanName());
        } catch (NoNameExecption noNameExecption) {
            noNameExecption.printStackTrace();

        }
        assertEquals(0, myfitnessplan.getTotalNumberOfGoals());
    }

    @Test
    void testAddOneGoalAndCatchException() {

        myfitnessplan.addGoal(myfirstgoal);
        myfitnessplan.updateFitnessPlanName("Lose Weight");

        try {
            assertEquals("Lose Weight", myfitnessplan.getFitnessPlanName() );
        } catch (NoNameExecption noNameExecption) {
            noNameExecption.printStackTrace();
        }
        assertEquals(1, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose Weight: 01/01/2020 Crunches 100.0 10.0\n", myfitnessplan.getGoals());
    }

    @Test
    void testAddMultipleGoalsAndNoExceptionThrown() {
        myfitnessplan.updateFitnessPlanName("Lose Weight");
        myfitnessplan.addGoal(myfirstgoal);
        myfitnessplan.addGoal(mysecondgoal);
        assertEquals(mysecondgoal, myfitnessplan.getGoalThatHasDate("01/02/2020"));


        try {
            assertEquals("Lose Weight", myfitnessplan.getFitnessPlanName());
        } catch (NoNameExecption noNameExecption) {
            fail("Failed");
        }
        assertEquals(2, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose Weight: 01/01/2020 Crunches 100.0 10.0\n" +
                "Lose More Weight and Get More Sleep: 01/02/2020 Planks 100.0 10.0\n", myfitnessplan.getGoals());

        myfitnessplan.getGoalThatHasDateOf("01/01/2020");

        assertEquals(1, myfitnessplan.getTotalNumberOfGoals());
        assertEquals("Lose More Weight and Get More Sleep: 01/02/2020 Planks 100.0 10.0\n",
                myfitnessplan.getGoals());

        myfitnessplan.getGoalThatHasDateOf("03/03/2019");
        assertEquals(1, myfitnessplan.getTotalNumberOfGoals());

        myfitnessplan.complete(myfirstgoal);
        assertEquals(true,myfirstgoal.getCompleted());
    }
}


