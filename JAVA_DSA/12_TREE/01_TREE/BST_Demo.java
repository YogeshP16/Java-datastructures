public class BST_Demo {
    public class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 0; // Default height for a new node
        }

        public int getData() {
            return data;
        }
    }

    private Node root;

    public BST_Demo() {
        root = null;
    }

    // Get the height of a node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Insert a value recursively
    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data); // Create new node if null
        }
        if (data < node.data) {
            node.left = insert(data, node.left);
        } else if (data > node.data) {
            node.right = insert(data, node.right);
        }

        // Update height after insertion
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    // Public insert method
    public void insert(int data) {
        root = insert(data, root);
    }

    // Inorder Traversal (Left -> Root -> Right)
    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Display tree (Inorder)
    public void display() {
        inorder(root);
        System.out.println();
    }

    // Search a value in BST
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    public static void main(String[] args) {
        BST_Demo tree = new BST_Demo();

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
