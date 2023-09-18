package com.app.guessingnumbergame;

/**
 * class that serves solely to change the game's difficulty level
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since class 2.0_BETA;
 *      \
 *       @since level funcionality: 1.0_BETA;
 */
public class Difficulty {
    
    //default variables
    int userDifficultyScanner;
    static String difficultySet = "[Easy]";     //By default, the game difficulty is easy.
    
    
    //set difficulty method
    public void difficulty() {
        System.out.println("\f\n---Difficulty Menu---\f");
        System.out.println("\nPlease select the desired difficulty level:\n");
        System.out.print("(1) - Easy; \n(2) - Intermediary; \n(3) - Hard; \n(4) - Veteran; \n(5) - Custom; \n(6) - Go to menu;\n\n>> ");
        
        userDifficultyScanner = Assets.scanner.scannerInt();
        
        switch (userDifficultyScanner) {
                
            //easy
            case 1 -> {
                difficultySet = "[Easy]";
                System.out.println("\nDifficulty 'Easy' successfully selected");
                System.out.println("Going to menu...");
                Assets.menu.mainMenu();
                break;
            }
            
            //intermediary
            case 2 -> {
                difficultySet = "[Intermediary]";
                System.out.println("\nDifficulty 'Intermediary' successfully selected");
                System.out.println("Going to menu...");
                Assets.menu.mainMenu();
                break;
            }
            
            //hard
            case 3 -> {
                difficultySet = "[Hard]";
                System.out.println("\nDifficulty 'Hard' successfully selected");
                System.out.println("Going to menu...");
                Assets.menu.mainMenu();
                break;
            }
            
            //veteran
            case 4 -> {
                difficultySet = "[Veteran]";
                System.out.println("\nDifficulty 'Veteran' successfully selected");
                System.out.println("Going to menu...");
                Assets.menu.mainMenu();
                break;
            }
            
            //custom - Don't forget to configure the level limits if this difficulty is selected
            case 5 -> {
                difficultySet = "[Custom]";
                System.out.println("\nDifficulty 'Custom' successfully selected");
                System.out.println("*** 'Custom' difficulty detected. Please don't forget to configure the numerical generation limits in the settings before continuing ***");
                System.out.println("Going to menu...");
                Assets.menu.mainMenu();
                break;
            }
            
            //go to menu
            case 6 -> {
                System.out.println("\nGoing to menu...");
                Assets.menu.mainMenu();
                break;
            }
        }
    }
}
