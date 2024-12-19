### Object Class 
- Object class is the root class of the Java class hierarchy. Every class in Java inherits from Object (either directly or indirectly)

1. **`toString()` Method**  
   - **What**: Returns a string representation of the object.  
   - **Why**: Useful for debugging and logging.  
   - **How**: Can be overridden to provide custom string representation.

2. **`finalize()` Method**  
   - **What**: Called by the garbage collector before the object is destroyed.  
   - **Why**: To clean up resources before object destruction.  
   - **How**: Rarely used, can be overridden for cleanup tasks.

3. **`hashCode()` Method**  
   - **What**: Returns a unique integer value for the object.  
   - **Why**: Used in hash-based collections like `HashMap`.  
   - **How**: Can be overridden to provide a custom hash value.

4. **`equals()` Method**  
   - **What**: Compares two objects for equality.  
   - **Why**: To determine if two objects are logically equal.  
   - **How**: Can be overridden to define custom equality logic.

5. **`instanceof` Operator**  
   - **What**: Checks if the object belongs to a class, subclass, or implements an interface. 
   - **Why**: Useful for type checking in conditional statements.  
   - **How**: Returns `true` if the object is of the specified type or a subclass.

6. **`getClass()` Method**  
   - **What**: Returns the `Class` object associated with the runtime class of the object.  
   - **Why**: To obtain the class information at runtime.  
   - **How**: `object.getClass()` returns the class type.