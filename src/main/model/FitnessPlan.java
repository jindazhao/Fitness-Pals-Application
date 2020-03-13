package model;

import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

// Represents a fitness plan with a description and a list of goals
public class FitnessPlan implements Saveable {
    private String fitnessPlanName;
    private ArrayList<Goal> fitnessPlanGoals;

    // EFFECTS: constructs an empty fitness plan
    public FitnessPlan() {
        fitnessPlanName = null;
        fitnessPlanGoals = new ArrayList<Goal>();
    }

    // MODIFIES: this
    // EFFECTS: adds a goal unto the fitness plan
    public void addGoal(Goal goal) {
        fitnessPlanGoals.add(goal);
    }

    // EFFECTS: returns the name of the fitness plan
    public String getFitnessPlanName() {
        return fitnessPlanName;
    }

    // MODIFIES: this
    // EFFECTS: changes the name of the fitness plan
    public void updateFitnessPlanName(String newname) {
        fitnessPlanName = newname;
    }

    // EFFECTS: returns the list of goal names
    public String getGoals() {
        String mygoal = "";
        for (Goal in : fitnessPlanGoals) {
            int placement = fitnessPlanGoals.indexOf(in);
            Goal mygoalname = fitnessPlanGoals.get(placement);
            mygoal = mygoal + mygoalname.getDescription() + ":" + " " + mygoalname.getDate()
                    + " " + mygoalname.getGoalExerciseName()
                    + " " + mygoalname.getExerciseCalories() + " " + mygoalname.getExerciseDuration() + "\n";
            placement++;
        }
        return mygoal;
    }

    // EFFECTS: returns the number of goals within the plan
    public int getTotalNumberOfGoals() {
        return fitnessPlanGoals.size();
    }

    // REQUIRES: a non empty goal list
    // MODIFIES: this
    // EFFECTS: removes the goal that has a specific date
    public void getGoalThatHasDateOf(String date) {
        for (Goal in : fitnessPlanGoals) {
            int placement = fitnessPlanGoals.indexOf(in);
            Goal mygoal = fitnessPlanGoals.get(placement);
            if (mygoal.getDate() == date) {
                fitnessPlanGoals.remove(mygoal);
            }
        }
    }

    public Goal getGoalThatHasDate(String date) {
        Goal mygoal = null;
        for (Goal in : fitnessPlanGoals) {
            int placement = fitnessPlanGoals.indexOf(in);
            mygoal = fitnessPlanGoals.get(placement);
            if (mygoal.getDate() == date) {
                return mygoal;
            }
        }
        return mygoal;
    }

    // EFFECTS: Prints all the components of the plan to a txt file
    // inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(fitnessPlanName);
        printWriter.print("\n");

        for (Goal i : fitnessPlanGoals) {
            printWriter.print(i.getDescription());
            printWriter.print(";");
            printWriter.print(i.getDate());
            printWriter.print(";");
            printWriter.print(i.getGoalExerciseName());
            printWriter.print(";");
            printWriter.print(i.getExerciseCalories());
            printWriter.print(";");
            printWriter.print(i.getExerciseDuration());
            printWriter.print("\n");
        }
    }

    public void complete(Goal goal) {
        goal.setDone();

    }
}
