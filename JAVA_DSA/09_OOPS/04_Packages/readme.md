### Java Packages:

A **package** in Java is a container(folders) that organizes classes and helps avoid naming conflicts. It acts as both a **namespace** and a **visibility control** mechanism.

#### Key Points:
- **Namespace**: Packages prevent class name collisions. For example, you can have `List` in your package without conflict with other `List` classes in different packages.
- **Visibility**: Only **public** classes, methods, or fields are accessible outside their package. Others are restricted to the package.
- **Hierarchy**: Packages are hierarchical. For example, `java.awt.image` must be stored in the `java/awt/image` directory on the file system.

#### How It Works:
1. **Defining a Package**:  
   At the top of your Java file, use the `package` keyword to declare it belongs to a package:
   ```java
   package MyPackage;
   ```

2. **Folder Structure**:  
   Java uses directories to store package classes. For `package MyPackage;`, the file must be stored in a folder named `MyPackage`. The folder structure mirrors the package hierarchy.

3. **Importing Packages**:  
   To use a class from another package, you import it using the `import` statement:
   ```java
   import MyPackage.MyClass;
   ```

4. **Classpath**:  
   The **Java runtime** finds packages:
   - From the current directory.
   - By setting the **CLASSPATH** environment variable.
   - By using the **-classpath** option with `javac` or `java`.

### Example:
```java
// File: MyClass.java inside MyPackage folder
package MyPackage;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}
```

To use this class:
```java
// File: Main.java
import MyPackage.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.display();
    }
}
```

### Summary:
- **Packages** keep class names unique and control access.
- Java packages reflect the file system directory structure.
- Only **public** elements are accessible from outside their package.

### In-built Java Packages

1. **`lang` package**  
   - **What**: Basic classes like `String`, `Object`, `Math`, `System`, `Thread`.  
   - **Why**: Essential for core Java functionality.  
   - **What it does**: Provides fundamental tools for data types, system operations, and multithreading.  
   - **How**: Automatically imported, no need for explicit inclusion.

2. **`io` package**  
   - **What**: Classes for input/output operations.  
   - **Why**: To handle file I/O and data streams.  
   - **What it does**: Classes like `File`, `BufferedReader`, `InputStream`, `FileReader`.  
   - **How**: Manages reading/writing data using streams.

3. **`util` package**  
   - **What**: Utility classes for collections, date/time, etc.  
   - **Why**: To manage data structures and utilities.  
   - **What it does**: Classes like `ArrayList`, `HashMap`, `Date`, `Random`.  
   - **How**: Provides collection handling and data manipulation.

4. **`applet` package**  
   - **What**: Classes for applet development.  
   - **Why**: For creating small applications in browsers.  
   - **What it does**: Classes like `Applet`, `AudioClip`, `Graphics`.  
   - **How**: Enables GUI and media handling in applets.

5. **`awt` package**  
   - **What**: Classes for GUI development.  
   - **Why**: For creating windowed applications.  
   - **What it does**: Classes like `Frame`, `Button`, `Label`, `TextField`.  
   - **How**: Handles GUI components and events.

6. **`net` package**  
   - **What**: Classes for network communication.  
   - **Why**: To enable internet and server communication.  
   - **What it does**: Classes like `Socket`, `ServerSocket`, `URL`.  
   - **How**: Manages network connections and data transfer.