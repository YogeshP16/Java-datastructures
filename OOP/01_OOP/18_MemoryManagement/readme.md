## Two Types of Memory JVM manages
- Heap
- Stack

### **1) Stack Memory**

- **Purpose**: Stack memory stores temporary variables, method calls, and the execution context of threads.

- **How it works**:
  - Each thread has its own stack memory.
  - It stores **primitive data types** (like `int`, `char`, etc.) and **references to objects** in the heap.
  - When a method is called, a new **stack frame** is created to store local variables and the method's execution context.
  - Once a method call completes, its stack frame is removed (LIFO order — Last In, First Out).
  
- **Key Characteristics**:
  - **Scope-based**: Variables inside a method are only visible within that method's scope.
  - **Automatic memory management**: As soon as the method scope ends, the stack frame and all variables inside it are removed.
  - **Fixed size**: Each thread has a fixed-size stack, and if the stack grows too large (e.g., due to deep recursion), it may cause a **StackOverflowError**.
  
- **References in Stack**:
  - Stack memory stores **references** (pointers) to objects in the heap, not the objects themselves.
  - **Strong Reference**: A strong reference means that an object will not be garbage collected as long as there is a reference to it.
  - **Weak Reference**: A weak reference allows the object to be garbage collected when no strong references are holding it.
  - **Soft Reference**: A soft reference is similar to weak references, but objects are retained as long as the JVM has enough heap space.
  
### **2) Heap Memory**

- **Purpose**: Heap memory is where all **objects** (instances of classes) are stored during the execution of a program.

- **How it works**:
  - The heap is shared by all threads, meaning objects are not tied to a specific thread's stack.
  - The memory management in the heap is dynamic, meaning objects can be allocated and deallocated at runtime.
  - **Garbage Collection**: When objects in the heap are no longer referenced by any active thread (via weak or strong references), the JVM will reclaim that memory through **garbage collection**.
  
- **Key Characteristics**:
  - The **garbage collector** (GC) is responsible for cleaning up unused objects and reclaiming their memory.
  - **Mark and Sweep Algorithm**: This is the basic algorithm used by the GC to mark objects that are still referenced and then sweep (remove) the unreferenced objects.
  - Heap is divided into two main regions:
    - **Young Generation**: Where new objects are allocated. It includes Eden space and Survivor spaces.
    - **Old Generation**: Where older objects that have survived garbage collection in the Young Generation are moved. These objects are less likely to be garbage collected frequently.
    - **Metaspace (Non-Heap)**: Stores class metadata, method definitions, and related information.
    
- **Memory Allocation Process**:
  - When a new object is created, it is initially placed in the **Young Generation**.
  - Objects that survive multiple garbage collection cycles in the Young Generation are promoted to the **Old Generation**.
  - The **Garbage Collector** runs periodically to clean up unreferenced objects.

### **Garbage Collection** in Detail:

- **Mark & Sweep**: The basic GC algorithm involves:
  - **Marking**: Identifying which objects are still referenced.
  - **Sweeping**: Removing the unreferenced objects.
  
- **Heap Generations**:
  - **Young Generation**: Contains new objects and is garbage collected more frequently.
  - **Old Generation**: Contains objects that have survived garbage collection cycles. These objects are cleaned less frequently.
  
- **Different Types of GC**:
  - **Serial GC**: Uses a single thread for garbage collection, which can slow down the application.
  - **Parallel GC**: Uses multiple threads to perform garbage collection, improving performance on multi-core systems.
  - **Concurrent Mark & Sweep (CMS)**: Tries to minimize pauses by running the garbage collection process concurrently with the application threads.
  - **G1 GC**: The **Garbage First** collector that divides the heap into regions to provide a balance between high throughput and low pause times.

### **Summary**:

- **Stack Memory**:
  - Stores **local variables** and **method call frames**.
  - Each thread has its own stack.
  - Primitives and object references are stored.
  - **Scope-based** (LIFO order) with automatic memory management.
  
- **Heap Memory**:
  - Stores **objects**.
  - Shared among all threads.
  - Managed via **garbage collection** (Mark & Sweep).
  - Divided into **Young Generation**, **Old Generation**, and **Metaspace**.

