/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca02valentinapiano;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author vale
 */

//The MatrixOperations class provides several methods for performing operations on 2D arrays (matrices)
// Populates a 2D array (matrix) with user input.
//Displays the elements of a 2D array (matrix) in a readable format. Each row of the matrix is printed on a new line with elements separated by commas.
//Calculates and displays the sums of the main diagonal and secondary diagonal of a square matrix.
//Generates and returns a multiplication table of a given size.
//Generate an array containing the spiral traversal of a matrix


public class MatrixOperations {
    
    //method to populate a 2D array
    public static int[][] populateMatrix(int rows, int cols) {
    Scanner input = new Scanner(System.in);// create a scanner object to read user input 
    int[][] userMatrix = new int[rows][cols];// declare an 2D array 

     for (int i = 0; i < rows; i++) { //loop through each row of the matrix
        int rownumber = i + 1;//convert 0-based index to a 1-based row number for user readability
        System.out.println("Insert the elements for row " + rownumber + " (separate by spaces):");
        String inputUserRow = input.nextLine();//read the user input for the current row as a single line and save in a variable
        String[] inputUserElement = inputUserRow.split(" "); // //split the input string into an array of elements using spaces as the delimiter

        if (inputUserElement.length == cols) { //check if the number of elements for the row are equal to the number of columns
            try {
                for (int j = 0; j < cols; j++) {
                    userMatrix[i][j] = Integer.parseInt(inputUserElement[j]); //attempt to parse each element to integer if not an error and message is displayed
                }
            } catch (NumberFormatException e) {  //handle the case where the user input is not a valid integer
                System.out.println("Invalid input! Please enter only integers.");
                i--; //decrement the row counter to retry as the user needs to insert the row again
            }
        } else {
            System.out.println("Invalid number of elements. Please try again.");
            i--; //decrement the row counter to retry as the user needs to insert the row again
        }
    }
    return userMatrix;
}
    //method to display a 2D array
    public static int[][] displayMatrix(int[][] myMatrix){
        System.out.println("You Matrix is : ");//display a message indicating the matrix is about to be printed
         for (int i = 0; i < myMatrix.length; i++) {//loop through each row of the matrix
           for (int j = 0; j < myMatrix[i].length; j++) { //loop through each column of the current row
            
            if (j < myMatrix[i].length - 1) {
                System.out.print(myMatrix[i][j] + ", ");//print each element followed by a comma, except the last one
            } else {
                System.out.print(myMatrix[i][j]);
            }
        }  
        System.out.println(); //add a newline after printing an array row  
    }
     return myMatrix; //return the array 
    }
    
    
    //method to calculate and display the sums of the main diagonal and secondary diagonal of a given 2D square matrix
    static void diagonalSum(int[][] myMatrix){
        int main=0; //initialize variables to store sums of the main diagonal
        int secondary =0;//initialize variables to store sums of the secondary diagonal
        
        if(myMatrix.length == myMatrix[0].length){//check if the matrix is square (number of rows equals number of columns)
            for (int i = 0; i < myMatrix.length; i++) {//loop through the rows of the matrix
              for (int j = 0; j < myMatrix[i].length; j++) { //loop through the columns of the current row
                  if (i == j){  //add the element to the main diagonal sum if row index equals column index
                      main += myMatrix[i][j];}
                    if ((i + j) == (myMatrix.length - 1)){//add the element to the secondary diagonal sum if the sum of indices equals (matrix size - 1)
                        secondary += myMatrix[i][j];
                    }
              }
            }  
        }else{//if the matrix is not square, display an error message and exit the method
            System.out.println("The matrix you insert is not a square matrice, to calculate the diagonale please insert a square matrice that has same number of columns and rows");
            return;
        }
        
        System.out.println("The main diagonal is: "+ main);// Print the calculated sums of the diagonal
        System.out.println("The secondary diagonal is: "+ secondary);// Print the calculated sums of the secondary diagonal
}
    
   //method generates a multiplication table of a given size.
    public static int[][]multiplicationTable(int size){
        int[][] table = new int[size][size];// declaration of a 2D array with the given size to store the multiplication table 
                                                                                           // if size =3
        for(int i=0; i<size; i++){// Loop through each row of the table                      first loop i,j (i+1)*(j+1) | second loop i,j i*j  (i+1)*(j+1)
            for (int j=0; j < size; j++ ){// Loop through each column of the current row                0,0-- 1*1=1     |            1,0   --   2*1=2
                table[i][j] = (i+1) * (j +1);                                                         //0,1-- 1*2=2     |            1,1   --   2*2=4 
            }                                                                                         //0,2-- 1*3=3     |            1,2   --   2*3=6
        }
        return table;// return the multiplication table
    }
    
    //method to print a matrix in spiral order 
    //It divide the matrix into layers or. It starts with the outermost boundary and prints its elements, 
    //then progressively moves inward to handle the inner layers until all elements are printed.
    
    public static int[] spiralTraversal(int[][] myMatrix) {
    
    if (myMatrix.length == myMatrix[0].length) {//check if the matrix is square (number of rows equals number of columns)
        int[] spiralTraversal = new int[myMatrix.length * myMatrix[0].length];//initialize the result array to store the spiral traversal elements
        int counter = 0; //counter to track the position in the result array

        int left = 0;  // Initialize variables to track the boundaries of the matrix
        int right = myMatrix[0].length - 1; 
        int top = 0; 
        int bottom = myMatrix.length - 1; 

        
        while (top <= bottom && left <= right) {// Loop until all elements in the matrix are traversed in a spiral order
            
            for (int i = left; i <= right; ++i) {// traverse the top row from left to right
                spiralTraversal[counter++] = myMatrix[top][i]; //add the element to the array
            }
            top++; //move the top boundary downwards

            for (int i = top; i <= bottom; ++i) {//traverse the right column from top to bottom
                spiralTraversal[counter++] = myMatrix[i][right]; //add the element to the array
            }
            right--; //move the right boundary leftwards
            
            if (top <= bottom) {//check if there are rows remaining between the updated top and bottom boundaries
                
                for (int i = right; i >= left; --i) {//traverse the bottom row from right to left
                    spiralTraversal[counter++] = myMatrix[bottom][i]; //add the element to the array
                }
                bottom--; //move the bottom boundary upwards
            }

            if (left <= right) {//check if there are columns remaining between the updated left and right boundaries
                for (int i = bottom; i >= top; --i) {//traverse the left column from bottom to top
                    spiralTraversal[counter++] = myMatrix[i][left]; //add the element to the array
                }
                left++; //move the left boundary rightwards
            }
        }
        return spiralTraversal;//the spiarlTraversal array
    }

    
    return null;// Return an empty array if the matrix is not square
    }
   
}   
       //row 4   col 4 
    
    
//                left           right
 //                 0            cols-1
 //       top 0 // 0,0  0,1  0,2  0,3
                // 1,0  1,1  1,2  1,3
                // 2,0  2,1  2,2  2,3
 //bottom  row-1// 3,0  3,1  3,2  3,3  (3)
 //                               (3)   
    
    //spiral--> 0,0 - 0,1 - 0,2 - 0,3 - 1,3 - 2,3 - 3,3 - 3,2 - 3,1 - 3,0 - 2,0 - 1,0 - 1,1 - 1,2 - 2,2 - 2,1    
    //length = col*row            
    
    

