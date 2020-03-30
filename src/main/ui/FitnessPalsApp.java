package ui;

import model.*;
import persistence.Reader;
import persistence.Writer;

import java.io.*;
import java.util.Scanner;

// Fitness Pals Application inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public class FitnessPalsApp {
    private static final String FITNESSPLANS_File = "./data/fitnessplan.txt";
    private FitnessPlan fitnessPlan;
    private String fitnessPlanName;
    private Writer writer;
    private Reader reader;

    private Goal myGoal;
    private Scanner input;

    // EFFECTS: runs the fitness app
    public FitnessPalsApp() {
        fitnessPlan = new FitnessPlan();
        runFitnessPalsApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input, inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    //          class: TellerApp, method: runTellerApp
    private void runFitnessPalsApp() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        loadFitnessPlans();

        while (keepGoing) {
            displayMenu();
//            System.out.println("\n");
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: loads the fitness plan from fitness plan file, it that file exists,
    // otherwise initialize with default
    private void loadFitnessPlans() {
        try {
            reader = new Reader();
            fitnessPlan  = reader.readFitnessPlan(new File(FITNESSPLANS_File));
        } catch (IOException e) {
            fitnessPlan = new FitnessPlan();
        }
    }

    // EFFECTS: saves state of the fitness plan with the fitness plan name and list of goals
    private void saveFitnessPlan() {
        try {
            writer = new Writer(new File(FITNESSPLANS_File));
            writer.write(fitnessPlan);
            writer.close();
            System.out.println("Accounts saved to file" + FITNESSPLANS_File);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save fitness plans to" + FITNESSPLANS_File);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    // EFFECTS: displays menu of options to user, inspired by TellerApp
    //          https://github.students.cs.ubc.ca/CPSC210/TellerApp.git class: TellerApp, method: displayMenu()
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View Your Fitness Plan");
        System.out.println("\tu -> Update Your Fitness Plan Name");
        System.out.println("\ta -> Add a Goal to Your Fitness Plan");
        System.out.println("\tr -> Remove a goal from your Fitness Plan");
        System.out.println("\ts -> Save your Fitness Plan");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command taken from fitness app, inspired by TellerApp
    //          https://github.students.cs.ubc.ca/CPSC210/TellerApp.git class: TellerApp, method: processCommand()
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewFitnessPlan();
        } else if (command.equals("u")) {
            updateFitnessPlanName();
        } else if (command.equals("a")) {
            addGoalToFitnessPlan();
        } else if (command.equals("r")) {
            takeAwayAGoal();
        } else if (command.equals("s")) {
            saveFitnessPlan();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // EFFECTS: allows user to view current fitness plan
    private void viewFitnessPlan() {

        if (fitnessPlan.getGoals().equals("")) {
            try {
                System.out.println("Your Fitness Plan Name is:" + " " + fitnessPlan.getFitnessPlanName());
            } catch (NoNameExecption noNameExecption) {
                noNameExecption.printStackTrace();
            }
            System.out.println("No Goals added yet");
        } else {
            try {
                System.out.println("Your Fitness Plan Name is:" + " " + fitnessPlan.getFitnessPlanName());
            } catch (NoNameExecption noNameExecption) {
                noNameExecption.printStackTrace();
            }
            System.out.println("Your Fitness Goals:" + " " + fitnessPlan.getGoals());
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the name of the plan
    private void updateFitnessPlanName() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please input your new fitness plan name");

        fitnessPlanName = input.nextLine();

        fitnessPlan.updateFitnessPlanName(fitnessPlanName);

        System.out.println("Fitness Plan Name is:" +  " " + fitnessPlanName);
    }


    // EFFECTS: takes the goal away from the fitness plan with a given date
    private void takeAwayAGoal() {
        String removedgoal = "";

        System.out.println("What is the date of the goal you would like to remove from your fitness plan?");
        removedgoal = input.next();

        fitnessPlan.getGoalThatHasDateOf(removedgoal);

        System.out.println("Goal from" + " " + removedgoal + " " + "has been removed from your fitness plan!");
    }

    // MODIFIES: this
    // EFFECTS: adds a new goal to fitness plan
    private void addGoalToFitnessPlan() {
        fitnessPlan.addGoal(makeNewGoal());
    }

    // EFFECTS:  makes a new goal with goal name, date, and one exercise
    private Goal makeNewGoal() {
        String goalname = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Please type in the name of your new goal");
        goalname = input.nextLine();

        System.out.println("Goal name is:" + " " + goalname);
        String goaldate = "";

        System.out.println("Please type in the date in form dd/mm/yyyy completed by");
        goaldate = input.nextLine();

        System.out.println("Goal is due by: " + " " + goaldate);

        myGoal = new Goal(goalname, goaldate, addExercises());

        return myGoal;
    }


    // EFFECTS:  makes and adds a new exercise onto an exercise list
    private Exercise addExercises() {
        Scanner input = new Scanner(System.in);
        String exercisename = "";

        System.out.println("Please type in description of exercise");
        exercisename = input.nextLine();

        System.out.println(exercisename);
        double exercisecalsburned = -1;

        System.out.println("Please type in the amount of calories you want to burn");
        exercisecalsburned = input.nextDouble();

        System.out.println(exercisecalsburned);
        double exercisetime = -1;

        System.out.println("Please type in the target duration of the exercise");
        exercisetime =  input.nextDouble();

        System.out.println(exercisetime);

        Exercise myexercise = new Exercise(exercisename, exercisecalsburned, exercisetime);

        return myexercise;
    }
}
