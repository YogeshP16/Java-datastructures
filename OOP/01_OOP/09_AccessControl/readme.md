### Access Control in Java

**What it is**:  
Access control in Java determines how members (fields, methods) of a class can be accessed from other classes.

**Why it's used**:  
It is used to restrict or allow access to class members, ensuring encapsulation, security, and proper class design.

**How it works**:  
Java provides different access modifiers—`public`, `private`, `protected`, and default—each with varying levels of access.

---

### Access Modifiers and Their Visibility

| Modifier    | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | World |
|-------------|-------|---------|---------------------|---------------------|-------|
| **public**  |   +   |    +    |          +          |          +          |   +   |
| **protected**|   +   |    +    |          +          |          +          |       |
| **default** |   +   |    +    |          +          |                     |       |
| **private** |   +   |         |                     |                     |       |

- **`public`**: Accessible anywhere.
- **`protected`**: Accessible within the same package and subclasses.
- **`default`**: Accessible within the same package.
- **`private`**: Accessible only within the same class.

---

### Example

```java
package packageOne;
public class Base {
    protected void display() {
        System.out.println("in Base");
    }
}

package packageTwo;
public class Derived extends packageOne.Base {
    public void show() {
        new Base().display();       // not working
        new Derived().display();    // works
        display();                  // works
    }
}
```

- **`new Base().display();`**: Not allowed because `Base` is in a different package, and protected methods are not accessible outside the package unless accessed through a subclass object.
- **`new Derived().display();`**: Allowed because `Derived` is a subclass of `Base`, so it inherits access to the `protected` method.
- **`display();`**: Allowed because `Derived` is the current class, and `protected` methods can be accessed by instances of subclasses.

---

### Key Points About `protected` Modifier

- **Subclasses can access** the `protected` methods or fields of their superclass, even if the superclass is in a different package.
- **Access through subclass instances**: A `protected` member can be accessed using an instance of the subclass, not the superclass.
- **Cannot access via superclass reference** unless the reference is pointing to an object of a subclass.

---

### Simplified Rule

- **Access to protected members** is allowed when the reference is of the type of the subclass or a class in the same package.  
- For non-subclass objects, even within the same package, `protected` members are not accessible.

