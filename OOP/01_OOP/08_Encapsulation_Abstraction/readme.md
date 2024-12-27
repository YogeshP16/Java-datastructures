### **Encapsulation - focus on internal working**
- **What it is**: 
Encapsulation is the concept of bundling data (variables) and methods (functions) that operate on the data within a single unit or class.
wrap up the implementation of data members and methods in a class.

- **Why it's used**: It helps restrict access to certain details and protects the integrity of the data.

- **What it does**: It hides the internal state of an object and only exposes necessary methods to interact with that state.

- **How it works**: By using **private** fields and providing **public** getter and setter methods to access and modify them, encapsulation hides the internal implementation and controls how data is accessed or modified.

### **Abstraction - focus on external stuff**
- **What it is**: 
Abstraction is the concept of hiding complex implementation details and exposing only the essential features of an object.
Hiding unnecessary details & showing valuable information. it is design level
we acheive abstraction via interfaces, abstract class.

- **Why it's used**: It simplifies interaction with objects by exposing only necessary functionality and hiding unnecessary complexities.

- **What it does**: It provides a simplified interface to interact with objects, while the detailed implementation is hidden from the user.

- **How it works**: By using **abstract classes** or **interfaces**, abstraction defines a contract (methods) without specifying the implementation. Classes that implement or extend these can provide specific implementations.

### **Encapsulation vs Abstraction**
- **Encapsulation** focuses on hiding the internal state of an object and restricting access to it using access modifiers (private/protected/public). It is about **how the data is hidden** and controlled.

- **Abstraction** focuses on hiding the complexity of the implementation and providing a simplified interface for interaction. It is about **what details are hidden**.

### **Example**
- **Encapsulation**: 
  - Class `Car` with private field `speed`. Public getter and setter methods control access to `speed`.
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
  
- **Abstraction**: 
  - Interface `Vehicle` with method `start()`. Classes `Car` and `Bike` provide specific implementations of `start()`.
  ```java
  interface Vehicle {
      void start();
  }
  
  class Car implements Vehicle {
      public void start() {
          System.out.println("Car started");
      }
  }
  
  class Bike implements Vehicle {
      public void start() {
          System.out.println("Bike started");
      }
  }
  ```

### **Data Hiding**
- **What it is**: Data hiding is a feature of encapsulation where the internal data of an object is hidden from outside access. example private access modifer is known as data hiding

- **Why it's used**: It ensures that the data is protected and can only be modified in controlled ways, preventing unauthorized or incorrect modifications.

- **What it does**: By making class fields private and providing controlled access through methods, data hiding prevents direct access to the fields.

- **How it works**: Data hiding is achieved using access modifiers like `private` to prevent direct access to fields. Only public methods are used to interact with the fields, allowing validation and control over the data.

### **Data hiding vs encapsulation**
#### **1. Definition and Focus**  
- **Data Hiding**: Hides internal data by using `private` access modifiers to restrict direct access.  
- **Encapsulation**: Wraps data and methods into a single unit and provides controlled access via public methods.  

#### **2. Relationship and Purpose**  
- **Data Hiding**: Ensures sensitive data is secure and not directly accessible. It is a **part of encapsulation**.  
- **Encapsulation**: Uses data hiding and promotes modularity by bundling fields with methods (getters/setters).  

