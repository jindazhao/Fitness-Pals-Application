package model;


// Represents an exercise containing the name, calories burned, and the time
public class Exercise {
    private String exercisename;
    private double caloriesburned;
    private double exercisetime;



    // EFFECTS: constructs an exercise with a description and the calories burned per minute
    public Exercise(String exercisename, double caloriesburned, double exercisetime) {
        this.exercisename = exercisename;
        this.caloriesburned = caloriesburned;
        this.exercisetime = exercisetime;


    }

    // EFFECTS: returns description of exercise
    public String getExerciseName() {
        return exercisename;

    }

    // EFFECTS: returns caloriesburned per minute of exercise
    public double getCaloriesBurned() {
        return caloriesburned;

    }

    // EFFECTS: returns the amount of time of the exercise
    public double getExerciseTime() {
        return exercisetime;

    }




}
