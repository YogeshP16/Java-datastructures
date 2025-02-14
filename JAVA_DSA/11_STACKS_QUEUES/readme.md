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

