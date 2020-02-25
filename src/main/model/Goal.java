package model;

import java.util.ArrayList;

// EFFECTS: Represents a goal having a description, a list of exercises wanting to do, number of calories want to burn,
//           a list of foods to consume, a list of nutrients want to consume, and the amount of sleep want the night
//           before
public class Goal {
    private String description;
    private String date; // has to be in the form dd/mm/yyyy
    private Exercise exercise;

    // EFFECTS: constructs a goal with a description, due date, and exercise
    public Goal(String description, String date, Exercise exercise) {
        this.description = description;
        this.date = date;
        this.exercise = exercise;
    }

    // EFFECTS: returns description of the goal
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns date of the goal
    public String getDate() {
        return date;
    }

    // EFFECTS: returns the exercise name as a string
    public String getGoalExerciseName() {
        return exercise.getExerciseName();
    }

    // EFFECTS: returns the number of calories burned as a double
    public Double getExerciseCalories() {
        return exercise.getCaloriesBurned();
    }

    // EFFECTS: returns the duration as a double
    public Double getExerciseDuration() {
        return exercise.getExerciseTime();
    }
}
