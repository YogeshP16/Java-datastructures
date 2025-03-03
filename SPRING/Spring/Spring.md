# Spring Framework
1. What is it?
    - A lightweight, open-source Java framework for building enterprise applications.
2. What problem does it solve?
    - Before: Developers had to write boilerplate code for dependency management, transactions, security, etc.
    - Now: Spring provides built-in support for Dependency Injection (DI), AOP, Transaction Management, and more.
3. How does it solve the problem?
    - Uses IoC (Inversion of Control) to manage dependencies automatically.
    - Provides modular components like Spring Boot, Spring MVC, Spring Data, Spring Security, etc.
4. Key Takeaways
    - Reduces complexity in Java applications.
    - Supports microservices, cloud deployment, and RESTful APIs.
    - Works with various databases and third-party tools seamlessly.
        
## Advantages of Using Spring
    1. What is it?
        ○ A Java framework that simplifies enterprise application development with built-in support for various features.
    2. What problem does it solve?
        ○ Before: Developers had to handle manual dependency management, transactions, and security, leading to complex code.
        ○ Now: Spring provides automatic dependency injection, declarative transactions, and security integration, making development easier.
    3. How does it solve the problem?
        ○ Lightweight & Modular: Only use what you need (Spring Boot, Spring MVC, etc.).
        ○ Dependency Injection (DI): Manages object creation and wiring automatically.
        ○ Transaction Management: Built-in support for database transactions.
        ○ AOP (Aspect-Oriented Programming): Separates cross-cutting concerns like logging and security.
        ○ Security & Authentication: Supports OAuth, JWT, and Role-based security.
        ○ Integration: Works with databases, messaging (Kafka, RabbitMQ), and cloud platforms.
    4. Key Takeaways
        ○ Reduces boilerplate code and improves maintainability.
        ○ Supports microservices, REST APIs, and cloud-native apps.
        ○ Backed by a strong community and widely used in enterprises.
        
## Main Modules of the Spring Framework
1. What is it?
    - Spring is divided into multiple modules, each handling a specific aspect of application development.
2. What problem does it solve?
    - Before: Java applications required multiple frameworks for different functionalities (e.g., DI, transactions, web, security).
    - Now: Spring provides an all-in-one solution with modular components.
3. How does it solve the problem?
    - Core Container: Provides Dependency Injection (DI) and IoC (Inversion of Control).
    - Spring AOP: Supports Aspect-Oriented Programming (AOP) for cross-cutting concerns like logging and security.
    - Spring Data Access: Simplifies database access using JDBC, ORM (Hibernate, JPA), and Transactions.
    - Spring MVC: Helps build RESTful APIs and web applications.
    - Spring Security: Provides authentication and authorization (OAuth, JWT, etc.).
    - Spring Boot: Simplifies configuration with auto-configuration and embedded servers.
    - Spring Cloud: Helps build microservices and cloud-native applications.
4. Key Takeaways
    - Each module can be used independently based on project needs.
    - Makes enterprise applications scalable, modular, and easy to maintain.
    - Works with databases, web services, and cloud platforms seamlessly.
        
Inversion of Control (IoC) in Spring
    1. What is it?
        ○ A design principle where the control of object creation and lifecycle is given to the Spring container instead of being managed manually.
    2. What problem does it solve?
        ○ Before: Objects were created manually using new and were tightly coupled.
        ○ Now: Spring manages object creation, reducing dependency and increasing flexibility.
    3. How does it solve the problem?
        ○ Uses Dependency Injection (DI) to inject dependencies automatically.
        ○ Spring’s IoC Container (ApplicationContext) manages bean creation and lifecycle.
    4. Key Takeaways
        ○ Makes applications loosely coupled and easier to test.
        ○ Works with XML (beans.xml) or annotations (@Component, @Bean).
        ○ IoC container is the core of Spring Framework.

Dependency Injection (DI) in Spring
    1. What is it?
        ○ A design pattern where Spring injects dependencies (objects) instead of creating them manually.
    2. What problem does it solve?
        ○ Before: Objects were tightly coupled (new ClassA() inside ClassB).
        ○ Now: Loose coupling allows better maintainability and testing.
    3. How does it solve the problem?
        ○ Uses Constructor Injection, Setter Injection, or Field Injection.
        ○ Spring manages object creation and wiring using the IoC (Inversion of Control) container.
    4. Key Takeaways
        ○ Improves scalability and testability.
        ○ Uses @Autowired or defines beans in @Configuration.
        ○ Works with Spring Boot, Spring Core, and Spring MVC.

Difference Between Tight Coupling and Loose Coupling
    1. What is it?
        ○ Tight Coupling: Objects are highly dependent on each other.
        ○ Loose Coupling: Objects interact with minimal dependencies.
    2. What problem does it solve?
        ○ Before (Tight Coupling): Changes in one class require modifications in dependent classes.
        ○ Now (Loose Coupling): Changes in one class don’t affect others, improving flexibility.
    3. How does it solve the problem?
        ○ Tight Coupling: 
class Car {
    Engine engine = new Engine(); // Hardcoded dependency
}
        ○ Loose Coupling (Using Dependency Injection): 
class Car {
    private Engine engine;
    Car(Engine engine) { this.engine = engine; } // Injected via constructor
}
        ○ Loose coupling uses interfaces, dependency injection (DI), and IoC to reduce direct dependencies.
    4. Key Takeaways
        ○ Tight Coupling → Harder to maintain, test, and extend.
        ○ Loose Coupling → Improves modularity, flexibility, and testability.
        ○ Spring Framework promotes loose coupling using IoC and DI.

Types of Dependency Injection in Spring
    1. What is it?
        ○ Dependency Injection (DI) is a design pattern that allows Spring to inject dependencies into beans instead of creating them manually.
    2. What problem does it solve?
        ○ Before: Objects were tightly coupled (new keyword was used everywhere).
        ○ Now: Spring injects dependencies automatically, making code loosely coupled and easier to test.
    3. Types of Dependency Injection
        ○ 1. Constructor Injection (Recommended)
            § Injects dependencies via constructor parameters.
            § Ensures all required dependencies are provided at object creation.
@Component
class Car {
    private Engine engine;
    @Autowired
    public Car(Engine engine) { this.engine = engine; } // Injected via constructor
}
        ○ 2. Setter Injection
            § Injects dependencies via setter methods.
            § Allows optional dependencies.
@Component
class Car {
    private Engine engine;
    @Autowired
    public void setEngine(Engine engine) { this.engine = engine; } // Injected via setter
}
        ○ 3. Field Injection (Not recommended for required dependencies)
            § Uses @Autowired directly on fields.
@Component
class Car {
    @Autowired
    private Engine engine; // Injected directly
}
    4. Key Takeaways
        ○ Constructor Injection → Best for mandatory dependencies (Immutable, testable).
        ○ Setter Injection → Best for optional dependencies.
        ○ Field Injection → Avoid for required dependencies (harder to test, not immutable).

BeanFactory vs ApplicationContext
    1. What is it?
        ○ BeanFactory and ApplicationContext are Spring containers that manage beans.
    2. What problem does it solve?
        ○ Before: Objects were created manually using new, leading to tight coupling.
        ○ Now: Spring containers manage object creation, initialization, and lifecycle automatically.
    3. Differences
    Feature	BeanFactory	ApplicationContext
    Type	Basic, lightweight container	Advanced, feature-rich container
    Lazy Loading	Loads beans only when needed	Loads beans at startup (default)
    Event Handling	❌ Not supported	✅ Supports event publishing
    AOP Support	❌ Limited support	✅ Full AOP support
    Internationalization	❌ Not supported	✅ Supports i18n
    4. How does it solve the problem?
        ○ BeanFactory (Manual Lazy Loading) 
BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
Car car = (Car) factory.getBean("carBean"); // Bean created on demand
        ○ ApplicationContext (Auto Eager Loading + Features) 
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
Car car = context.getBean(Car.class); // Beans initialized at startup
    5. Key Takeaways
        ○ Use BeanFactory when you need a lightweight container (e.g., mobile, IoT apps).
        ○ Use ApplicationContext for enterprise apps since it supports AOP, events, i18n, and auto bean loading.
        ○ Spring Boot always uses ApplicationContext internally.


How Does Spring Support IoC Containers?
    1. What is it?
        ○ IoC (Inversion of Control) means the control of object creation and dependency management is handled by Spring, not manually.
        ○ Spring provides IoC containers to manage beans.
    2. What problem does it solve?
        ○ Before: Developers had to manually instantiate and manage object dependencies (new keyword).
        ○ Now: Spring automatically injects dependencies and manages the object lifecycle.
    3. How does it solve the problem?
        ○ Spring provides two IoC containers:
            1. BeanFactory → Lightweight, basic IoC container.
            2. ApplicationContext → Advanced IoC container with extra features (AOP, event handling).
        ○ Example using ApplicationContext:
@Component
class Engine { }  

@Component
class Car {
    private Engine engine;
    
    @Autowired  // Spring injects the Engine automatically
    public Car(Engine engine) { this.engine = engine; } 
}

public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Car car = context.getBean(Car.class); // No 'new' keyword used!
}
    4. Key Takeaways
        ○ IoC removes manual object creation, reducing tight coupling.
        ○ Spring IoC containers (BeanFactory, ApplicationContext) manage dependencies.
        ○ Spring Boot internally uses ApplicationContext to auto-configure beans.


What is a Spring Bean?
    1. What is it?
        ○ A Spring Bean is an object that Spring manages and instantiates within its IoC container.
        ○ Beans are created, configured, and wired automatically by Spring.
    2. What problem does it solve?
        ○ Before: Objects were created manually using new, leading to tight coupling.
        ○ Now: Spring handles object creation and dependency injection, making the application loosely coupled and easier to manage.

How Do You Define a Bean in Spring?
There are three ways to define a bean:
    1. Using XML Configuration
<bean id="carBean" class="com.example.Car"/>
        ○ Used in older Spring applications.
    2. Using Annotations (@Component)
@Component
class Car { }  
        ○ Spring automatically registers this class as a bean when scanning packages.
    3. Using Java Config (@Bean)
@Configuration
class AppConfig {
    @Bean
    public Car car() { return new Car(); }
}
        ○ Provides manual control over bean creation.

What Are the Different Ways to Configure Spring Beans?
Configuration Type	Example	When to Use?
XML Configuration	<bean> in beans.xml	Legacy projects, when annotations aren’t possible.
Annotation-Based (@Component)	@Component, @Service, @Repository	Recommended for automatic bean scanning.
Java Configuration (@Bean)	@Configuration + @Bean	When more control is needed over bean instantiation.

Key Takeaways
    • Spring Beans are managed objects created inside the Spring IoC container.
    • Recommended Approach: Use Annotations (@Component) or Java Config (@Bean) in modern Spring applications.
    • Spring Boot automatically scans for beans without requiring XML configuration.

Different Bean Scopes in Spring
    1. What is it?
        ○ Bean Scope defines how long a bean instance should live and how it is shared within the application.
        ○ Spring provides five scopes for beans.
    2. What problem does it solve?
        ○ Before: Developers manually managed object instances, leading to memory issues.
        ○ Now: Spring controls bean lifecycles automatically, optimizing memory and performance.

Different Bean Scopes in Spring
Scope	Description	Usage Example
Singleton (Default)	Only one instance per Spring container.	@Component (default behavior)
Prototype	A new instance is created every time it’s requested.	@Scope("prototype")
Request (Web Only)	A new instance is created per HTTP request.	@Scope("request")
Session (Web Only)	A new instance is created per user session.	@Scope("session")
Application (Web Only)	A single instance is created per ServletContext.	@Scope("application")

What Is the Default Scope of a Bean in Spring?
    • The default scope is Singleton → One instance per Spring container.
    • Example (Singleton Scope, Default):
@Component
class Car { }

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApp.class, args);
        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        System.out.println(car1 == car2); // true (Same instance)
    }
}
    • Example (Prototype Scope, New Instance Every Time):
@Component
@Scope("prototype")
class Car { }
        ○ Now, context.getBean(Car.class) returns a new instance each time.

Key Takeaways
    • Singleton is the default scope.
    • Use Prototype when you need a new instance every time.
    • Request, Session, and Application scopes are for web applications.
    • Spring Boot uses Singleton by default, ensuring efficient memory use.

Spring Bean Lifecycle
    1. What is it?
        ○ The Spring Bean Lifecycle defines how a bean is created, initialized, used, and destroyed by the Spring container.
        ○ Spring provides hooks to execute code at different stages of a bean's lifecycle.
    2. What problem does it solve?
        ○ Before: Developers manually handled resource initialization and cleanup.
        ○ Now: Spring automates object creation, initialization, and destruction, ensuring better memory management.

How Do You Initialize and Destroy a Bean in Spring?
Spring provides three ways to define initialization and destruction methods:
    1. Using @PostConstruct and @PreDestroy (Recommended)
@Component
class Car {
    @PostConstruct
    public void init() { System.out.println("Car initialized!"); }

@PreDestroy
    public void destroy() { System.out.println("Car destroyed!"); }
}
        ○ @PostConstruct → Runs after the bean is created and dependencies are injected.
        ○ @PreDestroy → Runs before the bean is removed from the container.
    2. Using initMethod and destroyMethod in @Bean Configuration
@Configuration
class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() { return new Car(); }
}
    3. Implementing InitializingBean and DisposableBean (Not Recommended)
class Car implements InitializingBean, DisposableBean {
    public void afterPropertiesSet() { System.out.println("Car initialized!"); }
    public void destroy() { System.out.println("Car destroyed!"); }
}

Annotations Used for Lifecycle Methods
Annotation/Method	Purpose	Where to Use?
@PostConstruct	Executes after the bean is initialized.	Method inside a bean.
@PreDestroy	Executes before the bean is destroyed.	Method inside a bean.
initMethod (in @Bean)	Specifies initialization method.	Java Config (@Configuration).
destroyMethod (in @Bean)	Specifies destruction method.	Java Config (@Configuration).
afterPropertiesSet()	Executes after properties are set.	InitializingBean Interface.
destroy()	Executes when bean is destroyed.	DisposableBean Interface.

Key Takeaways
    • Spring manages the entire lifecycle of a bean (creation → initialization → destruction).
    • Recommended Approach: Use @PostConstruct and @PreDestroy.
    • Spring Boot automatically manages bean destruction in singleton scope but Prototype beans must be destroyed manually.

Constructor-Based vs. Setter-Based Dependency Injection
    1. What is Dependency Injection (DI)?
        ○ Dependency Injection (DI) is a design pattern where Spring injects dependencies into a class rather than the class creating them.
        ○ Spring provides two main types of DI: 
            1. Constructor-Based DI
            2. Setter-Based DI
    2. What problem does it solve?
        ○ Before: Objects were created manually using new, leading to tight coupling.
        ○ Now: Spring injects dependencies automatically, making the code loosely coupled and easier to test.

1. Constructor-Based Dependency Injection
    • Injects dependencies via constructor.
    • Ensures immutability (dependencies cannot be changed after object creation).
    • Best for mandatory dependencies.
Example:
@Component
class Car {
    private final Engine engine;
@Autowired  // Injects dependency via constructor
    public Car(Engine engine) {
        this.engine = engine;
    }
}
    • Spring Boot automatically injects dependencies if there is only one constructor.

2. Setter-Based Dependency Injection
    • Injects dependencies via setter methods.
    • Allows optional dependencies (dependency can be set or modified later).
    • Useful when dependencies are not always required.
Example:
@Component
class Car {
    private Engine engine;
@Autowired  // Injects dependency via setter
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

3. Differences Between Constructor and Setter Injection
Feature	Constructor Injection	Setter Injection
How it injects?	Uses constructor	Uses setter methods
Mandatory Dependency?	Yes, required at object creation	No, can be optional
Encapsulation?	Ensures immutability	Allows modification later
Recommended For?	Required dependencies	Optional dependencies
Testing	Better for unit testing (ensures object integrity)	More flexible but can be misused

Key Takeaways
    • Use Constructor Injection for required dependencies and immutability.
    • Use Setter Injection for optional dependencies and when values may change.
    • Spring Boot prefers Constructor Injection for better testability and immutability.

Circular Dependency in Spring
1. What is it?
A circular dependency occurs when two or more beans depend on each other, creating a loop.
2. What problem does it cause?
    • Before: Spring tries to create Bean A, but it needs Bean B → Spring tries to create Bean B, but it needs Bean A → Deadlock occurs.
    • Now: Spring detects circular dependencies and throws an error (except for setter-based DI, where it handles it).

Example of Circular Dependency (Constructor Injection)
@Component
class A {
    private final B b;
    @Autowired
    public A(B b) { this.b = b; }
}
@Component
class B {
    private final A a;
    @Autowired
    public B(A a) { this.a = a; }
}
🚨 Spring will throw BeanCurrentlyInCreationException!

How to Resolve Circular Dependencies?
Solution	How It Works?	When to Use?
1. Use Setter Injection	Spring initializes beans first, then injects dependencies via setters.	When circular dependency exists.
2. Use @Lazy Annotation	Delays bean creation until it's actually needed.	When lazy initialization is acceptable.
3. Use @Primary or @Qualifier	Helps Spring resolve which bean to use.	When multiple beans exist.
4. Break the Dependency	Refactor to avoid circular references.	When architecture allows.
5. Use ObjectFactory or Provider	Creates dependencies on demand.	When dynamic dependency resolution is needed.

Solution 1: Setter Injection (Recommended)
@Component
class A {
    private B b;
    @Autowired
    public void setB(B b) { this.b = b; }
}
@Component
class B {
    private A a;
    @Autowired
    public void setA(A a) { this.a = a; }
}
✅ Spring initializes A and B without issues.

Solution 2: @Lazy Annotation
@Component
class A {
    private final B b;
    @Autowired
    public A(@Lazy B b) { this.b = b; }
}
✅ Spring delays Bean B’s creation until it's actually needed.

Solution 3: Using ObjectProvider (For On-Demand Beans)
@Component
class A {
    private final ObjectProvider<B> bProvider;
    @Autowired
    public A(ObjectProvider<B> bProvider) {
        this.bProvider = bProvider;
    }
}
✅ Creates Bean B only when required, avoiding the loop.

Key Takeaways
    • Spring cannot resolve circular dependencies with Constructor Injection.
    • Setter Injection or @Lazy can break the loop.
    • Use ObjectProvider for on-demand dependency resolution.
    • Best practice: Avoid circular dependencies with better architecture.

1. What is @Autowired?
    • @Autowired is a Spring annotation used for automatic dependency injection.
    • It tells Spring to find a matching bean and inject it automatically into a class.
Example:
@Component
class Engine {}
@Component
class Car {
    private final Engine engine;
@Autowired  // Spring automatically injects the Engine bean
    public Car(Engine engine) {
        this.engine = engine;
    }
}
✅ Spring finds the Engine bean and injects it into Car.

2. @Autowired vs. @Inject vs. @Resource
Annotation	Framework	Behavior
@Autowired	Spring	Injects dependency by type (default). Requires Spring.
@Inject	Jakarta (JSR-330)	Same as @Autowired, but comes from Java EE (not Spring-specific).
@Resource	Java EE (JSR-250)	Injects dependency by name (first) and by type (if name is not found).
Example:
@Autowired  // Injects by type
private Engine engine;
@Inject  // Works like @Autowired
private Engine engine;
@Resource  // Injects by name (looks for a bean named "engine")
private Engine engine;
✅ Use @Autowired in Spring applications.
✅ Use @Resource only when you want to inject by name.

3. How Does @Qualifier Help in Resolving Bean Conflicts?
When multiple beans of the same type exist, Spring does not know which one to inject and throws an error.
👉 @Qualifier lets you specify the exact bean to inject.
Example (Without @Qualifier)
@Component
class PetrolEngine {}
@Component
class DieselEngine {}
@Component
class Car {
    private final Engine engine;
@Autowired  // ERROR: Multiple Engine beans found!
    public Car(Engine engine) {
        this.engine = engine;
    }
}
🚨 Spring throws an error because it finds two Engine beans (PetrolEngine and DieselEngine).
Example (With @Qualifier)
@Component
class PetrolEngine {}
@Component
class DieselEngine {}
@Component
class Car {
    private final Engine engine;
@Autowired
    public Car(@Qualifier("dieselEngine") Engine engine) {  // Explicitly specify bean
        this.engine = engine;
    }
}
✅ Spring now injects DieselEngine into Car.

4. What is @Primary?
    • When multiple beans exist, @Primary tells Spring which one to use by default.
    • If no @Qualifier is provided, Spring chooses the @Primary bean.
Example:
@Component
@Primary  // Marks this as the default bean
class PetrolEngine {}
@Component
class DieselEngine {}
@Component
class Car {
    private final Engine engine;
@Autowired
    public Car(Engine engine) {  // PetrolEngine is injected because it's marked @Primary
        this.engine = engine;
    }
}
✅ PetrolEngine is injected because it is marked with @Primary.
✅ Use @Qualifier if you need to override @Primary.

Key Takeaways
    • @Autowired injects dependencies automatically by type.
    • @Inject works like @Autowired but is from Java EE.
    • @Resource injects by name first, then by type.
    • Use @Qualifier to resolve conflicts when multiple beans exist.
    • Use @Primary to set a default bean when multiple options exist.







