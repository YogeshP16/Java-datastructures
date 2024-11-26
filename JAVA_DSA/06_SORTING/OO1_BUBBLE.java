/*
### Bubble Sort 

**What is Bubble Sort?**  
A simple sorting method where adjacent elements are swapped if they're in the wrong order, 
making smaller elements "bubble" to the top.

---
How It Works:

Start with the entire array.
Compare adjacent elements.
Swap them if they are in the wrong order.
Repeat the process for the rest of the array (ignoring already sorted elements).
Continue until no swaps are needed (array is sorted).

**Complexity:**  
- **Worst/Average Case:** (O(n^2))  
- **Best Case (Already Sorted):**  (O(n) )  
- **Space:**  (O(1) ) (in-place sorting, no extra arrays needed)

---

**When to Use:**  
- Educational purposes or small datasets.  
- Not efficient for large datasets—better alternatives exist.
 */


public class OO1_BUBBLE {
    public static void main(String[] args) {
        int[] arr = {2, 34, 45, 7, 89, 3};
        bubblesort(arr); // Sort the array
        for (int num : arr) { // Print the sorted array
            System.out.print(num + " ");
        }
    }

    public static void bubblesort(int[] arr) {

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                
                if (arr[j] < arr[j - 1]) {
                    // Swap arr[j] and arr[j-1]
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
