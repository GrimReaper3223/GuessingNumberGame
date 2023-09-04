/*
 * Copyright (C) 2023 deiv
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.app.guessingnumbergame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * File that will receive the parameters passed according to the selected game difficulty
 * 
 * @author deiv;
 * @version 2.0_BETA;
 */
public class DefaultLevelStructure {
    
    // instantiating the user MenuInterface class, Scanner, and Random
    private Random random;
    private Scanner scan;
    
    // instantiating user choice and randomized number
    private int generatedNumber;
    private int receivedUserNumber;
    
    // these variables will be responsible for showing information about the game's 
    // settings to the sectors that need it.
    private int origin;
    private int bound;
    
    // control flow variable
    private boolean validData = false;
    
    
    
    // basic constructor for better understanding of the code
    public DefaultLevelStructure() {
        this.random = new Random();
        this.scan = new Scanner(System.in);
    }
    
    /**
     * generating a random integer between origin and bound
     * 
     * @param origin receives configured values from the MenuInterface class according to the chosen level
     * @param bound receives configured values from the MenuInterface class according to the chosen level
     */
    public void randomize(int origin, int bound) {
        
        //assign parameter values to class variables
        this.origin = origin;
        this.bound = bound;
        
        generatedNumber = random.nextInt(origin, bound) + 1;
        
        scanner();
    };
    
    
    /**
    * Exception handling...
    *
    * If the user enters a number 
    * outside the scope of the code, 
    * it will be treated as an InputMismatchException
    *
    * @exception that can be generated at this point
    * @throws InputMismatchException;
    * 
    * @see the validData variable. it is a control boolean that becomes true 
    * when the user hits the number, making the while loop condition true once 
    * it is programmed to run while it is false, allowing the code to exit this 
    * loop and proceed to the last method
    * 
    * @since user input is wrong, it will be forced to go through this overflow
    * handling to avoid possible bugs
    */
    private void scanner() {
        
        /*
        * error message database
        *
        * These error messages should be initialized here in the 
        * input of this method
        */
        String[] exceptionsMsgBank = {
            "Number exceeds the limit ( > "+ bound +");",
            "Number is less than limit ( < "+ origin +");",
            "Enter only numbers!",
            "Enter a valid answer!",
        };
        
        //Checking data validity
        restartLabel:
        while(!validData) {
        
            try{

                System.out.print("\nEnter any number from "+ origin +" to "+ bound +" to guess which number was generated: ");
                receivedUserNumber = scan.nextInt();

                if(receivedUserNumber > bound) {
                    System.out.println(exceptionsMsgBank[0]);
                    continue restartLabel;

                } else if (receivedUserNumber < origin) {
                    System.out.println(exceptionsMsgBank[1]);
                    continue restartLabel;

                } else {
                    consoleMsgs();
                }

            } catch(InputMismatchException e) {
                System.out.println(exceptionsMsgBank[2]);
                scan.next();
                continue restartLabel;
            }
        }
    };
    
    /*
    * Checking entered number and providing hints 
    * based on randomly generated number
    */
    private void consoleMsgs() {
        
        if(receivedUserNumber > generatedNumber) {
            System.out.print("Try a smaller number...");
            scanner();
            
        } else if(receivedUserNumber < generatedNumber) {
            System.out.print("Try a bigger number...");
            scanner();
            
        } else if(receivedUserNumber == generatedNumber) {
            System.out.println("\nYou're right! Congratulations! The number that was generated was " + generatedNumber + ";\n");
            restartTheGame();
            validData = true;
        }
    };
    
    /**
     * if the user chooses to play a new game, the 'validData' control variable 
     * will return to its default value (false) and the 'randomize()' method 
     * will be called again. All data generated and stored later will be 
     * overwritten as the code progresses.
     * 
     * if the user decides not to play another game, the control variable 
     * (validData) will return to its default value (false). A 'main' object 
     * of the class file containing the user's menu will be instantiated 
     * temporarily. Then main will call the default home menu method.
     * 
     * @exception 'main' cannot be instantiated outside of the second case 
     * elsewhere in the code 
     * @throws if this is done, throws java.lang.StackOverFlowError;
     * 
     * @exception 'scan' must not be closed
     * @throws if closed, throws java.util.NoSuchElementException;
     */
    private void restartTheGame() {
        
        System.out.print("Do you want to play again? (y / n): ");
        String yesOrNo = scan.next();
        
        switch (yesOrNo.toLowerCase()) {
            
            case "y" -> {
                System.out.println("\nStarting a new game...");
                validData = false;
                randomize(origin, bound);
            }
            case "n" -> {
                System.out.println("\nGoing to main menu...\n");
                validData = false;
                MenuInterface main = new MenuInterface();
                main.mainMenu();
            }
            default -> restartTheGame();
        }
    }
};
