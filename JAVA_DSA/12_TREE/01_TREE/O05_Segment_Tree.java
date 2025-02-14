public class O05_Segment_Tree {
    class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    // Constructor to build the Segment Tree
    public O05_Segment_Tree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // sum 
        node.data = node.left.data + node.right.data;
        return node;
    }

    // Query function for range sum
    /*  --> if query range & node range doest meet means No Overlap
        Example: 
            Query range → (4, 6)
            Node range → (0, 2)
            Since (4-6) doesn't touch (0-2), return 0.

        --> Query range (qs-qe) covers the entire node range, so we directly 
                return the node’s sum (no need to check children) --> Complete overlap.
        Example:
            Query range → (2, 5)
            Node range → (2, 5)
            Query perfectly matches node range → return node.data.

        --> Partial Overlap → Call both left & right children, sum results
        Example:
            Query range → (2, 6)
            Node range → (0, 7)

            Left child (0-3) overlaps partially → Recurse on it.
            Right child (4-7) overlaps partially → Recurse on it.
            Add both results together.
    */
    public int query(int qs, int qe) {
        return query(root, qs, qe);
    }

    private int query(Node node, int qs, int qe) {
        if (node == null || qs > node.endInterval || qe < node.startInterval) {
            return 0; // No overlap
        }
        if (qs <= node.startInterval && qe >= node.endInterval) {
            return node.data; // Complete overlap
        }
        return query(node.left, qs, qe) + query(node.right, qs, qe); // Partial overlap
    }

    // Update function
    public void update(int index, int newValue) {
        update(root, index, newValue);
    }

    private void update(Node node, int index, int newValue) {
        // base case
        if (node.startInterval == node.endInterval) {
            node.data = newValue;
            return;
        }

        int mid = (node.startInterval + node.endInterval) / 2;
        if (index <= mid) {
            update(node.left, index, newValue);
        } else {
            update(node.right, index, newValue);
        }
        
        node.data = node.left.data + node.right.data;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        O05_Segment_Tree tree = new O05_Segment_Tree(arr);
        
        // Query range sum
        System.out.println("Sum of range (2, 5): " + tree.query(2, 5)); // 18
        
        // Update an element
        tree.update(3, 10);
        System.out.println("Sum of range (2, 5) after update: " + tree.query(2, 5)); // 24
    }
}
