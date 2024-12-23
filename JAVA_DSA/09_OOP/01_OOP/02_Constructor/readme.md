### Java Constructor: 

1. **What is a Constructor?**  
   - A constructor is a special method in Java used to initialize an object when it is created. It shares the same name as the class and has no return type. 
   - Private Constructor --> yes,class can have private constructor, objects cannot be created from another class using private constructor

2. **Why is it Used?**  
   - To set initial values for object properties.  
   - To execute any setup logic required when an object is instantiated.  

3. **What Does it Do?**  
   - Initializes an object’s fields.  
   - Provides flexibility to set values during object creation.  

4. **How it Works?**  
   - **Default Constructor**: If no constructor is defined, Java provides a default constructor with no arguments.  
     ```java
     public class Example {
         Example() { 
             System.out.println("Default Constructor Called");
         }
     }
     Example obj = new Example();
     ```
   - **Creating Constructors**: Define constructors manually if specific initialization is needed.
     ```java
     public class Example {
         int value;
         Example(int v) { 
             value = v;
         }
     }
     Example obj = new Example(10);
     ```
   - **Using `this` Keyword**:  
     - Used to refers current object & instance variable.  
     - Can resolve naming conflicts between parameters and fields.  

     ```java
     public Example(int value) {
         this.value = value; 
     }
     ```

5. **Constructor Overloading**  
   Multiple constructors in a class with different parameter lists provide flexibility in object initialization.  
   ```java
   public class Example {
       Example() { }
       Example(int value) { }
       Example(String name, int value) { }
   }
   ```

6. **Calling a Constructor from Another Constructor**  
   Use `this()` to call another constructor in the same class.  
   ```java
   public class Example {
       Example() { 
           this(10); 
       }
       Example(int value) { 
           System.out.println("Value: " + value);
       }
   }
   ```
7. **Why Default constructor**
    - **Automatic Object Creation:**
        If no constructor is defined in the class, Java provides a default constructor, allowing objects to be instantiated without manually writing a constructor.
        It simplifies object creation when initialization is not required.

    - **Initialization of Object:**
        The default constructor initializes instance variables to their default values (e.g., null, 0, false), ensuring that the object is in a valid state.

### Why Not Use `new` Keyword for Primitives?  
   Primitive types (`int`, `float`, etc.) are not objects; they are stored directly in memory. Using `new` is unnecessary and inefficient for primitives.  

### Memory Allocation of `new` Keyword  
   - When `new` is used, memory for the object is allocated on the **heap**.  
   - Primitive values, however, are stored in the **stack** for local variables or directly within objects/arrays.  

