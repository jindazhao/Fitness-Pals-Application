package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {

    Exercise crunches;


    @BeforeEach
    void runBefore() {

        crunches = new Exercise("crunches", 100, 30);

    }

    @Test
    void testGetters() {
        assertEquals("crunches", crunches.getExerciseName());
        assertEquals(100, crunches.getCaloriesBurned());
        assertEquals(30, crunches.getExerciseTime());



    }


}
