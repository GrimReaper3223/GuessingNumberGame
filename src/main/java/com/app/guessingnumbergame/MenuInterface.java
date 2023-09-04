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
import java.util.Scanner;

/**
 * This class contains the game's main menu, its properties and its methods.
 * in the future, this class will only show the menu. Your methods will be 
 * divided into classes for better maintainability, logic, new implementations 
 * and code readability;
 * 
 * @author deiv;
 * @version 2.0_BETA;
 */

//TODO: check the default labels of switch expressions for possible overflows
//the labels that must be checked will be marked with the netbeans marker

public class MenuInterface {
    
    //creating private instances of the required classes
    private Scanner scanner = new Scanner(System.in);
    
    private int userOption;
    private int difficultyOption;
    
    private int origin;
    private int bound;
    
    /*
    * variable that checks that a custom game has been properly 
    * configured before playing
    */
    private boolean validCustomGame;
    private boolean controlCodeFlow;
    
    String currentDifficulty = "[Easy]";
    
    //Main menu
    public void mainMenu() {
        
        System.out.println("\nGuessing Number Game - v2.0_BETA;");
        System.out.println("\nChoose an option: \n");
        System.out.println("(1) - Start Game " + currentDifficulty + "; \n(2) - Settings; \n(3) - Difficulty; \n(4) - Exit;");
        System.out.print("\n>> ");
        
        userOption = scanner.nextInt();
        
        switch (userOption) {
            
            //Starting a Game with default difficulty (easy)
            case 1 -> {
                System.out.println("\nStarting game " + currentDifficulty + "... ");
                startGame(currentDifficulty);
                break;
            }
            
            //Game settings
            case 2 -> {
                settings();
                break;
            }
            
            //Change game difficulty    
            case 3 -> {
                difficulty();
                break;
            }
            
            //Leave the game    
            case 4 -> {
                System.out.println("\nExiting...\n");
                scanner.close();
                break;
            }
            
            //NOTE: check this default label for bugs
            default -> {
                System.err.print("\nInvalid Option");
                mainMenu();
            }
        }
    };
    
    //start a game with early predefined level
    private void startGame(String level) {
        
        if(level.equals("[Easy]")) {
            DefaultLevelStructure startGame1 = new DefaultLevelStructure();
            startGame1.randomize(0, 100);
            
        } else if(level.equals("[Intermediary]")) {
            DefaultLevelStructure startGame2 = new DefaultLevelStructure();
            startGame2.randomize(0, 200);
            
        } else if(level.equals("[Hard]")) {
            DefaultLevelStructure startGame3 = new DefaultLevelStructure();
            startGame3.randomize(0, 500);
            
        } else if(level.equals("[Veteran]")) {
            DefaultLevelStructure startGame4 = new DefaultLevelStructure();
            startGame4.randomize(0, 1000);
            
        // logic to check and start a customizable game
        } else if(level.equals("[Custom]")) {
            
            if(!validCustomGame) {
                System.out.print("level Custom not configured. Do you want to configure? (y / n) \n>> ");
                String yOrN = scanner.next();
                
                switch (yOrN.toLowerCase()) {
                    
                    case "y":
                        settings();
                        break;
                    case "n": 
                        System.out.println("Unable to initialize a customizable game without initial settings. Check your settings or try another level");
                        mainMenu();
                        
                    //NOTE: check this default label for bugs
                    default: 
                        System.err.print("Invalid option");
                        scanner.next();
                }
                
            } else {
                DefaultLevelStructure startGame5 = new DefaultLevelStructure();
                startGame5.randomize(origin, bound);
            }
        }
    }
    
    //Game difficulty menu
    private void difficulty() {
        
        System.out.println("\nSelect the difficulty: \n");
        System.out.println("(1) - Easy; \n(2) - Intermediary; \n(3) - Hard; \n(4) - Veteran; \n(5) - Custom; \n(6) - Back to menu;");
        System.out.print("\n>> ");
        
        difficultyOption = scanner.nextInt();       
        
        switch(difficultyOption) {
            
            //Easy game difficulty
            case 1 -> {
                System.out.println("\nYou changed the difficulty of the game to Easy");
                System.out.println("Going back to the menu... ");
                currentDifficulty = "[Easy]";
                mainMenu();
                break;
            }
            
            //Intermediary game difficulty
            case 2 -> {
                System.out.println("\nYou changed the difficulty of the game to Intermediary");
                System.out.println("Going back to the menu...");
                currentDifficulty = "[Intermediary]";
                mainMenu();
                break;
            }
            
            //Hard game difficulty
            case 3 -> {
                System.out.println("\nYou changed the difficulty of the game to Hard");
                System.out.println("Going back to the menu...");
                currentDifficulty = "[Hard]";
                mainMenu();
                break;
            }
            
            //Veteran game difficulty
            case 4 -> {
                System.out.println("\nYou changed the difficulty of the game to Veteran");
                System.out.println("Going back to the menu...");
                currentDifficulty = "[Veteran]";
                mainMenu();
                break;
            }
            
            //Custom game difficulty
            case 5 -> {
                System.out.println("\nYou changed the game difficulty to Custom");
                System.out.println("Before Initializing a custom game, change the properties in the settings");
                System.out.println("Going back to the menu...");
                currentDifficulty = "[Custom]";
                mainMenu();
                break;
            }
            
            //back to main menu
            case 6 -> {
                System.out.println("\nGoing back to the menu...");
                mainMenu();
                break;
            }
            
            //NOTE: check this default label for bugs
            default -> {
                System.err.print("Invalid option");
                scanner.next();
            }
        }
    };
    
    /*
    * Game options menu
    *
    * here is the concise logic to configure the customizable game logic
    */
    private void settings() {
        
        System.out.println("\nSelect the setting you want to change:\n");
        System.out.print("(1) - Change the number generation range; \n(2) - Back to menu; \n\n>> ");
        
        //to prevent any reassign values bug
        controlCodeFlow = false;
        
        userOption = scanner.nextInt();
        
        switch (userOption) {
            
            case 1 -> {
                
                if(currentDifficulty.equals("[Custom]")) {
                    
                    //if the flow falls into the loop, this label will be responsible for resuming the execution of this point
                    restart:
                    while (!controlCodeFlow) {

                        try {
                            
                            System.out.print("\nEnter an initial value (origin): ");
                            origin = scanner.nextInt();
                            System.out.print("\nEnter an final value (bound): ");
                            bound = scanner.nextInt();

                            if(origin > bound || bound < origin) {
                                System.err.print("\nIncompatible data. Try again...");
                                continue restart;
                            } else if(origin == bound) {
                                System.err.print("Bound must be greater than origin. Try again...");
                                continue restart;
                            }
                            
                            /*
                            * if the data is valid and inserted correctly, the loop 
                            * control variable becomes positive, passing the code 
                            * execution to the configuration method, where the loop 
                            * control variable will become negative, in order to eliminate 
                            * bugs in case you want to change the values again
                            *
                            * 'validCustomGame' will also become positive, informing 
                            * the 'startGame()' method that a custom game has been 
                            * properly configured and can be started;
                            */
                            System.out.println("\nOrigin and bound set successfully!");
                            controlCodeFlow = true;
                            validCustomGame = true;
                            settings();
                            break;

                        } catch (InputMismatchException e) {
                            System.err.print("\nInvalid option. Enter valid data");
                            continue restart;
                        }
                    }
                    
                /*
                *  if the 'custom' level is not selected to play, this execution 
                *  block will be responsible for not allowing the settings to be changed;
                */
                } else {
                    System.err.print("\nThis option is only available for \"Custom\" difficulty games.. Change your game difficulty before selecting this option\n");
                    settings();
                }
            }
            
            case 2 -> {
                System.out.println("\nGoing back to the menu...\n");
                mainMenu();
                break;
            }
            
            //NOTE: check this default label for bugs
            default -> {
                System.err.print("Invalid option\n");
                settings();
            }
        }
    };
      
};
