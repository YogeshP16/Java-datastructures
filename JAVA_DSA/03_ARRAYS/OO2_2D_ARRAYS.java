import java.util.Arrays;

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
            for (int j = 0; j < arr[i].length; j++) {          // Iterate through columns in each row
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