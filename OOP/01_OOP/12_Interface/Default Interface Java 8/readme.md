

# **Default Methods in Java**

## **What Are Default Methods?**
- Introduced in Java 8.
- Methods with **default implementations** in **interfaces**.
- Allows adding new methods to interfaces without breaking existing classes.

## **Before Java 8:**
- Adding a method to an interface required **modifying all implementing classes**.
- example refer **Animal.java** interface

## **After Java 8:**
- **Default methods** provide a **default implementation** in the interface.
- Implementing classes are **not required** to implement new methods unless needed.
- refer **Animal2.java** interface

## **Key Benefits:**
- **Backward Compatibility**: Existing classes don’t need to change.
- **Flexibility**: Add new methods to interfaces without breaking old code.
- **Code Evolution**: Extend interfaces without forcing changes in all classes.

## **Usage:**
- Use default methods when you want to **extend interfaces** but maintain compatibility with older implementations.
- Use when **common behavior** can be shared across multiple classes.

## **Example**:
- **Without Default**: New method requires all classes to implement it.
- **With Default**: New method is already implemented in the interface, classes can use it or override it.

---

This is a compact summary of default methods in Java for easy reference.