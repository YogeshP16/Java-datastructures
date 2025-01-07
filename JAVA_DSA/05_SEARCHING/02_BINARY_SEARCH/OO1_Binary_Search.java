/*
---

### **What is Binary Search?**

Binary search is a fast way to find a target value in a **sorted array**. Instead of checking every item, it divides the array into halves until it finds the value.

---

### **How it Works (Steps):**

1. Look at the **middle value** of the array.  --> mid =  start +(end - start) /2;

2. Compare the middle value with your target:
   - If it's a match, you're done!
   - If the target is smaller, focus on the **left half**.
   - If the target is larger, focus on the **right half**.

3. Repeat until:
   - You find the target, or
   - The array is empty (target doesn't exist).

---

### **Why Use Binary Search?**

- **Speed:** It’s faster than checking one-by-one (O(log n) vs. O(n)).
- **Efficiency:** It uses very little extra memory (O(1) space).

---

### **When to Use It?**

1. **Searching in a Sorted List**: 
Quickly find an item in a sorted array.

2. **Finding a Specific Condition**: 
Locate the smallest or largest value meeting a condition.
If you have a function that is monotonically increasing or decreasing over a range, 
you can use binary search algorithm to find the maximum or minimum value in that range

3. **Closest Match**: 
If you have a sorted array or list and you want to find the closest value to a target value, you can use binary search algorithm.


---

### **Quick Example (Find 7):**

**Array:** [1, 3, 5, 7, 9, 11]  
1. Middle = 5 → 7 > 5 → Look at [7, 9, 11].  
2. Middle = 9 → 7 < 9 → Look at [7].  
3. Found 7!  


### tc --> O(log n) sc --> O(1)

---

 */


public class OO1_Binary_Search {

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            // find mid
            int mid = start + (end - start) / 2;

            // focus --> left search space 
            if( target < arr[mid]){
                end = mid-1;

            // right search space
            }else if (target > arr[mid]){
                start = mid +1;

            // target equals to mid --> return it
            } else {
                return mid;
            }

        }
        return -1;

    }


    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,67,78,90,123};   // sorted array
        int target = 78;
        int res = binarySearch(arr, target);
        System.out.println("target found at index: "+ res);

       
        
        
    }

}
