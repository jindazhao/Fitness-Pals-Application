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

    //
    public String getGoalExerciseName() {
        return exercise.getExerciseName();
    }

    /*
    // EFFECTS: returns exercises of the goal

    public ArrayList<Exercise> viewExercises() {
        return exercises.getExercises();

    }

    // EFFECTS: returns the target calories of the goal
    public double viewTargetCaloriesBurned() {
        return targetcaloriesburned;

    }

    // EFFECTS: returns foods of the goal
    public ArrayList<Food> viewFoods() {
        return foods.getFoods();

    }

    // EFFECTS: returns nutrients of the goal
    public ArrayList<Nutrient> viewNutrients() {
        return nutrients.getNutrients();

    }

    // EFFECTS: returns target sleep  of the goal
    public double viewTargetSleep() {
        return targetsleep;

    }

    // MODIFIES: this
    // EFFECTS: adds a foods unto foods in goal
    public void addFoods(Food food) {
        foods.addFood(food);

    }
    // MODIFIES: this
    // EFFECTS: adds an exercise unto exercises in goal

    public void addExercise(Exercise exercise) {
        exercises.addExercise(exercise);
    }

    // MODIFIES: this
    // EFFECTS: adds calories unto target calories burned in goal
    public void addCalories(double calories) {
        targetcaloriesburned = targetcaloriesburned + calories;


    }

    // MODIFIES: this
    // EFFECTS: adds a nutrient unto nutrients in goal
    public void addNutrient(Nutrient nutrient) {
        nutrients.addNutrient(nutrient);
    }

    // MODIFIES: this
    // EFFECTS: adds sleep unto target sleep in goal
    public void addSleep(double sleep) {
        targetcaloriesburned = targetsleep + sleep;

    }
*/

}
