package persistence;


import model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read fitness plan data from file
// reader class inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public class Reader {
    public static final String DELIMITER = ";";


    // EFFECTS: returns a fitness plan from a file
    // IOException if an exception is raised when opening / reading from file
    public static FitnessPlan readFitnessPlan(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a fitness plan
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

    // REQUIRES: a none empty list of strings containing the goal name, goal date, exercise name,
    // calories, and duration
    // EFFECTS: returns a goal from list of components
    private static Goal parseFitnessPlan(List<String> components) {
        Exercise exercise = new Exercise(components.get(2), Double.parseDouble(components.get(3)),
                Double.parseDouble(components.get(4)));
        Goal goal = new Goal(components.get(0), components.get(1), exercise);
        return goal;
    }
}
