
![Example Image](Downloads/hierarchy-of-collection-framework.jpg)

### **Collections Framework in Java**

#### **What It Is**
A set of interfaces and classes to handle collections of objects efficiently.

#### **Why It's Used**
To store, retrieve, and manipulate data in a standard, efficient way.

#### **What It Does**
- Stores and manages data.
- Provides methods to manipulate and query data.

#### **What Problem It Solves**
- Replaces custom data-handling code with reusable, optimized solutions.

#### **How It Works**
- **Interfaces**: `Collection`, `List`, `Set`, `Queue`, `Map`.
- **Implementations**: `ArrayList`, `HashSet`, `LinkedList`, `PriorityQueue`, `HashMap`.
- **Algorithms**: Provided by `Collections` class for sorting and searching.

### **Collection Interfaces**

#### **1. Collection**
- **What It Does**: Represents a group of objects.
- **How It Works**: Basic operations like `add()`, `remove()`, `size()`.
- **What It Solves**: Standardizes collection handling.
- **Example**:

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");
```

#### **2. List**
- **What It Does**: Ordered collection, allows duplicates.
- **How It Works**: Access elements by index.
- **What It Solves**: Stores data in order with duplicates.
- **Example**:

```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
System.out.println(list.get(0));  // Output: Apple
```

#### **3. Set**
- **What It Does**: Collection with unique elements.
- **How It Works**: Duplicates are not allowed.
- **What It Solves**: Ensures uniqueness of elements.
- **Example**:

```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");  // Duplicate, won't be added
System.out.println(set);  // Output: [Apple, Banana]
```

#### **4. Queue**
- **What It Does**: FIFO collection.
- **How It Works**: Adds elements to the end, removes from the front.
- **What It Solves**: Process elements in order they were added.
- **Example**:

```java
Queue<String> queue = new LinkedList<>();
queue.add("Apple");
queue.add("Banana");
System.out.println(queue.poll());  // Output: Apple
```

#### **5. Map**
- **What It Does**: Collection of key-value pairs.
- **How It Works**: Each key maps to a unique value.
- **What It Solves**: Stores data in pairs for fast access.
- **Example**:

```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 1);
map.put("Banana", 2);
System.out.println(map.get("Apple"));  // Output: 1
```

#### **6. Enum**
- **What It Does**: Represents a fixed set of constants.
- **How It Works**: Each constant is a unique instance of the Enum type.
- **What It Solves**: Provides type safety and ensures that a variable can only hold predefined constant values.
- **Example**:

```java
enum Fruit {
    APPLE, BANANA, ORANGE;
}

Fruit myFruit = Fruit.APPLE;
System.out.println(myFruit);  // Output: APPLE
```


### **ConcurrentHashMap**
**What It Does**
A thread-safe implementation of the Map interface that supports high-concurrency access.

**Why We Use It**
To avoid bottlenecks caused by synchronizing the entire map.
Efficient for multithreaded environments where multiple threads read/write concurrently.

**Behavior**
Allows multiple threads to read and update different segments concurrently.
Does not throw ConcurrentModificationException during iteration.
Weak consistency: Iterators reflect changes made during iteration but may not show all updates.

**Access**
Reads: Very fast as they are not blocked.
Writes: Only locks the segment being modified, allowing better concurrency..

- **Example**:

```java
import java.util.concurrent.*;

ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("Apple", 1);
map.put("Banana", 2);

System.out.println(map.get("Apple"));  // Output: 1
```

- **Key Features**:
  - Thread-safe operations.
  - Supports high concurrency with minimal contention.
  - Allows `null` values and keys (unlike `Hashtable`).
  - Lock-free reads and thread-safe writes.

### **Fail-fast vs Fail-safe**

#### **Fail-fast**
- **What It Does**: Detects concurrent modification of a collection and throws an exception immediately.
- **How It Works**: It works by checking if the collection is modified while iterating. If modified (like adding or removing elements), it throws a `ConcurrentModificationException`.
- **What It Solves**: Prevents unexpected behavior during iteration due to structural changes.
- **Example**:

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
Iterator<String> itr = list.iterator();
list.add("C");  // Modifying the collection while iterating
itr.next();  // Throws ConcurrentModificationException
```

#### **Fail-safe**
- **What It Does**: Allows safe iteration over a collection even if it is modified during iteration.
- **How It Works**: A copy of the collection is made for iteration, so changes made to the original collection don't affect the iteration process.
- **What It Solves**: Allows iteration without throwing exceptions even if the collection is modified during iteration.
- **Example**:

```java
List<String> list = new CopyOnWriteArrayList<>();
list.add("A");
list.add("B");
Iterator<String> itr = list.iterator();
list.add("C");  // Modifying the collection while iterating
itr.next();  // No exception, safely continues iteration
```

### **Key Differences**
- **Fail-fast**: Throws exceptions if collection is modified during iteration (e.g., `ArrayList`, `HashMap`).
- **Fail-safe**: Can continue iteration even if collection is modified (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`).