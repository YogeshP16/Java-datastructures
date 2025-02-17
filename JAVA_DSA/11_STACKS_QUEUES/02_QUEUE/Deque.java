class Deque {
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private Node front, rear;

    public Deque() {
        front = rear = null;
    }

    public void insertFront(int data) {
        Node node = new Node(data);
        if (front == null) {
            front = rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
    }

    public void insertRear(int data) {
        Node node = new Node(data);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
    }

    public int deleteFront() {
        if (front == null) throw new RuntimeException("Deque is empty");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        else front.prev = null;
        return val;
    }

    public int deleteRear() {
        if (rear == null) throw new RuntimeException("Deque is empty");
        int val = rear.data;
        rear = rear.prev;
        if (rear == null) front = null;
        else rear.next = null;
        return val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getFront() {
        if (front == null) throw new RuntimeException("Deque is empty");
        return front.data;
    }

    public int getRear() {
        if (rear == null) throw new RuntimeException("Deque is empty");
        return rear.data;
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertRear(30);

        System.out.println(deque.getFront()); // Output: 5
        System.out.println(deque.getRear());  // Output: 30
        System.out.println(deque.deleteFront()); // Output: 5
        System.out.println(deque.deleteRear());  // Output: 30
    }
}
