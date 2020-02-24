package model;


import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

// Represents a fitness plan with a description and a list of goals
public class FitnessPlan implements Saveable {
    private String fitnessplanname;
    ArrayList<Goal> fitnessplangoals;

    // EFFECTS: constructs an empty fitness plan
    public FitnessPlan() {
        fitnessplanname = null;
        fitnessplangoals = new ArrayList<Goal>();





    }

    // MODIFIES: this
    // EFFECTS: adds a goal unto the fitness plan
    public void addGoal(Goal goal) {
        fitnessplangoals.add(goal);

    }


    // EFFECTS: returns the name of the fitness plan
    public String getFitnessPlanName() {
        return fitnessplanname;

    }

    // MODIFIES: this
    // EFFECTS: changes the name of the fitness plan
    public void updateFitnessPlanName(String newname) {
        fitnessplanname = newname;

    }

    // EFFECTS: returns the list of goal names
    public String getGoals() {

        String mygoal = "";



        for (Goal in : fitnessplangoals) {
            int placement = fitnessplangoals.indexOf(in);
            Goal mygoalname = fitnessplangoals.get(placement);
            mygoal = mygoal + mygoalname.getDescription() + "\n";



            placement++;





        }

        return mygoal;





    }

    // EFFECTS: returns the number of goals within the plan
    public int getTotalNumberOfGoals() {
        return fitnessplangoals.size();
    }

    // REQUIRES: a non empty goal list
    // MODIFIES: this
    // EFFECTS: removes the goal that has a specific date
    public void getGoalThatHasDateOf(String date) {
        for (Goal in : fitnessplangoals) {
            int placement = fitnessplangoals.indexOf(in);
            Goal mygoal = fitnessplangoals.get(placement);
            if (mygoal.getDate() == date) {
                fitnessplangoals.remove(mygoal);

            }

        }




    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(fitnessplanname);
        printWriter.print(fitnessplangoals);

    }
}
