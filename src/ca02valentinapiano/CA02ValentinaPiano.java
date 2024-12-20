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
//github link
//https://github.com/ValentinaPiano313/CA02JavaValentinaPiano

//The main program provides an interactive interface for the user to perform operationson either a 1D array or a 2D matrix. 
//The program first prompts the user to choose between working with a 1D array or a 2D matrix. 
//Based on the user's selection,the program offers different tasks and functionalities for each type of array.
 //1D Array Operations**:
 //The user is prompted to enter the size and elements of a 1D array.
 //--Task 1: It searches for the first repeated element in the array and displays it if found.
 //--Task 5: It performs a Bubble Sort on the array and displays the sorted array along with the number of swaps performed during the sort.
 //    If no swaps were made, it indicates that the array was already sorted.
 //2D Matrix Operations**:
 // The user is prompted to input the number of rows and columns for a 2D matrix.
 //--Task 3: It calculates and displays the sums of the main and secondary diagonals of the matrix (only works if the matrix is square).
 //--Task 2: It generates and displays a multiplication table of the specified size.
 //The program checks for user input errors and provides feedback if an invalid key is pressed or if the input is not an integer. 
 // Task 4: Generate and display an array containing the spiral traversal of a matrix

public class CA02ValentinaPiano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);// create a scanner object to read user input 
        int[][] userMatrix;//variable declaration to hold 2D array user input
        int[] userArray;//variable declaration to hold 1D array user input
        int arrayLength =0; //
        int arrayOption=1;// variable that hold option for 1D Array
        int matrixOption=2;// variable that hold option for 2D Array
        int noswaps =0;
        
        try{ System.out.println("If you want to work with a 1D array, press 1 or if you want to work with 2D array, press 2.");// // Prompt the user to choose between 1D or 2D array
            int userTypeArrayChoice = input.nextInt();// read the user's choice as an integer
           
            // check for user's choice and handle accordingly 
            if(userTypeArrayChoice == arrayOption){
                 // Code for working with 1D array
                System.out.println("You chose to work with a 1D array");
                System.out.println("");
                // code for task 1
                System.out.println("Enter the size of the array;");// prompt the user to enter the size of the array
                arrayLength =input.nextInt();//get the array length from user input
                System.out.println("Enter the array elements");//prompt the user to enter the array elements
                userArray =new int[arrayLength];//initialize the array with the specified length
                userArray =ArrayOperations.populateArrayInputUser(arrayLength);//call the method to populate the array based on user input
                System.out.println("You array is: ");
                ArrayOperations.displayArray(userArray);//display the array to the user
                System.out.println("");
                System.out.println("Task1: Array Search - Find Repeated Element");
                Integer repeatedElement = ArrayOperations.findFirstRepeatedElement(userArray);//call the method to find the first repeated element in the array
                
                if( repeatedElement!= null){// Check if a repeated element was found
                     System.out.println("The first repeated element on the array is "+ repeatedElement); // Inform the user that a repated element was found and display it
                     System.out.println("");
                }else{
                     System.out.println("No repeated element founded on this array.");//Inform the user that no repeated element was found
                     System.out.println("");
                }
                // code for task 5
                System.out.println("Task5: BobbleSort - SortingArray");
                System.out.println("Enter the size of the array;");// prompt the user to enter the size of the array
                arrayLength =input.nextInt();//get the array length from user input
                System.out.println("Enter the array elements");//prompt the user to enter the array elements
                userArray =new int[arrayLength];//initialize the array with the specified length
                userArray =ArrayOperations.populateArrayInputUser(arrayLength);//call the method to populate the array based on user input
                System.out.println("You array is: ");
                ArrayOperations.displayArray(userArray);//display the array to the user
                BubbleSortOperations sortResults = BubbleSortOperations.bubbleSort(userArray); //perform the Bubble Sort operation and capture the result
                int swaps = sortResults.swaps;//retrieve the number of swaps performed during sorting
                if (swaps == noswaps){//check if the array was already sorted
                    System.out.println("The array is already sorted");//if no swaps were made, the array was already sorted
                    System.out.println("");
                }else{//otherwise, display the sorted array and the number of swaps made
                     System.out.println("Sorted Array: " + Arrays.toString(sortResults.sortedArray));
                     System.out.println("Number of Swaps: " + sortResults.swaps); 
                     System.out.println("");
                }
                
            }else if(userTypeArrayChoice == matrixOption){
                System.out.println("You chose to work with a 2D array.");
                // code for task 3
                System.out.println("Task3: Diagonal Sum of a Matrix");
                System.out.println("Insert the number of rows of the matrix;");//prompt the user to input the number of rows for the matrix
                int rows =input.nextInt();//read the number of rows from user input
                System.out.println("Insert the number of columns of the matrix;");//prompt the user to input the number of columns for the matrix
                int cols =input.nextInt();//read the number of columns from user input
                //userMatrix= new int[rows][cols];//initialize the matrix with the given dimensions
                userMatrix=MatrixOperations.populateMatrix(rows, cols);//call the method to populate the array 
                MatrixOperations.displayMatrix(userMatrix);//display the array to the user
                MatrixOperations.diagonalSum(userMatrix);//call mathod that calculate main and secondary diagonal and display them
                System.out.println("");
                // code for task 2
                System.out.println("Task2 : Multiplication Table");
                System.out.println("Insert the size of the multiplication table");//prompt the user to input the size of the multiplication table 
                int size =input.nextInt();//read the size from user input
                int[][]table= new int[size][size];//initialize the matrix with the given dimension
                table=MatrixOperations.multiplicationTable(size);//the method to calculate multiplication table and save the result on a 2Darray
                MatrixOperations.displayMatrix(table);//disply the matrix to the user
                //code for Task 4
                System.out.println("Task 4: Spiral");
                System.out.println("Insert the number of rows of the matrix:");
                rows = input.nextInt();
                System.out.println("Insert the number of columns of the matrix:");
                cols = input.nextInt();
                userMatrix = new int[rows][cols];
                userMatrix = MatrixOperations.populateMatrix(rows, cols); //populate the matrix
                MatrixOperations.displayMatrix(userMatrix); //display the matrix
                int[] spiral = MatrixOperations.spiralTraversal(userMatrix);//cal the method to perform the spiral traversal
                 if (spiral == null) {
                   System.out.println("The matrix is not square. Please insert a square matrix to calculate the spiral traversal.");
                } else {
                    System.out.println("The spiral traversal of your matrix is: " + Arrays.toString(spiral));
                }
               
            }else {
                System.out.println("You pressed an incorrect key.Please, press 1 if you want to work with 1D array or press 2 if you want ro work with 2D array.");
            }
            
        }catch (Exception e) {
            System.out.println("You pressed an incorrect key. The value must be an integer number.");// message to handle invalid input 
        } finally {
            input.close();// close the Scanner object to avoid resource leaks
        }
    }
    
}
