## Comparison Objects, Cloning, and Copy Types

### **1: Comparison Objects**
- **What it is**: Used to compare two objects in Java for sorting or ordering.
- **Why it's used**: Defines custom or natural comparison criteria for objects.
- **How it works**:
  - `Comparable`: Implemented by the class, overrides `compareTo`. Used for **natural sorting**.
  - `Comparator`: Implemented in a separate class, overrides `compare`. Used for **custom sorting**.

---

### **2: Comparable**
- **What it is**: Defines the natural ordering of objects within the class.
- **How it works**:
  - Implement `Comparable<T>` and override `compareTo`.
  - Example:
    ```java
    class Person implements Comparable<Person> {
        int age;
        @Override
        public int compareTo(Person other) {
            return this.age - other.age; // Sort by age
        }
    }
    ```

---

### **3: Comparator**
- **What it is**: Provides custom comparison logic outside the class.
- **How it works**:
  - Implement `Comparator<T>` and override `compare`.
  - Example:
    ```java
    class NameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name); // Sort by name
        }
    }
    ```

---

### **4: compareTo for Numeric Comparison**
- **What it does**: Compares two numeric values.
- **How it works**:
  - Negative if smaller, positive if larger, zero if equal.
  - Example:
    ```java
    Integer.valueOf(10).compareTo(20); // Negative
    ```

---

### **5: compareTo for Alphabetical Comparison**
- **What it does**: Compares strings lexicographically.
- **How it works**:
  - Negative if smaller, positive if larger, zero if equal.
  - Example:
    ```java
    "apple".compareTo("banana"); // Negative
    ```

---

### **6: Object Cloning**
- **What it is**: Creating an exact copy of an object.
- **Why it's used**: Duplicate an object without affecting the original.
- **How it works**: Implement `Cloneable` and override `clone()`.

---

### **7: Shallow Copy**
- **What it does**: Copies the object but shares references to internal objects.
- **Key Points**:
  - Changes to inner objects affect both the original and the copy.
  - Example:
    ```java
    // Shared inner object
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    ```

---

### **8: Deep Copy**
- **What it does**: Copies the object and duplicates all internal objects.
- **Key Points**:
  - Changes to one do not affect the other.
  - Example:
    ```java
    // Independent inner objects
    List<Integer> newList = new ArrayList<>(originalList);
    ```

