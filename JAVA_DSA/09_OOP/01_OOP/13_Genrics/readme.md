### **Custom ArrayList**   
A user-defined implementation of the `ArrayList` data structure.    

**What it does**:  
Stores elements dynamically, similar to Java's `ArrayList`, with user-defined methods for adding, removing, and accessing elements.   

### **Problem with Custom ArrayList**  
- Works only with specific data types (e.g., `int`, `String`).  
- Lack of type safety when handling various data types.  

**What it does**:  
Leads to repetitive code or casting issues when extending functionality to multiple data types.  

---

### **Custom ArrayList Using Generics**   
An implementation of `Custom ArrayList` using Java Generics to make it type-safe and reusable for any object type.   
allow a class, interface, or method to operate on various data types without type casting.  
Eliminates the risk of `ClassCastException`.

**What problem it solves**:  
- Avoids the need for casting.  
- Reduces runtime errors caused by type mismatches.  
- Eliminates code duplication for different types.  

**How it works**:  
1. Declare the class with `<T>`.  
2. Use `T` as the type for the internal array and method parameters.  
3. At runtime, `T` is replaced with the actual type specified during object creation.

---

### **Wildcards in generics make lists flexible.**

- **Unbounded Wildcard (`?`)**: Allows any type of student (math, art, sports) in the list without caring about the type.  
- **Upper Bounded Wildcard (`? extends T`)**: Restricts the list to students who are good at math or anything better (like advanced math).  
- **Lower Bounded Wildcard (`? super T`)**: Allows adding students who are at least as good as math students, or better.

