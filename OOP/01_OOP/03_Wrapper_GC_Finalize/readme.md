### **Wrapper Classes in Java** 

#### **Wrapper Classes**
-  A wrapper class is a class that encapsulates a primitive type into an object. Examples:
    - `int` → `Integer`
    - `char` → `Character`
    - `boolean` → `Boolean`
    - `short` → `Short`
    - `byte` → `Byte`
    - `long`→ `Long`
    - `float` → `Float`
    - `double` → `Double`


#### **Autoboxing**
- Autoboxing is the automatic conversion of a primitive type to its corresponding wrapper class. 
  - **Example**: `int a = 10; Integer b = a;`


#### **Unboxing**
- Unboxing is the automatic conversion of a wrapper class to its corresponding primitive type.
  - **Example**: `Integer v = 20; int x = v;`


#### **Why Use Wrapper Classes?**
- Wrapper classes are used to treat primitive types as objects, allowing them to be stored in collections and passed by reference.


---

### **`final` Keyword in Java**

#### **What it is:**
The `final` keyword is used to declare constants, prevent method overriding, and restrict inheritance.

#### **Why it's used:**
- To declare **constants** (values that cannot be changed).
- To ensure **immutability** of variables, methods, and classes.
- To prevent method overriding or class inheritance.

#### **What it does:**
- **For variables**: The value cannot be changed once initialized.
- **For methods**: The method cannot be overridden in subclasses,  no subclass can change the method's implementation.
- **For classes**: The class cannot be subclassed, no other class can extend the class.

#### **Constant Variables**
- **Q**: How do you create a constant variable in Java?
- **A**: Use the `final` keyword to declare a constant variable, making its value immutable after initialization.
  - **Example**: `final int VAR = 10;`

---

### **Garbage Collection in Java**

#### **What it is:**
Garbage Collection (GC) in Java where Java Virtual Machine (JVM) automatically deletes objects that are no longer in use, freeing up memory.
Automatic process looking at heap memory, identifying which objects are used and unused and delete  those unused objects.
unused objects --> no longer reference of any part of program

#### **Why it's used:**
Garbage Collection helps to **automatically manage memory**, preventing memory leaks by reclaiming memory that is no longer reachable by any active thread in the program.

#### **What it does:**
- It identifies objects that are no longer referenced or reachable from any part of the program.
- It **frees memory** by removing those objects, thus optimizing memory usage and improving performance.
  
#### **How it works:**
1. **Mark Phase**: The garbage collector marks all the objects that are reachable.
2. **Sweep Phase**: The collector then sweeps through the heap, clearing memory used by unreachable objects.
3. **Generational Collection**: Objects are divided into generations (young, old, and permanent). The GC targets short-lived objects in the young generation and longer-lived objects in the old generation for collection, improving efficiency.

The JVM handles GC automatically, but developers can tune GC settings for performance.

---

### **`finalize` Keyword in Java**

#### **What it is:**
Used to clean up non java resources before an object is garbage is collected.
The `finalize` method is part of the `Object` class in Java and is used to perform cleanup before an object is garbage-collected.

#### **Why it's used:**
It provides a way to release system resources (like closing file streams or network connections) before an object is discarded by the garbage collector.

#### **What it does:**
- The `finalize` method is called by the garbage collector just before an object is destroyed.
- It can be overridden in a class to perform cleanup tasks like releasing resources or saving data.

#### **How it works:**
- When an object is no longer reachable, the JVM invokes the `finalize` method before removing it from memory. 
- The object is eligible for garbage collection only after the `finalize` method has been executed.

Note: The `finalize` method is not guaranteed to be called immediately, and its use is discouraged in favor of try-with-resources or explicit resource management (e.g., `close()` methods).

--- 
