### Fast-Slow Pointer

**Steps:**
1. **Initialization:** Start with two pointers, `slow` and `fast`. Set both pointers to the beginning of the list or array.
2. **Loop:** Move `slow` by one step and `fast` by two steps in each iteration.
3. **Termination Condition:** Check if `fast` reaches the end of the list or becomes null.
4. **Result:** Based on the problem, either:
   - If `fast` reaches the end, `slow` will be in the middle (useful for finding the middle of a list).
   - If `slow` and `fast` meet, it indicates a cycle (useful for cycle detection).
5. linear time complexity `O(n)` with constant space `O(1)`

**Code Template:**

```java
public class FastSlowPointer {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by 1 step
            fast = fast.next.next;     // Move fast by 2 steps
            
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }
}
```

**Use Cases:**
1. **Cycle Detection in Linked Lists**: Identifying if a linked list has a cycle.
2. **Middle Element of Linked List**: Finding the middle element by moving `slow` by one step and `fast` by two steps.
3. **Palindrome Linked List**: Using two pointers to check if a linked list forms a palindrome.
4. **Finding the Nth from End**: Detecting the Nth node from the end of a linked list.



