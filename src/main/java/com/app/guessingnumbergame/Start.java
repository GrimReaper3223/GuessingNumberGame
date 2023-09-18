package com.app.guessingnumbergame;

/**
 * exclusive class to handle starting data for a new game.
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since 2.0_BETA;
 */
public class Start {
    
    //default variables
    String userDecideCustomConfig;

    //start game method
    public void start() {
        
        //easy
        if(Difficulty.difficultySet.equals("[Easy]")) {
            System.out.println("\nStarting a new game... "+ Difficulty.difficultySet +"\n");
            Assets.game.setRandomNumber(0, 100);
            
        //intermediary
        } else if(Difficulty.difficultySet.equals("[Intermediary]")) {
            System.out.println("\nStarting a new game... "+ Difficulty.difficultySet +"\n");
            Assets.game.setRandomNumber(0, 200);
        
        //hard
        } else if(Difficulty.difficultySet.equals("[Hard]")) {
            System.out.println("\nStarting a new game... "+ Difficulty.difficultySet +"\n");
            Assets.game.setRandomNumber(0, 500);
        
        //veteran    
        } else if(Difficulty.difficultySet.equals("[Veteran]")) {
            System.out.println("\nStarting a new game... "+ Difficulty.difficultySet +"\n");
            Assets.game.setRandomNumber(0, 1000);
            
        //custom - check settings before start a custom game    
        } else if(Difficulty.difficultySet.equals("[Custom]")) {
            
            if(!Settings.validGame) {
                System.out.print("\nCustomizable game not configured. Do you want to configure? \n\n>> ");
                
                userDecideCustomConfig = Assets.scanner.scannerString();
                
                switch (userDecideCustomConfig.toLowerCase()) {
                    
                    case "y" -> {
                        Assets.settings.settings();
                        break;
                    }
                    case "n" -> {
                        System.out.println("\nUnable to start unconfigured game. Please change your game mode or configure random generation limits in settings");
                        Assets.menu.mainMenu();
                        break;
                    }
                }
            //if a custom game is correctly configured, start it
            } else {
                System.out.println("\nStarting a new game... "+ Difficulty.difficultySet +"\n");
                Assets.game.setRandomNumber(Settings.origin, Settings.bound);
            }
        }
    };
};
