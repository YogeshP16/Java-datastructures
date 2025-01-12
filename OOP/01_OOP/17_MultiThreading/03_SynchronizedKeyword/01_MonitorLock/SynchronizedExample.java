class SharedResource {

    // Synchronized method 
    public synchronized void display1(String threadName) {
        System.out.println(threadName + " is accessing the resource...");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " is done accessing the resource.");
    }

    // Synchronized block
    public void display2(String threadName) {
        synchronized (this) { // Lock only this section
            System.out.println(threadName + " is accessing the resource...");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is done accessing the resource.");
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.display1("Thread 1"));
        Thread t2 = new Thread(() -> resource.display2("Thread 2"));

        t1.start();
        t2.start();
    }
}


/*
### Execution flow:
- Thread 1 calls the synchronized method display1(). It acquires the monitor lock of the SharedResource object.

- Thread 2 tries to call the synchronized block inside display2(), 
    but it must wait because Thread 1 holds the monitor lock of the same SharedResource object.
    
- Once Thread 1 finishes, it releases the monitor lock, allowing Thread 2 to acquire it and proceed.

### output
Thread 1 is accessing the resource...
Thread 1 is done accessing the resource.
Thread 2 is accessing the resource...
Thread 2 is done accessing the resource.
 */