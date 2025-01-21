### 1. **Static in Java**

#### **What is it?**
Class-level keyword for variables, methods, or blocks.Means they belong to the class rather than instances of the class.
- **Static Variables**: Shared by all instances of the class.
- **Static Methods**: Can be called without creating an instance of the class.
- **Static Blocks**: Used to initialize static variables when the class is loaded.

#### **Why it's used?**
It allows shared access to variables or methods across all instances of a class. 
You don’t need to create an object to access them.

---

### Static Variables

**What?**  
- Static variables are declared with `static` and belong to the class, not instances.
- Class-level variable → Common value shared by all objects.

**How?**  
- Accessed using the class name or an instance of the class.  
- **Cannot be overridden** but can be hidden in subclasses.

**Instance vs static**
- **Insance**: Object-level variable → Separate value for each object.
- **Static**: Class-level variable → Common value shared by all objects.

---

### Static Methods

**What?**  
- Static methods are declared with `static` and can be called using the class name without creating an object.

**Why?**  
- Used for class-level operations that do not depend on instance data.

**How?**  
- Access static variables and methods only.  
- Called directly through the class name.  
- **Cannot be overridden**, but can be hidden in subclasses.

---

### Why `psvm` is Static

**What?**  
- `psvm` stands for `public static void main(String[] args)` and is the entry point of any Java application.

**Why?**  
- Static because the JVM calls it before creating any objects. 
- The JVM invokes it directly when the program starts without creating an instance of the class.

---

### Non-static Member Inside a Static Method

**What?**  
- Non-static members cannot be accessed directly in a static method.  

**Why?**  
- Static methods lack access to instance-specific data.  

**How?**  
- Create an object to access non-static members (e.g., `obj.instanceVariable`).  

---

### Static Member Inside a Non-static Method

**What?**  
- Static members can be accessed directly in non-static methods.  

**Why?**  
- Static members are class-level and shared across all instances.  

**How?**  
- Access directly without an instance (e.g., `ClassName.staticVariable`).  
---

### `this` Keyword in Static Methods

**What?**  
- `this` refers to the current object.  

**Why Not in Static Methods?**  
- Static methods belong to the class, not any instance.  

**How?**  
- Static methods cannot use `this` since no specific instance is associated.

---
### Static Block

**What?**  
- Code executed when the class is loaded, even before `main`.  
- Used to initialize static variables.  

**Why?**  
- Ensures static variables are initialized only once for all instances.  

**How?**  
```java
static {
    variable = value;
}
```
---

### 9. **Instance vs Static**

#### **What is it?**
Instance members are tied to an object, whereas static members are tied to the class itself.
Instance members can only be accessed through an object, while static members can be accessed without creating an object.

#### **How it works?**
- Instance members require an object for access.
- Static members can be accessed directly using the class name.

---

### 10. **Inner Classes**

#### **What is it?**
An inner class is a class defined within another class.
It allows the inner class to access the members (including private members) of the outer class.

#### **How it works?**
- **Non-static inner classes**: These can access both static and non-static members of the outer class.
- **Static nested classes**: These can only access static members of the outer class.

---

### 11. **Singleton**

#### **What is Singleton?**
Ensures that only one object of a class is created and provides a global way to access that object. 
It is useful when you need a single, shared instance to manage something across the entire application.
To control access to shared resources (e.g., database connections, configuration settings).
To reduce memory usage by preventing multiple object creation

```java
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
``` 

---

