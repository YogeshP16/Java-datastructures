/*
 ### **Binary Search for an Infinite Array (KISS Rule)**

For an **infinite array**, we can’t directly apply binary search since we don’t know the array's size. Instead, we use a technique to find the range where the target lies before applying binary search.

---

### **How It Works (Steps):**

1. **Find the Range:**
   - Start with a small range (e.g., `[0, 1]`).
   - Double the range size (`end = end * 2`) until the target is within the range.

2. **Apply Binary Search:**  
   - Perform binary search within the identified range.

---

### **Key Idea:**
We don't need the entire array. By expanding the range dynamically, we only search where the target could exist.

---

### **Example (Find 17):**

#### Infinite Array: `[1, 3, 5, 7, 9, 11, 13, 15, 17, ...]`

1. Start with range `[0, 1]`:  
   - `arr[1] = 3` → 17 > 3 → Double range to `[0, 3]`.

2. Range `[0, 3]`:  
   - `arr[3] = 7` → 17 > 7 → Double range to `[0, 7]`.

3. Range `[0, 7]`:  
   - `arr[7] = 15` → 17 > 15 → Double range to `[0, 15]`.

4. Range `[0, 15]`:  
   - `arr[15] > 17` → Target lies in `[8, 15]`.

5. Apply Binary Search in `[8, 15]`:  
   - Mid = `arr[11] = 17` → Found target!

---

### **Key Notes:**
1. **Efficient for large/infinite arrays**: Only examines relevant parts of the array.
2. **Dynamic range expansion**: Ensures that we don't search unnecessarily.
3. **Time complexity**:  
   - Finding the range: (O(log p)), where (p) is the position of the target.  
   - Binary search within the range: (O(log n)).  
   - Overall: (O(log p + log n) = O(log n)). 

This approach is effective for scenarios where the array size is very large or theoretically infinite!
 */

 public class OO2_Infinite_Array_Search {

    public static int binarySearchInInfiniteArray(int[] arr, int target) {
        // Step 1: Find the range
        int start = 0, end = 1;
        
        while (target > arr[end]) {
            int newStart = end + 1;
            // Double the range size
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        // Step 2: Apply binary search within the range
        return binarySearch(arr, target, start, end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Simulating an infinite array
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};

        System.out.println(binarySearchInInfiniteArray(arr, 17)); // Output: 8
        System.out.println(binarySearchInInfiniteArray(arr, 10)); // Output: -1
    }
}
