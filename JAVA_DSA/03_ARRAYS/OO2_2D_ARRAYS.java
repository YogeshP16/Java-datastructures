import java.util.Arrays;


/*
Why Use **matrix[row].length** in Loops?

Rectangular Matrix:
If all rows have the same number of columns, 
use -->  matrix[row].length will correctly handle the column iteration.

Jagged Matrix:

In a jagged matrix (non-rectangular), each row can have a different length. 
Use --> matrix[row].length ensures that you don't go out of bounds for shorter rows.

For 2D binary Search:

--> use arr[0].length

 */
public class OO2_2D_ARRAYS {
    public static void main(String[] args) {
        
        // Initialize a 2D array with varying column sizes
        int[][] arr = {
            {12, 23, 34, 45},
            {23, 45, 56, 78},
            {12, 34, 56}
        };

        // Print 2D array elements using nested for loops
        System.out.println("Printing 2D array using nested for loops:");
        for (int i = 0; i < arr.length; i++) {                 // Iterate through rows
            for (int j = 0; j < arr[i].length; j++) {          // Iterate through columns in each row --> jagged matrix
                System.out.print(arr[i][j] + " ");             // Print element
            }
            System.out.println();                              // Line break after each row
        }


        // Print 2D array using Arrays.toString and for-each loop
        System.out.println("\nPrinting 2D array using Arrays.toString and for-each loop:");
        for (int[] row : arr) {                                 // Iterate through each row
            System.out.println(Arrays.toString(row));           // Print the row as a string
        }
    }
}


/* 
Printing 2D array using nested for loops:
12 23 34 45
23 45 56 78
12 34 56

Printing 2D array using Arrays.toString and for-each loop:
[12, 23, 34, 45]
[23, 45, 56, 78]
[12, 34, 56]
 */