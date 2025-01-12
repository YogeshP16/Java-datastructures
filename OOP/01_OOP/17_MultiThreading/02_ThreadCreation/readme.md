
---

### **1. Creating Threads**  
Threads can be created in two ways:  
- **Extending the Thread class**  
- **Implementing the Runnable interface**

#### **Extending the Thread Class**  

##### 1.create obj
    - create a class that extends Thread class
    - implement run() method 
##### 2. start the thread
    - create object(instance of sub class) 
    - call the start method.

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
- create obj
    - create a class that implements Runnable interface
    - implement run() method 
- start the thread
    - create object(instance of class) that implements Runnable
    - pass the runnable obj to thread constructor
    - call start method

##### Runnable
- A functional interface with the run() method.
- Use it to define the code executed by a thread.

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

### **Important Thread Methods**

1. **`start()`**:  
   - Begins the thread execution. Calls the `run()` method in a new thread.  

2. **`run()`**:  
   - Contains the thread's task logic.  
   - Called automatically when `start()` is invoked.  

3. **`sleep(milliseconds)`**:  
   - Pauses the thread for the specified time.  
   - Example: `Thread.sleep(1000); // Sleep for 1 second.`  

4. **`interrupt()`**:  
   - Interrupts a sleeping or waiting thread.  

5. **`stop()`** *(Deprecated)*:  
   - Forcefully stops the thread. Unsafe and no longer recommended.  

6. **`isAlive()`**:  
   - Checks if the thread is still running.  

---

**Why Java Offers Two Ways to Create Threads?**  

**extending the `Thread` class** and 
 Java allows extending only one class, so if you extend `Thread`, you can’t extend another class.

**implementing the `Runnable` interface**
 When your class already extends another class (e.g., `class MyRunnable extends BaseClass implements Runnable`).
  - For separation of concerns: the thread logic (`run()`) is independent of thread management (`Thread` class).  


---

### **2. Thread Lifecycle**  
A thread in Java transitions through the following states:

- **New**:  
  - Thread is created but not started.
  ```java
  Thread t = new Thread();
  ```

- **Runnable**:  
  - Thread is ready to run, waiting for CPU scheduling.  
  ```java
  t.start();
  ```

- **Running**:  
  - Thread is executing. This is managed by the JVM and OS scheduler.

- **Blocked**:  
  - Thread is waiting for a resource, such as file I/O or lock acquisition.
  - It release all the monitor locks

- **Waiting**:  
  - Thread is waiting indefinitely for another thread to notify it. 
  - makes it non runnable
  - it goes back to runnable when we call `notify()` or `notifyAll()`. 
  ```java
  synchronized(obj) {
      obj.wait(); // Waiting for a notify
  }
  ```

- **Timed Waiting**:  
  - Thread waits for a specific amount of time and come back to runnable state after specific condition met.
  - like `Sleep()`, `Join()`
  ```java
  Thread.sleep(1000); // Waits for 1 second
  ```

- **Terminated**:  
  - Thread has finished execution.

---
