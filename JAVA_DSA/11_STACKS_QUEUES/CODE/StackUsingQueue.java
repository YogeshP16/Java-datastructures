import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>(); // Initialize the queue
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        // Rotate elements so that the last inserted element is always at the front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.remove(); // Removes the top element (front of queue)
    }

    public int top() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.peek(); // Returns the top element without removing it
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.top()); // Output: 30
        System.out.println(stack.pop()); // Output: 30
        System.out.println(stack.pop()); // Output: 20
        System.out.println(stack.empty()); // Output: false
    }
}
