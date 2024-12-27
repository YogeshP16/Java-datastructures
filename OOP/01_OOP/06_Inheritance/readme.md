### **Inheritance in Java**

---

### **What is it?**  
Inheritance allows a class (child/subclass) to acquire properties and behavior (fields and methods) of another class (parent/superclass).  

---

### **Why is it used?**  
- To **reuse** existing code.  
- To **extend** functionality without rewriting it.  
- To achieve **polymorphism**.

---

### **What does it do?**  
It establishes an **IS-A relationship** between classes. A child class can:  
1. Use fields/methods of the parent class.  
2. Override parent methods.  

---

### **How it works?**  
- Use the `extends` keyword: `class Child extends Parent`.  
- The child gets access to public/protected members of the parent.  
- Private members are **not accessible**.  

---

### **`private` Keyword**  
- Used to **restrict access** to a class member.  
- **Not inherited** by child classes.  

---

### **`super` Keyword**  
- Used to access **parent class methods** or **constructors**.  
- **Syntax**: `super()` calls the parent constructor.  

---

### **Types of Inheritance**

1. **Single Inheritance**  
   - One child inherits from one parent.  
   ```java
   class A {}  
   class B extends A {}
   ```

2. **Multiple Inheritance (Not supported with classes)**  
   - A child inherits from **multiple parents**.  
   - Achieved via **interfaces** only.  

3. **Hierarchical Inheritance**  
   - Multiple child classes inherit from the same parent.  
   ```java
   class A {}  
   class B extends A {}  
   class C extends A {}
   ```

4. **Hybrid Inheritance**  
   - Combination of two or more types of inheritance. (combination of single and multiple inheritance)
   - Not directly supported in Java (avoids ambiguity).  
   - Achievable with **interfaces**.  

--- 

### **Can We Access Child Class Data from the Base Class?**

---

### **Short Answer:**  
No, **a base class (parent class) cannot directly access child class (derived class) data** or methods.

---

### **Why Not?**  
- In Java, inheritance flows **downward** from the parent class to the child class.  
- The parent class does not have knowledge of any specific properties or methods introduced in the child class.

---

### **How It Works**:  
- Parent class **only knows its own fields and methods**.  
- The child class can add its own fields and methods, but these are **unknown** to the parent.  

---

### **Example Demonstration**  
```java
class Parent {
    void display() {
        System.out.println("This is the Parent class.");
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
        p.display(); // Parent class method

        // p.childData; // Compilation error: childData not accessible
        // p.show();    // Compilation error: show() is not known to Parent
    }
}
```

---

### **Output**  
```
This is the Parent class.
```

---

### **Explanation**  
1. Even if the `Parent` reference points to a `Child` object, the **Parent class can only access its own methods**.  
2. Any methods or fields specific to the child class are **inaccessible** through the parent class reference.  

---

### **Why is this Important?**  
- Java follows **strict type checking** to ensure code safety.  
- It avoids ambiguity and enforces the **IS-A relationship** where the child class *is a* parent class but **not vice versa**.  

---

### **Workaround:**  
If you need to access child-specific data, you must **typecast** the parent reference back to the child class.  

**Example:**  
```java
Parent p = new Child();
Child c = (Child) p;  // Typecasting to Child class
System.out.println(c.childData);  // Accessing child-specific data
```

### **Output**  
```
10
```
### Why Multiple Inheritance is Not Supported by Java

#### **What is Multiple Inheritance?**
Multiple inheritance refers to a scenario where a class can inherit properties and behaviors (methods) from more than one parent class.

#### **What Does It Do?**
It allows a child class to combine and utilize features from multiple parent classes.

#### **How Does It Work?**  
In languages that support multiple inheritance (e.g., C++), a child class can explicitly inherit from multiple parent classes using syntax like:

```cpp
class Child : public Parent1, public Parent2 {
    // Combine methods and fields from Parent1 and Parent2
};
```

#### **Why Is It Not Supported in Java?**

1. **Diamond Problem:**
   - If two parent classes have a method with the same name, it creates ambiguity for the compiler when the child class inherits these methods.
   - Example:
     ```java
     class Parent1 {
         void show() {
             System.out.println("Parent1");
         }
     }

     class Parent2 {
         void show() {
             System.out.println("Parent2");
         }
     }

     class Child extends Parent1, Parent2 {
         // Which show() to inherit? Ambiguity!
     }
     ```

2. **Simplified Design:**
   - Java designers intentionally avoided multiple inheritance to keep the language simpler, more maintainable, and less error-prone.

3. **Alternative Solutions:**
   - Java supports **multiple inheritance of types** through interfaces. This allows a class to implement multiple interfaces without ambiguity.

#### **Why Interface Comes Into Play?**
1. **No Method Implementation Conflict:**
   - Interfaces only provide method declarations (until Java 8, when default methods were introduced). The child class must provide its own implementation, so there's no ambiguity like the diamond problem.

2. **Flexibility with Contracts:**
   - Interfaces allow classes to follow multiple contracts (behaviors) without inheriting state (fields), which ensures better modularity.

3. **Example of Multiple Inheritance with Interfaces:**
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
- With classes, the potential conflicts (like the diamond problem) could make code behavior unpredictable.
- Interfaces focus only on defining behavior without carrying the burden of shared state or inheritance ambiguity.


