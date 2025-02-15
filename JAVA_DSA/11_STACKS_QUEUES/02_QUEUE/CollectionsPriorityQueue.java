import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionsPriorityQueue {
    public static void main(String[] args) {
        // Min-Heap (Default Behavior)
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(50);
        minHeap.offer(20);
        minHeap.offer(30);
        minHeap.offer(10);

        System.out.println("Min-Heap Front Element: " + minHeap.peek()); // Output: 10 (smallest element)
        System.out.println("Min-Heap Removed Element: " + minHeap.poll()); // Output: 10

        // Max-Heap (Using Collections.reverseOrder())
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(50);
        maxHeap.offer(20);
        maxHeap.offer(30);
        maxHeap.offer(10);

        System.out.println("Max-Heap Front Element: " + maxHeap.peek()); // Output: 50 (largest element)
        System.out.println("Max-Heap Removed Element: " + maxHeap.poll()); // Output: 50
    }
}
