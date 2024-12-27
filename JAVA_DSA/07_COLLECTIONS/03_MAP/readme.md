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

### **HashMap Default Load Factor and Capacity**

#### **What is it?**
- **Default Load Factor**: `0.75`
- **Default Initial Capacity**: `16`

---

#### **Why is the Default Load Factor 0.75?**
- **Balance**: Optimizes memory usage and performance.
- **Collision Reduction**: Reduces the chances of multiple entries in the same bucket.
- **Efficient Resizing**: Resizes before too many collisions occur.

---

#### **Why is the Initial Capacity 16?**
- **Power of Two**: Makes bucket index calculation faster (`hash & (n - 1)`).
- **Trade-off**: Avoids frequent resizing for small maps and excessive memory usage for large maps.

---

#### **When Does Resizing Happen?**
- **Threshold Formula**:  
   
   Threshold = Initial Capacity x  Load Factor
   
- **For default values**:
   Threshold = 16  times 0.75 = 12
   
- **Action**: HashMap resizes when entries exceed the threshold.

---

### **Cheatsheet: Default Load Factor and Capacity**

| **Property**        | **Value**                     | **Why?**                                                    |
|----------------------|-------------------------------|-------------------------------------------------------------|
| **Load Factor**      | `0.75`                       | Balances speed and memory usage, reduces collisions.         |
| **Initial Capacity** | `16`                         | Efficient indexing with power of two, avoids frequent resizing. |
| **Resize Threshold** | `Initial Capacity * 0.75`    | Triggers resizing when map is ~75% full.                    |
| **Resizing Action**  | Capacity doubles (e.g., 16 → 32). | Ensures enough space to reduce collisions.                  |

---

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


