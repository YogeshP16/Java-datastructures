public class StackUsingLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;

    StackUsingLinkedList() {
        top = null;
    }

    // Push → Add to top
    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop → Remove from top
    public T pop() {
        if (top == null) throw new IndexOutOfBoundsException("Stack is empty");
        T value = top.data;
        top = top.next;
        return value;
    }

    // Peek → View top element
    public T peek() {
        if (top == null) throw new IndexOutOfBoundsException("Stack is empty");
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print stack elements
    public void printStack() {
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> s = new StackUsingLinkedList<>();
        
        s.push(10);
        s.push(20);
        s.push(30);
        s.printStack(); // Stack: 30 20 10
        
        System.out.println("Top Element: " + s.peek()); // 30
        
        s.pop();
        s.printStack(); // Stack: 20 10
    }
}