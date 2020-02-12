package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// Fitness Pals Application
public class FitnessPalsApp {
    private FitnessPlan fitnessplan;
    private Goal mygoal;
    private Scanner input;

    // EFFECTS: runs the fitness app
    public FitnessPalsApp() {
        fitnessplan = new FitnessPlan();
        runFitnessPalsApp();


    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runFitnessPalsApp() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);


        while (keepGoing) {
            displayMenu();
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

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View Your Fitness Plan");
        System.out.println("\tu -> Update Your Fitness Plan Name");
        System.out.println("\ta -> Add a Goal to Your Fitness Plan");
        System.out.println("\tr -> Remove a goal from you Fitness Plan");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command taken from fitness app
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewFitnessPlan();
        } else if (command.equals("u")) {
            updateFitnessPlanName();
        } else if (command.equals("q")) {
            addNutrients();
        } else if (command.equals("a")) {
            addGoalToFitnessPlan();
        } else if (command.equals("r")) {
            takeAwayAGoal();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // EFFECTS: allows user to view current fitness plan
    private void viewFitnessPlan() {

        if (fitnessplan.getGoals().equals("")) {
            System.out.println(fitnessplan.getFitnessPlanName());
            System.out.println("No Goals added yet");
        } else {

            System.out.println(fitnessplan.getFitnessPlanName());
            System.out.println(fitnessplan.getGoals());
        }



    }

    // MODIFIES: this
    // EFFECTS: changes the name of the plan
    private void updateFitnessPlanName() {
        String fitnessplanname = "";
        System.out.println("Please input your new name");
        fitnessplanname = input.next();
        fitnessplan.updateFitnessPlanName(fitnessplanname);
        System.out.println("Fitness Plan Name is" +  " " + fitnessplanname);



    }

    // EFFECTS: takes the goal away from the fitness plan with a given date
    private void takeAwayAGoal() {

        String removedgoal = "";

        System.out.println("What is the date of the goal you would like to remove from your fitness plan?");
        removedgoal = input.next();

        fitnessplan.getGoalThatHasDateOf(removedgoal);

        System.out.println("Goal from" + " " + removedgoal + " " + "has been removed from your fitness plan!");







    }

    // MODIFIES: this
    // EFFECTS: adds a new goal to fitness plan
    private void addGoalToFitnessPlan() {



        fitnessplan.addGoal(makeNewGoal());

    }

    // EFFECTS:  makes a new goal with goal name, date, target calorie burn, target sleep, foods consumed, exercises,
    //          nutrition
    private Goal makeNewGoal() {

        String goalname = "";


        System.out.println("Please type in the name of your new goal");
        goalname = input.next();
        System.out.println("Goal name is:" + " " + goalname);



        String goaldate = "";

        System.out.println("Please type in the date in form dd/mm/yyyy completed by");
        goaldate = input.next();
        System.out.println("Goal is due by: " + " " + goaldate);




        double targetcalories = -1;

        System.out.println("Please enter the amount of calories you want to burn");
        targetcalories = input.nextDouble();




        double targetsleep = -1;

        System.out.println("Please enter the amount of sleep you want the night before");
        targetsleep = input.nextDouble();


        mygoal = new Goal(goalname, goaldate, addExercises(), targetcalories, addFoods(), addNutrients(), targetsleep);

        return mygoal;

    }

    // EFFECTS: make and add foods onto a foods list
    private Foods addFoods() {

        Foods myfoodlist = new Foods();



        String foodname = "";


        System.out.println("Please type in description of food");
        foodname = input.next();
        System.out.println(foodname);



        double foodquant = -1;


        System.out.println("Please type in the amount of food");
        foodquant = input.nextDouble();
        System.out.println(foodquant);




        double foodcal = -1;

        System.out.println("Please type in the amount of calories");
        foodcal =  input.nextDouble();
        System.out.println(foodcal);



        Food myfood = new Food(foodname, foodquant, foodcal);

        myfoodlist.addFood(myfood);

        return myfoodlist;




    }

    // EFFECTS:  makes and adds a new exercise onto an exercise list
    private Exercises addExercises() {



        Exercises myexerciselist = new Exercises();



        String exercisename = "";


        System.out.println("Please type in description of exercise");
        exercisename = input.next();
        System.out.println(exercisename);



        double exercisecalsburned = -1;


        System.out.println("Please type in the amount of calories burned");
        exercisecalsburned = input.nextDouble();
        System.out.println(exercisecalsburned);




        double exercisetime = -1;

        System.out.println("Please type in the duration of the exercise");
        exercisetime =  input.nextDouble();
        System.out.println(exercisetime);



        Exercise myexercise = new Exercise(exercisename, exercisecalsburned, exercisetime);

        myexerciselist.addExercise(myexercise);

        return myexerciselist;





    }

    // EFFECTS:  makes and adds nutrients onto a nutrient list
    private Nutrients addNutrients() {


        Nutrients mynutrientlist = new Nutrients();




        String nutrientname = "";


        System.out.println("Please type in name of nutrient");
        nutrientname = input.next();
        System.out.println(nutrientname);



        double nutrientquant = -1;


        System.out.println("Please type in the amount of nutrients consumed in percentage of daily intake");
        nutrientquant = input.nextDouble();
        System.out.println(nutrientquant);





        Nutrient mynutrient = new Nutrient(nutrientname, nutrientquant);

        mynutrientlist.addNutrient(mynutrient);

        return mynutrientlist;

    }



}
