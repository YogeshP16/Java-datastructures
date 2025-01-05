To identify whether you can apply **sliding window techniques** (fixed or dynamic templates) for **subarray**, **substring**, or **sum problems**.

---

### **1. Sliding Window Patterns in Problems**
#### **A. Fixed-Size Window (Statically Sized Sliding Window)**
- **Clues**:
  - The problem asks for a subarray/substring of a **fixed size**.
  - Examples:
    - Find the **maximum/minimum sum** of a subarray of size  ( k  ).
    - Count the number of subarrays of size  ( k  ) that satisfy a condition.
  - **Key Template**: Keep the window size fixed and slide it by adding one element and removing one element.
  
---

#### **B. Variable-Size Window (Dynamically Sized Sliding Window)**
- **Clues**:
  - The window size needs to adjust dynamically based on conditions.
  - The problem requires:
    1. Minimizing or maximizing the window size.
    2. Checking for specific conditions within the window.
  - Examples:
    - Find the **smallest/longest subarray** with a sum greater than or equal to  ( S  ).
    - Find the **longest substring** with at most  ( k  ) distinct characters.
    - Find the **minimum window substring** containing all characters of another string.
  - **Key Template**: Adjust the window size (expand/shrink) to maintain validity.

---

### **2. Key Problem Features for Sliding Window**
#### **A. Arrays or Strings: Subarray/Substrings**
- If the problem asks for:
  1. **Contiguous** elements in an array or string.
  2. Optimizing the size of a subarray/substring.
  3. Sums or counts within a range of elements.
  
#### **B. Constraints on the Window:**
- If the problem mentions conditions like:
  1. A **fixed window size** ( (k )).
  2. A **condition** (e.g., sum, distinct elements, repeating characters).
  3. Minimizing or maximizing the **length** of a subarray or substring.

---

### **3. How to Decide Fixed or Dynamic Window?**
| **Clue in Problem Statement**                                | **Type of Sliding Window** | **Template**                                                                                      |
|-------------------------------------------------------------|----------------------------|--------------------------------------------------------------------------------------------------|
| Subarray/Substring of **fixed size  (k )**                  | Fixed-Size                | Expand and maintain window size =  ( k  ).                                                      |
| Find **maximum/minimum sum** or value for size  (k )        | Fixed-Size                | Add/remove elements to keep the size fixed.                                                     |
| Problem involves a **sum** or **condition** to be satisfied | Dynamic                   | Expand and shrink window based on the sum/condition.                                            |
| Find **longest/smallest subarray/substring** meeting a condition | Dynamic                   | Adjust window size dynamically (expand/shrink).                                                 |
| Problem involves counting **distinct elements**             | Dynamic                   | Use a **HashMap** or **Set** to manage distinct elements in the window.                         |
| Problem requires finding **anagrams** or matching patterns  | Dynamic                   | Expand window, shrink as necessary, and track character counts using arrays or hashmaps.        |

---

### Fixed, Static, Non shrinkable

```java
public int findMaxWindow(int[] A, int N) {
    int i = 0, j = 0;
    while (j < N) {
        // CODE: use A[j] to update state which might make the window invalid
        if (invalid()) { // Increment the left edge ONLY when the window is invalid. In this way, the window GROWS when it's valid, and SHIFTS when it's invalid
            // CODE: update state using A[i]
            i++;
        }
        // after `++j` in the for loop, this window `[i, j)` of length `j - i` MIGHT be valid.
        j++;
    }
    return j - i; // There must be a maximum window of size `j - i`.
}
```

Explanation:
- The `i` and `j` pointers represent the sliding window's left and right boundaries.
- The window will shift when it becomes invalid by incrementing `i`.
- The `invalid()` method should be replaced with your specific condition to check if the window is invalid.
- The loop will iterate through `j` and adjust `i` whenever necessary.
- The final result is the length of the largest valid window, represented by `j - i`.

Make sure to implement the logic for checking the invalid window condition based on the specific problem you're solving.


---
### Dynamic, Shrinkable, variable

```java
public int findMaxWindow(int[] A, int N) {
    int i = 0, j = 0, ans = 0;
    while (j < N) {
        // CODE: use A[j] to update state which might make the window invalid
        while (invalid()) { // when invalid, keep shrinking the left edge until it's valid again
            // CODE: update state using A[i]
            i++;
        }
        ans = Math.max(ans, j - i + 1); // the window [i, j] is the maximum window we've found thus far
        j++;
    }
    return ans;
}
```

Explanation:
- `i` and `j` are the two pointers representing the window's left and right boundaries.
- The `invalid()` method should be replaced with a check for when the window becomes invalid (like a sum threshold being exceeded or having too many duplicates).
- The loop will adjust the left pointer (`i`) when the window is invalid.
- `ans` keeps track of the maximum valid window length.

To implement this in your specific problem, replace the `invalid()` condition and update logic to suit the problem you're solving.
---

### **5. Checklist to Recognize Sliding Window**
1. Does the problem deal with **subarrays** or **substrings**?
2. Are you looking to optimize **window size** or **value** (e.g., sum, count, characters)?
3. Is there a condition on the **elements in the window** (e.g., "sum ≥  ( S  )", "contains  ( k  ) distinct characters")?
4. Does the problem involve **contiguous elements**?

If the answer is **yes** to most of these, **sliding window** is likely applicable!


### Shrinkable
3. Longest Substring Without Repeating Characters
159. Longest Substring with At Most Two Distinct Characters (Medium)
340. Longest Substring with At Most K Distinct Characters
424. Longest Repeating Character Replacement
487. Max Consecutive Ones II
713. Subarray Product Less Than K
1004. Max Consecutive Ones III
1208. Get Equal Substrings Within Budget (Medium)
1493. Longest Subarray of 1's After Deleting One Element
1695. Maximum Erasure Value
1838. Frequency of the Most Frequent Element
2009. Minimum Number of Operations to Make Array Continuous
2024. Maximize the Confusion of an Exam 


Same as (with a slight modification)
https://leetcode.com/problems/maximum-subarray/
https://leetcode.com/problems/contiguous-array/description/
https://leetcode.com/problems/subarray-sum-equals-k/description/
https://leetcode.com/problems/subarrays-with-k-different-integers/description/
https://leetcode.com/problems/count-number-of-nice-subarrays/description/
https://leetcode.com/problems/binary-subarrays-with-sum/description/
https://leetcode.com/problems/subarray-product-less-than-k/description/
https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/