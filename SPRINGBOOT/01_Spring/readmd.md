# **Spring core**

## **Spring IoC**  

#### **What is Spring IoC?**  
📝 **Definition**:  
- Spring IoC (Inversion of Control) is a design principle where the Spring container manages object 
creation and dependency injection instead of the programmer.  

#### **Why is Spring IoC needed?**  
❓ **Problem it solves**:  
- Avoids **tight coupling** between objects.  
- Improves **maintainability** and **scalability**.  
- Simplifies **unit testing** by injecting dependencies instead of hardcoding them.  

#### **How does Spring IoC work?**  
⚙️ **Implementation**:  
- Uses **Dependency Injection (DI)** to inject required dependencies.  
- Managed by the **Spring IoC container**.  
- Supports **Constructor Injection, Setter Injection, and Field Injection**.  

#### **Example of Spring IoC**  
📌 **Constructor Injection Example**:  
```java
@Component
class Engine {}

@Component
class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```
📢 **Spring automatically injects `Engine` into `Car`.**  

#### **Where is Spring IoC used?**  
✅ **Real-World Applications**:  
- **Spring Boot applications** – Automates dependency management.  
- **Enterprise apps** – Manages service dependencies.  
- **Microservices** – Handles service communication.  
- **Testing** – Allows mocking dependencies easily.  

---

## **Dependency Injection (DI) - Flashcards**  

#### **Flashcard 1: What is Dependency Injection (DI)?**  
📝 **Definition**:  
Dependency Injection (DI) is a design pattern in which an object's dependencies are provided by an external source (like the **Spring IoC container**) instead of the object creating them itself.  

---

#### **Flashcard 2: Why is Dependency Injection needed?**  
❓ **Problem it solves**:  
- Eliminates **tight coupling** between objects.  
- Enhances **code reusability** and **scalability**.  
- Makes **unit testing easier** by allowing dependency mocking.  

---

#### **Flashcard 3: Types of Dependency Injection**  
📌 **Three main types of DI in Spring**:  
1️⃣ **Constructor Injection** – Dependencies are passed via constructor.  
2️⃣ **Setter Injection** – Dependencies are set using setter methods.  
3️⃣ **Field Injection** – Dependencies are injected directly into fields (least recommended).  

---

#### **Flashcard 4: Constructor Injection Example**  
```java
@Component
class Engine {}

@Component
class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```
📢 **Spring automatically injects `Engine` into `Car` via the constructor.**  

---

#### **Flashcard 5: Setter Injection Example**  
```java
@Component
class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
```
📢 **Spring injects the dependency using a setter method.**  

---

#### **Flashcard 6: Where is Dependency Injection used?**  
✅ **Real-World Applications**:  
- **Spring Boot** – Automates DI for service layers.  
- **Microservices** – Injects dependencies dynamically.  
- **Testing (JUnit, Mockito)** – Easily replaces dependencies with mocks.  

---

## **Spring Beans - Flashcards**  

#### **Flashcard 1: What is a Spring Bean?**  
📝 **Definition**:  
A **Spring Bean** is an object that is managed by the **Spring IoC container**. It is created, configured, and controlled by Spring throughout its lifecycle.  

---

#### **Flashcard 2: Why are Spring Beans needed?**  
❓ **Problem they solve**:  
- Centralized **object management** by the Spring container.  
- Enables **loose coupling** by injecting dependencies.  
- Optimizes **resource usage** with singleton beans by default.  

---

#### **Flashcard 3: How to define a Spring Bean?**  
📌 **Ways to create a bean**:  
1️⃣ **Using `@Component` (Auto-detection)**  
```java
@Component
class Engine {}
```
2️⃣ **Using `@Bean` in a `@Configuration` class**  
```java
@Configuration
class AppConfig {
    @Bean
    public Engine engine() {
        return new Engine();
    }
}
```
📢 **Both methods register `Engine` as a Spring Bean.**  

---

#### **Flashcard 4: Spring Bean Scopes**  
📌 **Bean scopes define how beans are created and shared.**  
- **Singleton** (default) – One instance per container.  
- **Prototype** – New instance for each request.  
- **Request** – New instance per HTTP request (for web apps).  
- **Session** – One instance per user session.  

Example:  
```java
@Component
@Scope("prototype")  // Creates a new instance every time
class Car {}
```

---

#### **Flashcard 5: Where are Spring Beans used?**  
✅ **Real-World Applications**:  
- **Service Layer Beans** (`@Service`) – Business logic components.  
- **DAO/Repository Beans** (`@Repository`) – Database access objects.  
- **Controller Beans** (`@Controller`) – Handles HTTP requests in Spring MVC.  

---

## **Spring Bean Life Cycle - Flashcards**  

#### **Flashcard 1: What is the Spring Bean Life Cycle?**  
📝 **Definition**:  
The **Spring Bean Life Cycle** refers to the stages a bean goes through from **creation** to **destruction**, managed by the **Spring IoC container**.  

---

#### **Flashcard 2: Why is the Bean Life Cycle important?**  
❓ **Problem it solves**:  
- Ensures **proper initialization and cleanup** of resources.  
- Allows **custom behavior** before and after a bean is ready to use.  
- Prevents **memory leaks** by handling cleanup automatically.  

---

#### **Flashcard 3: Stages of the Spring Bean Life Cycle**  
📌 **Key stages**:  
1️⃣ **Instantiation** – The container creates the bean.  
2️⃣ **Dependency Injection** – Dependencies are injected.  
3️⃣ **Post-initialization (`@PostConstruct`)** – Custom logic after initialization.  
4️⃣ **Ready to Use** – Bean is available for use.  
5️⃣ **Pre-destruction (`@PreDestroy`)** – Cleanup logic before bean is removed.  
6️⃣ **Destruction** – The bean is destroyed.  

---

#### **Flashcard 4: Custom Initialization and Destruction Methods**  
📌 **Using `@PostConstruct` and `@PreDestroy` (Recommended)**  
```java
@Component
class Car {
    @PostConstruct
    public void init() {
        System.out.println("Car initialized 🚗");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car destroyed ❌");
    }
}
```

📌 **Using `initMethod` and `destroyMethod` in `@Bean`**  
```java
@Configuration
class AppConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Engine engine() {
        return new Engine();
    }
}
```

📌 **Implementing `InitializingBean` and `DisposableBean` (Less Recommended)**  
```java
@Component
class Engine implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() { System.out.println("Engine started 🔥"); }
    @Override
    public void destroy() { System.out.println("Engine stopped 🛑"); }
}
```

---

#### **Flashcard 5: Where is the Bean Life Cycle used?**  
✅ **Real-World Applications**:  
- **Database connections** – Open during initialization, close before destruction.  
- **Caching services** – Load cache on startup, clear cache on shutdown.  
- **Thread pools** – Start worker threads at init, shut them down gracefully.  

---

💡 **Key Takeaway**: The Spring Bean Life Cycle ensures proper **initialization, usage, and cleanup** of beans, improving application efficiency and stability. 🚀



# **Basics of Spring Boot**

## **Spring vs Spring Boot - Flashcards**  

---

#### **Flashcard 1: What is Spring?**  
📝 **Definition**:  
Spring is a **lightweight framework** that provides **dependency injection (DI), transaction management, AOP, and MVC** for Java applications.  

📌 **Key Features**:  
- **Spring Core** (IoC, DI)  
- **Spring MVC** (Web framework)  
- **Spring AOP** (Aspect-Oriented Programming)  
- **Spring Security** (Authentication & Authorization)  
- **Spring Data** (JPA, JDBC)  

---

#### **Flashcard 2: What is Spring Boot?**  
📝 **Definition**:  
Spring Boot is a **framework built on top of Spring** that simplifies application development by providing **auto-configuration, embedded servers, and opinionated defaults**.  

📌 **Key Features**:  
- **Auto-Configuration** (No XML, fewer configurations)  
- **Embedded Servers** (Tomcat, Jetty, Undertow)  
- **Spring Boot Starters** (Pre-configured dependencies)  
- **Spring Boot Actuator** (Monitoring & Metrics)  

---

#### **Flashcard 3: Key Differences**  
| Feature          | Spring Framework | Spring Boot |
|-----------------|-----------------|------------|
| **Setup** | Manual XML/Java config | Auto-configured |
| **Dependency Management** | Manual setup | Uses **Starters** |
| **Embedded Server** | Requires external setup | Built-in (Tomcat, Jetty) |
| **Configuration** | More boilerplate | **Less code, more defaults** |
| **Microservices** | Requires extra setup | **Built-in support** |
| **Production Ready** | Needs additional tools | **Actuator for monitoring** |

---

#### **Flashcard 4: Example - Spring vs Spring Boot**  
📌 **Spring (Traditional setup)**  
```xml
<!-- Need to manually configure dependencies -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.x.x</version>
</dependency>
```
```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    @Bean
    public Engine engine() {
        return new Engine();
    }
}
```

📌 **Spring Boot (Auto-configured setup)**  
```xml
<!-- Single starter dependency handles everything -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.x.x</version>
</dependency>
```
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📢 **Spring Boot eliminates XML and manual bean configuration.**  

---

#### **Flashcard 5: Where are Spring and Spring Boot used?**  
✅ **Real-World Applications**  
- **Spring** → Used in **large-scale enterprise applications** where customization is needed.  
- **Spring Boot** → Used for **microservices, REST APIs, and rapid application development**.  

---

## **Main Features of Spring Boot - Flashcards**  

---

#### **Flashcard 1: What is Spring Boot?**  
📝 **Definition**:  
Spring Boot is a **framework built on top of Spring** that simplifies application development by providing **auto-configuration, embedded servers, and opinionated defaults**.  

📌 **Key Benefit**: **Reduces boilerplate code and speeds up development** 🚀    
        ✅ **Auto-configuration**  
        ✅ **Starter dependencies**  
        ✅ **Embedded servers**  
        ✅ **Monitoring (Actuator)**  
        ✅ **Rapid development (DevTools)**  
        ✅ **Microservices support**  

---

#### **Flashcard 2: Auto-Configuration**  
⚡ **What it does?**  
- Automatically configures beans based on classpath dependencies.  
- No need for **manual XML or Java-based configuration**.  

📌 **Example**: If `spring-boot-starter-web` is added, Spring Boot **auto-configures** Spring MVC.  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📢 **No need for explicit `DispatcherServlet` configuration!**  

---

#### **Flashcard 3: Spring Boot Starters**  
📦 **What are they?**  
- **Pre-configured dependencies** for common tasks.  
- Reduces dependency conflicts and setup effort.  

📌 **Common Starters**:  
- `spring-boot-starter-web` → For web applications.  
- `spring-boot-starter-data-jpa` → For database access.  
- `spring-boot-starter-security` → For authentication & authorization.  

📌 **Example**:  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.x.x</version>
</dependency>
```
📢 **Handles dependencies automatically!**  

---

#### **Flashcard 4: Embedded Servers**  
🖥️ **What it does?**  
- Built-in support for **Tomcat, Jetty, and Undertow**.  
- No need to deploy WAR files to an external server.  

📌 **Example**: Run a web app **without setting up Tomcat manually**.  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📢 **Spring Boot includes an embedded server by default!**  

---

#### **Flashcard 5: Spring Boot Actuator**  
📊 **What it does?**  
- Provides **monitoring and management** endpoints for applications.  
- Helps in tracking application health, metrics, and logs.  

📌 **Enable Actuator in `application.properties`**:  
```properties
management.endpoints.web.exposure.include=*
```
📌 **Access health status**:  
```
http://localhost:8080/actuator/health
```
📢 **Ideal for production monitoring!**  

---

#### **Flashcard 6: Spring Boot DevTools**  
⚡ **What it does?**  
- **Auto-restart** on code changes.  
- Enables **LiveReload** for real-time UI updates.  

📌 **Add DevTools dependency**:  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```
📢 **No need to restart manually!**  

---

#### **Flashcard 7: Microservices Support**  
☁️ **Why important?**  
- Makes **developing and deploying microservices easier**.  
- Works seamlessly with **Spring Cloud** for distributed systems.  

📌 **Spring Boot with REST API example**:  
```java
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```
📢 **Lightweight and scalable for microservices!**  

---

## **@SpringBootApplication Annotation - Flashcard**  

---

#### **Flashcard 1: What is @SpringBootApplication?**  
📝 **Definition**:  
`@SpringBootApplication` is a **meta-annotation** in Spring Boot that combines three key annotations:  
✅ `@Configuration` – Marks the class as a Spring **configuration** class.  
✅ `@EnableAutoConfiguration` – Enables **Spring Boot's auto-configuration**.  
✅ `@ComponentScan` – Scans the **current package and sub-packages** for Spring components.  

📢 **It is the entry point of any Spring Boot application!** 🚀  

---

#### **Flashcard 2: Why is @SpringBootApplication needed?**  
🔥 **Problem it solves**:  
- Reduces **boilerplate code** by combining multiple annotations into one.  
- Simplifies **Spring Boot application setup**.  
- Ensures automatic configuration **based on dependencies**.  

📌 **Before Spring Boot (Without `@SpringBootApplication`)**  
```java
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class MyAppConfig {
}
```
📌 **With Spring Boot (Using `@SpringBootApplication`)**  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📢 **Less code, same functionality!**  

---

#### **Flashcard 3: How does @SpringBootApplication work internally?**  
⚙️ **Internal Breakdown**:  
- `@Configuration` → Allows **bean definitions** using `@Bean`.  
- `@EnableAutoConfiguration` → Automatically configures **Spring components** based on dependencies.  
- `@ComponentScan` → Finds **Spring Beans (@Component, @Service, @Repository, @Controller)** in the same package.  

📌 **Example with Auto-Configuration**:  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📌 If `spring-boot-starter-web` is added, it automatically configures:  
✅ **DispatcherServlet**  
✅ **Embedded Tomcat**  
✅ **Spring MVC setup**  

---

#### **Flashcard 4: Where is @SpringBootApplication used?**  
✅ **Microservices** – Rapid development of REST APIs.  
✅ **Web Applications** – Auto-configures MVC, security, and databases.  
✅ **Enterprise Applications** – Reduces configuration overhead.  

---

## **How to Create a Spring Boot Application - Flashcard**  

---

#### **Flashcard 1: Steps to Create a Spring Boot Application**  
📝 **Follow these simple steps**:  
1️⃣ **Set up a project** using Spring Initializr or manually.  
2️⃣ **Add dependencies** (like Spring Web, JPA, etc.).  
3️⃣ **Create a main application class** with `@SpringBootApplication`.  
4️⃣ **Define controllers, services, and repositories**.  
5️⃣ **Run the application** using `SpringApplication.run()`.  

📢 **Spring Boot simplifies setup with auto-configuration!**  

---

#### **Flashcard 2: Creating a Spring Boot Project (Using Spring Initializr)**  
🌐 **Go to**: [https://start.spring.io/](https://start.spring.io/)  
📌 **Steps**:  
1️⃣ Choose **Project Type** → **Maven** / **Gradle**.  
2️⃣ Select **Spring Boot Version** → (Latest stable version).  
3️⃣ Add **Dependencies** (e.g., Spring Web, Spring Boot DevTools, Lombok, etc.).  
4️⃣ Click **Generate** → Download the ZIP file.  
5️⃣ Extract and open it in an **IDE** (IntelliJ, Eclipse, VS Code).  

📢 **Spring Initializr sets up the project structure for you!**  

---

#### **Flashcard 3: Manually Creating a Spring Boot Application**  
📌 **1. Add Spring Boot Dependency (Maven Project - `pom.xml`)**  
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```
📢 **`spring-boot-starter-web` adds web functionalities!**  

📌 **2. Create a Main Class**  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
📢 **Entry point of a Spring Boot application!**  

📌 **3. Create a REST Controller**  
```java
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```
📢 **Creates a simple REST API endpoint!**  

---

#### **Flashcard 4: Running the Application**  
📌 **Option 1: Using IDE (IntelliJ, Eclipse)**  
✔ Right-click `MyApp.java` → **Run MyApp**  

📌 **Option 2: Using Command Line (Maven Project)**  
```sh
mvn spring-boot:run
```
📌 **Option 3: Running JAR File**  
```sh
java -jar target/myapp-0.0.1-SNAPSHOT.jar
```
📢 **Runs an embedded server (Tomcat by default)!**  

---

#### **Flashcard 5: Testing the Application**  
✅ Open a browser or Postman → **Visit the endpoint**  
```
http://localhost:8080/api/hello
```
📌 **Response:**  
```
Hello, Spring Boot!
```
📢 **Spring Boot auto-configures everything! 🚀**  

---

## **`pom.xml` in Spring Boot - Flashcard**  

---

#### **Flashcard 1: What is `pom.xml`?**  
📝 **Definition**:  
`pom.xml` (**Project Object Model**) is the **configuration file for Maven** in a Spring Boot project. It:  
✅ **Manages dependencies** 📦  
✅ **Defines project build configurations** 🔧  
✅ **Handles plugins & profiles** ⚙️  

📢 **It is the heart of a Maven-based Spring Boot project!** ❤️  

---

#### **Flashcard 2: Basic Structure of `pom.xml`**  
📌 **Essential Tags:**  
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>   <!-- Unique identifier (Company/Org Name) -->
    <artifactId>spring-boot-demo</artifactId>  <!-- Project Name -->
    <version>1.0.0</version>  <!-- Version Number -->
    <packaging>jar</packaging>  <!-- JAR or WAR -->
    
    <name>Spring Boot Demo</name> 
    <description>Spring Boot application using Maven</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version> <!-- Spring Boot Version -->
    </parent>

    <dependencies>
        <!-- Spring Boot Web Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Testing Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
📢 **This file defines dependencies, versioning, and build settings for the project!** 🚀  

---

#### **Flashcard 3: Why is `pom.xml` needed?**  
🔥 **Problem it solves**:  
- Eliminates **manual dependency management**.  
- Ensures **consistent project builds**.  
- Handles **transitive dependencies** (automatically pulls required libraries).  

📢 **Just add dependencies, and Maven takes care of the rest!**  

---

#### **Flashcard 4: Key Elements in `pom.xml`**  
🔹 **`<parent>`** – Inherits properties from **Spring Boot starter parent**.  
🔹 **`<dependencies>`** – Defines required **Spring Boot modules** (Web, JPA, Security, etc.).  
🔹 **`<build>`** – Specifies the **Spring Boot Maven plugin** for packaging & execution.  

📌 **Example: Adding MySQL Database Dependency**  
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
📢 **Maven automatically downloads and manages it!**  

---


# **Spring boot configuration**

## **Configuring Spring Boot using `application.properties` - Flashcard**  

---

#### **Flashcard 1: What is `application.properties`?**  
📝 **Definition**:  
`application.properties` is a **configuration file** used in Spring Boot to **externalize settings** like:  
✅ **Server Port**  
✅ **Database Configurations**  
✅ **Logging Levels**  
✅ **Spring Profiles**  

📢 **It helps in separating configuration from code!**  

---

#### **Flashcard 2: Where is `application.properties` located?**  
📌 Default Location:  
```
src/main/resources/application.properties
```
📢 **Spring Boot automatically loads it at startup!**  

---

#### **Flashcard 3: How to Configure Spring Boot Properties?**  
📌 **1️⃣ Change Default Server Port**  
```properties
server.port=8081
```
(Default is `8080` but changes to `8081` here.)  

📌 **2️⃣ Configure Database (MySQL Example)**  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
📢 **Manages database connection easily!**  

📌 **3️⃣ Set Logging Levels**  
```properties
logging.level.org.springframework=DEBUG
```
📢 **Controls log verbosity!**  

📌 **4️⃣ Configure Active Profiles**  
```properties
spring.profiles.active=dev
```
📢 **Enables different environments (e.g., `dev`, `prod`)!**  


---

## **Difference between `application.properties` and `application.yml` - Flashcard**  

---

#### **Flashcard 1: What are `application.properties` and `application.yml`?**  
📝 **Definition**:  
Both `application.properties` and `application.yml` are **Spring Boot configuration files** used for setting various properties like server configurations, database settings, and logging levels.  
- **`application.properties`** uses **key-value pairs** (`key=value` format).  
- **`application.yml`** uses a **hierarchical structure** (`YAML` format).  

---

#### **Flashcard 2: Key Differences Between `application.properties` and `application.yml`**  

| **Feature**                     | **`application.properties`**       | **`application.yml`**           |
|----------------------------------|-------------------------------------|---------------------------------|
| **Format**                       | Key-Value Pair (`key=value`)        | Hierarchical (`YAML` format)    |
| **Readability**                  | Less readable, plain text           | More readable, structured format |
| **Nested Configuration**         | Requires multiple properties       | Supports nested structure easily |
| **Syntax Example**               | `server.port=8081`                  | `server: port: 8081`            |
| **Support for Arrays/Lists**     | Limited to repeating key names      | Supports lists (e.g., `- value`)|
| **Comments**                     | Can use `#` for comments            | Uses `#` for comments           |

---

#### **Flashcard 3: Example of Key-Value Configuration**  
- **`application.properties`**:  
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
```
- **`application.yml`**:  
```yaml
server:
  port: 8081
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
```

📢 **`application.yml` allows easier and more structured configuration**.  

---

## **Externalizing Configuration in Spring Boot - Flashcards**  

---

#### **Flashcard 1: What is Externalizing Configuration in Spring Boot?**  
📝 **Definition**:  
Externalizing configuration allows you to **keep application settings outside the code**, making it more flexible and environment-specific (e.g., different settings for development, production).  

---

#### **Flashcard 2: Why Externalize Configuration?**  
❓ **Problem it solves**:  
- **Environment-specific configurations** (e.g., dev, prod).  
- **Separation of code and configuration**, allowing easier maintenance.  
- **Avoid hardcoding sensitive values** (e.g., passwords, API keys).  
- **Flexible configurations** for various environments without changing the codebase.

---

#### **Flashcard 3: How to Externalize Configuration?**  
📌 **Common methods to externalize configurations**:  
1️⃣ **Using `application.properties` or `application.yml`**  
   - Store key-value pairs in these files for application-wide settings.  

2️⃣ **Using Command Line Arguments**  
   - Pass configurations via the command line when running the application.  
   ```bash
   java -jar app.jar --server.port=8082
   ```

3️⃣ **Using Environment Variables**  
   - Define environment variables for sensitive or environment-specific configurations.  
   ```bash
   export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/mydb
   ```

4️⃣ **Using `@Value` Annotation**  
   - Inject values directly into your Spring beans.  
   ```java
   @Value("${app.name}")
   private String appName;
   ```

5️⃣ **Using `@ConfigurationProperties`**  
   - Bind entire configuration sections to a Java bean class.  
   ```java
   @Component
   @ConfigurationProperties(prefix = "app")
   public class AppConfig {
       private String name;
       private String version;
   }
   ```

---

#### **Flashcard 4: Example - Using `application.properties`**  
📌 **Define properties in `application.properties`**:  
```properties
# application.properties
server.port=8081
app.name=My Spring Boot App
```

📌 **Inject using `@Value`**:  
```java
@Value("${server.port}")
private int serverPort;

@Value("${app.name}")
private String appName;
```

📢 **`application.properties` is the default location for configurations.**  

---

#### **Flashcard 5: Profile-Specific Configurations**  
📌 **Using Profiles for different environments**:  
- **application-dev.properties**  
- **application-prod.properties**

📌 **Set active profile in `application.properties`**:  
```properties
spring.profiles.active=dev
```

📌 **Profile-specific properties file**:  
```properties
# application-dev.properties
server.port=8081

# application-prod.properties
server.port=8080
```

📢 **Spring Boot will automatically load the appropriate profile-based configuration.**  

---

#### **Flashcard 6: Where is Externalized Configuration used?**  
✅ **Real-World Applications**:  
- **Multi-environment applications** (e.g., different configurations for dev, prod).  
- **Cloud-based applications** using environment variables for configuration.  
- **Microservices** needing centralized configuration via Spring Cloud Config.  

---

## **Using `@Profile` in Spring Boot - Flashcards (KISS)**

---

#### **Flashcard 1: What is `@Profile`?**  
📝 **Definition**:  
`@Profile` is an annotation used to specify that a bean is available only in certain **Spring profiles** (environments).

---

#### **Flashcard 2: Why is `@Profile` Needed?**  
❓ **Problem it solves**:  
- **Environment-specific beans**: Define different beans for different environments (e.g., dev, prod).  
- **Reduce conditional code**: Avoid using conditional statements in code to manage different configurations.

---

#### **Flashcard 3: How Does `@Profile` Work?**  
📌 **Usage of `@Profile`**:  
1. **Assign profiles to beans**: Use `@Profile("dev")` to only enable a bean for the `dev` profile.
2. **Set active profile**: Specify the active profile in `application.properties`.

📌 **Example**:  
```java
@Bean
@Profile("dev")
public DataSource devDataSource() {
    return new DataSource("dev-url");
}

@Bean
@Profile("prod")
public DataSource prodDataSource() {
    return new DataSource("prod-url");
}
```

📢 **Spring only activates beans based on the active profile.**  

---

#### **Flashcard 4: Setting Active Profiles**  
📌 **Set active profile in `application.properties`**:  
```properties
# application.properties
spring.profiles.active=dev
```

📌 **Set active profile via command line**:  
```bash
java -jar app.jar --spring.profiles.active=prod
```

📢 **Profiles can be set programmatically or via property files.**

---

#### **Flashcard 5: Where is `@Profile` Used?**  
✅ **Real-World Applications**:  
- **Microservices**: Different beans for different service environments.  
- **Cloud deployments**: Switch between dev, staging, and production environments.  
- **Database configurations**: Use different database beans for dev/prod.

---

## **Using `@Value` in Spring Boot - Flashcards (KISS)**

---

#### **Flashcard 1: What is `@Value`?**  
📝 **Definition**:  
`@Value` is a Spring annotation used to **inject values** from property files or environment variables directly into fields of a Spring bean.  

---

#### **Flashcard 2: Why is `@Value` Needed?**  
❓ **Problem it solves**:  
- **Injects external configuration values** (e.g., from `application.properties`) into Java beans.  
- **Simplifies access to application properties** without manual configuration.  
- **Eliminates hardcoding** values within the application code.  

---

#### **Flashcard 3: How Does `@Value` Work?**  
📌 **Usage of `@Value`**:  
1. **Inject simple values** from properties files:  
   - Inject values like strings, integers, etc.  
2. **Expression language**: Use **SpEL** (Spring Expression Language) to evaluate more complex expressions.  

📌 **Example**:  
```java
@Value("${app.name}")
private String appName;

@Value("${server.port}")
private int serverPort;
```

📢 **Values are automatically injected from `application.properties`** based on property names.

---

#### **Flashcard 4: Example with `application.properties`**  
📌 **Define properties in `application.properties`**:  
```properties
app.name=My Spring Boot App
server.port=8080
```

📌 **Inject properties into Spring beans**:  
```java
@Component
public class MyApp {
    @Value("${app.name}")
    private String appName;

    @Value("${server.port}")
    private int port;
    
    public void printDetails() {
        System.out.println("App Name: " + appName);
        System.out.println("Server Port: " + port);
    }
}
```

---

#### **Flashcard 5: Using SpEL (Spring Expression Language)**  
📌 **Example of SpEL in `@Value`**:  
```java
@Value("#{2 * 10}")
private int calculatedValue; // Injects 20

@Value("#{T(java.lang.Math).random()}")
private double randomValue; // Injects a random number
```

📢 **SpEL allows for more complex calculations or object creation.**  

---

# **Restful webservices**

## **@RestController in Spring Boot - Flashcard**

#### **Flashcard 1: What is @RestController?**  
📝 **Definition**:  
`@RestController` is a specialized version of `@Controller` in Spring that combines `@ResponseBody` and `@Controller`. It is used to handle HTTP requests and automatically converts the returned objects into JSON or XML responses.  

---

#### **Flashcard 2: Why is @RestController needed?**  
❓ **Problem it solves**:  
- Simplifies RESTful API creation.  
- Automatically converts Java objects to JSON or XML.  
- Removes the need for manually annotating methods with `@ResponseBody`.

---

#### **Flashcard 3: How does @RestController work?**  
⚙️ **Functionality**:  
- When a method is marked with `@RestController`, Spring converts its return type into a response body directly.  
- It can be used with HTTP methods like **GET**, **POST**, **PUT**, **DELETE**.

---

#### **Flashcard 4: @RestController Example**  
```java
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```
📢 **This controller handles GET requests at `/api/hello` and returns "Hello, World!" as a JSON response.**  

---

#### **Flashcard 5: Where is @RestController used?**  
✅ **Real-World Applications**:  
- **REST APIs** – Exposes endpoints that return JSON responses.  
- **Microservices** – For service-to-service communication.  
- **Web Services** – Simplifies backend development by exposing RESTful APIs.

---

💡 **Key Takeaway**: `@RestController` is used to create **RESTful web services** that automatically return **JSON/XML responses** without the need for explicit `@ResponseBody` annotations. 🚀







