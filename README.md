# My Personal Project: Fitness Pals



This is a desktop application that will enhance motivation and become fit at the same time. The application allows the
to choose a fitness plan and alter the given plan based on the user's experience, needs, and goals. Everyday, there will
be a given goal for exercise, sleep, and nutrition. Every goal that is met each day, there is a feature that is added to
your pet's house, hence the name "Pals". In order to keep your pet happy and healthy, the goals must be met. 
This way, people can be stay fit and be motivated while also being able to track their progress in a fun and motivating
way.  

I am choosing this project because I like living a healthy lifestyle. However, it is very difficult at times because it 
is hard as seeing progress takes a long time. I wanted to find something that I could see physically getting better if I
hit my goal and this project combined my love for dogs and fitness. This way I can physically see that I am making
progress, keeping me motivated. This app is for people like me who want to stay motivated to be healthy but find it 
difficult as progress is hardly seen.



## Fitness

The fitness aspect of the app can contain many plans based on the user:

- Weight loss
- Healthy lifestyle choices
- Getting fit

These plans will be based on three aspects that will make up daily goals:

- Sleep
- Food, Calorie and nutrient consumption
- Exercise and calorie burned


## Pals

How the pets aspect works is that once a goal is hit, there will be an added feature to the the user's pet's house.
Every goal that is not hit will not take away any features, but over time, the more goals not met, the sadder the pets
will become.

**Hitting goals but not actually doing it will keep the pets happy, but the user will be cheating themselves**

##User Stories

- As a user, I want to be able to add my goal to my fitness plan
- As a user, I want to be able to add a name of my fitness plan and be able to view it as well
- As a user, I want to be able to add an exercise to a goal and then add the goal to the fitness plan
- As a user, I want to be able to add multiple goals to my fitness plan
- As a user, I want to be able to view the names of the goals added to my fitness plan

- As a user, I want to be able to save my fitness plan as an option when I quit my application
- As a user, I want to be able to load my fitness plan that I had saved when I open the application

# Instructions for Grader

Note: turn up your volume for some cool sound effects!

- Step 1: Run the GUI class and have a look at the documentation if you wish. When you first start the application up
you will find that it brings you to the menu screen with an image of a dog. 
- Step 2: In order to complete the first of the two required adding an X to  Y, in my application you can add a name to 
the fitness plan. By doing so you will be satisfying this requirement. To do so, please view click on the view button
and notice how the name is null. Go back to the menu and click on the "Update Your Fitness Plan Name" button and type in
a name. After, there is a button right underneath to update the name. After clicking that button, please head back to 
view your fitness plan and notice how the name has been updated. 
- Step 3: In order to complete second of two required events, in my application, you can add an exercise to a goal and 
add multiple goals to the fitness plan. Please first view the fitness plan and notice how the goals list is empty. 
In the menu, click on the
add a goal button and fill out the required areas. Please note that whenever asking for number, please type in as
integers or doubles and when asking for the date type in the format "dd/mm/yyyy". After that there is a button to add 
the goals. Finally, view the new goal that has been added to 
your plan by heading back to the menu and viewing it. You can repeat this process multiple times as you wish. 
Note that the way I have the user view their goals is in a
JTextField. This will change in the next phase as I will try to improve my GUI. 
- Step 4: There are a couple visual and a couple audio components. First the menu page has a image and as well as the 
updating your name page and viewing page. As well, you may have noticed that there were sounds effects when you clicked 
"View Fitness Plan" and when you clicked on the button inside the adding a goal page. The images will change to 
animations (hopefully) in the future phase. 
- Step 5: Save the fitness plan by clicking on the save button in the menu page. After, exit out the application by 
clicking the X at the top right corner. You can also check that it saves by going over to the directory and checking the 
"fitnessplan.txt" file. 
- Step 6: Run the GUI Class. First, view that the current fitness plan is empty/null, then go back and click load and 
then view the fitness plan again and notice how everything was loaded.

# Phase 4: Task 2

Option 1: Class: FitnessPlan Method: getFitnessPlan(); if there is no name fo the fitness plan then 
it will throw a checked exception. In GUI, ReaderTest, WriterTest, FitnessPlanTest, were all made more robust because of
this change:
Class/Method: FitnessPlan/getFitnessPlan(), GUI/loadFitnessPlan()/doUpdateName()/viewMakeFitnessPanel(), 
ReaderTest/testParseFitnessFile1(), WriterTest/testWriteFitnessPlan(), FitnessPlanTest/
testConstructorAndCatchException()
/textAddMultipleGoalsAndNoExceptionThrown();

Because I have made FitnessPlan: getFitnessPlan() more robust, the ones listed have also become more robust.

# Phase 4: Task 3

- First Change: There was poor cohesion and in my GUI class it ran and created a new GUI. This did not obey the single
responsibility and thus had poor cohesion. I refactored it so that in my Main Class I called a new GUI and had the GUI
only focus on creating a new GUI. 
- Second Change: In order to improve cohesion, I noticed that in my Goal Class I was checking something that was in my 
Corgi class and this violated the single responsibility principle as my Goal Class should only be concerned about the 
Goal class aspects. So I refactored the method setDone() and made changes to my Corgi class to check the preconditions
instead of having that method check the preconditions thus making is adhere to the single responsibility principle. 



       