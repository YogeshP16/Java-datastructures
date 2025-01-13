
class MyThread extends Thread {
    // Override the run() method to define the task the thread will perform
    public void run() {
        // Print the name of the current thread (i.e., the child thread's name)
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        // Create two instances of MyThread (these will be child threads)
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        // Start the threads, they will begin execution in parallel
        thread1.start();
        thread2.start();
        
        // Main thread will wait for thread1 and thread2 to finish using join()
        // This ensures that the main thread waits until both child threads are done
        thread1.join(); // Main thread waits for thread1 to complete
        thread2.join(); // Main thread waits for thread2 to complete
        
        // After both threads finish, the main thread resumes and prints this message
        System.out.println("Main thread completed after both threads.");
    }
}


/*
Thread-1 is running.
Thread-0 is running.
Main thread completed after both threads.
 */