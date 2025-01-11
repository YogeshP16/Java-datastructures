
### **Collections Framework in Java**

---

#### **Collections in Java**
- **Definition**: A framework for storing and manipulating **groups of objects**.
- **Key Components**:
##### **Interfaces**
- Defines the basic contract for collections (e.g., `List`, `Set`, `Queue`).

###### List 
- **ArrayList** --> Maintains insertion order, for fast index based access, insert/delete requires shiting the elements
- **linkes List** --> Maintains insertion order,  for fast insertion, deletion
- **vector** --> similar to arraylist but thread safe , slower
- **CopyOnArrayList** --> thread safe, for heavy read operation but slower on write operation
- **Stack** --> last in first out

###### Set
- **HashSet** --> unordered collection that does not allow duplicate elements, allow null element.
- **LinkedHashSet**  -->  maintains insertion order of elements, allow null element.
- **TreeSet** --> maintains Sorted order of elements,  Does not allow `null` elements (throws `NullPointerException`), Slower.

###### Queue
- **Queue** --> First in first out, processing elements in order of insertion, null not allowed.
- **PriorityQueue** --> elements are ordered based on their natural order or a custom comparator.
- **Deque** -->  allows elements to be added or removed from both ends. Supports both FIFO and LIFO operations.

###### Map
- **HashMap** --> key - value pair, Unorder, keys are unique and values not, allow null key & multiple null value, not thread safe, faster add, remove, lookup.
- **Linked HashMap** --> maintains the insertion order of keys, not thread safe, slower
- **TreeMap** --> maintains the Sorted order of keys, not thread safe, slower, o(logn)
- **Concurrent HashMap** --> Thread Safe, Allows concurrent read/write operations without blocking the entire map.

#### **Hashtable vs HashMap**
- **Hashtable** --> Thread-safe, No null keys or values, Slower due to synchronization.
- **Legacy**: Older, pre-Java 1.2.

- **HashMap** --> Not thread-safe by default, Allows one null key and multiple null values, Faster due to no synchronization.
- **Modern**: Part of Java 1.2+ Collections Framework.

---

#### Comparator vs comparable
- **Comparable** --> for natural sorting of objects, compareTo(T o).
- **Comparator** --> for custom sorting of objects, compare(T o1, T o2).

#### Fail fast vs fail safe
- **Fail-Fast**:
  - Modifications during iteration throw a `ConcurrentModificationException`.
  - Examples: `ArrayList`, `HashMap`.
  
- **Fail-Safe**:
  - Allows modifications during iteration (does not throw exceptions).
  - Examples: `CopyOnWriteArrayList`, `ConcurrentHashMap`.

---

### Java List Implementations

---

#### **1: ArrayList in Java**
- **Definition**: A resizable array implementation of `List`.
- **Advantages**:
  - Fast **random access** via index.
  - Dynamic resizing when capacity exceeds.
- **Disadvantages**:
  - **Slow insertion/deletion**: Elements need to be shifted.
  - **Not thread-safe**: Needs external synchronization.
- **Use Case**: When frequent random access is required.

---

#### **2: Vector Class in Java**
- **Definition**: A synchronized, resizable array implementation of `List`. Legacy class from Java 1.0.
- **Advantages**: 
  - Thread-safe out of the box.
- **Disadvantages**:
  - Slower than `ArrayList` due to synchronization.
  - Considered outdated, replaced by `ArrayList` or `CopyOnWriteArrayList`.
- **Use Case**: Rarely used; prefer modern alternatives.

---

#### **3: LinkedList in Java**
- **Definition**: A doubly-linked list implementation of `List` and `Deque`.
- **Advantages**:
  - Efficient **insertions/deletions**: No need to shift elements.
  - Can act as a queue or deque due to `Deque` interface.
- **Disadvantages**:
  - **Slower random access** compared to `ArrayList`.
  - Higher memory usage due to node pointers.
- **Use Case**: When frequent insertions/deletions occur.

---

#### **4: CopyOnWriteArrayList**
- **Definition**: A thread-safe implementation of `List`, which creates a copy of the array for updates.
- **Advantages**:
  - **Thread-safe** without external synchronization.
  - Ideal for **read-heavy** operations.
- **Disadvantages**:
  - Memory-intensive: Copies array on updates.
  - Slower for write operations.
- **Use Case**: When reads significantly outnumber writes.

---

#### **5: Stack Class in Java**
- **Definition**: A LIFO (Last In, First Out) data structure extending `Vector`.
- **Key Methods**:
  - `push(E e)`: Adds an element to the top of the stack.
  - `pop()`: Removes and returns the top element.
  - `peek()`: Returns the top element without removing it.
- **Advantages**:
  - Easy-to-use LIFO operations.
- **Disadvantages**:
  - Based on the outdated `Vector` class.
  - Not ideal for modern stack use cases; prefer `Deque` or `ArrayDeque`.
- **Use Case**: Simple LIFO stack requirements.

---

### **Set Implementations in Java**

---

#### **1: Set in Java**
- **Definition**: An unordered collection that does not allow duplicate elements.
- **Key Characteristics**:
  - No duplicate values are allowed.
  - Can have one `null` element (depending on implementation).
  - Implements the `Collection` interface.
- **Common Implementations**: `HashSet`, `LinkedHashSet`, `TreeSet`.
- **Use Case**: When unique elements are required without concern for ordering or duplicates.

---

#### **2: HashSet in Java**
- **Definition**: A `Set` implementation backed by a `HashMap`.
- **Key Characteristics**:
  - **Unordered**: Does not guarantee any specific iteration order.
  - Allows **null** elements.
  - **Not thread-safe**: Requires synchronization for concurrent access.
  - **Uses hashing** for fast add, remove, and contains operations (O(1) average time complexity).
- **Disadvantages**:
  - No control over element order.
  - Collisions may degrade performance.
- **Use Case**: Efficiently storing unique elements without regard for order.

---

#### **3: TreeSet in Java**
- **Definition**: A `Set` implementation that maintains **sorted order** using a `TreeMap`.
- **Key Characteristics**:
  - Implements `NavigableSet` for range operations like `subSet()`, `headSet()`, `tailSet()`.
  - **Sorted** based on natural order or a provided comparator.
  - Does not allow `null` elements (throws `NullPointerException`).
  - Slower than `HashSet` (O(log n) for add, remove, and contains).
- **Disadvantages**:
  - Higher overhead compared to `HashSet`.
- **Use Case**: When sorted unique elements are required, such as in range queries or ordered iteration.

---

#### **4: LinkedHashSet in Java**
- **Definition**: An **ordered version** of `HashSet`, which maintains **insertion order** of elements.
- **Key Characteristics**:
  - Backed by a `LinkedHashMap`.
  - Allows **null** elements.
  - **Not thread-safe**: Requires synchronization for concurrent access.
  - Slightly slower than `HashSet` due to the linked structure.
- **Advantages**:
  - Predictable iteration order (insertion order).
  - Combines the benefits of a `HashSet` and a linked list.
- **Use Case**: When unique elements are required, and the order of insertion matters.

---

### **Queue and Deque in Java**

---

#### **1: Queue Interface in Java**
- **Definition**: A **First-In-First-Out (FIFO)** data structure for processing elements in order of insertion.
- **Key Methods**:
  - `offer(E e)`: Inserts an element into the queue, returns `true` if successful.
  - `poll()`: Retrieves and removes the head of the queue, returns `null` if empty.
  - `peek()`: Retrieves, but does not remove, the head of the queue, returns `null` if empty.
- **Characteristics**:
  - Part of the `java.util` package.
  - Does not allow `null` elements.
- **Use Case**: Ideal for task scheduling or processing items in the order they arrive.

---

#### **2: PriorityQueue in Java**
- **Definition**: A queue where elements are ordered based on their **natural order** or a **custom comparator**.
- **Key Characteristics**:
  - Backed by a binary heap.
  - Not thread-safe; use `PriorityBlockingQueue` for concurrent environments.
  - Allows duplicates but does not permit `null` elements.
  - Offers **O(log n)** time complexity for insertions and deletions.
- **Disadvantages**:
  - Order is not guaranteed for elements with the same priority.
  - Does not provide constant-time retrieval of arbitrary elements.
- **Use Case**: Useful for priority-based task scheduling or sorting elements dynamically.

---

#### **3: Deque Interface in Java**
- **Definition**: A **Double-Ended Queue (Deque)** that allows elements to be added or removed from both ends. Supports both **FIFO** and **LIFO** operations.
- **Key Methods**:
  - `addFirst(E e)`, `addLast(E e)`: Inserts elements at the front or rear.
  - `removeFirst()`, `removeLast()`: Removes elements from the front or rear.
  - `peekFirst()`, `peekLast()`: Retrieves elements from the front or rear without removal.
- **Characteristics**:
  - Extends `Queue` interface.
  - Implementations: `ArrayDeque`, `LinkedList`.
  - Does not allow `null` elements.
- **Use Case**: Suitable for use cases requiring both queue and stack-like operations.

---
### **Map Implementations**

---

#### **1: Map Interface in Java**
- **Definition**: Represents a collection of key-value pairs, where keys are unique and values can be duplicated.
- **Key Characteristics**:
  - No duplicate keys allowed, but values can be duplicated.
  - Provides methods like `put()`, `get()`, `containsKey()`, and `containsValue()`.
  - Implements `java.util.Map` interface.
- **Use Case**: Suitable for scenarios where data needs to be retrieved via keys (e.g., lookups, associations).

---

#### **2: HashMap in Java**
- **Definition**: An **unordered** `Map` implementation backed by a **hash table**.
- **Key Characteristics**:
  - Allows one **null key** and multiple **null values**.
  - **Not thread-safe**; requires external synchronization for concurrent access.
  - **Time complexity** for basic operations (`put()`, `get()`, `remove()`) is **O(1)** on average.
- **Disadvantages**:
  - Unordered elements (no guaranteed order of iteration).
  - Performance may degrade in case of high collision rates.
- **Use Case**: When fast lookups are needed and order does not matter.

---

#### **3: LinkedHashMap in Java**
- **Definition**: A `Map` implementation that maintains the **insertion order** of keys.
- **Key Characteristics**:
  - Backed by a **doubly linked list** in addition to the hash table.
  - **Insertion order** is preserved during iteration.
  - **Not thread-safe**.
- **Disadvantages**:
  - Slightly slower than `HashMap` due to the additional overhead of maintaining order.
- **Use Case**: When maintaining insertion order is required (e.g., cache implementations, ordered collections).

---

#### **4: TreeMap in Java**
- **Definition**: A `Map` implementation that maintains **sorted order** of keys.
- **Key Characteristics**:
  - Implements `NavigableMap` for range operations (`subMap()`, `headMap()`, `tailMap()`).
  - **Sorted** by natural order of keys or a custom comparator.
  - **Not thread-safe**.
  - Backed by a **Red-Black tree**.
- **Disadvantages**:
  - Slower than `HashMap` and `LinkedHashMap` (O(log n) for operations like `put()`, `get()`, `remove()`).
- **Use Case**: When sorted key ordering or range queries are needed.

---

#### **6: ConcurrentHashMap in Java**
- **Definition**: A **thread-safe** version of `HashMap` with segment-level locking.
- **Key Characteristics**:
  - Allows concurrent read/write operations without blocking the entire map.
  - Split into **segments** to enable fine-grained locking (i.e., individual segments can be locked independently).
  - Provides **O(1)** time complexity for most operations under normal load.
- **Disadvantages**:
  - Slower than `HashMap` due to synchronization overhead.
- **Use Case**: When thread-safety is needed and high concurrency is expected (e.g., multi-threaded applications).

---

#### **7: Hashtable in Java**
- **Definition**: A legacy, **synchronized** `Map` implementation.
- **Key Characteristics**:
  - **Synchronized** for thread safety, but less efficient than `ConcurrentHashMap`.
  - Does not allow **null keys** or **null values**.
  - Uses **hashing** for key-value mapping, like `HashMap`.
- **Disadvantages**:
  - Considered outdated and replaced by `ConcurrentHashMap` or `HashMap`.
  - Thread synchronization causes potential performance bottlenecks.
- **Use Case**: Rarely used today; thread-safe maps where both keys and values are non-null.

---

#### **8: Fail-Fast and Fail-Safe**
- **Fail-Fast**:
  - Modifications during iteration throw a `ConcurrentModificationException`.
  - Examples: `ArrayList`, `HashMap`.
  - **Use Case**: To prevent inconsistent state in a collection during iteration (mainly used in single-threaded environments).
  
- **Fail-Safe**:
  - Allows modifications during iteration (does not throw exceptions).
  - Examples: `CopyOnWriteArrayList`, `ConcurrentHashMap`.
  - **Use Case**: Used in concurrent collections where modifications are expected during iteration.

---

### **Internal Workings of HashMap in Java**

---

#### **1: Internal Working of HashMap**
- **HashMap Storage**: Internally, HashMap stores key-value pairs in **buckets** (slots) of an array. Each bucket corresponds to an index determined by the key’s **hashCode()**.
- **Handling Collisions**:
  1. **Chaining**: A linked list of entries is stored at the same index for colliding keys.
  2. **Open Addressing**: Uses probing (linear or double hashing) to find another empty slot when a collision occurs.
- **Performance**: Average time complexity for **insertions** and **retrievals** is **O(1)**, but **collisions** can degrade performance.

---

#### **2: Load Factor in HashMap**
- **Definition**: The **load factor** determines when HashMap should resize the internal array (rehashing) to accommodate more entries.
- **Default Load Factor**: `0.75`
- **Threshold**: `Threshold = Load Factor * Current Capacity`
- **Example**: With an initial capacity of 16 and a load factor of 0.75, resizing occurs when the map exceeds 12 entries (`16 * 0.75 = 12`).

---

#### **3: Default Load Factor and Capacity**
- **Default Load Factor**: `0.75`
  - **Why?**: Optimizes both memory usage and performance by reducing the chance of collisions and ensuring resizing happens before too many collisions occur.
- **Default Initial Capacity**: `16`
  - **Why?**: The number 16 is a power of two, which makes bucket index calculation faster (`hash & (n - 1)`).
  - **Trade-off**: It prevents frequent resizing for small maps and excessive memory usage for larger maps.

---

#### **4: When Does Resizing Happen?**
- **Threshold Calculation**:  
   `Threshold = Initial Capacity x Load Factor`  
   - With the default values: `Threshold = 16 * 0.75 = 12`
- **Resizing Action**: When the map exceeds the threshold (12 in this case), the internal array **doubles in size** (e.g., from 16 to 32), and **rehashing** occurs.

---

#### **5: Rehashing**
- **Definition**: When the number of entries exceeds the threshold, the size of the array is doubled, and all existing entries are **rehashed** into the new array.
- **Effect**: Rehashing helps maintain the efficiency of `put()` and `get()` operations, ensuring the number of collisions remains low.

---

#### **6: Collision Handling Methods**
- **Chaining**:
  - Each bucket holds a **linked list** of entries.
  - **Example**: `bucket[4] --> [Entry1] --> [Entry2] --> [Entry3]`
- **Open Addressing**:
  - A collision is resolved by finding the next available slot using **probing**.
  - **Techniques**:
    1. **Linear Probing**: Check the next available slot.
    2. **Double Hashing**: Use a second hash function to determine the next slot.

---

#### **7: Hash Function**
- **Purpose**: Converts a large number (hash code) into an index in the hash table.
- **Common Methods**:
  1. **Division Method**: `h(k) = k % m`
  2. **Multiplication Method**: `h(k) = (k * A) % m`, where `A` is a constant.

---

### **SortedSet, Comparator, and Iterator in Java**

---

#### **1: SortedSet Interface in Java**
- **Definition**: The `SortedSet` interface extends `Set` and maintains elements in **ascending order**.
- **Key Features**:
  - Prevents duplicates (like all `Set` implementations).
  - Provides methods for accessing the **first** and **last** elements.
  - Supports **range** views (subset of elements between two values).
- **Common Implementations**: `TreeSet`.

---

#### **2: Comparator Interface in Java**
- **Purpose**: The `Comparator` interface allows for **custom comparison logic**.
- **Method**: `compare(T o1, T o2)`
  - Returns:
    - **0** if `o1` is equal to `o2`.
    - **> 0** if `o1` is greater than `o2`.
    - **< 0** if `o1` is less than `o2`.
- **Usage**: Useful for sorting collections in a way other than their natural ordering.

---

#### **3: Java Comparable Interface**
- **Purpose**: The `Comparable` interface defines the **default sorting logic** for objects.
- **Method**: `compareTo(T o)`
  - Returns:
    - **0** if the current object is equal to `o`.
    - **> 0** if the current object is greater than `o`.
    - **< 0** if the current object is less than `o`.
- **Usage**: Useful for sorting objects based on their natural ordering (typically a single field).

---

#### **4: Java Comparable vs Comparator**
- **Comparable**:
  - **Natural Ordering**: Defines the natural order of objects (usually based on one field).
  - **Method**: `compareTo()`.
  - **Usage**: Used when sorting objects in a **default order**.
  
- **Comparator**:
  - **Custom Ordering**: Allows custom sorting based on multiple fields or different criteria.
  - **Method**: `compare()`.
  - **Usage**: Used when sorting objects in a **non-default** order.

---

#### **5: Java Iterator**
- **Purpose**: The `Iterator` interface provides a way to **traverse** through a collection of elements one at a time.
- **Key Methods**:
  1. **hasNext()**: Returns `true` if there are more elements to iterate over.
  2. **next()**: Returns the next element in the iteration.
  3. **remove()**: Removes the last element returned by the iterator (optional operation).

---

