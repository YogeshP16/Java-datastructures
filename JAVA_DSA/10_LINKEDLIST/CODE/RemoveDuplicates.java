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
    int size;

    // Insert at the end
    public void insertEnd(int data) {
        Node node = new Node(data);

        if (head == null) { // If list is empty
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
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

    // Remove Duplicates
    public void removeDuplicates(){
        if(head == null){
            return;
        }

        Node temp = head;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }

        }
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insertEnd(20);
        l.insertEnd(20);
        l.insertEnd(30);
        l.insertEnd(30);
        l.insertEnd(30);
        l.insertEnd(40);

        // Print the list
        l.print(); // Expected Output: 20 -> 20 -> 30 -> 30 -> 30 -> 40 -> END

        l.removeDuplicates();
        l.print(); // 20 -> 30 -> 40 -> END

    }
}
