
### **Deprecated Methods: `stop()`, `suspend()`, `resume()`**
- **Why Deprecated --> The feature may cause issues, like bugs, crashes, or inefficiencies.**:  
  - `stop()`: used to stop a thread, but it could cause problems like leaving resources in an inconsistent state, which made it unsafe to use.
  - `suspend()` & `resume()`: These were used to pause and resume threads, but they could lead to deadlock situations

- **What to do instead?**
  - For stop(), suspend(), and resume(), the recommended alternatives are:

  - `interrupt()`: For safely stopping a thread.
  - `wait()`, `notify()`, `notifyAll()`: For thread synchronization and control.

---

### **Thread Joining**
- **Purpose**: Makes the current thread wait for another thread to finish execution.

- **Method**: `join()`

- **Example**:
  ```java
  Thread t = new Thread(() -> {
      System.out.println("Thread is running.");
  });
  t.start();
  t.join(); // Main thread waits for `t` to finish
  System.out.println("Main thread resumes.");
  ```

---

### **Volatile Keyword**
- Ensures that a variable is read from and written to the main memory
- This means that changes made by one thread are immediately visible to other threads
- preventing threads from caching it locally

- **When to Use**: For variables accessed by multiple threads where **synchronization** isn't needed but **visibility** is critical.

- **Example**:
  ```java
  volatile boolean flag = true;
  ```

---

### **Thread Priority in Java**
- **Definition**: Thread priority determines the order in which threads are scheduled to run. Higher priority threads are generally given preference by the JVM, but it does not guarantee execution order.

- **Priority Range**: 
  - **MIN_PRIORITY**: 1
  - **NORM_PRIORITY** (Default): 5
  - **MAX_PRIORITY**: 10

- **Methods**:
  - `setPriority(int priority)` – Set the thread’s priority.
  - `getPriority()` – Get the thread’s current priority.

- **Effect**: 
  - OS and JVM thread scheduler uses priority, but thread execution order is not guaranteed .
  - because OS only decides to schedule threads based on factors beyond priority, such as CPU availability, time-slicing.
  
- **Daemon Threads**: Run in the background with lower priority than normal threads.

---

### **Daemon Threads**
- **Definition**: Background threads that support user threads (e.g., Garbage Collector), does not prevent the program from exiting.

- **Key Point**: JVM exits when only daemon threads are left running.

- **Example**:
  ```java
  Thread t = new Thread(() -> {
      System.out.println("Daemon thread running.");
  });
  t.setDaemon(true); // Set thread as a daemon
  t.start();
  ```

---

