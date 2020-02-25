package model.persistence;

import model.FitnessPlan;
import org.junit.jupiter.api.Test;
import persistence.Reader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    @Test
    void testParseFitnessFile1() {
        try {
            FitnessPlan fitnessPlan = Reader.readFitnessPlan(new File("./data/testFitnessPlanFile1.txt"));
            assertEquals("My Fitness Plan", fitnessPlan.getFitnessPlanName());
            assertEquals(1, fitnessPlan.getTotalNumberOfGoals());


        } catch (IOException e) {
            fail("IOEception should have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readFitnessPlan(new File("./path/does/not/exist/textFitnessPlan.txt"));
        } catch (IOException e) {
            // expected
        }
    }

}
