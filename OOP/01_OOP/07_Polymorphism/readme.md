### Polymorphism

- Polymorphism means "many forms." It allows an object to take on different forms based on the context.
- It allows methods or objects to be used in different ways depending on the data type or class.

### Types of Polymorphism

1. **Compile-time Polymorphism (Static Polymorphism)**:
   - **What it is**: Occurs during compilation and is resolved by the compiler.
   - **Example**: Method Overloading.

   **How it works**
   - Multiple methods with the same name but different parameters (number/type of parameters).

   ```java
   class Shape {
       void draw(int x) { System.out.println("Drawing with " + x + " points"); }
       void draw(double x) { System.out.println("Drawing with radius " + x); }
   }
   ```

2. **Runtime Polymorphism (Dynamic Polymorphism)**:
   - **What it is**: Occurs at runtime and is resolved by the JVM.
   - **Example**: Method Overriding.

   **How Method Overriding works** 
   - Method in the subclass overrides a method in the superclass.
   - The subclass method must have the same method signature as the superclass method.

   ```java
   class Shape {
       void draw() { System.out.println("Drawing Shape"); }
   }

   class Circle extends Shape {
       void draw() { System.out.println("Drawing Circle"); }
   }

   Shape s = new Circle();
   s.draw();  // Outputs "Drawing Circle"
   ```


### How Java Determines Which Method to Run ---> uses dynamic method dispatch
- **At compile-time**: For overloaded methods, Java uses the reference type to determine which method to call.
- **At runtime**: For overridden methods, Java uses the actual object type (not the reference type) to determine which method to execute.

### Dynamic Method Dispatch

**What?**  
- **Dynamic Method Dispatch** is a mechanism in Java where the JVM decides which method to invoke at runtime based on the **actual object type**, not the reference type.

**Why?**  
- It's tied to **runtime polymorphism** and is a core feature of method overriding.

**How?**  
- When a method is overridden in a subclass, the JVM determines the actual method to call based on the object's actual class (not the reference type).

**Key Points**  
1. Works with **overridden methods** in the subclass.
2. The **reference type** determines the available methods at compile-time, while the **object type** determines the method to call at runtime.

### `final` Keyword
- **What it is**: The `final` keyword is used to prevent modification.
- **Why it's used**: It can prevent method overriding, class inheritance, or variable reassignment.
- **What it does**: 
  - **Method**: Cannot be overridden.
  - **Class**: Cannot be subclassed.
  - **Variable**: Cannot be reassigned.

### Can We Override Static Methods?
- **Answer**: No, static methods cannot be overridden. They can be hidden, but not overridden.


