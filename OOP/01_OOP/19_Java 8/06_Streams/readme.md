

### **1. What are Streams?**
- Streams in Java are used to **process a sequence of elements** in a **functional programming style**.
- They enable operations like **filtering, mapping, sorting, and reducing** on a collection or array without modifying the original data.

---

#### **2. Key Characteristics of Streams:**
- **Non-Storage**: Streams don’t store data; they process data as it flows.
- **Lazy Evaluation**: Intermediate operations are evaluated only when a terminal operation is invoked.
- **Immutable**: The source data remains unmodified.
- **Pipelined Operations**: Stream operations are combined into a single pass for better efficiency.

---

#### **3. Stream Pipeline Components:**
| **Stage**           | **Description**                                                                 |
|----------------------|---------------------------------------------------------------------------------|
| **Source**           | Data source (e.g., Collections, Arrays, I/O channels).                         |
| **Intermediate Ops** | Transform the stream (e.g., `filter()`, `map()`, `sorted()`).                  |
| **Terminal Ops**     | Produce a result or a side-effect (e.g., `collect()`, `forEach()`, `reduce()`). |

---

#### **4. Common Stream Methods:**
| **Method**             | **Purpose**                                                                                          |
|-------------------------|------------------------------------------------------------------------------------------------------|
| `stream()`             | Creates a sequential stream from a collection.                                                      |
| `parallelStream()`     | Creates a parallel stream for multi-threaded processing.                                             |
| `filter(Predicate)`    | Filters elements based on a condition.                                                              |
| `map(Function)`        | Transforms each element (e.g., `String` to `Integer`).                                              |
| `sorted()`             | Sorts elements in natural or custom order.                                                          |
| `distinct()`           | Removes duplicate elements.                                                                         |
| `limit(n)`             | Limits the stream to the first `n` elements.                                                       |
| `skip(n)`              | Skips the first `n` elements.                                                                       |
| `forEach(Consumer)`    | Iterates through elements and performs an action.                                                   |
| `collect(Collector)`   | Gathers elements into a collection (e.g., `List`, `Set`, `Map`).                                    |
| `reduce(BinaryOperator)`| Aggregates elements into a single result (e.g., sum, max, concatenation).                          |
| `count()`              | Counts the number of elements in the stream.                                                        |
| `anyMatch(Predicate)`  | Returns `true` if any element matches the predicate.                                                |
| `allMatch(Predicate)`  | Returns `true` if all elements match the predicate.                                                 |
| `noneMatch(Predicate)` | Returns `true` if no elements match the predicate.                                                  |

---

#### **5. Types of Streams:**
1. **Sequential Stream**:
   - Processes data sequentially (single-threaded).
   - Created using `stream()`.

2. **Parallel Stream**:
   - Processes data concurrently (multi-threaded).
   - Created using `parallelStream()`.

---

#### **6. Examples:**
##### **Filter and Collect Example:**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");

List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A")) // Filters names starting with 'A'
    .distinct()                           // Removes duplicates
    .collect(Collectors.toList());       // Collects into a List

System.out.println(filteredNames); // Output: [Alice]
```

##### **Map and Reduce Example:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream()
    .map(x -> x * 2)           // Multiply each number by 2
    .reduce(0, Integer::sum);  // Sum all elements

System.out.println(sum); // Output: 30
```

---

#### **7. Key Collectors for `collect()`**
| **Collector**                 | **Purpose**                                |
|-------------------------------|--------------------------------------------|
| `toList()`                    | Collects elements into a `List`.           |
| `toSet()`                     | Collects elements into a `Set`.            |
| `toMap(Function, Function)`   | Collects elements into a `Map`.            |
| `joining(delimiter)`          | Concatenates elements into a `String`.     |
| `groupingBy(Function)`        | Groups elements by a classifier.           |
| `partitioningBy(Predicate)`   | Partitions elements into two groups (true/false). |

---

#### **8. Streams vs Collections:**
| **Streams**                    | **Collections**                    |
|--------------------------------|-------------------------------------|
| Processes elements lazily.     | Stores elements eagerly.           |
| Can’t reuse once consumed.     | Can be reused multiple times.      |
| Provides functional operations.| Offers imperative operations.      |

---

#### **9. Performance Tips:**
- Use **parallel streams** for large datasets but avoid if the task involves heavy synchronization.
- Minimize the number of intermediate operations.
- Use `filter()` early in the pipeline to reduce unnecessary processing.

---

#### **10. Limitations of Streams:**
- Debugging is harder due to the functional nature.
- Streams don’t support indexing (use `skip()` or `limit()` instead).

---

#### **11. When to Use Streams:**
- For concise and readable code when processing collections or arrays.
- For scenarios where you need operations like filtering, mapping, and reducing.

---

### **`collect()` Methods in Java Streams**  

🔥 **1. Convert Stream to List, Set, or Map**  
```java
List<Integer> list = stream.collect(Collectors.toList());
Set<Integer> set = stream.collect(Collectors.toSet());
Map<Integer, String> map = stream.collect(Collectors.toMap(k -> k, v -> "Value" + v));
```

✅ **2. Joining Strings**  
```java
String result = stream.collect(Collectors.joining(", "));  // "A, B, C"
```

✅ **3. Counting Elements**  
```java
long count = stream.collect(Collectors.counting());  // Number of elements
```

✅ **4. Finding Min/Max**  
```java
Optional<Integer> max = stream.collect(Collectors.maxBy(Comparator.naturalOrder()));
Optional<Integer> min = stream.collect(Collectors.minBy(Comparator.naturalOrder()));
```

✅ **5. Summing and Averaging**  
```java
int sum = stream.collect(Collectors.summingInt(n -> n));
double avg = stream.collect(Collectors.averagingInt(n -> n));
```

✅ **6. Grouping Elements (`groupingBy`)**  
```java
Map<String, List<Person>> grouped = people.stream()
    .collect(Collectors.groupingBy(Person::getDepartment));
```

✅ **7. Partitioning by Predicate (`partitioningBy`)**  
```java
Map<Boolean, List<Integer>> partitioned = list.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```
