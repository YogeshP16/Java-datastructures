
### **Method Reference in Java**
- A method reference is used to refer method to functional interface. easy form of lambda expression
- Converting lambda expression to method reference by double quotient ` :: `
- It refers to an existing method by name and is used primarily to make the code more readable.

#### **Syntax:**
`ClassName::methodName` or `objectName::methodName`

#### **Types of Method References:**
1. **Static Method Reference**:
   - Refers to a **static** method of a class.
   - Syntax: `ClassName::staticMethod`
   - Example: `Math::max`

2. **Instance Method Reference on a Specific Object**:
   - Refers to an **instance method** of an object.
   - Syntax: `objectName::instanceMethod`
   - Example: `myObject::doSomething`

3. **Instance Method Reference on an Instance of a Class**:
   - Refers to an **instance method** on an instance of a class.
   - Syntax: `ClassName::instanceMethod`
   - Example: `String::toUpperCase`

4. **Constructor Reference**:
   - Refers to a **constructor**.
   - Syntax: `ClassName::new`
   - Example: `ArrayList::new`

#### **Example of Method Reference:**

```java
import java.util.function.Consumer;

public class MethodReferenceExample {
    // A simple method that prints a string.
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        // using Lambda Expression
        Consumer<String> consumer = (String message) -> sysout(message)
        consumer.accept("hello");

        // Using a method reference to refer to the static method printMessage
        Consumer<String> consumer = MethodReferenceExample::printMessage;
        consumer.accept("Hello, World!");
    }
}
```

**Explanation:**
- `MethodReferenceExample::printMessage` is a **method reference** to the `printMessage` method.
- The `Consumer<String>` interface is used to accept a string and print it.

#### **When to Use:**
- Use **method references** when the lambda expression simply calls a method without modification.
- They are more concise and **readable** than lambda expressions, especially when the method being called already exists.

---

### **Key Benefits:**
- **Simplification**: Reduces boilerplate code, especially in cases where lambda expressions are only calling a method.
- **Readability**: Increases readability by eliminating unnecessary lambda syntax.

### **Example of Types:**

1. **Static Method Reference**:
   ```java
   // Lambda: (x, y) -> Math.max(x, y)
   Comparator<Integer> comparator = Math::max;  // Method Reference
   ```

2. **Instance Method Reference**:
   ```java
   // Lambda: s -> s.toUpperCase()
   Function<String, String> upperCaseFunction = String::toUpperCase;
   ```

3. **Constructor Reference**:
   ```java
   // Lambda: () -> new ArrayList<>()
   Supplier<List<String>> supplier = ArrayList::new;
   ```

---

### **Summary:**
- **Method Reference** is shorthand for calling a method directly.
- It makes code **cleaner and more readable** while referring to methods or constructors.
