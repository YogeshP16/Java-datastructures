### **Flashcards: Java Basics**  

---

### **🔹 What is Java?**  
✔ **Platform-independent** object-oriented programming language.  
✔ **"Write Once, Run Anywhere"** – Java programs run on any OS with a JVM.  
✔ Java code is both **compiled** (to bytecode) and **interpreted** (by JVM).  

---

### **🔹 Java Development Components**  

| Component | Contains | Purpose |
|-----------|----------|---------|
| **JDK (Java Development Kit)** | JRE + Compiler + Debugger | For **development** (compiling & running Java apps) |
| **JRE (Java Runtime Environment)** | JVM + Libraries | For **running** Java applications |
| **JVM (Java Virtual Machine)** | Class Loader + Runtime Memory + Execution Engine | Converts **bytecode** to machine code |

---

### **🔹 JVM Key Components**  

✔ **Class Loader** → Loads `.class` files into memory.  
✔ **Runtime Memory** → Manages **Stack, Heap, Method Area**.  
✔ **Execution Engine** → Interprets bytecode & runs it.  

✅ **How Java Runs Code?**  
1️⃣ **Java Source Code (`.java`)** → **Compiled to Bytecode (`.class`)**  
2️⃣ **JVM loads Bytecode** → Converts to **Machine Code** → Executes 🚀  

---

### **🔹 JIT (Just-In-Time) Compiler**  
✔ Converts **bytecode** to **native machine code** **at runtime**.  
✔ **Improves Performance** by reducing repeated interpretation.  

---

### **🔹 Why Java is NOT 100% Object-Oriented?**  
✔ **Primitive types** (`int, double, boolean`) are not objects.  
✔ **Wrapper classes** (`Integer`, `Double`, `Boolean`) provide an object alternative.  

✅ **Example:**  
```java
int num = 10;  // Primitive type
Integer obj = Integer.valueOf(num); // Wrapper class
```

### **Flashcards: Java Basics**  

---

### **🔹 Data Types in Java**  
✔ **Primitive Types** → `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`.  
✔ **Reference Types** → `String`, `Array`, `Class` (Require memory allocation).  

---

### **🔹 Reserved Keywords**  
✔ **Modifiers** → `abstract`, `final`.  
✔ **Inheritance** → `interface`, `super`.  

---

### **🔹 Identifiers & Literals**  
✔ **Identifier** → Name for **class, variable, or method**.  
✔ **Literals** → Constant values assigned to variables (`10`, `3.14`, `'A'`, `true`).  

---

### **🔹 Type Casting in Java**  
✔ **Automatic Type Conversion (Widening)** → **Small → Large** (`int` → `long`).  
✔ **Explicit Type Casting (Narrowing)** → **Large → Small** (`double` → `int`).  

✅ **Example:**  
```java
int num = 10;
double d = num;  // Automatic (Widening)
double x = 5.5;
int y = (int) x; // Explicit (Narrowing)
```

---

### **🔹 Boolean Logical Operators**  
| Operator | Meaning | Example |
|----------|---------|----------|
| `&&` (AND) | True if **both** conditions are true | `if (a > 5 && b < 10)` |
| `||` (OR) | True if **at least one** condition is true | `if (x == 5 || y == 3)` |
| `!` (NOT) | **Inverts** the condition | `if (!isTrue)` |

---

### **🔹 Short-Circuit Logical Operators**  
✔ `&&` → **Stops if the first condition is false**.  
✔ `||` → **Stops if the first condition is true**.  

✅ **Example:**  
```java
if (x != 0 && 10 / x > 1) {  // Stops if x == 0
    System.out.println("Valid");
}
```

---

### **🔹 Conditional (Ternary) Operator**  
✔ **Syntax:**  
```java
condition ? true-expression : false-expression;
```
✔ **Example:**  
```java
int min = (a < b) ? a : b;  // If a < b, min = a; else, min = b
```

---

### **🔹 Control Flow Statements**  
✔ **Selection** → `if`, `switch`.  
✔ **Looping** → `for`, `while`, `do-while`.  

✅ **Example:**  
```java
if (num > 10) {
    System.out.println("Greater");
} else {
    System.out.println("Smaller");
}
```

---

### **🔹 while vs do-while**  
✔ **while** → Checks condition **before execution**.  
✔ **do-while** → Executes **at least once**, then checks condition.  

✅ **Example:**  
```java
int i = 5;
while (i < 5) {   // Won't execute
    System.out.println(i);
}

do {   // Executes at least once
    System.out.println(i);
} while (i < 5);
```

---

### **🔹 Loop Control Statements**  

✔ **Break** → **Exits** the loop immediately.  
```java
for (int j = 0; j < 3; j++) {
    if (j == 1) break;
    System.out.println("j=" + j);  // Prints 0, then exits
}
```

✔ **Continue** → **Skips** current iteration & moves to the next.  
```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i);  // Prints odd numbers
}
```

---

### **🔹 Compilation & Execution in Java**  
✔ **Compile** → `javac MyClass.java`  
✔ **Run** → `java MyClass`  

### **Flashcards: Java Memory Management**  

---

### **🔹 Stack Memory**  
✔ **Purpose** → Stores **local variables** & **method calls**.  
✔ **Characteristics** →  
   - LIFO (**Last-In-First-Out**).  
   - **Thread-specific** (each thread has its own stack).  
   - **Fast** memory access.  

✅ **Example:**  
```java
void methodA() {
    int x = 10;  // Stored in Stack
    methodB();
}
```

---

### **🔹 Heap Memory**  
✔ **Purpose** → Stores **objects & class instances**.  
✔ **Characteristics** →  
   - Managed by **Garbage Collector (GC)**.  
   - **Shared among threads** (common memory space).  
   - Slower than stack but used for dynamic memory allocation.  

✅ **Example:**  
```java
class Car {
    String brand = "Toyota";  // Stored in Heap
}
Car c1 = new Car();  // Object created in Heap
```

---

### **🔹 Method Area (MetaSpace in Java 8+)**  
✔ **Purpose** → Stores **class metadata** (names, methods, fields).  
✔ **Characteristics** →  
   - **JVM-wide** (shared among all threads).  
   - **Dynamically grows** (no fixed size in Java 8+).  

✅ **Example:**  
```java
class A { 
    int num = 5;  
} // Class A's metadata is stored in the Method Area
```

---

### **🔹 Runtime Constant Pool**  
✔ **Purpose** → Stores **literals & symbolic references**.  
✔ **Characteristics** →  
   - **Part of Method Area**.  
   - **Class-specific** and optimized for reuse.  

✅ **Example:**  
```java
String s1 = "Hello";  // Stored in Runtime Constant Pool
String s2 = "Hello";  // Reuses same reference
```

---

### **🔹 Native Method Stack**  
✔ **Purpose** → Stores **data for native (non-Java) methods**.  
✔ **Characteristics** →  
   - **Thread-specific**.  
   - Supports **JNI (Java Native Interface)** for calling C/C++ code.  

✅ **Example:**  
```java
public class Test {
    native void nativeMethod(); // Calls a C function
}
```

---

### **🔹 Garbage Collection (GC)**  
✔ **Purpose** → **Reclaims memory** by removing unused objects.  
✔ **Characteristics** →  
   - **Automatic memory management**.  
   - **Optimizes Heap Memory usage**.  
   - Uses different **GC algorithms**:  
     - **Mark-Sweep** → Finds & removes unused objects.  
     - **G1 GC (Java 9+)** → Prioritizes important objects.  
     - **ZGC (Java 11+)** → Low-latency, high-performance GC.  

✅ **Example:**  
```java
Car c1 = new Car();
c1 = null;  // Eligible for Garbage Collection
System.gc();  // Suggests GC to run
```

### **Flashcards: Java Strings**  

---

### **🔹 What is a String?**  
✔ **Definition** → A **sequence of characters** used to store text.  
✔ **Created using:**  
   - **String Literal** → Stored in **String Pool**.  
   - **Using `new` keyword** → Stored in **Heap Memory**.  

✅ **Example:**  
```java
String str1 = "Hello";  // String literal (String Pool)
String str2 = new String("Hello");  // Heap memory
```

---

### **🔹 Why is String Immutable?**  

✔ **1. Security** → Prevents modifications in passwords, URLs, etc.  
✔ **2. Thread-Safety** → Multiple threads can safely share a string.  
✔ **3. Memory Efficiency** → Reuses string literals using the **String Intern Pool**.  
✔ **4. Heap Memory** →  
   - **String Pool** → Stores literals (saves memory).  
   - **Heap** → Stores dynamically created strings.  

✅ **Example:**  
```java
String s1 = "Hello";
String s2 = "Hello";  // Both point to the same memory in the String Pool

String s3 = new String("Hello");  // Creates a new object in Heap
```

---

### **🔹 String Pool & Memory Management**  

✔ **String Pool** → Stores string literals to avoid duplication.  
✔ **`intern()` Method** → Moves a string to the pool if not already present.  

✅ **Example:**  
```java
String s1 = new String("Java");
String s2 = s1.intern();  // Moves to String Pool
String s3 = "Java";

System.out.println(s2 == s3);  // true (same reference)
```

### **Flashcards: String Immutability & Comparison**  

---

### **🔹 How is String Immutable?**  

✔ **1. Private Final Fields** → Stores characters in an **unchangeable array**.  
   ```java
   private final char value[];
   ```  
✔ **2. No Setters** → No method to modify the original string.  
✔ **3. Final Class** → Prevents inheritance & modification.  
   ```java
   public final class String { ... }
   ```  
✔ **4. Unmodifiable Methods** → Every method returns a **new string** instead of modifying the existing one.  

✅ **Example:**  
```java
String s = "Hello";
s.concat(" World");  // Creates a new object, doesn't modify 's'
System.out.println(s);  // Output: Hello (unchanged)
```

---

### **🔹 How to Create an Immutable Class (Like String)?**  
✅ **Steps to Implement:**  
1️⃣ Declare the class as `final` (prevents inheritance).  
2️⃣ Make fields `private final` (cannot be modified).  
3️⃣ No setters (prevent modification).  
4️⃣ Use defensive copying for mutable objects.  

✅ **Example:**  
```java
public final class ImmutableString {
    private final String value;
    
    public ImmutableString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
```

---

### **🔹 String vs StringBuffer vs StringBuilder**  

| Type         | Mutability | Thread-Safe | Best For |
|-------------|-----------|------------|----------|
| **String**       | Immutable  | ✅ Yes | Fixed text |
| **StringBuffer** | Mutable    | ✅ Yes | Multi-threaded changes |
| **StringBuilder** | Mutable    | ❌ No | Fast single-threaded operations |

✅ **Example:**  
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);  // Output: Hello World
```

### **Flashcards: Java String Concepts**  

---

### **🔹 Why Use `char[]` for Passwords?**  
✔ **String** → Immutable, stays in memory longer → **Security Risk**.  
✔ **char[]** → Can be manually **cleared after use**, removing sensitive data.  

✅ **Example:**  
```java
char[] password = {'s', 'e', 'c', 'r', 'e', 't'};
Arrays.fill(password, '*'); // Clears password from memory
```

---

### **🔹 `==` vs `.equals()`**  

| **Operator** | **Purpose** | **Checks** |
|-------------|------------|-----------|
| `==`        | Reference equality | Memory address |
| `.equals()` | Logical equality | Content |

✅ **Example:**  
```java
String s1 = new String("Hello");
String s2 = new String("Hello");

System.out.println(s1 == s2);      // false (different objects)
System.out.println(s1.equals(s2)); // true (same content)
```

---

### **🔹 When to Use?**  
✔ **Use `==`** → To check if two references point to the **same object**.  
✔ **Use `.equals()`** → To compare **string content**.  

---

### **🔹 `StringTokenizer`**  
✔ Splits a string into tokens using **delimiters**.  
✔ Efficient for **parsing large strings**.  

✅ **Example:**  
```java
StringTokenizer st = new StringTokenizer("Java,Python,C", ",");
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken()); // Java, Python, C
}
```

---

### **🔹 String Constant Pool**  
✔ **Stores unique string literals** in a **special memory area**.  
✔ Prevents **duplicate objects**, saving memory.  

✅ **Example:**  
```java
String s1 = "Hello"; 
String s2 = "Hello";  // Reuses existing "Hello" from the pool

System.out.println(s1 == s2);  // true (same reference)
```

---

### **🔹 Ways to Create a String**  

1️⃣ **Using String Literal** (Stored in **String Pool**)  
   ```java
   String s = "Hello"; 
   ```
2️⃣ **Using `new` Keyword** (Stored in **Heap**)  
   ```java
   String s = new String("Hello"); 
   ```

### **Flashcards: Class and Objects in Java**  

---

### **🔹 What is a Class?**  
✔ **Blueprint** for creating objects.  
✔ Defines **attributes** (variables) and **behaviors** (methods).  
✔ **Does not occupy memory** until an object is created.  

✅ **Example:**  
```java
class Car {  
    String brand;  
    void drive() {  
        System.out.println("Car is moving");  
    }  
}
```

---

### **🔹 What is an Object?**  
✔ **Real-world entity** that is an **instance of a class**.  
✔ **Occupies memory** and has **state** (data) & **behavior** (methods).  

✅ **Example (Creating an Object):**  
```java
Car myCar = new Car();  // Object creation  
myCar.brand = "Toyota";  
myCar.drive();  
```

---

### **🔹 Why Do We Need Classes and Objects?**  
✔ **Code Organization** → Structured, reusable, and maintainable.  
✔ **Encapsulation** → Hides implementation details.  
✔ **Reusability** → Define once, create multiple objects.  

---

### **🔹 Class vs. Object**  

| **Concept** | **Description** |
|------------|---------------|
| **Class** | A **template** defining attributes & methods |
| **Object** | A **real instance** of a class |

---

### **🔹 Object Creation Methods**  

✔ **Using `new` keyword** → `Car myCar = new Car();`  
✔ **Using `Class.forName()`** → Reflection API  
✔ **Using `clone()`** → Object Cloning  
✔ **Using Deserialization** → Restoring from a serialized state  

---

### **🔹 Instance vs. Static vs. Local Members**  

| **Type**    | **Scope**        | **Memory**      | **Lifecycle** | **Access via** |
|------------|----------------|--------------|------------|--------------|
| **Instance** | Object-level     | **Heap**      | Exists with object | `obj.instanceVar` |
| **Static**   | Class-level      | **Method Area** | Exists for class lifetime | `ClassName.staticVar` |
| **Local**    | Method-level     | **Stack**     | Created & destroyed with method | Direct access |

✅ **Example:**  
```java
class Example {
    int instanceVar = 10;  // Instance variable
    static int staticVar = 20; // Static variable
    
    void show() {
        int localVar = 30; // Local variable
        System.out.println(localVar);
    }
}
```

### **Flashcards: Constructor in Java**  

---

### **🔹 What is a Constructor?**  
✔ A **special method** that initializes objects.  
✔ **Same name as the class** and **no return type**.  
✔ **Runs automatically** when an object is created.  

✅ **Example:**  
```java
class Person {
    String name;
    
    // Constructor
    Person(String name) {
        this.name = name;
    }
}
Person p = new Person("Alice");  // Constructor runs automatically
```

---

### **🔹 Why Do We Need Constructors?**  
✔ **Automatic Initialization** → Objects get initialized automatically.  
✔ **Avoids Uninitialized Objects** → Prevents errors from missing values.  
✔ **Immutable Objects** → Helps initialize final fields.  

✅ **Example Without Constructor (Manual Initialization Required)**  
```java
class Person {
    String name;
    int age;
}
Person p = new Person();
p.name = "Alice";  // Manual setup required
p.age = 25;
```

✅ **Example With Constructor (Automatic Initialization)**  
```java
class Person {
    String name;
    int age;
    
    // Constructor ensures automatic initialization
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
Person p = new Person("Alice", 25);  // No manual setup needed ✅
```

---

### **🔹 Types of Constructors**  

| **Type**         | **Description** |
|----------------|----------------|
| **Default Constructor** | No parameters, initializes default values. |
| **Parameterized Constructor** | Takes arguments to initialize fields with specific values. |
| **Copy Constructor** | Copies values from another object of the same class. |

✅ **Example:**  
```java
class Person {
    String name;
    
    // Default Constructor
    Person() {
        name = "Unknown";
    }

    // Parameterized Constructor
    Person(String name) {
        this.name = name;
    }

    // Copy Constructor
    Person(Person p) {
        this.name = p.name;
    }
}
```

---

### **🔹 Constructor vs. Method**  

| **Feature**       | **Constructor** | **Method** |
|----------------|---------------|---------|
| **Return Type** | No return type | Must have a return type |
| **Execution**   | Runs **automatically** | Called **explicitly** |
| **Purpose**     | Initializes objects | Performs actions |

✅ **Example:**  
```java
class Example {
    Example() {  // Constructor
        System.out.println("Constructor called");
    }
    
    void display() {  // Method
        System.out.println("Method called");
    }
}
```

---

### **🔹 Constructor Overloading**  
✔ Multiple constructors with **different parameters**.  
✔ **No return type** (unlike method overloading).  

✅ **Example:**  
```java
class Car {
    String brand;
    
    // Constructor 1
    Car() {
        brand = "Unknown";
    }
    
    // Constructor 2 (Overloaded)
    Car(String brand) {
        this.brand = brand;
    }
}
```

---

### **🔹 Private Constructor**  
✔ Used in **Singleton Pattern** to restrict instantiation.  

✅ **Example:**  
```java
class Singleton {
    private static Singleton instance;
    
    private Singleton() {}  // Private Constructor
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

### **🔹 Static Block vs. Constructor**  

| **Feature**        | **Static Block** | **Constructor** |
|-------------------|---------------|--------------|
| **Execution**    | Runs **once** when class loads | Runs **each time** an object is created |
| **Usage**        | Initializes **static variables** | Initializes **object variables** |

✅ **Example:**  
```java
class Example {
    static {
        System.out.println("Static Block");  // Runs once
    }
    
    Example() {
        System.out.println("Constructor Called");  // Runs every time
    }
}
```

---

### **🔹 Constructor Chaining**  
✔ **Calling one constructor from another** within the same class.  
✔ **Uses `this()`** to refer to another constructor.  

✅ **Example:**  
```java
class Car {
    String brand;
    
    Car() {
        this("Unknown");  // Calls the parameterized constructor
    }
    
    Car(String brand) {
        this.brand = brand;
    }
}
```

---

### **🔹 `super()` Keyword**  
✔ Calls the **parent class** constructor.  

✅ **Example:**  
```java
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle Constructor");
    }
}

class Car extends Vehicle {
    Car() {
        super();  // Calls Vehicle constructor
        System.out.println("Car Constructor");
    }
}
```

---

### **🔹 Destructor in Java?**  
✔ Java **does not have destructors** like C++.  
✔ **Garbage Collector (GC)** automatically destroys unused objects.  
✔ `finalize()` method can be overridden but **not reliable**.  

✅ **Example:**  
```java
class Example {
    protected void finalize() {
        System.out.println("Object destroyed");
    }
}
```

---

### **🔹 Call by Value vs. Call by Reference**  

| **Type**       | **Effect** |
|--------------|---------|
| **Call by Value** | Passes a copy of the value, original remains unchanged. |
| **Call by Reference** | Passes the reference, original object **can be modified**. |

✅ **Example:**  
```java
class Example {
    void modify(int num) {  // Call by Value
        num = 10;
    }
    
    void modifyArray(int[] arr) {  // Call by Reference
        arr[0] = 10;
    }
}
```

### **Flashcards: `final` Keyword in Java**  

---

### **🔹 What is the `final` Keyword?**  
✔ Declares **constants**  
✔ Prevents **method overriding**  
✔ Restricts **inheritance**  

✅ **Example:**  
```java
final int VAR = 10;  // Constant variable
```

---

### **🔹 `final` Keyword Usage**  

| **Where Used?**  | **Effect** |
|----------------|-------------|
| **Final Variable**  | Value cannot be changed after initialization. |
| **Final Method**  | Cannot be overridden in subclasses. |
| **Final Class**  | Cannot be extended (subclassed). |

---

### **🔹 `final` with Variables**  
✔ Once assigned, the value **cannot be changed**.  

✅ **Example:**  
```java
class Example {
    final int VAR = 10;  // Cannot be changed
}
```

---

### **🔹 `final` with Methods**  
✔ **Prevents method overriding** in subclasses.  

✅ **Example:**  
```java
class Parent {
    final void show() {
        System.out.println("Final method");
    }
}

class Child extends Parent {
    // Cannot override show() method
}
```

---

### **🔹 `final` with Classes**  
✔ **Prevents inheritance** (no subclasses allowed).  

✅ **Example:**  
```java
final class Parent {
}

// class Child extends Parent {}  // ❌ Error: Cannot extend a final class
```

---

### **🔹 Can a `final` class be extended?**  
❌ **No** → The `final` keyword **prevents subclassing**.

### **Flashcards: Java Packages**  

---

### **🔹 What is a Package?**  
✔ A **container** for related classes and interfaces.  
✔ Helps **organize** code and **prevent naming conflicts**.  
✔ Provides **access control** and better **code modularity**.  

✅ **Example:**  
```java
package MyPackage;  // Defines a package
public class MyClass {
    public void display() {
        System.out.println("Inside MyPackage");
    }
}
```

---

### **🔹 Why Use Packages?**  

| **Feature**       | **Benefit** |
|------------------|------------|
| **Namespace**   | Avoids class name conflicts. |
| **Encapsulation**  | Controls access to classes. |
| **Code Organization** | Groups related classes together. |

---

### **🔹 Built-in Java Packages**  

| **Package** | **Usage** |
|------------|----------|
| `java.lang` | Core classes (`String`, `Math`, `Object`) – auto-imported. |
| `java.io` | Input/Output (`File`, `BufferedReader`). |
| `java.util` | Utility classes (`ArrayList`, `HashMap`). |
| `java.applet` | Applet programming (`Applet`, `Graphics`). |
| `java.awt` | GUI components (`Button`, `Frame`). |
| `java.net` | Networking (`Socket`, `URL`). |

---

### **🔹 How Packages Work?**  

1️⃣ **Declaring a Package**  
```java
package mypackage;  // Must be the first line
```

2️⃣ **Importing a Package**  
```java
import mypackage.MyClass;  // Imports a specific class
import java.util.*;  // Imports all classes from java.util
```

3️⃣ **Accessing Class from Another Package**  
```java
package mypackage;
public class MyClass {
    public void show() {
        System.out.println("Hello from MyClass");
    }
}
```
```java
package anotherpackage;
import mypackage.MyClass;  // Importing MyClass

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show();
    }
}
```

---

### **🔹 `classpath` & Package Structure**  
✔ Java searches for packages using:  
1️⃣ **Current Directory**  
2️⃣ **`CLASSPATH` Environment Variable**  
3️⃣ **`-classpath` Command Option**  

✅ **Running Java with Classpath**  
```sh
javac -d . MyClass.java  // Stores compiled class in correct package folder
java mypackage.MyClass   // Runs the class
```

### **Flashcards: Java Garbage Collection**  

---

### **🔹 What is Garbage Collection?**  
✔ **Automatic** process that frees up memory by removing unused objects.  
✔ Prevents **memory leaks** by deleting objects **no longer referenced**.  
✔ Managed by the **JVM**.  

✅ **Example:**  
```java
MyClass obj = new MyClass();  // Object created in heap
obj = null;  // Object now eligible for garbage collection
```

---

### **🔹 Why Use Garbage Collection?**  

| **Feature**         | **Benefit** |
|--------------------|------------|
| **Automatic Memory Management** | No need for manual deallocation. |
| **Prevents Memory Leaks** | Removes unused objects. |
| **Optimizes Performance** | Reclaims unused heap space. |

---

### **🔹 JVM Memory Areas & Object Storage**  

| **Memory**        | **Purpose** |
|------------------|------------|
| **Heap Memory**  | Stores objects, managed by GC. |
| **Stack Memory** | Stores local variables & method calls. |
| **Method Area (Metaspace)** | Stores class metadata. |
| **Young Generation** | For short-lived objects. |
| **Old Generation** | For long-lived objects. |
| **String Pool** | Stores unique string literals. |

✅ **Where are Objects Stored?**  
✔ Objects → **Heap**  
✔ References → **Stack**  

---

### **🔹 How Does Java Perform Garbage Collection?**  

1️⃣ **Mark & Sweep Algorithm:**  
✔ **Mark** → Identifies unreachable objects.  
✔ **Sweep** → Removes them from memory.  

2️⃣ **Generational GC:**  
✔ **Young Generation** → For short-lived objects.  
✔ **Old Generation** → For long-lived objects.  

---

### **🔹 Key Methods & Concepts**  

✔ **`System.gc()`** → Requests GC (not guaranteed).  
✔ **`finalize()`** → Called before an object is GC’d (deprecated).  
✔ **JVM decides when to run GC** (usually when memory is low).  

✅ **Example of GC Request (Not Guaranteed):**  
```java
System.gc();  // Requests garbage collection
```

---

### **🔹 Heap vs. Stack Memory**  

| **Aspect**      | **Heap Memory** | **Stack Memory** |
|---------------|--------------|-------------|
| **Stores** | Objects | Local variables, method calls |
| **Shared?** | Yes, shared by all threads | No, each thread has its own stack |
| **Size** | Larger | Smaller |
| **Managed By** | GC (automatic) | Scope-based (LIFO order) |

✅ **Example:**  
```java
class Test {
    int x = 10;  // Stored in heap
    void method() {
        int y = 5;  // Stored in stack
    }
}
```

---

### **🔹 Important Questions**  

✔ **Q: Where is a new object stored?**  
**A:** In the heap memory.  

✔ **Q: What does `System.gc()` do?**  
**A:** Requests garbage collection, but execution is **not guaranteed**.  

✔ **Q: What happens if an object has no reference?**  
**A:** It becomes **eligible for garbage collection**.  

✔ **Q: Can you force garbage collection?**  
**A:** No, you can only request it using `System.gc()`.  

✔ **Q: What is the purpose of the `finalize()` method?**  
**A:** Used for cleanup before an object is GC’d (deprecated in Java 9+).  

---

Here are flashcards for **Variables, Keywords, and Methods in Java** for quick revision:  

---

### **🔹 Instance Variable (Non-Static)**
**Definition:**  
- Belongs to an object (instance).  
- Each object has its own copy.  
- Stored in **heap memory**.  

**Example:**  
```java
class Example {
    int instanceVar = 10;  // Instance Variable

    public static void main(String[] args) {
        Example obj = new Example();
        System.out.println(obj.instanceVar);  // Output: 10
    }
}
```
📌 **Cannot be accessed directly in a static method!**  

---

### **🔹 Local Variable (Method Level)**
**Definition:**  
- Defined inside a method.  
- Stored in **stack memory**.  
- Cannot have access modifiers.  

**Example:**  
```java
void show() {
    int localVar = 5;  // Local variable
}
```
📌 **Exists only during method execution!**  

---

### **🔹 Static Variable (Class Variable)**
**Definition:**  
- Shared among all instances of a class.  
- Stored in the **method area** of JVM.  

**Example:**  
```java
class Example {
    static int staticVar = 20;

    public static void main(String[] args) {
        System.out.println(Example.staticVar);  // Output: 20
    }
}
```
📌 **Access via `ClassName.staticVar`**  

---

### **🔹 Final Keyword**
**Definition:**  
- Prevents modification.  
- Used for variables, methods, and classes.  

**Example:**  
```java
final int x = 10;  // Cannot be changed
```
📌 **Final methods cannot be overridden. Final classes cannot be extended!**  

---

### **🔹 Nested Class**
**Definition:**  
- A class inside another class.  
- Can be **static** (static nested class) or **non-static** (inner class).  

---

### **🔹 Static Keyword**
**Definition:**  
- Used for memory management.  
- Can be applied to **variables, methods, blocks, and nested classes**.  

---

### **🔹 Static Method**
**Definition:**  
- Belongs to the class, not an instance.  
- Can access **static variables** directly.  
- Cannot call non-static members directly.  

**Example:**  
```java
class Example {
    static void show() {
        System.out.println("Static method");
    }

    public static void main(String[] args) {
        Example.show();  // No object needed!
    }
}
```
📌 **Cannot be overridden but can be hidden by another static method!**  

---

### **🔹 Can Static Methods Be Overloaded?**
✅ **Yes** – Same method name with different parameters.  

**Example:**  
```java
class Example {
    static void show(int a) {}
    static void show(double b) {}  // Overloading
}
```

---

### **🔹 Can We Override Private Variables?**
❌ **No** – Private variables are not inherited!  

---

### **🔹 Blank Final Variable**
**Definition:**  
- Declared as `final` but **not initialized immediately**.  
- Must be assigned in the **constructor**.  

**Example:**  
```java
class Example {
    final int x;  // Blank final variable
    Example() { x = 10; }  // Must be initialized in constructor
}
```

---

### **🔹 Can a Non-Static Variable Be Accessed in a Static Context?**
❌ **No** – Needs an object.  
✅ **But static members can be accessed in a non-static method!**  

**Example:**  
```java
class Example {
    int a = 10;  // Instance variable
    static int b = 20;  // Static variable

    void show() { System.out.println(b); }  // ✅ Allowed
    static void display() { System.out.println(a); }  // ❌ Error!
}
```

---

### **🔹 How to Access Variables Outside `main()`?**
**Instance Variables:**  
```java
Example obj = new Example();
System.out.println(obj.instanceVar);
```
**Static Variables:**  
```java
System.out.println(Example.staticVar);
```
📌 **Use ClassName.staticVar for static, and obj.instanceVar for non-static!**  

---

### **🔹 Can Static Variables Be Serialized?**
❌ **No** – They belong to the **class**, not the instance.  

---

### **🔹 Static Initializer Block**
**Definition:**  
- Executes **once** when the class is loaded.  
- Used to initialize **static variables**.  

**Example:**  
```java
class Example {
    static { System.out.println("Static block executed!"); }
}
```

---

### **🔹 Where Do Static Blocks Get Stored?**
📌 **Method Area (Class Metadata in JVM).**  

---

### **🔹 Static vs Non-Static Methods**
| Feature | Static Method | Non-Static Method |
|---------|--------------|-------------------|
| Belongs To | Class | Object |
| Access | Called without an object | Needs an object |
| Can Access | Only static variables/methods | Both static & instance variables |
| Overriding | ❌ Cannot be overridden (can be hidden) | ✅ Can be overridden |

---

Here are flashcards for **Encapsulation and Abstraction** in Java:

---

### **🔹 Encapsulation**
**Definition:**  
- Wrapping **data (variables)** and **methods** into a single unit (class).  
- **Hides** data from direct access using `private` fields.  

**Key Points:**  
✅ **Blueprint analogy** – A complete overview of a task.  
✅ **Data hiding** – Private fields prevent direct modification.  
✅ **Controlled access** – Use **getters and setters** to modify data.  

**Example:**  
```java
class BankAccount {
    private double balance;  // Hidden from direct access

    public double getBalance() {  // Getter
        return balance;
    }

    public void setBalance(double balance) {  // Setter
        if (balance >= 0) this.balance = balance;
    }
}
```
📌 **Encapsulation protects integrity by restricting direct modification.**

---

### **🔹 Abstraction**
**Definition:**  
- **Hides implementation details**, showing only relevant functionality.  
- Achieved using **abstract classes** and **interfaces**.  

**Key Points:**  
✅ **What vs How** – Focuses on **what** an object does, not **how** it does it.  
✅ **Abstraction vs Encapsulation** –  
   - **Encapsulation** hides **data** (control access).  
   - **Abstraction** hides **logic** (simplifies usage).  

**Example Using Abstract Class:**  
```java
abstract class Vehicle {
    abstract void start();  // Abstract method (no implementation)
}

class Car extends Vehicle {
    void start() {  // Concrete implementation
        System.out.println("Car starts with a key.");
    }
}
```

**Example Using Interface:**  
```java
interface Payment {
    void pay();  // Abstract method
}

class CreditCard implements Payment {
    public void pay() { 
        System.out.println("Paying via Credit Card.");
    }
}
```
📌 **Abstraction ensures only essential details are exposed!**  

---

Here are **flashcards** for **Inheritance in Java** 🚀:

---

### **🔹 Inheritance**
**Definition:**  
- A mechanism where a **child class** acquires the properties & behavior of a **parent class**.

**Key Points:**  
✅ **Reusability** – Avoids code duplication.  
✅ **Method Overriding** – Child class can redefine parent methods.  
✅ **"IS-A" Relationship** – A subclass is a specialized version of a superclass.  

---

### **🔹 How Inheritance Works**
✅ **`extends` keyword** – To inherit from a class.  
✅ **Access Specifiers**:  
   - ✅ `public` & `protected` → **accessible in child class**  
   - ❌ `private` → **not inherited**  
✅ **`super()` keyword** – Calls **parent class constructor** or methods.  

📌 **Example:**
```java
class Animal {
    void eat() { System.out.println("Animal is eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat(); // Inherited from Animal
        d.bark();
    }
}
```
📝 **Output:**  
```
Animal is eating  
Dog barks  
```

---

### **🔹 Types of Inheritance**
1️⃣ **Single Inheritance** – One child, one parent.  
```java
class A {}  
class B extends A {}
```
✅ **Common use case:** Method reuse.

2️⃣ **Multiple Inheritance (via Interface)** – A class implements multiple interfaces.  
```java
interface A {}  
interface B {}  
class C implements A, B {}
```
✅ **Avoids Diamond Problem** in Java.

3️⃣ **Hierarchical Inheritance** – Multiple child classes from the same parent.  
```java
class A {}  
class B extends A {}  
class C extends A {}
```
✅ **Common use case:** Same behavior shared among child classes.

4️⃣ **Hybrid Inheritance** – Combination of different inheritance types, achieved via interfaces.  
```java
interface A {}  
class B {}  
class C extends B implements A {}
```
✅ **Combines class & interface inheritance.

---

### **🔹 Why Multiple Inheritance is Not Supported in Java?**
❌ **Diamond Problem**:  
If two parent classes have a method with the same name, ambiguity arises.  

✅ **Solution:** Use **interfaces** instead.  
```java
interface A { void show(); }  
interface B { void show(); }  

class C implements A, B {
    public void show() { System.out.println("Resolved ambiguity!"); }
}
```

---

### **🔹 Can Parent Class Access Child’s Data?**
❌ **No**, because inheritance is **one-way (top-down)** from parent to child.

---

Here are **flashcards** for **Polymorphism & Related OOP Concepts** 🚀:  

---

### **🔹 Polymorphism**
**Definition:**  
- A single interface representing multiple behaviors (e.g., **smartphones** performing different actions).  

**Types:**  
✅ **Compile-time Polymorphism (Method Overloading)**  
✅ **Runtime Polymorphism (Method Overriding)**  

---

### **🔹 Method Overloading (Compile-time Polymorphism)**
📌 **Definition:**  
- Defining multiple methods with the same name but **different parameters** (number, type, or order).  

📌 **Example:**
```java
class MathUtil {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

public class Main {
    public static void main(String[] args) {
        MathUtil m = new MathUtil();
        System.out.println(m.add(5, 3));       // Calls int version
        System.out.println(m.add(5.5, 2.2));   // Calls double version
    }
}
```
📝 **Output:**  
```
8  
7.7  
```

---

### **🔹 Method Overriding (Runtime Polymorphism)**
📌 **Definition:**  
- A **subclass provides a specific implementation** of a method that is already defined in the **superclass**.  

📌 **Example:**
```java
class Animal {
    void makeSound() { System.out.println("Animal makes sound"); }
}

class Dog extends Animal {
    void makeSound() { System.out.println("Dog barks"); }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); // Reference of superclass, object of subclass
        a.makeSound();  // Calls Dog's overridden method
    }
}
```
📝 **Output:**  
```
Dog barks  
```

✅ **Key Rule:** Method signature (name + parameters) **must match exactly**.  
✅ **Achieves:** **Runtime polymorphism** (decided at runtime).  

---

### **🔹 Dynamic Method Dispatch (Runtime Polymorphism)**
📌 **Definition:**  
- A superclass reference variable can refer to a subclass object, allowing method calls to be resolved at **runtime**.  

✅ **Example:** `Animal a = new Dog();`  

---

### **🔹 Virtual Function**
📌 **Definition:**  
- A **method in the base class marked as "virtual"** (in languages like C++) to allow dynamic polymorphism via **runtime method binding**.  
- In Java, **all non-static methods are virtual functions by default**.  

---

### **🔹 Why Does Java Not Support Operator Overloading?**
📌 **Definition:**  
- Operator Overloading: Using operators like `+`, `-`, `*` with **user-defined** types.  
❌ **Not supported in Java** to **keep the language simple and avoid confusion**.  

---

### **🔹 Composition ("HAS-A" Relationship)**
📌 **Definition:**  
- One class **owns** another class, forming a **strong** relationship.  
✅ **Example:** A **Car has an Engine**.  

📌 **Example:**
```java
class Engine {
    void start() { System.out.println("Engine started"); }
}

class Car {
    Engine engine = new Engine();
    
    void startCar() {
        engine.start(); // Delegating behavior to Engine
    }
}
```
✅ **If Car is destroyed, Engine is also destroyed.**  

---

### **🔹 Association ("USES-A" Relationship)**
📌 **Definition:**  
- **A relationship between two objects** where one **uses** the other **without ownership**.  

✅ **Example:** A **student is associated with a teacher** but does not own them.  
✅ **Types:**  
1️⃣ **One-to-One**  
2️⃣ **One-to-Many**  
3️⃣ **Many-to-Many**  

---

### **🔹 Aggregation (Weak "Whole-Part" Relationship)**
📌 **Definition:**  
- A **weaker** version of composition where objects **can exist independently**.  

✅ **Example:**  
- A **University has Departments**, but a **Department can exist without the University**.  

📌 **Example:**
```java
class Department {
    String name;
    Department(String name) { this.name = name; }
}

class University {
    Department dept;  // Has-a relationship (Aggregation)
    
    University(Department dept) {
        this.dept = dept;
    }
}
```

---

### **🔹 Constructor Overloading**
📌 **Definition:**  
- Defining multiple constructors **with different parameters**.  
✅ **Used for object initialization in different ways**.  

📌 **Example:**
```java
class Person {
    String name;
    int age;
    
    Person(String name) { this.name = name; }
    Person(String name, int age) { this.name = name; this.age = age; }
}
```

---

Here are **flashcards** for **Abstract Classes in Java** 🚀:  

---

### **🔹 Abstract Class**
📌 **Definition:**  
- A class that **cannot be instantiated** and is meant to be extended by subclasses.  
- Can have **abstract methods (without implementation)** and **concrete methods (with implementation).**  

---

### **🔹 Key Points About Abstract Classes**
✅ **Can Have:**  
✔ Abstract methods (**without** body)  
✔ Concrete methods (**with** body)  
✔ Constructors  
✔ Private methods  
✔ Final methods  

❌ **Cannot:**  
❌ Be instantiated (`new AbstractClass()` is not allowed)  
❌ Be marked **final** (`final abstract class A {}` gives compilation error)  

---

### **🔹 Can an Abstract Class Have a Constructor?**
✅ **Yes!**  
- Used to **initialize common properties** for subclasses.  

📌 **Example:**
```java
abstract class Animal {
    String name;
    
    Animal(String name) {  // Constructor in abstract class
        this.name = name;
    }
}

class Dog extends Animal {
    Dog(String name) { super(name); }
}
```

---

### **🔹 Can We Use `final` in an Abstract Class?**
❌ **No, an abstract class cannot be final**  
❌ **`final abstract class A {}` → Compilation error**  
📌 **Reason:**  
- **`final` prevents extension**, but **`abstract` requires extension**.  

✅ **However, a final method inside an abstract class is allowed**:  
```java
abstract class A {
    final void display() {
        System.out.println("Final method in abstract class");
    }
}
```

---

Here are **flashcards** for **Interfaces in Java** 🚀:  

---

### **🔹 Interface**
📌 **Definition:**  
- Defines a **contract** (what a class must do) **without implementation** (how it’s done).  
- **Cannot be instantiated.**  
- **All variables are `public static final` by default.**  
- **Methods are `public abstract` by default (before Java 8).**  

✅ **Example:**
```java
interface Animal {
    void makeSound(); // Abstract method (no implementation)
}

class Dog implements Animal {
    public void makeSound() {  // Must provide implementation
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();  // Output: Dog barks
    }
}
```

---

### **🔹 Key Points About Interfaces**
✅ **Can Have:**  
✔ **Abstract methods** (must be implemented by the class)  
✔ **Static methods** (introduced in Java 8)  
✔ **Default methods** (introduced in Java 8)  
✔ **Nested types**  

❌ **Cannot:**  
❌ Be instantiated  
❌ Have constructors  
❌ Contain instance variables (only constants)  

✅ **All variables are `public static final` by default**  
```java
interface Test {
    int VALUE = 100;  // Equivalent to: public static final int VALUE = 100;
}
public class Main {
    public static void main(String[] args) {
        System.out.println(Test.VALUE);  // Output: 100
        // Test.VALUE = 200;  // ❌ Error: Cannot modify final variable
    }
}
```

---

### **🔹 Why Use Interfaces?**
✅ **Multiple Inheritance** (Java does not support multiple class inheritance, but it supports multiple interface implementation).  
✅ **Abstraction** (Hides implementation details).  
✅ **Loose Coupling** (Flexible design, reducing dependency between components).  

---

### **🔹 Types of Methods in Interfaces**
| Type          | Introduced in | Description |
|--------------|-------------|-------------|
| **Abstract Method** | Java 7  | Methods without body (must be implemented). |
| **Static Method** | Java 8 | Can have a body, but cannot be overridden. |
| **Default Method** | Java 8 | Has a default implementation, can be overridden. |

✅ **Default & Static Methods in Interfaces (Java 8+)**
```java
interface MyInterface {
    default void show() {   // Default method
        System.out.println("Default method in interface");
    }
    static void staticMethod() {  // Static method
        System.out.println("Static method in interface");
    }
}
public class Demo implements MyInterface {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show();  // Output: Default method in interface
        MyInterface.staticMethod();  // Output: Static method in interface
    }
}
```

---

### **🔹 Functional Interface**
📌 **Definition:**  
- An interface with only **one abstract method** but can have **default or static methods.**  
- Used for **Lambda Expressions**.  

✅ **Example:**
```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);  // Single abstract method
}
public class Main {
    public static void main(String[] args) {
        Calculator sum = (a, b) -> a + b; // Lambda expression
        System.out.println(sum.add(5, 10)); // Output: 15
    }
}
```

---

### **🔹 Marker Interface**
📌 **Definition:**  
- **An interface without methods.**  
- Used to indicate a class has special properties.  

✅ **Example:**  
Java's **Serializable, Cloneable** are marker interfaces.  
```java
class Student implements Serializable { }  // Marks class as serializable
```

---

### **Flashcard: Serializable vs Cloneable + Shallow vs Deep Copy**  

#### **🟢 Serializable (Used for Object Persistence)**  
✔ **Allows an object to be serialized** (converted into a byte stream).  
✔ **Used for** saving an object's state to a file, sending over a network, or storing in a database.  
✔ **Marker interface** (no methods, just a signal to JVM).  
✔ **Non-static & non-transient fields** are serialized.  
✔ **Use `transient`** to skip fields during serialization.  
✅ **Example:**  
```java
class Data implements Serializable {
    private static final long serialVersionUID = 1L;  
    int id;
    transient String password; // Won't be serialized
}
```

---  

#### **🟡 Cloneable (Used for Object Duplication)**  
✔ **Marker interface** (no methods).  
✔ **Enables object cloning using `clone()`** from `Object` class.  
✔ **Must override `clone()`**, otherwise `CloneNotSupportedException` occurs.  
✔ **By default, performs a shallow copy**.  
✔ **For deep copy**, override `clone()` & manually copy mutable fields.  
✅ **Example:**  
```java
class CopyExample implements Cloneable {
    int id;
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow Copy
    }
}
```

---

### **Shallow Copy vs Deep Copy**  

#### **🔹 Shallow Copy**  
✔ **Copies references** of inner objects (not new instances).  
✔ **Top-level object is duplicated, but inner objects are shared.**  
✔ **Changes in one affect the other.**  
✅ **Example:**  
```java
class Shallow implements Cloneable {
    int[] arr = {1, 2, 3}; 
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Reference of `arr` is copied
    }
}
```

#### **🔹 Deep Copy**  
✔ **Creates new instances** of inner objects.  
✔ **Completely independent copy**—modifying one does not affect the other.  
✅ **Example:**  
```java
class Deep implements Cloneable {
    int[] arr = {1, 2, 3}; 
    public Object clone() throws CloneNotSupportedException {
        Deep copy = (Deep) super.clone();
        copy.arr = arr.clone(); // New instance of `arr`
        return copy;
    }
}
```

📌 **Key Differences:**  
✔ **Serializable** → Used for persistence (saving/transferring objects).  
✔ **Cloneable** → Used for object duplication (`clone()`).  
✔ **Shallow Copy** → Shared inner objects (change affects both).  
✔ **Deep Copy** → New inner objects (each copy is independent). 🚀