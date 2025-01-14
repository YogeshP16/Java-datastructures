# Spring IoC (Inversion of Control) 

## **1. What is IoC?**
- **Definition**: IoC is a design principle where the control of object creation and dependency management is transferred from the application code to a container (Spring IoC container).
- **Purpose**:
  - To achieve **loose coupling**.
  - Simplifies object lifecycle management.
  - Enables flexible and maintainable applications.

## **2. How Does IoC Work in Spring?**
- The Spring IoC container (either `BeanFactory` or `ApplicationContext`) manages the lifecycle and configuration of beans.
- Dependencies are injected into beans using **Dependency Injection (DI)**.


### **Before IoC:**
    - Manual object creation and lifecycle management. 
    - Tight coupling between classes (e.g., changing Sim sim = new Jio() to Sim sim = new Airtel() required modifying source code).
    - Difficult to switch implementations or manage dependencies.
    - Manual object lifecycle management.

### **After IoC:**
    - Loose Coupling:  Objects (beans) are configured externally (e.g., beans.xml) instead of hardcoded in the source code.
    - Centralized Management: Dependencies and beans are managed in one place.
    - Improved Flexibility: Change implementation by updating XML/Java configuration without modifying code.

---

## **3. Core Concepts**
### **Spring Bean**
- **Definition**: A bean is an object managed by the IoC container.
- **Purpose**: Represent application components defined in Spring configuration.
- **Configuration Options**: XML, Java-based, or annotations.

### **IoC Container**
#### **1. BeanFactory**
- Basic container, an interface in spring framework, it does not support annotation based configuration, bean configuration to be done in XML.
- **Lazy initialization** (beans are created only when requested).
- Suitable for simple applications.

#### **2. ApplicationContext**
- Advanced container with additional features:
- Sub-interface of beanfactory
  - **Eager initialization** (beans are created at startup).
  - Support for AOP, event propagation, and internationalization.
  - Recommended for enterprise applications.

---

## **4. Dependency Injection (DI)**
- DI is a technique where the IoC container provides the required dependencies (objects) to a class during runtime.
- From XML/Java Config to Class Object: The objects (beans) defined in the XML file are injected into the class object via its constructor/setter (this is Dependency Injection).

### **Types of Dependency Injection**
#### **1. Constructor Injection**
- Inject dependencies through the class constructor.
- Ensures mandatory dependencies are provided at object creation.
- example: The constructor of the class is used to receive the required objects (dependencies). These objects are provided by the Spring IoC container (via XML configuration or Java annotations) when the bean is created.

#### **2. Setter Injection**
- A method of injecting dependencies into a Spring-managed bean via setter methods after the object is constructed.
- Suitable for optional dependencies.
- Allows setting dependencies after object creation.

#### **3. Field Injection** *(Less Recommended)*
- Dependencies are directly injected into fields using annotations (e.g., `@Autowired`).
- Not ideal for unit testing due to lack of constructor-based initialization.

---

## **5. Bean Lifecycle**
- managed by spring container

### **Lifecycle Steps**
- when we run the program first spring container will started then container creates instances of bean as per the request then the dependencies are inject and finally the bean is destroyed when the spring container is closed.

1. **Bean instantiation** : Bean is created by the container.
2. **Dependency injection** : Dependencies are injected.
3. **Custom initialization** : Custom initialization logic using(`@PostConstruct` or `init-method`).
4. **Bean usage** : Bean is used in the application
5. **Custom destruction** : Clean-up logic using (`@PreDestroy` or `destroy-method`).

### **Lifecycle Methods:**
1. **@PostConstruct**: Executes custom logic after dependency injection.
2. **@PreDestroy**: Executes custom logic before bean destruction.

---

## **6. Bean Scope**
### **Types of Scopes**

1. **Singleton** *(Default)*:
- A single instance is created per container.
2. **Prototype**:
- A new instance is created for every request.
3. **Request** *(Web applications)*:
- A new instance is created for each HTTP request.
4. **Session** *(Web applications)*:
- A new instance is created for each HTTP session.
5. **GlobalSession** *(Portlets)*:
- A new instance is created for each global HTTP session.

---

## **Ways to create spring beans**
- **XML Configuration**: Define the bean in the `beans.xml` file.
- **@Component Annotation**: Use `@Component` to automatically detect and register the bean.
- **@Bean Annotation**: Use `@Bean` within a `@Configuration` class to define beans.

**Method 1: Creating Bean Inside an XML Configuration File**
- Define a bean in `beans.xml` with `<bean>` tag, specifying the class and its properties.

**Example (XML)**:
```xml
<bean id="studentAmiya" class="Student"></bean>
```

---

**Method 2: Using @Component Annotation**
- Annotate the class with `@Component` to register the bean.
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

**Method 3: Using @Bean Annotation**
- Define a `@Configuration` class with methods annotated with `@Bean` to create the bean.
- The method name becomes the bean id.

**Example (Java)**:
```java
@Configuration
public class CollegeConfig {
    @Bean
    public College collegeBean() {
        return new College();
    }
}

---
## **7. Example: Spring IoC with Constructor Injection**
### **Step 1: Interface and Implementation**
#### **Sim Interface**
```java
public interface Sim {
    void calling();
    void data();
}
```

#### **Jio Implementation**
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

### **Step 2: Dependent Class**
#### **Mobile Class**
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

### **Step 3: XML Configuration**
#### **beans.xml**
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

### **Step 4: Main Class**
#### **Main.java**
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

## **Spring Setter Dependency Injection (SDI)**:

**Example Code for Setter Injection:**

1. **Student Class (Needs MathCheat Dependency via Setter):**
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

2. **MathCheat Class (Provides Dependency):**
```java
public class MathCheat {
    public void mathCheating() {
        System.out.println("And I Have Stated Math Cheating");
    }
}
```

3. **XML Configuration (`beans.xml`) for Setter Injection:**
```xml
<bean id="student" class="Student">
    <property name="id" value="101"/>
    <property name="mathCheat">
        <bean class="MathCheat"></bean>
    </property>
</bean>
```

4. **Main Class to Run the Program:**
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






