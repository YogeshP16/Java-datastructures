import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {

    /*
     **Approach (KISS Rule)**  
    1. **Push (O(1))** → Directly add the element to the queue.  
    2. **Pop (O(N))** → Rotate all elements except the last one to the back, then remove the last element.  
    3. **Top (O(N))** → Similar to `pop()`, but return the last element without removing it.  
    4. **Empty (O(1))** → Check if the queue is empty.
     */
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
