### **What is a List?**

A List is an ordered collection in Java that:
- Maintains insertion order.
- Allows duplicate elements.
- Provides indexed access to elements.

### **Implementations of the List Interface**

#### **ArrayList**
- resizable array implementation of the List interface in Java, which allows dynamic storage and fast random access to elements
- Fast for random access (`get()` and `set()` are O(1)).
- Slower for insertions/deletions in the middle (shifting required).

#### **LinkedList**
- data structure that stores elements in nodes, where each node contains a value and a reference to the next node in the sequence.
- Fast for insertions/deletions anywhere (`add()` and `remove()` are O(1) for iterators).
- Slower for random access (`get()` is O(n)).

#### **Vector**
- Synchronized version of ArrayList (not commonly used now).
- Thread-safe but slower due to synchronization overhead.

### **Key Methods in the List Interface**

| Method                           | Description                                               | Example                                    |
|-----------------------------------|-----------------------------------------------------------|--------------------------------------------|
| `add(E e)`                        | Appends an element to the list.                           | `list.add("apple");`                       |
| `add(int index, E element)`       | Inserts an element at a specific index.                   | `list.add(1, "banana");`                   |
| `get(int index)`                  | Retrieves the element at a specific index.                | `String fruit = list.get(0);`             |
| `set(int index, E element)`       | Replaces the element at a specific index.                 | `list.set(0, "grape");`                   |
| `remove(int index)`               | Removes the element at a specific index.                  | `list.remove(0);`                          |
| `remove(Object o)`                | Removes the first occurrence of the specified element.    | `list.remove("apple");`                   |
| `size()`                          | Returns the number of elements in the list.               | `int size = list.size();`                 |
| `contains(Object o)`              | Checks if the list contains a specific element.           | `boolean hasApple = list.contains("apple");` |
| `indexOf(Object o)`               | Returns the index of the first occurrence.                | `int index = list.indexOf("banana");`     |
| `lastIndexOf(Object o)`           | Returns the index of the last occurrence.                 | `int lastIndex = list.lastIndexOf("banana");` |
| `clear()`                         | Removes all elements from the list.                        | `list.clear();`                            |
| `isEmpty()`                       | Checks if the list is empty.                              | `boolean empty = list.isEmpty();`         |
| `subList(int fromIndex, int toIndex)` | Returns a view of a portion of the list.                  | `List<String> sub = list.subList(1, 3);`  |

### **Differences Between ArrayList and LinkedList**

| Feature                      | ArrayList                      | LinkedList                     |
|------------------------------|--------------------------------|--------------------------------|
| Storage                      | Dynamic array.                 | Doubly-linked list.            |
| Access Speed                 | Fast (O(1)).                   | Slower (O(n)).                 |
| Insertion/Deletion           | Slower in the middle (O(n)).   | Fast in the middle (O(1) if iterator is used). |
| Memory Usage                 | Less (array overhead only).    | More (node objects required). |

### **Thread-Safe Alternatives**

#### **CopyOnWriteArrayList** (from `java.util.concurrent`)
- Thread-safe alternative to ArrayList.
- Performs a copy of the underlying array on each modification, making it slower for writes but fast for reads.

#### **Collections.synchronizedList(List)**
- Wraps any list in a synchronized wrapper.
 
```
```
### **What is a Set?**

A Set is a collection in Java that:
- Does not allow duplicate elements.
- Does not guarantee insertion order (except in specific implementations).
- Provides operations for mathematical set theory (union, intersection, etc.).

### **Implementations of the Set Interface**

#### **HashSet**
- Backed by a HashMap.
- Fast for add, remove, and contains operations (O(1) average).
- Does not preserve insertion order.

#### **LinkedHashSet**
- Extends HashSet.
- Preserves insertion order.
- Slightly slower than HashSet due to the additional ordering overhead.

#### **TreeSet**
- Backed by a TreeMap.
- Stores elements in sorted (ascending) order.
- Slower than HashSet for most operations (O(log n) due to tree structure).

#### **EnumSet**
- Specialized for enums.
- Very efficient for a fixed set of constants.

### **Key Methods in the Set Interface**

| Method                         | Description                                               | Example                              |
|---------------------------------|-----------------------------------------------------------|--------------------------------------|
| `add(E e)`                      | Adds an element to the set.                               | `set.add("apple");`                  |
| `remove(Object o)`              | Removes the specified element.                            | `set.remove("apple");`               |
| `contains(Object o)`            | Checks if the set contains the specified element.         | `boolean exists = set.contains("apple");` |
| `size()`                        | Returns the number of elements in the set.                | `int size = set.size();`             |
| `isEmpty()`                     | Checks if the set is empty.                               | `boolean empty = set.isEmpty();`     |
| `clear()`                       | Removes all elements from the set.                        | `set.clear();`                       |
| `iterator()`                    | Returns an iterator for the set.                          | `Iterator<String> itr = set.iterator();` |

### **Thread-Safe Alternatives**

#### **Collections.synchronizedSet(Set)**
- Wraps a set in a synchronized wrapper.

### **Special Features of Set**

#### **No Duplicates**
- If an element already exists, `add(E e)` does not add it again and returns false.

#### **Mathematical Set Operations**
- **Union**: Combine two sets.
- **Intersection**: Common elements between two sets.

### **Time and Space Complexities for List and Set**

#### **List (ArrayList, LinkedList)**

| Operation                   | **ArrayList**         | **LinkedList**        |
|-----------------------------|-----------------------|-----------------------|
| **Access (get, set)**        | O(1)                  | O(n)                  |
| **Search (contains)**        | O(n)                  | O(n)                  |
| **Insert (at end)**          | O(1)                  | O(1)                  |
| **Insert (at index)**        | O(n)                  | O(n)                  |
| **Remove (at end)**          | O(1)                  | O(1)                  |
| **Remove (at index)**        | O(n)                  | O(n)                  |
| **Add (at beginning)**       | O(n)                  | O(1)                  |
| **Add (at middle)**          | O(n)                  | O(n)                  |
| **Space Complexity**         | O(n)                  | O(n)                  |

#### **Set (HashSet, LinkedHashSet, TreeSet)**

| Operation                   | **HashSet**           | **LinkedHashSet**     | **TreeSet**           |
|-----------------------------|-----------------------|-----------------------|-----------------------|
| **Access**                   | O(1) (average)        | O(1) (average)        | O(log n)              |
| **Search (contains)**        | O(1) (average)        | O(1) (average)        | O(log n)              |
| **Insert (add)**             | O(1) (average)        | O(1) (average)        | O(log n)              |
| **Remove (remove)**          | O(1) (average)        | O(1) (average)        | O(log n)              |
| **Space Complexity**         | O(n)                  | O(n)                  | O(n)                  |

### **Key Points**
- **ArrayList** offers fast random access (O(1)) but has slower insertions and deletions in the middle (O(n)).
- **LinkedList** is faster for insertions and deletions at the ends or middle (O(1) if iterator used), but slower for random access (O(n)).
- **HashSet** and **LinkedHashSet** offer fast operations on average (O(1)) but suffer from O(n) performance in the worst case due to hash collisions.
- **TreeSet** ensures sorted order but has O(log n) time complexity for insertion, deletion, and search due to the tree structure.