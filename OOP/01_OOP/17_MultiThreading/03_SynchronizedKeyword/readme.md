### **Monitor Lock with Synchronized Method vs Block**

1. **What is a Monitor Lock (synchronized)?**
   - Ensures only **one thread at a time** can access synchronized code on the same object.
   - **synchronized** keyword allows a thread to acquire the monitor lock of an object. ensure thread safety.

2. **Synchronized Method**:
   - Locks the **entire method**.
   - Automatically locks the object.
   - Simpler to use but less flexible.
   - Example: 
     ```java
     public synchronized void display1(String threadName) {
         // Entire method locked
     }
     ```

3. **Synchronized Block**:
   - Locks only a **specific block** of code.
   - Provides more control over what to lock.
   - More flexible and efficient.
   - Example:
     ```java
     public void display2(String threadName) {
         synchronized (this) {
             // Only this block locked
         }
     }
     ```

4. **Key Difference**:
   - **Method**: Coarse-grained, locks everything in the method.
   - **Block**: Fine-grained, locks only the critical section.

5. **When to Use**:
   - Use **method** Use when the entire method needs to be thread-safe.
   - Use **block** when only a specific portion of the method needs to be synchronized.


### **Inter-Thread Communication**
   - Threads communicate with each other using wait(), notify(), and notifyAll(), which must be called within a synchronized block or method.

#### **Methods Explanation:**
1. **wait():**
   - Causes the current thread to wait until another thread calls notify() or notifyAll() on the same object.

2. ***notify():**
   - Wakes up one waiting thread on the same object monitor.

3. **notifyAll():**
   - Wakes up all threads waiting on the same object monitor.

#### **Why are wait(), notify(), and notifyAll() in the Object class and not in the Thread class?**
   - These methods are used for inter-thread communication and synchronization.
   - Every Java object has a monitor lock, and these methods need to be called on the monitor lock to coordinate thread execution

### **Producer-Consumer Problem**
A classic example of inter-thread communication where:

- **Producer**: 
   - Produces data and notifies the consumer.
   - adds items (or data) to a shared resource (e.g., a queue or buffer).
   - The producer must wait if the buffer is full.
- **Consumer**: 
   - Consumes data and waits for the producer to produce more.
   - retrieves and processes items from the shared resource
   - The consumer must wait if the buffer is empty.   

#### **Why Is Producer-Consumer Important?**
   - It teaches thread synchronization and communication.
   - It demonstrates how to handle shared resources safely in a multi-threaded environment.
   - It is used in real-world systems like:
      - Message queues (e.g., Kafka, RabbitMQ)
      - Data pipelines
      - Operating system scheduling