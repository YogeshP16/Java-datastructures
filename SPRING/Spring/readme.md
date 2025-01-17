
---

### **What is IoC?**

- **Definition**: 
  - **IoC** is a design principle where the control of object creation and dependency management is handed over to a container (Spring IoC container).
  - 
  
- **Purpose**:
  - Achieve **loose coupling**.
  - Simplify **object lifecycle management**.
  - Enable **flexible** and **maintainable applications**.

---

### **How Does IoC Work in Spring?**

- The **Spring IoC container** (either `BeanFactory` or `ApplicationContext`) manages the lifecycle and configuration of **beans**.
- **Dependency Injection (DI)** is used to inject dependencies into beans.

---

#### **Before IoC:**

- Manual object creation and lifecycle management.
- **Tight coupling** between classes (e.g., changing `Sim sim = new Jio()` to `Sim sim = new Airtel()` would require modifying the source code).
- Difficult to switch implementations or manage dependencies.
- Manual management of the object lifecycle.

---

#### **After IoC:**

- **Loose Coupling**: Beans (objects) are configured externally (e.g., in `beans.xml`) instead of hardcoded in the source code.
- **Centralized Management**: Dependencies and beans are managed in a single place.
- **Improved Flexibility**: You can change implementations by updating the configuration (XML or Java) without modifying the code itself.

---

### **Spring Bean**
- **Definition**: A **bean** is an object that is managed by the **IoC container** in the Spring framework.
- **Purpose**: Beans represent the components of your application that are defined in Spring's configuration.
- **Configuration Options**: Beans can be configured in XML, using Java code, or with annotations.

---

### **IoC Container**

#### **1. BeanFactory**
- **Basic container** and an interface in Spring framework.
- Does **not support annotation-based configuration**; configuration must be done via XML.
- Supports **lazy initialization**, meaning beans are only created when requested.
- Suitable for **simple applications**.

#### **2. ApplicationContext**
- **Advanced container** that is a sub-interface of `BeanFactory`.
  - Provides **eager initialization**, meaning beans are created at startup.
  - Supports additional features like **AOP**, **event propagation**, and **internationalization**.
  - Recommended for **enterprise applications**.

---

### **Dependency Injection (DI)**  
- **Definition**: **DI** is a technique where the **IoC container** provides the required dependencies (objects) to a class at runtime.  
- **From XML/Java Config to Class Object**: The objects (beans) defined in the configuration file (XML or Java) are injected into the class object via its constructor or setter methods (this is Dependency Injection).  

---

### **Types of Dependency Injection**

#### **1. Constructor Injection**
- Dependencies are injected through the class constructor.
- Ensures **mandatory dependencies** are provided when the object is created.
- Example: The required objects (dependencies) are passed through the constructor and provided by the Spring IoC container (via XML configuration or Java annotations) when the bean is created.

#### **2. Setter Injection**
- Dependencies are injected into the bean via setter methods after the object is constructed.
- Suitable for **optional dependencies**.
- Dependencies can be set after the object is created.

#### **3. Field Injection** *(Less Recommended)*
- Dependencies are directly injected into fields using annotations like `@Autowired`.
- This method is **not ideal for unit testing** because there is no constructor-based initialization.

---

### **Bean Lifecycle**
- The lifecycle of a bean is **managed by the Spring container**.
- when we run the program first spring container will started then container creates instances of bean as per the request then the dependencies are inject and finally the bean is destroyed when the spring container is closed.

---

#### **Lifecycle Steps**  
1. **Bean Instantiation**: The bean is created by the container.  
2. **Dependency Injection**: The required dependencies are injected into the bean.  
3. **Custom Initialization**: Custom initialization logic is executed using `@PostConstruct` or `init-method`.  
4. **Bean Usage**: The bean is used in the application.  
5. **Custom Destruction**: Cleanup logic is executed using `@PreDestroy` or `destroy-method`.

---

#### **Lifecycle Methods**
1. **@PostConstruct**: Executes custom logic after dependencies are injected.
2. **@PreDestroy**: Executes custom logic before the bean is destroyed.

---

### **Bean Scope**  
- **Types of Scopes**:

1. **Singleton** *(Default)*:
   - A **single instance** is created per container.

2. **Prototype**:
   - A **new instance** is created for each request.

3. **Request** *(Web applications)*:
   - A **new instance** is created for each **HTTP request**.

4. **Session** *(Web applications)*:
   - A **new instance** is created for each **HTTP session**.

5. **GlobalSession** *(Portlets)*:
   - A **new instance** is created for each **global HTTP session**.

---

### **Ways to Create Spring Beans or Bean Configuration**  
- **XML Configuration**: Define beans in the `beans.xml` file.
- **@Component Annotation**: Automatically detect and register beans using `@Component`.
- **@Bean Annotation**: Define beans within a `@Configuration` class using `@Bean`.


---

#### **Method 1: Creating Beans Inside an XML Configuration File**  
- Define the bean in the `beans.xml` file with the `<bean>` tag, specifying the class and its properties.

**Example (XML)**:
```xml
<bean id="studentAmiya" class="Student"></bean>
```

---

#### **Method 2: Using `@Component` Annotation**  
- Annotate the class with `@Component` to automatically register the bean.
- Optionally, specify a name for the bean using `@Component("beanName")`.

**Example (Java)**:
```java
@Component("collegeBean")
public class College {
    public void test() {
        System.out.println("Test College Method");
    }
}
```

---

#### **Method 3: Using `@Bean` Annotation**  
- Define a `@Configuration` class with methods annotated with `@Bean` to create the bean.
- The method name will become the **bean ID**.

**Example (Java)**:
```java
@Configuration
public class CollegeConfig {
    @Bean
    public College collegeBean() {
        return new College();
    }
}
```

---

### **Spring IoC with Constructor Injection**

#### **Step 1: Interface and Implementation**
##### **Sim Interface**  
```java
public interface Sim {
    void calling();
    void data();
}
```

##### **Jio Implementation**
```java
public class Jio implements Sim {
    @Override
    public void calling() {
        System.out.println("Jio Calling");
    }

    @Override
    public void data() {
        System.out.println("Jio Data");
    }
}
```

---

#### **Step 2: Dependent Class**
##### **Mobile Class**
```java
public class Mobile {
    private Sim sim; // Dependency

    // Constructor for Dependency Injection
    public Mobile(Sim sim) {
        this.sim = sim;
    }

    public void useSim() {
        sim.calling();
        sim.data();
    }
}
```

---

#### **Step 3: XML Configuration**
##### **beans.xml**
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Bean for Jio Implementation -->
    <bean id="jio" class="Jio"></bean>

    <!-- Bean for Mobile with Constructor Injection -->
    <bean id="mobile" class="Mobile">
        <constructor-arg ref="jio"/>
    </bean>

</beans>
```

---

#### **Step 4: Main Class**
##### **Main.java**
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the Mobile bean
        Mobile mobile = context.getBean("mobile", Mobile.class);

        // Use the Mobile bean
        mobile.useSim(); // Output: Jio Calling, Jio Data
    }
}
```

---

### **Spring Setter Dependency Injection (SDI)**

#### **Example Code for Setter Injection:**

##### **1. Student Class (Needs MathCheat Dependency via Setter)**
```java
public class Student {
    private int id;
    private MathCheat mathCheat;

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Setter for mathCheat
    public void setMathCheat(MathCheat mathCheat) {
        this.mathCheat = mathCheat;
    }

    public void cheating() {
        System.out.println("My ID is: " + id);
        mathCheat.mathCheating();
    }
}
```

##### **2. MathCheat Class (Provides Dependency)**
```java
public class MathCheat {
    public void mathCheating() {
        System.out.println("And I Have Stated Math Cheating");
    }
}
```

---

##### **3. XML Configuration (`beans.xml`) for Setter Injection:**
```xml
<bean id="student" class="Student">
    <property name="id" value="101"/>
    <property name="mathCheat">
        <bean class="MathCheat"></bean>
    </property>
</bean>
```

---

##### **4. Main Class to Run the Program**
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = context.getBean("student", Student.class);
        student.cheating();
    }
}
```

---

