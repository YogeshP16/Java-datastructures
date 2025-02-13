
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

### **Binary Tree**
```
Binary Tree Example: 
       1
      / \
     2   3
    / \   \
   4   5   6
```
**In linked list we have:**

```java
class Node{
    int data;
    Node next;
}
```
**In Binary Tree we have;**
```java
class Node{
    int data;
    Node left;
    Node right;

}
```

## **Types of Binary Trees**
- A **binary tree** is a tree where each node has at most **two children**. 
- There are different types based on structure and properties.  

---

### **1️. Full Binary Tree or Strict Binary Tree**  
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

### **2️. Complete Binary Tree**  
➡ **All levels are completely filled except possibly the last level, which is filled from left to right.**  

```
       1  
      / \  
     2   3  
    / \  /  
   4   5 6  
```

---

### **3️. Perfect Binary Tree**  
➡ **All internal nodes have two children, and all leaf nodes are at the same level.**  

```
       1  
      / \  
     2   3  
    / \  / \  
   4   5 6   7  
```

---

### **4️. Balanced Binary Tree**  
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

### **5️. Degenerate (Skewed) Binary Tree**  
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

### **6️. Orderd BT --> Binary Search Tree (BST)**  
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
Used for **fast search, insert, delete** operations.

---

### **Summary Table:**

| Type                     | Definition                                                                  |
|--------------------------|-----------------------------------------------------------------------------|
| **Full Binary Tree**     | Every node has 0 or 2 children.                                             |
| **Complete Binary Tree** | All levels are full except possibly the last, filled left to right.         |
| **Perfect Binary Tree**  | All leaf nodes are at the same level, all internal nodes have 2 children.   |
| **Balanced Binary Tree** | Height difference between left & right subtree ≤ 1.                         |
| **Degenerate (Skewed)**  | All nodes have only one child (linked list-like).                           |
| **Binary Search Tree (BST)** | Left subtree ≤ Node, Right subtree > Node.                              |

---

## **Binary Tree Properties**
These properties help solve **tree-related problems efficiently**.

---

### **1️. Perfect Binary Tree (PBT)**
- A **Perfect Binary Tree** has **all levels completely filled**.
- If height **h**, then:
  - **Total Nodes** = (2^{h+1} - 1)
  - **Leaf Nodes** = (2^h)
  - **Nodes at Level (i)** = (2^i) (0-based index)

 **Example:**  
For **h = 3**, the tree looks like:
```
        1
       / \
      2   3
     / \  / \
    4  5 6  7
```
- **Total Nodes** = (2^{3+1} - 1 = 15)  
- **Leaf Nodes** = (2^3 = 8)   
- **Nodes at Level 2** = (2^2 = 4)   

---

### **2️. Leaf Nodes in a Perfect Binary Tree**
- **Leaf Nodes** = (2^h)  
- **Internal Nodes** = (2^{h} - 1)  

 **Example:**  
For **h = 3**:
- **Leaf Nodes** = (2^3 = 8)   
- **Internal Nodes** = (2^3 - 1 = 7)   

---

### **3️. Levels in a Tree**
- If there are **N leaf nodes**, then **levels** = (log_2 (N+1)).  
- If there are **N total nodes**, then **levels** = (log_2 (N+1)).  

 **Example:**  
For **N = 15 nodes**,  
- **Levels** = (log_2 (15+1) = log_2 (16) = 4)   

---

### **4️. Strict Binary Tree (Full Binary Tree)**
- A **Strict (Full) Binary Tree** is a tree where **every node has 0 or 2 children**.
- If **N = No. of Leaf Nodes**, then:
  - **Internal Nodes** = (N - 1)  
  - **Total Nodes** = (2N - 1)  

 **Example:**  
For **N = 4 leaf nodes**,  
- **Internal Nodes** = (4 - 1 = 3)   
- **Total Nodes** = (2 \times 4 - 1 = 7)   

```
        1
       / \
      2   3
     / \  / \
    4   5 6  7
```

---

### **5️. Number of Leaf Nodes and Internal Nodes**
- **Leaf Nodes** = **Internal Nodes + 1** (excluding root).  

 **Example:**  
For **3 internal nodes**,  
- **Leaf Nodes** = (3 + 1 = 4)  

---

## **Binary Tree Implementation in Java**  

- Linked representation
- Sequential -> using arrays 

---

### **Linked representation -> Node Structure (TreeNode Class)**
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

## **Binary Search Tree (BST)**  

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

### **BST Node Definition**
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

## **Tree Traversal Method**  
Tree traversal refers to visiting all **nodes** in a tree in a specific order.

---

### **1️⃣ Depth-First Search (DFS) Traversals**  
- **Uses recursion or a stack** to explore **as deep as possible** before backtracking.
- **Three types of DFS traversals:**  

#### **📌 1.1 Preorder (Root → Left → Right)**  
**Process:**  
1. Visit **Root**  
2. Visit **Left subtree**  
3. Visit **Right subtree**  

**When to use**
- DFS-Based Root-to-Leaf Path Problems.

✅ **Example:**  
```
        A
       / \
      B   C
     / \   \
    D   E   F
```
#### **Preorder (A → B → D → E → C → F)**  

**Code (Recursive):**
```java
void preOrder(Node node) {
    if (node == null) return;
    System.out.print(node.data + " "); // Visit root
    preOrder(node.left);  // Left subtree
    preOrder(node.right); // Right subtree
}
```

---

#### **📌 1.2 Inorder (Left → Root → Right)**
**Process:**  
1. Visit **Left subtree**  
2. Visit **Root**  
3. Visit **Right subtree**  

**When to use**
- for sorted order

✅ **Example:**  
```
        A
       / \
      B   C
     / \   \
    D   E   F
```
🔹 **Inorder (D → B → E → A → C → F)**  

**Code (Recursive):**
```java
void inOrder(Node node) {
    if (node == null) return;
    inOrder(node.left);   // Left subtree
    System.out.print(node.data + " "); // Visit root
    inOrder(node.right);  // Right subtree
}
```

---

#### **📌 1.3 Postorder (Left → Right → Root)**
**Process:**  
1. Visit **Left subtree**  
2. Visit **Right subtree**  
3. Visit **Root**  

**When to use**
- for deleting the Binary tree
- for bottom up calculation

✅ **Example:**  
```
        A
       / \
      B   C
     / \   \
    D   E   F
```
🔹 **Postorder (D → E → B → F → C → A)**  

**Code (Recursive):**
```java
void postOrder(Node node) {
    if (node == null) return;
    postOrder(node.left);   // Left subtree
    postOrder(node.right);  // Right subtree
    System.out.print(node.data + " "); // Visit root
}
```

---

### **2️⃣ Breadth-First Search (BFS) – Level Order Traversal**
- **Uses a queue** (FIFO) to visit nodes **level by level**.  

**Process:**  
1. Start with **Root**.  
2. Visit nodes **level by level** (Left → Right).  

✅ **Example:**  
```
        A
       / \
      B   C
     / \   \
    D   E   F
```
🔹 **Level Order (A → B → C → D → E → F)**  

**Code (Iterative using Queue):**
```java
void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        Node temp = queue.poll();
        System.out.print(temp.data + " ");
        
        if (temp.left != null) queue.add(temp.left);
        if (temp.right != null) queue.add(temp.right);
    }
}
```

---

### **🚀 Summary (Quick Table)**
| Traversal             | Order               |         Use Case               |
|-----------------------|---------------------|--------------------------------|
| **Preorder (DFS)**    | Root → Left → Right | Copying tree, Expression trees |
| **Inorder (DFS)**     | Left → Root → Right | Sorted order in BST            |
| **Postorder (DFS)**   | Left → Right → Root | Deleting tree, Expression trees|
| **Level Order (BFS)** | Level-by-Level      | Shortest path, Networking      |

---


## **AVL Tree - Adelson-Velsky and Landis**
  
### **1️⃣ What Problem Did We Have Before AVL?**  
    - Unbalanced BSTs become skewed → O(N) time complexity
    - Insertions in sorted order create a linked list-like structure 
    - Search, Insert, Delete operations slow down to O(N) instead o(log N)  

``` skewed right tree 
    1
     \
      2
       \
        3
         \
          4
```

---

### **2️⃣ What Does AVL Solve?**  
✅ **Self-balancing BST**  
✅ **Ensures O(log N) operations**  
✅ **Prevents skewed trees by keeping height minimal**  

---

### **3️⃣ How Does AVL Work?**  
📏 **Balance Factor** = `Height(Left subtree) - Height(Right subtree)`  
🔄 **A node is unbalanced if |Balance Factor| > 1** 

#### **Rotations to restore balance**
- When a node becomes unbalanced after insertion/deletion, we perform rotations:

1️⃣ **LL (Left-Left) → Right Rotation**   
2️⃣ **RR (Right-Right) → Left Rotation**   
3️⃣ **LR (Left-Right) → Left + Right Rotation**  
4️⃣ **RL (Right-Left) → Right + Left Rotation**   

---

### **4️⃣ Example of RR (Right-Right) Rotation**  
Before:  
```
   10
     \
      20
        \
         30
```
**Balance Factor = -2 (Unbalanced)**  
🔄 **Fix:** Left Rotate(10)  

After:  
```
      20
     /  \
   10    30
```
✅ **Now Balanced!**

---

### **5️⃣ Complexity**  
 **Time Complexity:** O(log N)  
 **Space Complexity:** O(N) (Same as BST)  

---

### **Summary**
🔹 **BSTs can become unbalanced → O(N) operations**  
🔹 **AVL keeps BSTs balanced → O(log N) operations**  
🔹 **Balance Factor ≤ 1 → Ensures efficient search, insert, delete**  
🔹 **Rotations fix imbalance → Keeps operations fast** 🚀  


