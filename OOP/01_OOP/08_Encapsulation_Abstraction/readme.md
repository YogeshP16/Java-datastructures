### Encapsulation vs Abstraction

#### **Encapsulation**  
- **What?**  
  - Bundles data (variables) and methods within a class.
  - **Data Hiding**: Restricts access to internal data using private fields and public methods.
  
- **Why?**  
  - Protects data integrity and controls access to it.
  
- **How?**  
  - Private fields + public getter/setter methods.
  
#### **Abstraction**  
- **What?**  
  - Hides implementation details and exposes essential features.
  
- **Why?**  
  - Simplifies interaction with objects by hiding complexities.
  
- **How?**  
  - Achieved via interfaces or abstract classes that define methods without implementation.

#### **Encapsulation vs Abstraction**  
- **Encapsulation**: Focuses on **how** data is hidden and controlled.
- **Abstraction**: Focuses on **what** details are hidden and simplifies interactions.

#### **Example**  
- **Encapsulation**: Private field with getter/setter.
- **Abstraction**: Interface with method implementations in classes.

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

### Data Hiding vs Encapsulation

#### **Data Hiding**  
- **What?**  
  - Hides internal data using private access modifiers.
  
- **Why?**  
  - Protects data and ensures controlled modifications.

- **How?**  
  - Private fields + public methods (getters/setters) for controlled access.

#### **Encapsulation**  
- **What?**  
  - Wraps data and methods into a single unit, exposing necessary functionality.

- **Why?**  
  - Promotes modularity by bundling data with its associated methods.

- **How?**  
  - Combines data hiding with public methods for data interaction.

#### **Data Hiding vs Encapsulation**  
- **Data Hiding**: Focuses on **hiding** internal data.  
- **Encapsulation**: Combines data and methods, providing **controlled access** to the data.  
- **Relationship**: Data hiding is a **part of encapsulation**.
