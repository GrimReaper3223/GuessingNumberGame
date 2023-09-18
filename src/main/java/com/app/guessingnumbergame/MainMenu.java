package com.app.guessingnumbergame;

/**
 * class that shows the user menu interface
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since class: 2.0_BETA;
 *   |
 *    \
 *     @since Menu funcionality: 1.0_BETA;
 */
public class MainMenu {
    
    //default variables
    int userMenuScanner;

    //main menu method
    public void mainMenu() {
        
        System.out.println("\f\nGuessing Number Game - v3.0_BETA;");
        System.out.println("\nChoose an option:\n");
        System.out.println("(1) - Start Game " + Difficulty.difficultySet + "; \n(2) - Settings; \n(3) - Difficulty; \n(4) - Exit;");
        System.out.print("\n>> ");
        
        userMenuScanner = Assets.scanner.scannerInt();
        
        switch (userMenuScanner) {
            
            //start game
            case 1:
                Assets.start.start();
                break;
                
            //settings
            case 2:
                Assets.settings.settings();
                break;
                
            //difficulty    
            case 3:
                Assets.difficulty.difficulty();
                break;
            
            //close game    
            case 4:
                System.out.println("\nExiting...\n");
                Assets.scanner.scannerClose();
                break;
        }
    };
};
