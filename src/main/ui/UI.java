package ui;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import model.Corgi;
import model.Exercise;
import model.FitnessPlan;
import model.Goal;
import persistence.Reader;
import persistence.Writer;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class UI extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField field;
    private  BoxLayout boxLayout;
    private static final String FITNESSPLANS_File = "./data/fitnessplan.txt";
    private FitnessPlan fitnessPlan;
    private String fitnessPlanName;
    private JPanel menuPanel;
    private JPanel viewPanel;
    private JPanel goalPanel;
    private JPanel updatePanel;
    private JPanel removePanel;
    private Goal myGoal;

    private JTextField text0;
    private JTextField text1;
    private JTextField text3;
    private JTextField text4;
    private JTextField text5;

    private JTextField label1;
    private JTextField field2;

    private Corgi corgi;



    public UI() {
        super("Fitness Pals");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 700));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        menuPanel = new JPanel();
        fitnessPlan = new FitnessPlan();
        add(menuPanel);
        boxLayout = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
        menuPanel.setLayout(boxLayout);
        JButton btn1 = new JButton("View  Your  Fitness  Plan  Goals");
        JButton btn2 = new JButton("Update Your Fitness Plan Name");
        JButton btn3 = new JButton("Add  Goal  to  Your  Fitness Plan");
        JButton btn4 = new JButton("Check  off  a  Goal  in  Your Plan");
        JButton btn5 = new JButton("Save   your   Goals   to   text  file");
        JButton btn7 = new JButton("Load  your  saved   Fitness  Plan");

        setButtonsCommands(btn1, btn2, btn3, btn4, btn5, btn7);



//        btn1.setActionCommand("View Your Fitness Plan");
//        btn1.addActionListener(this); // Sets "this" object as an action listener for btn
//        btn2.setActionCommand("Update Your Fitness Plan Name");
//        btn2.addActionListener(this); // Sets "this" object as an action listener for btn
//        btn3.setActionCommand("Add a Goal");
//        btn3.addActionListener(this); // Sets "this" object as an action listener for btn
//        btn4.setActionCommand("Check off a Goal");
//        btn4.addActionListener(this); // Sets "this" object as an action listener for btn
//        btn5.setActionCommand("Save your Fitness Plan");
//        btn5.addActionListener(this); // Sets "this" object as an action listener for btn
//        btn7.setActionCommand("Load Fitness Plan");
//        btn7.addActionListener(this);
        // so that when the btn is clicked,
        // this.actionPerformed(ActionEvent e) will be called.
        // You could also set a different object, if you wanted
        // a different object to respond to the button click

        JLabel jlabel = new JLabel("FITNESS PALS");
        JLabel label2 = new JLabel();
        doJLabelSettings(jlabel, label2);

        addButtonsToMenu(btn1, btn2, btn3);
        addButtonsToMenu(btn4, btn5, btn7);
        makePanels();
        menuPanel.setVisible(true);
    }

    public void doJLabelSettings(JLabel jlabel, JLabel label2) {
        jlabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        label2.setIcon(new ImageIcon("./data/61MdczSfPqL._AC_SL1500_.jpg"));
        label2.setMinimumSize(new Dimension(20,20));
        menuPanel.add(jlabel);
        menuPanel.add(label2);


    }

    public void setButtonsCommands(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn7) {
        btn1.setActionCommand("View Your Fitness Plan");
        btn1.addActionListener(this); // Sets "this" object as an action listener for btn
        btn2.setActionCommand("Update Your Fitness Plan Name");
        btn2.addActionListener(this); // Sets "this" object as an action listener for btn
        btn3.setActionCommand("Add a Goal");
        btn3.addActionListener(this); // Sets "this" object as an action listener for btn
        btn4.setActionCommand("Check off a Goal");
        btn4.addActionListener(this); // Sets "this" object as an action listener for btn
        btn5.setActionCommand("Save your Fitness Plan");
        btn5.addActionListener(this); // Sets "this" object as an action listener for btn
        btn7.setActionCommand("Load Fitness Plan");
        btn7.addActionListener(this);

    }

    public void makePanels() {
        makeViewFitnessPanel();
        makeUpdateFitnessPlaPanel();
        makeAddAGoalPanel();
        makeRemoveAGoalPanel();
    }

    public void addButtonsToMenu(JButton b1, JButton b2, JButton b3) {
        menuPanel.add(b1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        menuPanel.add(b2);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        menuPanel.add(b3);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


    }

    private void loadFitnessPlans() {
        try {
            fitnessPlan  = Reader.readFitnessPlan(new File(FITNESSPLANS_File));
            label.setText("Your Plan Name is: " + fitnessPlan.getFitnessPlanName());
            label1.setText("Your Fitness Goals: " + fitnessPlan.getGoals());
        } catch (IOException e) {
            fitnessPlan = new FitnessPlan();
        }

    }


    private void saveFitnessPlan() {
        try {
            Writer writer = new Writer(new File(FITNESSPLANS_File));
            writer.write(fitnessPlan);
            writer.close();
            System.out.println("Accounts saved to file" + FITNESSPLANS_File);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save fitness plans to" + FITNESSPLANS_File);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("View Your Fitness Plan")) {
            playSound("./data/Dog sound effect woof.wav");
            viewFitnessPlan();
        } else if (e.getActionCommand().equals("Update Your Fitness Plan Name")) {
            //playSound("./data/Dog sound effect woof.wav");
            updateFitnessPlanName();
        } else if (e.getActionCommand().equals("Add a Goal")) {
           // playSound("./data/Dog sound effect woof.wav");
            addGoalToFitnessPlan();
        } else if (e.getActionCommand().equals("Check off a Goal")) {
            //playSound("./data/Dog sound effect woof.wav");
            takeAwayAGoal();
        } else if (e.getActionCommand().equals("Save your Fitness Plan")) {
            //playSound("./data/Dog sound effect woof.wav");
            saveFitnessPlan();
        } else if (e.getActionCommand().equals("Back to Menu")) {
            backToMenu();
        } else if (e.getActionCommand().equals("Load Fitness Plan")) {
            //playSound("./data/Dog sound effect woof.wav");
            loadFitnessPlans();
        } else if (e.getActionCommand().equals("Update Your Name")) {
            doUpdateName();
        } else if (e.getActionCommand().equals("Add Goal")) {
            playSound("./data/Kids Cheering - Gaming Sound Effect (HD).wav");
            doAction();
        } else if (e.getActionCommand().equals("Check off as Complete!")) {
            doCompleteGoal();
        }
    }

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound");
            ex.printStackTrace();
        }
    }

    public void doCompleteGoal() {
        fitnessPlan.getGoalThatHasDate(field2.getText()).setDone();
    }

    public void doUpdateName() {
        fitnessPlanName = field.getText();
        fitnessPlan.updateFitnessPlanName(fitnessPlanName);
        label.setText("Your Plan Name is: " + fitnessPlan.getFitnessPlanName());
    }

    public void doAction() {
        Exercise exercise = new Exercise(text3.getText(), Double.parseDouble(text4.getText()),
                Double.parseDouble(text5.getText()));
        myGoal = new Goal(text0.getText(), text1.getText(), exercise);
        fitnessPlan.addGoal(myGoal);
        label1.setText("Your Fitness Goals: " + fitnessPlan.getGoals() + "\n");

    }



    public void makeViewFitnessPanel() {
        viewPanel = new JPanel();

        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("./data/512x512bb.jpg"));
        jl.setMinimumSize(new Dimension(800,400));


        boxLayout = new BoxLayout(viewPanel, BoxLayout.Y_AXIS);
        viewPanel.setLayout(boxLayout);
        label = new JLabel("Your Plan Name is: " + fitnessPlan.getFitnessPlanName());
        label1 = new JTextField("Your Fitness Goals: " + fitnessPlan.getGoals());
        label.setFont(new Font("SansSerif", Font.PLAIN, 25));
        label1.setFont(new Font("SansSerif", Font.PLAIN, 18));


        JLabel label2 = new JLabel("Your Fitness Pal: ");
        label2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        JButton menuButton = new JButton("Back to Menu");
        menuButton.setActionCommand("Back to Menu");
        menuButton.addActionListener(this);
        viewPanel.add(label);
        viewPanel.add(label1);
        viewPanel.add(label2);
        viewPanel.add(jl);
        viewPanel.add(menuButton);


    }

    public void makeUpdateFitnessPlaPanel() {
        updatePanel = new JPanel();
        boxLayout = new BoxLayout(updatePanel, BoxLayout.Y_AXIS);
        updatePanel.setLayout(boxLayout);
        JButton menuButton = new JButton("Back to Menu");
        menuButton.setActionCommand("Back to Menu");
        menuButton.addActionListener(this);
        JButton btn2 = new JButton("Update Your Name");
        btn2.setActionCommand("Update Your Name");
        btn2.addActionListener(this);
        field = new JTextField(5);
        field.setMaximumSize(new Dimension(500, 25));
        JLabel label2 = new JLabel(new ImageIcon("./data/516-5169666_kawaii-"
                + "cute-anime-shiba-dog-puppy-kawaii-cute.png"));
        label2.setMinimumSize(new Dimension(21, 2));


        JLabel label = new JLabel("Please type in your new Fitness Plan Name: ");
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        updatePanel.add(label);
        updatePanel.add(field);
        updatePanel.add(btn2);
        updatePanel.add(label2);
        updatePanel.add(menuButton);
    }

    public void makeAddAGoalPanel() {
        goalPanel = new JPanel();
        boxLayout = new BoxLayout(goalPanel, BoxLayout.Y_AXIS);
        goalPanel.setLayout(boxLayout);
        JButton menuButton = new JButton("Back to Menu");
        menuButton.setActionCommand("Back to Menu");
        menuButton.addActionListener(this);
        JButton btn = new JButton("Add Goal");
        btn.setActionCommand("Add Goal");
        btn.addActionListener(this);
        JLabel label0 = new JLabel("Please type in the name of your new goal:");
        text0 = new JTextField(5);
        JLabel label1 = new JLabel("Please type in the date that your will complete your goal by:");
        text1 = new JTextField(5);
        JLabel label3 = new JLabel("Please type in the name if your exercise:");
        text3 = new JTextField(5);
        JLabel label4 = new JLabel("Please type in the the target calories you want to burn from this exercise:");
        text4 = new JTextField(5);
        JLabel label5 = new JLabel("Please type in the target duration of the exercise in minutes:");
        text5 = new JTextField(5);
//        label0.setFont(new Font("SansSerif", Font.BOLD, 15));
//        label1.setFont(new Font("SansSerif", Font.BOLD, 15));
//        label3.setFont(new Font("SansSerif", Font.BOLD, 15));
//        label4.setFont(new Font("SansSerif", Font.BOLD, 15));
//        label5.setFont(new Font("SansSerif", Font.BOLD, 15));
        setAllFont(label0, label1, label3, label4, label5);
        setMaxTextSize(text0, text1, text3, text4, text5);
//        text0.setMaximumSize(new Dimension(1200, 40));
//        text1.setMaximumSize(new Dimension(1200, 40));
//        text3.setMaximumSize(new Dimension(1200, 40));
//        text4.setMaximumSize(new Dimension(1200, 40));
//        text5.setMaximumSize(new Dimension(1200, 40));
        addAllToGoalPanel(label0, text0, label1, text1, label3, text3, label4, text4, label5, text5, btn, menuButton);

//        goalPanel.add(label0);
//        goalPanel.add(text0);
//        goalPanel.add(label1);
//        goalPanel.add(text1);
//        goalPanel.add(label3);
//        goalPanel.add(text3);
//        goalPanel.add(label4);
//        goalPanel.add(text4);
//        goalPanel.add(label5);
//        goalPanel.add(text5);
//        goalPanel.add(btn);
//        goalPanel.add(menuButton);
    }

    public void setAllFont(JLabel l1, JLabel l2, JLabel l3, JLabel l4, JLabel l5) {
        l1.setFont(new Font("SansSerif", Font.BOLD, 15));
        l2.setFont(new Font("SansSerif", Font.BOLD, 15));
        l3.setFont(new Font("SansSerif", Font.BOLD, 15));
        l4.setFont(new Font("SansSerif", Font.BOLD, 15));
        l5.setFont(new Font("SansSerif", Font.BOLD, 15));

    }

    public void setMaxTextSize(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {
        t1.setMaximumSize(new Dimension(1200, 40));
        t2.setMaximumSize(new Dimension(1200, 40));
        t3.setMaximumSize(new Dimension(1200, 40));
        t4.setMaximumSize(new Dimension(1200, 40));
        t5.setMaximumSize(new Dimension(1200, 40));
    }

    public void addAllToGoalPanel(JLabel l1, JTextField t1,
                                  JLabel l2, JTextField t2, JLabel l3, JTextField t3,
                                  JLabel l4, JTextField t4, JLabel l5, JTextField t5,
                                  JButton b1, JButton b2) {
        goalPanel.add(l1);
        goalPanel.add(t1);
        goalPanel.add(l2);
        goalPanel.add(t2);
        goalPanel.add(l3);
        goalPanel.add(t3);
        goalPanel.add(l4);
        goalPanel.add(t4);
        goalPanel.add(l5);
        goalPanel.add(t5);
        goalPanel.add(b1);
        goalPanel.add(b2);



    }



    public void makeRemoveAGoalPanel() {
        removePanel = new JPanel();
        boxLayout = new BoxLayout(removePanel, BoxLayout.Y_AXIS);
        removePanel.setLayout(boxLayout);
        JButton menuButton = new JButton("Back to Menu");
        menuButton.setActionCommand("Back to Menu");
        menuButton.addActionListener(this);
        JButton btnr = new JButton("Check off as Complete!");
        btnr.setActionCommand("Check off as Complete!");
        btnr.addActionListener(this);
        JLabel label = new JLabel("Please enter the date in dd/mm/yyyy of the goal you would like ot check off: ");
        field2 = new JTextField(5);
        removePanel.add(label);
        removePanel.add(field2);
        removePanel.add(btnr);
        removePanel.add(menuButton);
    }

    public void viewFitnessPlan() {
        add(viewPanel);
        menuPanel.setVisible(false);
        goalPanel.setVisible(false);
        updatePanel.setVisible(false);
        removePanel.setVisible(false);
        viewPanel.setVisible(true);
    }

    public void updateFitnessPlanName() {
        add(updatePanel);
        menuPanel.setVisible(false);
        viewPanel.setVisible(false);
        removePanel.setVisible(false);
        goalPanel.setVisible(false);
        updatePanel.setVisible(true);
    }

    public void addGoalToFitnessPlan() {
        add(goalPanel);
        menuPanel.setVisible(false);
        viewPanel.setVisible(false);
        removePanel.setVisible(false);
        updatePanel.setVisible(false);
        goalPanel.setVisible(true);
    }

    public void takeAwayAGoal() {
        add(removePanel);
        viewPanel.setVisible(false);
        removePanel.setVisible(false);
        updatePanel.setVisible(false);
        menuPanel.setVisible(false);
        removePanel.setVisible(true);
    }

    public void backToMenu() {
        viewPanel.setVisible(false);
        updatePanel.setVisible(false);
        goalPanel.setVisible(false);
        goalPanel.setVisible(false);
        menuPanel.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
