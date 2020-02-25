package persistence;


import model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read fitness plan data from file
public class Reader {
    public static final String DELIMITER = ";";
    public static final Goal GOAL = null;

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static FitnessPlan readFitnessPlan(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // conatining the content of one row of file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of fitness plans parsed from list of Strings
    // where each string contains data for one fitness plan
    private static FitnessPlan parseContent(List<String> fileContent) {
        FitnessPlan fitnessPlan = new FitnessPlan();
        fitnessPlan.updateFitnessPlanName(fileContent.get(0));
        fileContent.remove(0);

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            fitnessPlan.addGoal(parseFitnessPlan(lineComponents));
        }
        return fitnessPlan;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 2 where element 0 represents the
    // fitness plan name of the next fitness plan to be constructed, element 1 represents
    // fitness plan name, and element 2 represent the list of goals of the fitness plan
    // to be constructed
    // EFFECTS: returns a fitness plan constructed from components
    private static Goal parseFitnessPlan(List<String> components) {
        Exercise exercise = new Exercise(components.get(2), Double.parseDouble(components.get(3)),
                Double.parseDouble(components.get(4)));
        Goal goal = new Goal(components.get(0), components.get(1), exercise);
        return goal;
    }
}
