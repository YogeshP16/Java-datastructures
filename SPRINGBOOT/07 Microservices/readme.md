## Index

- [Microservices in Spring Boot](#microservices-in-spring-boot)
  - [What is a Microservice?](#what-is-a-microservice)
  - [Key Features](#key-features)
  - [Microservices in Spring Boot](#microservices-in-spring-boot-1)
  - [Example: Simple Microservice (REST API)](#example-simple-microservice-rest-api)
  - [Why Microservices?](#why-microservices)
- [Monolithic vs Microservices](#monolithic-vs-microservices)
  - [Monolithic Architecture](#monolithic-architecture)
  - [Microservices Architecture](#microservices-architecture)
  - [Key Differences](#key-differences)
- [Microservice Communication Methods](#microservice-communication-methods)
  - [Synchronous Communication (Blocking)](#synchronous-communication-blocking)
  - [Asynchronous Communication (Non-Blocking)](#asynchronous-communication-non-blocking)
  - [When to Use What?](#when-to-use-what)
- [Service Discovery in Microservices](#service-discovery-in-microservices)
  - [What is Service Discovery?](#what-is-service-discovery)
  - [Types of Service Discovery](#types-of-service-discovery)
  - [Client-Side Service Discovery](#client-side-service-discovery)
  - [Server-Side Service Discovery](#server-side-service-discovery)
  - [Key Differences](#key-differences-1)
- [Eureka in Microservices](#eureka-in-microservices)
  - [What is Eureka?](#what-is-eureka)
  - [Eureka Components](#eureka-components)
  - [Eureka Server](#eureka-server)
  - [Eureka Client](#eureka-client)
  - [Service Discovery Using Eureka](#service-discovery-using-eureka)
  - [Key Features of Eureka](#key-features-of-eureka)
- [Spring Cloud Config Server in Microservices](#spring-cloud-config-server-in-microservices)
  - [What is Spring Cloud Config Server?](#what-is-spring-cloud-config-server)
  - [Components of Spring Cloud Config](#components-of-spring-cloud-config)
  - [Config Server](#config-server)
  - [Config Client](#config-client)
  - [How Spring Cloud Config Works?](#how-spring-cloud-config-works)
  - [Key Benefits of Spring Cloud Config](#key-benefits-of-spring-cloud-config)
- [API Gateway & Spring Cloud Gateway](#api-gateway--spring-cloud-gateway)
  - [What is an API Gateway?](#what-is-an-api-gateway)
  - [Spring Cloud Gateway (SCG)](#spring-cloud-gateway-scg)
  - [Key Features of Spring Cloud Gateway](#key-features-of-spring-cloud-gateway)
  - [API Gateway vs. Spring Cloud Gateway](#api-gateway-vs-spring-cloud-gateway)
  - [When to Use Spring Cloud Gateway?](#when-to-use-spring-cloud-gateway)
- [Circuit Breaker & Resilience in Microservices](#circuit-breaker--resilience-in-microservices)
  - [What is a Circuit Breaker?](#what-is-a-circuit-breaker)
  - [Circuit Breaker States](#circuit-breaker-states)
  - [Resilience4j (Circuit Breaker Library)](#resilience4j-circuit-breaker-library)
  - [Bulkhead Pattern](#bulkhead-pattern)
  - [Circuit Breaker vs. Bulkhead](#circuit-breaker-vs-bulkhead)
  - [Why Use Resilience4j?](#why-use-resilience4j)
- [Securing Microservices](#securing-microservices)
  - [Why Secure Microservices?](#why-secure-microservices)
  - [Key Security Mechanisms](#key-security-mechanisms)
  - [Authentication & Authorization](#authentication--authorization)
  - [API Gateway Security](#api-gateway-security)
  - [Secure Service-to-Service Communication](#secure-service-to-service-communication)
  - [Data Encryption & Secure Storage](#data-encryption--secure-storage)
  - [Rate Limiting & Throttling](#rate-limiting--throttling)
  - [Key Takeaways](#key-takeaways)
- [Saga Pattern in Distributed Transactions](#saga-pattern-in-distributed-transactions)
  - [What is the Saga Pattern?](#what-is-the-saga-pattern)
  - [How Saga Works?](#how-saga-works)
  - [Choreography-Based Saga](#choreography-based-saga)
  - [Orchestration-Based Saga](#orchestration-based-saga)
  - [When to Use Saga?](#when-to-use-saga)
- [Logging & Tracing in Microservices (Sleuth & Zipkin)](#logging--tracing-in-microservices-sleuth--zipkin)
  - [Why Logging & Tracing in Microservices?](#why-logging--tracing-in-microservices)
  - [What is Spring Cloud Sleuth?](#what-is-spring-cloud-sleuth)
  - [What is Zipkin?](#what-is-zipkin)
  - [How Sleuth & Zipkin Work Together?](#how-sleuth--zipkin-work-together)
  - [Benefits of Logging & Tracing in Microservices](#benefits-of-logging--tracing-in-microservices)
- [How M2 Communicates with M1 If M1 Crashes?](#how-m2-communicates-with-m1-if-m1-crashes)
  - [Retry Mechanism](#retry-mechanism)
  - [Circuit Breaker](#circuit-breaker)
  - [Service Discovery & Load Balancing](#service-discovery--load-balancing)
  - [Message Queue](#message-queue)
  - [Best Approach?](#best-approach)


### **Microservices in Spring Boot**  

#### ✅ **What is a Microservice?**  
✔ A **small, independent, loosely coupled service** that focuses on a **single functionality**.  
✔ Communicates via **REST APIs** or **messaging systems** (e.g., Kafka, RabbitMQ).  
✔ Each service has **its own database** (DB per service).  

#### ✅ **Key Features**  
✔ **Independently deployable** 🛠️  
✔ **Scalable & fault-tolerant** 🔄  
✔ **Uses REST, gRPC, or Messaging for communication** 📡  
✔ **Follows Domain-Driven Design (DDD)** 🏗️  
✔ **Can be containerized using Docker & Kubernetes** 🐳  

#### ✅ **Microservices in Spring Boot**  
Spring Boot provides tools to build microservices easily:  
✔ **Spring Cloud** → For distributed systems.  
✔ **Spring Boot REST** → To expose APIs.  
✔ **Spring Security** → For authentication & authorization.  
✔ **Spring Cloud Netflix (Eureka, Zuul, Ribbon)** → For service discovery, API Gateway, and load balancing.  

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

#### **💡 Why Microservices?**  
✔ **Better scalability & flexibility**  
✔ **Faster development & deployment**  
✔ **Fault isolation – failure in one service doesn't break the entire system**  
✔ **Easy to maintain & upgrade** 🚀  

---

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

#### **💡 Key Differences**  

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

---

### **Microservice Communication Methods**  

#### ✅ **1. Synchronous Communication (Blocking)**  
✔ **REST (HTTP APIs) 📡** → Services communicate using `GET`, `POST`, etc.  
✔ **gRPC** → High-performance RPC framework using Protocol Buffers.  

✅ **Example (REST API Communication)**  
```java
@RestTemplate restTemplate = new RestTemplate();
String response = restTemplate.getForObject("http://order-service/orders/123", String.class);
```

✅ **Example (gRPC Communication)**  
```java
OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);
OrderResponse response = stub.getOrder(OrderRequest.newBuilder().setId(123).build());
```

#### ✅ **2. Asynchronous Communication (Non-Blocking)**  
✔ **Message Brokers (Event-Driven)** → Kafka, RabbitMQ, ActiveMQ.  
✔ **Useful for decoupling services & handling large-scale events.**  

✅ **Example (Kafka Communication)**  
✔ **Producer (Publishing an Event)**  
```java
kafkaTemplate.send("order-events", new OrderEvent(orderId, "CREATED"));
```
✔ **Consumer (Listening to Events)**  
```java
@KafkaListener(topics = "order-events")
public void processOrder(OrderEvent event) {
    System.out.println("Processing order: " + event.getOrderId());
}
```

#### **💡 When to Use What?**  
| Communication Type  | Use Case |
|--------------------|---------|
| **REST (HTTP APIs)** | Request-Response model, simple microservices |
| **gRPC** | Low-latency, high-performance inter-service calls |
| **Kafka/RabbitMQ (Messaging)** | Event-driven systems, real-time data streaming |
| **WebSockets** | Real-time communication (e.g., chat apps) |

🔹 **Use REST/gRPC for direct calls,**  
🔹 **Use Kafka/RabbitMQ for event-driven microservices.** 🚀

---

### **Service Discovery in Microservices**  

#### ✅ **What is Service Discovery?**  
✔ **Automatically locates services in a dynamic environment** (e.g., Kubernetes, cloud).  
✔ Solves the issue of **changing IP addresses** in microservices.  
✔ Services register themselves & discover others dynamically.  

#### **🔹 Types of Service Discovery**  

#### **1. Client-Side Service Discovery**  
✔ Client queries **Service Registry** → Gets service instance → Calls service directly.  
✔ Requires a **Service Registry** (e.g., Eureka, Consul, Zookeeper).  

✅ **Example (Eureka Client-Side Discovery)**  
```java
@LoadBalanced
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

// Calling another microservice dynamically
String response = restTemplate.getForObject("http://ORDER-SERVICE/orders/123", String.class);
```

#### **2. Server-Side Service Discovery**  
✔ Client requests **Load Balancer** → Load Balancer queries Service Registry → Routes request to an instance.  
✔ Used by **AWS ALB, Kubernetes, Istio**.  

✅ **Example (Kubernetes Service Discovery)**  
```yaml
apiVersion: v1
kind: Service
metadata:
  name: order-service
spec:
  selector:
    app: order-service
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
```
Clients access `http://order-service`, and Kubernetes routes to available instances.

#### **💡 Key Differences**  

| Type                 | How It Works | Example Tools |
|---------------------|-------------|--------------|
| **Client-Side**  | Client selects service instance from registry | Eureka, Consul, Zookeeper |
| **Server-Side**  | Load Balancer picks the instance | AWS ALB, Kubernetes, Istio |

✅ **Use Client-Side Discovery** for **direct control** over service selection.  
✅ **Use Server-Side Discovery** when using **cloud-native solutions (AWS, Kubernetes, Istio).** 🚀

---

### **Eureka in Microservices**  

#### ✅ **What is Eureka?**  
✔ Eureka is a **service discovery tool** from Netflix, used in Spring Cloud.  
✔ Allows microservices to **register themselves** & **discover** other services dynamically.  
✔ Helps with **load balancing** and **fault tolerance** in distributed systems.  

#### **🔹 Eureka Components**  

#### **1. Eureka Server**  
✔ Acts as a **Service Registry** (stores registered services).  
✔ Other services register and fetch service details from it.  

✅ **Example: Eureka Server Setup**  
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```
✅ **`application.yml` (Eureka Server)**  
```yaml
server:
  port: 8761

eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
```

#### **2. Eureka Client**  
✔ Registers itself with the Eureka Server.  
✔ Can **discover other services** dynamically.  

✅ **Example: Registering a Service with Eureka**  
```java
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
```
✅ **`application.yml` (Eureka Client)**  
```yaml
server:
  port: 8081

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    preferIpAddress: true
```
#### **3. Service Discovery Using Eureka**  
✔ Use **RestTemplate** or **Feign Client** to call another service dynamically.  

✅ **Using `RestTemplate` with Eureka**  
```java
@LoadBalanced
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

@Autowired
private RestTemplate restTemplate;

public String getOrderDetails() {
    return restTemplate.getForObject("http://ORDER-SERVICE/orders/123", String.class);
}
```

✅ **Using `Feign Client` (Easier Alternative)**  
```java
@FeignClient(name = "ORDER-SERVICE")
public interface OrderClient {
    @GetMapping("/orders/123")
    String getOrderDetails();
}
```

#### **💡 Key Features of Eureka**  
✔ **Self-Registration**: Microservices register themselves.  
✔ **Heartbeat Monitoring**: Ensures services are alive.  
✔ **Load Balancing**: Distributes traffic among instances.  
✔ **Failover Handling**: Routes requests to available instances.  

---

### **Spring Cloud Config Server in Microservices**  

#### ✅ **What is Spring Cloud Config Server?**  
✔ A centralized **configuration management system** for microservices.  
✔ Stores external configurations in **Git, database, or local files**.  
✔ Helps microservices fetch dynamic configurations **without redeployment**.  

#### **🔹 Components of Spring Cloud Config**  

#### **1. Config Server (Centralized Configuration Store)**  
✔ Acts as a **centralized storage** for configurations.  
✔ Reads configurations from **Git, local files, or database**.  

✅ **Example: Setting Up Config Server**  
```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

✅ **`application.yml` (Config Server)**  
```yaml
server:
  port: 8888  # Config server runs on port 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/example/config-repo  # Git repo for storing configs
```

#### **2. Config Client (Microservices Fetching Configs)**  
✔ Microservices fetch their configurations from the **Config Server**.  
✔ Uses **Spring Boot `@RefreshScope`** to apply changes dynamically.  

✅ **`bootstrap.yml` (Config Client)**  
```yaml
spring:
  application:
    name: orderservice  # Name of microservice
  cloud:
    config:
      uri: http://localhost:8888  # URL of Config Server
```

✅ **Fetch Configuration Using REST API**  
```
GET http://localhost:8888/orderservice/default
```

✅ **Using `@RefreshScope` to Apply Config Updates**  
```java
@RefreshScope
@RestController
public class ConfigController {
    
    @Value("${app.message:Default Message}")
    private String message;

    @GetMapping("/config-message")
    public String getMessage() {
        return message;
    }
}
```

#### **🔹 How Spring Cloud Config Works?**  
1️⃣ **Config Server** fetches configuration from Git or local storage.  
2️⃣ **Microservices (Clients)** fetch configurations from the Config Server.  
3️⃣ **Refresh Configs Dynamically** using `@RefreshScope` and `/actuator/refresh`.  

✅ **Trigger Config Refresh** (Use Actuator Endpoint)  
```
POST http://localhost:8080/actuator/refresh
```

#### **💡 Key Benefits of Spring Cloud Config**  
✔ **Centralized Configuration**: Manage all configs in one place.  
✔ **Dynamic Updates**: No need to restart microservices.  
✔ **Version Control**: Store configs in Git for rollback.  
✔ **Environment-Specific Configs**: Separate configs for Dev, Test, Prod.  

🔥 **Spring Cloud Config Server simplifies configuration management for microservices!** 🚀

### **API Gateway & Spring Cloud Gateway**  

#### **✅ What is an API Gateway?**  
✔ A single entry point for **all client requests** in a microservices architecture. this is first layer it just solves teh sitting between client and backend services. 
✔ Handles **routing, authentication, rate limiting, logging, and security**.  
✔ Helps in **hiding internal microservice structure** from clients. 
if client send request that need data from multiple services api gateway responsible for all service and sent the single response back to client

✅ **Common API Gateway Tools:**  
- **Spring Cloud Gateway**  
- **Kong API Gateway**  
- **Netflix Zuul**  
- **AWS API Gateway**  

#### **🔹 Spring Cloud Gateway (SCG)**  
✔ Built on **Spring WebFlux (Reactive Programming)**.  
✔ Replaces **Netflix Zuul** for modern microservices.  
✔ Uses **filters & predicates** for routing requests dynamically.  
✔ Supports **circuit breakers, rate limiting, authentication**.  

✅ **Example: Spring Cloud Gateway Configuration (YAML)**  
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - StripPrefix=1
```
**What happens?**  
- Requests to `/users/**` are routed to `USER-SERVICE`.  
- `StripPrefix=1` removes `/users` from the URL before forwarding the request.  
- `lb://USER-SERVICE` enables **load balancing** via **Eureka**.  

---

#### **💡 Key Features of Spring Cloud Gateway**  

| Feature            | Description |
|-------------------|-------------|
| **Routing**       | Directs requests to the right microservice. |
| **Predicates**    | Conditions like `Path`, `Method`, `Header` to filter requests. |
| **Filters**       | Modify requests/responses (e.g., authentication, rate-limiting). |
| **Load Balancing** | Works with **Eureka + Ribbon** for dynamic service discovery. |
| **Security**      | Works with **OAuth2, JWT, API keys** for authentication. |

---

#### **✅ API Gateway vs. Spring Cloud Gateway**  

| Feature              | API Gateway (General) | Spring Cloud Gateway |
|----------------------|----------------------|----------------------|
| **Architecture**     | Standalone service | Integrated with Spring Boot |
| **Technology**      | Varies (e.g., Kong, AWS API Gateway) | Java + Spring WebFlux |
| **Load Balancing**   | External (e.g., Nginx, AWS ALB) | Built-in (Eureka, Ribbon) |
| **Customization**   | Limited | Highly customizable with filters & predicates |
| **Reactive Support** | Varies | Fully reactive (WebFlux-based) |

---

#### **💡 When to Use Spring Cloud Gateway?**  
✔ If using **Spring Boot + Microservices** (Best Fit 🚀).  
✔ Need **fine-grained control** over request handling.  
✔ Require **integrations with Eureka, Circuit Breakers, Security**.  

✅ **Spring Cloud Gateway is the go-to solution** for Spring-based microservices architectures! 🚀


### **Circuit Breaker & Resilience in Microservices**  

---

#### **✅ What is a Circuit Breaker?**  
✔ A **fault tolerance mechanism** that prevents a system from repeatedly calling a failing service.  
✔ **Stops cascading failures** and **improves system stability**.  
✔ Works like an **electrical circuit breaker**:  
   - If failures exceed a threshold, it **opens** (stops calls).  
   - After a timeout, it **half-opens** (tests if service is back).  
   - If healthy, it **closes** (resumes normal calls).  

---

#### **🔹 Circuit Breaker States**  

| State         | Description |
|--------------|-------------|
| **Closed**   | Calls go through normally. |
| **Open**     | Calls are blocked due to failures. |
| **Half-Open** | Some requests are allowed to check service recovery. |

---

#### **✅ Resilience4j (Circuit Breaker Library)**  
✔ A **lightweight Java library** for resilience in microservices.  
✔ Provides **Circuit Breaker, Rate Limiter, Bulkhead, Retry mechanisms**.  

✅ **Example: Resilience4j Circuit Breaker in Spring Boot**  
```java
@CircuitBreaker(name = "userService", fallbackMethod = "fallbackResponse")
public String getUserData() {
    // Call external service
    return restTemplate.getForObject("http://user-service/users", String.class);
}

// Fallback method when circuit is open
public String fallbackResponse(Exception e) {
    return "Default user data";
}
```

💡 **What Happens?**  
- If `user-service` fails repeatedly, the circuit breaker **opens**.  
- Calls are redirected to `fallbackResponse()`.  
- After a cooldown, the circuit **half-opens** and tests recovery.  

---

#### **✅ Bulkhead Pattern** (Another Resilience Mechanism)  
✔ **Isolates failures** by limiting concurrent requests to a service.  
✔ Prevents **one slow service from affecting others**.  

✅ **Example: Resilience4j Bulkhead**  
```java
@Bulkhead(name = "userService", type = Bulkhead.Type.THREADPOOL)
public String getUserData() {
    return restTemplate.getForObject("http://user-service/users", String.class);
}
```
💡 **What Happens?**  
- Limits the number of threads accessing `user-service`.  
- Prevents overload by **isolating slow services**.  

---

#### **✅ Circuit Breaker vs. Bulkhead**  

| Feature         | Circuit Breaker | Bulkhead |
|---------------|---------------|-----------|
| **Purpose**   | Prevents repeated calls to failing services. | Limits concurrent requests to prevent overload. |
| **Analogy**   | Electrical circuit breaker (Stops calls). | Ship bulkhead (Isolates compartments). |
| **Use Case**  | Unreliable external APIs. | Services with high load spikes. |

---

#### **💡 Why Use Resilience4j?**  
✔ Lightweight & **Spring Boot-friendly**.  
✔ Works with **Spring Cloud Gateway** & **Feign Clients**.  
✔ Provides **advanced resilience patterns** (Retry, Rate Limiter, etc.).  

✅ **Key Takeaway**:  
- **Use Circuit Breaker** to handle **failures**.  
- **Use Bulkhead** to **limit resource usage**.  
- **Use Retry** to **retry transient failures**.  

---


### **Securing Microservices**  

#### **✅ Why Secure Microservices?**  
✔ Prevents **unauthorized access** and **data breaches**.  
✔ Ensures **secure communication** between services.  
✔ Protects **sensitive information** (API keys, tokens, user data).  

#### **🔹 Key Security Mechanisms**  

#### **1️⃣ Authentication & Authorization**  
✔ **Authentication** → Verifies **who** the user is (e.g., JWT, OAuth2).  
✔ **Authorization** → Defines **what** the user can access (e.g., Role-Based Access Control - RBAC).  

✅ **Example: Using JWT in Spring Security**  
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated())
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    return http.build();
}
```
💡 **What Happens?**  
- Secures `/admin/**` endpoints for **only ADMIN users**.  
- Uses **JWT (JSON Web Token)** for authentication.  


#### **2️⃣ API Gateway Security**  
✔ **Acts as a centralized security layer** for microservices.  
✔ Can handle **JWT validation, rate limiting, and authentication**.  

✅ **Spring Cloud Gateway Security with JWT**  
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - AuthenticationFilter
```
💡 **What Happens?**  
- Filters **unauthenticated requests** before reaching microservices.  
- Validates **JWT tokens** centrally in API Gateway.  


#### **3️⃣ Secure Service-to-Service Communication**  
✔ Use **OAuth2 or API Keys** for internal microservice calls.  
✔ Use **mutual TLS (mTLS)** for **end-to-end encryption**.  

✅ **Feign Client with OAuth2**  
```java
@FeignClient(name = "user-service", configuration = OAuth2FeignConfig.class)
public interface UserServiceClient {
    @GetMapping("/users")
    String getUsers();
}
```
💡 **What Happens?**  
- Every request to `user-service` includes an **OAuth2 token**.  
- Only authenticated services can communicate.  


#### **4️⃣ Data Encryption & Secure Storage**  
✔ Use **HTTPS (SSL/TLS)** for data in transit.  
✔ Encrypt **sensitive data** using **Jasypt** or **AWS KMS**.  
✔ Store **secrets** securely (e.g., **Vault, AWS Secrets Manager**).  

✅ **Encrypting Passwords with Jasypt**  
```properties
spring.datasource.password=ENC(UHh0pJ9H3sdU1J0a)
```
💡 **What Happens?**  
- **Database passwords** are encrypted.  
- Only **authorized services** can decrypt them.  


#### **5️⃣ Rate Limiting & Throttling**  
✔ Prevents **DDoS attacks** and **abuse**.  
✔ Tools: **Resilience4j RateLimiter, API Gateway**.  

✅ **Rate Limiting with Resilience4j**  
```java
@RateLimiter(name = "userService", fallbackMethod = "fallback")
public String getUserData() {
    return restTemplate.getForObject("http://user-service/users", String.class);
}
```
💡 **What Happens?**  
- Limits the **number of requests** per second.  
- Calls `fallback()` if the limit is exceeded.  


#### **💡 Key Takeaways**  
✅ **Use OAuth2 + JWT** for authentication.  
✅ **Secure API Gateway** to protect microservices.  
✅ **Encrypt data & secrets** using secure storage.  
✅ **Limit requests** to prevent abuse.  
✅ **Enable HTTPS & mTLS** for secure communication.  

---

### **Saga Pattern – Handling Distributed Transactions**  
**Transaction** Example in Banking system we just transfer money from myAccount to others
so the system ensure either both the debit and credit operations sucess or either both fails so this is part  of one transaction. so if sucess means commit else rollback.
**Problem:** Microservices don’t have a global database, so **rolling back changes** when a failure happens is tricky.  
**Solution:** Use **Saga**, which breaks a big transaction into **small local transactions** with rollback steps. so each service performs its part and then publishes an event to notify the services.
some kind of chain system if somthing goes wrong it just undo the previous transations 

#### **Two Ways to Use Saga:**  
##### **1️⃣ Choreography (Event-Driven) 🎭**  
✔ **Each service listens & reacts** to events—no central controller.  
✔ Good for **simple workflows** with fewer dependencies.  

💡 **Example: Order Processing**  
- 🛒 **Order Service** → Creates order → Sends `OrderCreated` event.  
- 💳 **Payment Service** → Deducts payment → Sends `PaymentCompleted` event.  
- 📦 **Inventory Service** → Reserves stock → Sends `StockReserved` event.  

🚨 **What if stock is unavailable?**  
→ **Rollback:** Inventory cancels order → Payment refunds money.  

##### **2️⃣ Orchestration (Central Controller) 🎯**  
✔ **One service (Orchestrator) controls** the whole process.  
✔ Good for **complex workflows** needing strict control.  

💡 **Example: Order Processing with Orchestrator**  
- 🤖 **Orchestrator** → Orders Service: “Create Order”  
- 🛒 **Order Service** → Order created → Notifies Orchestrator  
- 🤖 **Orchestrator** → Payment Service: “Deduct Payment”  
- 💳 **Payment Service** → Payment deducted → Notifies Orchestrator  
- 🤖 **Orchestrator** → Inventory Service: “Reserve Stock”  

🚨 **What if payment fails?**  
→ **Rollback:** Orchestrator tells Order Service to cancel the order.  

#### **Choreography vs. Orchestration – When to Use?**  
- **Choreography** → Simple workflows, less coupling.  
- **Orchestration** → Complex workflows, strict control.  

**Saga = Smart way to handle microservices failures!** 🚀

#### **🔹 When to Use Saga?**  
✔ When **transactions span multiple microservices**.  
✔ When a **global transaction manager (2PC) is not feasible**.  
✔ When **eventual consistency is acceptable**.  

---

### **Logging & Tracing in Microservices (Sleuth & Zipkin)**  

#### **✅ Why Logging & Tracing in Microservices?**  
✔ Microservices are distributed → Hard to debug issues.  
✔ Need to **track requests** as they pass through multiple services.  
✔ Helps in **monitoring performance & troubleshooting errors**.  

#### **🔹 What is Spring Cloud Sleuth?**  
✔ Adds **unique trace IDs** and **span IDs** to requests.  
✔ Automatically propagates trace information across services.  
✔ Integrates with logging frameworks (e.g., SLF4J, Logback).  

✅ **How it Works?**  
- **Trace ID** → Unique identifier for a request across services.  
- **Span ID** → Unique identifier for a single unit of work (e.g., a method call).  

✅ **Example Log (Sleuth Enabled)**  
```
[TRACE-ID=abc123] [SPAN-ID=xyz456] Processing order request...
```

✅ **Enable Sleuth in Spring Boot**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```
#### **🔹 What is Zipkin?**  
✔ Distributed tracing system for **visualizing request flow**.  
✔ Collects and stores tracing data from services.  
✔ Helps analyze **latency & performance bottlenecks**.  

✅ **Enable Zipkin in Spring Boot**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

✅ **Send Traces to Zipkin**  
```properties
spring.zipkin.base-url=http://localhost:9411
spring.sleuth.sampler.probability=1.0  # 100% sampling
```

#### **🔹 How Sleuth & Zipkin Work Together?**  
1️⃣ **Sleuth** adds trace/span IDs to logs.  
2️⃣ **Services propagate** trace info via HTTP headers (`X-B3-TraceId`, `X-B3-SpanId`).  
3️⃣ **Zipkin collects traces** from all services and visualizes them.  


#### **🔹 Benefits of Logging & Tracing in Microservices**  
✅ **Request tracking** across multiple services.  
✅ **Detect latency issues** and bottlenecks.  
✅ **Debugging made easier** with structured trace logs.  

🚀 **Sleuth + Zipkin = Easy Distributed Tracing!** 🔍

---

### **How M2 Communicates with M1 If M1 Crashes?**  

When Microservice **M1** crashes, **M2** can handle it using **fault-tolerant mechanisms** to ensure system reliability.

#### ✅ **1. Retry Mechanism**  
- If M1 is temporarily down, M2 can **retry** the request.  
- Implemented using **Spring Retry** or client-side retries (e.g., Feign Retry).  

✅ **Example (Spring Retry)**  
```java
@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
public String callM1() {
    return restTemplate.getForObject("http://M1/service", String.class);
}
```

#### ✅ **2. Circuit Breaker (Resilience4j / Hystrix)**  
- Prevents M2 from repeatedly calling a failing M1.  
- If M1 is **unavailable**, return a **fallback response**.  

✅ **Example (Resilience4j Circuit Breaker)**  
```java
@CircuitBreaker(name = "m1Service", fallbackMethod = "fallbackResponse")
public String callM1() {
    return restTemplate.getForObject("http://M1/service", String.class);
}

public String fallbackResponse(Exception e) {
    return "M1 is down, returning fallback response!";
}
```

#### ✅ **3. Service Discovery & Load Balancing (Eureka / Consul)**  
- If M1 has multiple instances, **Service Discovery** can redirect M2 to a healthy instance.  
- **Ribbon / Load Balancer** can distribute traffic among available instances.  

✅ **Example (Eureka Client)**  
```java
@LoadBalanced
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```

✅ **Calling M1 via Service Name**  
```java
restTemplate.getForObject("http://M1/service", String.class);
```

#### ✅ **4. Message Queue (Asynchronous Communication - Kafka/RabbitMQ)**  
- Instead of direct calls, M2 **publishes** a message to a queue.  
- When M1 **recovers**, it processes the message asynchronously.  

✅ **Example (Kafka Producer - M2)**  
```java
kafkaTemplate.send("m1-topic", "Request to M1");
```

✅ **Example (Kafka Consumer - M1)**  
```java
@KafkaListener(topics = "m1-topic", groupId = "m1-group")
public void processMessage(String message) {
    System.out.println("Processing: " + message);
}
```

#### **🚀 Best Approach?**  
🔹 If M1 is **temporarily down** → Use **Retry Mechanism**.  
🔹 If M1 is **frequently failing** → Use **Circuit Breaker**.  
🔹 If M1 has **multiple instances** → Use **Service Discovery & Load Balancing**.  
🔹 If M2 needs to continue **without waiting** → Use **Message Queue**.  

🔹 **Hybrid Approach** (Circuit Breaker + Retry + Asynchronous Messaging) ensures the best reliability! 🚀