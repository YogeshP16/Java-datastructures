# Spring Boot Interview 

1. **What is Spring Boot, and how does it differ from the traditional Spring Framework?**
    - Spring Boot is an extension of the Spring Framework that simplifies the development of stand-alone, production-ready applications with minimal configuration.
    - **Differences:**

      | Feature                | Spring Framework                                      | Spring Boot                                                |
      |------------------------|-------------------------------------------------------|------------------------------------------------------------|
      | Configuration          | Requires manual XML or Java-based configuration       | Uses auto-configuration and convention over configuration  |
      | Dependency Management  | Requires adding dependencies manually                 | Comes with pre-configured dependencies via spring-boot-starter modules |
      | Embedded Server        | Requires external web server setup (Tomcat, Jetty)    | Comes with an embedded server (Tomcat, Jetty, Undertow)    |
      | Microservices Support  | Not specifically designed for microservices           | Designed for microservices architecture                    |
      | Deployment             | Requires deploying WAR files in an external server    | Can create standalone JARs with embedded servers           |

2. **What is the purpose of @SpringBootApplication annotation?**
    - @SpringBootApplication is a convenience annotation that combines three key annotations:
      - @Configuration - Marks the class as a source of bean definitions.
      - @EnableAutoConfiguration - Enables Spring Boot’s auto-configuration mechanism.
      - @ComponentScan - Scans for components (beans, controllers, services) in the package.
    - **Example:**
      ```java
      @SpringBootApplication
      public class MyApplication {
            public static void main(String[] args) {
                 SpringApplication.run(MyApplication.class, args);
            }
      }
      ```
    - **Purpose:** It simplifies Spring Boot application setup by enabling auto-configuration and component scanning.

3. **Explain the concept of auto-configuration in Spring Boot.**
    - Auto-configuration in Spring Boot automatically configures application settings based on the dependencies present in the classpath.
      - It eliminates the need for manual configuration.
      - Uses @EnableAutoConfiguration (included in @SpringBootApplication).
      - Reads META-INF/spring.factories for predefined configurations.
    - **Example:** If spring-boot-starter-web is present, Spring Boot:
      - Automatically configures an embedded Tomcat server.
      - Registers DispatcherServlet, Jackson, etc.
      - Configures default error handling.

4. **What is the role of application.properties or application.yml in Spring Boot?**
    - These files are used for configuring application settings such as database connection, logging, and server properties.
    - **Example (application.properties):**
      ```properties
      server.port=8081
      spring.datasource.url=jdbc:mysql://localhost:3306/mydb
      spring.datasource.username=root
      spring.datasource.password=root
      ```
    - **Example (application.yml):**
      ```yaml
      server:
         port: 8081
      spring:
         datasource:
            url: jdbc:mysql://localhost:3306/mydb
            username: root
            password: root
      ```
    - application.properties is key-value based, whereas application.yml is hierarchical and more readable.

5. **What are the advantages of Spring Boot over traditional Spring applications?**
    1. Auto-configuration – Reduces boilerplate code.
    2. Embedded server – No need to deploy on external servers.
    3. Microservices-friendly – Simplifies REST API development.
    4. Production-ready – Includes monitoring (Spring Boot Actuator).
    5. Starter dependencies – Reduces dependency conflicts.
    6. Spring Initializr – Simplifies project setup.

6. **What is the difference between @Component, @Service, @Repository, and @Controller in Spring Boot?**
    - **Example:**

      | Annotation  | Purpose                    | Used For                |
      |-------------|----------------------------|-------------------------|
      | @Component  | Generic Spring-managed bean | Any Spring bean         |
      | @Service    | Business logic layer        | Service classes         |
      | @Repository | Data access layer           | DAO/Repository classes  |
      | @Controller | Handles HTTP requests       | MVC controllers         |
      | @RestController | Combines @Controller and @ResponseBody | REST APIs |

      ```java
      @Service
      public class MyService { /* Business logic */ }

      @Repository
      public interface MyRepository extends JpaRepository<User, Long> { }

      @Controller
      public class MyController { /* Returns HTML views */ }

      @RestController
      public class MyRestController { /* Returns JSON responses */ }
      ```

7. **How do you create a Spring Boot RESTful web service?**
    1. Add spring-boot-starter-web dependency.
    2. Use @RestController and @RequestMapping.
    3. Return JSON responses using @GetMapping, @PostMapping, etc.
    - **Example:**
      ```java
      @RestController
      @RequestMapping("/users")
      public class UserController {
          @GetMapping("/{id}")
          public User getUser(@PathVariable Long id) {
              return new User(id, "John Doe", "john@example.com");
          }
      }
      ```

8. **What is Spring Boot Actuator, and what are its uses?**
    - Spring Boot Actuator provides production-ready features like monitoring and health checks.
    - **Features:**
      - /actuator/health - Check application health.
      - /actuator/info - Display application metadata.
      - /actuator/metrics - Show runtime metrics.
    - **To enable Actuator:**
      ```properties
      management.endpoints.web.exposure.include=*
      ```

9. **What is the significance of @RestController and how is it different from @Controller?**
    - **Example:**

      | Feature       | @Controller               | @RestController         |
      |---------------|---------------------------|-------------------------|
      | Purpose       | Handles web requests      | Handles REST API requests |
      | Return Type   | View (JSP, Thymeleaf)     | JSON or XML             |
      | Requires @ResponseBody | Yes             | No                      |

      ```java
      @Controller
      public class WebController {
          @GetMapping("/hello")
          public String hello(Model model) {
              model.addAttribute("message", "Hello World");
              return "hello"; // Returns a view name
          }
      }

      @RestController
      public class ApiController {
          @GetMapping("/api/hello")
          public String hello() {
              return "Hello, JSON"; // Returns JSON response
          }
      }
      ```

10. **How do you handle exceptions in Spring Boot applications?**
    - **Method 1: Using @ExceptionHandler**
      ```java
      @RestControllerAdvice
      public class GlobalExceptionHandler {
          @ExceptionHandler(UserNotFoundException.class)
          public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
              return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
          }
      }
      ```

    - **Method 2: Using @ControllerAdvice**
      ```java
      @ControllerAdvice
      public class ExceptionHandlerAdvice {
          @ExceptionHandler(Exception.class)
          public String handleException(Model model, Exception ex) {
              model.addAttribute("error", ex.getMessage());
              return "error-page";
          }
      }
      ```

11. **What is Spring Boot DevTools, and what benefits does it provide during development?**
    - Spring Boot DevTools is a module that enhances the development experience by enabling automatic application restarts, live reloads, and other useful features.
    - **Benefits:**
      1. Automatic Restart – Detects code changes and restarts the application.
      2. Live Reload – Refreshes web pages automatically (requires a browser plugin).
      3. Property Defaults – Disables template caching for Thymeleaf, Freemarker, etc.
      4. Remote Debugging – Supports remote development using spring.devtools.remote.secret.
    - **To enable DevTools:**
      ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-devtools</artifactId>
          <scope>runtime</scope>
          <optional>true</optional>
      </dependency>
      ```

12. **How do you use Spring Boot to connect to a database (e.g., MySQL or PostgreSQL)?**
    1. Add the JDBC dependency:
      ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
      </dependency>
      ```
    2. Configure the database in application.properties:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/mydb
      spring.datasource.username=root
      spring.datasource.password=root
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```
    3. Create an Entity and Repository:
      ```java
      @Entity
      public class User {
          @Id @GeneratedValue
          private Long id;
          private String name;
          private String email;
      }

      @Repository
      public interface UserRepository extends JpaRepository<User, Long> { }
      ```

13. **Explain the difference between @Bean and @Component in Spring Boot.**

    | Feature     | @Bean                          | @Component                      |
    |-------------|--------------------------------|---------------------------------|
    | Use Case    | Used in Java configuration classes | Used in component-scanned classes |
    | Defined In  | @Configuration classes         | Regular Java classes            |
    | Lifecycle Control | Full lifecycle control   | Automatically managed by Spring |
    | Example     | Manually defined in a method   | Annotated on a class            |

    - **Example: Using @Bean**
      ```java
      @Configuration
      public class AppConfig {
          @Bean
          public MyService myService() {
              return new MyService();
          }
      }
      ```
    - **Example: Using @Component**
      ```java
      @Component
      public class MyService { }
      ```

14. **How do you configure logging in Spring Boot?**
    - Spring Boot uses SLF4J with Logback as the default logging framework.
    1. Set log levels in application.properties:
      ```properties
      logging.level.root=INFO
      logging.level.com.myapp=DEBUG
      ```
    2. Custom logback.xml:
      ```xml
      <configuration>
          <appender name="FILE" class="ch.qos.logback.core.FileAppender">
              <file>app.log</file>
              <encoder>
                  <pattern>%d [%thread] %-5level %logger{36} - %msg%n</pattern>
              </encoder>
          </appender>
          <root level="info">
              <appender-ref ref="FILE"/>
          </root>
      </configuration>
      ```
    3. Use logging in Java code:
      ```java
      private static final Logger logger = LoggerFactory.getLogger(MyService.class);
      logger.info("Application started successfully");
      ```
 
 
15. **What are Spring Boot profiles, and how do you manage them for different environments (dev, prod)?**
    - Spring Boot profiles allow different configurations for different environments like development, testing, and production.
    1. Define environment-specific application-{profile}.properties:
        - application-dev.properties
        - application-prod.properties
    2. Example configuration:
        ```properties
        # application-dev.properties
        spring.datasource.url=jdbc:mysql://localhost:3306/devdb
        logging.level.root=DEBUG

        # application-prod.properties
        spring.datasource.url=jdbc:mysql://prod-db-host:3306/proddb
        logging.level.root=ERROR
        ```
    3. Activate profile in application.properties:
        ```properties
        spring.profiles.active=dev
        ```
        Or set via command-line:
        ```sh
        java -jar myapp.jar --spring.profiles.active=prod
        ```

16. **How do you implement security in a Spring Boot application?**
    1. Add the dependency:
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        ```
    2. Create a Security Configuration:
        ```java
        @Configuration
        @EnableWebSecurity
        public class SecurityConfig {
            @Bean
            public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                    .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                    .formLogin(Customizer.withDefaults());
                return http.build();
            }
        }
        ```
    3. Default username: `user`, password printed in console.

17. **What is Spring Boot’s embedded server, and how does it work?**
    - Spring Boot comes with embedded servers like Tomcat, Jetty, Undertow.
        - The default is Tomcat (spring-boot-starter-web).
        - Runs inside the application, no need to deploy WAR files.
        - Change the server in pom.xml:
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>
        ```

18. **What is the use of @EnableAutoConfiguration in Spring Boot?**
    - Enables automatic configuration based on classpath dependencies.
    - Internally part of @SpringBootApplication.
    - Uses spring.factories to load configurations.
    ```java
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
    public class MyApplication { }
    ```

19. **What is the difference between application.properties and application.yml files?**

    | Feature                  | application.properties | application.yml |
    |--------------------------|------------------------|-----------------|
    | Format                   | Key-value pairs        | Hierarchical YAML |
    | Readability              | Less readable          | More readable   |
    | Example                  | `server.port=8081`     | `server:\n port: 8081` |

    - YAML is preferred for complex configurations.

20. **What is Spring Boot's support for creating microservices?**
    - Spring Boot simplifies microservices development with:
        1. Spring Cloud – Provides tools for cloud-native apps.
        2. Spring Boot Actuator – Adds monitoring endpoints.
        3. Spring Config Server – Centralized configuration management.
        4. Spring Cloud Eureka – Service discovery.
        5. Spring Cloud Gateway – API gateway for microservices.
    - Example microservice:
        ```java
        @RestController
        @RequestMapping("/users")
        public class UserController {
            @GetMapping("/{id}")
            public User getUser(@PathVariable Long id) {
                return new User(id, "John Doe");
            }
        }
        ```
21. **How does Spring Boot handle dependency injection?**
    - Spring Boot uses Spring’s Dependency Injection (DI) to manage object dependencies.
    - **Types of Dependency Injection:**
        1. Constructor Injection (Recommended)
        2. Setter Injection
        3. Field Injection (Not Recommended)
    - **Example of Constructor Injection:**
      ```java
      @Service
      public class UserService {
          private final UserRepository userRepository;

          @Autowired
          public UserService(UserRepository userRepository) {
              this.userRepository = userRepository;
          }
      }
      ```
    - Spring Boot automatically injects dependencies using @Autowired (though it’s optional for constructors in Spring Boot 2+).

22. **How do you test a Spring Boot application using @SpringBootTest?**
    - @SpringBootTest loads the entire application context for integration testing.
    - **Example of Testing a REST API:**
      ```java
      @SpringBootTest
      @AutoConfigureMockMvc
      class UserControllerTest {
          @Autowired
          private MockMvc mockMvc;

          @Test
          void testGetUser() throws Exception {
              mockMvc.perform(get("/users/1"))
                     .andExpect(status().isOk())
                     .andExpect(jsonPath("$.name").value("John Doe"));
          }
      }
      ```
    - For Unit Testing, use @MockBean to mock dependencies.

23. **Explain the difference between @RequestMapping, @GetMapping, @PostMapping, and other HTTP method annotations.**

    | Annotation     | HTTP Method | Usage             |
    |----------------|-------------|-------------------|
    | @RequestMapping| Any (GET, POST, etc.) | Generic mapping |
    | @GetMapping    | GET         | Fetch data        |
    | @PostMapping   | POST        | Create a resource |
    | @PutMapping    | PUT         | Update a resource |
    | @DeleteMapping | DELETE      | Delete a resource |

    - **Example:**
      ```java
      @RestController
      @RequestMapping("/users")
      public class UserController {

          @GetMapping("/{id}")
          public User getUser(@PathVariable Long id) {
              return new User(id, "John Doe");
          }

          @PostMapping("/")
          public User createUser(@RequestBody User user) {
              return user;
          }
      }
      ```

24. **What are Spring Boot’s default error handling mechanisms, and how can they be customized?**
    - Spring Boot provides default error handling using BasicErrorController.
    - Returns JSON responses like:
      ```json
      {
          "timestamp": "2024-02-11T12:00:00.123+00:00",
          "status": 404,
          "error": "Not Found",
          "message": "User not found",
          "path": "/users/99"
      }
      ```
    - **Custom Error Handling using @ControllerAdvice:**
      ```java
      @RestControllerAdvice
      public class GlobalExceptionHandler {

          @ExceptionHandler(UserNotFoundException.class)
          public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
          }
      }
      ```

25. **How do you perform batch processing in Spring Boot?**
    - Use Spring Batch for processing large volumes of data.
    - **Steps:**
        1. Add Spring Batch dependency.
        2. Create a Job configuration.
        3. Define ItemReader, ItemProcessor, and ItemWriter.
    - **Example:**
      ```java
      @Configuration
      @EnableBatchProcessing
      public class BatchConfig {

          @Bean
          public Job processJob(JobBuilderFactory jobBuilderFactory, Step step) {
              return jobBuilderFactory.get("processJob")
                      .incrementer(new RunIdIncrementer())
                      .start(step)
                      .build();
          }

          @Bean
          public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader,
                           ItemProcessor<String, String> processor, ItemWriter<String> writer) {
              return stepBuilderFactory.get("step")
                      .<String, String>chunk(10)
                      .reader(reader)
                      .processor(processor)
                      .writer(writer)
                      .build();
          }
      }
      ```
 
26. **What is Spring Data JPA, and how is it used in Spring Boot?**
    - Spring Data JPA simplifies database interactions by reducing boilerplate code.
    - **Example:**
      - Define an Entity:
        ```java
        @Entity
        public class User {
            @Id @GeneratedValue
            private Long id;
            private String name;
        }
        ```
      - Create a Repository:
        ```java
        @Repository
        public interface UserRepository extends JpaRepository<User, Long> { }
        ```
      - Use the Repository in a Service:
        ```java
        @Service
        public class UserService {
            @Autowired
            private UserRepository userRepository;

            public User createUser(User user) {
                return userRepository.save(user);
            }
        }
        ```

27. **How do you manage transaction handling in Spring Boot applications?**
    - Use @Transactional for atomicity.
    - By default, Spring Boot uses JPA transaction management.
    - **Example:**
      ```java
      @Service
      public class UserService {
          @Autowired
          private UserRepository userRepository;

          @Transactional
          public void updateUser(Long id, String newName) {
              User user = userRepository.findById(id).orElseThrow();
              user.setName(newName);
          }
      }
      ```

28. **What are the different ways to run a Spring Boot application?**
    - Using Maven or Gradle:
      1. Using IDE (Eclipse, IntelliJ) – Run the main() method.
      2. Deploying to an external Tomcat server (WAR packaging).

29. **Explain the Spring Boot logging mechanism with default loggers (e.g., Logback).**
    - Spring Boot uses SLF4J with Logback by default.
    - **Logging Levels:**
      - TRACE, DEBUG, INFO, WARN, ERROR
    - **Configuring logging in application.properties:**
      ```properties
      logging.level.root=INFO
      logging.level.com.myapp=DEBUG
      ```
    - **Using logs in Java:**
      ```java
      private static final Logger logger = LoggerFactory.getLogger(MyService.class);
      logger.info("Application started");
      ```

30. **How do you configure Spring Boot to send an email (e.g., using JavaMailSender)?**
    1. Add JavaMail dependency:
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
        ```
    2. Configure application.properties:
        ```properties
        spring.mail.host=smtp.gmail.com
        spring.mail.port=587
        spring.mail.username=your-email@gmail.com
        spring.mail.password=your-password
        spring.mail.properties.mail.smtp.auth=true
        spring.mail.properties.mail.smtp.starttls.enable=true
        ```
    3. Create an Email Service:
        ```java
        @Service
        public class EmailService {
            @Autowired
            private JavaMailSender mailSender;

            public void sendEmail(String to, String subject, String text) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(to);
                message.setSubject(subject);
                message.setText(text);
                mailSender.send(message);
            }
        }
        ```
# Java Interview Questions for 3+ Years of Experience

1. **What are the main features of Java?**
    - **Platform Independent:** Java code can run on any platform that has a JVM.
    - **Object-Oriented:** Everything in Java is an object.
    - **Simple and Secure:** Java provides a secure environment for code execution.
    - **Multithreaded:** Java supports multithreading, allowing concurrent execution of two or more threads.
    - **Robust:** Java has strong memory management and exception handling features.

2. **Explain the concept of OOP in Java.**
    - **Object-Oriented Programming (OOP):** A programming paradigm based on the concept of objects.
    - **Key Concepts:**
      - **Encapsulation:** Wrapping data and methods into a single unit (class).
      - **Inheritance:** Mechanism where one class inherits the properties and behavior of another class.
      - **Polymorphism:** Ability to take many forms, e.g., method overloading and overriding.
      - **Abstraction:** Hiding the implementation details and showing only the functionality.

3. **What is the difference between JDK, JRE, and JVM?**
    - **JDK (Java Development Kit):** A software development kit used to develop Java applications.
    - **JRE (Java Runtime Environment):** Provides libraries, Java Virtual Machine (JVM), and other components to run applications written in Java.
    - **JVM (Java Virtual Machine):** An abstract machine that enables your computer to run a Java program.

4. **What are the different types of memory areas allocated by JVM?**
    - **Method Area:** Stores class structures, method data, and constant pool.
    - **Heap:** Runtime data area where objects are allocated.
    - **Stack:** Stores frames, local variables, and partial results.
    - **Program Counter Register:** Contains the address of the JVM instruction currently being executed.
    - **Native Method Stack:** Contains all native methods used in the application.

5. **Explain the concept of garbage collection in Java.**
    - **Garbage Collection:** Automatic memory management feature that deallocates memory used by objects that are no longer reachable.
    - **Types of Garbage Collectors:**
      - **Serial Garbage Collector:** Uses a single thread for garbage collection.
      - **Parallel Garbage Collector:** Uses multiple threads for garbage collection.
      - **CMS (Concurrent Mark-Sweep) Garbage Collector:** Low-latency collector that performs most of its work concurrently with the application.
      - **G1 (Garbage First) Garbage Collector:** Divides the heap into regions and prioritizes garbage collection in regions with the most garbage.

6. **What is the difference between `==` and `equals()` in Java?**
    - **`==`:** Compares references (memory addresses) of objects.
    - **`equals()`:** Compares the content of objects for equality.

7. **What are the access modifiers in Java?**
    - **Private:** Accessible only within the same class.
    - **Default (Package-Private):** Accessible only within the same package.
    - **Protected:** Accessible within the same package and subclasses.
    - **Public:** Accessible from any other class.

8. **Explain the concept of inheritance in Java.**
    - **Inheritance:** Mechanism where one class (child/subclass) inherits the properties and behavior of another class (parent/superclass).
    - **Types of Inheritance:**
      - **Single Inheritance:** A class inherits from one superclass.
      - **Multilevel Inheritance:** A class inherits from a superclass, which in turn inherits from another superclass.
      - **Hierarchical Inheritance:** Multiple classes inherit from one superclass.

9. **What is polymorphism in Java?**
    - **Polymorphism:** Ability of a method to do different things based on the object it is acting upon.
    - **Types:**
      - **Compile-time Polymorphism (Method Overloading):** Multiple methods with the same name but different parameters.
      - **Runtime Polymorphism (Method Overriding):** Subclass provides a specific implementation of a method already defined in its superclass.

10. **What is an interface in Java?**
    - **Interface:** A reference type in Java, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.
    - **Example:**
      ```java
      public interface Animal {
          void eat();
          void sleep();
      }
      ```

11. **What is the difference between abstract class and interface in Java?**
    - **Abstract Class:**
      - Can have both abstract and concrete methods.
      - Can have instance variables.
      - Can have constructors.
    - **Interface:**
      - Can only have abstract methods (until Java 8, which introduced default and static methods).
      - Cannot have instance variables.
      - Cannot have constructors.

12. **Explain exception handling in Java.**
    - **Exception Handling:** Mechanism to handle runtime errors, ensuring the normal flow of the application.
    - **Keywords:**
      - **try:** Block of code to monitor for exceptions.
      - **catch:** Block of code to handle the exception.
      - **finally:** Block of code that executes regardless of an exception.
      - **throw:** Used to explicitly throw an exception.
      - **throws:** Indicates the exceptions that a method can throw.

13. **What is the difference between checked and unchecked exceptions in Java?**
    - **Checked Exceptions:** Exceptions that are checked at compile-time (e.g., IOException, SQLException).
    - **Unchecked Exceptions:** Exceptions that are not checked at compile-time (e.g., NullPointerException, ArithmeticException).

14. **What is multithreading in Java?**
    - **Multithreading:** A process of executing multiple threads simultaneously.
    - **Benefits:**
      - Efficient utilization of CPU.
      - Improved performance.
    - **Creating Threads:**
      - By extending `Thread` class.
      - By implementing `Runnable` interface.

15. **Explain the concept of synchronization in Java.**
    - **Synchronization:** Mechanism to control the access of multiple threads to shared resources.
    - **Synchronized Block:** Limits the scope of synchronization to a block of code.
    - **Synchronized Method:** Synchronizes the entire method.

16. **What is the Java Collections Framework?**
    - **Java Collections Framework:** A set of classes and interfaces that implement commonly reusable collection data structures.
    - **Core Interfaces:**
      - **List:** Ordered collection (e.g., ArrayList, LinkedList).
      - **Set:** Unordered collection with no duplicates (e.g., HashSet, TreeSet).
      - **Map:** Collection of key-value pairs (e.g., HashMap, TreeMap).
      - **Queue:** Collection designed for holding elements prior to processing (e.g., LinkedList, PriorityQueue).

17. **What is the difference between ArrayList and LinkedList in Java?**
    - **ArrayList:**
      - Backed by an array.
      - Provides fast random access.
      - Slower for insertions and deletions.
    - **LinkedList:**
      - Backed by a doubly-linked list.
      - Provides fast insertions and deletions.
      - Slower for random access.

18. **Explain the concept of generics in Java.**
    - **Generics:** Enables types (classes and methods) to be parameters when defining classes, interfaces, and methods.
    - **Benefits:**
      - Type safety.
      - Elimination of casts.
      - Code reusability.
    - **Example:**
      ```java
      public class Box<T> {
          private T t;
          public void set(T t) { this.t = t; }
          public T get() { return t; }
      }
      ```

19. **What is the difference between `HashMap` and `Hashtable` in Java?**
    - **HashMap:**
      - Not synchronized.
      - Allows one null key and multiple null values.
      - Better performance.
    - **Hashtable:**
      - Synchronized.
      - Does not allow null keys or values.
      - Slower performance.

20. **Explain the concept of lambda expressions in Java.**
    - **Lambda Expressions:** Introduced in Java 8, provides a clear and concise way to represent one method interface using an expression.
    - **Syntax:**
      ```java
      (parameters) -> expression
      (parameters) -> { statements; }
      ```
    - **Example:**
      ```java
      List<String> names = Arrays.asList("John", "Jane", "Jack");
      names.forEach(name -> System.out.println(name));
      ```

21. **What is the Stream API in Java?**
    - **Stream API:** Introduced in Java 8, used to process collections of objects.
    - **Features:**
      - Supports functional-style operations.
      - Lazy evaluation.
      - Parallel processing.
    - **Example:**
      ```java
      List<String> names = Arrays.asList("John", "Jane", "Jack");
      names.stream()
            .filter(name -> name.startsWith("J"))
            .forEach(System.out::println);
      ```

22. **What is the difference between `Comparable` and `Comparator` in Java?**
    - **Comparable:**
      - Used to define the natural ordering of objects.
      - Implemented by the class to be compared.
      - Method: `compareTo()`.
    - **Comparator:**
      - Used to define custom ordering of objects.
      - Implemented by a separate class.
      - Method: `compare()`.

23. **Explain the concept of functional interfaces in Java.**
    - **Functional Interface:** An interface with exactly one abstract method.
    - **Example:**
      ```java
      @FunctionalInterface
      public interface MyFunctionalInterface {
          void myMethod();
      }
      ```

24. **What is the significance of the `default` keyword in interfaces?**
    - **Default Methods:** Introduced in Java 8, allows interfaces to have methods with implementation.
    - **Example:**
      ```java
      public interface MyInterface {
          default void myDefaultMethod() {
              System.out.println("Default Method");
          }
      }
      ```

25. **What is the `Optional` class in Java?**
    - **Optional:** A container object which may or may not contain a non-null value.
    - **Purpose:** To avoid `NullPointerException`.
    - **Example:**
      ```java
      Optional<String> optional = Optional.ofNullable("Hello");
      optional.ifPresent(System.out::println);
      ```

26. **Explain the concept of reflection in Java.**
    - **Reflection:** Allows inspection and modification of classes, methods, and fields at runtime.
    - **Uses:**
      - Analyzing class properties.
      - Creating instances of classes.
      - Invoking methods.
    - **Example:**
      ```java
      Class<?> clazz = Class.forName("com.example.MyClass");
      Method method = clazz.getMethod("myMethod");
      method.invoke(clazz.newInstance());
      ```

27. **What is the difference between `final`, `finally`, and `finalize` in Java?**
    - **final:** Keyword used to declare constants, prevent inheritance, and prevent method overriding.
    - **finally:** Block used to execute important code such as closing resources, always executes.
    - **finalize:** Method called by the garbage collector before an object is destroyed.

28. **What is the significance of the `transient` keyword in Java?**
    - **transient:** Keyword used to indicate that a field should not be serialized.
    - **Example:**
      ```java
      public class MyClass implements Serializable {
          private transient int transientField;
      }
      ```

29. **Explain the concept of serialization in Java.**
    - **Serialization:** Process of converting an object into a byte stream.
    - **Deserialization:** Process of converting a byte stream back into an object.
    - **Uses:**
      - Persisting objects.
      - Sending objects over a network.
    - **Example:**
      ```java
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.dat"));
      out.writeObject(new MyClass());
      ```

30. **What is the `volatile` keyword in Java?**
    - **volatile:** Keyword used to indicate that a variable's value will be modified by different threads.
    - **Purpose:** Ensures visibility of changes to variables across threads.
    - **Example:**
      ```java
      public class MyClass {
          private volatile boolean flag;
      }
      ```

### Java advance topic

31. **Explain the concept of Java Memory Model (JMM).**
    - **Java Memory Model:** Defines how threads interact through memory and what behaviors are allowed in concurrent execution.
    - **Key Concepts:**
      - **Happens-Before Relationship:** Guarantees memory visibility and ordering.
      - **Volatile Variables:** Ensure visibility of changes across threads.
      - **Atomicity:** Operations that are performed as a single unit without interference.

32. **What are the different types of class loaders in Java?**
    - **Class Loaders:** Responsible for loading classes into the JVM.
    - **Types:**
      - **Bootstrap Class Loader:** Loads core Java classes (rt.jar).
      - **Extension Class Loader:** Loads classes from the extension directories.
      - **System/Application Class Loader:** Loads classes from the classpath.

33. **Explain the concept of method references in Java.**
    - **Method References:** A shorthand notation of a lambda expression to call a method.
    - **Types:**
      - **Static Method Reference:** `ClassName::staticMethodName`
      - **Instance Method Reference:** `instance::instanceMethodName`
      - **Constructor Reference:** `ClassName::new`
    - **Example:**
      ```java
      List<String> names = Arrays.asList("John", "Jane", "Jack");
      names.forEach(System.out::println);
      ```

34. **What is the Fork/Join framework in Java?**
    - **Fork/Join Framework:** Introduced in Java 7, used for parallel processing by breaking tasks into smaller subtasks.
    - **Key Classes:**
      - **ForkJoinPool:** Manages worker threads.
      - **RecursiveTask:** Represents a task that returns a result.
      - **RecursiveAction:** Represents a task that does not return a result.
    - **Example:**
      ```java
      ForkJoinPool pool = new ForkJoinPool();
      pool.invoke(new MyRecursiveTask());
      ```

35. **Explain the concept of CompletableFuture in Java.**
    - **CompletableFuture:** A class introduced in Java 8 for asynchronous programming.
    - **Features:**
      - **Chaining:** Combine multiple futures.
      - **Exception Handling:** Handle exceptions in asynchronous tasks.
      - **Combining Futures:** Combine results of multiple futures.
    - **Example:**
      ```java
      CompletableFuture.supplyAsync(() -> "Hello")
                       .thenApply(result -> result + " World")
                       .thenAccept(System.out::println);
      ```

36. **What is the significance of the `synchronized` keyword in Java?**
    - **Synchronized Keyword:** Used to control access to a block of code or method by multiple threads.
    - **Types:**
      - **Synchronized Method:** Locks the entire method.
      - **Synchronized Block:** Locks a specific block of code.
    - **Example:**
      ```java
      public synchronized void synchronizedMethod() {
          // synchronized code
      }
      ```

37. **Explain the concept of Java Reflection API.**
    - **Reflection API:** Allows inspection and modification of classes, methods, and fields at runtime.
    - **Uses:**
      - **Analyzing Class Properties:** Inspecting fields, methods, and constructors.
      - **Dynamic Class Loading:** Loading classes at runtime.
      - **Invoking Methods:** Calling methods dynamically.
    - **Example:**
      ```java
      Class<?> clazz = Class.forName("com.example.MyClass");
      Method method = clazz.getMethod("myMethod");
      method.invoke(clazz.newInstance());
      ```

38. **What is the Java Native Interface (JNI)?**
    - **JNI:** A framework that allows Java code to interact with native applications and libraries written in other languages like C or C++.
    - **Uses:**
      - **Performance:** Accessing low-level system resources.
      - **Legacy Code:** Integrating with existing native libraries.
    - **Example:**
      ```java
      public class MyClass {
          static {
              System.loadLibrary("nativeLib");
          }
          public native void nativeMethod();
      }
      ```

39. **Explain the concept of dynamic proxies in Java.**
    - **Dynamic Proxies:** Allows creation of proxy instances at runtime that implement specified interfaces.
    - **Uses:**
      - **AOP (Aspect-Oriented Programming):** Implementing cross-cutting concerns.
      - **Mocking:** Creating mock objects for testing.
    - **Example:**
      ```java
      InvocationHandler handler = (proxy, method, args) -> {
          // custom invocation logic
          return null;
      };
      MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
          MyInterface.class.getClassLoader(),
          new Class<?>[]{MyInterface.class},
          handler
      );
      ```

40. **What is the significance of the `transient` keyword in Java?**
    - **Transient Keyword:** Used to indicate that a field should not be serialized.
    - **Purpose:** Prevents sensitive data from being serialized.
    - **Example:**
      ```java
      public class MyClass implements Serializable {
          private transient int transientField;
      }
      ```

41. **Explain the concept of Java Annotations.**
    - **Annotations:** Metadata that provides information about the code but does not affect its execution.
    - **Types:**
      - **Marker Annotations:** No elements (e.g., @Override).
      - **Single-Value Annotations:** One element (e.g., @SuppressWarnings).
      - **Full Annotations:** Multiple elements (e.g., @Entity).
    - **Example:**
      ```java
      @Retention(RetentionPolicy.RUNTIME)
      @Target(ElementType.METHOD)
      public @interface MyAnnotation {
          String value();
      }
      ```

42. **What is the Java Concurrency API?**
    - **Concurrency API:** Provides classes and interfaces for managing concurrent programming.
    - **Key Components:**
      - **Executor Framework:** Manages thread execution.
      - **Concurrent Collections:** Thread-safe collections (e.g., ConcurrentHashMap).
      - **Locks:** Advanced locking mechanisms (e.g., ReentrantLock).
    - **Example:**
      ```java
      ExecutorService executor = Executors.newFixedThreadPool(10);
      executor.submit(() -> {
          // task code
      });
      ```

43. **Explain the concept of Java Modules (introduced in Java 9).**
    - **Java Modules:** A new way to organize code into modules, providing better encapsulation and dependency management.
    - **Key Features:**
      - **Module Descriptor:** `module-info.java` file.
      - **Encapsulation:** Control over which packages are accessible.
      - **Dependency Management:** Explicitly declare module dependencies.
    - **Example:**
      ```java
      module com.example.myModule {
          requires java.base;
          exports com.example.myPackage;
      }
      ```

44. **What is the significance of the `volatile` keyword in Java?**
    - **Volatile Keyword:** Indicates that a variable's value will be modified by different threads.
    - **Purpose:** Ensures visibility of changes to variables across threads.
    - **Example:**
      ```java
      public class MyClass {
          private volatile boolean flag;
      }
      ```

45. **Explain the concept of Java Agent.**
    - **Java Agent:** A tool that allows you to instrument Java bytecode at runtime.
    - **Uses:**
      - **Profiling:** Monitoring application performance.
      - **Instrumentation:** Modifying bytecode for debugging or logging.
    - **Example:**
      ```java
      public class MyAgent {
          public static void premain(String agentArgs, Instrumentation inst) {
              // instrumentation code
          }
      }
      ```

46. **What is the Java Flight Recorder (JFR)?**
    - **Java Flight Recorder:** A profiling tool built into the JVM for collecting diagnostic and profiling data.
    - **Uses:**
      - **Performance Monitoring:** Analyzing application performance.
      - **Troubleshooting:** Identifying issues in production environments.
    - **Example:**
      ```java
      // Enable JFR at runtime
      jcmd <pid> JFR.start name=MyRecording settings=profile
      ```

47. **Explain the concept of Java Memory Management.**
    - **Memory Management:** The process of allocating and deallocating memory in the JVM.
    - **Key Components:**
      - **Heap:** Stores objects and class instances.
      - **Stack:** Stores method frames and local variables.
      - **Garbage Collection:** Automatic memory management to reclaim unused objects.
    - **Example:**
      ```java
      // Trigger garbage collection
      System.gc();
      ```

48. **What is the Java Virtual Machine (JVM)?**
    - **JVM:** An abstract machine that enables your computer to run a Java program.
    - **Key Components:**
      - **Class Loader:** Loads class files.
      - **Bytecode Verifier:** Ensures bytecode is valid and secure.
      - **Execution Engine:** Executes bytecode instructions.
    - **Example:**
      ```java
      // JVM options
      java -Xmx1024m -Xms512m MyClass
      ```

49. **Explain the concept of Java Security Manager.**
    - **Security Manager:** A class that allows applications to implement a security policy.
    - **Uses:**
      - **Access Control:** Restricting access to system resources.
      - **Sandboxing:** Running untrusted code in a restricted environment.
    - **Example:**
      ```java
      System.setSecurityManager(new SecurityManager());
      ```

50. **What is the Java Cryptography Architecture (JCA)?**
    - **JCA:** A framework for accessing and developing cryptographic functionality.
    - **Key Components:**
      - **Providers:** Implementations of cryptographic algorithms.
      - **APIs:** Classes and interfaces for encryption, decryption, and key management.
    - **Example:**
      ```java
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      SecretKey secretKey = keyGen.generateKey();
      ```


