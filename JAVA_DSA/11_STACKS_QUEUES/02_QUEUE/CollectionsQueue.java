import java.util.LinkedList;
import java.util.Queue;

public class CollectionsQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue (add elements)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue); // [10, 20, 30]

        // Peek (check front element)
        System.out.println("Front Element: " + queue.peek()); // Output: 10

        // Dequeue (remove front element)
        System.out.println("Removed Element: " + queue.poll()); // Output: 10

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
    }
}
