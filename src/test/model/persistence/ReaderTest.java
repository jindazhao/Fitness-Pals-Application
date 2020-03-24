package model.persistence;

import model.FitnessPlan;
import model.NoNameExecption;
import org.junit.jupiter.api.Test;
import persistence.Reader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    @Test
    void testParseFitnessFile1() {
        Reader reader = new Reader();
        try {
            FitnessPlan fitnessPlan = Reader.readFitnessPlan(new File("./data/testFitnessPlan.txt"));
            assertEquals("My Fitness Plan", fitnessPlan.getFitnessPlanName());
            assertEquals(2, fitnessPlan.getTotalNumberOfGoals());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } catch (NoNameExecption noNameExecption) {
            noNameExecption.printStackTrace();
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
