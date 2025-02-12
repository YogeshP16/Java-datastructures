class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    // Insert at the end
    public void insertEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Merge two sorted linked lists
    public static Node mergeSorted(Node l1, Node l2) {
        Node dummy = new Node(-1); // Dummy node to simplify logic
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next; // Return merged list (skip dummy node)
    }
}

public class MergeSortedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertEnd(10);
        list1.insertEnd(20);
        list1.insertEnd(30);

        LinkedList list2 = new LinkedList();
        list2.insertEnd(5);
        list2.insertEnd(25);
        list2.insertEnd(40);
        list2.insertEnd(50);

        System.out.print("List 1: ");
        list1.print();
        System.out.print("List 2: ");
        list2.print();

        // Merge lists
        LinkedList.Node mergedHead = LinkedList.mergeSorted(list1.head, list2.head);

        // Print merged list
        System.out.print("Merged List: ");
        LinkedList mergedList = new LinkedList();
        mergedList.head = mergedHead;
        mergedList.print();  // Expected Output: 5 -> 10 -> 20 -> 25 -> 30 -> 40 -> 50 -> END
    }
}
