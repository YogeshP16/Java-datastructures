### **Introduction**  
- An **abstract class** is a class that cannot be instantiated. It is declared using the `abstract` keyword and may contain abstract methods (without implementation) and concrete methods (with implementation).

---

### **Multiple Inheritance Problem**  
- Java does not support multiple inheritance with classes to avoid ambiguity caused by the **Diamond Problem**, where two parent classes have the same method, leading to confusion over which method to inherit.

---

### **Abstract Classes**  
Abstract classes provide a blueprint for other classes. They:
1. Define abstract methods to be implemented by subclasses (why ? --> they provide no implemenation in super class).
2. Allow partial implementation by combining abstract and concrete methods.

#### **Implementation Rules**
A subclass of an abstract class must either:
Implement all abstract methods from the superclass.
Or, itself be declared abstract (if it chooses not to implement all the methods).
---

### **Example of Abstract Classes**  
```java
abstract class Shape {  // super class
    abstract void draw(); // Abstract method -->Must be implemented by subclass
    void display() {
        System.out.println("This is a shape");
    }
}
class Circle extends Shape {  // subclass
    void draw() {     // here the implementation of abstract method
        System.out.println("Drawing Circle"); 
    }
}
```

---

### **Abstract Constructors**  
- Abstract classes cannot have constructors marked `abstract`, but they can define constructors for initialization, which subclasses can invoke using `super`.
-  In simple term normal constructor support in abstract class but we cannot use abstract marked constructor

---

### **Object of an Abstract Class**  
- You **cannot create an object** of an abstract class directly. However, you can use it to define references and instantiate concrete subclasses.

#### **Abstract Class Cannot Create Objects**
- Why?: Abstract classes are incomplete; they may have abstract methods with no implementation (they are incomplete).
- Therefore, you cannot directly instantiate an abstract class (e.g., Parent obj = new Parent(); is invalid if Parent is abstract).

#### Subclasses Can Create Objects
- If a subclass implements all abstract methods from the abstract parent class, the subclass becomes complete, and you can create objects of the subclass.

---

### **Abstract Static Methods**  
- Abstract static methods are not allowed in Java because static methods belong to a class, not an instance. Abstract methods are designed to be overridden by instances, causing conflict.

---

### **Static Methods in Abstract Classes**  
- Static methods can be defined in abstract classes. They behave like normal static methods and cannot be overridden by subclasses.  

```java
abstract class Utility {
    static void log(String message) {
        System.out.println("Log: " + message);
    }
}
```

---

### **"final" Keyword in Abstract Class**  
The `final` keyword cannot be used with an abstract class since `final` prevents inheritance, and abstract classes are meant to be extended.

---

### **Multiple Inheritance Using Abstract Classes**  
Multiple inheritance can be achieved by combining abstract classes and interfaces. A class can extend one abstract class and implement multiple interfaces. This resolves ambiguity by separating method definitions (interfaces) and partial implementation (abstract classes).

```java
abstract class Animal {
    abstract void sound();
}
interface Pet {
    void play();
}
class Dog extends Animal implements Pet {
    void sound() {
        System.out.println("Barks");
    }
    public void play() {
        System.out.println("Plays fetch");
    }
}
```

### Your Understanding Simplified  

1. **Abstract Class as a Leader**  
   - The **abstract class** acts as a **leader** who assigns tasks to its employees (subclasses).  
   - It defines the **tasks** (abstract methods) but doesn’t do the actual work. Instead, it says, “This is what needs to be done,” and leaves the details to the subclasses.  

2. **Abstract Methods as Task Assigners**  
   - The abstract class **must define the tasks (abstract methods)** in a general way but doesn’t explain how to finish them (no method body).  
   - Subclasses are responsible for completing these tasks by **implementing the abstract methods**.

3. **Subclass Handles the Work**  
   - The **subclass (employee)** knows how to finish the tasks and provides the detailed implementation of the abstract methods.  
   - If a subclass doesn’t complete the tasks, it becomes abstract itself, as it didn’t fulfill its responsibility.

4. **Method Overriding in Child Class**  
   - In **method overriding**, the **child class (subclass)** provides its own specific implementation for a method that the **parent class (abstract class)** declared.  
   - This is mandatory for abstract methods (you **must** override them in the child class), and it’s optional for non-abstract methods (you **can** override them).  

5. **Using `Child obj = new Child();`**  
   - You cannot use Parent obj = new Parent() --> Abstract classes are incomplete and may have abstract methods with no implementation, so they cannot be instantiated.
   - When we write `Child obj = new Child();`, we’re saying:  
     - “I want to create an object of the subclass and use its specific implementation of the tasks.”  
     - The overridden methods in the child class will be executed.  
   - This is why the abstract class can only be used as a reference (`Parent obj = new Child();`) but **not instantiated directly**.

---

### Example to Solidify  
```java
abstract class Leader {
    abstract void assignTask(); // Abstract method - task assigned
    void greet() {
        System.out.println("Welcome to the team!"); // Shared behavior
    }
}
class Employee extends Leader {
    @Override
    void assignTask() { // Child overrides the task
        System.out.println("Completing the assigned task!");
    }
}
public class Main {
    public static void main(String[] args) {
        Leader leader = new Employee(); // Parent reference, child object
        leader.greet(); // Calls parent method
        leader.assignTask(); // Calls child's overridden method
    }
}
```

### Key Observations  
- The `Leader` class is like the **abstract leader**, defining the task (`assignTask()`) but not knowing how to finish it.  
- The `Employee` subclass knows **how to complete the task** and overrides `assignTask()`.  
- When using `Leader leader = new Employee();`, you see the **employee’s implementation** in action because the **child overrides the parent’s behavior**.  

