##  Stacks 

### **What is a Stack?**  
- A **LIFO (Last In, First Out)** data structure.  
- Think of a stack of plates: last added = first removed.  

### **Operations (O(1) Time)**  
- **Push(x):** Add `x` to the top.  (insert at end)
- **Pop():** Remove the top element.  (delete at end)
- **Peek():** See the top element without removing.  
- **isEmpty():** Check if stack is empty. 
- **Top:** return top most value.

### **When to Use?**  
- **Backtracking** (Undo operations, Recursion)  
- **Expression Evaluation** (Balanced Parentheses, Postfix)  
- **Monotonic Stack** (Next Greater Element)  

### **Stack Implementation**  
- **Using Array** (Fixed size, Fast)  
- **Using Linked List** (Dynamic size, Extra memory)  
- **Using Java’s Stack class** (`Stack<Integer> stack = new Stack<>();`)  


## **Queue**  

### **What is a Stack?** 
- A **queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.  
- Applications -> 

---

### **Queue Operations**
- **enqueue(x)**  Add element `x` to the rear (end) 
- **dequeue()**  Remove element from the front 
- **peek()**  Get the front element without removing it 
- **isEmpty()**  Check if the queue is empty 
- **Rear** point last element
- **Front** poiny first element

---

### **Implementation Methods**
- **Using Array**  
- **Using Linked List**  
- **Using Java's `Queue` Interface (`LinkedList` or `ArrayDeque`)**  

---

### **Queue Implementations in Java**
#### **🔹 Using `LinkedList` (Queue Interface)**
```java
import java.util.*;

Queue<Integer> queue = new LinkedList<>();
queue.offer(10); // Enqueue
queue.offer(20);
System.out.println(queue.poll()); // Dequeue (10)
System.out.println(queue.peek()); // Front element (20)
```
#### Operations Complexity:
- offer() → O(1) (Add element)
- poll() → O(1) (Remove front element)
- peek() → O(1) (View front element)

---

#### **Using `ArrayDeque` (Better than LinkedList)**
```java
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(1);
queue.offer(2);
System.out.println(queue.poll()); // 1
```
✔ **Faster than `LinkedList` (no extra node objects).**  

---

#### **Using `PriorityQueue` (Sorted Order)**
- when you need priority-based ordering (Min-Heap/Max-Heap).

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
pq.offer(1);
pq.offer(3);
System.out.println(pq.poll()); // 1 (smallest first)
```
✔ **Uses Min-Heap for sorting elements.**

#### Operations Complexity:
- offer() → O(log N) (Heapify)
- poll() → O(log N) (Heapify)
- peek() → O(1) (View smallest element)
---

### **When to Use a Queue?**
✔ **When order matters (FIFO processing).**  
✔ **For scheduling tasks (CPU Scheduling, BFS, Print Queue).**  

---

