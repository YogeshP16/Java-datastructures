### **Real-Time Example of Threads and Processes**   

1. **Process**:  
   - **Web Browser**: Each browser tab is a separate process. If one tab crashes, it doesn’t affect others.  

2. **Threads within a Process**:  
   - **Video Streaming**:  
     - **Main Thread**: Handles the user interface (e.g., play/pause button).  
     - **Background Threads**: Download video data, decode it, and play the audio/video concurrently.  

### **Process**
   - A process is an instance of a program that's being executed by the OS.
   - It gets resources like memory and threads when created.

    **Compilation**: 
    - `javac Test.java` generates bytecode that the JVM can execute.
    **Execution**: 
    - `java Test` **starts a new JVM Process** and runs the `main` method.

**How much memeory that process get**:
   - When a process starts with `java MainClassName`, a new JVM instance is created.
   - You can allocate heap memory using:
     - `-Xms<size>`: Initial heap size (e.g., `-Xms256m` sets it to 256MB).
     - `-Xmx<size>`: Maximum heap size (e.g., `-Xmx2g` sets it to 2GB).
   - If the process tries to allocate more memory than the maximum (`-Xmx`), an `OutOfMemoryError` occurs. 


### **Thread**:
   - A thread is a lightweight process, or the smallest sequence of instructions that the CPU can execute independently.
   - A process can have multiple threads.

2. **Main Thread**:
   - When a process starts, it begins with a "main thread."
   - Other threads can be created from the main thread to perform tasks concurrently.

3. **Example**:
   - In the `main` method, the `Thread.currentThread().getName()` prints the name of the current thread, which is "main" by default.

   ```java
   public class MultithreadingLearning {
       public static void main(String args[]) {
           System.out.println("Thread Name: " + Thread.currentThread().getName());
       }
   }
   ```

   **Output**: `Thread Name: main`


### **physical memory and its components**

1. **JVM and Process**:
   - Each **process** (e.g., `Process1`, `Process2`) runs in its own **JVM instance**.
   - Each JVM instance has its own **heap memory** and other resources.

2. **Memory Structure --> All Managed by JVM**:
   - **Code Segment**: 
        - Holds the Compiled byte code (Machine code).
        - its read only
        - all thread within the same process, share same code segment.

   - **Data Segment**: 
        - Stores global and static variables.
        - Thread can read & Modify the data.
        - all thread within the same process, share same code segment.
        - Synchronization required between multiple thread.

   - **Heap**
        - Stores **objects** and **class instances**. Shared by all threads but not within same process.
        - Thread can read & Modify the data.
        - Synchronization required between multiple thread.
        
   - **Stack**: 
        - Contains method calls, local variables.
        - Each thread has it own stack.

   - **Registers**: 
        - Registers are the fastest, smallest storage units in the CPU.
        - They temporarily hold data, instructions, or addresses being processed.

   - **Program Counter (Counter)**: 
        - Points to the next instruction to execute.
        - Increment its counter after executed.

3. **Threads**:
   - Each **JVM instance** can have multiple threads (e.g., `Thread1`, `Thread2`, `Thread3`).
   - Threads share the **Code Segment** and **Data Segment**, but each thread has its own **Stack**.

4. **Main Memory (RAM)**:
   - All processes, threads, and memory segments exist in **main memory (RAM)**.
   - **Cache**: Stores frequently accessed data for faster access by the CPU.

### **Multithreading**  
1. **Definition**:  
   - Multithreading allows a program to perform multiple tasks simultaneously.  
   - Threads share resources like memory but execute independently.  

2. **Benefits**:  
   - Improved performance through parallelism.  
   - Better responsiveness.  
   - Efficient resource sharing.  

3. **Challenges**:  
   - Concurrency issues like deadlocks and data inconsistency.  
   - Synchronization overhead.  
