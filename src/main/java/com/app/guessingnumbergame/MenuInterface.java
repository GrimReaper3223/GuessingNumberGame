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
 *
 * @author deiv;
 * @version 1.0_BETA;
 * 
 * here is the introduction of the game. The user can start a game, 
 * change some options, change difficulty, etc.
 */

//TODO: review comments
//TODO: document and review code with javadoc

/*PENDING: assimilate all methods that access the class's instance variables so 
that they can use the get and set methods*/

/*NOTE: see what can be done in the 'MainActivity' class to remove the overload 
of the 'MenuInterface' class*/

public class MenuInterface {
    
    //creating private instances of the required classes
    private Scanner scanMenu = new Scanner(System.in);
    
    private int userOption;
    private int difficultyOption;
    
    private int originCustom;
    private int boundCustom;
    
    //variable that checks that a custom game has been properly 
    //configured before playing
    private boolean validCustomGame = false;    //FIXME: change this variable to false again. if it changes to true and stays like that, it will not be possible to reassign values in the settings for the 'custom' game mode
    private boolean controlCodeFlow = false;
    
    String difficultyChosen = "[Easy - default]";
    
    
    
    public void mainMenu() {
        
        System.out.println("\nGuessing Number Game - v1.0;");
        System.out.println("\nChoose an option: \n");
        System.out.println("(1) - Start Game " + difficultyChosen + "; \n(2) - Settings; \n(3) - Difficulty; \n(4) - Exit;");
        System.out.print("\n>> ");
        
        userOption = scanMenu.nextInt();
        
        switch (userOption) {
            
            //Starting a Game with default difficulty (easy)
            case 1 -> {
                System.out.println("\nStarting game " + difficultyChosen + "... ");
                startGame(difficultyChosen);
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
                scanMenu.close();
                break;
            }
                
            default -> {
                System.err.print("\nInvalid Option");
                scanMenu.next();
            }
        }
    };
    
    private void startGame(String level) {
        
        if(level.equals("[Easy - default]")) {
            Game_Easy startGame1 = new Game_Easy();
            startGame1.randomize();
            
        } else if(level.equals("[Intermediary]")) {
            Game_Intermediary startGame2 = new Game_Intermediary();
            startGame2.randomize();
            
        } else if(level.equals("[Hard]")) {
            Game_Hard startGame3 = new Game_Hard();
            startGame3.randomize();
            
        } else if(level.equals("[Veteran]")) {
            Game_Veteran startGame4 = new Game_Veteran();
            startGame4.randomize();
            
        } else if(level.equals("[Custom]")) {
            
            if(!validCustomGame) {
                System.out.print("level Custom not configured. Do you want to configure? (y / n) \n>> ");
                String yOrN = scanMenu.next();
                
                switch (yOrN.toLowerCase()) {
                    
                    case "y":
                        settings();
                        break;
                    case "n": 
                        System.out.println("Unable to initialize a customizable game without initial settings. Check your settings or try another level");
                        mainMenu();
                    default: 
                        System.err.print("Invalid option");
                        scanMenu.next();
                }
                
            } else {
                Game_Custom startGame5 = new Game_Custom();
                startGame5.randomize(originCustom, boundCustom);
            }
        }
    }
    
    //Game difficulty menu
    private void difficulty() {
        
        System.out.println("\nSelect the difficulty: \n");
        System.out.println("(1) - Easy [default]; \n(2) - Intermediary; \n(3) - Hard; \n(4) - Veteran; \n(5) - Custom; \n(6) - Back to menu;");
        System.out.print("\n>> ");
        
        difficultyOption = scanMenu.nextInt();       
        
        switch(difficultyOption) {
            
            //Easy game difficulty
            case 1 -> {
                System.out.println("\nYou changed the difficulty of the game to Easy");
                System.out.println("Going back to the menu... ");
                mainMenu();
                break;
            }
            
            //Intermediary game difficulty
            case 2 -> {
                System.out.println("\nYou changed the difficulty of the game to Intermediary");
                System.out.println("Going back to the menu...");
                difficultyChosen = "[Intermediary]";
                mainMenu();
                break;
            }
            
            //Hard game difficulty
            case 3 -> {
                System.out.println("\nYou changed the difficulty of the game to Hard");
                System.out.println("Going back to the menu...");
                difficultyChosen = "[Hard]";
                mainMenu();
                break;
            }
            
            //Veteran game difficulty
            case 4 -> {
                System.out.println("\nYou changed the difficulty of the game to Veteran");
                System.out.println("Going back to the menu...");
                difficultyChosen = "[Veteran]";
                mainMenu();
                break;
            }
            
            //Custom game difficulty
            case 5 -> {
                System.out.println("\nYou changed the game difficulty to Custom");
                System.out.println("Before Initializing a custom game, change the properties in the settings");
                System.out.println("Going back to the menu...");
                difficultyChosen = "[Custom]";
                mainMenu();
                break;
            }
            
            //back to main menu
            case 6 -> {
                System.out.println("\nGoing back to the menu...");
                mainMenu();
                break;
            }
            
            default -> {
                System.err.print("Invalid option");
                scanMenu.next();
            }
        }
    };
    
    //Game options menu
    private void settings() {
        
        System.out.println("\nSelect the setting you want to change:\n");
        System.out.print("(1) - Change the number generation range; \n(2) - Back to menu; \n\n>> ");
        
        controlCodeFlow = false;
        userOption = scanMenu.nextInt();
        
        switch (userOption) {
            
            case 1 -> {
                
                if(difficultyChosen.equals("[Custom]")) {
                    
                    restart:
                    while (!controlCodeFlow) {

                        try {
                            Game_Custom randomCustom = new Game_Custom();

                            System.out.print("\nEnter an initial value (origin): ");
                            originCustom = scanMenu.nextInt();
                            System.out.print("\nEnter an final value (bound): ");
                            boundCustom = scanMenu.nextInt();

                            if(originCustom > boundCustom || boundCustom < originCustom) {
                                System.err.print("\nIncompatible data. Try again...");
                                continue restart;
                            } else if(originCustom == boundCustom) {
                                System.err.print("Bound must be greater than origin. Try again...");
                                continue restart;
                            }

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
            
            default -> {
                System.err.print("Invalid option\n");
                settings();
            }
        }
    };
      
};
