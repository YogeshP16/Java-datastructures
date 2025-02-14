
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


## **AVL Tree - Adelson-Velsky and Landis (Self balancing BT)**
- A self balancing BST to maintain balance structure by ensuring the height 
    difference (balance factor = h(left child) - h(right child))
  
### **1️⃣ What Problem Did We Have Before AVL?**  
    - Unbalanced BSTs become skewed → O(N) time complexity
    - Insertions in sorted order create a linked list-like structure 
    - Search, Insert, Delete operations slow down to O(N) instead o(log N)  

``` skewed right tree (Unbalanced tree)
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
- **Balance Factor** = `Height(Left subtree) - Height(Right subtree)`  
- **A node is unbalanced if |Balance Factor| > 1** 
- **For any node in AVL tree, if the **Balance Factor (BF) is -1, 0, or +1** -> No Rotation needed**

### **AVL Tree Balance Factor Rules:**
- **BF = -1, 0, +1** → ✅ Balanced (No Rotation Needed)
- **BF ≤ -2 or BF ≥ +2** → ❌ Unbalanced (Rotation Required)

### **Example Cases:**
1. **BF = 0 (Balanced)**
   ```
       A (0)
      /   \
    B(0)   C(0)
   ```
   - **BF(A) = Height(B) - Height(C) = 1 - 1 = 0** ✅  
   - **No rotation needed.**

2. **BF = +1 (Balanced)**
   ```
       A (+1)
      /
    B(0)
   ```
   - **BF(A) = Height(B) - Height(NULL) = 1 - 0 = +1** ✅  
   - **No rotation needed.**

3. **BF = -1 (Balanced)**
   ```
       A (-1)
          \
           B(0)
   ```
   - **BF(A) = Height(NULL) - Height(B) = 0 - 1 = -1** ✅  
   - **No rotation needed.**

4. **BF = +2 (Unbalanced, Rotation Needed)**
   ```
         A (+2) ❌
        /
       B (+1)
      /
     C (0)
   ```
   - **BF(A) = Height(B) - Height(NULL) = 2 - 0 = +2** ❌  
   - **Rotation needed (LL case → Right Rotation).**


#### **Rotations to restore balance**
- When a node becomes unbalanced after insertion/deletion, we perform rotations:

1️⃣ **LL (Left-Left) → Right Rotation**   
2️⃣ **RR (Right-Right) → Left Rotation**   
3️⃣ **LR (Left-Right) → Left + Right Rotation**  
4️⃣ **RL (Right-Left) → Right + Left Rotation**   

---

## **Here are diagrams for all four AVL Tree rotations:**

---

### **1️⃣ LL (Left-Left) Rotation → Right Rotation**  
**Insertion in the left subtree of the left child → Right Rotation** 

---

#### **Before Rotation (Unbalanced)**
```
              A (BF = +2 ❌)
           /     \
         B(+1)   4 (0)
        / \
       C   3(0)
       / \
     1(0)  2(0)
```
#### **Balance Factor Calculation (Before Rotation):**  
- **BF(A) = Height(B) - Height(4) = 3 - 1 = +2** ❌ (Unbalanced)
- **BF(B) = Height(C) - Height(3) = 2 - 1 = +1** ✅
- **BF(C) = Height(1) - Height(2) = 1 - 1 = 0** ✅  
- **BF(1), BF(2), BF(3), BF(4) = 0** (Leaf nodes)

#### **Clarification on Height Calculation for A:**
- The left subtree of A (rooted at B) has a maximum height of **3**, calculated as:
  - **Path:** A → B → C → 1 (Height = 3)
  - **Path:** A → B → C → 2 (Height = 3)
- The right subtree of A (rooted at 4) has a height of **1** (since 4 is a leaf node).
- Thus, **BF(A) = 3 - 1 = +2** (Unbalanced).

#### 📌 **Fix:** Perform **Right Rotation on A**  

---

#### **After Right Rotation (Balanced)**
```
        B (BF = 0 ✅)
       /   \
      C (0)  A (0)
     / \    /  \
    1 (0) 2 (0) 3 (0)  4 (0)
```

#### **Balance Factor Calculation (After Rotation):**
- **BF(B) = Height(C) - Height(A) = 2 - 2 = 0** ✅  
- **BF(A) = Height(3) - Height(4) = 1 - 1 = 0** ✅  
- **BF(C) = Height(1) - Height(2) = 1 - 1 = 0** ✅  
- **All leaf nodes (1, 2, 3, 4) have BF = 0** ✅  

---

#### **Key Takeaways:**
1. **Balance Factor (BF)** = Height(Left Subtree) - Height(Right Subtree).
2. **For A (Before Rotation)**:
   - Left subtree height = **3** (B → C → 1 or 2).
   - Right subtree height = **1** (only node 4).
   - BF(A) = **3 - 1 = +2** ❌ (Unbalanced).
3. **After Right Rotation on A**, the tree is **balanced**, and all nodes have BF within the valid range (-1, 0, +1).

---

### **2️⃣ RR (Right-Right) Rotation → Left Rotation**  
**Insertion in the right subtree of the right child → Left Rotation**  

---

#### **Before Rotation (Unbalanced)**
```
        A (BF = -2 ❌)
       /     \
      1 (0)   B (-1)
            /    \
          2 (0)   C (0)
                    \
                     3 (0)
```
#### **Balance Factor Calculation (Before Rotation):**  
- **BF(A) = Height(B) - Height(1) = 3 - 1 = -2** ❌ (Unbalanced)  
- **BF(B) = Height(C) - Height(2) = 2 - 1 = -1** ✅  
- **BF(C) = Height(NULL) - Height(3) = 0 - 1 = -1** ✅  
- **BF(1), BF(2), BF(3) = 0** (Leaf nodes)  

📌 **Fix:** Perform **Left Rotation on A**  

---

#### **After Left Rotation (Balanced)**
```
        B (BF = 0 ✅)
       /   \
      A (0)  C (0)
     /  \      \
    1 (0) 2 (0) 3 (0)
```

#### **Balance Factor Calculation (After Rotation):**
- **BF(B) = Height(A) - Height(C) = 2 - 2 = 0** ✅  
- **BF(A) = Height(1) - Height(2) = 1 - 1 = 0** ✅  
- **BF(C) = Height(NULL) - Height(3) = 0 - 1 = 0** ✅  
- **All leaf nodes (1, 2, 3) have BF = 0** ✅  

---

### **3️⃣ LR (Left-Right) Rotation → Left Rotation on B, then Right Rotation on A**  
**Insertion in the right subtree of the left child → LR Rotation (Left Rotation + Right Rotation)**  

---

#### **Before Rotation (Unbalanced)**
```
        A (BF = +2 ❌)
       /     \
      B (+1)   4 (0)
     /   \
    1 (0)  C (-1)
             \
              2 (0)
```
#### **Balance Factor Calculation (Before Rotation):**  
- **BF(A) = Height(B) - Height(4) = 3 - 1 = +2** ❌ (Unbalanced)  
- **BF(B) = Height(1) - Height(C) = 1 - 2 = -1** ❌ (Indicates LR Case)  
- **BF(C) = Height(NULL) - Height(2) = 0 - 1 = -1** ✅  
- **BF(1), BF(2), BF(4) = 0** (Leaf nodes)  

📌 **Fix:** Perform **Left Rotation on B (to convert LL case), then Right Rotation on A**  

---

#### **After Left Rotation on B**
```
        A (BF = +2 ❌)
       /     \
      C (0)   4 (0)
     /   \
    B (0)  2 (0)
   /
  1 (0)
```
📌 **Now it becomes an LL Case → Perform Right Rotation on A**  

---

#### **After Right Rotation on A (Balanced)**
```
        C (BF = 0 ✅)
       /   \
      B (0)  A (0)
     /      /  \
    1 (0)  2 (0) 4 (0)
```

#### **Balance Factor Calculation (After Rotation):**
- **BF(C) = Height(B) - Height(A) = 2 - 2 = 0** ✅  
- **BF(B) = Height(1) - Height(NULL) = 1 - 0 = 0** ✅  
- **BF(A) = Height(2) - Height(4) = 1 - 1 = 0** ✅  
- **All leaf nodes (1, 2, 4) have BF = 0** ✅  

---

### **4️⃣ RL (Right-Left) Rotation → Right Rotation on B, then Left Rotation on A**  
**Insertion in the left subtree of the right child → RL Rotation (Right Rotation + Left Rotation)**  

---

#### **Before Rotation (Unbalanced)**
```
        A (BF = -2 ❌)
       /     \
      1 (0)   B (-1)
            /   \
          C (+1)  4 (0)
         /
        2 (0)
```
#### **Balance Factor Calculation (Before Rotation):**  
- **BF(A) = Height(B) - Height(1) = 3 - 1 = -2** ❌ (Unbalanced)  
- **BF(B) = Height(C) - Height(4) = 2 - 1 = +1** ❌ (Indicates RL Case)  
- **BF(C) = Height(2) - Height(NULL) = 1 - 0 = +1** ✅  
- **BF(1), BF(2), BF(4) = 0** (Leaf nodes)  

📌 **Fix:** Perform **Right Rotation on B (to convert RR case), then Left Rotation on A**  

---

#### **After Right Rotation on B**
```
        A (BF = -2 ❌)
       /     \
      1 (0)   C (0)
             /   \
            2 (0)  B (0)
                    \
                     4 (0)
```
📌 **Now it becomes an RR Case → Perform Left Rotation on A**  

---

#### **After Left Rotation on A (Balanced)**
```
        C (BF = 0 ✅)
       /   \
      A (0)  B (0)
     /  \      \
    1 (0) 2 (0) 4 (0)
```

#### **Balance Factor Calculation (After Rotation):**
- **BF(C) = Height(A) - Height(B) = 2 - 2 = 0** ✅  
- **BF(A) = Height(1) - Height(2) = 1 - 1 = 0** ✅  
- **BF(B) = Height(NULL) - Height(4) = 0 - 1 = 0** ✅  
- **All leaf nodes (1, 2, 4) have BF = 0** ✅  

---

### **Summary of Rotations:**
| **Case**  | **Unbalanced BF Condition** | **Fix** |
|-----------|----------------------------|---------|
| **LL**    | **BF(A) = +2, BF(B) = +1** | **Right Rotation on A** |
| **RR**    | **BF(A) = -2, BF(B) = -1** | **Left Rotation on A** |
| **LR**    | **BF(A) = +2, BF(B) = -1** | **Left Rotation on B, then Right Rotation on A** |
| **RL**    | **BF(A) = -2, BF(B) = +1** | **Right Rotation on B, then Left Rotation on A** |

---

### **5️⃣ Complexity**  
 **Time Complexity:** O(log N)  
 **Space Complexity:** O(N) (Same as BST)  

---

## **Segment Trees**  

### **What**
- it is a Binary tree which has interval info like indecies &  Operations like (sum, max...)

### **Problems Before Segment Trees?**  
1. **Brute Force**: Querying a range (sum, max, etc.) takes **O(N)** time.  
2. **Prefix Sum**: Works for sum queries but **fails for updates** (needs O(N) time). 
3. **updating arrays** also takes O(N) times

### **What Problem It Solves?**  
- Allows **fast range queries** (sum, max, etc.) in **O(log N)**.  
- Supports **efficient updates** in **O(log N)** instead of O(N).  
- To make tree O(N);

### **When to Use It?**  
Use when you need **fast range queries** (sum, max, min, product, etc.) **with updates**.  
Finding Range Sum Queries
Searching index with given prefix sum
Finding Range Maximum/Minimum
Counting frequency of Range Maximum/Minimum
Finding number of zeros in the given range or finding index of Kth zero

### Example (Sum Segment Tree for [1,3,5,7,9,11])
``` sum 
                  [sum(0,5)=36]
                 /             \
          [sum(0,2)=9]       [sum(3,5)=27]
          /       \          /        \
      [1,3]=4   [5]=5    [7,9]=16    [11]=11  
```
---

### Segment tree queries `range sum`, `range max`, etc., efficiently by **overcoming overlap issues**. Let's see how:

#### 🔴 **Types of Overlap**
1. **Total Overlap** → Query range (`L-R`) fully covers node range.  
   ✅ **Return** node value directly.
   
2. **No Overlap** → Query range (`L-R`) is outside node range.  
   ❌ **Ignore** (return 0 for sum, -∞ for max).

3. **Partial Overlap** → Query range partially covers node range.  
   🔄 **Divide & Recur**: Get results from **left & right** child nodes and merge.

#### ⚡ **Example**
_Array_: [1, 2, 3, 4, 5, 6, 7, 8]  
_Query_: Sum from index **2 to 6**  
_Segment Tree Nodes_:  
- **Root (0-7)** = Left (0-3) + Right (4-7)  
- Query `(2-6)` falls in **both** → Call **left (0-3) & right (4-7)**

💡 **Solution**:  
1. Take sum from left child `(2-3)` ✅  
2. Take sum from right child `(4-6)` ✅  
3. Merge results 🔗 (final sum).

---

## BFS

### Breadth-First Search (BFS) – Level Order Traversal**
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

### When to use
- when answer lies near the root node
- whenn you are asked  search by level -->  example : calculate sum of all levels in tree (level by level)

