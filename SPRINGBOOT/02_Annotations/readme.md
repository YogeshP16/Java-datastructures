## **`@Component` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@Component` is a **generic Spring annotation** used to define a **bean** (a managed object in Spring’s IoC container).  
- It **tells Spring** to automatically detect and instantiate this class as a **Spring bean** during component scanning.  

```java
@Component
public class MyComponent {
    public void doSomething() {
        System.out.println("Component logic executed!");
    }
}
```
✅ **Spring automatically registers `MyComponent` as a bean**.

---

### **2️⃣ R - Reverse (How `@Component` Works Internally?)**  
- Spring scans the package where `@Component` is declared.  
- It registers the class as a bean in the **ApplicationContext**.  
- We can use `@Autowired` to inject it into other components.  

```java
@Service
public class MyService {
    private final MyComponent myComponent;

    @Autowired
    public MyService(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public void performTask() {
        myComponent.doSomething();
    }
}
```
✅ **Now `MyComponent` is injected into `MyService` using constructor injection.**  

---

### **3️⃣ I - Inspect (Difference Between `@Component`, `@Service`, `@Repository`)**  

| Annotation     | Purpose |
|---------------|---------|
| `@Component`  | Generic stereotype for any Spring-managed bean. |
| `@Service`    | Specialized for **service layer** (business logic). |
| `@Repository` | Specialized for **DAO layer** (database operations, exception translation). |

✅ **Example: When to Use What?**  
```java
@Component
public class UtilityHelper {} // Generic helper class  

@Service
public class UserService {} // Business logic  

@Repository
public class UserRepository {} // Data access logic  
```
---

### **4️⃣ M - Modify (Customization & Best Practices)**  

#### **1️⃣ Custom Bean Naming (`@Component("customName")`)**  
- Default bean name = class name in **camelCase** (`myComponent`).  
- You can override it:  
```java
@Component("customBeanName")
public class MyComponent {}
```
- Access it by name:  
```java
@Autowired
@Qualifier("customBeanName")
private MyComponent myComponent;
```

#### **2️⃣ Manual Bean Definition (Alternative to `@Component`)**  
Instead of `@Component`, define a bean manually in a configuration class:  
```java
@Configuration
public class AppConfig {
    @Bean
    public MyComponent myComponent() {
        return new MyComponent();
    }
}
```

---

## **`@Service` & `@Repository` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- Both `@Service` and `@Repository` are **specialized versions of `@Component`**, meaning they **register classes as Spring beans**.  
- **`@Service`** → Used in the **service layer** for **business logic**.  
- **`@Repository`** → Used in the **data access layer (DAO)** for **database operations**.  

✅ **Example:**  
```java
@Service
public class UserService {
    public String getUser() {
        return "User from Service";
    }
}

@Repository
public class UserRepository {
    public String getUserFromDB() {
        return "User from Database";
    }
}
```
---

### **2️⃣ R - Reverse (How Do `@Service` and `@Repository` Work Internally?)**  
- Both **inherit `@Component`**, so they are detected during **component scanning**.  
- **Service layer (`@Service`) handles business logic**, while  
- **Repository layer (`@Repository`) interacts with the database**.  

✅ **Injecting Repository into Service**  
```java
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser() {
        return userRepository.getUserFromDB();
    }
}
```
- `UserService` depends on `UserRepository`, which is **automatically injected**.  

---

### **3️⃣ I - Inspect (Why Use `@Service` and `@Repository` Instead of `@Component`?)**  

| Annotation     | Purpose |
|---------------|---------|
| `@Component`  | Generic stereotype for any Spring-managed bean. |
| `@Service`    | Used for business logic or service layer. |
| `@Repository` | Used for database operations (includes exception translation). |

✅ **Exception Translation in `@Repository`**  
Spring automatically **converts JDBC exceptions to Spring’s `DataAccessException` hierarchy**, making error handling easier.  

```java
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, new UserRowMapper());
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error occurred");
        }
    }
}
```
---

### **4️⃣ M - Modify (Customization & Best Practices)**  

#### **1️⃣ Custom Bean Naming (`@Service("customService")`)**  
```java
@Service("customService")
public class UserService { }
```
- Now it can be injected using:  
```java
@Autowired
@Qualifier("customService")
private UserService userService;
```

#### **2️⃣ Alternative to `@Repository`: Manually Defining Beans**  
```java
@Configuration
public class AppConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
```
- Works the same way but **without component scanning**.

---

## **`@Configuration` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@Configuration` is an **annotation in Spring** that **marks a class as a source of bean definitions**.  
- It is used to **define beans manually** in a **Java-based configuration** instead of XML.  

✅ **Example:**  
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```
- The `myService()` method creates a **Spring-managed bean**.  
- Works **similarly to `@Component`, but with manual control over bean creation**.  

---

### **2️⃣ R - Reverse (How `@Configuration` Works Internally?)**  
- **Spring scans the class annotated with `@Configuration`** during startup.  
- The methods annotated with `@Bean` **return Spring-managed objects**.  
- It ensures **only one instance of each bean is created (Singleton by default).**  

✅ **Example of Injecting Beans in Another Class**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(MyService myService) {
        this.myService = myService;
    }
}
```
- `MyService` is injected into `MyAppService` automatically.

---

### **3️⃣ I - Inspect (Why Use `@Configuration` Instead of `@Component`?)**  

| Annotation     | Purpose |
|---------------|---------|
| `@Component`  | Automatically detects and registers the class as a bean. |
| `@Configuration`  | Manually defines and configures beans using `@Bean`. |
| `@Bean`  | Registers a method’s return object as a Spring bean. |

✅ **Use `@Configuration` When:**  
1. You need **more control over bean creation** (e.g., setting properties, factory patterns).  
2. You want to define **third-party beans** (like external libraries).  

✅ **Example: Defining a Third-Party Bean (DataSource)**  
```java
@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(); // Manually configuring a connection pool
    }
}
```
- Instead of `@Component`, we **manually configure a DataSource bean**.  

---

### **4️⃣ M - Modify (Customization & Best Practices)**  

#### **1️⃣ Combining `@Configuration` with `@ComponentScan`**  
```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig { }
```
- **This scans for all `@Component`, `@Service`, and `@Repository` annotations**.

#### **2️⃣ Avoiding Multiple Instances Using `@Bean`**  
Spring **ensures a bean defined inside `@Configuration` is a Singleton**.  

✅ **Example:**  
```java
@Configuration
public class SingletonConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```
- **Ensures only one `MyService` instance** exists in the Spring container.

---

## **`@Bean` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@Bean` is an annotation in Spring used **inside a `@Configuration` class** to **define and manage Spring beans manually**.  
- It is an alternative to `@Component` when you need **more control** over bean creation.  

✅ **Example:**  
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService(); // Creates a Spring-managed bean
    }
}
```
- `myService()` returns an object that **Spring registers as a bean**.

---

### **2️⃣ R - Reverse (How `@Bean` Works Internally?)**  
- When the application starts, Spring **calls methods annotated with `@Bean`** and **registers their return objects as beans**.  
- Unlike `@Component`, it allows **fine-grained control** over how beans are created.  

✅ **Injecting `@Bean` into Another Component**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(MyService myService) {
        this.myService = myService;
    }
}
```
- `MyService` is **automatically injected**, just like a `@Component` bean.

---

### **3️⃣ I - Inspect (Why Use `@Bean` Instead of `@Component`?)**  

| Annotation     | Purpose |
|---------------|---------|
| `@Component`  | Automatically detects and registers the class as a bean. |
| `@Bean`  | Manually registers a method’s return object as a Spring bean. |

✅ **Use `@Bean` When:**  
1. You **cannot modify a third-party class** (e.g., configuring an external library).  
2. You need **custom initialization logic** before returning a bean.  
3. You want to **configure multiple variations of a bean**.  

✅ **Example: Defining a Third-Party Bean (DataSource)**  
```java
@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(); // Manually configuring a connection pool
    }
}
```
- Instead of `@Component`, we **manually configure a DataSource bean**.  

---

### **4️⃣ M - Modify (Customization & Best Practices)**  

#### **1️⃣ Custom Bean Naming (`@Bean("customBean")`)**  
```java
@Bean("customService")
public MyService myService() {
    return new MyService();
}
```
- Now, it can be injected using:  
```java
@Autowired
@Qualifier("customService")
private MyService myService;
```

#### **2️⃣ Using `@Bean` with Factory Methods**  
✅ **Example:**  
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return MyService.createInstance(); // Custom factory method
    }
}
```

---

## **`@Autowired` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@Autowired` is a **Spring dependency injection (DI) annotation** that **automatically injects beans** into a class.  
- It eliminates the need for **manual object creation** (`new MyService()`), letting Spring handle dependencies.  

✅ **Example: Injecting a Service into Another Component**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired  // Spring injects MyService automatically
    public MyAppService(MyService myService) {
        this.myService = myService;
    }
}
```
- `@Autowired` tells Spring to **find and inject** an instance of `MyService`.

---

### **2️⃣ R - Reverse (How `@Autowired` Works Internally?)**  
1. **Spring scans the application context** for a matching bean.  
2. **If exactly one match is found**, it injects the bean.  
3. **If multiple matches are found**, it throws an error unless a specific bean is chosen using `@Qualifier`.  

✅ **Example: Handling Multiple Beans with `@Qualifier`**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(@Qualifier("customService") MyService myService) {
        this.myService = myService;
    }
}
```
- This ensures **Spring injects the bean named `customService`**.

---

### **3️⃣ I - Inspect (Ways to Use `@Autowired`)**  

#### **1️⃣ Constructor Injection (Recommended ✅)**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(MyService myService) {
        this.myService = myService;
    }
}
```
✅ **Why?**  
- Ensures **dependency is always available**.  
- Supports **immutability** (final fields).  
- Works well with **unit testing**.  

#### **2️⃣ Field Injection (Not Recommended ❌)**  
```java
@Service
public class MyAppService {
    @Autowired
    private MyService myService;
}
```
🚫 **Why Avoid?**  
- Hard to **mock in tests**.  
- Breaks **dependency inversion** principle.  

#### **3️⃣ Setter Injection (Used for Optional Dependencies)**  
```java
@Service
public class MyAppService {
    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
```
✅ **Use Case:**  
- When **dependency is optional**.  

---

### **4️⃣ M - Modify (Customization & Best Practices)**  

#### **1️⃣ Using `@Primary` to Avoid Multiple Bean Conflicts**  
```java
@Service
@Primary
public class DefaultService implements MyService { }
```
- `@Primary` tells Spring to **prefer this bean** if multiple beans match.  

#### **2️⃣ Using `@Lazy` for Delayed Initialization**  
```java
@Autowired
@Lazy
private MyService myService;
```
- `@Lazy` **delays bean creation** until it's actually needed.  

---

## **`@Qualifier` vs. `@Primary` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **`@Primary`**: Used when multiple beans of the same type exist, **marking one as the default**.  
- **`@Qualifier`**: Used to **explicitly specify** which bean should be injected when multiple beans exist.  

✅ **Example: Two Beans, One Service Needs Injection**  
```java
@Service
@Primary  // This bean is chosen by default if no @Qualifier is used
public class DefaultService implements MyService { }

@Service
public class CustomService implements MyService { }
```
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(MyService myService) {
        this.myService = myService;  // DefaultService is injected because of @Primary
    }
}
```

---

### **2️⃣ R - Reverse (How They Work Internally?)**  
- If multiple beans match a type, Spring:  
  1. **First checks for `@Primary`** and selects it.  
  2. **If no `@Primary` is found, an error occurs** unless `@Qualifier` is used.  

✅ **Using `@Qualifier` to Specify a Bean**  
```java
@Service
public class MyAppService {
    private final MyService myService;

    @Autowired
    public MyAppService(@Qualifier("customService") MyService myService) {
        this.myService = myService;  // Now CustomService is injected
    }
}
```
- Here, `customService` is explicitly chosen **instead of `@Primary`**.

---

### **3️⃣ I - Inspect (Key Differences & Best Practices)**  

| Feature       | `@Primary`  | `@Qualifier`  |
|--------------|------------|--------------|
| **Purpose** | Default bean selection | Explicit bean selection |
| **When to Use?** | When a single bean is preferred for most cases | When multiple beans exist and selection is required |
| **Scope** | Applied at the **class level** | Applied at the **injection point** |
| **Override?** | Can be overridden by `@Qualifier` | Overrides `@Primary` |

✅ **Best Practice:**  
- **Use `@Primary`** when one bean is **clearly the default**.  
- **Use `@Qualifier`** when **multiple beans are required for different use cases**.  

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### **1️⃣ `@Primary` with Multiple Beans**  
```java
@Service
@Primary
public class DefaultPaymentService implements PaymentService { }

@Service
public class PremiumPaymentService implements PaymentService { }
```
- `DefaultPaymentService` is injected **by default** unless `@Qualifier` is used.  

#### **2️⃣ `@Qualifier` with Lists of Beans**  
✅ **Injecting Multiple Beans in a List**  
```java
@Service
public class MyAppService {
    private final List<MyService> myServices;

    @Autowired
    public MyAppService(List<MyService> myServices) {
        this.myServices = myServices;  // Injects all MyService beans
    }
}
```
- This injects **both `DefaultService` and `CustomService`** into the list.  

---

## **Spring Boot Profiles - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- Spring Boot **Profiles** allow switching between different configurations based on the environment (e.g., `dev`, `test`, `prod`).  
- Profiles help manage **different database settings, logging levels, and application behaviors** without changing the code.  
- Defined using **`application-{profile}.properties`** or **`@Profile` annotation**.

✅ **Example: Setting Up Different Properties for `dev` and `prod`**  

📌 **`application-dev.properties`**  
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/devdb
```

📌 **`application-prod.properties`**  
```properties
server.port=9090
spring.datasource.url=jdbc:mysql://prod-db-server:3306/proddb
```

🔹 **How to Activate a Profile?**  
- **Via `application.properties`**:  
  ```properties
  spring.profiles.active=dev
  ```
- **Via Command Line**:  
  ```sh
  java -jar myapp.jar --spring.profiles.active=prod
  ```
- **Via Environment Variable**:  
  ```sh
  export SPRING_PROFILES_ACTIVE=prod
  ```

---

### **2️⃣ R - Reverse (How It Works Internally?)**  
1. **Spring Boot detects the active profile** from properties, environment variables, or command-line arguments.  
2. It **loads the corresponding `application-{profile}.properties` file**.  
3. If no profile is specified, it uses `application.properties`.  
4. **Profile-specific beans** are also loaded using `@Profile`.  

✅ **Example: Defining Beans Based on Profile**  
```java
@Component
@Profile("dev")
public class DevDataSourceConfig implements DataSourceConfig {
    // Dev-specific configuration
}
```
```java
@Component
@Profile("prod")
public class ProdDataSourceConfig implements DataSourceConfig {
    // Prod-specific configuration
}
```
- If **`spring.profiles.active=dev`**, only `DevDataSourceConfig` is used.

---

### **3️⃣ I - Inspect (Use Cases & Best Practices)**  

✅ **Best Practices for Using Profiles**  
| Use Case        | Recommended Approach |
|----------------|---------------------|
| Switching database connections | Use `application-{profile}.properties` |
| Different log levels per environment | Use `logback-{profile}.xml` |
| Loading beans conditionally | Use `@Profile` annotation |
| Externalized config in Docker/Kubernetes | Use environment variables |

✅ **Using `@Profile` for Service Implementations**  
```java
@Service
@Profile("dev")
public class DevEmailService implements EmailService {
    public void sendEmail() {
        System.out.println("Sending email in Dev mode");
    }
}
```
```java
@Service
@Profile("prod")
public class ProdEmailService implements EmailService {
    public void sendEmail() {
        System.out.println("Sending email in Prod mode");
    }
}
```
- Spring **only loads the matching bean** based on the active profile.

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### **1️⃣ Default Profile (`@Profile("default")`)**  
If no profile is active, Spring uses `@Profile("default")`.  
```java
@Service
@Profile("default")
public class DefaultEmailService implements EmailService { }
```

#### **2️⃣ Using `@IfProfileActive` in Tests**  
Spring Boot provides **profile-based testing**:  
```java
@SpringBootTest
@ActiveProfiles("test")
public class MyAppTest { }
```
- Ensures that tests **run with test configurations only**.

#### **3️⃣ Combining Multiple Profiles**  
```java
@Profile({"dev", "qa"})
```
- This bean **loads for both `dev` and `qa` profiles**.

---

## **`@ComponentScan` & `@EnableAutoConfiguration` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
#### ✅ `@ComponentScan`  
- Tells Spring **where to look for components (`@Component`, `@Service`, `@Repository`, `@Controller`)**.  
- Default **scans the package where the main class is located and its sub-packages**.  

✅ **Example:**  
```java
@ComponentScan(basePackages = "com.example.service")
```
- This scans only **`com.example.service`** and its sub-packages.

#### ✅ `@EnableAutoConfiguration`  
- **Automatically configures Spring Boot** based on dependencies.  
- Checks **classpath dependencies** and configures beans accordingly.  
- Example: If `spring-boot-starter-web` is present, it auto-configures **Tomcat, DispatcherServlet, and MVC components**.

✅ **Example:**  
```java
@EnableAutoConfiguration
public class MyApp { }
```
- Spring Boot **automatically configures necessary beans**.

---

### **2️⃣ R - Reverse (How It Works Internally?)**  

#### 🔹 **How `@ComponentScan` Works?**  
1. Scans the specified package (or the default `@SpringBootApplication` package).  
2. Finds **Spring-managed beans (`@Component`, `@Service`, `@Repository`, `@Controller`)**.  
3. Registers them in the Spring ApplicationContext.

✅ **Example: Auto-detecting Beans**  
```java
@Component
public class MyBean { }
```
- If `MyBean` is inside a scanned package, Spring **automatically registers** it.

#### 🔹 **How `@EnableAutoConfiguration` Works?**  
1. Reads **`spring.factories`** file inside `META-INF` directory.  
2. Loads **pre-defined configurations** based on dependencies.  
3. Uses **`@Conditional` annotations** to enable/disable configurations.

✅ **Example: Auto-Configuring Database**  
- If `spring-boot-starter-data-jpa` is present, it **automatically configures DataSource, EntityManager, and JPA Repositories**.

---

### **3️⃣ I - Inspect (Use Cases & Best Practices)**  

#### ✅ `@ComponentScan` Use Cases  
| Use Case        | Example |
|----------------|---------|
| Scanning a specific package | `@ComponentScan("com.example.service")` |
| Scanning multiple packages | `@ComponentScan({"com.example.service", "com.example.repo"})` |
| Excluding specific classes | `@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))` |

#### ✅ `@EnableAutoConfiguration` Use Cases  
| Use Case        | How It Helps |
|----------------|-------------|
| Web applications | Auto-configures Tomcat, MVC, Jackson |
| Database applications | Configures DataSource, JPA, Hibernate |
| Security | Enables Spring Security defaults |

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### **1️⃣ Disabling Auto-Configuration for Specific Beans**  
✅ **Example: Disabling Hibernate Auto-Configuration**  
```java
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
```

#### **2️⃣ Checking Auto-Configured Beans**  
✅ **Command to See Auto-Configured Beans**  
```sh
$ mvn spring-boot:run --debug
```

#### **3️⃣ Using `spring.main.allow-bean-definition-overriding`**  
- If a bean **conflicts with auto-configured beans**, allow overriding:  
```properties
spring.main.allow-bean-definition-overriding=true
```

---

## **`@RequestMapping` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- `@RequestMapping` **maps HTTP requests to specific handler methods** in a Spring Boot controller.  
- It can map to **URLs, HTTP methods (GET, POST, etc.), headers, and params**.  
- **Shortcut annotations** exist:  
  - `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`.

✅ **Basic Example:**  
```java
@RestController
@RequestMapping("/api")
public class MyController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```
- Maps `GET /api/hello` to `sayHello()` method.

---

### **2️⃣ R - Reverse (How It Works Internally?)**  
- **Spring scans controllers**, detects `@RequestMapping`, and registers them as handlers.  
- **Spring MVC DispatcherServlet** processes incoming requests and matches the right method.  
- Uses an **internal RequestMappingHandlerMapping** to find the appropriate controller method.

✅ **Example: Mapping Specific HTTP Methods**  
```java
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public String getHello() { return "Hello"; }
```
- Only allows `GET` requests.

---

### **3️⃣ I - Inspect (Use Cases & Best Practices)**  

| **Use Case**         | **Example** |
|----------------------|------------|
| **Mapping Multiple URLs** | `@RequestMapping({"/hello", "/hi"})` |
| **Mapping Multiple HTTP Methods** | `@RequestMapping(value = "/data", method = {RequestMethod.GET, RequestMethod.POST})` |
| **Mapping with Parameters** | `@RequestMapping(value = "/user", params = "id")` |
| **Mapping Headers** | `@RequestMapping(value = "/json", headers = "Accept=application/json")` |
| **Path Variables** | `@RequestMapping("/user/{id}")` with `@PathVariable("id") int userId` |

✅ **Example: Path Variable Usage**  
```java
@RequestMapping("/user/{id}")
public String getUser(@PathVariable("id") int id) {
    return "User ID: " + id;
}
```
- Access via `/user/10` → Returns `"User ID: 10"`.

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### ✅ **Using Query Parameters (`@RequestParam`)**  
```java
@RequestMapping("/user")
public String getUserByParam(@RequestParam(name = "id", required = false) Integer id) {
    return "User ID: " + id;
}
```
- `/user?id=5` → `"User ID: 5"`

#### ✅ **Returning JSON Instead of Plain Text**  
```java
@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/user", produces = "application/json")
    public User getUser() {
        return new User(1, "John Doe");
    }
}
```

#### ✅ **Using `@GetMapping`, `@PostMapping` (Shortcut Annotations)**  
```java
@GetMapping("/users")
public List<User> getUsers() {
    return List.of(new User(1, "John"), new User(2, "Jane"));
}
```
- **Equivalent to:** `@RequestMapping(value = "/users", method = RequestMethod.GET)`

---

## **`@PathVariable` vs. `@RequestParam` in Spring Boot - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  

| Annotation      | Purpose                                    | Example Usage                         | URL Example   |
|-----------------|--------------------------------------------|---------------------------------------|---------------|
| `@PathVariable` | Captures **path parameters** from the URL -| `/users/{id}` → `@PathVariable("id")` | `/users/10`   |
| `@RequestParam` | Captures **query parameters** from the URL | `/users?id=10` → `@RequestParam("id")`| `/users?id=10`|

---

### **2️⃣ R - Reverse (How It Works Internally?)**  
#### ✅ **`@PathVariable` - Extracts a part of the URL path**  
- Used when the value is **mandatory and part of the URL**.
```java
@GetMapping("/users/{id}")
public String getUserById(@PathVariable("id") int id) {
    return "User ID: " + id;
}
```
- **URL:** `/users/10` → `"User ID: 10"`

#### ✅ **`@RequestParam` - Extracts query parameters from URL**  
- Used for **optional or multiple query parameters**.
```java
@GetMapping("/users")
public String getUserByRequestParam(@RequestParam(name = "id", required = false) Integer id) {
    return "User ID: " + id;
}
```
- **URL:** `/users?id=10` → `"User ID: 10"`
- **URL:** `/users` → `"User ID: null"` (optional param)

---

### **3️⃣ I - Inspect (Use Cases & Best Practices)**  

| **Use Case**       | **@PathVariable** | **@RequestParam** |
|--------------------|------------------|------------------|
| **Mandatory Input** | ✅ Always required in the URL | ❌ Can be optional (`required=false`) |
| **Dynamic URLs** | ✅ Best for RESTful APIs (`/product/{id}`) | ❌ Not used for dynamic URLs |
| **Filtering/Search** | ❌ Not preferred for filtering | ✅ Best for search (`/products?category=mobile`) |
| **Multiple Parameters** | ✅ Used in URL (`/order/{id}/item/{itemId}`) | ✅ Used for filters (`/order?id=10&type=fast`) |

✅ **Example: Combining Both**  
```java
@GetMapping("/orders/{orderId}")
public String getOrderDetails(
    @PathVariable("orderId") int orderId,
    @RequestParam(name = "status", required = false, defaultValue = "pending") String status) {
    return "Order ID: " + orderId + ", Status: " + status;
}
```
- **URL:** `/orders/100` → `"Order ID: 100, Status: pending"`  
- **URL:** `/orders/100?status=shipped` → `"Order ID: 100, Status: shipped"`

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### ✅ **Multiple Path Variables**  
```java
@GetMapping("/orders/{orderId}/items/{itemId}")
public String getItemDetails(@PathVariable int orderId, @PathVariable int itemId) {
    return "Order ID: " + orderId + ", Item ID: " + itemId;
}
```
- **URL:** `/orders/10/items/5` → `"Order ID: 10, Item ID: 5"`

#### ✅ **Handling Optional Query Params with Default Values**  
```java
@GetMapping("/products")
public String getProducts(@RequestParam(defaultValue = "all") String category) {
    return "Category: " + category;
}
```
- **URL:** `/products` → `"Category: all"`
- **URL:** `/products?category=laptop` → `"Category: laptop"`

---

## **Exception Handling in Spring Boot using `@ControllerAdvice` and `@ExceptionHandler` - T.R.I.M. Template**  

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
| Annotation | Purpose | Example |
|------------|---------|---------|
| `@ExceptionHandler` | Handles specific exceptions inside a controller | Catches and processes an exception at the method level |
| `@ControllerAdvice` | Global exception handler for multiple controllers | Centralized error handling across the application |
| `@ResponseStatus` | Sets HTTP status for an exception | Maps exceptions to HTTP status codes |

---

### **2️⃣ R - Reverse (How It Works Internally?)**  
#### ✅ **`@ExceptionHandler` - Handle Exception at Controller Level**  
- Used inside a specific controller to catch exceptions raised in that controller.
```java
@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        if (id <= 0) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        return "User " + id;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
```
- **URL:** `/users/-1` → `404 Not Found: User not found with ID: -1`

#### ✅ **`@ControllerAdvice` - Handle Exceptions Globally**  
- Used for centralizing exception handling across multiple controllers.
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // Catch-all for unexpected exceptions
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```
- **URL:** `/users/-1` → `404 Not Found`
- **URL:** `/users/abc` (Invalid Input) → `500 Internal Server Error`

---

### **3️⃣ I - Inspect (Use Cases & Best Practices)**  
| **Use Case** | **@ExceptionHandler** | **@ControllerAdvice** |
|-------------|------------------------|------------------------|
| **Handling specific exception per controller** | ✅ Yes | ❌ No |
| **Global exception handling** | ❌ No | ✅ Yes |
| **Multiple exception handling** | ❌ No | ✅ Yes |
| **Centralized logging & error handling** | ❌ No | ✅ Yes |

✅ **Best Practice**:  
- Use `@ExceptionHandler` for **small controllers** that need **custom exception handling**.  
- Use `@ControllerAdvice` for **large applications** to **centralize** exception handling.

---

### **4️⃣ M - Modify (Customization & Advanced Usage)**  

#### ✅ **Custom Exception with `@ResponseStatus`**  
- Simplifies response handling by setting HTTP status in exception class.
```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
```

#### ✅ **Returning Custom Error Response Using `@ControllerAdvice`**  
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "User Not Found");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
```
**Response Example:**  
```json
{
    "error": "User Not Found",
    "message": "User not found with ID: -1",
    "timestamp": "2025-03-03T14:00:00"
}
```

---

 