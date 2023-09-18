package com.app.guessingnumbergame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exclusive class for data entry using Scanner. 
 * Contains exclusive and proprietary methods for treating exceptions.
 * Any error related to a scanner object must be resolved here.
 * 
 * @author deiv;
 * @version 3.0_ALPHA;
 * @since 3.0_ALPHA;
 *     \
 *      @since scanner funcionality: 1.0_BETA;
 */
public class Scan {
    
    //Instance of each class so that the correct assignment variable can be called
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * Unique method for starting a Scanner with the System.in parameter and 
     * then assigning values ​​to given variables
     * 
     * @return 0 - null return if the program presents an error;
     */
    public int scannerInt() {
        
        //exception treatment block
        try {
            
            return scanner.nextInt();
            
          //if wrong input data
        } catch(InputMismatchException exception) {
            System.out.println("Error: " + exception +";");
            System.out.println("Please, input valid data");
            scanner.nextLine();
            return scannerInt();
        }
    };
    
    
    /**
     * Unique method for starting a Scanner with the System.in parameter and 
     * then assigning values ​​to given variables
     * 
     * @return null - null return if the program presents an error;
     */
    public String scannerString() {
        
        try {
            
            return scanner.next();
            
            //if wrong input data
        } catch (InputMismatchException exception) {
            System.out.println("Error: " + exception +";");
            System.out.println("Please, input valid data");
            scannerString();
        }
        
        return null;
    };
    
    
    //scan close method
    public void scannerClose() {
        scanner.close();
    };
}
