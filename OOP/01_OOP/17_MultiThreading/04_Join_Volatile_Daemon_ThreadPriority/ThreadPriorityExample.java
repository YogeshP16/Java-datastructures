public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        // Set thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY);  // Lowest priority
        thread2.setPriority(Thread.MAX_PRIORITY);  // Highest priority

        // Start threads
        thread1.start();
        thread2.start();
    }
}
/*
Thread 1: 1
Thread 2: 1
Thread 2: 2
Thread 2: 3
Thread 2: 4
Thread 2: 5
Thread 1: 2
Thread 1: 3
Thread 1: 4
Thread 1: 5
 */