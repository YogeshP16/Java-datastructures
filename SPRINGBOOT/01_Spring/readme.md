## **Spring IoC (Inversion of Control)**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Inversion of Control (IoC)** is a core principle of Spring that shifts object creation and dependency management from the developer to the **Spring Container**.  
- Instead of manually creating objects (`new` keyword), Spring **injects dependencies automatically** using **Dependency Injection (DI)**.  
- This makes the application more **loosely coupled**, testable, and maintainable.  

### **2️⃣ R - Reverse (Why Do We Need It?)**  
- **Without IoC (Tightly Coupled Code)**:  
  ```java
  public class Car {
      private Engine engine = new Engine();  // Direct dependency
  }
  ```  
  - **Problems:**  
    ✅ Hard to replace `Engine` with a different implementation.  
    ✅ Hard to test since dependencies are hardcoded.  
- **With IoC (Loosely Coupled Code using DI):**  
  ```java
  public class Car {
      private Engine engine;
      public Car(Engine engine) { this.engine = engine; }  // Injected dependency
  }
  ```  
  ✅ Now `Car` doesn’t create `Engine`; it gets it externally (via Spring IoC).  

### **3️⃣ I - Inspect (How It Works + Code Example)**  

- **Define a Spring Bean (Component Managed by IoC Container):**  
  ```java
  @Component
  public class Engine {
      public void start() { System.out.println("Engine Started!"); }
  }
  ```  
- **Inject Dependency Using `@Autowired`:**  
  ```java
  @Component
  public class Car {
      private final Engine engine;
      
      @Autowired
      public Car(Engine engine) { this.engine = engine; }
      
      public void drive() { engine.start(); }
  }
  ```  
- **Run with Spring Boot (`@SpringBootApplication`)**  
  ```java
  @SpringBootApplication
  public class App {
      public static void main(String[] args) {
          ApplicationContext context = SpringApplication.run(App.class, args);
          Car car = context.getBean(Car.class);
          car.drive();
      }
  }
  ```  
✅ **Spring IoC manages dependencies and provides `Engine` to `Car` automatically!**  

### **4️⃣ M - Modify (Advanced Customization & Optimization)**  
- **Use XML-Based Configuration (Legacy Approach)**:  
  ```xml
  <bean id="engine" class="com.example.Engine"/>
  <bean id="car" class="com.example.Car">
      <constructor-arg ref="engine"/>
  </bean>
  ```  
- **Use Java-Based Configuration (`@Configuration` + `@Bean`)**:  
  ```java
  @Configuration
  public class AppConfig {
      @Bean
      public Engine engine() { return new Engine(); }
      
      @Bean
      public Car car(Engine engine) { return new Car(engine); }
  }
  ```  
- **Best Practices:**  
  ✅ Use `@Component`, `@Service`, `@Repository` for automatic bean discovery.  
  ✅ Prefer Constructor Injection (Immutable & Testable).  
  ✅ Use `@Qualifier` if multiple beans of the same type exist.  

---

## **Spring Bean**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- A **Spring Bean** is an object managed by the **Spring IoC (Inversion of Control) Container**.  
- It is automatically created, configured, and injected where needed.  
- Beans help in **loose coupling** and **dependency injection**.  

### **2️⃣ R - Reverse (Why Do We Need It?)**  
**Without Beans (Manual Object Creation - Tightly Coupled Code):**  
```java
public class Car {
    private Engine engine = new Engine(); // Manually creating an object
}
```  
**Problems:**  
❌ **Hardcoded dependencies** (difficult to replace `Engine`).  
❌ **Not scalable** (cannot manage object lifecycles efficiently).  

**With Beans (Spring-Managed Object - Loosely Coupled Code):**  
```java
@Component
public class Engine { }
```  
```java
@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) { this.engine = engine; }  // IoC container injects Engine
}
```  
✅ **Spring creates & injects the `Engine` bean automatically!**  

---

### **3️⃣ I - Inspect (How It Works + Code Example)**  

#### **1. Defining a Bean Using `@Component` (Annotation-Based Approach - Recommended)**  
```java
@Component  // Marks this class as a Spring Bean
public class Engine {
    public void start() { System.out.println("Engine started!"); }
}
```  

#### **2. Injecting the Bean Using `@Autowired`**  
```java
@Component
public class Car {
    private final Engine engine;

    @Autowired  // Injects the Engine bean automatically
    public Car(Engine engine) { this.engine = engine; }

    public void drive() { engine.start(); }
}
```  

#### **3. Registering Beans Using `@Bean` (Java-Based Configuration - Alternative Approach)**  
```java
@Configuration
public class AppConfig {
    @Bean
    public Engine engine() { return new Engine(); }

    @Bean
    public Car car(Engine engine) { return new Car(engine); }
}
```  

#### **4. Running the Application (Spring Boot Example)**  
```java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        Car car = context.getBean(Car.class);
        car.drive();  // Output: Engine started!
    }
}
```

✅ **Spring automatically creates, manages, and injects the `Engine` bean into `Car`.**  

---

### **4️⃣ M - Modify (Advanced Customization & Optimization)**  

#### **1. Controlling Bean Scope (`@Scope`)**  
By default, Spring beans are **singleton** (one instance per Spring container).  
You can change the scope using `@Scope`:  
```java
@Component
@Scope("prototype") // Creates a new instance every time it's requested
public class Engine { }
```  

#### **2. Using `@Qualifier` for Multiple Beans**  
If multiple beans exist, use `@Qualifier` to specify which one to inject.  
```java
@Component("petrolEngine")
public class PetrolEngine extends Engine { }

@Component("dieselEngine")
public class DieselEngine extends Engine { }

@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(@Qualifier("dieselEngine") Engine engine) { this.engine = engine; }
}
```  

#### **3. Bean Lifecycle Methods (`@PostConstruct` & `@PreDestroy`)**  
```java
@Component
public class Engine {
    @PostConstruct
    public void init() { System.out.println("Engine initialized!"); }

    @PreDestroy
    public void destroy() { System.out.println("Engine destroyed!"); }
}
```

---


## **Spring Bean Scopes & Lifecycle - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  

### **Bean Scope**  
- Defines **how and when** a Spring bean is created and shared within the application.  
- **Common Scopes:**  
  - `singleton` (default) → **One** instance per Spring Container.  
  - `prototype` → **New** instance for every request.  
  - `request`, `session`, `application` → Used in **Web Applications**.  

### **Bean Lifecycle**  
- Defines **how a bean is initialized, used, and destroyed** within the Spring container.  
- **Key Phases:**  
  1. **Instantiation** → Spring creates the bean.  
  2. **Initialization** → Custom setup using `@PostConstruct`.  
  3. **Usage** → Bean is used in the application.  
  4. **Destruction** → Cleanup using `@PreDestroy`.  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without Proper Scoping & Lifecycle**  
❌ **Memory issues** if beans are unnecessarily re-created.  
❌ **Unexpected behavior** if beans are shared incorrectly.  
❌ **Lack of cleanup** leads to resource leaks.  

#### **How Spring Solves It?**  
✅ Provides **scopes** to optimize memory & resource usage.  
✅ Provides **lifecycle callbacks** for custom initialization & cleanup.  

---

### **3️⃣ I - Inspect (How It Works + Code Examples)**  

### **1️⃣ Bean Scopes in Spring Boot**  

| Scope        | Description |
|-------------|------------|
| `singleton` (Default) | One instance shared across the app. |
| `prototype` | New instance for each request. |
| `request` | New instance for each HTTP request (Web only). |
| `session` | New instance for each user session (Web only). |
| `application` | Shared instance across the entire web app. |

#### **Example: Singleton vs Prototype**  
```java
@Component
@Scope("singleton") // Default
public class SingletonBean { }
```
```java
@Component
@Scope("prototype") // New instance each time
public class PrototypeBean { }
```
```java
@Autowired
private PrototypeBean prototypeBean1;

@Autowired
private PrototypeBean prototypeBean2;

System.out.println(prototypeBean1 == prototypeBean2); // false (different instances)
```

---

### **2️⃣ Bean Lifecycle in Spring Boot**  

#### **Lifecycle Annotations**  

| Annotation      | Purpose |
|----------------|---------|
| `@PostConstruct` | Runs after bean creation (initialization). |
| `@PreDestroy` | Runs before bean is destroyed. |

#### **Example: Lifecycle Methods**  
```java
@Component
public class MyBean {
    
    @PostConstruct
    public void init() {
        System.out.println("Bean is initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean is being destroyed");
    }
}
```

✅ **With `@PostConstruct` and `@PreDestroy`**  
1. **When the application starts**, `"Bean is initialized"` is printed.  
2. **When the application stops**, `"Bean is being destroyed"` is printed.  

---

### **3️⃣ M - Modify (Advanced Usage)**  

#### **1️⃣ Using `InitializingBean` and `DisposableBean` Interfaces**  
```java
@Component
public class MyBean implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println("Custom initialization logic");
    }

    @Override
    public void destroy() {
        System.out.println("Custom cleanup logic");
    }
}
```
✅ Alternative to `@PostConstruct` and `@PreDestroy`.  

---

#### **2️⃣ Using `@Bean(initMethod, destroyMethod)` in `@Configuration`**  
```java
@Configuration
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public MyBean myBean() {
        return new MyBean();
    }
}
```
✅ Useful for **third-party beans** where annotations **cannot be added**.  

---


## **Spring Boot vs Spring Framework**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Spring Framework** is a broad framework for Java-based applications, requiring **manual configuration**.  
- **Spring Boot** is a specialized version of Spring that **automates configuration** and provides an embedded server for rapid application development.  

---

### **2️⃣ R - Reverse (Why Do We Need Spring Boot?)**  

#### **Problem with Traditional Spring Framework**  
❌ **Boilerplate Code**: Requires extensive XML/Java-based configuration.  
❌ **Manual Server Setup**: Needs an external web server like Tomcat.  
❌ **Dependency Management**: Requires manually handling dependencies.  

#### **How Spring Boot Solves It?**  
✅ **Auto-Configuration**: Reduces the need for manual configuration.  
✅ **Embedded Servers**: Comes with Tomcat/Jetty/Undertow pre-configured.  
✅ **Spring Boot Starters**: Predefined dependencies simplify project setup.  

---

### **3️⃣ I - Inspect (Key Differences + Code Examples)**  

| Feature | Spring Framework | Spring Boot |
|---------|-----------------|-------------|
| **Configuration** | Requires XML/Java Config (`@Configuration`) | Uses **Auto-Configuration** (`@SpringBootApplication`) |
| **Server Setup** | Needs external Tomcat, Jetty | Comes with **embedded** Tomcat, Jetty, Undertow |
| **Dependency Management** | Manually managed using `pom.xml` | Uses **Spring Boot Starters** (`spring-boot-starter-web`) |
| **Microservices Support** | Requires additional setup | Built-in microservices support |
| **Production Readiness** | No built-in monitoring | **Actuator** for monitoring |
| **Default Packaging** | WAR (Web Archive) | JAR (Standalone Runnable) |

#### **1️⃣ Spring Framework Example (Manual Setup)**  
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.10</version>
</dependency>
```
```java
@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class AppConfig { }
```
```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
```

#### **2️⃣ Spring Boot Example (Auto-Configuration)**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
```java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);  // No manual context setup
    }
}
```

✅ **Spring Boot removes manual configurations, allowing faster development.**  

---

### **4️⃣ M - Modify (Advanced Customization & Optimization)**  
- **Disable Auto-Configuration (if needed)**  
  ```java
  @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
  ```
- **Use External Configurations (YAML/Properties instead of XML)**  
  ```yaml
  server:
    port: 8081
  ```

---


## **Spring Boot Auto-Configuration**  

### **1️⃣ (Basic Concept in Simple Terms)**  
- **Spring Boot Auto-Configuration** automatically configures Spring Beans based on the classpath dependencies.  
- It removes the need for **manual configuration** (`@Configuration`) and **XML setup**.  
- Works using `@EnableAutoConfiguration` (internally included in `@SpringBootApplication`).  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without Auto-Configuration (Spring Framework)**  
❌ Requires **manual bean definitions** for everything (DataSource, ViewResolvers, etc.).  
❌ Needs **explicit component scanning** and `@Configuration` setup.  

#### **How Auto-Configuration Solves It? (Spring Boot)**  
✅ **Automatically detects** required configurations based on dependencies.  
✅ **Provides sensible defaults**, reducing boilerplate code.  
✅ **Overrides are possible** via properties or custom configurations.  

---

### **3️⃣ I - Inspect (How It Works + Code Example)**  

#### **1️⃣ How Auto-Configuration Works Internally?**  
- When `@SpringBootApplication` is used, it enables `@EnableAutoConfiguration`.  
- Spring Boot scans the classpath and applies configurations based on **Spring Boot Starters**.  
- Uses `spring.factories` file to load pre-defined configurations dynamically.  

#### **2️⃣ Example: Auto-Configuration for DataSource**  
✅ **Without Auto-Configuration (Spring Framework - Manual Setup)**  
```java
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource();
    }
}
```

✅ **With Auto-Configuration (Spring Boot - No Manual Setup Needed!)**  
Just add the dependency:  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
And Spring Boot **automatically** configures a DataSource! 🚀  

---

### **4️⃣ M - Modify (Customizing Auto-Configuration)**  

#### **1️⃣ Exclude Unwanted Auto-Configurations**  
```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
```

#### **2️⃣ Override Auto-Configured Beans**  
If you want to use a custom DataSource instead of the default one:  
```java
@Configuration
public class CustomDataSourceConfig {
    @Bean
    public DataSource customDataSource() {
        return new HikariDataSource();
    }
}
```

#### **3️⃣ Enable/Disable Features Using `application.properties`**  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.jpa.hibernate.ddl-auto=update
```

---


## **`@SpringBootApplication` Annotation**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@SpringBootApplication` is a **shortcut annotation** in Spring Boot.  
- It **bundles three core annotations**:  
  - `@SpringBootConfiguration` → Marks the class as a configuration class.  
  - `@EnableAutoConfiguration` → Enables Spring Boot’s auto-configuration.  
  - `@ComponentScan` → Scans for Spring components (`@Component`, `@Service`, `@Repository`, `@Controller`).  
- It simplifies the configuration of a Spring Boot application.  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without `@SpringBootApplication`**  
❌ You would have to manually write:  
```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyAppConfig {
}
```
❌ More boilerplate code and manual configuration.  

#### **How `@SpringBootApplication` Solves It?**  
✅ **Single annotation** replaces three.  
✅ **Reduces boilerplate** and improves readability.  
✅ **Automatically configures** components based on dependencies.  

---

### **3️⃣ I - Inspect (How It Works + Code Examples)**  

### **1️⃣ Basic Example of `@SpringBootApplication`**
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
✅ This **automatically configures** Spring Boot and starts the application.  

---

### **2️⃣ Breaking Down `@SpringBootApplication`**  

#### **1️⃣ `@SpringBootConfiguration`**  
- Alternative to `@Configuration`, marks the class as a Spring Boot configuration class.  

#### **2️⃣ `@EnableAutoConfiguration`**  
- Automatically configures beans based on classpath dependencies.  
- Example: If `spring-boot-starter-web` is present, it **auto-configures** a web server.  

#### **3️⃣ `@ComponentScan`**  
- Scans the **current package and sub-packages** for Spring-managed beans.  
- Without it, components outside the package won’t be detected.  

---

### **3️⃣ M - Modify (Advanced Usage & Examples)**  

#### **1️⃣ Excluding Auto-Configurations**  
If you **don’t want** certain auto-configurations, you can exclude them:  
```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyApp {
}
```
✅ Prevents unwanted configurations (e.g., disabling database auto-configuration).  

---

#### **2️⃣ Customizing Component Scanning**  
You can **limit scanning** to specific packages:  
```java
@SpringBootApplication(scanBasePackages = "com.example.services")
public class MyApp {
}
```
✅ Helps improve performance by only scanning required packages.  

---


## **Lombok in Spring Boot**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Lombok** is a Java library that reduces boilerplate code like getters, setters, constructors, and logging in Spring Boot applications.  
- It uses **annotations** to automatically generate commonly used methods at compile-time.  
- Helps in **cleaner, more readable code**.  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without Lombok (Traditional Java Approach)**  
❌ Too much **boilerplate code** for getters, setters, constructors, etc.  
❌ Hard to maintain **large data models** with many fields.  

#### **How Lombok Solves It?**  
✅ **Reduces boilerplate** by generating methods automatically.  
✅ **Improves readability** and keeps the code **clean**.  
✅ **Increases productivity** in Spring Boot development.  

---

### **3️⃣ I - Inspect (How It Works + Code Examples)**  

### **1️⃣ Setup Lombok in Spring Boot (Maven/Gradle)**  
#### **For Maven (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```
#### **For Gradle (`build.gradle`)**  
```gradle
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.30'
    annotationProcessor 'org.projectlombok:lombok:1.18.30'
}
```

---

### **2️⃣ Lombok Annotations & Examples**  

| Annotation      | Purpose |
|----------------|---------|
| `@Getter` | Generates all getter methods. |
| `@Setter` | Generates all setter methods. |
| `@ToString` | Generates `toString()` method. |
| `@EqualsAndHashCode` | Generates `equals()` and `hashCode()`. |
| `@NoArgsConstructor` | Generates a no-args constructor. |
| `@AllArgsConstructor` | Generates an all-args constructor. |
| `@RequiredArgsConstructor` | Generates a constructor for final fields. |
| `@Data` | Combines `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, and `@RequiredArgsConstructor`. |
| `@Value` | Similar to `@Data` but makes the class **immutable**. |
| `@Builder` | Provides a **Builder Pattern** for object creation. |
| `@Slf4j` | Generates a logger instance. |

---

### **3️⃣ M - Modify (Advanced Usage & Examples)**  

#### **1️⃣ Using `@Data` (Most Common Use Case)**
```java
import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
}
```
✅ Generates **getters, setters, `toString()`, `equals()`, and `hashCode()`** automatically.  

---

#### **2️⃣ Using `@NoArgsConstructor` and `@AllArgsConstructor`**
```java
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
```
✅ Generates **both default and parameterized constructors**.  

---

#### **3️⃣ Using `@Builder` for Object Creation**  
```java
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private int age;
}
```
✅ Creates a **builder pattern** for easy object creation:  
```java
User user = User.builder().name("John").age(25).build();
```

---

#### **4️⃣ Using `@Slf4j` for Logging in Spring Boot**  
```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    public void processUser() {
        log.info("Processing user...");
    }
}
```
✅ No need for `Logger logger = LoggerFactory.getLogger(ClassName.class);`  

---


## **Spring Boot Starters - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- A **Spring Boot Starter** is a **pre-configured dependency** that bundles commonly used libraries and configurations to simplify development.  
- Instead of manually adding multiple dependencies, a single starter brings everything needed for a specific functionality (e.g., web, JPA, security).  
- Starters **reduce boilerplate and ensure compatibility** between dependencies.  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without Starters**  
❌ Developers must manually add and manage multiple dependencies.  
❌ Version conflicts between dependencies can occur.  
❌ Extra manual configuration is required.  

#### **How Spring Boot Starters Solve It?**  
✅ **Single dependency** pulls in all required libraries.  
✅ **Auto-configures settings** for quick setup.  
✅ **Ensures compatibility** between dependencies.  

---

### **3️⃣ I - Inspect (How It Works + Code Examples)**  

### **1️⃣ Commonly Used Starters & Their Purpose**  

| Starter | Purpose |
|---------|---------|
| `spring-boot-starter-web` | For building **REST APIs** and web applications (includes Spring MVC, embedded Tomcat). |
| `spring-boot-starter-data-jpa` | For database access using **Spring Data JPA and Hibernate**. |
| `spring-boot-starter-security` | For adding **Spring Security** (authentication & authorization). |
| `spring-boot-starter-test` | For **unit and integration testing** (JUnit, Mockito). |
| `spring-boot-starter-thymeleaf` | For using **Thymeleaf template engine** in web applications. |
| `spring-boot-starter-actuator` | For **monitoring and management** of Spring Boot applications. |
| `spring-boot-starter-mail` | For sending emails using **JavaMailSender**. |
| `spring-boot-starter-cache` | For adding **caching support** in Spring Boot. |
| `spring-boot-starter-aop` | For **Aspect-Oriented Programming (AOP)** with Spring. |

---

### **2️⃣ Example - Using `spring-boot-starter-web`**  
Instead of adding multiple dependencies, just add this:  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
✅ Includes Spring MVC, Jackson (for JSON), and an embedded Tomcat server.  

---

### **3️⃣ M - Modify (Advanced Usage & Examples)**  

#### **1️⃣ Custom Starter Development**  
You can create your own Spring Boot starter for **reusable components** across projects.  

Steps:  
1. Create a **new module** with required dependencies.  
2. Define a `META-INF/spring.factories` file for auto-configuration.  
3. Package and reuse it as a starter dependency in multiple projects.  

---
## **Configuring Properties in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Spring Boot properties** are configured in **`application.properties`** or **`application.yml`** files to **externalize configurations** like database settings, server ports, and custom variables.  
- Properties can also be **set via environment variables, command-line arguments, or external configuration files**.  
- **Spring Boot automatically loads these properties** and injects them into beans using `@Value` or `@ConfigurationProperties`.  

---

### **2️⃣ R - Reverse (Why Do We Need It?)**  

#### **Problem Without Externalized Properties**  
❌ Hardcoding values in Java files makes configuration **inflexible** and **hard to maintain**.  
❌ Changing database URLs, API keys, or ports requires **code changes & redeployment**.  

#### **How Spring Boot Properties Solve It?**  
✅ Configuration is **centralized** in `application.properties` or `application.yml`.  
✅ Supports **multiple environments** (dev, test, prod) with **Spring Profiles**.  
✅ **Easy modification** without changing code.  

---

### **3️⃣ I - Inspect (How It Works + Code Examples)**  

### **1️⃣ Configuring Properties in `application.properties`**  
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
custom.message=Hello, Spring Boot!
```

✅ **`server.port=8081`** → Changes the server port from the default **8080** to **8081**.  
✅ **Database credentials** are **externalized**, making them easy to change.  

---

### **2️⃣ Using `application.yml` (YAML Format Alternative)**  
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: secret

custom:
  message: "Hello, Spring Boot!"
```
✅ YAML provides **better readability** for nested configurations.  

---

### **3️⃣ Injecting Properties into Java Code**  

#### **1️⃣ Using `@Value` for Individual Properties**  
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${custom.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
```
✅ **Reads `custom.message` from `application.properties` or `application.yml`**.  

---

#### **2️⃣ Using `@ConfigurationProperties` for Grouped Properties**  
```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    private String message;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
```
✅ **Maps all properties prefixed with `custom.` to a Java class.**  
✅ **More scalable than `@Value` for handling multiple properties.**  

---

### **4️⃣ M - Modify (Advanced Usage & Examples)**  

#### **1️⃣ Using Profiles for Environment-Specific Configurations**  
Create different property files:  
- `application-dev.properties` (for development)  
- `application-prod.properties` (for production)  

Example `application-dev.properties`:  
```properties
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/devdb
```

Example `application-prod.properties`:  
```properties
server.port=8083
spring.datasource.url=jdbc:mysql://prod-db-server:3306/proddb
```

Activate a profile in `application.properties`:  
```properties
spring.profiles.active=dev
```
✅ Switch environments **without modifying the main application**.  

---

#### **2️⃣ Overriding Properties via Command Line (For Dynamic Configurations)**  
```sh
java -jar myapp.jar --server.port=9090 --custom.message="Overridden via CLI"
```
✅ Useful for **dynamic deployments without modifying files**.  

---


