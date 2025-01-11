
---

### **1. Creating Threads**  
Threads can be created in two ways:  
- **Extending the Thread class**  
- **Implementing the Runnable interface**

#### **Extending the Thread Class**  
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts the thread
    }
}
```

#### **Implementing the Runnable Interface**  
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start(); // Starts the thread
    }
}
```

---

### **2. Thread Lifecycle**  
A thread in Java transitions through the following states:

- **New**:  
  Thread is created but not started.  
  ```java
  Thread t = new Thread();
  ```

- **Runnable**:  
  Thread is ready to run, waiting for CPU scheduling.  
  ```java
  t.start();
  ```

- **Running**:  
  Thread is executing. This is managed by the JVM and OS scheduler.

- **Blocked**:  
  Thread is waiting for a resource, such as file I/O or lock acquisition.

- **Waiting**:  
  Thread is waiting indefinitely for another thread to notify it.  
  ```java
  synchronized(obj) {
      obj.wait(); // Waiting for a notify
  }
  ```

- **Timed Waiting**:  
  Thread waits for a specific amount of time.  
  ```java
  Thread.sleep(1000); // Waits for 1 second
  ```

- **Terminated**:  
  Thread has finished execution.

---

This explanation simplifies thread creation and lifecycle while covering all essential points.