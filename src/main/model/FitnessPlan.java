package model;


import java.util.ArrayList;

// Represents a fitness plan with a description and a list of goals
public class FitnessPlan {
    private String fitnessplanname;
    ArrayList<Goal> fitnessplan;

    // EFFECTS: constructs an a blank fitness plan
    public FitnessPlan() {
        fitnessplanname = null;
        fitnessplan = new ArrayList<Goal>();


    }

    // MODIFIES: this
    // EFFECTS: adds a goal unto the fitness plan
    public void addGoal(Goal goal) {
        fitnessplan.add(goal);

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

        for (Goal in : fitnessplan) {
            int placement = fitnessplan.indexOf(in);
            Goal mygoalname = fitnessplan.get(placement);
            mygoal = mygoal + mygoalname.getDescription() + "\n";



            placement++;





        }

        return mygoal;





    }

    // EFFECTS: returns the number of goals within the plan
    public int getTotalNumberOfGoals() {
        return fitnessplan.size();
    }

    // MODIFIES: this
    // EFFECTS: removes the goal that has a specific date
    public void getGoalThatHasDateOf(String date) {
        for (Goal in : fitnessplan) {
            int placement = fitnessplan.indexOf(in);
            Goal mygoal = fitnessplan.get(placement);
            if (mygoal.getDate() == date) {
                fitnessplan.remove(mygoal);

            }
        }




    }








}
