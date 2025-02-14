public class O03_BST_Impl {
    class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    Node root;

    // Insert
    void insert(int data) {
        root = insert(root, data);
    }

    Node insert(Node node, int data){
        if(node == null) return new Node(data);
        if(data < node.data) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);
        return node;
    }

    // Search
    boolean search(int key) {
        return search(root, key);
    }

    boolean search(Node node, int key){
        if(node == null) return false;
        if(node.data == key) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Travserse (In order) --> Left + root + right
    void inOrder(){
        inOrder(root);
        System.out.println();
    }

    void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Find Minimum
    Node findMin(Node node){
        while(node.left != null) node = node.left;
        return node;
    }

    // find max
    Node findMax(Node node){
        while(node.right != null) node = node.right;
        return node;
    }

        /*
        ### **Deleting a Node in a BST**  

        #### **Rules for Deletion in a BST**  
        1️ **Leaf Node (No children)** → Set parent’s link to `null`.  
        2️ **Node with One Child** → Link parent directly to the child.  
        3️ **Node with Two Children** →  
        - Find **inorder successor** (smallest in right subtree).  
        - Replace the node’s value with the successor’s value.  
        - Delete the successor from the right subtree.  

        ---

        #### **Example: Deleting 10 from this BST**
        ```
            10
            /  \
            5    15
                /  \
                12   20
        ```
        - **Case 1**: Delete **5** (Leaf) → Just remove it.  
        - **Case 2**: Delete **15** (One child, 12) → Link **10 → 12** directly.  
        - **Case 3**: Delete **10** (Two children)  
        - Inorder Successor = **12**  
        - Replace **10 → 12**, then delete **12** from right subtree.  

        **Final BST after deleting 10:**
        ```
            12
            /  \
            5    15
                \
                20
        ```
        */   
    // Delete node
    void delete(int data) {
        root = delete(root, data);
    }
    
    Node delete(Node node, int key){
        if(node == null) return node;
        if(key < node.data) node.left = delete(node.left, key);
        else if(key > node.data) node.right = delete(node.right, key);
        else{ // Key == node.data

             // Case 1: No child (Leaf Node) &  Case 2: One child (Left or Right)
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else{

                // Case 3: Two children → Replace with inorder successor (smallest in right subtree)
                Node successor = findMin(node.right); // Get inorder successor
                node.data = successor.data; // Copy successor's value
                node.right = delete(node.right, successor.data); // Delete the successor
            }
           
        }
        return node;

    }
 
                   

    public static void main(String[] args) {
        O03_BST_Impl tree = new O03_BST_Impl();

        // Insert elements
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(3);
        tree.insert(8);
        tree.insert(18);
        tree.insert(40);

        // Inorder Traversal (Should print in sorted order)
        System.out.print("Inorder Traversal: ");
        tree.inOrder(); // Output: 3 5 8 10 18 20 40

        // Search elements
        System.out.println("Search 8: " + tree.search(8)); // Output: true
        System.out.println("Search 15: " + tree.search(15)); // Output: false

        // Find Min & Max
        System.out.println("Minimum Value: " + tree.findMin(tree.root).data); // Output: 3
        System.out.println("Maximum Value: " + tree.findMax(tree.root).data); // Output: 40

        // Delete
        tree.root = tree.delete(tree.root, 20); // Update the root after deletion
        System.out.print("Inorder after deletion: "); // Inorder after deletion: 3 5 8 10 18 40 
        tree.inOrder(); 
        


        
    }

}
