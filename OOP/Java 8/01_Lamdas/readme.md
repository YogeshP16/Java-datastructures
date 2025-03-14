### **Lambda Expressions** in Java:

- A **Lambda Expression** is a shorthand notation to represent a **single-method interface (functional interface)**.
- Anonoymous function
- It doesn't belongs to any class or objects
- It provides a clear and concise way to implement methods of a functional interface using an expression rather than a full class or method.

- **Syntax**: 
  ```java
  (parameters) -> expression
  ```

  - **Parameters**: The input values (optional if none).
  - **`->`**: The lambda operator.
  - **Expression**: The body of the lambda (single statement or block).

  Example:
  ```java
  (x, y) -> x + y  // Adds two numbers
  ```

- **Components**:
  1. **Parameter(s)**: The input to the lambda.
  2. **Lambda Operator (`->`)**: Separates parameters from the body.
  3. **Body**: Defines the action or behavior.

- **When to Use**:
  - When you need to pass a behavior (method) as an argument.
  - When you are working with **functional interfaces**.
  - When you want a **short, concise** way to express a single method of a functional interface.

---

### **Example**:
```java
// Lambda expression to define the behavior of a Runnable
Runnable task = () -> System.out.println("Running the task...");

// Using the lambda
task.run();
```

### **When Not to Use**:
- If the method requires more than one implementation or has complex logic, consider using a regular method or class.

---
 


