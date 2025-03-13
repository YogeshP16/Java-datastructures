### **Spring Boot Messaging**  

---

#### **1: Messaging Support in Spring Boot**  
💡 **Q:** What is Spring Boot’s support for messaging?  
✅ **A:**  
- Supports messaging via **RabbitMQ, Kafka, ActiveMQ, JMS**.  
- Uses **Spring Messaging** & **Spring Cloud Stream** for abstraction.  
- **Decouples components**, improving scalability.  

---

#### **2: Configuring a Message Broker**  
💡 **Q:** How to configure a message broker in Spring Boot?  
✅ **A:**  
- Use `spring-boot-starter-websocket` for STOMP.  
- Configure a broker in `WebSocketMessageBrokerConfigurer`:  
    ```java
    @Configuration
    @EnableWebSocketMessageBroker
    public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
            @Override
            public void configureMessageBroker(MessageBrokerRegistry config) {
                    config.enableSimpleBroker("/topic");
                    config.setApplicationDestinationPrefixes("/app");
            }
    }
    ```  

---

#### **3: Sending & Receiving Messages with RabbitMQ**  
💡 **Q:** How do you send and receive messages with RabbitMQ in Spring Boot?  
✅ **A:**  
1. Add `spring-boot-starter-amqp`.  
2. Define a queue, exchange, and binding.  
3. Use `RabbitTemplate` to send messages.  
4. Use `@RabbitListener` to receive messages.  
     ```java
     @RabbitListener(queues = "myQueue")
     public void receiveMessage(String message) {
             System.out.println("Received: " + message);
     }
     ```  

---

#### **4: Spring Kafka in Spring Boot**  
💡 **Q:** What is Spring Kafka, and how is it used in Spring Boot?  
✅ **A:**  
- Integration for **Apache Kafka** in Spring Boot.  
- Handles **publishing and consuming events** asynchronously.  
- Uses **`KafkaTemplate`** for sending messages.  

##### Spring Kafka - What Problem Does It Solve?
🔹 Problem: Traditional request-response systems like REST APIs create tight coupling between services, leading to scalability and reliability issues.
🔹 Solution: Spring Kafka enables asynchronous event-driven communication, solving:

---

#### **Kafka Producer & Consumer**  
💡 **Q:** What are a **producer** and a **consumer** in Kafka?  
✅ **A:**  
- **Producer**: Sends messages to Kafka **topics**.  
- **Consumer**: Reads messages from **topics**.  
- **Brokers** store and distribute messages.  

---

#### **Kafka Topics**  
💡 **Q:** What is a Kafka **topic**?  
✅ **A:**  
- A **logical channel** where messages are stored.  
- **Producers write** to topics, **consumers read** from them.  
- Messages persist based on **retention policies**.  

---

#### **Kafka Producer Configuration**  
💡 **Q:** How do you configure a Kafka **producer** in Spring Boot?  
✅ **A:**  
1. Add `spring-kafka` dependency.  
2. Define Kafka properties in `application.properties`:  
   ```properties
   spring.kafka.bootstrap-servers=localhost:9092
   ```  
3. Use `KafkaTemplate` to send messages:  
   ```java
   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

   public void sendMessage(String message) {
       kafkaTemplate.send("myTopic", message);
   }
   ```  

---

#### **Kafka Consumer Configuration**  
💡 **Q:** How do you configure a Kafka **consumer** in Spring Boot?  
✅ **A:**  
1. Define consumer properties in `application.properties`:  
   ```properties
   spring.kafka.consumer.group-id=myGroup
   ```  
2. Use `@KafkaListener` to consume messages:  
   ```java
   @KafkaListener(topics = "myTopic", groupId = "myGroup")
   public void consume(String message) {
       System.out.println("Received: " + message);
   }
   ```  

---

#### **Kafka Topic Partitions**  
💡 **Q:** What are Kafka **partitions**, and why are they used?  
✅ **A:**  
- Topics are divided into **partitions** for parallel processing.  
- Each partition stores messages in an **ordered** way.  
- **Multiple consumers** can read from different partitions.  

---

#### **5: Configuring Kafka Producer & Consumer**  
💡 **Q:** How do you configure a Kafka producer and consumer in Spring Boot?  
✅ **A:**  
1. Add `spring-kafka` dependency.  
2. Configure Kafka properties in `application.properties`:  
     ```properties
     spring.kafka.bootstrap-servers=localhost:9092
     spring.kafka.consumer.group-id=myGroup
     ```  
3. Create a **producer** using `KafkaTemplate`:  
     ```java
     kafkaTemplate.send("topicName", "message");
     ```  
4. Create a **consumer** with `@KafkaListener`:  
     ```java
     @KafkaListener(topics = "topicName", groupId = "myGroup")
     public void consume(String message) {
             System.out.println("Received: " + message);
     }
     ```  

---

#### **6: Advantages of Messaging Systems**  
💡 **Q:** What are the advantages of using messaging systems in applications?  
✅ **A:**  
- **Decoupling**: Allows different parts of an application to communicate without being directly connected.  
- **Scalability**: Helps in scaling applications by distributing messages across multiple consumers.  
- **Reliability**: Ensures messages are delivered even if parts of the system fail.  
- **Asynchronous Communication**: Enables non-blocking communication between services.  

---

#### **7: Difference Between RabbitMQ and Kafka**  
💡 **Q:** What are the key differences between RabbitMQ and Kafka?  
✅ **A:**  
- **RabbitMQ**:  
    - Best for complex routing and message delivery guarantees.  
    - Supports multiple messaging protocols.  
    - Suitable for real-time messaging.  
- **Kafka**:  
    - Designed for high-throughput and low-latency message processing.  
    - Ideal for event streaming and log aggregation.  
    - Provides strong durability and fault-tolerance.  

---

#### **8: Error Handling in Messaging**  
💡 **Q:** How do you handle errors in messaging systems?  
✅ **A:**  
- Use **dead-letter queues** to capture failed messages.  
- Implement **retry mechanisms** to reprocess messages.  
- Log errors for **monitoring and debugging**.  
- Use **circuit breakers** to prevent cascading failures.  

---

### **1: Kafka Stream Topologies**  
💡 **Q:** Have you worked on any **stream topologies** in Kafka?  
✅ **A:**  
- **Yes**, Kafka Streams allows **real-time processing** of data.  
- **Topology**: A DAG (Directed Acyclic Graph) of processing nodes.  
- Uses `KStream` and `KTable` for transformation.  

---

### **2: Reading Data from Kafka in Spring Boot**  
💡 **Q:** How do you read data from a **Kafka topic** in Spring Boot?  
✅ **A:**  
- Use **`@KafkaListener`** to consume messages:  
  ```java
  @KafkaListener(topics = "myTopic", groupId = "myGroup")
  public void consume(String message) {
      System.out.println("Received: " + message);
  }
  ```  
- **Spring Cloud Stream** can also be used for event-driven microservices.  

---

### **3: Kafka Consumer in Spring**  
💡 **Q:** What feature in Spring do you use to read data from Kafka?  
✅ **A:**  
- **Spring Kafka** provides `@KafkaListener` for consuming messages.  
- **Spring Cloud Stream** abstracts Kafka details with bindings.  

---

### **4: Default Kafka Message Size**  
💡 **Q:** What is the default message size Kafka can accept?  
✅ **A:**  
- **Default:** `1MB (1048576 bytes)`.  
- Configured using `message.max.bytes`.  

---

### **5: Configuring Kafka for 15MB Messages**  
💡 **Q:** How do you send **15MB messages** in Kafka?  
✅ **A:** Configure these properties:  
1. **Producer (`server.properties`)**  
   ```properties
   message.max.bytes=15728640
   ```  
2. **Broker (`server.properties`)**  
   ```properties
   replica.fetch.max.bytes=15728640
   ```  
3. **Consumer (`consumer.properties`)**  
   ```properties
   fetch.message.max.bytes=15728640
   ```  

---

### **6: Kafka Message Size Exceeds Limit**  
💡 **Q:** What happens if a message exceeds the max size?  
✅ **A:**  
- Producer **fails with an error** (`RecordTooLargeException`).  
- Kafka **does not split large messages** automatically.  
- Solution: **Increase max size** or use **message compression**.  

---

### **7: Kafka Replication Factor**  
💡 **Q:** What is **replication factor** in Kafka?  
✅ **A:**  
- Number of copies of a partition across brokers.  
- Example: `replication.factor=3` → 3 copies of data.  

---

### **8: Why Replication Factor?**  
💡 **Q:** Why implement **replication factor** in Kafka?  
✅ **A:**  
- Ensures **data durability & availability**.  
- Protects against **broker failures**.  

---

### **9: Fault Tolerance in Kafka**  
💡 **Q:** What is **fault tolerance** in Kafka?  
✅ **A:**  
- Ability to **recover from failures** without data loss.  
- Achieved using **replication & leader election**.  

---

### **10: Fault Tolerance & Replication**  
💡 **Q:** Can **replication factor** provide fault tolerance?  
✅ **A:**  
- **Yes**, if a broker fails, Kafka **elects a new leader** from replicas.  
- Ensures **continuous availability** of messages.  

---

