package ui;

import model.FitnessPlan;

import java.util.Scanner;

// Fitness Pals Application
public class FitnessPalsApp {
    private FitnessPlan fitnessPlan;
    private Scanner input;

    public class FitnessPlanApp() {
        runFitnessPalsApp();
    }

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
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\ts -> save accounts to file");
        System.out.println("\tp -> print to screen");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("d")) {
            doDeposit();
        } else if (command.equals("w")) {
            doWithdrawal();
        } else if (command.equals("t")) {
            doTransfer();
        } else if (command.equals("s")) {
            saveAccounts();
        } else if (command.equals("p")) {
            printAccount();
        } else {
            System.out.println("Selection not valid...");
        }
    }




}
