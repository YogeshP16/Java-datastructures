##  **Java Class & Object**

### **What is a Class?**
- **Definition**: A class is a blueprint or template for creating objects.
- **Why It’s Used**: Defines what an object will look like and what it can do. It promotes code reusability and organization.
- **What It Does**: A class defines **properties** (fields) and **methods** (behaviors).

#### **How It Works?**
1. **Fields (Properties)**: Variables that define the state of the object (e.g., `color`, `speed`).
2. **Methods (Behaviors)**: Functions that define what actions the object can perform (e.g., `startEngine()`, `accelerate()`).

#### **Example**:
```java
class Car {
    String color;
    int speed;
    
    void startEngine() {
        System.out.println("Engine started!");
    }

    void accelerate() {
        System.out.println("Car is speeding up!");
    }
}
```

### **What is an Object?**
- **Definition**: An object is a specific instance of a class, containing data (fields) and behavior (methods).
- **Why It's Used**: Models real-world entities, enabling reusability and modularity.
- **What It Does**: Encapsulates data and methods specific to that instance.

#### **How to Create Objects?**
1. **Using `new` Keyword**:
   ```java
   Car myCar = new Car();  // Creates an object of Car class
   ```

2. **Using Factory Methods**:
   ```java
   List<String> list = new ArrayList<>();  // Uses a factory method to create a List object
   ```

#### **Class vs Object**
| **Class**                              | **Object**                           |
|----------------------------------------|---------------------------------------|
| A blueprint for objects.               | A specific instance of a class.      |
| Defines structure and behavior.        | Holds actual data and performs actions. |
| Example: `Car` class.                  | Example: `Car myCar = new Car();`    |

#### **Properties of an Object**
1. **State**: Data stored in fields (e.g., color of the car).
2. **Behavior**: Methods define actions (e.g., `drive()` for a car).
3. **Identity**: Each object has a unique reference in memory.

#### **Accessing Instance Variables**
- Use the dot (`.`) operator to access or modify fields:
   ```java
   Car myCar = new Car();
   myCar.color = "Red";  // Access instance variable
   ```

#### **Dynamic Memory Allocation**
- Objects are stored in the **heap memory** during runtime.
- **Why Important?**: Memory is dynamically allocated and freed as needed.
   ```java
   Car myCar = new Car();  // Object stored in heap, reference in stack
   ```

#### **Manipulating Objects**
1. **Modify Fields**:
   ```java
   myCar.color = "Blue";  // Change the state of the object
   ```
2. **Call Methods**:
   ```java
   myCar.drive();  // Call method to perform an action
   ```
3. **Object References**: Assign references between objects.
   ```java
   Car anotherCar = myCar;  // Share data between objects
   ```

--- 

###  **Java Constructor**

#### **What is a Constructor?**
- A special method used to initialize objects during creation. 
- Same name as class name and has no return type.
- **Private Constructor**: Used for singleton patterns or restricting object creation from other classes.
- **Parameterized Constructor**: Constructor with arguments to initialize objects with custom values.


#### **How it Works?**
1. **Default Constructor**:  
   - If no constructor is defined, Java provides a default constructor.
   - default constructor String -> null, primitive -> 0;
   ```java
   public class Example {
       Example() { 
           System.out.println("Default Constructor Called");
       }
   }
   Example obj = new Example();
   ```
2. **Manual Constructor**:  
   - Define constructors with arguments for specific initialization.
   ```java
   public class Example {
       int value;
       Example(int v) { 
           value = v;
       }
   }
   Example obj = new Example(10);
   ```
3. **Using `this` Keyword**:  
   - Refers to the current object and instance variables. 
   - Resolves conflicts between parameters and fields.
   ```java
   public Example(int value) {
       this.value = value; 
   }
   ```

#### **Constructor Overloading**
- Constructor Overloading means having multiple constructors in a class with different parameter lists.
   ```java
   public class Example {
       Example() { }
       Example(int value) { }
       Example(String name, int value) { }
   }
   ```

#### **Calling a Constructor from Another Constructor**
- Use `this()` to call another constructor in the same class. known as constructor chaining.
   ```java
   public class Example {
       Example() { 
           this(10); 
       }
       Example(int value) { 
           System.out.println("Value: " + value);
       }
   }
   ```

#### **Why Default Constructor**
1. **Automatic Object Creation**: If no constructor is defined, Java provides one automatically.
2. **Initialization**: Sets default values (e.g., `null`, `0`, `false`) for instance variables.

#### **Why Not Use `new` Keyword for Primitives?**
- Primitives (`int`, `float`, etc.) are not objects and are stored directly in memory. Using `new` is inefficient for them.

#### **Memory Allocation of `new` Keyword**
- Objects created with `new` are allocated in the **heap**.
- Primitives are stored in the **stack** or within objects/arrays.

###  **Wrapper Classes, `final` Keyword, Garbage Collection, and `finalize` Keyword in Java**

---

#### **Wrapper Classes in Java**
- **What**: Converts primitive types into objects.  
- **Why**: Needed for collections (e.g., `ArrayList`) and object-based APIs.  
- **Examples**:  
  - `int` → `Integer`  
  - `char` → `Character`  
  - `boolean` → `Boolean`  
  - `double` → `Double`  
- **Utility**: Provides methods for conversion and manipulation (e.g., converting strings to numbers).

---

#### **`final` Keyword in Java**
- **What**: Prevents modification of variables, methods, and classes.  
- **Why**: Ensures immutability and restricts inheritance or method overriding.  
- **How**:  
  - **Variables**: Value cannot be changed once initialized.  
  - **Methods**: Cannot be overridden.  
  - **Classes**: Cannot be subclassed.

---

#### **Garbage Collection in Java**
- **What**: JVM automatically deletes unused objects to free memory.  
- **Why**: Prevents memory leaks and manages memory efficiently.  
- **How**:  
  1. **Mark Phase**: Identifies reachable objects.  
  2. **Sweep Phase**: Removes unreachable objects.  
  3. **Generational Collection**: Targets young objects for collection first for efficiency.  
- **JVM** handles GC automatically, but settings can be tuned.

---

#### **`finalize` Keyword in Java**
- **What**: Used for cleanup before garbage collection.  
- **Why**: Releases non-Java resources (e.g., file streams, network connections).  
- **How**:  
  - The `finalize` method is called before the object is discarded by the GC.  
  - It can be overridden to release resources, but its use is discouraged in favor of `try-with-resources` or explicit resource management (e.g., `close()`).

--- 

###  **Java Packages**  

#### **Definition**  
- **Package**: A container that organizes classes, preventing naming conflicts and controlling visibility.

#### **Key Points**  
1. **Namespace**: Prevents class name collisions (e.g., `List` in different packages).
2. **Visibility**: Only **public** classes/members are accessible outside the package.
3. **Hierarchy**: Package structure mirrors directory structure (e.g., `java.awt.image` → `java/awt/image`).

#### **How It Works**  
1. **Defining a Package**:  
   ```java
   package MyPackage;
   ```
2. **Folder Structure**: Class files are stored in corresponding directories (e.g., `MyPackage`).
3. **Importing Packages**:  
   ```java
   import MyPackage.MyClass;
   ```

4. **Classpath**:  
   - Found via the current directory or **CLASSPATH** variable.
   - Use `-classpath` option for `javac` or `java`.

#### **Example**  
```java
// File: MyClass.java inside MyPackage
package MyPackage;
public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}
```
```java
// File: Main.java
import MyPackage.MyClass;
public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.display();
    }
}
```

#### **In-built Java Packages**  
1. **`lang`**: Essential classes, default package, we dont need to import (`String`, `Object`, `Math`, etc.)  
2. **`io`**: For file I/O and data streams (`File`, `BufferedReader`)  
3. **`util`**: For collections and utilities (`ArrayList`, `HashMap`)  
4. **`applet`**: For applet development (`Applet`, `AudioClip`)  
5. **`awt`**: For GUI development (`Frame`, `Button`)  
6. **`net`**: For network communication (`Socket`, `ServerSocket`)

---

###  **Static in Java**

#### **What is it?**
- **Static**: A keyword used to define class-level members (variables, methods, blocks). These belong to the class, not instances. No need to create an object to access them.

---

### **Static Variables**
- Class-level variable → Common value shared by all objects.
- Initialized once; same value across instances.
- **Access**: Via class name or instance.
- **Overriding**: Cannot be overridden but can be hidden in subclasses.

### **Instance vs static**
- **Insance**: Object-level variable → Separate value for each object. Tied to an object.
- **Static**: Class-level variable → Common value shared by all objects. Tied to the class.
- **How it Works**: Instance members require objects; static members are accessed via class name.

---

### **Static Methods**
- Can be called without creating an instance of the class. Class-level operations not dependent on instance data.
- Can access only static variables/methods.
- **Access**: Via class name.
- **Overriding**: Cannot be overridden; can be hidden in subclasses.

---

### **Static Block**
- Used to initialize static variables when the class is loaded.
- Runs once when the class is loaded, initializing static variables.

---

### **Why `psvm` is Static?**
- **Reason**: JVM calls the `main` method before any objects are created, so it must be static.
- **How it Works**: Static allows the JVM to invoke it directly.

---

### **Non-static Member in Static Method**
- **Reason**: Static methods can't directly access non-static members.
- **How it Works**: Create an object to access non-static members.

---

### **Static Member in Non-static Method**
- **Reason**: Static members belong to the class and can be accessed directly in non-static methods.

---

### **`this` Inside Static Methods**
- **Reason**: Static methods don't belong to an instance, so `this` can't be used.

---

### **Inner Classes**
- **Reason**: Group classes logically; improve encapsulation.
- **How it Works**:
  - **Non-static inner classes**: Access both static and non-static members of the outer class.
  - **Static nested classes**: Access only static members.

---

### **Singleton Pattern**
- **What is it?**: Ensures a class has only one instance and provides a global point of access.
- **Why Use?**: Controls access to shared resources, ensures consistent behavior, reduces memory usage.
- **How It Works?**
    - **Private Constructor**: To prevent the class from creating multiple instances
    - **Static Instance**: A static instance variable holds the single object, and it’s initialized when required.
    - **Public Method**: A public static method (usually named getInstance()) is used to access the instance. 
                        It checks whether the instance already exists or not. If not, it creates one.

###  **Inheritance in Java**

#### **What is it?**
- **Inheritance**: A mechanism where a subclass acquires properties and behavior (fields and methods) of a parent class.

#### **Why is it Used?**
- **Code Reusability**: Avoids code duplication by using existing functionality.
- **Extensibility**: Extends functionality without rewriting code.
- **Polymorphism**: Enables method overriding for runtime flexibility.

#### **What Does It Do?**
- **IS-A relationship**: Child class inherits fields and methods of the parent class.
- Can **override** parent methods.

#### **How It Works?**
- **Syntax**: `class Child extends Parent`
- Access **public** and **protected** members of the parent.
- **Private** members of the parent are **not inherited**.

---

### **Keywords in Inheritance**

1. **`private` Keyword**: 
   - Restricts access to class members and prevents inheritance of private fields/methods.
  
2. **`super` Keyword**:
   - Refers to the parent class. 
   - Used to call parent class methods or constructors: `super()`.

---

### **Types of Inheritance**

1. **Single Inheritance**: One child inherits from one parent.
   ```java
   class A {}
   class B extends A {}
   ```

2. **Multiple Inheritance (Not supported with classes)**: A child inherits from multiple parents using **interfaces** only.

3. **Hierarchical Inheritance**: Multiple child classes inherit from the same parent.
   ```java
   class A {}
   class B extends A {}
   class C extends A {}
   ```

4. **Hybrid Inheritance**: A combination of different inheritance types (avoided directly in Java, achievable with interfaces).

---

### **Can We Access Child Class Data from the Base Class?**

- **Short Answer**: No, a **parent class** cannot directly access **child class** data or methods.
  
- **Why Not?**: 
   - Java's inheritance works **downward** from parent to child.
   - The parent class only knows its own fields and methods; it does not have access to child-specific properties.

- **How It Works**: The child class can add its own fields and methods, but the parent cannot reference or access them.

- **Example**:  
```java
class Parent {
    void display() {
        System.out.println("Parent class.");
    }
}

class Child extends Parent {
    int childData = 10;

    void show() {
        System.out.println("Child data: " + childData);
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.display();  // Works
        // p.childData; // Compilation error: childData is inaccessible
        // p.show();    // Compilation error: show() is not known to Parent
    }
}
```

---

### **Why Multiple Inheritance Is Not Supported in Java**

#### **What is Multiple Inheritance?**
- A scenario where a class inherits from more than one parent class.

#### **Why Not in Java?**
1. **Diamond Problem**: Ambiguity arises when two parent classes have the same method signature, causing confusion for the compiler on which method to inherit.
2. **Alternative Solutions**:
   - **Interfaces** provide multiple inheritance of **types** without method conflict.

#### **Using Interfaces for Multiple Inheritance**:
- Interfaces do not have method implementations (pre-Java 8), so there's no conflict. Child classes implement the interfaces and provide their own method implementations.
  
**Example**:
```java
interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {
    @Override
    public void show() {
        System.out.println("Show from A");
    }

    @Override
    public void display() {
        System.out.println("Display from B");
    }
}
```

#### **Why Not Just Use Classes?**
- Inheriting from multiple classes could cause **ambiguous behavior** (e.g., diamond problem).
- **Interfaces** define behavior without inheriting state, which provides a cleaner, more modular design.

---

### **Polymorphism **

- **Definition**: "Many forms" — allows objects to take different forms depending on context.
---

### Types of Polymorphism:

1. **Compile-time Polymorphism (Static Polymorphism)**:
   - **Occurs**: At compile-time.
   - **Example**: Method Overloading (same method name, different parameters).
   - **Code**:
     ```java
     void draw(int x) { }
     void draw(double x) { }
     ```

2. **Runtime Polymorphism (Dynamic Polymorphism)**:
   - **Occurs**: At runtime.
   - **Example**: Method Overriding (subclass overrides superclass method).
   - **Code**:
     ```java
     class Shape { void draw() { } }
     class Circle extends Shape { void draw() { } }
     Shape s = new Circle(); s.draw();  // "Drawing Circle"
     ```

---

### Key Concepts:

- **Overloading (Static)**: Same method name, different parameter types.
- **Overriding (Dynamic)**: Subclass provides own method implementation.

### Dynamic Method Dispatch:
- **What**: JVM calls method based on actual object type (not reference type).
- **Example**: At runtime, Java calls overridden method of `Circle`, even if reference is `Shape`.

---

### Additional Notes:

- **final Keyword**:
  - **Method**: Cannot be overridden.
  - **Class**: Cannot be subclassed.
  - **Variable**: Cannot be reassigned.

- **Static Methods**: Cannot be overridden (can be hidden).

---

### **Encapsulation vs Abstraction Flashcard**

#### **Encapsulation**
- **What**: Bundles data (variables) and methods (functions) into a class.
- **Why**: Protects data and restricts access to it.
- **How**: Uses **private** fields and **public** getter/setter methods to control access.

#### **Abstraction**
- **What**: Hides implementation details and exposes only essential features.
- **Why**: Simplifies interaction and hides complexity.
- **How**: Achieved using **abstract classes** or **interfaces** to define contracts without implementations.

#### **Key Differences**:
- **Encapsulation**: Focuses on **how data is hidden** (internal state control).
- **Abstraction**: Focuses on **what details are hidden** (simplified interface).

#### **Example**:
- **Encapsulation** (Data hiding with getter/setter):
  ```java
  class Car {
      private int speed;
      
      public int getSpeed() {
          return speed;
      }
      
      public void setSpeed(int speed) {
          this.speed = speed;
      }
  }
  ```
- **Abstraction** (Using interface to define behavior):
  ```java
  interface Vehicle {
      void start();
  }
  
  class Car implements Vehicle {
      public void start() {
          System.out.println("Car started");
      }
  }
  ```

#### **Data Hiding**
- **What**: Hides internal data via `private` access.
- **Why**: Protects data integrity and prevents unauthorized changes.
- **How**: Achieved through access modifiers, limiting external access to fields.

#### **Data Hiding vs Encapsulation**
- **Data Hiding**: Hides data (uses `private` modifiers).
- **Encapsulation**: Combines data and methods, uses data hiding for protection.

---

###  **Access Control in Java**

---

**What it is**:  
Access control in Java defines how class members (fields, methods) are accessed from other classes.

---

**Why it's used**:  
To enforce encapsulation, security, and proper design by restricting or allowing access to class members.

---

**Access Modifiers & Visibility**:

| Modifier     | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | World |
|--------------|-------|---------|---------------------|---------------------|-------|
| **public**   |   +   |    +    |          +          |          +          |   +   |
| **protected**|   +   |    +    |          +          |          +          |       |
| **default**  |   +   |    +    |          +          |                     |       |
| **private**  |   +   |         |                     |                     |       |

- **public**: Accessible everywhere.
- **protected**: Accessible in same package & subclasses.
- **default**: Accessible in same package.
- **private**: Accessible only within the same class.

---

**Key Example**:  
```java
package packageOne;
public class Base {
    protected void display() {
        System.out.println("in Base");
    }
}

package packageTwo;
public class Derived extends packageOne.Base {
    public void show() {
        new Base().display();  // not working
        new Derived().display(); // works
        display();              // works
    }
}
```

- `Base().display()` → Not allowed (different package, `protected`).
- `Derived().display()` → Allowed (same package subclass).
- `display()` → Allowed (same class).

---

**Key Points**:

- **`protected`**: Accessible by subclasses, even across packages.
- **Access is allowed through subclass instances**, not superclass instances.
- **Not accessible via superclass reference**, unless it points to a subclass object.

---

**Simplified Rule**:  
- **`protected`** members can be accessed from subclasses or within the same package, but not from other classes in different packages unless it's via a subclass.

---

### **Abstract Classes in Java**

**1. What is an Abstract Class?**
- Blueprint tells what class to do via abstract method but not how (in subclass we implement abastract method part)
- Cannot be instantiated directly.
- Declared with `abstract` keyword.
- can have constructor called by using super keyword, can have final and static methods
- Can contain both **abstract methods** (no implementation) and **concrete methods** (with implementation).

**2. Multiple Inheritance Issue:**
- Java avoids **multiple inheritance** in classes to prevent **Diamond Problem** (method ambiguity).

**3. Abstract Class Rules:**
- A subclass **must** implement all abstract methods or be declared abstract itself.

**4. Example:**
```java
abstract class Shape {
    abstract void draw(); 
    void display() { System.out.println("This is a shape"); }
}

class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}
```

**5. Constructor in Abstract Classes:**
- **No abstract constructors**.
- Can define constructors for initialization, called by subclasses using `super`.

**6. Object Creation:**
- Cannot instantiate an **abstract class**.
- Can create objects of **concrete subclasses**.

**7. Abstract Static Methods:**
- Not allowed (conflict with static method behavior).

**8. Static Methods in Abstract Classes:**
- Allowed and behave like normal static methods (not overridden).

**9. `final` Keyword:**
- **Cannot** be used with abstract classes (prevents inheritance).

**11. Key Concept:**
- **Abstract class = Leader:** Defines tasks (abstract methods) but doesn't implement them.
- **Subclass = Employee:** Implements tasks (abstract methods).
- **You cannot instantiate abstract class**; only create objects of concrete subclasses.

**12. Example:**
```java
abstract class Leader {
    abstract void assignTask();
    void greet() { System.out.println("Welcome to the team!"); }
}

class Employee extends Leader {
    void assignTask() { System.out.println("Completing the task!"); }
}
```

---

### ** Interfaces in Java**

---

#### **What are Interfaces?**
- A contract defining what a class must do, but not how it’s done.  
- Methods are **public** and **abstract** by default. Variables are **static**, **final**, and **public**.
- cannot be instantiated, class can have n no of interface
- contains method without body
- we use **Implements** keyword
- in java 8 we have default method 

---

#### **Why Use Interfaces?**
- Achieve **multiple inheritance** and **abstraction**.  
- Allow unrelated classes to share common behavior.  
- Promote **loose coupling**.

---

#### **Key Features:**
1. **Default Methods** (Java 8+):  
   - Can have methods with implementations, maintaining backward compatibility.  
   ```java
   default void show() { System.out.println("Default Method"); }
   ```

2. **Static Methods** (Java 8+):  
   - Belong to the interface, not inherited.  
   ```java
   static void print() { System.out.println("Static Method"); }
   ```

3. **Nested Interfaces**:  
   - Interfaces can be declared inside other classes or interfaces.  
   ```java
   class Outer { public interface Nested { void display(); } }
   ```

4. **Extending Interfaces**:  
   - Interfaces can extend other interfaces. Classes implementing an extended interface must implement all inherited methods.

---

#### **Example:**
```java
interface Animal { void sound(); }

class Dog implements Animal {
    public void sound() { System.out.println("Woof"); }
}
```

---

#### **Interface vs Abstract Class:**
- **Multiple Inheritance**:  
  - Interfaces allow multiple inheritance; abstract classes don’t.  
- **State**:  
  - Abstract classes can have instance variables; interfaces can only have static final variables.
- **Constructors**:  
  - Abstract classes can have constructors; interfaces can’t.

---

#### **Important Notes:**
1. **Dynamic Method Resolution**:  
   - Method resolution happens at runtime, enabling flexibility.
2. **Access Modifiers**:  
   - Methods in interfaces must be **public**.
3. **Performance**:  
   - Using interfaces may introduce runtime lookup overhead.


---

### **Custom ArrayList with Generics**

**What it is**:  
A user-defined dynamic list implementation that stores elements of any type using Java Generics.

**Key Points**:
1. **Type Safety**: Eliminates casting and `ClassCastException`.
2. **Flexible**: Can work with any object type without duplicating code.
3. **How it works**:  
   - Declare class as `<T>`.
   - Use `T` for array and method types.
   - Type `T` is determined during object creation (e.g., `CustomArrayList<Integer>`).

**Wildcards in Generics**:
- **Unbounded Wildcard (`?`)**: Allows any type.
- **Upper Bounded Wildcard (`? extends T`)**: Restricts to types extending `T`.
- **Lower Bounded Wildcard (`? super T`)**: Allows types that are `T` or a superclass of `T`.

---

###  **Comparison Objects & Cloning in Java**

#### **Comparison Objects**
- **What It Is**: Used to compare two objects for sorting or ordering. Implemented via `Comparable` or `Comparator`.
- **Key Interfaces**:  
  - **Comparable**: Internal comparison (e.g., `compareTo`). Used for natural sorting.
  - **Comparator**: External comparison (e.g., `compare`). Used for custom sorting.
  
- **Examples**:
  - **Comparable**:  
    ```java
    class Person implements Comparable<Person> {  
        @Override  
        public int compareTo(Person other) {  
            return this.age - other.age;  
        }  
    }
    ```
  - **Comparator**:  
    ```java
    class PersonComparator implements Comparator<Person> {  
        @Override  
        public int compare(Person p1, Person p2) {  
            return p1.name.compareTo(p2.name);  
        }  
    }
    ```

#### **`compareTo` Methods**
- **Numeric Comparison**: Compares numeric values (`compareTo` for integers/floats).
  - **Result**: Negative, 0, or positive.
- **Alphabetical Comparison**: Compares strings lexicographically (like dictionary order).
  - **Result**: Negative, 0, or positive.

#### **Object Cloning**
- **What It Is**: Creates an exact copy of an object.
- **Key Concept**: `Cloneable` interface & `clone()` method.

#### **Shallow Copy**  
- **Definition**: Copies the object, but shares references to internal objects (e.g., `ArrayList`).
- **Effect**: Changes in inner objects affect both original and copied objects.

#### **Deep Copy**  
- **Definition**: Creates an independent object, duplicating the internal objects as well.
- **Effect**: Changes in the original do not affect the deep-copied object.

---

### ** Exception Handling in Java**

---

#### **What It Is**
- Mechanism to handle runtime errors and maintain normal program flow.  

---

#### **Why It's Used**
- Prevents program crashes and handles errors gracefully.  
- Separates error-handling from regular code.  

---

#### **Core Concepts**
- **try**: Test code for exceptions.  
- **catch**: Handle exceptions.  
- **finally**: Always executes, used for cleanup.  
- **throw**: Explicitly throw an exception.  
- **throws**: Declare exceptions a method can throw.

---

#### **Error vs Exception**
| **Aspect**     | **Error**              | **Exception**           |
|----------------|------------------------|-------------------------|
| **Severity**   | Serious, unrecoverable | Less severe, recoverable |
| **Examples**   | `OutOfMemoryError`     | `IOException`, `SQLException` |

---

#### **Types of Exceptions**
- **Checked**: Must be handled or declared (`IOException`, `SQLException`).
- **Unchecked**: Runtime errors (`NullPointerException`, `ArithmeticException`).
- **Error**: Critical system issues (`StackOverflowError`).

---

#### **Creating Custom Exceptions**
- Extend `Exception` or `RuntimeException`.  
- Example:
  ```java
  class CustomException extends Exception {
      public CustomException(String message) {
          super(message);
      }
  }
  ```

---

#### **Common Checked Exceptions**
- **IOException**: Issues with I/O operations (e.g., file reading/writing).
- **SQLException**: Database access or SQL query issues.

---

#### **Common Unchecked Exceptions**
- **NullPointerException**: Using a null reference.
- **ArithmeticException**: Illegal arithmetic operations (e.g., division by zero).
- **ArrayIndexOutOfBoundsException**: Invalid array index access.

--- 
### **JVM Memory Types**
#### **Two Types of Memory JVM Manages**

- **Heap**
- **Stack**

---

#### **Stack Memory in Java**

- **Purpose**: Stores method variables and execution context for each thread.
- **How it Works**: 
  - Each thread has its own stack.
  - Stores **primitive types** and **object references** (pointers to objects in heap).
  - New stack frames are created for each method call, removed when the method completes (LIFO).
- **Key Points**:
  - **Scope-based**: Exists only within the method's scope.
  - **Automatic cleanup**: Automatically cleared when method ends.
  - **Fixed size**: Too deep recursion causes **StackOverflowError**.

---

#### **Heap Memory in Java**

- **Purpose**: Stores **objects** (instances of classes).
- **How it Works**:
  - Shared by all threads, objects are not tied to specific thread’s stack.
  - **Dynamic memory management** at runtime.
  - **Garbage Collection (GC)**: Reclaims memory from unreferenced objects.
- **Key Characteristics**:
  - Managed by **Garbage Collector**.
  - **Mark & Sweep** algorithm marks referenced objects and removes unreferenced ones.
  - Divided into:
    - **Young Generation**: New objects.
    - **Old Generation**: Surviving objects.
    - **Metaspace** (Java 8+): Stores class metadata.
  
---

### **Garbage Collection** in Detail
- automatic memory management-> process of deallocating memory from unused objects duing program execution
- jvm controls the garbage collections
- it looking at heap memory and identify which objects are used andd unused by using mark and sweep algorithm.
 
- **Mark & Sweep**: 
  - **Mark**: Identifies referenced objects.
  - **Sweep**: Removes unreferenced objects.
  
- **GC Types**:
  - **Serial GC**: Single-threaded, slow.
  - **Parallel GC**: Multi-threaded, faster.
  - **CMS**: Minimizes pause times by running GC concurrently with app threads.
  - **G1 GC**: Balances high throughput and low pause times by dividing the heap into regions.

---

