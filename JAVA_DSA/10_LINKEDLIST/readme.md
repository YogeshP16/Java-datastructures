### **Linked List**  

#### **What is it?**  
Linked List is a **dynamic data structure** where elements (nodes) are stored in a **non-contiguous** manner. 
Every node has **two parts**:  
1. **Data** - Stores the actual value.  
2. **Next** - Stores the reference (address) of the next node.  

 **Example:**  
   ```
   10 -> 20 -> 30 -> null

   10 -> Head (Ref variable)
   30 -> Tail
   ```

---

### **Before (Problem with Arrays)**  
❌ **Fixed Size** – Cannot grow/shrink dynamically. *(O(N) for resizing)*  
❌ **Insertion/Deletion Costly** – Need to shift elements. *(O(N) in worst case)*  

### **After (Solution with Linked List) ✅**  
✔ **Dynamic Size** – No fixed limit, grows as needed. *(O(1) for insert at head)*  
✔ **Fast Insert/Delete** – Just update pointers, no shifting. *(O(1) at head, O(N) for search)*  
✔ **Memory Efficient** – Uses only required space. *(Extra O(N) for pointers)*  

### **Time & Space Complexity**  
| Operation  | Array (TC) | Linked List (TC) | Linked List (SC) |
|------------|-----------|------------------|------------------|
| Access     | **O(1)**  | **O(N)** (search needed) | **O(N)** (extra pointers) |
| Insert (End) | **O(1)** (if space) / **O(N)** (if resize) | **O(1)** (tail pointer) | **O(N)** |
| Insert (Middle) | **O(N)** (shifting) | **O(N)** (traverse) | **O(N)** |
| Delete (Middle) | **O(N)** (shifting) | **O(N)** (traverse) | **O(N)** |

👉 **Linked List avoids shifting but uses extra space!** 🚀

---

### **Example - Simple Linked List (Tamil Comments)**  
```java
class Node {
    int data; // Data store panra place
    Node next; // Next node oda address store panra place
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; // First node oda address store agum
    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // First node create agum
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Last node varikum pogum
            }
            temp.next = newNode; // Last node ku new node attach panrom
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> "); // Data print panrom
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // Output: 10 -> 20 -> 30 -> null
    }
}
```
---
### **Types of Linked List**  

1️⃣ **Singly Linked List (forward traversal)**  
   - Each node has **data** and **next** (points to next node).  
   - Only **forward traversal** possible.  
   - **Insertion/Deletion easy** (No shifting like arrays).  
   - Used in **stacks, adjacency lists, hash chains**.  
   
   **Example:**  
   ```
   10 -> 20 -> 30 -> null
   ```

---

2️⃣ **Doubly Linked List (Both forward & backward)**  
   - Each node has **data, next (forward), and prev (backward)**.  
   - **Bidirectional traversal** (Both forward & backward).  
   - Insertion/Deletion is **faster** since we have `prev` pointer.  
   - Used in **browser history, undo-redo, LRU cache**.  

   **Example:**  
   ```
   null <- 10 <-> 20 <-> 30 -> null
   ```

---

3️⃣ **Circular Linked List (Continuous loop)**  
   - Last node’s **next** points back to **head**.  
   - **No null end** (Continuous loop).  
   - Used in **round-robin scheduling, multiplayer games**.  

   **Example (Singly Circular Linked List):**  
   ```
   10 -> 20 -> 30 --|
   ↑               ↓
   |---------------|
   ```

   **Example (Doubly Circular Linked List):**  
   ```
   10 <-> 20 <-> 30
   ↑              ↓
   |--------------|
   ```

---

### **Comparison Table (Fast Recall 🔥)**  
| Type | Traversal | Extra Space? | Use Case |
|------|----------|-------------|----------|
| **Singly Linked List** | Forward only | ❌ No extra space | Simple data storage |
| **Doubly Linked List** | Forward & Backward | ✅ Extra `prev` pointer | Undo/Redo, LRU Cache |
| **Circular Linked List** | Circular movement | ❌ (Single) / ✅ (Double) | Scheduling, Gaming |

---

### **Short & Sweet Summary**  
- **Singly LL** – Simple, forward only. ✅  
- **Doubly LL** – Backward possible, extra space needed. ✅  
- **Circular LL** – No end, keeps looping! 🔄 ✅  

---

### **Approach to Solve Linked List Problems**  

1️⃣ **Identify the Type of LL** – **Singly, Doubly, or Circular?** (Direction matters!)  
2️⃣ **Understand the Operation** – **Traversal, Insertion, Deletion, Reversal, Cycle Detection?**  
3️⃣ **Choose the Right Technique** – **Two Pointers, Recursion, Hashing, Slow-Fast Pointers?**  
4️⃣ **Dry Run on a Small Example** – **Simulate step by step!**  

---

### **Common Linked List Questions & How to Solve Them**  

| **Problem Type**       | **Example Questions**  | **Best Approach** |
|------------------------|----------------------|------------------|
| **Basic Traversal**     | Print LL, Find Length | Simple Loop (O(N)) |
| **Insertion & Deletion** | Insert at Head/Tail, Delete Node | Pointer Manipulation (O(1) for head, O(N) for tail) |
| **Reversal**           | Reverse LL, Reverse K Group | **Two Pointers** (O(N)) |
| **Cycle Detection**    | Detect Loop, Find Cycle Start | **Slow-Fast Pointer (Floyd’s Algorithm)** (O(N)) |
| **Merge & Intersection** | Merge Two Sorted LLs, Find Intersection | **Two Pointers, Hashing** (O(N)) |
| **Clone LL with Random Pointers** | Deep Copy Linked List | **HashMap or Two Pass Approach** (O(N)) |
| **Sort LL**           | Sort 0s,1s,2s, Merge Sort on LL | **Merge Sort (O(N log N))** |
| **Remove Duplicates** | Remove Duplicates from Sorted/Unsorted LL | **Sorting + Two Pointers / HashSet** (O(N)) |
| **Nth Node from End** | Find Kth Node from End | **Two Pointers** (O(N)) |
| **Add & Multiply Numbers** | Add Two LLs (Like Numbers) | **Reversal + Two Pointers** (O(N)) |

---

### **How to Pick the Right Approach?**  
1️⃣ **If traversal needed** → Use **loop or recursion**.  
2️⃣ **If searching required** → Use **hashing or two pointers**.  
3️⃣ **If modification (insertion/deletion)** → Change **next pointers carefully**.  
4️⃣ **If cycle/loop detection** → Use **slow-fast pointer**.  
5️⃣ **If merging/sorting** → Use **two pointers or merge sort**.  

