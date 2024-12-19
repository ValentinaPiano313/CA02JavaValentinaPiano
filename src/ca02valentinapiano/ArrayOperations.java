/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca02valentinapiano;
import java.util.Scanner; 
import java.util.InputMismatchException;
/**
 *
 * @author vale
 */


//
 //The ArrayOperations class provides utility methods for working with 1-dimensional arrays.
 //Populate an array with user-provided integer values through input validation.
 //Display the elements of an array in a readable format.
 //find the first repeated element in an array 


public class ArrayOperations {
    
     // method to populate an array based on user input lenght
    public static int[] populateArrayInputUser(int arrayLenght){
        Scanner input = new Scanner(System.in);
        int[] userArray =new int[arrayLenght]; //create an array of integers with the specified length.  
        
        try{
         //use a for loop to read user input and populate the array  
         for(int i=0; i< arrayLenght; i++){
             userArray[i]=input.nextInt(); //read an integer from the user and assign it to the corresponding index in the array.
         }
         return userArray;//return the populated array
          //If the user enters a non-integer value, an InputMismatchException is caught, and an error message is displayed  
        }catch(InputMismatchException e){
           System.out.println("Invalid input! Please enter only integer values.");//prompt an error message to the user
           return null;// return null if invalid input is encountered
        }finally{
        }
    }
    
    //method to print all elements of the array.
    public static int[] displayArray(int[] myArray){
         for (int i = 0; i < myArray.length; i++) {
        //print each element followed by a comma, except for the last element.
        if (i < myArray.length - 1) {
            System.out.print(myArray[i] + ", ");
        } else {
            System.out.print(myArray[i]);
        }
    }
    System.out.println(); // add a newline after printing the array
    return myArray; // return the array if needed
      
    }
    
    
    // method to find the first repeated element in an array of integer
   public static Integer findFirstRepeatedElement(int[] userArray) {
        // Iterate through each element in the array
        for (int i = 0; i < userArray.length; i++) {
            // Check each element against all subsequent elements
            for (int j = i + 1; j < userArray.length; j++) {
                if (userArray[i] == userArray[j]) { // Check for repetition
                    return userArray[i]; // Return the first repeated element
                }
            }
        }
        return null; // Return null if no repeated element is found
    }
   

    
    
}
