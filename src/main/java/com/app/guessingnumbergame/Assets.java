package com.app.guessingnumbergame;


/**
 * These classes will be used to keep all objects online (before the app starts).
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since 3.0_ALPHA;
 */
public class Assets {
    
    //assets loader
    static MainMenu menu;
    static Start start;
    static Settings settings;
    static Difficulty difficulty;
    static DefaultGameStructure game;
    static Scan scanner;
    
    //asset constructor
    public Assets() {
        menu = new MainMenu();
        start = new Start();
        settings = new Settings();
        difficulty = new Difficulty();
        game = new DefaultGameStructure();
        scanner = new Scan();
        
        //verify if instances has been initialized
        verifyMenuInstance();
        verifyStartInstance();
        verifySettingsInstance();
        verifyDifficultyInstance();
        verifyGameInstance();
        verifyScanInstance();
    };
    
    private MainMenu verifyMenuInstance() {
        if(menu != null) {
            System.out.println("Menu instance | OK;");
            return menu;
        } else {
            System.out.println("Creating menu instance...");
            return Assets.menu = new MainMenu();
        }
    };
    
    private Start verifyStartInstance() {
        if(start != null) {
            System.out.println("Start instance | OK;");
            return start;
        } else {
            System.out.println("Creating start instance...");
            return Assets.start = new Start();
        }
    };
    
    private Settings verifySettingsInstance() {
        if(settings != null) {
            System.out.println("Settings instance | OK;");
            return settings;
        } else {
            System.out.println("Creating settings instance...");
            return Assets.settings = new Settings();
        }
    };
    
    private Difficulty verifyDifficultyInstance() {
        if(difficulty != null) {
            System.out.println("Difficulty instance | OK;");
            return difficulty;
        } else {
            System.out.println("Creating difficulty instance...");
            return Assets.difficulty = new Difficulty();
        }
    };
    
    private DefaultGameStructure verifyGameInstance() {
        if(game != null) {
            System.out.println("Game instance | OK;");
            return game;
        } else {
            System.out.println("Creating game instance...");
            return Assets.game = new DefaultGameStructure();
        }
    };
    
    private Scan verifyScanInstance() {
        if(scanner != null) {
            System.out.println("Scan instance | OK;\n");
            return scanner;
        } else {
            System.out.println("Creating scan instance...\n");
            return Assets.scanner = new Scan();
        }
    };
}
