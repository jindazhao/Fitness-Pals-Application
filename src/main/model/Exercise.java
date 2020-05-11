package model;


// Represents an exercise containing the name, calories burned, and the time
public class Exercise {
    private String exerciseName;
    private double caloriesBurned;
    private double exerciseTime;

    // EFFECTS: constructs an exercise with a description and the calories burned per minute
    public Exercise(String exercisename, double caloriesburned, double exercisetime) {
        this.exerciseName = exercisename;
        this.caloriesBurned = caloriesburned;
        this.exerciseTime = exercisetime;
    }

    // EFFECTS: returns description of exercise
    public String getExerciseName() {
        return exerciseName;
    }

    // EFFECTS: returns caloriesburned per minute of exercise
    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    // EFFECTS: returns the amount of time of the exercise
    public double getExerciseTime() {
        return exerciseTime;
    }


}
