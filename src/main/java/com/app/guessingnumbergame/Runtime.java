package com.app.guessingnumbergame;

/**
 * Start point class
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since funcionality: 1.0_BETA;
 *      \
 *       @since class: 3.0_ALPHA
 */
public class Runtime {
    
    //main method
    public static void main(String[] args) {
        
        Assets assets = new Assets();
        
        MainMenu menu = new MainMenu();
        menu.mainMenu();
    };
};
