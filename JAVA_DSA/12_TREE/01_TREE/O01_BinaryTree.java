

/**
 * This class represents a simple binary tree and provides methods to create and traverse the tree.
 */
public class O01_BinaryTree {

    /**
     * This inner class represents a node in the binary tree.
     * Each node contains an integer data and references to left and right child nodes.
     */
    class Node {
        int data;
        Node left, right;

        /**
         * Constructor to create a new node with the given data.
         * @param data The integer value to be stored in the node.
         */
        Node(int data) {
            this.data = data;
        }
    }

    Node root; // Root node of the binary tree

    /**
     * Creates a sample binary tree with predefined values.
     * @return The root node of the created binary tree.
     */
    Node createTree() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        return node;
    }

    /**
     * Performs a preorder traversal of the binary tree.
     * Preorder traversal visits nodes in the order: Root → Left → Right.
     * @param node The starting node for the traversal.
     */
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * Main method to create a binary tree and perform a preorder traversal.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        O01_BinaryTree tree = new O01_BinaryTree();
        tree.root = tree.createTree();
        System.out.println("Pre order: ");
        tree.preorder(tree.root);
    }
}

/*
 Pre order: 
1 2 4 5 3 6 7  
 */