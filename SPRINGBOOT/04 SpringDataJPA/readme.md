
## **Spring data JPA** 

### **📌 JDBC**  

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

🚀 **"JDBC = Direct SQL, More Control, More Code!"**

### **📌 WorkFlow**

🟢 **Spring Boot Application**  
⬇️ (Uses)  
🟡 **Spring Data JPA** (Simplifies JPA Implementation)  
⬇️ (Abstracts)  
🟠 **JPA (Java Persistence API)** (Defines ORM Standard)  
⬇️ (Uses Implementation)  
🔵 **Hibernate (JPA Provider)** (Performs ORM)  
⬇️ (Interacts with)  
🟣 **Database (MySQL, PostgreSQL, etc.)**  

+---------------------------+
|  Spring Boot Application  |
+------------+--------------+
             | uses
             v
+---------------------------+
|     Spring Data JPA       |  (Simplifies JPA Implementation)
+------------+--------------+
             |
             v
+---------------------------+
|       JPA (API)           |  (Defines ORM standards)
+------------+--------------+
             |
             v
+---------------------------+
|    Hibernate (JPA Provider) |  (Actual ORM implementation)
+------------+--------------+
             |
             v
+---------------------------+
|   Database (MySQL, etc.)  |  (Final Data Storage)
+---------------------------+



### **📌What Spring Data JPA**  

✅ **What is Spring Data JPA?**  
✔ **Abstraction over JPA** → Reduces boilerplate code.  
✔ **Built on JPA + Hibernate** → Simplifies database access. 
✔ **Uses Hibernate** as the default JPA provider.   
✔ **Auto-generates queries** using method names (`findByName()`, `findByEmail()`).  
✔ **Works with Spring Boot** → Uses `JpaRepository`. 
✔ Provides built-in **CRUD operations, pagination, and query generation**.  

✅ **Basic Snippet**  
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name); // Auto-implemented by Spring Data JPA
}
```
🚀 **"Less Code, More Power! Just Extend `JpaRepository`"**


### **📌 JPA**  

✅ **What is JPA?**  
✔ **Java Persistence API** → Standard for ORM in Java.  
✔ **Defines API, Hibernate implements it**.  
✔ **Works with Spring Boot** to handle DB operations.  
✔ **Uses annotations like `@Entity`, `@Id`, `@Column`**.  
✔ **Simplifies DB interactions** without writing SQL.  

✅ **Basic Snippet**  
```java
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
```
🚀 **"JPA = ORM Standard, Hibernate = Implementation!"**




### **📌 Hibernate**  

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










#### Flashcard 1: Connecting Spring Boot with a Database
**Question:** How to connect Spring Boot with a database?
**Answer:** 
1. Add database dependency in `pom.xml` (e.g., MySQL, H2).
2. Configure `application.properties` with database URL, username, and password.
3. Use `@Entity` for mapping classes to database tables.
4. Use `@Repository` for Data Access Objects (DAOs).

#### Flashcard 2: Spring Data JPA
**Question:** What is Spring Data JPA?
**Answer:** 
- A part of Spring Data project.
- Simplifies data access layer.
- Provides CRUD operations without boilerplate code.
- Uses `JpaRepository` interface.

#### Flashcard 3: @Entity Annotation
**Question:** What is `@Entity` annotation?
**Answer:** 
- Marks a class as a JPA entity.
- Maps the class to a database table.
- Each instance represents a row in the table.

#### Flashcard 4: @Repository Annotation
**Question:** What is `@Repository` annotation in Spring Boot?
**Answer:** 
- Indicates that the class is a DAO.
- Provides CRUD operations.
- Translates database exceptions into Spring exceptions.

#### Flashcard 5: @Transactional Annotation
**Question:** Explain the `@Transactional` annotation in Spring Boot.
**Answer:** 
- Manages transactions.
- Ensures data integrity.
- Rolls back transactions on exceptions.
- Can be applied at method or class level.