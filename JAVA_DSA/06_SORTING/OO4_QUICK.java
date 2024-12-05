/*
 QUICK SORT
-----------
Partition the array around a pivot: 
    Rearrange elements such that all elements smaller than the pivot go to its left, 
    and all elements larger go to its right.
    
Recursively apply the above steps to the subarrays on the left and right of the pivot.

Quick Sort Complexity:
-------------------------
- **Best & Average Case:**  
  - **Time:** (O(n log n))  ------------------> when you choose pivot as middle
  - **Space:** (O(log n)) (recursive stack)

- **Worst Case:**  
  - **Time:** (O(n^2))  ---------------> When you choose pivot as smalles / largest
  - **Space:** (O(n)) (recursive stack)  

 */



import java.util.Arrays;

public class OO4_QUICK {
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        // Call the quick sort function with initial low and high indices
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr)); // Print the sorted array
    }

    static void quick(int[] arr, int low, int high) { 
        // Base condition: if low >= high, no further sorting is needed
        if (low >= high) return;

        int s = low; // Start pointer
        int e = high; // End pointer
        int mid = s + (e - s) / 2; // Find the middle element to use as the pivot
        int pivot = arr[mid]; // Set pivot as the middle element of the array

        // Partition the array into two halves
        while (s <= e) {
            // Increment the start pointer until an element greater than or equal to pivot is found
            while (arr[s] < pivot) {
                s++;
            }

            // Decrement the end pointer until an element smaller than or equal to pivot is found
            while (arr[e] > pivot) {
                e--;
            }

            // If the start pointer is still less than or equal to the end pointer, swap the elements
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++; // Move the start pointer forward
                e--; // Move the end pointer backward
            }
        }

        // Recursively sort the left part of the array (elements before the 'e' pointer)
        quick(arr, low, e);

        // Recursively sort the right part of the array (elements after the 's' pointer)
        quick(arr, s, high);
    }
}

/*

quick(arr, 0, 4)  --> arr = {1, 2, 3, 4, 5} 
   ├── quick(arr, 0, 1) --> arr = {1, 2} 
   └── quick(arr, 3, 4) --> arr = {4, 5}


*/
