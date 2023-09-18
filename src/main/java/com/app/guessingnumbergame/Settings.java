package com.app.guessingnumbergame;

/**
 * game configuration class. There is only one configuration available. 
 * In the future there will be more options
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since class: 2.0_BETA;
 *      \
 *       @since settings funcionality: 1.0_BETA;
 */
public class Settings {
    
    /*
    * default variables
    *
    * controlVariable - checks whether a custom game has been properly configured 
    *                   and, if not, prevents the flow from exiting the loop and causing bugs in the code
    *
    * static origin - 'origin' needs to remain static so that its value can be referenced to other classes
    * static bound - 'bound' needs to remain static so that its value can be referenced to other classes
    *
    * validGame - checks whether a custom game has been properly configured. 
    *             Otherwise, when trying to start an unconfigured custom game, 
                  the conditional key in the 'Start' class will prevent the game from starting, 
                  forcing the user to change the difficulty level or otherwise configure a custom game before starting.
    */
    int userSettingsScanner;
    boolean controlVariable = false;
    
    static int origin;      
    static int bound;
    static boolean validGame = false;       
    
    
    //game settings interface
    public void settings() {
        
        System.out.println("\f\n---Settings Menu---\f");
        System.out.print("\n(1) - Set bounds for custom game; \n(2) - Go to menu; \n\n>> ");
        
        userSettingsScanner = Assets.scanner.scannerInt();
        
        switch (userSettingsScanner) {
            
            case 1 -> {
                
                if(Difficulty.difficultySet.equals("Custom")) {
                    
                    restart:
                        while(!controlVariable) {
                            System.out.print("Enter origin (minimum) value: ");
                            origin = Assets.scanner.scannerInt();
                            System.out.print("Enter bound (maximum) value: ");
                            bound = Assets.scanner.scannerInt();
                            
                            if(origin > bound) {
                                System.out.print("\nError: 'Origin' cannot be greater than 'bound';\n");
                                continue restart;
                                
                            } else if(bound < origin) {
                                System.out.print("\nError: 'Bound' cannot be less than 'origin';\n");
                                continue restart;
                                
                            } else if(bound == origin) {
                                System.out.print("\nError: 'Origin' and 'bound' cannot be the same\n");
                                continue restart;
                                
                            } else {
                                System.out.println("\nOrigin and bound defined successfully!");
                                System.out.println("\nGoing to menu...\n");
                                controlVariable = true;
                                validGame = true;
                                Assets.menu.mainMenu();
                                break;
                            }
                        }
                    
                } else {
                    System.out.println("\nError: This setting is not available for the 'custom' game mode. Please update your game mode and try again;");
                    Assets.menu.mainMenu();
                }
            }
            
            case 2 -> {
                System.out.println("\nGoing to menu...");
                Assets.menu.mainMenu();
                break;
            }
        }
    };
    
};
