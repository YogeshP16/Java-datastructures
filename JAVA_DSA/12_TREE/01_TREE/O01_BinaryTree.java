public class O01_BinaryTree {
    class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    Node root;

    Node createTree(){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        return node;
    }

    // Preorder Traversal (Root → Left → Right)
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

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