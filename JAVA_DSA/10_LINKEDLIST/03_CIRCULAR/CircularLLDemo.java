class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularSinglyLL {
    Node head;
    Node tail;

    // Insert at the end
    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) { // First node
            head = node;
            tail = node;
            tail.next = head; // Circular link
        } else {
            tail.next = node;
            tail = node;
            tail.next = head; // Circular link
        }
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;

        Node temp = head, prev = null;
        // If the head is to be deleted
        if (temp.data == key) {
            if (head == tail) { // Only one element
                head = tail = null;
                return;
            }
            tail.next = head.next; // Update last node
            head = head.next;
            return;
        }

        // Search for the key
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.data != key);

        if (temp == head) return; // Not found

        prev.next = temp.next; // Remove node
        if (temp == tail) tail = prev; // If last node is deleted
    }

    // Traverse the list
    public void print() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Head)");
    }
}

// Main Class
public class CircularLLDemo {
    public static void main(String[] args) {
        CircularSinglyLL cll = new CircularSinglyLL();
        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);

        System.out.print("Circular Linked List: ");
        cll.print(); // Expected: 10 -> 20 -> 30 -> 40 -> (Head)

        cll.delete(30);
        System.out.print("After deleting 30: ");
        cll.print(); // Expected: 10 -> 20 -> 40 -> (Head)
    }
}
