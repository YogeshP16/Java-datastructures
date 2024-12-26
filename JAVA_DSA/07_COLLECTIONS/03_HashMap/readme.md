### **HashMap vs Hashtable**

**HashMap:**
- key : Value pair
- Allows null keys and values.
- Not synchronized, making it faster than Hashtable for single-threaded use cases.
- Allows one null key and multiple null values.

**Hashtable:**
- Does not allow null keys or values.
- Synchronized, making it slower than HashMap.
- Thread-safe.

### **What it solves**
- Fast Lookup: Need to quickly find if a user exists in a database by their ID.
- Frequency Count: Counting the frequency of each word in a text document.
- Cache Management: Storing recently accessed data where retrieval speed is critical.
- Handle large datasets, fast lookups

### **How Numbers Are Converted into Hash Codes**

```java
// hashCode() is used to generate an integer representation for objects.
// For example, String "hello" will generate a hash code.

String str = "hello";
int code = str.hashCode();   // hashCode() converts "hello" to a hash code integer.
System.out.println("HashCode of 'hello': " + code);  // Output: 99162322

// Integer objects also have their own hashCode method.
Integer i = 1232234;
int res = i.hashCode();     // Integer itself has the same value as its hash code.
System.out.println("HashCode of Integer 1232234: " + res);  // Output: 1232234
```

### **Internal Workings of HashMap**
- Internally, HashMap uses an array of "buckets" (slots) to store entries (key-value pairs).
- Each bucket corresponds to an index determined by the hash code of the key.
- If there is a collision (two keys hash to the same index), HashMap handles it using either:
  1. Chaining (linked list of entries at the same bucket index).
  2. Open addressing (finding another empty slot using probing).

### **Load Factor in HashMap**
- The load factor determines when to resize the internal array (rehashing).
- Default load factor is 0.75.
- If the map exceeds the threshold (load factor * current capacity), the map will resize.
- For example, with an initial capacity of 16 and load factor of 0.75, the map will resize when the number of entries exceeds 12 (16 * 0.75 = 12).

### **Rehashing**
- When the number of entries exceeds the threshold, the map's array size is doubled, and all existing entries are rehashed to the new array.

### **Performance**
- In HashMap, insertion and retrieval are typically O(1), but collisions can occur.
- Collision happens when two keys hash to the same index in the hash table.

### **Resolving Collisions**
1. **Chaining**: Store multiple elements at the same index using a linked list.
2. **Open addressing**: Find the next available index using probing.

### **Chaining**
Every index in the array holds a linked list of elements.
- Example:
  - [4] --> [] --> [] --> []
  - [7] --> [] --> [] --> []

### **Hash Function**
To convert a large number (hash code) into an index in the hash table:
- Use modulo operation: `hashCode % tableSize`

### **Hash Function Methods**
- Division method: `h(k) = k % m`
- Multiplication method: `h(k) = (k * A) % m`, where A is a constant.

### **Table Size and Load Factor**
- Load factor: `n/m` where `n` is the number of keys, and `m` is the table size.
- A higher load factor can increase the likelihood of collisions.

### **Open Addressing**
- Only one item per slot.
- When a collision occurs, we try to find the next available slot (probing).
- Techniques like linear probing or double hashing are used to resolve collisions.

**Advantages of Open Addressing**:
- More cache-efficient than chaining.
- **Chaining** is more resilient to poor hash functions.

### **Time & Space Complexity of HashMap**

#### **Time Complexity**
- **Insert (put)**: O(1) on average, but O(n) in the worst case (when rehashing occurs).
- **Search (get)**: O(1) on average, but O(n) in the worst case (when collisions are high).
- **Delete (remove)**: O(1) on average, but O(n) in the worst case (when collisions are high).

#### **Space Complexity**
- **Space**: O(n) where n is the number of entries (key-value pairs).
- The space is used for storing the array of buckets and the entries within each bucket.

#### **Important Notes**
- **Average Case**: O(1) for insert, search, and delete due to efficient hashing.
- **Worst Case**: O(n) if there are many collisions (e.g., when all keys hash to the same bucket).


### **ConcurrentHashMap**
- **What It Does**: A thread-safe implementation of the `Map` interface that allows concurrent access to multiple threads without locking the entire map.
- **How It Works**: Divides the map into segments, allowing multiple threads to update different segments simultaneously, improving performance over synchronized maps.
- **What It Solves**: Provides better concurrency in multithreaded environments, avoiding the bottleneck of synchronizing the entire map.
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