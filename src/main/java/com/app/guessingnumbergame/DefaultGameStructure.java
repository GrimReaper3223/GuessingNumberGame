
package com.app.guessingnumbergame;

import java.util.Random;
/**
 * Class that contains the entire basic structure of a game. 
 * Any gameplay-related errors must be resolved here.
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since 2.0_BETA;
 */
public class DefaultGameStructure {
    
    //default instances
    Random random;
    
    //default variables
    String userChoiceYesOrNo;
    int userGuessScanner;
    
    private int randomGenerated;
    
    private int origin;     //stores the limits in case the user decides to play again
    private int bound;      //stores the limits in case the user decides to play again
    
    
    //class constructor
    public DefaultGameStructure() {
        random = new Random();
    };
    
    
    //set random number method
    public void setRandomNumber(int origin, int bound) {
        
        randomGenerated = random.nextInt(origin, bound) + 1;
        
        this.origin = origin;
        this.bound = bound;
        
        inputTreatment();
    };
    
    
    //fault handling
    private void inputTreatment() {
        
        System.out.print("Enter a number between "+ origin +" and "+ bound +": ");
        userGuessScanner = Assets.scanner.scannerInt();
        
        if(userGuessScanner > bound) {
            System.out.println("\nError: Input exceeds the maximum limit generated (> " + bound + "). Try again...\n");
            inputTreatment();
        } else if(userGuessScanner < origin) {
            System.out.println("\nError: Error: Input exceeds the minimum limit generated (< " + origin + "). Try again...\n");
            inputTreatment();
        } else {
            isCorrect();
        }
    };
    
    
    //assertiveness check
    private void isCorrect() {
        
        if(userGuessScanner > randomGenerated) {
            System.out.println("Try a lower value...");
            inputTreatment();
        } else if(userGuessScanner < randomGenerated) {
            System.out.println("Try a higher value...");
            inputTreatment();
        } else {
            System.out.println("\nCongratulations! You're right! The correct number is " + randomGenerated + ";");
            restartGame();
        }
    };
    
    
    //checks if the user wants to restart the game or go to the menu
    private void restartGame() {
        System.out.print("\nDo you want to play again? (Y/n) \n\n>> ");
        userChoiceYesOrNo = Assets.scanner.scannerString();
        
        switch (userChoiceYesOrNo.toLowerCase()) {
            case "y": 
                System.out.println("\nRestarting game...\n");
                setRandomNumber(this.origin, this.bound);
                break;
                
            case "n": 
                System.out.println("\nGoing to menu...");
                Assets.menu.mainMenu();
                break;
        }
    }
};
