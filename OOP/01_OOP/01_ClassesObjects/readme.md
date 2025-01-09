### **Class and Object**

---

#### **What is a Class in Java?**  
   
- **Definition**: A blueprint for creating objects.  
- **Key Points**:  
  - Defines **properties (fields)** and **behaviors (methods)**.  
  - When you declare an object of a class, you are creating an instance of that class. Thus, a class is a logical construct. An object has physical reality. (That is, an object occupies space in memory.)
  - Example:  
    ```java
    class Car {
        String color; // Field
        void startEngine() { // Method
            System.out.println("Engine started!");
        }
    }
    ```

---

#### **What is an Object in Java?**  

- **Definition**: An instance of a class.  
- **Key Points**:  
  - Created using the `new` keyword.  
  - Occupies memory in the heap.  
  - Example:  
    ```java
    Car myCar = new Car(); // Object creation
    myCar.color = "Red"; // Access field
    myCar.startEngine(); // Call method
    ```  

**Object Properties**:  
1. **State**: Values of fields (e.g., `color`).  
2. **Identity**: Unique memory reference.  
3. **Behavior**: Methods (e.g., `startEngine()`).

---

#### **How to Create an Object?**  

1. Declare a reference variable: `ClassName obj;`  
2. Allocate memory with `new`: `obj = new ClassName();`  
3. Combine: `ClassName obj = new ClassName();`  

**Key Points**:  
- `new` dynamically allocates memory at runtime.  
- The reference variable stores the memory address of the object.

---

#### **What Happens When an Object is Created?**  
  
1. **Memory Allocation**: Space is allocated in the heap.  
2. **Constructor Execution**: Initializes the object.  
3. **Reference Assignment**: Variable points to the memory address.

**Example**:  
```java
Box box1 = new Box();
Box box2 = box1; // box1 and box2 refer to the same object
```
- Changes via `box2` reflect on `box1`.

---

#### **What is the `dot (.)` Operator?**  
 
- Used to access an object’s fields or methods.  
- Example:  
  ```java
  car.color = "Blue";
  car.startEngine();
  ```

---

####  **Primitive Types vs Objects**  
 
- **Primitive Types**: Not objects, stored as normal variables for efficiency (e.g., `int`, `char`).  
- **Objects**: Dynamically allocated in memory, referenced by variables.  

---

