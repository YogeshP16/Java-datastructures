## **Connecting a Spring Boot Application to a Database**

### **1️⃣ (Basic Concept in Simple Terms)**  
Spring Boot connects to a database using **Spring Data JPA** (for ORM-based access) or **JDBC** (for direct SQL execution). Connection details are specified in the `application.properties` or `application.yml` file.

---

### **2️⃣ (How It Works Internally?)**  

### ✅ **Step 1: Add Dependencies (JPA + Database Driver)**
For **MySQL**, add the following dependencies in `pom.xml`:
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
For **PostgreSQL**, replace `mysql-connector-java` with:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

### ✅ **Step 2: Configure Database in `application.properties`**  
#### **For MySQL**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=pass123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA settings
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
#### **For PostgreSQL**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=pass123
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
**⚡ `spring.jpa.hibernate.ddl-auto=update` automatically updates tables, but use `validate` or `none` in production.**

---

### ✅ **Step 3: Create Entity Class**  
```java
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters & Setters
}
```

---

### ✅ **Step 4: Create Repository Layer (DAO)**  
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

---

### ✅ **Step 5: Create Service & Controller**  
```java
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
```

```java
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
```

---

### **3️⃣ (Common Issues & Solutions)**  
| **Issue** | **Solution** |
|-----------|-------------|
| `Cannot create JDBC connection` | Ensure MySQL/PostgreSQL is running, and DB credentials are correct |
| `Table not found` | Use `spring.jpa.hibernate.ddl-auto=update` or manually create tables |
| `java.sql.SQLException: Access denied` | Ensure correct DB username/password and grant permissions |
| `Unknown database 'mydb'` | Create the database manually: `CREATE DATABASE mydb;` |

---

### **4️⃣ (Customization & Advanced Usage)**  

✅ **Using H2 In-Memory Database for Testing**  
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
**Access H2 Console at:** `http://localhost:8080/h2-console`

✅ **Using Flyway for DB Migrations**  
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```
- Place migration scripts in `src/main/resources/db/migration/`
- Example SQL file `V1__Create_Users_Table.sql`
```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
```

---

## **Handling Multiple Databases & Connection Pooling in Spring Boot (HikariCP) - T.R.I.M. Approach**  

---

### **1️⃣ (Basic Concept in Simple Terms)**  
Spring Boot supports **multiple databases** and **connection pooling** using **HikariCP** (default connection pool).  
- **Multiple Databases**: Use multiple `DataSource` beans to connect to different databases (e.g., MySQL & PostgreSQL).  
- **Connection Pooling**: HikariCP efficiently manages database connections for better performance.  

---

### **2️⃣ (How It Works Internally?)**  

### ✅ **HikariCP (Default Connection Pool in Spring Boot)**
HikariCP is a high-performance JDBC connection pool used by default in Spring Boot. It provides:
- **Faster connection retrieval** than other pools.
- **Lower latency & better throughput**.
- **Auto-recovery of failed connections**.

### **Basic HikariCP Configuration**
In `application.properties`:
```properties
# HikariCP Settings
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.max-lifetime=60000
spring.datasource.hikari.connection-timeout=20000
```
- `maximum-pool-size=10`: Max connections in the pool.
- `minimum-idle=5`: Minimum connections in the pool.
- `idle-timeout=30000`: Close idle connections after 30 sec.
- `max-lifetime=60000`: Close a connection after 60 sec.

---

### **3️⃣ (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| `HikariPool-1 - Connection is not available` | Increase `maximum-pool-size` or check DB load |
| `Connection timeout` | Increase `connection-timeout` |
| `Too many connections` | Ensure proper DB indexing and optimize queries |

---

### **4️⃣ (Advanced: Connecting Multiple Databases)**  

### ✅ **Step 1: Define Two DataSources**
```java
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return new DriverManagerDataSource();
    }
}
```

---

### ✅ **Step 2: Configure in `application.properties`**
```properties
# MySQL Configuration
spring.datasource.mysql.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.mysql.username=root
spring.datasource.mysql.password=pass123
spring.datasource.mysql.driver-class-name=com.mysql.cj.jdbc.Driver

# PostgreSQL Configuration
spring.datasource.postgres.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.postgres.username=postgres
spring.datasource.postgres.password=pass123
spring.datasource.postgres.driver-class-name=org.postgresql.Driver
```

---

### ✅ **Step 3: Using the Databases in Repositories**  
```java
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(@Qualifier("mysqlDataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int countUsers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }
}
```

---
## **Flyway Database Migration in Spring Boot – T.R.I.M. Approach** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**  
Flyway is a **database migration tool** that helps manage **schema changes** in a **version-controlled manner**.  
- It ensures that **database schema updates** are applied in the correct order.  
- It works by running **SQL migration scripts** automatically at application startup.  

---

### **2️⃣ (How It Works Internally?)**  
- **Migration scripts** are placed in `src/main/resources/db/migration/`.  
- Each script follows a **versioning convention**:  
  - `V1__init.sql` → Runs first  
  - `V2__add_table.sql` → Runs second  
  - `V3__modify_column.sql` → Runs next  
- Flyway keeps track of applied migrations in a **metadata table** (`flyway_schema_history`).  

---

### **3️⃣ (Common Issues & Fixes)**  

| **Issue** | **Solution** |
|-----------|-------------|
| `FlywayException: Found non-applied migrations` | Check if a script was edited after execution. Avoid modifying past migrations. |
| `Table already exists` | Ensure proper versioning of scripts. Use `IF NOT EXISTS` in SQL. |
| `Duplicate migration version` | Never reuse the same version number in different files. |

---

### **4️⃣ (Implementation in Spring Boot)**  

### ✅ **Step 1: Add Flyway Dependency**  
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

---

### ✅ **Step 2: Configure Flyway in `application.properties`**  
```properties
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration
```
- `enabled=true` → Enables Flyway migration.  
- `baseline-on-migrate=true` → Initializes Flyway on existing DB.  
- `locations=classpath:db/migration` → Folder where SQL files are stored.  

---

### ✅ **Step 3: Create Migration Scripts**  
Place migration scripts in `src/main/resources/db/migration/`  

**Example: Initial Table (V1__init.sql)**  
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

**Example: Add a New Column (V2__add_column.sql)**  
```sql
ALTER TABLE users ADD COLUMN age INT DEFAULT 18;
```

---

### ✅ **Step 4: Verify Migration Execution**  
Flyway will **automatically execute** the scripts on application startup.  
Check the `flyway_schema_history` table:  
```sql
SELECT * FROM flyway_schema_history;
```

---

## **Spring Data JPA – T.R.I.M. Approach** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**  
Spring Data JPA is a **wrapper around JPA** that simplifies database interactions by:  
✅ **Reducing boilerplate code** (No need to write queries for basic operations).  
✅ **Providing built-in CRUD methods** (`save()`, `findById()`, `findAll()`, etc.).  
✅ **Supporting custom queries** using **method naming** and `@Query`.  

---

### **2️⃣ (How It Works Internally?)**  
- Uses **Hibernate** as the default JPA implementation.  
- Spring Boot **auto-configures** everything (DB connection, EntityManager).  
- Provides **Repository Interfaces** (`JpaRepository`) that eliminate the need for DAO classes.  

---

### **3️⃣ (Common Issues & Fixes)**  

| **Issue** | **Solution** |
|-----------|-------------|
| `LazyInitializationException` | Fetch data eagerly (`@EntityGraph` or `@JoinFetch`). |
| `TransactionRequiredException` | Ensure methods modifying data are annotated with `@Transactional`. |
| `Duplicate entry for primary key` | Use `@GeneratedValue(strategy = GenerationType.IDENTITY)` for auto-incrementing IDs. |

---

### **4️⃣ (Implementation in Spring Boot)**  

### ✅ **Step 1: Add Dependencies**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

### ✅ **Step 2: Configure Database in `application.properties`**  
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=pass123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
- `ddl-auto=update` → Automatically creates/updates tables.  
- `show-sql=true` → Shows generated SQL queries in logs.  

---

### ✅ **Step 3: Define an Entity**  
```java
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and Setters
}
```

---

### ✅ **Step 4: Create a Repository (No SQL Required!)**  
```java
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); // Auto-generated query
}
```
- `JpaRepository<User, Long>` provides **ready-made** CRUD methods.  
- `findByName(String name)` → Generates `SELECT * FROM users WHERE name = ?`.  

---

### ✅ **Step 5: Use Repository in Service Layer**  
```java
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}
```

---

## **Purpose of `@Entity` and Repository in Spring Data JPA**  

### **1️⃣ `@Entity` (Purpose & Role)**  
- **Marks a class as a database table representation.**  
- Maps class fields to table columns.  
- Used by JPA to manage database records as Java objects.  

### **✅ Example**  
```java
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and Setters
}
```
🔹 **`@Entity`** → Marks `User` as a table.  
🔹 **`@Id` & `@GeneratedValue`** → Defines the primary key with auto-increment.  

---

### **2️⃣ Repository (Purpose & Role)**  
- **Handles database operations (CRUD) without SQL writing.**  
- **Extends `JpaRepository`** → Gets built-in `save()`, `findById()`, `findAll()`, `delete()` methods.  

### **✅ Example**  
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // Auto-generates SQL query
}
```
🔹 **`JpaRepository<User, Long>`** → Connects to the `User` table.  
🔹 **`findByEmail(String email)`** → Auto-generates `SELECT * FROM users WHERE email = ?`.  

---

## **Performing CRUD Operations in Spring Boot using Spring Data JPA** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**  
CRUD (**Create, Read, Update, Delete**) operations are handled by **Spring Data JPA**, which provides built-in methods through `JpaRepository`.  
- **No SQL required** – Just call methods like `save()`, `findById()`, `findAll()`, `delete()`.  
- **Custom queries** – Use method names or `@Query`.  

---

### **2️⃣ (How It Works Internally?)**  
- **Spring Boot auto-configures Hibernate** (JPA implementation).  
- **Repositories extend `JpaRepository`**, providing CRUD methods.  
- **Spring injects dependencies** → No manual EntityManager handling needed.  

---

### **3️⃣ (Common Issues & Fixes)**  

| **Issue** | **Solution** |
|-----------|-------------|
| `EntityNotFoundException` | Always check `Optional<T>` when fetching data (`findById()`). |
| `DataIntegrityViolationException` | Ensure unique constraints (`@Column(unique=true)`). |
| `LazyInitializationException` | Use `@Transactional` or fetch relationships eagerly (`@EntityGraph`). |

---

### **4️⃣ (Implementation in Spring Boot)**  

### ✅ **Step 1: Add Dependencies**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

### ✅ **Step 2: Configure Database in `application.properties`**  
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=pass123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
- `ddl-auto=update` → Creates/updates tables automatically.  
- `show-sql=true` → Displays generated SQL queries in logs.  

---

### ✅ **Step 3: Define an Entity**  
```java
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and Setters
}
```
🔹 **`@Entity`** → Marks `User` as a database table.  
🔹 **`@Id` & `@GeneratedValue`** → Defines the primary key with auto-increment.  

---

### ✅ **Step 4: Create a Repository (No SQL Needed!)**  
```java
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```
🔹 **`JpaRepository<User, Long>`** → Provides CRUD operations.  
🔹 **`findByEmail(String email)`** → Auto-generates `SELECT * FROM users WHERE email = ?`.  

---

### ✅ **Step 5: Implement CRUD Operations in Service Layer**  
```java
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ (Get all users)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ (Find by ID)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // UPDATE
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
            .map(user -> {
                user.setName(userDetails.getName());
                user.setEmail(userDetails.getEmail());
                return userRepository.save(user);
            })
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
```
🔹 **`save(user)`** → Inserts or updates a user.  
🔹 **`findAll()`** → Fetches all users.  
🔹 **`findById(id)`** → Finds a user by ID.  
🔹 **`deleteById(id)`** → Deletes a user.  

---

### ✅ **Step 6: Create a REST Controller**  
```java
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // READ (Get all users)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // READ (Get user by ID)
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
```
🔹 **`@PostMapping`** → Creates a user.  
🔹 **`@GetMapping`** → Retrieves users.  
🔹 **`@PutMapping`** → Updates a user.  
🔹 **`@DeleteMapping`** → Deletes a user.  

---

### **Difference between `CrudRepository` and `JpaRepository` in Spring Data JPA** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**
Both `CrudRepository` and `JpaRepository` are interfaces in **Spring Data JPA** that provide CRUD operations, but:  
- **`CrudRepository`** → Basic CRUD operations (`save`, `findById`, `delete`).  
- **`JpaRepository`** → Extends `CrudRepository` + **adds JPA-specific features** (batch operations, pagination, sorting).  

---

### **2️⃣ (How It Works Internally?)**
| Feature                | `CrudRepository` | `JpaRepository` |
|------------------------|-----------------|-----------------|
| Provides basic CRUD operations | ✅ Yes | ✅ Yes |
| Supports **pagination & sorting** | ❌ No | ✅ Yes (`findAll(Pageable p)`) |
| Provides **batch operations** | ❌ No | ✅ Yes (`saveAll(Iterable<T> entities)`) |
| Has **flush() & deleteInBatch()** | ❌ No | ✅ Yes |
| Extends | `Repository<T, ID>` | `PagingAndSortingRepository<T, ID>` |
| Performance for large data | 🚫 Limited | 🚀 Optimized |

---

### **3️⃣ (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| Can't use pagination with `CrudRepository` | Switch to `JpaRepository` |
| `saveAll()` is slow for bulk inserts | Use `JpaRepository.saveAllAndFlush()` |
| Want to delete multiple records in one query? | Use `JpaRepository.deleteInBatch()` |

---

### **4️⃣ (Code Comparison)**  

### ✅ **Using `CrudRepository` (Only Basic CRUD)**
```java
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // Inherited CRUD methods: save(), findById(), findAll(), deleteById()
}
```
- **❌ No Pagination & Sorting**  
- **❌ No Batch Operations**  

---

### ✅ **Using `JpaRepository` (Advanced Features)**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByName(String name, Pageable pageable);
}
```
- **✅ Pagination (`Pageable`)**
- **✅ Sorting (`Sort.by("name")`)**
- **✅ Bulk operations (`saveAll()`, `flush()`)**

---

### **Configuring Multiple Data Sources in Spring Boot** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**
Spring Boot allows **multiple databases** by defining separate **DataSource beans** with different configurations.  
We use:  
- `@Primary` → Marks the default DataSource  
- `@ConfigurationProperties` → Reads properties from `application.yml`  
- `@EnableTransactionManagement` → Enables transaction support  

---

### **2️⃣ (How It Works Internally?)**
- Define **two different DataSource beans**  
- Create **two separate `EntityManagerFactory`** beans  
- Configure **two `TransactionManager`** beans  
- Use `@EnableJpaRepositories` to link repositories  

---

### **3️⃣ (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| App connects to only one DB | Ensure both `EntityManagerFactory` are configured |
| Wrong `@Primary` annotation usage | Only one `@Primary` allowed per bean type |
| No bean found for `DataSource` | Ensure correct `@Configuration` setup |

---

### **4️⃣ (Code Implementation)**  

#### ✅ **Step 1: Define Properties in `application.yml`**
```yaml
spring:
  datasource:
    primary:
      url: jdbc:mysql://localhost:3306/db1
      username: root
      password: pass
      driver-class-name: com.mysql.cj.jdbc.Driver
    secondary:
      url: jdbc:mysql://localhost:3306/db2
      username: root
      password: pass
      driver-class-name: com.mysql.cj.jdbc.Driver
```

---

#### ✅ **Step 2: Configure Primary DataSource**
```java
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.example.repo.primary",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDbConfig {

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, 
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.model.primary")
                .persistenceUnit("primary")
                .build();
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
```
🔹 **`@Primary`** → Marks the main data source  

---

#### ✅ **Step 3: Configure Secondary DataSource**
```java
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.example.repo.secondary",
    entityManagerFactoryRef = "secondaryEntityManagerFactory",
    transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDbConfig {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("secondaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.model.secondary")
                .persistenceUnit("secondary")
                .build();
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
```
🔹 **No `@Primary`** → Ensures it's not the default  

---

#### ✅ **Step 4: Define Repositories & Entities**
```java
@Entity
@Table(name = "users")
public class PrimaryUser {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
```
```java
@Entity
@Table(name = "orders")
public class SecondaryOrder {
    @Id @GeneratedValue
    private Long id;
    private String description;
}
```
```java
@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Long> {}
```
```java
@Repository
public interface SecondaryOrderRepository extends JpaRepository<SecondaryOrder, Long> {}
```

---

### **`@Transactional` in Spring Boot** 🚀  

---

### **1️⃣ (Basic Concept in Simple Terms)**  
`@Transactional` **ensures that a set of database operations execute as a single unit** (atomicity). If one operation fails, all changes are **rolled back** to maintain data consistency.  

---

### **2️⃣ (How It Works Internally?)**  
- Spring **creates a proxy** around the method annotated with `@Transactional`.  
- **Begins a transaction** before method execution.  
- If **no exceptions occur**, it **commits** the transaction.  
- If an **unchecked exception (RuntimeException)** occurs, it **rolls back** changes.  

---

### **3️⃣ (Common Issues & Fixes)**  
| **Issue** | **Solution** |
|-----------|-------------|
| Transaction not rolling back | Ensure exception is unchecked (`RuntimeException`) |
| `@Transactional` not working | Place it on **public methods** in a **Spring-managed bean** |
| Lazy loading exception | Use `@Transactional` at the **service layer** |
| Nested transactions failing | Use `Propagation.REQUIRES_NEW` |

---

### **4️⃣ (Code Implementation)**  

#### ✅ **Basic Example**
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        // If an exception occurs here, the save is rolled back
    }
}
```
🔹 **Any error inside `createUser` will roll back the transaction.**  

---

#### ✅ **Rollback for Specific Exception**
```java
@Transactional(rollbackFor = Exception.class)
public void updateUser(Long id, String name) throws Exception {
    User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    user.setName(name);
    userRepository.save(user);
    throw new Exception("Simulated failure"); // Forces rollback
}
```
🔹 **Explicit rollback for checked exceptions (`Exception.class`).**  

---

#### ✅ **Propagation & Isolation**
```java
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
public void processPayment() {
    // Runs in a new transaction, with strict isolation
}
```
| **Propagation Mode** | **Behavior** |
|----------------------|-------------|
| `REQUIRED` (default) | Uses existing transaction, creates new if none exists |
| `REQUIRES_NEW` | Always starts a new transaction |
| `SUPPORTS` | Uses transaction if available, else runs without |
| `MANDATORY` | Requires an existing transaction, else throws an error |

| **Isolation Level** | **Behavior** |
|---------------------|-------------|
| `READ_COMMITTED` | Prevents dirty reads |
| `REPEATABLE_READ` | Prevents dirty & non-repeatable reads |
| `SERIALIZABLE` | Full isolation (slowest but safest) |

---

### **📌 Final Interview Answer (Concise Summary)**  
*"`@Transactional` in Spring Boot ensures atomicity and consistency in database operations. It manages commit/rollback automatically. It supports propagation and isolation levels to control transactions efficiently."*  

Would you like examples for nested transactions or testing transactions? 🚀