/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca02valentinapiano;

/**
 *
 * @author vale
 */
public class BubbleSortOperations {
    
    int[] sortedArray;// variable to store the sorted array after the bubble sort
    int swaps; // variable to store the number of swaps performed during the sort
    
    // Constructor to initialize the object with the sorted array and swap count.
    BubbleSortOperations (int[] sortedArray, int swaps) {
        
        this.sortedArray = sortedArray;
        this.swaps = swaps;
    }
    
    //method performs the bubble sort algorithm on the given input array
    public static BubbleSortOperations bubbleSort(int[] userArray){
       int swaps = 0;//initialization the swap counter
       
       for(int i=0; i< userArray.length; i++){// outer loop iterates through the array from the beginning.
           for (int j = i + 1; j < userArray.length; j++){ //Inner loop compares consecutive adjacent elements and swaps them if they are in the wrong order
               if(userArray[i] > userArray[j]){ // // If the current element is greater than the next element, 
                   int elementIndexJ = userArray[j];   //
                   userArray[j] = userArray[i];        //swape their positions
                   userArray[i] = elementIndexJ;       //
                   swaps++; //increment the swap counter
               }
               } 
           }  
        return new BubbleSortOperations(userArray, swaps); // create and return a new instance of BubbleSortOperations with the sorted array and swap count 
       }
    
}
