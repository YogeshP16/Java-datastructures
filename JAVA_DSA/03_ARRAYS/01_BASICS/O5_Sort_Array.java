

import java.util.Arrays;

public class O5_Sort_Array {
    public static void main(String[] args) {

        // Input array
        int[] arr = {12, 34, 45, 6, 78, 8}; // Expected output: [6, 8, 12, 34, 45, 78]
        
        // 1. Using Arrays.sort()
        Arrays.sort(arr);
        System.out.println("Using Arrays.sort(): " + Arrays.toString(arr));

        System.out.println();

        // 2. Check if Array is Sorted (Brute Force)
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) { // Fix: Use index `i` for comparison
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("Array is sorted: " + isSorted);

        System.out.println();

        // 3. Bubble Sort Implementation
        int[] arr2 = {12, 34, 45, 6, 78, 8}; // Original array for Bubble Sort
        for (int i = 0; i < arr2.length - 1; i++) { // Outer loop for passes
            for (int j = 0; j < arr2.length - i - 1; j++) { // Compare adjacent elements
                if (arr2[j] > arr2[j + 1]) {
                    // Swap elements
                    int temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }
        System.out.println("Using Bubble Sort: " + Arrays.toString(arr2));
    }
}
