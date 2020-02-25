package model.persistence;

import model.Exercise;
import model.FitnessPlan;
import model.Goal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testFitnessPlan.txt";
    private Writer testWriter;
    private FitnessPlan fitnessPlan;
    private Goal goal;
    private Goal goal2;
    private Exercise exercise;




    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        fitnessPlan = new FitnessPlan();
        exercise = new Exercise("Running", 100, 100);
        goal = new Goal("Lose Weight", "00/00/0000", exercise);
        exercise = new Exercise("Planks", 100, 100);
        goal2 = new Goal("Lose More Weight", "00/00/0000", exercise);


    }


    @Test
    void testWriteFitnessPlan() {

        fitnessPlan.addGoal(goal);
        fitnessPlan.addGoal(goal2);
        fitnessPlan.updateFitnessPlanName("My Fitness Plan");



        // save fitness name and list of goals
        testWriter.write(fitnessPlan);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
        try {
            FitnessPlan fitnessPlan = Reader.readFitnessPlan(new File(TEST_FILE));
            assertEquals("My Fitness Plan", fitnessPlan.getFitnessPlanName());
            assertEquals(2, fitnessPlan.getTotalNumberOfGoals());



        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }


    }


}
