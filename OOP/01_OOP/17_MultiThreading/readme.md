### Threads and Processes

#### **1. Process**
- **Definition**: A program instance running on the OS, with allocated resources (memory, threads).
- **Example**: Each browser tab is a separate process; if one crashes, others remain unaffected.
- **Memory Allocation**:
  - `-Xms<size>`: Initial heap size (e.g., `-Xms256m`).
  - `-Xmx<size>`: Maximum heap size (e.g., `-Xmx2g`).
  - Exceeding max heap causes `OutOfMemoryError`.

#### **2. Threads**
- **Definition**: Lightweight processes; smallest execution unit.
- **Main Thread**:
  - Every process starts with a "main thread."
  - Example:
    ```java
    public class MultithreadingExample {
        public static void main(String[] args) {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
    ```
    **Output**: `Thread Name: main`

#### **3. Memory Segments in JVM**
- **Code Segment**:
  - Stores compiled bytecode (read-only).
  - Shared by all threads in a process.
- **Data Segment**:
  - Stores global/static variables.
  - Shared by threads; requires synchronization.
- **Heap**:
  - Stores objects and class instances.
  - Shared by threads; requires synchronization.
- **Stack**:
  - Stores method calls and local variables.
  - Each thread has its own stack.
- **Registers**:
  - Fastest storage for temporary data during execution.
- **Program Counter**:
  - Tracks the next instruction for execution.

#### **4. Multithreading**
- **Definition**: Performing multiple tasks simultaneously within a process.
- **Benefits**:
  - Improved performance via parallelism.
  - Better responsiveness.
- **Challenges**:
  - Concurrency issues (e.g., deadlocks, data inconsistency).
  - Overhead for synchronization.

#### **5. Real-Time Examples**
- **Process**: Web browser tabs as independent processes.
- **Threads**:
  - Video streaming: UI handled by main thread; background threads manage downloading and decoding.

