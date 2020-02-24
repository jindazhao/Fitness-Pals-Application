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
    public static final String DELIMITER = ",";
    public static final Goal GOAL = null;

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<FitnessPlan> readFitnessPlan(File file) throws IOException {
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
    private static List<FitnessPlan> parseContent(List<String> fileContent) {
        List<FitnessPlan> fitnessplans = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            fitnessplans.add(parseFitnessPlan(lineComponents));

        }

        return fitnessplans;
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
    private static FitnessPlan parseFitnessPlan(List<String> components) {
        String fitnessplanname = components.get(0);
        String goalname = components.get(1);



        return new FitnessPlan();


    }











}
