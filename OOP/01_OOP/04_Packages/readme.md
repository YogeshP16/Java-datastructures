### Flashcard: **Java Packages**

---

#### **What is a Package in Java?**  

- **Definition**: A container (folder) for classes and interfaces that organizes code and prevents naming conflicts.  
- **Key Roles**:  
  - Acts as a **namespace** to avoid class name collisions.  
  - Provides **visibility control** (public/private access).  

---

#### **How Packages Work**   

1. **Defining**: Use the `package` keyword at the top of the file.  
   ```java
   package MyPackage;
   ```  
2. **Structure**: Directory matches package hierarchy (e.g., `java/awt/image`).  
3. **Importing**: Use `import` to include classes.  
   ```java
   import MyPackage.MyClass;
   ```  
4. **Classpath**: Java searches for packages via the current directory, `CLASSPATH`, or `-classpath`.  

**Example**:  
```java
package MyPackage;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}
```  
```java
import MyPackage.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
    }
}
```

---

#### **What are the Built-in Java Packages?**  

1. **`lang` -> Default package**: Core classes like `String`, `Object`, `Math`. Automatically imported.  
2. **`io`**: For input/output operations (e.g., `File`, `BufferedReader`).  
3. **`util`**: Utilities like collections (`ArrayList`, `HashMap`), date/time.  
4. **`applet`**: For applet development (`Applet`, `Graphics`).  
5. **`awt`**: For GUI (`Button`, `Frame`, `Label`).  
6. **`net`**: Networking (`Socket`, `URL`).  

---

####  **Why Use Packages in Java?** 

1. **Organized Code**: Groups related classes together.  
2. **Avoid Naming Conflicts**: Ensures unique class names via namespaces.  
3. **Access Control**: Limits visibility using access modifiers (e.g., `public`, default).  
4. **Reusable Components**: Enables modular development.