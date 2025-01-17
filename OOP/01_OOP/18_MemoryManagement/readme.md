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

### Conclusion:
- The **Stack** holds method variables and follows the LIFO order for memory cleanup.
- The **Heap** stores objects and literals (e.g., strings). 
- The **Garbage Collector** automatically manages memory in the Heap, cleaning up unreferenced objects.
