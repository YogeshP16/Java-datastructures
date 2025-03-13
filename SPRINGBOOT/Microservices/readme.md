### **Microservices in Spring Boot**  

#### ✅ **What is a Microservice?**  
✔ A **small, independent, loosely coupled service** that focuses on a **single functionality**.  
✔ Communicates via **REST APIs** or **messaging systems** (e.g., Kafka, RabbitMQ).  
✔ Each service has **its own database** (DB per service).  

---

#### ✅ **Key Features**  
✔ **Independently deployable** 🛠️  
✔ **Scalable & fault-tolerant** 🔄  
✔ **Uses REST, gRPC, or Messaging for communication** 📡  
✔ **Follows Domain-Driven Design (DDD)** 🏗️  
✔ **Can be containerized using Docker & Kubernetes** 🐳  

---

#### ✅ **Microservices in Spring Boot**  
Spring Boot provides tools to build microservices easily:  
✔ **Spring Cloud** → For distributed systems.  
✔ **Spring Boot REST** → To expose APIs.  
✔ **Spring Security** → For authentication & authorization.  
✔ **Spring Cloud Netflix (Eureka, Zuul, Ribbon)** → For service discovery, API Gateway, and load balancing.  

---

#### ✅ **Example: Simple Microservice (REST API)**  
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return "User with ID: " + id;
    }
}
```

---

### **💡 Why Microservices?**  
✔ **Better scalability & flexibility**  
✔ **Faster development & deployment**  
✔ **Fault isolation – failure in one service doesn't break the entire system**  
✔ **Easy to maintain & upgrade** 🚀  

### **Monolithic vs Microservices**  

#### ✅ **Monolithic Architecture**  
✔ **Single codebase** → All features in one application.  
✔ **Tightly coupled components** → Hard to scale independently.  
✔ **Single database** → Shared across the entire app.  
✔ **Easy to develop & deploy** initially but **hard to maintain** as it grows.  

✅ **Example:**  
```text
E-commerce App (One Codebase)  
- User Management  
- Order Service  
- Payment Processing  
- Inventory Management  
```

---

#### ✅ **Microservices Architecture**  
✔ **Multiple independent services** → Each service focuses on **one feature**.  
✔ **Loosely coupled** → Each service runs **independently**.  
✔ **Own database per service** → No shared database.  
✔ **Scalable & maintainable** → Easily update, deploy, or scale services separately.  

✅ **Example:**  
```text
E-commerce System (Microservices)  
- User Service (Handles user data)  
- Order Service (Processes orders)  
- Payment Service (Handles payments)  
- Inventory Service (Manages stock)
```

---

### **💡 Key Differences**  

| Feature           | Monolithic 🏛️ | Microservices 🏗️ |
|------------------|--------------|----------------|
| **Structure**     | Single app   | Multiple services |
| **Scalability**   | Hard to scale | Easy to scale |
| **Deployment**    | One large deployment | Independent deployments |
| **Database**      | Shared DB    | DB per service |
| **Fault Isolation** | Failure affects entire app | Isolated failures |
| **Development Speed** | Slower as app grows | Faster with teams working on separate services |

🔹 **Microservices = Flexibility & Scalability 🚀**  
🔹 **Monolithic = Simplicity for small apps 🏗️**



## **Microservices vs. Monolithic Architecture** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Microservices**: A software architecture where an application is **divided into small, independent services**, each handling a specific functionality and communicating via APIs.  
- **Monolithic**: A single unified application where all functionalities are tightly coupled into one codebase.  

---

### **2️⃣ R - Reverse (Key Differences)**  

| Feature          | Monolithic Architecture | Microservices Architecture |
|-----------------|------------------------|----------------------------|
| **Structure**   | Single codebase & deployable unit | Multiple independent services |
| **Scalability** | Hard to scale specific features | Easily scales individual services |
| **Deployment**  | Full redeployment required for changes | Deploy services independently |
| **Technology**  | Single tech stack | Polyglot (Different tech stacks per service) |
| **Fault Isolation** | A bug can crash the whole system | Failure in one service doesn’t impact others |
| **Communication** | In-process method calls | Inter-service API calls (REST, gRPC, Messaging) |

---

### **3️⃣ I - Inspect (Common Challenges & Fixes)**  
| **Issue** | **Microservices Fix** |
|-----------|----------------------|
| Complex inter-service communication | Use **API Gateway** & **Service Discovery** |
| Data consistency issues | Use **Event-Driven Architecture** & **Saga Pattern** |
| Increased deployment complexity | Use **CI/CD pipelines & Kubernetes** |

---

### **4️⃣ M - Modify (Code & Implementation)**  

#### ✅ **Monolithic Example (Spring Boot)**
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
```
🔹 **Everything (controller, service, and database access) is in one application.**  

---

#### ✅ **Microservices Example (Spring Boot + Eureka)**
🔹 **User Service (`users-service`)**
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
```
🔹 **Order Service (`orders-service`) calling `users-service`**
```java
@FeignClient(name = "users-service")
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);
}
```
🔹 **Eureka Server (Service Discovery)**
```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
```

---


## **Microservices Communication Methods** 🚀  

Microservices communicate via **synchronous** or **asynchronous** methods, depending on requirements like latency, consistency, and resilience.  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Synchronous Communication**: One service waits for a response from another.  
- **Asynchronous Communication**: Services communicate via events/messages without waiting.  

---

### **2️⃣ R - Reverse (Types & Implementation)**  

| Communication Type | Protocol/Technology | Example Use Case |
|-------------------|-------------------|------------------|
| **Synchronous (Blocking)** | REST (HTTP), gRPC | Request-response (User Service calling Order Service) |
| **Asynchronous (Non-blocking)** | Kafka, RabbitMQ, JMS | Event-driven (Order Service notifying Payment Service) |

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| High Latency in REST Calls | Use **gRPC** (binary protocol) for faster communication |
| Service Unavailability | Implement **Circuit Breaker (Resilience4j)** |
| Data Consistency Across Services | Use **Event Sourcing & Saga Pattern** |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **Synchronous Communication - REST API (Spring Boot + Feign Client)**  
🔹 **User Service exposing REST API**  
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "Yogesh");
    }
}
```
🔹 **Order Service calling User Service using Feign Client**  
```java
@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);
}
```
```java
@Service
public class OrderService {
    @Autowired
    private UserClient userClient;

    public void createOrder(Long userId) {
        User user = userClient.getUser(userId);
        System.out.println("Order placed for: " + user.getName());
    }
}
```
---

#### ✅ **Asynchronous Communication - Kafka (Spring Boot)**  
🔹 **Order Service publishes an event**  
```java
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

public void placeOrder(String orderId) {
    kafkaTemplate.send("order-topic", orderId);
}
```
🔹 **Payment Service listens to the event**  
```java
@KafkaListener(topics = "order-topic", groupId = "payment-group")
public void processOrder(String orderId) {
    System.out.println("Processing payment for order: " + orderId);
}
```
---

## **Service Discovery & Netflix Eureka** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Service Discovery** helps microservices dynamically find and communicate with each other without hardcoding IPs.  
- **Spring Cloud Netflix Eureka** is a **service registry** where microservices **register themselves** and **discover other services** dynamically.  

---

### **2️⃣ R - Reverse (How It Works)**  
✅ **Without Service Discovery**  
- Microservices must **hardcode IP addresses** of other services, which fail if services move or scale dynamically.  

✅ **With Eureka (Service Discovery)**  
- Services **register** with Eureka, and clients **fetch service details dynamically** instead of using hardcoded URLs.  
- Supports **client-side load balancing** via **Ribbon**.  

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| Service downtime causes failures | Use **circuit breakers (Resilience4j, Hystrix)** |
| High network traffic in large-scale apps | Use **API Gateway (Zuul, Spring Cloud Gateway)** |
| Dynamic scaling leads to IP changes | Eureka **dynamically updates** service locations |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **1. Eureka Server (Service Registry)**
```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```
🔹 **`application.yml` (Eureka Server Config)**  
```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

---

#### ✅ **2. Registering a Microservice with Eureka**
🔹 **Microservice (`users-service`) registers itself with Eureka**  
```java
@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
```
🔹 **`application.yml` (User Service Config)**  
```yaml
server:
  port: 8081

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

#### ✅ **3. Discovering Services via Eureka Client**
🔹 **Order Service fetching `users-service` dynamically**  
```java
@FeignClient(name = "users-service")
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);
}
```
🔹 **Load Balancing Request (Ribbon Integration)**  
```yaml
users-service:
  ribbon:
    eureka-enabled: true
```

---

## **Spring Cloud Config Server in Microservices** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **Spring Cloud Config Server** centralizes configuration management for microservices.  
- It stores configurations in **Git, database, or local files**, allowing services to fetch them dynamically.  
- This eliminates the need for **hardcoded configurations** in individual microservices.  

---

### **2️⃣ R - Reverse (How It Works - Architecture Flow)**  

1. **Config Server** loads configurations from a repository (e.g., Git).  
2. **Microservices (Clients)** fetch their configurations from the Config Server at runtime.  
3. Configuration updates can be refreshed dynamically using **Spring Cloud Bus (with RabbitMQ/Kafka)**.  

✅ **Without Config Server:** Each microservice maintains its own config files, making updates complex.  
✅ **With Config Server:** Centralized configuration allows dynamic updates and consistency across services.  

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| Configuration updates require service restarts | Use **Spring Cloud Bus** to refresh configs dynamically |
| Security concerns with storing secrets in Git | Use **Vault or AWS Secrets Manager** |
| High latency when fetching configurations | Enable **local caching** in microservices |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **1. Set Up Spring Cloud Config Server**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
🔹 **Create Config Server Application**  
```java
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```
🔹 **`application.yml` (Config Server Settings)**  
```yaml
server:
  port: 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/yogesh/config-repo  # Git Repo for configurations
```

---

#### ✅ **2. Microservice (Client) Fetching Configurations**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
🔹 **`bootstrap.yml` (Fetch Configs from Config Server)**  
```yaml
spring:
  application:
    name: users-service
  cloud:
    config:
      uri: http://localhost:8888
```
🔹 **Accessing Configuration in Code**  
```java
@Value("${db.url}")
private String dbUrl;
```

---

#### ✅ **3. Refresh Configuration Without Restart (Spring Cloud Bus)**  
🔹 **Add Dependency (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
🔹 **Enable Refresh in Controller**  
```java
@RestController
@RefreshScope
public class ConfigController {
    @Value("${message}")
    private String message;

    @GetMapping("/config")
    public String getConfig() {
        return message;
    }
}
```
🔹 **Trigger Config Refresh**  
```bash
curl -X POST http://localhost:8081/actuator/refresh
```

---

## **API Gateway & Spring Cloud Gateway** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- An **API Gateway** is the **entry point** for all client requests in a microservices architecture.  
- It handles **authentication, routing, rate limiting, load balancing, and security** centrally.  
- **Spring Cloud Gateway** is a lightweight, reactive API Gateway built on **Spring WebFlux**.  

---

### **2️⃣ R - Reverse (How It Works - Architecture Flow)**  
1. **Client** sends a request to the API Gateway.  
2. **Gateway** routes the request to the appropriate microservice.  
3. **Filters** handle security, logging, rate limiting, etc.  
4. **Response** is sent back through the Gateway.  

✅ **Without API Gateway:** Clients must call multiple microservices directly, leading to complexity.  
✅ **With API Gateway:** Clients interact with a single entry point, simplifying communication.  

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| High latency due to multiple service calls | Enable **caching** and **circuit breakers** (Resilience4j) |
| Authentication needs to be handled per service | Implement **JWT-based security** at the Gateway level |
| Difficult to monitor API traffic | Use **Spring Boot Actuator & Micrometer** for metrics |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **1. Set Up Spring Cloud Gateway**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

🔹 **Configure Routes in `application.yml`**  
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://localhost:8081
          predicates:
            - Path=/users/**
        - id: order-service
          uri: http://localhost:8082
          predicates:
            - Path=/orders/**
```

---

#### ✅ **2. Implement Custom Pre & Post Filters**  
🔹 **Logging Filter (Pre & Post Processing)**  
```java
@Component
public class LoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Request intercepted: " + exchange.getRequest().getPath());
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
            System.out.println("Response sent: " + exchange.getResponse().getStatusCode())));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
```

---

#### ✅ **3. Enable Rate Limiting & Circuit Breaking**  
🔹 **Add Rate Limiting with Redis**  
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://localhost:8081
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 5
                redis-rate-limiter.burstCapacity: 10
```

🔹 **Enable Circuit Breaker (Resilience4j)**  
```yaml
resilience4j:
  circuitbreaker:
    instances:
      user-service:
        failureRateThreshold: 50
        waitDurationInOpenState: 5000ms
```

---

## **Circuit Breaker & Resilience4j/Hystrix** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- A **Circuit Breaker** is a **fault-tolerance** mechanism that **prevents cascading failures** in microservices.  
- If a service fails repeatedly, the Circuit Breaker **opens** and temporarily stops requests, allowing the system to recover.  
- **Resilience4j** (modern) and **Hystrix** (legacy) are two popular Circuit Breaker libraries.  

---

### **2️⃣ R - Reverse (How It Works - Lifecycle)**  
| **State** | **Condition** | **Action** |
|-----------|-------------|-------------|
| **Closed** | Normal operation | Requests pass through |
| **Open** | Failure rate exceeds threshold | Requests are blocked, fallback executed |
| **Half-Open** | After a cooldown period | Allows limited requests to check recovery |

✅ **Without Circuit Breaker:** Continuous failures cause system-wide crashes.  
✅ **With Circuit Breaker:** Prevents overload, allowing services to recover.  

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| Service stays open for too long | Adjust **cooldown period** |
| Frequent false failures | Fine-tune **failure threshold** |
| Performance overhead | Use **bulkhead pattern** to isolate failures |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **1. Implement Circuit Breaker using Resilience4j**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-spring-boot2</artifactId>
</dependency>
```

🔹 **Enable Circuit Breaker in Service**  
```java
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "userServiceCB", fallbackMethod = "fallbackGetUser")
    public String getUserData() {
        return restTemplate.getForObject("http://unavailable-service/users", String.class);
    }

    public String fallbackGetUser(Exception e) {
        return "Fallback response: Service unavailable";
    }
}
```

🔹 **Configure Circuit Breaker Properties (`application.yml`)**  
```yaml
resilience4j:
  circuitbreaker:
    instances:
      userServiceCB:
        failureRateThreshold: 50
        waitDurationInOpenState: 5000ms
        permittedNumberOfCallsInHalfOpenState: 2
```

---

#### ✅ **2. Implement Circuit Breaker using Hystrix (Legacy - Not Recommended)**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

🔹 **Enable Hystrix Circuit Breaker in Service**  
```java
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate = new RestTemplate();

    @HystrixCommand(fallbackMethod = "fallbackGetOrders")
    public String getOrders() {
        return restTemplate.getForObject("http://unavailable-service/orders", String.class);
    }

    public String fallbackGetOrders() {
        return "Fallback: Orders service is down";
    }
}
```

🔹 **Enable Hystrix in `application.yml`**  
```yaml
hystrix:
  command:
    default:
      circuitBreaker:
        requestVolumeThreshold: 5
        errorThresholdPercentage: 50
        sleepWindowInMilliseconds: 5000
```

---

## **Securing Microservices Using OAuth2 and JWT** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- **OAuth2** is an authorization framework that allows secure access without exposing credentials.  
- **JWT (JSON Web Token)** is a compact token format used for authentication and authorization.  
- In microservices, OAuth2 and JWT help in **user authentication, API security, and inter-service communication.**  

---

### **2️⃣ R - Reverse (How It Works - Step by Step)**  
| **Step** | **Description** |
|----------|---------------|
| **1. User Authentication** | User logs in, and the Authorization Server validates credentials. |
| **2. Token Generation** | A **JWT token** is issued if authentication is successful. |
| **3. Token Propagation** | User includes JWT in the `Authorization` header (`Bearer Token`) for requests. |
| **4. API Gateway Verification** | The API Gateway verifies the token before forwarding requests to microservices. |
| **5. Microservices Authorization** | Each microservice validates JWT and grants access based on roles/permissions. |

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|----------|------------|
| Token Expired | Implement **refresh tokens** to get a new token. |
| Token Tampering | Use **JWT signing** with a secret key (`HS256`) or **public/private key** (`RS256`). |
| Microservices need user data | Decode JWT or use a **UserInfo endpoint**. |

---

### **4️⃣ M - Modify (Code Implementation)**  

#### ✅ **1. Set Up OAuth2 Authorization Server (Spring Security 5+)**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-authorization-server</artifactId>
</dependency>
```

🔹 **Configure Authorization Server**  
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("client-id")
            .secret("{noop}client-secret") // Use BCrypt in production
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("read", "write")
            .accessTokenValiditySeconds(3600)
            .refreshTokenValiditySeconds(86400);
    }
}
```

---

#### ✅ **2. Configure Resource Server (Microservice Security using JWT)**  
🔹 **Add Dependencies (`pom.xml`)**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

🔹 **Enable JWT Token Validation in Microservices**  
```java
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/secure/**").authenticated();
    }
}
```

🔹 **Set JWT Public Key in `application.yml`**  
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          public-key-location: classpath:public-key.pem
```

---

#### ✅ **3. Protect Endpoints with JWT Authentication**  
🔹 **Add Security to Controller**  
```java
@RestController
@RequestMapping("/secure")
public class SecureController {

    @GetMapping("/user")
    public ResponseEntity<String> getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok("Hello, " + jwt.getSubject());
    }
}
```

🔹 **User Sends Request with JWT Token**  
```http
GET /secure/user
Authorization: Bearer eyJhbGciOiJIUzI1...
```

---

## **Saga Pattern in Distributed Transactions** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- In microservices, **each service has its own database**, making **ACID transactions difficult** across multiple services.  
- The **Saga Pattern** manages **distributed transactions** by breaking them into a **sequence of local transactions**.  
- If a step **fails**, it triggers a **compensating transaction** to **undo** the previous steps.  

---

### **2️⃣ R - Reverse (How It Works - Step by Step)**  
There are **two types** of Saga implementation:  

#### **1️⃣ Choreography-Based Saga (Event-Driven)**
- **Each service publishes an event** after completing a local transaction.  
- **Other services listen** and respond accordingly.  
- Example: **Order Service → Payment Service → Inventory Service**  
- If **Payment fails**, an event triggers the **Order cancellation**.  

#### **2️⃣ Orchestration-Based Saga (Central Controller)**
- A **Saga Orchestrator** (like **Camunda, Axon, or Spring Workflow**) manages the steps.  
- It **sends commands** to services and waits for responses.  
- If a step fails, it **executes rollback commands**.  

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|----------|------------|
| Event Duplication | Use **idempotency** to prevent re-executing transactions. |
| Partial Failures | Implement **timeouts & retries** for robustness. |
| Data Consistency | Use **event sourcing** or **compensating transactions**. |

---

### **4️⃣ M - Modify (Code Implementation - Choreography Saga using Kafka)**  

🔹 **Step 1: Order Service Publishes an Event**  
```java
Order order = new Order();
order.setStatus("PENDING");
orderRepository.save(order);
kafkaTemplate.send("order-events", new OrderCreatedEvent(order.getId()));
```

🔹 **Step 2: Payment Service Listens and Processes Payment**  
```java
@KafkaListener(topics = "order-events")
public void processOrder(OrderCreatedEvent event) {
    if (paymentSuccessful(event.getOrderId())) {
        kafkaTemplate.send("payment-events", new PaymentSuccessEvent(event.getOrderId()));
    } else {
        kafkaTemplate.send("payment-events", new PaymentFailureEvent(event.getOrderId()));
    }
}
```

🔹 **Step 3: Order Service Listens for Payment Failure & Compensates**  
```java
@KafkaListener(topics = "payment-events")
public void handlePaymentFailure(PaymentFailureEvent event) {
    Order order = orderRepository.findById(event.getOrderId()).get();
    order.setStatus("CANCELLED");
    orderRepository.save(order);
}
```

---

## **Logging & Tracing in Microservices using Sleuth & Zipkin** 🚀  

---

### **1️⃣ T - Trim (Basic Concept in Simple Terms)**  
- In microservices, debugging is **hard** because a request **flows through multiple services**.  
- **Spring Cloud Sleuth** adds **trace IDs** and **span IDs** to log requests.  
- **Zipkin** collects and visualizes these traces for debugging.  

---

### **2️⃣ R - Reverse (How It Works - Step by Step)**  
| **Component** | **Role** |
|--------------|---------|
| **Sleuth** | Adds **trace ID** & **span ID** to logs for tracking a request. |
| **Zipkin** | Collects, stores, and visualizes tracing data. |
| **Log Aggregation** | Centralized logging using **ELK Stack (Elasticsearch, Logstash, Kibana)** or **Grafana Loki**. |

---

### **3️⃣ I - Inspect (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|----------|------------|
| Logs not showing Trace IDs | Ensure **Spring Boot logs are in JSON format** or configured properly. |
| High Latency | Optimize **Zipkin storage** (use MySQL, Elasticsearch instead of in-memory). |
| Missing Spans | Ensure **services propagate tracing headers (`X-B3-TraceId`, `X-B3-SpanId`)**. |

---

### **4️⃣ M - Modify (Code Implementation - Sleuth & Zipkin in Spring Boot)**  

🔹 **Step 1: Add Dependencies** (in `pom.xml`)  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

🔹 **Step 2: Enable Tracing in `application.properties`**  
```properties
# Enable Zipkin tracing
spring.zipkin.base-url=http://localhost:9411
spring.sleuth.sampler.probability=1.0  # 100% sampling (adjust as needed)
```

🔹 **Step 3: Add Logging in Controller**  
```java
@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id) {
        logger.info("Fetching order with ID: {}", id);
        return "Order " + id;
    }
}
```

🔹 **Step 4: Run Zipkin Server** (via Docker)  
```sh
docker run -d -p 9411:9411 openzipkin/zipkin
```
Access **Zipkin UI** at **[http://localhost:9411](http://localhost:9411)** to view traces.  

---

