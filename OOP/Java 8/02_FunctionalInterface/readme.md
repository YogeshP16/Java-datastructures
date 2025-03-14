### **Functional Interface** in Java:

- A **Functional Interface** is an interface that has **only one abstract method** and can have **multiple default or static methods**. It is designed to be implemented using **lambda expressions**.
- If you need a single **behavior** to be passed around (like a task to execute), use a **Functional Interface**.

- **Example**:
  ```java
  @FunctionalInterface
  interface Task {
      void execute();  // Single abstract method
  }
  ```

- **Key Characteristics**:
   1. It must have **exactly one abstract method**.
   2. It can have **multiple default** or **static methods**.
   3. Can be annotated with `@FunctionalInterface` (optional but helps for clarity).
   4. Supports **lambda expressions** to provide a clear and concise way to represent a function or behavior.

- **Recognizing a Functional Interface**:
   - If an interface has **one abstract method**, it is a **Functional Interface**.
   - The **`@FunctionalInterface` annotation** is a marker used to indicate that the interface is intended to be functional, but it’s not mandatory.

---

### **Examples of Functional Interfaces**:
1. `Runnable` – Defines a task that can be run.
2. `Comparator` – Defines a method for comparing two objects.
3. `Consumer` – Defines a method that accepts an argument and returns no result.
4. `Supplier` – Defines a method that supplies a result with no input.

---

### **Why use a Functional Interface?**
- **Compactness**: It allows you to represent a method's implementation using lambda expressions.
- **Encapsulation**: Helps encapsulate a single action (or task) that can be passed around as a parameter or returned from a method.

---

### **Predefined Functional Interfaces in Java**  

**1. `Predicate<T>`** → Takes `T`, returns `boolean` (Used for filtering)  
```java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

**2. `Function<T, R>`** → Takes `T`, returns `R` (Used for transformations)  
```java
Function<String, Integer> length = s -> s.length();
```

**3. `Consumer<T>`** → Takes `T`, returns `void` (Used for actions)  
```java
Consumer<String> print = s -> System.out.println(s);
```

**4. `Supplier<T>`** → Takes nothing, returns `T` (Used for lazy initialization)  
```java
Supplier<Double> random = Math::random;
```

**5. `BiFunction<T, U, R>`** → Takes `(T, U)`, returns `R` (Used for combining two inputs)  
```java
BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
```


---

