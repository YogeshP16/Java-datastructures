import java.util.Arrays;
import java.util.Scanner;

public class OO1_ARRAYS {

    // ARRAYS --> Collection of same data types
    public static void main(String[] args) {
        System.out.println("Working with arrays:");

        // Declare initialization in one step

        /*

         * int[] arr = {12,34,45,56,67,88}
         
        */

        // Array declaration and initialization
        int arr[] = new int[5];

        Scanner sc = new Scanner(System.in);

        // Array initialization using Scanner
        System.out.println("Enter 11 integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Print array using for loop
        System.out.println("Array elements using for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Line break for better formatting

        // Print array using foreach loop
        System.out.println("Array elements using foreach loop:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); // Line break for better formatting

        // Print array using Arrays.toString
        System.out.println("Array elements using Arrays.toString:");
        System.out.println(Arrays.toString(arr));

        // Closing scanner
        sc.close();
    }
}

/*

Working with arrays:
Enter 11 integers:
12
12
23
34
45
Array elements using for loop:
12 12 23 34 45

Array elements using foreach loop:
12 12 23 34 45

Array elements using Arrays.toString:
[12, 12, 23, 34, 45] 

*/