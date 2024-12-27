### **Exception Handling in Java**

---

#### **What it is**  
Abnormal terminations occurs during program execution.
A mechanism to manage runtime errors and maintain normal program flow.

---

#### **Why it's used**  
- To handle errors gracefully without crashing the program.  
- To separate error-handling logic from regular code.  

---

#### **What it does**  
- Catches runtime errors and allows custom handling.  
- Provides feedback or alternatives for unexpected behavior.  

---

#### **What problem it solves**  
- Prevents abrupt program termination.  
- Makes code robust, user-friendly, and maintainable.  

---

#### **How it works**  
- Errors are thrown using exceptions.  
- Try-Catch blocks handle these exceptions.  
- Can define custom exceptions for specific scenarios.  

---

### **Error vs Exception**

| Aspect          | Error                          | Exception                      |
|-----------------|--------------------------------|--------------------------------|
| Severity        | Serious issue, unrecoverable  | Less severe, recoverable      |
| Examples        | `OutOfMemoryError`            | `IOException`, `SQLException` |
| Handling        | Not usually handled in code   | Handled via try-catch blocks  |

---

### **Types of Exceptions**

1. **Checked Exceptions**  
   - Compile-time checked.  
   - Example: `IOException`, `SQLException`.  

2. **Unchecked Exceptions**  
   - Runtime errors.  
   - Example: `NullPointerException`, `ArithmeticException`.  

3. **Error (Not Exceptions)**  
   - Critical issues.  
   - Example: `StackOverflowError`.  

---

### **Exception Handling Keywords**

1. **try**  
   Block to test code for exceptions.

2. **catch**  
   Block to handle the exception.

3. **finally**  
   Always executes, used for cleanup.

4. **throw**  
   Explicitly throw an exception.

5. **throws**  
   Declares exceptions a method might throw.

---

### **Creating Custom Exceptions**

#### Steps:
1. Extend `Exception` or `RuntimeException`.
2. Add constructors.
3. Use `throw` to trigger it.

#### Example:
```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```
### **Types of Checked Exceptions in Java**  

Checked exceptions are **checked at compile time**. The compiler ensures they are either caught or declared using the `throws` keyword.  

---

#### **1. IOException**  
- **What it is**: Thrown when an I/O operation fails or is interrupted.  
- **Common Causes**:  
  - File not found.  
  - Issues with file reading/writing.  
- **Example**:  
```java
import java.io.File;
import java.io.FileReader;

FileReader reader = new FileReader(new File("nonexistent.txt")); // Throws IOException
```

---

#### **2. SQLException**  
- **What it is**: Thrown when there is a database access error or SQL query issue.  
- **Common Causes**:  
  - Invalid database URL.  
  - Syntax errors in SQL.  
- **Example**:  
```java
import java.sql.Connection;
import java.sql.DriverManager;

Connection conn = DriverManager.getConnection("invalid-url", "user", "pass"); // Throws SQLException
```

---

#### **3. ClassNotFoundException**  
- **What it is**: Thrown when a specified class cannot be found during runtime.  
- **Common Causes**:  
  - Class not in the classpath.  
  - Issues with dynamic loading.  
- **Example**:  
```java
Class.forName("com.example.NonExistentClass"); // Throws ClassNotFoundException
```

---

#### **4. FileNotFoundException**  
- **What it is**: Thrown when attempting to access a file that does not exist.  
- **Common Causes**:  
  - Incorrect file path.  
  - File deleted or unavailable.  
- **Example**:  
```java
import java.io.FileInputStream;

FileInputStream file = new FileInputStream("missing-file.txt"); // Throws FileNotFoundException
```

---

### **Types of UnChecked Exceptions in Java**  

Unchecked exceptions are part of the `RuntimeException` class hierarchy and occur during the execution of the program. These are **not checked** at compile time.

---

#### **1. NullPointerException**  
- **What it is**: Thrown when trying to use a `null` object reference.  
- **Example**: Calling a method on a `null` object.  
```java
String str = null;
str.length(); // Throws NullPointerException
```

---

#### **2. ArithmeticException**  
- **What it is**: Thrown for illegal arithmetic operations.  
- **Example**: Division by zero.  
```java
int result = 10 / 0; // Throws ArithmeticException
```

---

#### **3. ArrayIndexOutOfBoundsException**  
- **What it is**: Thrown when accessing an invalid index of an array.  
- **Example**: Accessing beyond array size.  
```java
int[] arr = {1, 2, 3};
System.out.println(arr[5]); // Throws ArrayIndexOutOfBoundsException
```

---

#### **4. StringIndexOutOfBoundsException**  
- **What it is**: Thrown when accessing an invalid index of a string.  
- **Example**: Substring beyond string length.  
```java
String str = "Hello";
char ch = str.charAt(10); // Throws StringIndexOutOfBoundsException
```

---

#### **5. NumberFormatException**  
- **What it is**: Thrown when converting an invalid string to a number.  
- **Example**: Parsing a non-numeric string.  
```java
int num = Integer.parseInt("ABC"); // Throws NumberFormatException
```

---

#### **6. IllegalArgumentException**  
- **What it is**: Thrown when a method receives an invalid argument.  
- **Example**: Passing negative values where not allowed.  
```java
Thread.sleep(-1000); // Throws IllegalArgumentException
```

---

#### **7. ConcurrentModificationException**  
- **What it is**: Thrown when a collection is modified while iterating.  
- **Example**: Adding/removing elements during iteration.  
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
for (Integer num : list) {
    list.add(4); // Throws ConcurrentModificationException
}
```


---
