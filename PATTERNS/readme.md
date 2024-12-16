# Constraints Check
------------------

- **if n < 100**  
  ---> O(2^N), N! ---> e.g., brute force, backtracking
  
- **if n < 3000**  
  ---> O(N^2) ---> e.g., Nested loops, dynamic programming

- **if 3000 < n < 10^6**  
  ---> O(N), O(N Log N) ---> e.g., Two pointer, sliding window, binary search, greedy, heap, sorting (merge, quick)

- **if n > 10^6**  
  ---> O(Log N), O(1) ---> e.g., Binary search, math-related problems

# Patterns 
----------

### Cyclic Sort  
- **When to use:** When the array contains a range of numbers, e.g., {1, N} or {0, N}.  
- **Examples:** 
  - Find missing numbers.
  - Find duplicates.
  - Find all duplicates.
  - Find all numbers disappeared in the array.
  - Set mismatch.
  - First missing positive.

### Two Pointer  
- **When to use:** Start from both ends or from the start of two arrays.
  - **From both ends:**  
    - Checking if an array is a palindrome.
    - Two-sum problems on sorted arrays.
    - Partitioning an array.
    - Reversing an array.
    - Trapping rain water.
    - Next permutations.
  - **From the start of two arrays:**  
    - Merging two sorted arrays.
    - Finding the intersection of two sorted arrays.
    - Comparing sequences.
    - Median finder.
    - Substring-related problems.

### Fast-Slow Pointer  
- **When to use:** Detect cycles in a sequence or find the middle of a linked list.
- **Examples:** 
  - Detecting a cycle in a linked list (Floyd's Tortoise and Hare).
  - Finding the middle element of a linked list.
  - Finding the starting point of a cycle in a linked list.

### Binary Search  
- **When to use:** When the array is sorted.
- **Examples:**  
  - Finding a target in a sorted array.
  - Finding the smallest or largest element satisfying a condition (e.g., smallest number greater than or equal to a target).
  - Search in rotated sorted arrays.
  - Searching in a 2D matrix (row and column sorted).

### Modified Binary Search  
- **When to use:** Apply binary search on problems that don't exactly fit the standard binary search but can be modified.
- **Examples:**  
  - Finding the peak element in an array.
  - Finding the first/last occurrence of an element in a sorted array.
  - Solving problems with conditions like "greater than" or "less than" in a binary search way.
  - Finding the transition point in an array (e.g., first `1` in a binary array).

### Sliding Window  
- **When to use:** For problems involving subarrays or substrings of fixed or variable length.
- **Examples:**  
  - Maximum sum of subarrays of size K.
  - Longest substring with at most K distinct characters.
  - Finding the minimum window substring containing all characters of another string.
  - Substring with at least K distinct characters.
  
### Greedy Algorithm  
- **When to use:** When you can make the optimal choice at each step, which leads to a global optimum.
- **Examples:**  
  - Interval scheduling (e.g., meeting rooms).
  - Activity selection problem.
  - Huffman coding.
  - Job scheduling with deadlines.
  - Coin change (minimizing the number of coins).

### Heap  
- **When to use:** For problems requiring dynamic retrieval of the smallest or largest elements.
- **Examples:**  
  - Kth largest/smallest element.
  - Merge k sorted lists.
  - Running median (sliding window problem).
  - Priority queue applications.

### Dynamic Programming  
- **When to use:** When solving problems that involve overlapping subproblems.
- **Examples:**  
  - Fibonacci numbers.
  - Longest common subsequence.
  - Knapsack problem.
  - Coin change problem (minimum coins).
  - Edit distance.

### Backtracking  
- **When to use:** When solving problems where you need to explore all possible solutions by building up a solution incrementally.
- **Examples:**  
  - N-Queens problem.
  - Permutations and combinations.
  - Sudoku solver.
  - Subset sum problem.
  - Graph coloring.

### Topological Sort  
- **When to use:** When dealing with directed acyclic graphs (DAG).
- **Examples:**  
  - Task scheduling.
  - Course prerequisite problem.
  - Dependency resolution.

### Divide and Conquer  
- **When to use:** When a problem can be divided into subproblems that can be solved independently.
- **Examples:**  
  - Merge sort.
  - Quick sort.
  - Binary search.
  - Closest pair of points.

### Math-Related  
- **When to use:** When the problem involves mathematical formulas or techniques.
- **Examples:**  
  - GCD (Greatest Common Divisor) and LCM (Least Common Multiple).
  - Prime factorization.
  - Permutation and combination.
  - Modular arithmetic.

### Union-Find (Disjoint Set Union)  
- **When to use:** For problems involving connectivity between nodes.
- **Examples:**  
  - Kruskal's algorithm for Minimum Spanning Tree.
  - Connected components in a graph.
  - Find the number of disjoint sets.
