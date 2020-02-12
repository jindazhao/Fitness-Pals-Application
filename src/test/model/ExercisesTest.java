package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ExercisesTest {
    Exercises myexercises;
    Exercise crunches;
    Exercise planks;


    @BeforeEach
    void runBefore() {
        myexercises = new Exercises();
        crunches = new Exercise("Crunches", 100, 10);
        planks = new Exercise("Planks", 100, 10);
    }

    @Test
    void testConstructor() {
        assertEquals(0, myexercises.getTotalNumberOfExercises());

    }

    @Test
    void testAddOneExercise() {
        myexercises.addExercise(crunches);
        assertEquals(1, myexercises.getTotalNumberOfExercises());

    }

    @Test
    void testAddMultipleExercises() {
        myexercises.addExercise(crunches);
        myexercises.addExercise(planks);
        assertEquals(2, myexercises.getTotalNumberOfExercises());




    }




}
