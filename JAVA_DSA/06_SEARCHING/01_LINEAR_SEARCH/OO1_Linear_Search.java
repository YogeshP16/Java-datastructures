/*
LINEAR SEARCH 

What is it?
Linear Search checks each element in an array or list sequentially to find the target value.

How it works?
Start from the first element.
Compare each element with the target.
Stop when the target is found or the end is reached.

Time and Space Complexity:
Time Complexity:

Worst Case: O(n) - The target is at the end or not present.
Best Case: O(1) - The target is at the first position.
Average Case: O(n/2) ≈ O(n).

Space Complexity:

O(1) - Uses only a constant amount of extra space (e.g., loop variables).

When to Use Linear Search:

Dataset is Small or Unsorted:
Sorting costs extra time; linear search is straightforward.

Data in a Linked List:
Random access is not possible; linear traversal is necessary.

Backup Algorithm:
Useful if binary search fails due to corrupted data or edge cases.

Simplicity Over Speed:
Ideal for quick, simple searches without preprocessing.

 */

public class OO1_Linear_Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Find target
        int target = 6;
        int res = findtarget(arr, target);
        System.out.println("Target found at index: " + res);

        // Two sum using linear search
        int[] arr1 = {12, 3, 4, 6, 8};
        int sum = 7;
        int[] res1 = twosum(arr1, sum);
        if (res1 != null) {
            System.out.println("Two sum indices: " + res1[0] + ", " + res1[1]);
        } else {
            System.out.println("No pair found");
        }
    }

    // Linear search to find target
    
    public static int findtarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return index if target found
            }
        }
        return -1;  // Return -1 if not found
    }

    // Two sum using linear search

    public static int[] twosum(int[] arr1, int sum) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] + arr1[j] == sum) {
                    return new int[]{i, j};  // Return indices of the pair
                }
            }
        }
        return null;  // Return null if no pair is found
    }

}
