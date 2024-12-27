### 1. **Static in Java**

#### **What is it?**
The keyword `static` in Java is used to define class-level members (variables, methods, or blocks), meaning they belong to the class rather than instances of the class.

#### **Why it's used?**
It allows shared access to variables or methods across all instances of a class. You don’t need to create an object to access them.

#### **What it does?**
- **Static Variables**: Shared by all instances of the class.
- **Static Methods**: Can be called without creating an instance of the class.
- **Static Blocks**: Used to initialize static variables when the class is loaded.

#### **How it works?**
- **Static Variable**: When a variable is declared static, it's initialized only once, and all instances of the class share the same memory location for that variable.it cannot be ovverriden by another class.
- **Static Method**: A method declared as static can be called directly using the class name, without creating an object, it cannot be ovverriden by another class.

---

### 2. **Static Variables**

A **static variable** is declared with the `static` keyword and belongs to the class, not instances of the class.

- **Usage**: Static variables are used for data that is shared among all instances of the class.
- **Behavior**: They are initialized only once and have the same value for all instances.
- **Access**: Accessed using the class name or an instance of the class.
- **Overriding**: Static variables **cannot be overridden**, but can be hidden in subclasses.

---

### 3. **Static Methods**

A **static method** is declared with the `static` keyword and can be called using the class name without creating an object.

- **Usage**: Static methods are used for class-level operations that do not depend on instance data.
- **Behavior**: They can access only static variables and methods.
- **Access**: Called directly through the class name, without an instance.
- **Overriding**: Static methods **cannot be overridden**. They can be hidden in subclasses, but the method call is determined by the reference type at compile time.

---

### 4. **Why `psvm` (main method) is static?**

#### **What is it?**
`psvm` stands for `public static void main(String[] args)` which is the entry point of any Java application.

#### **Why it's used?**
The `main` method needs to be static because it is called by the JVM before any objects are created. The JVM does not create an object to invoke the main method, so it must be static.

#### **What it does?**
It allows the JVM to call the method without creating an instance of the class.

#### **How it works?**
Since the `main` method is static, the JVM can invoke it directly when the program starts.

---

### 5. **Non-static Member Inside a Static Method**

#### **What is it?**
You cannot directly access non-static members (variables or methods) inside a static method because static methods don’t have access to instance data.

You can access by creating an instance of the class (Example obj = new Example();), the static method can access the non-static members using the object reference (obj.instanceVariable).

#### **Why it's used?**
Non-static members are tied to instances, so they require an object to be accessed.

#### **What it does?**
To access a non-static member inside a static method, you need to create an instance of the class.

#### **How it works?**
You can create an object in the static method and use it to access non-static members.

---

### 6. **Static Member Inside a Non-static Method**

#### **What is it?**
Static members (variables or methods) can be accessed directly in non-static methods because static members belong to the class.

#### **Why it's used?**
It allows access to class-level data inside instance methods.

#### **What it does?**
You can directly refer to static members in non-static methods without creating an instance of the class.

#### **How it works?**
Since static members are shared by all instances, they are directly available inside non-static methods.

---

### 7. **`this` Keyword Inside Static Methods**

#### **What is it?**
The `this` keyword refers to the current object.

#### **Why it's used?**
It is used to refer to the current instance of the class.

#### **What it does?**
Inside a static method, `this` cannot be used because static methods don’t belong to any specific instance.

#### **How it works?**
Since static methods are class-level methods, they cannot refer to the instance-specific context, which is what `this` represents.

---

### 8. **Initialization of Static Variables (Static block)**

#### **What is it?**
A static block is a block of code inside a class that is executed when the class is loaded into memory, even before the main method run
Static variables are initialized when the class is loaded into memory.
Execution Order:

Static blocks are executed once when the class is loaded by the JVM.
After the static block, the main method or other program logic is executed.

#### **Why it's used?**
To ensure that static variables are initialized only once for the entire class.

#### **What it does?**
Static variables are initialized when the class is loaded by the JVM and remain the same across all instances.

#### **How it works?**
You can initialize static variables in a static block or directly at the point of declaration.

---

### 9. **Instance vs Static**

#### **What is it?**
Instance members are tied to an object, whereas static members are tied to the class itself.

#### **Why it's used?**
Use instance members when data is unique to an object, and static members when the data should be shared across all objects of the class.

#### **What it does?**
Instance members can only be accessed through an object, while static members can be accessed without creating an object.

#### **How it works?**
- Instance members require an object for access.
- Static members can be accessed directly using the class name.

---

### 10. **Inner Classes**

#### **What is it?**
An inner class is a class defined within another class.

#### **Why it's used?**
Used for logically grouping classes that are only used in one place, improving encapsulation.

#### **What it does?**
It allows the inner class to access the members (including private members) of the outer class.

#### **How it works?**
- **Non-static inner classes**: These can access both static and non-static members of the outer class.
- **Static nested classes**: These can only access static members of the outer class.

---

### 11. **Singleton**
#### **What is Singleton?**
The Singleton pattern ensures that only one object of a class is created and provides a global way to access that object. It is useful when you need a single, shared instance to manage something across the entire application.

#### **Why Use Singleton?**
- To control access to shared resources (e.g., database connections, configuration settings).
- To ensure consistent behavior with a single instance.
- To reduce memory usage by preventing multiple object creation
---

