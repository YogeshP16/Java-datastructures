
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
