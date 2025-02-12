// Node Class for DLL

// Doubly Linked List Class
class DLL {
    private class Node {
        int data;
        Node next;
        Node prev;

        public Node (int data){
            this.data = data;
        }
    
        // Constructor to initialize a new node
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    Node head;
    Node tail;
    int size;

    // Insert at the beginning (head)
    public void insertFirst(int data) {
        Node node = new Node(data); // next = head, prev = null
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        } else {
            tail = node; // If inserting the first node, tail should also point to it
        }
        head = node;
        size++;
    }

    // Insert at the end (tail)
    public void insertLast(int data) {
        if (head == null) { // If list is empty, insertFirst
            insertFirst(data);
            return;
        }

        Node node = new Node(data, null, tail); // next = null, prev = tail
        tail.next = node;
        tail = node;
        size++;
    }

    // Delete the first node
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        }

        int data = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // If the list becomes empty
        }
        size--;
        return data;
    }

    // Delete the last node
    public int deleteLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty!");
        }

        int data = tail.data;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // If the list becomes empty
        }
        size--;
        return data;
    }

    // Print the Doubly Linked List
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}

// Main Class
public class DoublyLLDemo {
    public static void main(String[] args) {
        DLL l = new DLL();

        // Insert at the beginning
        l.insertFirst(20);
        l.insertFirst(30);
        l.insertFirst(40);
        l.insertFirst(60);
        l.insertFirst(80);
        l.insertFirst(100);

        // Print the list
        System.out.print("Doubly Linked List: ");
        l.print();  // Expected: 100 <-> 80 <-> 60 <-> 40 <-> 30 <-> 20 <-> End

        // Insert at the end
        l.insertLast(10);
        l.insertLast(5);
        System.out.print("After inserting at last: ");
        l.print();  // Expected: 100 <-> 80 <-> 60 <-> 40 <-> 30 <-> 20 <-> 10 <-> 5 <-> End

        // Delete first node
        System.out.println("Deleted First: " + l.deleteFirst());
        System.out.print("After deleting first: ");
        l.print();  // Expected: 80 <-> 60 <-> 40 <-> 30 <-> 20 <-> 10 <-> 5 <-> End

        // Delete last node
        System.out.println("Deleted Last: " + l.deleteLast());
        System.out.print("After deleting last: ");
        l.print();  // Expected: 80 <-> 60 <-> 40 <-> 30 <-> 20 <-> 10 <-> End
    }
}
