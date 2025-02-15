public class QueueUsingLL {
    
    // Node class to represent each element in the queue
    class Node {
        int data;
        Node next;

        Node(int data) { // Constructor to initialize the node
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear; // Front (head) and rear (tail) pointers

    QueueUsingLL() {
        front = null;
        rear = null;
    }

    // Enqueue: Add an element to the rear of the queue
    public void enqueue(int data) {
        Node node = new Node(data);
        
        if (front == null) {  // If the queue is empty, set front to new node
            front = node;
        } else {
            rear.next = node; // Link the old rear to the new node
        }
        rear = node; // Update rear to the new node
    }

    // Dequeue: Remove and return the front element
    public int dequeue() {
        if (front == null) throw new IndexOutOfBoundsException("Queue is empty"); // Handle underflow

        int temp = front.data; // Store front data to return
        front = front.next; // Move front to the next node
        
        if (front == null) { // If the queue becomes empty, reset rear
            rear = null;
        }
        return temp;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display the front element without removing it
    public int displayFrontElement() {
        if (front == null) throw new IndexOutOfBoundsException("Queue is empty"); 
        return front.data;
    }

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();
        
        // Enqueue elements: O(1) time complexity, O(N) space complexity
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue elements: O(1) time complexity, O(N) space complexity
        System.out.println(queue.dequeue()); // Output: 10
        System.out.println(queue.dequeue()); // Output: 20
    }
}
