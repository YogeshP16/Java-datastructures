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


        
    }

}
