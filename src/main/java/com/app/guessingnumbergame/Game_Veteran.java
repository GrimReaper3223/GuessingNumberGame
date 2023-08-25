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
 *
 * @author deiv;
 * @version 1.0_BETA;
 * 
 * game mechanics structure based on veteran level
 * the structure of this file can be used to generate 
 * other more difficult and customizable levels
 * 
 */
public class Game_Veteran {
    
    // instantiating the user mainMenu class, scanner, and random_Intermediary
    private Random random_Veteran;
    private Scanner scan_Veteran;
    
    // instantiating user and game logic variables
    private int generatedNumber;
    private int receivedUserNumber;
    
    private boolean validData = false;
    
    //error message database
    String[] exceptionsMsgBank = {
        "Number exceeds the limit ( > 1000);",
        "Number is less than limit ( < 0);",
        "Enter only numbers!",
        "Enter a valid answer!",
    };

    // basic constructor for better use of the code
    public Game_Veteran() {
        this.random_Veteran = new Random();
        this.scan_Veteran = new Scanner(System.in);
    }
    
    /**
     * generating a random_Intermediary integer between 0 and 1000
     * 
     * @return the randomly generated number for the generatedNumber variable
     * 
     */
    public int randomize() {
        
        generatedNumber = random_Veteran.nextInt(0, 1000) + 1;
        
        scanner();
        return generatedNumber;
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
        
        while(!validData) {
        
            try{

                System.out.print("\nEnter any number from 0 to 1000 to guess which number was generated: ");
                receivedUserNumber = scan_Veteran.nextInt();

                if(receivedUserNumber > 500) {
                    System.out.println(exceptionsMsgBank[0]);
                    scanner();

                } else if (receivedUserNumber < 0) {
                    System.out.println(exceptionsMsgBank[1]);
                    scanner();

                } else {
                    consoleMsgs();
                }

            }catch(InputMismatchException e) {
                System.out.println(exceptionsMsgBank[2]);
                scan_Veteran.next();
            }
        }
    };
    
    //Checking entered number and providing hints 
    //based on randomly generated number
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
        String yesOrNo = scan_Veteran.next();
        
        switch (yesOrNo.toLowerCase()) {
            
            case "y" -> {
                System.out.println("\nStarting a new game...");
                validData = false;
                randomize();
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
