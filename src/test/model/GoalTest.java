package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoalTest {

    Goal mysecondgoal;
    Goal myfirstgoal;

    Exercise crunches;
    Exercise planks;

    @BeforeEach
    void runBefore() {
        crunches = new Exercise("Crunches", 100, 10);
        planks = new Exercise("Planks", 100, 10);

        myfirstgoal = new Goal("Lose Weight", "01/01/2020", crunches, false);
        mysecondgoal = new Goal("Lose More Weight and Get More Sleep", "01/02/2020", planks, false);
    }

    @Test
    void testGetters() {
        assertEquals("Lose Weight", myfirstgoal.getDescription());
        assertEquals("01/01/2020", myfirstgoal.getDate());
        assertEquals("Crunches", myfirstgoal.getGoalExerciseName());
        assertEquals(100, myfirstgoal.getExerciseCalories());
        assertEquals(10, myfirstgoal.getExerciseDuration());
        assertEquals(false, myfirstgoal.getCompleted());
        myfirstgoal.setDone();
        assertEquals(true, myfirstgoal.getCompleted());
    }
}
