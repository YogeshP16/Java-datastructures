### Comparison Objects

- **What it is**:  
  Comparison objects are used in Java to compare two objects. They are often implemented using the `Comparator` or `Comparable` interface.

- **Why it's used**:  
  It is used to define how two objects should be compared, typically for sorting or ordering purposes.

- **What it does**:  
  It provides a way to compare objects based on a specified criterion (e.g., numerical order, alphabetical order).

- **How it works**:
  - **Comparable**: The class implements `Comparable` and overrides the `compareTo` method. It compares the current object (`this`) with the provided object.

  - **Comparator**: The class implements `Comparator` and overrides the `compare` method. It compares two objects of any class based on a custom criterion.

  ```java
  class Person implements Comparable<Person> {
      String name;
      int age;

      @Override
      public int compareTo(Person other) {
          return this.age - other.age; // Compare by age
      }
  }
  
  class PersonComparator implements Comparator<Person> {
      @Override
      public int compare(Person p1, Person p2) {
          return p1.name.compareTo(p2.name); // Compare by name
      }
  }
  ```

### **Comparable: --> for natural sorting of objects**
- It's like students in a class naturally knowing their roll numbers.
- They can line up in order of their roll numbers without needing anyone else to tell them how to do it.
- The rule of sorting by roll number is built into them, so they can organize themselves automatically.

It is implemented within the object (the class itself). The object knows how to compare itself to another object of the same type.
In-place sorting: Sorting logic is embedded in the class, so the class itself defines the "natural" order.

### **compareTo for Numeric Comparison**

- **What it is**:  
  `compareTo` compares numeric values (integers, floats) between two objects.

- **How it works**:  
  It compares the values directly:
  - If the first number is smaller, it returns **negative**.  
  - If the first number is larger, it returns **positive**.  
  - If both are equal, it returns **0**.

- **Example**:
  ```java
  Integer.valueOf(10).compareTo(20); // Negative (10 is smaller than 20)
  Integer.valueOf(10).compareTo(10); // 0 (equal)
  Integer.valueOf(20).compareTo(10); // Positive (20 is larger than 10)
  ```

  ### **compareTo for Alphabetical Comparison (KISS)**

- **What it is**:  
  `compareTo` compares strings lexicographically (like in a dictionary).

- **How it works**:  
  It compares characters one by one using their Unicode values.  
  - If the first string is smaller, it returns **negative**.  
  - If the first string is larger, it returns **positive**.  
  - If both are equal, it returns **0**.

- **Example**:
  ```java
  "apple".compareTo("banana"); // Negative (apple comes before banana)
  "apple".compareTo("apple");  // 0 (equal)
  "apple".compareTo("appl");   // Positive (apple is longer)
  ```

  ### **1. Comparator - for custom sorting**
  - It's like a teacher outside the class tells the students how to line up (e.g., by roll number).
  - The students follow the teacher’s rule, but they don’t know how to sort themselves.
  - The sorting rule is defined externally (by the Comparator), not by the students.
  
   - It is a **separate class** that **externalizes** the comparison logic.
   - **Custom sorting**: You can define various sorting criteria in different comparator classes. For instance, you could have one comparator that sorts by roll number, another that sorts by name, etc.

   **Example**:
   ```java
   class RollNoComparator implements Comparator<Student> {
       @Override
       public int compare(Student s1, Student s2) {
           return s1.rollNo - s2.rollNo; // Custom order by roll number
       }
   }
   ```

---

### **Object Cloning**
- **What it is**: Object cloning is the process of creating an exact copy of an object.
- **Why it's used**: It is used when you need a duplicate of an object without affecting the original.
- **What it does**: Creates a new instance of an object with the same values as the original object.
- **How it works**: In Java, the Cloneable interface is used for cloning objects, and the clone() method is called to duplicate the object.

---
### **Shallow Copy**
- **What it does**: Creates a new object but **shares references** to the original object's internal objects.
- **How it works**: The outer object is copied, but the inner objects (like an `ArrayList`) are not duplicated. Instead, both the original and the copy point to the **same inner objects**.
- **What it ensures**: Changes to the shared inner objects in one copy affect the other copy.

#### **Key Points**
1. **Shared Inner Objects**:
   - The outer object  is new, but the inner references (like the `ArrayList`) remain shared.
   - Modifying the shared inner object affects both the original and the shallow copy.

2. **Example Behavior**:
   - Change inner objects → Both the original and the shallow copy reflect the changes.
   - Change outer object attributes (if any) → Changes are independent.

---


### **Deep copy**
- **What it does**: Creates a completely independent new object.
- **How it works**: The new object gets the same values as the original object, but not the same references to internal objects.
- **What it ensures**: Changes made to the original object do not affect the deep-copied object, and vice versa.

#### **Key Points**
1. **Independent Objects**:
   - The new object and the original are completely separate.
   - If the original object has a reference (like an `ArrayList`), the deep copy creates a new reference with the same data, not a shared one.

2. **Example Behavior**:
   - Original object changes → Deep copy remains unaffected.
   - Deep copy changes → Original object remains unaffected.

---