### SOLID Principles 

1. **SRP (Single Responsibility Principle)**  
   - A class should have one job.  
   - Makes code easier to maintain.

2. **OCP (Open/Closed Principle)**  
   - Classes should be open for extension, closed for modification.  
   - Allows adding features without changing existing code.

3. **LSP (Liskov Substitution Principle)**  
   - Subclasses should replace parent classes without errors, breaking functionality or logic.  
   - Ensures subclasses behave as expected.

4. **ISP (Interface Segregation Principle)**  
   - Don't force a class to implement unused methods.  
   - Keeps interfaces simple and focused.

5. **DIP (Dependency Inversion Principle)**  
   - High-level modules depend on abstractions, not concrete classes.  
   - Reduces tight coupling and improves flexibility.


## 1. Single Responsibility Principle (SRP)
- **What**: A class should only have one job or responsibility.
- **Why**: Makes code easier to maintain and understand.
- **Benefit**: Reduces confusion and prevents changes from affecting multiple areas.

### Bad Design:
```java
class UserManager {
    public void createUser(String name, String email) {
        // create user logic
    }
    
    public void sendEmail(String email) {
        // send email logic
    }
}
```
- The class has two responsibilities: creating users and sending emails.

### Good Design:
```java
class UserManager {
    public void createUser(String name, String email) {
        // create user logic
    }
}

class EmailService {
    public void sendEmail(String email) {
        // send email logic
    }
}
```
- Separated responsibilities into two classes.

---

## 2. Open/Closed Principle (OCP)
- **What**: Classes should be open for new features but closed for changes.
- **Why**: Allows extending code without modifying existing code.
- **Benefit**: Reduces bugs by preventing unnecessary changes.

### Bad Design:
```java
class DiscountCalculator {
    public double calculateDiscount(Order order) {
        if (order.getType() == "Standard") {
            return 0.1;
        } else if (order.getType() == "VIP") {
            return 0.2;
        }
        return 0.0;
    }
}
```
- Directly modifying the class for every new type of discount.

### Good Design:
```java
interface DiscountStrategy {
    double calculateDiscount(Order order);
}

class StandardDiscount implements DiscountStrategy {
    public double calculateDiscount(Order order) {
        return 0.1;
    }
}

class VIPDiscount implements DiscountStrategy {
    public double calculateDiscount(Order order) {
        return 0.2;
    }
}

class DiscountCalculator {
    private DiscountStrategy discountStrategy;

    public DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(Order order) {
        return discountStrategy.calculateDiscount(order);
    }
}
```
- Use interfaces to add new discount strategies without changing the `DiscountCalculator` class.

---

## 3. Liskov Substitution Principle (LSP)
- **What**: A subclass should be able to replace its parent class without errors.
- **Why**: Ensures subclasses don't break parent class behavior.
- **Benefit**: Guarantees that derived classes will behave as expected.

### Bad Design:
```java
class Bird {
    public void fly() {
        // fly logic
    }
}

class Ostrich extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}
```
- Ostrich violates LSP by overriding the method in a way that breaks behavior.

### Good Design:
```java
class Bird {
    public void move() {
        // move logic
    }
}

class Sparrow extends Bird {
    public void move() {
        // fly logic
    }
}

class Ostrich extends Bird {
    public void move() {
        // walk logic
    }
}
```
- Subclasses correctly override `move()` to maintain consistent behavior.

---

## 4. Interface Segregation Principle (ISP)
- **What**: Don't force a class to implement methods it doesn't need.
- **Why**: Keeps interfaces simple and focused.
- **Benefit**: Reduces unused code and simplifies maintenance.

### Bad Design:
```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        // robot working
    }

    public void eat() {
        throw new UnsupportedOperationException("Robot cannot eat");
    }
}
```
- Robot is forced to implement `eat()` even though it's not relevant.

### Good Design:
```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() {
        // robot working
    }
}

class Human implements Workable, Eatable {
    public void work() {
        // human working
    }
    
    public void eat() {
        // human eating
    }
}
```
- Interfaces are split into more relevant responsibilities.

---

## 5. Dependency Inversion Principle (DIP)
- **What**: High-level code should not depend on low-level code. Both should depend on abstractions.
- **Why**: Makes code more flexible and easier to test.
- **Benefit**: Reduces tight coupling between modules and allows for easier changes.

### Bad Design:
```java
class UserService {
    private Database database = new Database();

    public void saveUser(User user) {
        database.save(user);
    }
}
```
- `UserService` is tightly coupled to `Database`.

### Good Design:
```java
interface Storage {
    void save(User user);
}

class Database implements Storage {
    public void save(User user) {
        // save to database
    }
}

class UserService {
    private Storage storage;

    public UserService(Storage storage) {
        this.storage = storage;
    }

    public void saveUser(User user) {
        storage.save(user);
    }
}
```
- `UserService` depends on the `Storage` abstraction, not a specific implementation.

---
#### **When to apply**

When to apply SRP: Developers think about separating concerns. If a class is doing too much (e.g., handling both business logic and external services), it’s time to split it into smaller classes, each with a single responsibility.

When to apply OCP: If a class might need to be extended in the future (e.g., adding new functionality), consider designing it to be open for extension (through interfaces or abstract classes) and closed for modification.

When to apply LSP: When subclassing, ensure that the subclass can be used interchangeably with the parent class without altering the expected behavior of the system.

When to apply ISP: If a class or interface has methods that won’t be used by all implementations, break it into smaller, more specific interfaces.

When to apply DIP: Always prefer abstractions over concrete implementations. This helps in making the code more flexible and testable.
