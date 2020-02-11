package model;

import java.util.ArrayList;

// Represents a list of exercises done throughout the day
public class Exercises {
    ArrayList<Exercise> exerciselist;



    // EFFECTS: constructs and empty exercise
    public Exercises() {
        exerciselist = new ArrayList<Exercise>();

    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the list of exercises
    public void addExercise(Exercise exercise) {
        exerciselist.add(exercise);

    }
    // EFFECTS: returns the number of exercises

    public int getTotalNumberOfExercises() {
        return exerciselist.size();


    }

    // EFFECTS: returns the list of exercises
    public ArrayList<Exercise> getExercises() {
        return exerciselist;

    }




}
