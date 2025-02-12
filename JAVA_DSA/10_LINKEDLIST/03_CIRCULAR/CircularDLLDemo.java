class DNode {
    int data;
    DNode next, prev;

    DNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class CircularDoublyLL {
    DNode head, tail;

    // Insert at the end
    public void insert(int data) {
        DNode node = new DNode(data);
        if (head == null) { // First node
            head = tail = node;
            head.next = head.prev = head;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = head;
            head.prev = node;
            tail = node;
        }
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;

        DNode temp = head;
        if (temp.data == key) { // If head is to be deleted
            if (head == tail) { // Only one node
                head = tail = null;
                return;
            }
            head = head.next;
            tail.next = head;
            head.prev = tail;
            return;
        }

        // Search for the key
        do {
            temp = temp.next;
        } while (temp != head && temp.data != key);

        if (temp == head) return; // Not found

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        if (temp == tail) tail = temp.prev; // If last node is deleted
    }

    // Traverse the list
    public void print() {
        if (head == null) return;

        DNode temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Head)");
    }
}

// Main Class
public class CircularDLLDemo {
    public static void main(String[] args) {
        CircularDoublyLL dll = new CircularDoublyLL();
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);

        System.out.print("Circular Doubly Linked List: ");
        dll.print(); // Expected: 10 <-> 20 <-> 30 <-> 40 <-> (Head)

        dll.delete(30);
        System.out.print("After deleting 30: ");
        dll.print(); // Expected: 10 <-> 20 <-> 40 <-> (Head)
    }
}
