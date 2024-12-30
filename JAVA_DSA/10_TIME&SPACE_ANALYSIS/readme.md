## **Algorithms**
- Sequence of finite steps to perform some specific task.
- **Sum of 2 numbers**
  1. Take two numbers a & b.
  2. Compute c = a + b.
  3. Return c.

### **Properties of Algo**
- Terminates after a finite amount of time.
- Returns at least one output.
- Independent of any programming languages.
- Output should be unambiguous — deterministic (you should get the same output even after rerunning it after a few days).

### **Steps to construct an algorithm**
1. Understand the problem definition.
2. Design the algorithm (using techniques like Divide & Conquer, Greedy, Dynamic Programming, Backtracking, etc.).
3. Draw the flowchart.
4. Perform testing (test cases/edge cases).
5. Implementation.
6. Analyze (Time & Space complexity).

### **Asymptotic Notations**
- Big O — Worst case.
- Omega — Best case.
- Theta — Average case.

### **Analysis**
#### **Types**
1. **Aposteriori Analysis** — Completely dependent on the language, compiler, and types of hardware.
2. **Apriori Analysis** — Independent (depends on the logic of the code, not on languages, compilers, or hardware). With the help of Big O, we can produce useful results.

### **Apriori Analysis**
- **Example 1:**
  ```
  x = y + z  // Constant time --> O(1)
  ```

- **Example 2:**
  ```
  for (i = 0; i < n; i++) {
    x = y + z;  // Linear time --> O(n)
  }
  ```

- **Example 3:**
  ```
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      x = x + y;  // Quadratic time --> O(n^2)
    }
  }
  ```

- **Example 4:**
  ```
  i = n;
  while (i > 1) {
    i = i - 1;
    print("hello");  // Linear time --> O(n)
  }
  ```

- **Example 5:**
  ```
  i = n;
  while (i > 1) {
    i = i - 3;
    print("loki");  // Linear time --> O(n)
  }
  ```

- **Example 6:**
  ```
  i = 1;
  n = 64;
  while (i < n) {
    i = 2 * i;
    print(i);  // Logarithmic time --> O(log n)
  }
  ```
  
---
### **1. What is Time and Space Complexity?**
- **What:** Measures the efficiency of an algorithm in terms of:
  - **Time Complexity (TC):** How execution time grows with input size grows.
  - **Space Complexity (SC):** How memory usage grows with input size.
- **Usage:** Helps evaluate and compare algorithms to choose the most efficient one.
- **Behavior:** 
  - **TC:** Depends on loops, recursion, and operations.
  - **SC:** Includes input size, variables, recursion stack, etc.

---

### **2. Example: Time Complexity**
- **Code Example:**
  ```java
  for (int i = 0; i < n; i++) {
      System.out.println(i);
  }
  ```
  **TC:**  ( O(n)  ), as the loop runs `n` times.  
  **SC:**  ( O(1)  ), as it uses a fixed amount of memory.

---

### **3. Comparing Complexities**
- **Common Orders:**  
  - (O(1) - Constant)
  - (O( log n) - Logarithmic)
  - (O(n) - Linear)
  - (O(n log n) -  linear logarithmic)
  - (O(n^2) - Quadratic)
  - (O(n^3) - Cubic)
  - (O(2^n) - Exponential)
  - (O(n!) - Factorial)
  - (O(n^n))

- **Key:** Lower complexity is better for larger inputs.
 
---

### **4. Procedure for Analyzing Complexity with Example**

When analyzing the time complexity of an algorithm or application, the goal is to assess its performance under different conditions, especially the worst-case scenario. Here's a refined step-by-step process with an example:

---

### **1. Always Look for Worst-Case Time Complexity**

When developing an application, always consider the worst-case scenario—i.e., how the system behaves with the maximum input size. For example, if an app has 10 users vs. 10,000 users, the worst-case scenario is with 10,000 users, as it could cause a crash due to load. Hence, the algorithm must be designed for the worst-case performance.

---

### **2. Always Consider Complexity for Large Data**

When evaluating the algorithm, think about how it scales with larger datasets. It is essential to analyze the complexity for large `n` (input size) because this gives a realistic view of how the system will perform as data grows.

---

### **3. Ignore Actual Time; Focus on Growth**

When analyzing algorithms, we care more about how the time grows relative to the input size. For example:
- `y = x` and `y = 2x` or `y = 3x` all grow linearly with `x`. We don't care about the constant multipliers like `2` or `3`; they do not significantly affect the overall complexity.

This means, if we have:
- `O(N)`, `O(2N)`, `O(3N)`, all of these are still considered **O(N)**.

---

### **4. Ignore Constants and Non-Dominant Terms**

When you get a final expression for time complexity, drop constants and less dominant terms. 

For example:
- If you get an expression like `O(N^3 + 2N^2 + N + 3)`, drop the constants (e.g., `2`, `3`) and non-dominant terms (e.g., `N^2`), leaving you with `O(N^3)` as the most significant term.

---

### **Procedure to Analyze Time Complexity:**

1. **Identify Loops, Recursion, and Operations:**
   - Count how many times the operations inside loops and recursion are executed in terms of the input size.

2. **Count Operations in Terms of Input Size (`n`):**
   - For example, a loop running `n` times takes `O(n)` time. Nested loops should multiply their complexities.

3. **Drop Constants and Non-Dominant Terms:**
   - For example, if the expression for time complexity is `O(N^2 + 5N + 100)`, after ignoring the constants and lower-order terms, the result is simply `O(N^2)`.

---

### **Example:**

Consider the following code snippet to analyze its time complexity:

```java
for (int i = 0; i < n; i++) {            // Loop 1
    for (int j = 0; j < n; j++) {        // Loop 2
        // Constant time operation
    }
}

for (int k = 0; k < n; k++) {            // Loop 3
    // Constant time operation
}
```

**Analysis:**

- **First two nested loops**: The outer loop runs `n` times. For each iteration of the outer loop, the inner loop also runs `n` times, so the total operations are `n * n = O(n^2)`.

- **Third loop**: This loop runs `n` times, with each operation taking constant time, so this contributes `O(n)`.

**Final Complexity:**

- Combining the complexities: `O(n^2) + O(n)`
- After dropping the non-dominant term: The final time complexity is **O(n^2)**.

---
### Upper lower Bound
- Upper Bound --> example 10/3 = 3.33 ==> add 1 --->  4
- Lower Bound --> 10/3 = 3.33 ==> get before decimal value ---> 3

### **5. Big-Oh Notation ( ( O  )) --> Upper Bound  **
- **What:** Worst-case growth rate.
- **Example:**  ( O(n^2)  ) for nested loops over `n`, it cannot exceeds the O(N^2).
- f(n) / g(n) > 0;
- O(n3 + n2 + 2n + 3) ==> o(n3)

### **6. Big-Omega Notation ( (  Omega  )) --> Lower Bound**
- **What:** Best-case growth rate.
- **Example:**  (  Omega(n)  ) for linear search when the first element matches. it cannot be less than Omega(n);
- f(n) / g(n) < 0;
- O(n3 + n2 + 2n + 3) ==> o(n3)

### **7. Big-Theta Notation ( (  Theta  ))  --> Combining both upper and lower bound**
- **What:** Average-case growth rate (tight bound).
- **Example:**  (  Theta(n  log n)  ) for Merge Sort.

### **8. Little-Oh Notation ( ( o  ))**
- **What:** Strict upper bound.
- **Example:**  ( o(n^2)  ) means growth is less than  ( n^2  ).

### **9. Little-Omega Notation ( (  omega  ))**
- **What:** Strict lower bound.
- **Example:**  (  omega(n)  ) means growth is faster than  ( n  ).

---

### **10. Space Complexity**
- **What:** Memory usage of an algorithm.
- **Components:**
  1. Input Space  --> Refers to the memory required for storing the input data, which is provided as part of the problem
  (ex: array is sorted)
  2. Auxiliary Space  --> Refers to the extra memory used by the algorithm during execution to store temporary variables, recursion stack, etc.
  3. Recursion Stack --> The stack of function calls created during recursion.
- **Example:**  
  Fibonacci with recursion uses  ( O(n)  ) stack space; iterative uses  ( O(1)  ).

---

### **11. Sorting Algorithms Complexity**
| Algorithm       | Time Complexity   | Space Complexity |
|------------------|-------------------|------------------|
| Bubble Sort      |  ( O(n^2)  )      |  ( O(1)  )       |
| Merge Sort       |  ( O(n  log n)  ) |  ( O(n)  )       |
| Quick Sort       |  ( O(n  log n)  ) (avg) |  ( O( log n)  ) |

---

### **12. Recursive Programs**
- Use recurrence relations to derive TC.
- Example:  
  Fibonacci recursion:
   ( T(n) = T(n-1) + T(n-2) + O(1)  )

---


```
                    f(4)                     // Initial call to f(4)
               /             \
           f(3)               f(2)            // f(4) calls f(3) and f(2)
          /    \             /   \
       f(2)     f(1)      f(1)   f(0)    // f(3) calls f(2) and f(1), f(2) calls f(1) and f(0)
      /  \      /  \      /  \
    f(1) f(0) f(0)  f(0) f(0)  (base case reached)
```

### **Step-by-Step Breakdown:**

1. **Call to f(4)**:  
   - `f(4)` is the first call. It tries to calculate its result by calling `f(3)` and `f(2)`.

2. **Call to f(3)**:  
   - When `f(4)` calls `f(3)`, `f(3)` further calls `f(2)` and `f(1)`.

3. **Call to f(2)**:  
   - `f(3)` calls `f(2)` which then calls `f(1)` and `f(0)`. 
   - `f(2)` calls `f(1)`, so the recursion stack increases.

4. **Base Case f(0)**:  
   - Once `f(0)` is called, the recursion depth reaches its limit for that branch. We stop recursing, and `f(0)` returns a value (base case).
   
5. **Space Occupation**:
   - Each function call (like `f(4)`, `f(3)`, etc.) takes up space on the **recursion stack**.
   - As the function calls keep nesting deeper, the recursion stack grows.
   - For example, when `f(4)` calls `f(3)`, the space used by `f(3)` is added to the stack. Similarly, `f(3)` calls `f(2)`, which adds space for `f(2)`, and so on.
   - The **maximum depth** of the recursion stack is reached when `f(0)` is called, and all previous recursive calls are waiting for `f(0)` to complete before returning.

### **Recursion Stack Breakdown**:

1. `f(4)` starts at the top of the stack.
2. `f(3)` is called, and it is added to the stack.
3. `f(2)` is called within `f(3)`, adding another layer to the stack.
4. `f(1)` is called within `f(2)`, adding another layer.
5. Finally, `f(0)` is reached at the deepest point, which is the base case.

**Space Complexity**:  
- The maximum depth of the recursion stack here is 5 (`f(4)` → `f(3)` → `f(2)` → `f(1)` → `f(0)`).
- Hence, the space complexity is proportional to the maximum recursion depth, which is `O(n)` in this example (where `n = 4`).


### **13. Recurrence Relations**
- **Types:**
  1. **Divide-and-Conquer:**  ( T(n) = 2T(n/2) + O(n)  )
  2. **Linear:**  ( T(n) = T(n-1) + O(1)  )
  3. **Non-Homogeneous:**  ( T(n) = T(n-1) + f(n)  )

- **Akra-Bazzi Theorem:** Solves divide-and-conquer relations.  
- **Homogeneous Linear Relations:** Use characteristic equations.

---

### **14. Fibonacci with Golden Ratio**
- **Formula:**  ( F(n) =  frac{ phi^n - (1- phi)^n}{ sqrt{5}}  ), where  (  phi =  frac{1+ sqrt{5}}{2}  ).

---

### **15. NP-Complete Problems**
- **What:** Problems for which no known polynomial-time solution exists, but verifying a solution is polynomial.
- **Example:** Traveling Salesman Problem (TSP).

---

### **Question: Solve Recurrence Relation with Repeated Roots**
- Example:  ( T(n) = 2T(n/2) + O(n)  )  
  - Solution:  ( T(n) = O(n  log n)  ).

---
