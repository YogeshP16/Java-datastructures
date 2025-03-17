The **Merge Intervals** pattern is frequently tested in **FAANG** and other top tech company interviews. It is commonly seen in **system scheduling, time management, and event overlap problems**.  

### **📌 Where Are These Questions Asked?**
| **Company**  | **Example Questions** |
|-------------|----------------------|
| **Google**  | Find Employee Free Time |
| **Amazon**  | Merge Intervals |
| **Facebook** | Meeting Rooms II |
| **Microsoft** | Insert Interval |
| **Apple** | Non-overlapping Intervals |
| **Uber** | Minimum Number of Meeting Rooms |

---

### **📌 LeetCode Questions on Merge Intervals**
| **Problem** | **LeetCode Link** |
|------------|-------------------|
| **Merge Intervals** | [LC 56](https://leetcode.com/problems/merge-intervals/) |
| **Insert Interval** | [LC 57](https://leetcode.com/problems/insert-interval/) |
| **Non-overlapping Intervals** | [LC 435](https://leetcode.com/problems/non-overlapping-intervals/) |
| **Meeting Rooms** | [LC 252](https://leetcode.com/problems/meeting-rooms/) |
| **Meeting Rooms II** | [LC 253](https://leetcode.com/problems/meeting-rooms-ii/) |
| **Employee Free Time** | [LC 759](https://leetcode.com/problems/employee-free-time/) |

These questions **test your ability to sort and merge intervals efficiently**, usually in **O(N log N) time complexity**.  

### **Merge Intervals Pattern**  

This **single template** can be used for various **merge interval problems** by modifying the merging condition as needed.

---

### **📌 Template**
```java
public int[][] mergeIntervals(int[][] intervals) {
    // Step 1: Sort intervals based on start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0]; // Start with the first interval

    for (int i = 1; i < intervals.length; i++) {
        // If the current interval overlaps, merge them
        if (intervals[i][0] <= current[1]) {
            current[1] = Math.max(current[1], intervals[i][1]); // Merge
        } else {
            result.add(current); // Store merged interval
            current = intervals[i]; // Move to the next interval
        }
    }

    result.add(current); // Add the last interval
    return result.toArray(new int[result.size()][]);
}
```

---

### **📌 Where Can This Be Used?**
| **Problem Type**                     | **Modification Needed** |
|--------------------------------------|------------------------|
| **Merge Overlapping Intervals**      | **No modification needed** |
| **Insert Interval**                   | Add the new interval before sorting |
| **Remove Covered Intervals**         | Ignore fully covered intervals |
| **Find Interval Intersections**      | Store overlapping parts instead of merging |
| **Meeting Rooms II (Min Heap Variant)** | Use a **min heap** instead of a list |

---

### **📌 Example Usage**
#### **1️⃣ Merging Overlapping Intervals**
```java
int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
mergeIntervals(intervals); 
// Output: [[1,6], [8,10], [15,18]]
```

#### **2️⃣ Insert a New Interval**
Modify the input to add a new interval before sorting:
```java
int[][] intervals = {{1,3}, {6,9}};
int[] newInterval = {2,5};
mergeIntervals(intervals); 
// Output: [[1,5], [6,9]]
```

---

This **single template** can be modified to solve almost **all interval-related problems**! 🚀  
Let me know if you need variations!