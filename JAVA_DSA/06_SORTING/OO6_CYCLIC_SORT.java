/* 
 CYCLIC SORT 
 
- Cyclic Sort is a sorting algorithm that works by iterating through the array, 
  placing each element in its correct position based on its value (assuming the values are within a known range).

#### When to Use Cyclic Sort?
-------------------------------
- When the array contains distinct integers within a known range (e.g., 1 to n).
- When you need in-place sorting with constant space.
- FIND MISSING, DUPLIICATES, MISPLACED NUMBERS (1 to n)

#### How to Identify This Pattern?
---------------------------------
- If you’re given an array of integers where each element is within a known range 
  and you need to sort it without extra space, consider Cyclic Sort.
- The pattern involves identifying the index of each element
  and ensuring each value is placed in its corresponding index.

#### Time & Space Complexity:
----------------------------
- Time Complexity: (O(n)) — Each element is swapped at most once.
- Space Complexity: (O(1)) — It’s an in-place sorting algorithm.

---
#### Algorithm:
--------------------
1. Start from the first element.
2. If the element is not at its correct index (i.e., `arr[i] != arr[arr[i]]`), 
    swap it with the element at its correct index.
3. Repeat until all elements are at their correct position.

### Example:
----------
Given the array: `[3, 1, 2, 5, 4]`  
Cyclic Sort proceeds like:
1. Check `arr[0] = 3`. It should be at index 2, so swap with `arr[2]`. Array becomes `[2, 1, 3, 5, 4]`.
2. Check `arr[0] = 2`. It should be at index 1, so swap with `arr[1]`. Array becomes `[1, 2, 3, 5, 4]`.
3. Check `arr[1] = 2`, it's at the correct position, continue.
4. Check `arr[3] = 5`, it should be at index 4, swap with `arr[4]`. Array becomes `[1, 2, 3, 4, 5]`.


#### Pseudocode 

function cyclicSort(arr):
    n = length of arr
    i = 0
    
    while i < n:
        # If the element is not at the correct index
        if arr[i] != arr[arr[i] - 1]:
            # Swap the element with the correct position
            swap(arr[i], arr[arr[i] - 1])
        else:
            # If it's at the correct position, move to the next element
            i = i + 1

####  Important notes

- if range --> [0, N]  --> every element will be at index = value      ---> arr[i]
- if range --> [1, N]  --> every element wil be at index = value - 1   ---> arr[i] - 1
 */

import java.util.Arrays;

public class OO6_CYCLIC_SORT {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};   // ------------> here range is {1 to N} --> arr[i]-1
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
            
    }
    static void cyclic(int[] arr) {
        int n = arr.length;         // Get the length of the array
        int i = 0;                  // Start from the first element
    
        while (i < n) {
            // Calculate the correct index for the current element (value - 1)
            int correct_index = arr[i] - 1;
    
            // Check if the current element is not at its correct index
            if (arr[i] != arr[correct_index]) {
                // If not, swap the current element with the element at its correct index
                int temp = arr[i];
                arr[i] = arr[correct_index];
                arr[correct_index] = temp;
            } else {
                // If it's at the correct index, move to the next element
                i++;
            }
        }
    }
}   
