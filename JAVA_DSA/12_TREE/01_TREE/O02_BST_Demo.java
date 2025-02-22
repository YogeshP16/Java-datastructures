/**
 * This class demonstrates a simple Binary Search Tree (BST) implementation.
 */
public class O02_BST_Demo {

    /**
     * Represents a node in the BST.
     */
    public class Node {
        int data; // Value of the node
        Node left; // Left child
        Node right; // Right child
        int height; // Height of the node

        /**
         * Constructor to create a new node with given data.
         * @param data Value to be stored in the node.
         */
        public Node(int data) {
            this.data = data;
            this.height = 0; // Default height for a new node
        }

        /**
         * Get the data of the node.
         * @return Data of the node.
         */
        public int getData() {
            return data;
        }
    }

    private Node root; // Root of the BST

    /**
     * Constructor to initialize an empty BST.
     */
    public O02_BST_Demo() {
        root = null;
    }

    /**
     * Get the height of a node.
     * @param node Node whose height is to be determined.
     * @return Height of the node, -1 if node is null.
     */
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    /**
     * Check if the tree is empty.
     * @return True if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a value into the BST.
     * @param data Value to be inserted.
     */
    public void insert(int data) {
        root = insert(data, root);
    }

    /**
     * Display the BST in inorder traversal.
     */
    public void display() {
        inorder(root);
        System.out.println();
    }

    /**
     * Search for a value in the BST.
     * @param key Value to be searched.
     * @return True if the value is found, false otherwise.
     */
    public boolean search(int key) {
        return search(root, key);
    }

    /**
     * Main method to demonstrate BST operations.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        O02_BST_Demo tree = new O02_BST_Demo();

        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.print("BST Inorder (Sorted): ");
        tree.display(); // BST Inorder (Sorted): 1 3 4 6 7 8 10 13 14 

        System.out.println("Search 6: " + tree.search(6)); // true
        System.out.println("Search 15: " + tree.search(15)); // false
    }
}
