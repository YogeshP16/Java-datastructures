## Two Types of Memory JVM manages
- Heap
- Stack

### **Stack Memory in Java**

- **Purpose**: Stores method variables and execution context for each thread.

- **How it Works**:
  - Each thread has its own stack.
  - Stores **primitive types** (like `int`) and **object references** (pointers to objects in heap).
  - New stack frames are created for each method call. Once the method completes, the frame is removed (LIFO).

- **Key Points**:
  - **Scope-based**: Variables exist only within the method's scope.
  - **Automatic cleanup**: Stack memory is automatically managed. When a method ends, its stack frame is cleared.
  - **Fixed size**: Too deep a recursion can cause **StackOverflowError**.

- **References**:
  - **Strong**: Prevents garbage collection.
  - **Weak**: Allows garbage collection if no strong reference exists.
  - **Soft**: Retained as long as there’s enough heap space.

In short: **Stack = thread-specific, temporary, scope-based memory** for method variables and references, cleaned up automatically.
  
### **Heap Memory in Java**

- **Purpose**: Stores **objects** (instances of classes) during program execution.

- **How it Works**:
  - Shared by all threads, meaning objects are not tied to any specific thread's stack.
  - **Dynamic memory management**: Objects are allocated and deallocated at runtime.
  - **Garbage Collection (GC)**: The JVM reclaims memory from objects that are no longer referenced by any active thread (via weak or strong references).

- **Key Characteristics**:
  - Managed by **Garbage Collector (GC)** to clean up unreferenced objects.
  - **Mark and Sweep**: Algorithm used by GC to marks referenced objects and sweeps (remove) away unreferenced ones.
  - Divided into:
    - **Young Generation**: Where new objects are created (includes Eden and Survivor spaces).
    - **Old Generation**:  Where older objects that have survived garbage collection in the Young Generation are moved.
    - **Metaspace(non heap)- java 8+**: Stores class metadata (non-heap memory).

- **Memory Allocation**:
  - New objects start in the **Young Generation**.
  - Surviving objects are promoted to the **Old Generation**.
  - **GC** runs periodically to clean unreferenced objects.

In short: **Heap = shared memory for objects**, with **automatic cleanup via garbage collection**, using **Mark and Sweep** to manage memory allocation across generations.

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


### Key Concepts:
1. **Stack Memory**: Stores method variables and references to objects. It follows the LIFO (Last In, First Out) principle. When the method's scope ends, all its variables are removed from the stack.
2. **Heap Memory**: Stores actual objects, including String literals and instances of user-defined classes.
3. **String Pool**: A special area in the Heap where Java maintains unique string literals to save memory by reusing the same string values.
4. **Garbage Collection**: When an object in the Heap is no longer referenced by any variables (i.e., no active references point to it), it becomes eligible for garbage collection.

### Example Code:
```java
public class MemoryManagementTest {

    public static void memoryManagementTest() {
        String str1 = "Hello";  // String literal in String Pool
        String str2 = "Hello";  // This reuses the same reference from the pool

        // Creating a Person object on Heap
        Person personObj = new Person("John", 25);  
        
        // Creating another Person object on Heap
        Person personObj2 = new Person("Alice", 30);
    }

    public static void main(String[] args) {
        // Calling memoryManagementTest method
        memoryManagementTest();
        
        // Once memoryManagementTest method ends, its local variables (str1, str2, personObj, personObj2)
        // are removed from the stack (in LIFO order)
        
        // Now we are back in the main method, but no references to personObj or personObj2 are left.
        // The objects in Heap are now eligible for garbage collection.
        System.gc();  // Explicitly requesting the JVM to run garbage collection (though it's not guaranteed)
    }

    static class Person {
        String name;
        int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
```

### Explanation of Memory Behavior:
1. **Stack**:
   - When the `memoryManagementTest` method is called, variables `str1`, `str2`, `personObj`, and `personObj2` are pushed onto the stack.
   - At the end of the `memoryManagementTest` method (when the closing bracket is encountered), these variables are popped off the stack in LIFO order.
   
2. **Heap**:
   - The `String` literals `"Hello"` are stored in the **String Pool** (Heap memory).
   - The `Person` objects `personObj` and `personObj2` are created on the Heap.
   - Once the references in the stack are removed (when the method ends), these objects are still in the Heap but are no longer referenced.

3. **Garbage Collection**:
   - Since there are no active references to the `Person` objects after the `memoryManagementTest` method ends, they become **eligible for garbage collection**.
   - The garbage collector periodically runs in the background, removing objects from the Heap that are no longer referenced.
   - The `System.gc()` call is a **hint** to the JVM to run the garbage collector, but it doesn't guarantee when or if the collection will happen.

### Memory State:
- **Stack**:
  - After `memoryManagementTest()` ends, the stack is cleared, and references to `personObj` and `personObj2` are removed.
- **Heap**:
  - The `String` literals `"Hello"` remain in the **String Pool**.
  - The `Person` objects `personObj` and `personObj2` are left in the Heap, awaiting garbage collection.
  
- The garbage collector will eventually free the memory by removing unreferenced objects from the Heap, though this is managed automatically by the JVM. 


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