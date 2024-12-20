### Polymorphism
- **What it is**: Polymorphism means "many forms." It allows an object to take on different forms based on the context.
- **Why it's used**: It enables flexibility and reusability of code, allowing methods to behave differently based on the object calling them.
- **What it does**: It allows methods or objects to be used in different ways depending on the data type or class.

### Types of Polymorphism
1. **Compile-time Polymorphism (Static Polymorphism)**:
   - **What it is**: Occurs during compilation and is resolved by the compiler.
   - **Example**: Method Overloading.

   **How it works**: Multiple methods with the same name but different parameters (number/type of parameters).

   ```java
   class Shape {
       void draw(int x) { System.out.println("Drawing with " + x + " points"); }
       void draw(double x) { System.out.println("Drawing with radius " + x); }
   }
   ```

2. **Runtime Polymorphism (Dynamic Polymorphism)**:
   - **What it is**: Occurs at runtime and is resolved by the JVM.
   - **Example**: Method Overriding.

   **How it works**: Method in the subclass overrides a method in the superclass.

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

### Static Polymorphism (Overloading)
- **What it is**: Overloading methods at compile-time based on method signatures.
- **How it works**: Multiple methods with the same name but different parameters.

### Dynamic Polymorphism (Overriding)
- **What it is**: Overriding a method of a superclass in a subclass.
- **How it works**: At runtime, the JVM determines which version of the method to call based on the object type, not the reference type.

### How Overriding Works
- **What it is**: A subclass provides its own implementation of a method already defined in the superclass.
- **How it works**: The subclass method must have the same method signature as the superclass method.

### How Java Determines Which Method to Run ---> uses dynamic method dispatch
- **At compile-time**: For overloaded methods, Java uses the reference type to determine which method to call.
- **At runtime**: For overridden methods, Java uses the actual object type (not the reference type) to determine which method to execute.

### Dynamic Method Dispatch 

**Dynamic Method Dispatch** is a mechanism in Java that allows the JVM to decide which method to invoke at runtime based on the **actual object type** (not the reference type) used in the method call. This is closely tied to **runtime polymorphism** and is a core feature of method overriding.

When a method is overridden in a subclass, the JVM determines the actual method to invoke at runtime, based on the object's actual class (not the reference type).

#### How It Works:
- When a method is called on an object, Java uses **dynamic method dispatch** to check the actual object's type and calls the appropriate method, even if the reference type is the parent class.
- The decision on which method to call is made at runtime, which is why this behavior is referred to as "dynamic."

#### Key Points:
1. **Overridden Methods**: Dynamic method dispatch works with overridden methods in the subclass.
2. **Reference Type vs. Object Type**: The reference type determines which method is available at compile time, but the actual method called is determined by the **object type** at runtime.


### `final` Keyword
- **What it is**: The `final` keyword is used to prevent modification.
- **Why it's used**: It can prevent method overriding, class inheritance, or variable reassignment.
- **What it does**: 
  - **Method**: Cannot be overridden.
  - **Class**: Cannot be subclassed.
  - **Variable**: Cannot be reassigned.

### Can We Override Static Methods?
- **Answer**: No, static methods cannot be overridden. They can be hidden, but not overridden.


