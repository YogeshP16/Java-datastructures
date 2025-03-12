

## **Spring data JPA** 
---
### **JDBC**  

✅ **What is JDBC?**  
✔ **Java Database Connectivity** → Connects Java apps to databases.  
✔ **Uses SQL queries** for CRUD operations.  
✔ **Requires manual connection handling** (`DriverManager`).  
✔ **Low-level API** → More boilerplate code.  

✅ **Basic Flow**  
1️⃣ Load JDBC driver.  
2️⃣ Create a connection (`Connection`).  
3️⃣ Execute queries using `Statement` / `PreparedStatement`.  
4️⃣ Process `ResultSet`.  
5️⃣ Close resources.  

---

### **WorkFlow**

🟢 **Spring Boot Application**  
⬇️ (Uses)  
🟡 **Spring Data JPA** (Simplifies JPA Implementation)  
⬇️ (Abstracts)  
🟠 **JPA (Java Persistence API)** (Defines ORM Standard)  
⬇️ (Uses Implementation)  
🔵 **Hibernate (JPA Provider)** (Performs ORM)  
⬇️ (Interacts with)  
🟣 **Database (MySQL, PostgreSQL, etc.)**  

```
+---------------------------+
|  Spring Boot Application  |
+------------+--------------+
             | uses
             v
+---------------------------+
|     Spring Data JPA       |  (Simplifies JPA Implementation of DAO layer)
+------------+--------------+
             |
             v
+---------------------------+
|       JPA (API)           |  (Defines ORM standards)
+------------+--------------+
             |
             v
+---------------------------+
|    Hibernate (JPA Provider) |  (Actual ORM implementation, Mappling applications objects to relational db tables)
+------------+--------------+
             |
             v
+---------------------------+
|   Database (MySQL, etc.)  |  (Final Data Storage)
+---------------------------+
```
---

### **What Spring Data JPA**  

✅ **What is JPA?**  
✔ **Java Persistence API** → Standard for ORM in Java.  
✔ **Defines API, Hibernate implements it**.  
✔ **Works with Spring Boot** to handle DB operations.  
✔ **Uses annotations like `@Entity`, `@Id`, `@Column`**.  
✔ **Simplifies DB interactions** without writing SQL. 

✅ **What is Spring Data JPA?**  
✔ **Abstraction over JPA** → Reduces boilerplate code.  
✔ **Built on JPA + Hibernate** → Simplifies database access. 
✔ **Uses Hibernate** as the default JPA provider, cannot work without a JPA provider.   
✔ **Auto-generates queries** using method names (`findByName()`, `findByEmail()`).  
✔ **Works with Spring Boot** → Uses `JpaRepository`. 
✔ **Provides built-in** CRUD operations, pagination, and query generation.  
✔ **reduce boilerplate code** required to implement DAO layer.

✅ **Basic Snippet**  
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name); // Auto-implemented by Spring Data JPA
}
```
🚀 **"Less Code, More Power! Just Extend `JpaRepository`"**

---

### **Hibernate**  

✅ **What is Hibernate?**  
✔ ORM framework → Maps Java objects to DB tables.  
✔ Removes JDBC boilerplate → No manual SQL needed.  
✔ Manages transactions automatically.  
✔ Works with JPA (`@Entity`, `@Id`).  
✔ Supports caching for better performance.  

✅ **Basic Snippet**  
```java
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
```
🚀 **"Java + DB = Hibernate (No SQL Needed!)"**

---

### **What Does Spring Data JPA Solve?**  

❌ **JPA/Hibernate Issues**  
- **Boilerplate Code** → Writing `EntityManager` logic manually.  
- **Manual Query Writing** → Need to write complex JPQL/SQL queries.  
- **Transaction Handling** → Must explicitly manage transactions.  

✅ **Spring Data JPA Fixes This**  
✔ **Less Code** → Just extend `JpaRepository`.  
✔ **Auto Query Generation** → Methods like `findByName()`.  
✔ **Built-in CRUD Operations** → `save()`, `findAll()`, `deleteById()`.  
✔ **Simplifies Transactions** → Handled automatically.  

🚀 **"JPA is powerful, but Spring Data JPA makes it effortless!"**

---

### **`JpaRepository` Methods & Connection to `EntityManager`**  

✅ **Common Methods in `JpaRepository<T, ID>`**  
✔ `save(T entity)` → Insert or update an entity.  
✔ `findById(ID id)` → Retrieve entity by ID.  
✔ `findAll()` → Get all entities.  
✔ `deleteById(ID id)` → Delete entity by ID.  
✔ `existsById(ID id)` → Check if entity exists.  
✔ `count()` → Get total entity count.  
✔ **Custom Queries** → `findByName(String name)`, etc.  

✅ **How It Connects to `EntityManager`**  
✔ **`JpaRepository` is a Spring Data interface** → No need to implement methods.  
✔ **Spring provides implementation using `SimpleJpaRepository`** (which internally uses `EntityManager`).  
✔ **`EntityManager` handles database interactions** like persist, merge, remove, and query execution.  
✔ **Spring injects `EntityManager` automatically**, so developers only call repository methods.  

🚀 **"You call repository methods → Spring handles database interactions via `EntityManager`!"**

---

### **Entities in JPA**  

✔ **Entities = Java classes that define database tables.**  
✔ Each entity maps to **one table**, and its fields map to **columns**.  
✔ Objects of entity classes **represent rows** in the table.  

✅ **Key Annotations:**  
- `@Entity` → Marks a class as a JPA entity (table).  
- `@Table(name="table_name")` → Custom table name.  
- `@Id` → Defines the **primary key**.  
- `@GeneratedValue(strategy=GenerationType.IDENTITY)` → Auto-generates ID.  
- `@Column(name="column_name")` → Custom column mapping.  
- **Relationships:** `@OneToOne`, `@OneToMany`, `@ManyToOne`.  

🚀 **"Think of an entity as a Java class that directly maps to a database table!"**

---

### **JPA Entity vs. Database Table**  

📌 **Entity Class (Java Side)**  
```
+----------------------+
|      User (Entity)   |
+----------------------+
| @Id  Long id        |  ---> PRIMARY KEY
| @Column name        |  ---> Column in DB
| @Column email       |  ---> Column in DB
| @OneToMany orders   |  ---> Relationship
+----------------------+
```

📌 **Corresponding Database Table**  
```
+----------------------+
|      users (Table)   |
+----------------------+
| id (PK)  | name  | email  |
+----------------------+
|   1      | John  | j@x.com |
|   2      | Jane  | j@y.com |
+----------------------+
```

📌 **Relationships Example**  
```
User 1 ---> Orders [Order 1, Order 2]
User 2 ---> Orders [Order 3]
```

🚀 **"An entity is a Java class that mirrors a database table!"**

---

### **Spring Data JPA Flow (Simplified)**  

📌 **Step-by-Step Execution:**  
1️⃣ **Service Layer (Uses Entities)** → Calls `JpaRepository` for CRUD operations.  
2️⃣ **JpaRepository (DAO Layer)** → Extends `JpaRepository`, provides built-in methods.  
3️⃣ **JPA API (Abstraction Layer)** → Standard API that reduces boilerplate.  
4️⃣ **Hibernate (ORM Implementation)** → Translates JPA calls into SQL queries.  
5️⃣ **JDBC (Low-Level API)** → Manages connections and executes queries.  
6️⃣ **JDBC Driver → Database** → Binds values and runs SQL queries on the database.  

📌 **Flow Diagram:**  
```
[Service] → [JpaRepository] → [JPA API] → [Hibernate] → [JDBC] → [Database]
```

🚀 **"Spring Data JPA simplifies database interactions by removing boilerplate code!"**

---



### **HikariCP (Spring Boot Default Connection Pool)**  

✅ **What is HikariCP?**  
- **High-performance connection pool** used in Spring Boot.  
- **Faster & lightweight** compared to other pools (e.g., C3P0, Apache DBCP).  
- **Default** in `spring-boot-starter-data-jpa`.  

✅ **Why Use HikariCP?**  
✔ Faster connection acquisition.  
✔ Low memory footprint.  
✔ Optimized for **high concurrency**.  
✔ Better performance in **multi-threaded environments**.  

📌 **Spring Boot Auto-Configures It!**  
- You can **customize settings** in `application.properties`:  
  ```properties
  spring.datasource.hikari.maximum-pool-size=10
  spring.datasource.hikari.minimum-idle=5
  spring.datasource.hikari.connection-timeout=30000
  ```  
🚀 **"Efficient, fast, and the go-to choice for database connections in Spring Boot!"**

---

### **Basic JPA Annotations for Entity Mapping**  

✅ **`@Entity`** → Marks a class as a database table.  
✅ **`@Table(name="table_name")`** → Defines a custom table name (optional).  
✅ **`@Id`** → Marks the primary key field.  
✅ **`@GeneratedValue(strategy=...)`** → Specifies primary key generation strategy.  
✅ **`@Column(name="column_name")`** → Maps a field to a specific DB column (optional).  
✅ **`@Transient`** → Excludes a field from persistence (not stored in DB).  
✅ **`@Lob`** → Used for large objects (BLOB, CLOB).  
✅ **`@Temporal(TemporalType.DATE/TIME/TIMESTAMP)`** → Maps `Date` or `Calendar` fields.  
✅ **`@Enumerated(EnumType.STRING/ORDINAL)`** → Maps an enum to a database column.  

🚀 **Example:**  
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String name;

    @Transient
    private String tempData; // Not stored in DB
}
```  
💡 **Tip:** By default, field names map to column names.

---

### **Primary Key & Generation Strategies in JPA**  

✅ **Primary Key (`@Id`)**  
- **Uniquely identifies each record** in a table.  
- Used with `@Id` annotation in **JPA entities**.  

✅ **Primary Key Generation Strategies (`@GeneratedValue`)**  
- Defines how the **primary key is generated** automatically.  

📌 **Generation Strategies:**  
1️⃣ **AUTO** (Default) 
→ JPA picks the best strategy based on DB.  

2️⃣ **IDENTITY** 
- DB **auto-increments** (MySQL, PostgreSQL).  
- The IDENTITY strategy in JPA uses the auto-increment feature of the database to generate primary key values automatically.

3️⃣ **SEQUENCE** 
- Uses **sequence tables** (Oracle, PostgreSQL).  
- Maintains a separate sequence object in the database.
- Ensures unique primary key values.
- Avoids table locks and contention issues (better for high-concurrency environments).

4️⃣ **TABLE** 
- Uses a separate **table** to store key values. 
- Uses a separate table to store and generate primary key values.
- Slower than SEQUENCE but works in all databases. 

🚀 **Example:**  
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    // @GeneratedValue - JPA annotation to auto-generate the value of this field
    // strategy = GenerationType.IDENTITY - JPA annotation to auto-generate the value of this field
    // IDENTITY - JPA annotation to auto increment the column value
}
```  
💡 **Tip:** `IDENTITY` is commonly used for MySQL, while `SEQUENCE` is preferred for databases that support sequences like PostgreSQL & Oracle.

---

### **Spring Data JPA Repository Interfaces & Hierarchy**  

Spring Data JPA provides multiple repository interfaces, each building on top of the previous one for **more functionality**.  

#### **✅ Repository Interface Hierarchy**  
1️⃣ **`Repository<T, ID>`** → Base interface (root), provides core functionality.  
2️⃣ **`CrudRepository<T, ID>`** → Basic CRUD operations (`save`, `findById`, `delete`).  
3️⃣ **`PagingAndSortingRepository<T, ID>`** → Adds **pagination & sorting** support.  
4️⃣ **`JpaRepository<T, ID>`** → Extends `PagingAndSortingRepository` with JPA-specific features.  

---

#### **✅ Key Interfaces & Their Usage**  

✔ **`Repository<T, ID>`**  
- Root interface (superclass) → Marks a class as a repository.  
- No built-in methods.  

✔ **`CrudRepository<T, ID>`**  
- Provides basic CRUD operations:  
  - `save()`, `findById()`, `delete()`, `existsById()`, `count()`.  

✔ **`PagingAndSortingRepository<T, ID>`**  
- Adds **pagination & sorting**:  
  - `findAll(Pageable pageable)`, `findAll(Sort sort)`.  

✔ **`JpaRepository<T, ID>`**  
- Extends `PagingAndSortingRepository`, adding:  
  - `flush()`, `saveAndFlush()`, `deleteInBatch()`.  
- Provides **batch operations & custom queries**.  

🚀 **"JpaRepository = Everything from Crud + Pagination + Extra JPA Features!"**

#### **Spring Data JPA Repository Hierarchy**  

```java
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Derived Query Methods
    List<User> findByName(String name);
    
    // Custom Query
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
```

✅ **Extends `JpaRepository<User, Long>`** → Includes CRUD, pagination, and batch operations.  
✅ **Uses method naming conventions** (`findByName`).  
✅ **Supports custom JPQL queries** (`@Query`).

---

### **Steps to Create & Use Spring Data JPA Repository**  

✅ **1. Add Dependencies** → Include Spring Data JPA and database driver in your project.  

✅ **2. Configure Database** → Set database URL, username, password, and JPA properties in `application.properties`.  

✅ **3. Create an Entity** → Define a class representing a database table, annotate it with `@Entity`, and specify a primary key.  

            ```java
            @Entity
            public class User {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
                private String name;
                private String email;
            }
            ```

✅ **4. Create a Repository interface** → Extend `JpaRepository` interface to get built-in CRUD methods like `save()`, `findById()`, and `findAll()`.  

            ```java
            public interface UserRepository extends JpaRepository<User, Long> {
                // Derived Query Methods
                List<User> findByName(String name);

                // Custom Query - optional (if we need them)
                @Query("SELECT u FROM User u WHERE u.email = ?1")
                User findByEmail(String email);
            }
            ```

✅ **5. Use Repository in Service** → Inject the repository and call methods to handle business logic.  

            ```java
            @Service
            public class UserService {
                @Autowired
                private UserRepository userRepository;

                public List<User> getAllUsers() {
                    return userRepository.findAll();
                }

                public User getUserById(Long id) {
                    return userRepository.findById(id).orElse(null);
                }
            }
            ```

✅ **6. Use Service in Controller** → Expose APIs using `@RestController` to interact with the database through the service.  

---

###  **JPA Repository Methods**  

#### **🔹 Basic CRUD Methods**  
| Method                | Description |
|-----------------------|-------------|
| `save(T entity)`      | Saves/updates entity |
| `findById(id)`        | Finds by ID (Optional) |
| `findAll()`           | Retrieves all records |
| `deleteById(id)`      | Deletes by ID |
| `existsById(id)`      | Checks if exists |
| `count()`             | Total record count |

---

#### **🔹 Finder Methods (`findBy`...)**  
| Method                                      | Description |
|---------------------------------------------|-------------|
| `findByName(String name)`                   | Exact match |
| `findByNameContaining(String keyword)`      | Partial match (LIKE) |
| `findByPriceGreaterThan(Double price)`      | Price > given value |
| `findByNameIgnoreCase(String name)`         | Case-insensitive search |

---

#### **🔹 Sorting & Pagination**  
| Method                                                 | Description |
|--------------------------------------------------------|-------------|
| `findByNameContainingOrderByPriceAsc(String keyword)`  | Sort by price (ascending) |
| `findByPriceBetween(min, max, Pageable pageable)`      | Price range with pagination |

---

#### **🔹 Custom Queries (`@Query`)**  
```java
@Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
List<Product> searchByName(@Param("name") String name);
```
🔹 JPQL Query for name search  

```java
@Query(value = "SELECT * FROM product WHERE price > ?1", nativeQuery = true)
List<Product> findExpensiveProducts(Double price);
```
🔹 Native SQL for expensive products  

---

#### **🔥 Quick Recap**
✅ **CRUD:** `save()`, `findById()`, `findAll()`, `deleteById()`.  
✅ **Finder:** `findByName()`, `findByPriceGreaterThan()`.  
✅ **Sorting/Pagination:** `findByNameContainingOrderByPriceAsc()`.  
✅ **Custom Queries:** `@Query` for complex cases.  

---

### **📌 `@Embedded` & `@Embeddable` – Flashcard**  

✅ **What is `@Embedded` & `@Embeddable`?**  
✔ **`@Embeddable`** → Marks a class as reusable inside an entity.  
✔ **`@Embedded`** → Used in an entity to include an embeddable class.  
✔ **Avoids duplicate fields** in multiple entities.  
✔ **Helps in grouping related fields** (e.g., Address, Contact Info).  

✅ **Example Usage**  
```java
@Embeddable
public class Address {
    private String city;
    private String state;
}

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    
    @Embedded
    private Address address;
}
```
🚀 **"Use `@Embedded` to include, `@Embeddable` to define!"**

---


