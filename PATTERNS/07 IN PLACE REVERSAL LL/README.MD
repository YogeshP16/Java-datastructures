### **🔥 In-Place Reversal of a Linked List Pattern 🔥**  

### **📌 What is it?**  
The **In-Place Reversal of a Linked List** pattern is used when we need to **reverse** all or part of a linked list **without using extra space**. Instead of storing nodes in another data structure, we **change the links directly** in a single traversal.

---

### **📌 What Kind of Problems Does It Solve?**  
| **Problem Type**                   | **Use Case** |
|------------------------------------|-------------|
| **Reverse a Linked List**          | Reverse the entire list in-place |
| **Reverse a Sublist (Between m and n)** | Reverse a specific portion of the list |
| **Reverse K-Group Nodes**          | Reverse nodes in groups of K |
| **Check for Palindromic Linked List** | Reverse the second half and compare |
| **Rotate a Linked List**           | Reverse in parts to rotate |

---

### **📌 Single Template for All Problems**
```java
public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null, curr = head, next = null;

    while (curr != null) {
        next = curr.next; // Save next node
        curr.next = prev; // Reverse pointer
        prev = curr;      // Move prev forward
        curr = next;      // Move curr forward
    }

    return prev; // New head of the reversed list
}
```

---

### **📌 Where Can This Be Used?**
| **Problem Type**                     | **Modification Needed** |
|--------------------------------------|------------------------|
| **Reverse Entire Linked List**       | **Use template as is** |
| **Reverse a Sublist (Between m and n)** | Find m-th node before reversing |
| **Reverse K-Group Nodes**           | Reverse every K nodes using recursion or iteration |
| **Check Palindromic List**          | Reverse second half and compare |
| **Rotate a Linked List**            | Reverse in parts to rotate |

---

### **📌 Example Variations**
#### **1️⃣ Reverse Entire List**
```java
ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
reverseLinkedList(head);
// Output: 3 -> 2 -> 1
```

#### **2️⃣ Reverse a Sublist (Between m and n)**
```java
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || m == n) return head;
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    
    // Move prev to the node before m
    for (int i = 1; i < m; i++) prev = prev.next;

    ListNode curr = prev.next, next;
    for (int i = 0; i < n - m; i++) {
        next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }
    
    return dummy.next;
}
```
✔ **Use this when you need to reverse only part of the list.**  

---

Would you like me to break down **Reverse K-Group** or any other variation? 🚀