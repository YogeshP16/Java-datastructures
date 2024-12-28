Here’s a README file with real-time examples for common design patterns, including what they solve, their usage, behavior, and short code examples:

---

# Real-Time Design Patterns in Java

This repository demonstrates real-time applications of common design patterns in Java with examples of usage, behavior, and code.

## 1. **Singleton Pattern**

### **What it is**
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.

### **Usage**
This pattern is used when you need to restrict the instantiation of a class to one object. A real-world example is a **Database Connection Pool** where only one instance of the connection manager is used.

### **Behavior**
The class ensures that no new instances are created beyond the initial one, and provides access to the instance globally.

### **Code Example**

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to database...");
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.connect();
    }
}
```

---

## 2. **Factory Pattern**

### **What it is**
The Factory pattern provides an interface for creating objects, but allows subclasses to alter the type of objects that will be created.

### **Usage**
This pattern is useful when creating instances of different types of objects, especially when the class to instantiate is determined at runtime. A real-world example is a **Car Factory** that produces different car models based on input.

### **Behavior**
The Factory method abstracts the instantiation of objects, allowing different types of objects to be created through a common interface.

### **Code Example**

```java
interface Car {
    void drive();
}

class Sedan implements Car {
    public void drive() {
        System.out.println("Driving a Sedan...");
    }
}

class SUV implements Car {
    public void drive() {
        System.out.println("Driving an SUV...");
    }
}

class CarFactory {
    public static Car getCar(String type) {
        if (type.equals("Sedan")) return new Sedan();
        else return new SUV();
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("SUV");
        car.drive();
    }
}
```

---

## 3. **Observer Pattern**

### **What it is**
The Observer pattern allows an object (subject) to notify a list of observers about state changes, without being tightly coupled to them.

### **Usage**
This pattern is useful in event-driven systems where multiple components need to be notified of changes. A real-world example is a **Weather Monitoring System**, where multiple devices (observers) need to be updated when the weather changes.

### **Behavior**
The Subject maintains a list of observers and notifies them when its state changes. Observers can subscribe or unsubscribe as needed.

### **Code Example**

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class MobileApp implements Observer {
    public void update(String message) {
        System.out.println("Mobile App: Weather update - " + message);
    }
}

class DisplayBoard implements Observer {
    public void update(String message) {
        System.out.println("Display Board: Weather update - " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileApp mobileApp = new MobileApp();
        DisplayBoard displayBoard = new DisplayBoard();

        station.addObserver(mobileApp);
        station.addObserver(displayBoard);
        
        station.notifyObservers("Rainy, 22°C");
    }
}
```

---

## 4. **Strategy Pattern**

### **What it is**
The Strategy pattern allows a class to change its behavior dynamically by encapsulating algorithms in separate classes.

### **Usage**
This pattern is useful when different behaviors or algorithms can be swapped at runtime. A real-world example is a **Payment System** where different payment methods (Credit Card, PayPal, etc.) can be selected.

### **Behavior**
The context (e.g., PaymentProcessor) delegates the task to one of several interchangeable strategy classes (e.g., CreditCardPayment, PayPalPayment).

### **Code Example**

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}

class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(int amount) {
        strategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(new PayPalPayment());
        processor.processPayment(100);
    }
}
```

---

## 5. **Decorator Pattern**

### **What it is**
The Decorator pattern adds behavior to an object dynamically, without modifying its structure.

### **Usage**
This pattern is useful when you need to add additional responsibilities to objects without altering their code. A real-world example is a **Coffee Shop** where you can add extras like milk or sugar to a basic coffee.

### **Behavior**
The Decorator wraps the original object and extends its functionality while maintaining the original interface.

### **Code Example**

```java
interface Coffee {
    double cost();
}

class BasicCoffee implements Coffee {
    public double cost() {
        return 5.0;
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 2.0;
    }
}

class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 1.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        
        System.out.println("Total cost: " + coffee.cost());
    }
}
```



