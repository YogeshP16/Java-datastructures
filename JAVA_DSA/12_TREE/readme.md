# **Tree Data Structure**

## **What is a Tree?**
- A **tree** is a hierarchical data structure that consists of **nodes** connected by **edges**. 
- It has a **root node** and branches out like an inverted tree.

### **Why**
- we can traverse, insert, remove items in **O(Log N) times**
- cost efficient -> restucture the things is not required
- Orderd storage

### **Real-life Applications**:
- **File System** (Folders and subfolders)
- **Organizational Hierarchy** (Company structure)
- **XML/HTML Parsing** (DOM structure)
- **Routing Algorithms** (Network routing, AI decision trees)

---

## **Tree Terminologies**

```
       A  <- Root  ----------------------------> level 0
      / \  <- Edge  
     B   C  <- Parent & Sibling ---------------> level 1
    / \   \
   D   E   F <- Child & Leaf (if no children) ----> level 2
```

1. **Root**     – The topmost node (A).
2. **Parent**   – A node that has children (A is the parent of B & C).
3. **Child**    – A node derived from a parent (B, C are children of A).
4. **Leaf**     – A node with no children (D, E, F).
5. **Sibling**  – Nodes that share the same parent (B & C are siblings).
6. **Depth**    – Distance from root (Depth of D = 2).
7. **Height**   – Longest path from a node to a leaf (Height of A = 2) 
                or Maximum No.of edges between from that node to leaf.
8. **Size**     - Total number of nodes
9. **Edge**     - A connection between two nodes. (Each parent-child connection)
10. **Level**   - Distance from the root.


---

## **Types of Trees**

1. **General Tree** – Any tree structure with no restrictions.
2. **Binary Tree** – Each node has at most **two children**.
3. **N-ary Tree** – Each node can have at most **N children**.


## **Binary Tree**
```
Binary Tree Example: 
       1
      / \
     2   3
    / \   \
   4   5   6
```
#### In linked list we have:

```java
class Node{
    int data;
    Node next;
}
```
#### In Binary Tree we have;
```java
class Node{
    int data;
    Node left;
    Node right;

}
```
### **🌳 Types of Binary Trees**
- A **binary tree** is a tree where each node has at most **two children**. 
- There are different types based on structure and properties.  

---

### **1️⃣ Full Binary Tree or Strict Binary Tree**  
➡ **Every node has either 0 or 2 children.**  
✅ No node has only one child.  

```
       1  
      / \  
     2   3  
    / \  / \  
   4   5 6  7  
```

---

### **2️⃣ Complete Binary Tree**  
➡ **All levels are completely filled except possibly the last level, which is filled from left to right.**  

```
       1  
      / \  
     2   3  
    / \  /  
   4   5 6  
```

---

### **3️⃣ Perfect Binary Tree**  
➡ **All internal nodes have two children, and all leaf nodes are at the same level.**  

```
       1  
      / \  
     2   3  
    / \  / \  
   4   5 6   7  
```

---

### **4️⃣ Balanced Binary Tree**  
➡ **The height difference between left and right subtrees is at most 1.**  
✅ **Example:** **AVL Tree, Red-Black Tree**  

```
       1  
      / \  
     2   3  
    / \  
   4   5  
```
(Height difference ≤ 1 for every node)

---

### **5️⃣ Degenerate (Skewed) Binary Tree**  
➡ **Each parent has only one child (like a linked list).**  
✅ Can be **left-skewed** or **right-skewed**.  

📌 **Left-Skewed:**  
```
       1  
      /  
     2  
    /  
   3  
  /  
 4  
```

📌 **Right-Skewed:**  
```
 1  
  \  
   2  
    \  
     3  
      \  
       4  
```

---

### **6️⃣ Orderd BT --> Binary Search Tree (BST)**  
➡ **For every node:**  
   - Left subtree **≤** Node  
   - Right subtree **>** Node  

```
       5  
      / \  
     3   7  
    / \  / \  
   2   4 6   8  
```
✅ Used for **fast search, insert, delete** operations.

---

🔹 **Summary Table:**

| Type                     | Definition                                                                  |
|--------------------------|-----------------------------------------------------------------------------|
| **Full Binary Tree**     | Every node has 0 or 2 children.                                             |
| **Complete Binary Tree** | All levels are full except possibly the last, filled left to right.         |
| **Perfect Binary Tree**  | All leaf nodes are at the same level, all internal nodes have 2 children.   |
| **Balanced Binary Tree** | Height difference between left & right subtree ≤ 1.                         |
| **Degenerate (Skewed)**  | All nodes have only one child (linked list-like).                           |
| **Binary Search Tree (BST)** | Left subtree ≤ Node, Right subtree > Node.                              |

---

## Properties that will help in some questions

- 1.  For perfect binary tree, Height = h
    - total nodes = 2^(n+1) - 1
    - at every level it doubling like level 1 have 1 node, then level 2 have 2 node , then level 3 have 4 nodes
    - if level = i, then no of nodes = 2^i 

- 2. leaf node in perfect BT = 2^h , h - height
    - 2^(n+1) - 1 - 2^h ==> 2^h -1

- 3. if you have N = no.of.leafs
        - log (N+1) levels
    if you have N = no.of.nodes
        - log (N+1)

4. if Strict BT, N -> leaf nodes
        - N-1 -> internal nodes
        - no of leaf nodes = no of internal nodes + 1

5. the no of leaf node = 1 + no of internal with 2 child (not including root node)


### **Binary Tree Implementation in Java**  

- Linked representation
- Sequential -> using arrays 

---

#### ** Linked representation -> Node Structure (TreeNode Class)**
Each node contains:  
- `data` → Stores the value.  
- `left` → Points to the left child.  
- `right` → Points to the right child.  

```java
class TreeNode {
    int data;
    TreeNode left, right;

    // Constructor
    TreeNode(int value) {
        data = value;
        left = right = null;
    }
}
```
---

### **🌳 Binary Search Tree (BST)**  

A **Binary Search Tree (BST)** is a **sorted binary tree** where:  
- Left subtree contains **smaller** values.  
- Right subtree contains **larger** values.  
- No duplicate values (in a strict BST).  

```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13
```

---

### **1️⃣ BST Node Definition**
Each node has `data`, `left`, and `right` pointers.
```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int value) {
        this.data = value;
        this.left = this.right = null;
    }
}
```

---



