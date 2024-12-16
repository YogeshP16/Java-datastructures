### **Two Pointer Template: From Both Ends**

This pattern is often used in problems involving arrays or strings when working with a single array or string.

#### **Steps**:
1. Initialize two pointers:
   - `left = 0` (start of the array)
   - `right = n - 1` (end of the array)
2. Move the pointers based on a condition:
   - If the condition is met, move one or both pointers accordingly.
   - Typically, increment `left` or decrement `right`.
3. Stop when `left > right`.

#### **Code Template**:
```java
public void twoPointersBothEnds(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
        // Example condition
        if (nums[left] + nums[right] == target) {
            // Perform operation (e.g., return or store result)
        }
        
        // Adjust pointers
        if (conditionToMoveLeft) {
            left++;
        } else if (conditionToMoveRight) {
            right--;
        }
    }
}
```

#### **Use Cases**:
- Checking if an array is a palindrome.
- Two-sum problems on sorted arrays.
- Partitioning an array.
- Reversing
- Trapping rain water
- Next permutations
---

### **Two Pointer Template: From Start of Two Arrays**

This pattern is used when working with two separate arrays, often sorted.

#### **Steps**:
1. Initialize two pointers:
   - `i = 0` for the first array.
   - `j = 0` for the second array.
2. Compare the elements pointed to by the pointers and decide how to move them:
   - If `arr1[i] < arr2[j]`, move `i`.
   - If `arr1[i] > arr2[j]`, move `j`.
   - If they are equal, perform some operation and move both pointers.
3. Stop when either pointer reaches the end of its array.

#### **Code Template**:
```java
public void twoPointersTwoArrays(int[] arr1, int[] arr2) {
    int i = 0, j = 0;

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] == arr2[j]) {
            // Perform operation (e.g., add to result)
            i++;
            j++;
        } else if (arr1[i] < arr2[j]) {
            i++;
        } else {
            j++;
        }
    }
}
```

#### **Use Cases**:
- Merging two sorted arrays.
- Finding the intersection of two sorted arrays.
- Comparing sequences.
- Median finder
- substring related