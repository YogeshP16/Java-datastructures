
### **Interfaces in Java**

#### **1. What are Interfaces?**  
- Interfaces define a contract (what a class must do) without providing the implementation (how it’s done).  
- Methods are **public** and **abstract** by default. Variables are **static**, **final**, and **public**.  

#### **2. Why Use Interfaces?**  
- To achieve **multiple inheritance** and abstraction.  
- Allows unrelated classes to implement common behavior.  
- Promotes loose coupling between components.  

#### **3. What Problem Does It Solve?**  
- Avoids **diamond problem** in multiple inheritance by only specifying method declarations, not bodies.  
- Allows dynamic method resolution at runtime.  

#### **4. How Does It Work?**  
- A class implements an interface using the `implements` keyword.  
- The class must provide the implementation of all methods in the interface unless it's declared `abstract`.  

---

### **Key Features**

#### **Default Methods**  
- Added in Java 8.  
- Allow interfaces to include methods with implementations.  
- Used for backward compatibility to add new methods without breaking existing code.  
```java
default void show() {
    System.out.println("Default Method in Interface");
}
```

#### **Static Methods**  
- Introduced in Java 8.  
- Static methods belong to the interface and are not inherited by implementing classes.  
- Called using the interface name.  
```java
static void print() {
    System.out.println("Static Method in Interface");
}
}
```

#### **Nested Interfaces**  
- Interfaces can be declared inside classes or other interfaces.  
- Nested interfaces can be public, private, or protected.  
```java
class Outer {
    public interface Nested {
        void display();
    }
}
```

#### **Extending Interfaces**  
- Interfaces can inherit other interfaces using the `extends` keyword.  
- The implementing class must implement all inherited methods.  

---

### **Example: Basic Interface**
```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof");
    }
}
```

---

### **Example: Default Method**
```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle Starting");
    }
}

class Car implements Vehicle {}
```

---

### **Important Notes**
1. **Dynamic Method Resolution**  
   - Method calls are resolved at runtime, enabling flexibility and polymorphism.  

2. **Static Variables**  
   - Must be initialized. Cannot be changed by implementing classes.  

3. **Access Modifiers**  
   - Methods implementing an interface must be **public**.  

4. **Performance**  
   - Using interfaces introduces a runtime lookup overhead, so avoid in performance-critical code.  

5. **Conflict Resolution**  
   - If two interfaces have the same default method, the class implementing them must override the method to resolve ambiguity.  

6. **State Management**  
   - Unlike classes, interfaces cannot maintain state as they do not support instance variables.  

---

#### **Interface vs Abstract Class**  
Yes, interfaces are **similar** to abstract classes in the following ways:
1. **Cannot Create Objects Directly**  
   - Just like abstract classes, you **cannot create an object** of an interface.  
   - Example:
     ```java
     interface Animal {}
     Animal a = new Animal(); // ERROR
     ```
   - However, you can create objects of the implementing subclass:
     ```java
     class Dog implements Animal {}
     Animal a = new Dog(); // VALID
     ```

---

#### **No Instance Variables in Interfaces**  
- Correct! Interfaces **cannot have instance variables** because they belong to objects, and interfaces are not tied to any specific object.  
- Interfaces are meant to define **behavior**, not hold **state**.

---

#### **Static Variables and Methods in Interfaces**  
- **Static Variables**  
  - Interfaces support static variables because these belong to the interface itself, not any object.  
  - Example:
    ```java
    interface Animal {
        int AGE = 10; // static and final by default
    }
    ```
    - `AGE` can be accessed as `Animal.AGE`.  

- **Static Methods**  
  - Interfaces can have static methods (introduced in Java 8).  
  - These belong to the interface and are accessed using the interface name:
    ```java
    interface Animal {
        static void info() {
            System.out.println("Static method in interface");
        }
    }

    Animal.info(); // VALID
    ```

---

#### **Abstract Methods in Interfaces**  
- Yes, you must declare **abstract methods** in an interface, and these **must** be implemented by any class that implements the interface.  
- Example:
  ```java
  interface Animal {
      void sound(); // Abstract method
  }

  class Dog implements Animal {
      public void sound() {
          System.out.println("Woof");
      }
  }
  ```

---

#### **Implements Keyword**  
- Interfaces use the `implements` keyword to indicate that a class will follow its contract.  
- Example:
  ```java
  interface Animal {
      void sound();
  }

  class Dog implements Animal {
      public void sound() {
          System.out.println("Woof");
      }
  }
  ```

---

#### **Constructor in Interfaces**  
- **No, interfaces do not support constructors.**  
- Reason:  
  - A constructor is used to initialize objects and belongs to the class instance.  
  - Since you can’t create an object of an interface, there’s no need for a constructor.  

---

#### **Summary Table**

| Feature                        | Abstract Class             | Interface                       |
|--------------------------------|----------------------------|---------------------------------|
| **Can Create Objects?**        | No                         | No                              |
| **Instance Variables?**        | Yes                        | No                              |
| **Static Variables?**          | Yes                        | Yes (default: `public static`) |
| **Abstract Methods?**          | Yes                        | Yes (default: `public`)        |
| **Static Methods?**            | Yes                        | Yes (Java 8+)                  |
| **Constructors?**              | Yes                        | No                              |
| **Multiple Inheritance?**      | No                         | Yes (via multiple interfaces)  |
| **Keyword to Extend?**         | `extends`                  | `implements`                   |

---

### differences between **Abstract Classes** and **Interfaces** in Java:

#### **1. Purpose**  
- **Abstract Class**:  
  - Used to represent a common base for related classes with **shared state** (instance variables) and behavior (methods).
  - Example:  
    ```java
    abstract class Animal {
        String name; // shared state
        void eat() { // shared behavior
            System.out.println("Eating");
        }
        abstract void sound(); // must be implemented by subclasses
    }
    ```

- **Interface**:  
  - Used to define a **contract** or **behavior** that unrelated classes can implement. Focuses only on "what" a class should do, not "how."  
  - Example:  
    ```java
    interface Animal {
        void sound(); // abstract by default
    }
    ```

---

#### **2. Multiple Inheritance**  
- **Abstract Class**:  
  - Does **not support multiple inheritance**. A class can only extend one abstract class.  
  - Example:
    ```java
    class Dog extends Mammal {} // Only one parent class
    ```

- **Interface**:  
  - Supports **multiple inheritance**. A class can implement multiple interfaces.  
  - Example:
    ```java
    interface Swimmable {}
    interface Runnable {}
    class Dog implements Swimmable, Runnable {}
    ```

---

#### **3. Methods**  
| **Feature**          | Abstract Class                      | Interface                                    |
|-----------------------|--------------------------------------|---------------------------------------------|
| **Abstract Methods**  | Yes                                 | Yes (default: `public abstract`)            |
| **Concrete Methods**  | Yes                                 | Yes (using `default` or `static` methods)   |
| **Access Modifiers**  | Can be `protected`, `public`, or `default` | Always `public` for methods and variables |

---

#### **4. Variables**  
| **Feature**               | Abstract Class               | Interface                          |
|----------------------------|------------------------------|------------------------------------|
| **Instance Variables**     | Yes                         | No                                |
| **Static Variables**       | Yes                         | Yes (`public static final` by default) |

- **Why Interfaces Don’t Have Instance Variables?**  
  Interfaces are not tied to specific objects, so they don’t have instance variables. Instead, they define constants (`static final`) that all implementing classes can use.

---

#### **5. Constructors**  
- **Abstract Class**:  
  - Can have constructors to initialize common fields.  
  - Example:
    ```java
    abstract class Animal {
        String name;
        Animal(String name) {
            this.name = name;
        }
    }
    ```

- **Interface**:  
  - No constructors because you **cannot instantiate interfaces**. They are purely behavioral blueprints.

---

#### **6. When to Use?**  
- **Abstract Class**:  
  - Use when you have a **common state** or behavior to share among related classes.  
  - Example:  
    ```java
    abstract class Vehicle {
        int speed;
        void start() {
            System.out.println("Starting vehicle");
        }
    }
    ```

- **Interface**:  
  - Use when you want to define a **contract** for unrelated classes to follow.  
  - Example:
    ```java
    interface Flyable {
        void fly();
    }
    ```

---

#### **Key Differences at a Glance**

| **Aspect**               | **Abstract Class**                        | **Interface**                           |
|--------------------------|-------------------------------------------|-----------------------------------------|
| **Purpose**              | Base class with shared state & behavior   | Defines a contract for behavior         |
| **Inheritance**          | Single inheritance                       | Multiple inheritance                    |
| **State (Variables)**    | Can have instance variables               | Only `public static final` constants    |
| **Constructors**         | Supported                                | Not supported                           |
| **Access Modifiers**     | Supports all (private, protected, public) | Always `public`                         |
| **When to Use?**         | Shared state & closely related classes    | Unrelated classes sharing common behavior |

