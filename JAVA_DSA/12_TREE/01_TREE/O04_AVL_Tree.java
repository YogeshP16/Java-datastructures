public class O04_AVL_Tree {
    class Node {
        int data;
        Node left, right;
        int height; // Store height of node

        Node(int data) {
            this.data = data;
            this.height = 1; // Corrected from 0 to 1 (leaf node should have height 1)
        }
    }

    Node root;

    // Get the height of a node
    public int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Insert
    void insert(int data) {
        root = insert(root, data);
    }

    Node insert(Node node, int data) {
        if (node == null) return new Node(data);

        if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);
        else return node; // Duplicate values are not allowed in BST

        // Update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Balance Factor Calculation
        int balanceFactor = getBalanceFactor(node);

        // LL Case → Right Rotate
        if (balanceFactor > 1 && data < node.left.data) return rightRotate(node);

        // LR Case → Left Rotate + Right Rotate
        if (balanceFactor > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR Case → Left Rotate
        if (balanceFactor < -1 && data > node.right.data) return leftRotate(node);

        // RL Case → Right Rotate + Left Rotate
        if (balanceFactor < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Get balance factor
    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // Right Rotation (LL case)
    private Node rightRotate(Node A) {
        Node B = A.left;
        Node T3 = B.right; // Temporary subtree

        B.right = A;
        A.left = T3;

        // Update heights
        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));

        return B;
    }

    // Left Rotation (RR case)
    private Node leftRotate(Node A) {
        Node B = A.right;
        Node T2 = B.left; // Temporary subtree

        B.left = A;
        A.right = T2;

        // Update heights
        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));

        return B;
    }

    // In-order traversal
    void inOrder() {
        inOrder(root);
        System.out.println();
    }

    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " (Height: " + node.height + ")  ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        O04_AVL_Tree tree = new O04_AVL_Tree();

        // Insert elements
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);

        // Inorder Traversal (Should print in sorted order)
        System.out.print("Inorder Traversal: ");  //  output -> 10 (Height: 1)  15 (Height: 2)  20 (Height: 1)
        tree.inOrder(); 
    }
}



/*

---

### **Step 1: Insert 10**  
- Tree is empty, so **10 becomes the root**.  
- **Height of 10 = 1**  
```
    10
```

---

### **Step 2: Insert 15**  
- **15 > 10**, so it goes to the right of 10.  
- **Height of 10 = 2**, **Height of 15 = 1**  
```
    10
      \
      15
```
✅ **Balanced**, since balance factor (BF) of 10 = `0 - 1 = -1` (within range **[-1,1]**).

---

### **Step 3: Insert 20**  
- **20 > 15**, so it goes to the right of 15.  
- **Height of 15 = 2**, **Height of 20 = 1**  
- **Height of 10 = 3**  
```
    10
      \
      15
        \
        20
```
⚠️ **Unbalanced at 10**  
- **Balance Factor of 10 = 0 - 2 = -2** (**Out of range!**)  
- Since **20 was inserted in the right subtree of 15**, this is an **RR (Right-Right) case**.  
- **Fix: Perform a Left Rotation on 10**.

---

### **Step 4: Left Rotation on 10**
- 15 becomes the new root.  
- 10 becomes the left child of 15.  
- 20 remains the right child of 15.  
- Heights are updated accordingly.  

#### **After Left Rotation**
```
       15
      /  \
    10    20
```
✅ **Balanced**, since:  
- **Balance Factor of 15 = (1 - 1) = 0**  
- **Balance Factor of 10 = 0 - 0 = 0**  
- **Balance Factor of 20 = 0 - 0 = 0**  

---

### **Final AVL Tree**
```
       15
      /  \
    10    20
```
*Now the AVL tree is balanced!*
 */