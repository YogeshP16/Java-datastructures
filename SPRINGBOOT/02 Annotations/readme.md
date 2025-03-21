## Index

- [@Component in Spring Boot](#component-in-spring-boot)
- [@Service vs @Repository vs @Controller in Spring Boot](#service-vs-repository-vs-controller-in-spring-boot)
- [@Controller vs @RestController in Spring Boot](#controller-vs-restcontroller-in-spring-boot)
- [@Configuration in Spring Boot](#configuration-in-spring-boot)
- [@Component vs @Bean in Spring Boot](#component-vs-bean-in-spring-boot)
- [@Autowired in Spring Boot](#autowired-in-spring-boot)
- [@Qualifier vs @Primary in Spring Boot](#qualifier-vs-primary-in-spring-boot)
- [@Profile in Spring Boot](#profile-in-spring-boot)
- [@SpringBootApplication in Spring Boot](#springbootapplication-in-spring-boot)



---

### **`@Component` in Spring Boot**  

#### ✅ **What is `@Component`?**  
✔ **Marks a class as a Spring-managed bean**.  
✔ **Auto-detected** and registered in **Spring ApplicationContext**.  
✔ Used when a class **doesn’t fit into specific roles** (`@Service`, `@Repository`, etc.).  

#### ✅ **Example:**  
```java
@Component  
public class MyComponent {  
    public String getMessage() {  
        return "Hello from Component!";  
    }  
}
```

#### 💡 **Key Point:**  
✔ `@Component` is the **base annotation** for Spring beans.  
✔ `@Service`, `@Repository`, `@Controller` are **specialized versions** of `@Component`. 🚀  

---

### **`@Service` vs `@Repository` vs `@Controller` in Spring Boot**  

#### ✅ **`@Service` (Business Logic Layer)**  
✔ Used for **business logic & service layer**.  
✔ A **specialized `@Component`** for processing data.  

✅ **Example:**  
```java
@Service
public class UserService {
    public String getUser() {
        return "User data";
    }
}
```
#### ✅ **`@Repository` (Data Access Layer)**  
✔ Used for **database-related operations (DAO layer)**.  
✔ **Converts database exceptions** into `DataAccessException`.  

✅ **Example:**  
```java
@Repository
public class UserRepository {
    public String getUserFromDB() {
        return "Fetching user from DB";
    }
}
```
#### ✅ **`@Controller` (Web Layer - MVC)**  
✔ Handles **web requests** in Spring MVC.  
✔ **Returns a view (HTML/JSP)**.  

✅ **Example:**  
```java
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // Returns home.html or home.jsp
    }
}
```
---

### **`@Controller` vs `@RestController` in Spring Boot**  

#### ✅ **`@Controller` (MVC Controller)**  
✔ Used in **Spring MVC** to handle web requests.  
✔ Returns **a view (HTML/JSP)** using **ViewResolvers**.  
✔ Works with `@ResponseBody` to return JSON manually.  

✅ **Example:**  
```java
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // Returns home.html or home.jsp
    }
}
```

#### ✅ **`@RestController` (API Controller)**  
✔ **Combination of `@Controller` + `@ResponseBody`**.  
✔ Used for **REST APIs** (returns **JSON/XML** directly).  
✔ No need for `@ResponseBody` on each method.  

✅ **Example:**  
```java
@RestController
public class UserController {
    @GetMapping("/user")
    public String getUser() {
        return "User data"; // Returns "User data" as JSON response
    }
}
```
---

### **`@Configuration` in Spring Boot**  

#### ✅ **What is `@Configuration`?**  
✔ Indicates that a class **contains Spring bean definitions**.  
✔ Used to **define beans manually** with `@Bean` methods.  
✔ Ensures **singleton scope** for beans by default.  
✔ `@Configuration` is **equivalent to** an XML configuration file.  
✔ Ensures that **Spring manages beans** in the `ApplicationContext`.  
✔ Works **with `@ComponentScan`** to auto-detect components.

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

---

### **`@Component` vs `@Bean` in Spring Boot**  

✔ **`@Component`** → **Spring auto-detects** and creates the object.  
✔ **`@Bean`** → **Manually define** how the object is created inside `@Configuration`.  

✅ **Key Difference:**  
- `@Component` → Used on **classes**, auto-registered.  
- `@Bean` → Used on **methods**, manually defined.  

🚀 **Think of `@Component` as "Spring finds it automatically" and `@Bean` as "You tell Spring how to create it."**

---

### **`@Autowired` in Spring Boot**  

✔ **Tells Spring: "Inject this dependency automatically!"**  
✔ Used for **dependency injection** (no need for `new`).  
✔ Works on **fields, constructors, and setters**.  

#### How `@Autowired` Works Internally?
1. Spring scans the application context** for a matching bean.  
2. **If exactly one match is found**, it injects the bean.  
3. **If multiple matches are found**, it throws an error unless a specific bean is chosen using `@Qualifier`. 

#### **Ways to Inject a Bean using `@Autowired` in Spring Boot**  

1️⃣ **Field Injection** (Not recommended)  
✔ Directly injects into a class field.   
2️⃣ **Constructor Injection** (Recommended ✅)  
✔ Injects via the constructor, for mandatory one, cannot modify, used to inject during obj creation  
3️⃣ **Setter Injection**  
✔ Injects via a setter method, optional dependency, can be modified, used to inject after obj creation 
 

🚀 **Constructor Injection is preferred for better maintainability!**

✅ **Example:**  
```java
@Component
class Engine {}

@Component
class Car {
    @Autowired
    private Engine engine; // Auto-injected
}
```  

---

### **`@Qualifier` vs `@Primary` in Spring Boot**  

✔ **`@Primary`** → **Default bean** if multiple exist.  
✔ **`@Qualifier`** → **when you need a specific one!** which bean to use.  

#### Key diff
✅ @Primary → Makes a bean the default choice for injection.
✅ @Autowired (without @Qualifier) → Injects the @Primary bean.
✅ @Qualifier("beanName") → Overrides @Primary and injects the specified bean.

✅ **Example:**  

```java
@Component
@Primary
class PetrolEngine implements Engine {}

@Component
class DieselEngine implements Engine {}

@Component
class Car {
    @Autowired
    @Qualifier("dieselEngine") // Specifically inject DieselEngine
    private Engine engine;
}
```  

---

### **`@Profile` in Spring Boot**  

✔ Allows switching between different configurations based on the environment (e.g., `dev`, `test`, `prod`).  
✔ Helps in **switching configurations** easily.  
✔ Used with `@Component` or `@Configuration`.  
✔ Defined using **`application-{profile}.properties`** or **`@Profile` annotation**.  

✅ **Think of it as "Use this bean only in this environment!"**  

### **🔹 Example: `@Profile` with Beans**  
```java
@Profile("dev")  // Active only in the "dev" environment
@Component
public class DevService {
    public String getMessage() {
        return "Development Profile Active!";
    }
}
```  

🚀 **Activate Profile**: Set in `application.properties`  
```
spring.profiles.active=dev
```
---

### **`@SpringBootApplication` in Spring Boot**  

✔ **Main entry point** for a Spring Boot application, used to bootstrap.            
✔ Combines **`@Configuration`**, **`@EnableAutoConfiguration`**, and **`@ComponentScan`**. 
✔ Auto-configures Spring Boot features and scans for components.  

- **@SpringBootConfiguration**   // Equivalent to @Configuration (Marks this class as a config class)
- **@EnableAutoConfiguration**   // Enables Spring Boot’s auto-configuration
- **@ComponentScan**             // Scans for components in the package and subpackages

✅ **Think of it as "Boot up the entire Spring app with auto-config!"**  

### **🔹 Example: `@SpringBootApplication`**  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```  
#### **How Does It Bootstrap the App?**
✔ SpringApplication.run(MyApp.class, args);
- Starts the Spring Boot application.
- Creates the Spring Application Context.
- Auto-configures required beans.

✔@ComponentScan scans the package and subpackages
- Finds @Component, @Service, @Repository, @Controller, etc.
- Registers them as beans in the Spring container.

✔@EnableAutoConfiguration enables automatic configurations
- Configures beans based on dependencies (e.g., if spring-web is present, it configures DispatcherServlet).

#### **Customization & Advanced Usage**  

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































