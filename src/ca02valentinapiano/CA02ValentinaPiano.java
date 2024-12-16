/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca02valentinapiano;
import java.util.Arrays;
import java.util.Scanner; 
import java.io.IOException;

/**
 *
 * @author vale
 */
public class CA02ValentinaPiano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);// create a scanner object to read user input 
        int[][] userMatrix;//variable declaration to hold 2D array user input
        int[] userArray;//variable declaration to hold 1D array user input
        int arrayOption=1;// variable that hold option for 1D Array
        int matrixOption=2;// variable that hold option for 2D Array
        
        try{ System.out.println("If you want to work with a 1D array, press 1 or if you want to work with 2D array, press 2.");// // Prompt the user to choose between 1D or 2D array
            int userTypeArrayChoice = input.nextInt();// Read the user's choice as an integer
           
            // Check for user's choice and handle accordingly 
            if(userTypeArrayChoice == arrayOption){
              
                
            }else if(userTypeArrayChoice == matrixOption){
              
                
            }else {
                System.out.println("You pressed an incorrect key.Please, press 1 if you want to work with 1D array or press 2 if you want ro waork with 2D array.");
            }
            
        }catch (Exception e) {
            System.out.println("Invalid input. ");// Message to handle invalid input 
        } finally {
            input.close();// Close the Scanner object to avoid resource leaks
        }
    }
    
}
