
## **🔹 Index**  
- [Indexing – Speed Up Queries](#indexing--speed-up-queries-)
- [Stored Procedure – Reusable SQL Code](#stored-procedure--reusable-sql-code-)
- [Normalization – Remove Data Redundancy](#normalization--remove-data-redundancy-)
- [Aggregation – Group & Summarize Data](#aggregation--group--summarize-data-)
- [Joins – Combine Tables](#joins--combine-tables-)
- [Transactions – Ensure Data Integrity](#transactions--ensure-data-integrity-)
- [Views – Virtual Tables](#views--virtual-tables-)
- [Triggers – Auto Execute SQL](#triggers--auto-execute-sql-)
- [SQL Clauses – Control Query Behavior](#sql-clauses--control-query-behavior-)
- [SQL Constraints – Enforce Data Integrity](#sql-constraints--enforce-data-integrity-)
- [SQL Language Categories – 4 Types](#sql-language-categories--4-types-)
---  

## **🔹 Indexing – Speed Up Queries 🚀**  
✅ **What?** A **data structure** (B-Tree, Hash) that helps in **faster search**.  
✅ **Why?** Instead of scanning the entire table, it **jumps directly** to relevant rows.  
✅ **Example:** `CREATE INDEX idx_name ON employees(name);`  
✅ **Downside?** Uses **extra storage** and **slows inserts/updates**.  

---

## **🔹 Stored Procedure – Reusable SQL Code ⚙️**  
✅ **What?** A **predefined SQL block** stored in the database.  
✅ **Why?** **Faster execution** (precompiled) and **reduces redundancy**.  
✅ **Example:**  
```sql
CREATE PROCEDURE GetUsers()
BEGIN
   SELECT * FROM users;
END;
```  
✅ **Downside?** Harder to debug, less flexible than app-level logic.  

---

## **🔹 Normalization – Remove Data Redundancy 🔄**  
✅ **What?** **Organizing tables** to avoid duplicate data.  
✅ **Why?** **Saves space, avoids anomalies**, and improves consistency.  
✅ **Levels:**  
1️⃣ **1NF** → Atomic values (no lists inside cells).  
2️⃣ **2NF** → No partial dependency (non-key columns depend only on the primary key).  
3️⃣ **3NF** → No transitive dependency (no indirect dependency on the primary key).  

✅ **Downside?** **More joins** can slow down queries.  

---

## **🔹 Aggregation – Group & Summarize Data 📊**  
✅ **What?** **Mathematical operations** on groups of data.  
✅ **Why?** Useful for reports, analytics.  
✅ **Example:**  
```sql
SELECT department, COUNT(*) FROM employees GROUP BY department;
```  
✅ **Functions:** `SUM()`, `AVG()`, `COUNT()`, `MAX()`, `MIN()`  

✅ **Downside?** Aggregations on large datasets **can be slow** without indexing.  

---

## **🔹 Joins – Combine Tables 🔗**  
✅ **What?** **Merging data** from multiple tables based on relationships.  
✅ **Why?** Avoids duplicate storage, maintains **data integrity**.  
✅ **Types:**  
- **INNER JOIN** → Only matching records.  
- **LEFT JOIN** → All from left, matching from right.  
- **RIGHT JOIN** → All from right, matching from left.  
- **FULL JOIN** → All records from both tables.  

✅ **Example:**  
```sql
SELECT e.name, d.department FROM employees e
INNER JOIN departments d ON e.dept_id = d.id;
```  

✅ **Downside?** **More joins = slower queries** without indexing.  

---

## **🔹 Transactions – Ensure Data Integrity ✅**  
✅ **What?** A **group of SQL operations** that should be **executed together**.  
✅ **Why?** If any step fails, **rollback** everything → **ACID properties**:  
- **Atomicity** → All or nothing.  
- **Consistency** → Data remains valid.  
- **Isolation** → Transactions don’t affect each other.  
- **Durability** → Data is permanent after commit.  

✅ **Example:**  
```sql
START TRANSACTION;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
COMMIT;  -- Saves changes
-- ROLLBACK; (if something fails)
```  

✅ **Downside?** **Locks resources**, slowing performance under heavy load.  

---

## **🔹 Views – Virtual Tables 📄**  
✅ **What?** A **stored SQL query** that acts like a table.  
✅ **Why?** **Security (restricts access)**, simplifies complex queries.  
✅ **Example:**  
```sql
CREATE VIEW active_users AS
SELECT name, email FROM users WHERE status = 'active';
```  
✅ **Downside?** Views **don’t store data**, just an SQL query.  

---

## **🔹 Triggers – Auto Execute SQL 🔄**  
✅ **What?** **Auto-runs SQL** when an event happens (INSERT, UPDATE, DELETE).  
✅ **Why?** Used for **audit logs, validation, or automatic updates**.  
✅ **Example:**  
```sql
CREATE TRIGGER update_timestamp
BEFORE UPDATE ON orders
FOR EACH ROW SET NEW.updated_at = NOW();
```  
✅ **Downside?** Hard to debug and can slow down write operations.  

---

## **🔹 SQL Clauses – Control Query Behavior 🎯**  
Clauses **filter, group, and modify** how data is retrieved.  

### **1️⃣ WHERE – Filter Rows**  
✅ **Used in:** `SELECT`, `UPDATE`, `DELETE`  
✅ **Why?** Fetch only the needed data.  
✅ **Example:**  
```sql
SELECT * FROM employees WHERE age > 30;
```  
### **2️⃣ ORDER BY – Sort Data**  
✅ **Sorts results in **ascending (`ASC`) or descending (`DESC`)** order.  
✅ **Example:**  
```sql
SELECT name, salary FROM employees ORDER BY salary DESC;
```  
### **3️⃣ GROUP BY – Group & Aggregate**  
✅ **Used with aggregate functions** (`SUM`, `COUNT`, `AVG`).  
✅ **Example:**  
```sql
SELECT department, COUNT(*) FROM employees GROUP BY department;
```  
### **4️⃣ HAVING – Filter After Grouping**  
✅ **Like `WHERE`, but for aggregate results.**  
✅ **Example:**  
```sql
SELECT department, AVG(salary) FROM employees
GROUP BY department HAVING AVG(salary) > 50000;
```  
### **5️⃣ LIMIT – Restrict Results**  
✅ **Fetch only a certain number of rows.**  
✅ **Example:**  
```sql
SELECT * FROM products LIMIT 10;
```  
### **6️⃣ DISTINCT – Remove Duplicates**  
✅ **Returns only unique values.**  
✅ **Example:**  
```sql
SELECT DISTINCT department FROM employees;
```  
### **7️⃣ JOIN – Combine Tables**  
✅ **Fetch related data from multiple tables.**  
✅ **Example (Inner Join):**  
```sql
SELECT employees.name, departments.name 
FROM employees INNER JOIN departments 
ON employees.dept_id = departments.id;
```  
### **8️⃣ UNION – Merge Result Sets**  
✅ **Combines results of two `SELECT` queries (removes duplicates).**  
✅ **Example:**  
```sql
SELECT name FROM employees
UNION
SELECT name FROM clients;
```  

✅ **Use `UNION ALL`** to keep duplicates.  

---

## **🔹 SQL Constraints – Enforce Data Integrity 🚀**  
Constraints **control what values can be inserted, updated, or deleted** in a table to maintain data accuracy.  

### **1️⃣ PRIMARY KEY – Unique + Not Null**  
✅ **Ensures each row is uniquely identified.**  
✅ **Example:**  
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY, 
    name VARCHAR(50)
);
```  

✅ **Composite Primary Key (Multiple Columns):**  
```sql
CREATE TABLE orders (
    order_id INT, 
    product_id INT, 
    PRIMARY KEY (order_id, product_id)
);
```

### **2️⃣ FOREIGN KEY – Enforce Relationships**  
✅ **Links one table to another.**  
✅ **Prevents invalid data (can’t insert non-existent values).**  
✅ **Example:**  
```sql
CREATE TABLE orders (
    id INT PRIMARY KEY, 
    customer_id INT, 
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);
```

### **3️⃣ NOT NULL – Prevent Empty Values**  
✅ **Ensures a column cannot have `NULL` values.**  
✅ **Example:**  
```sql
CREATE TABLE users (
    id INT PRIMARY KEY, 
    email VARCHAR(100) NOT NULL
);
```  

### **4️⃣ UNIQUE – No Duplicate Values**  
✅ **Ensures all values in a column are distinct.**  
✅ **Example:**  
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY, 
    email VARCHAR(100) UNIQUE
);
```  

✅ **For multiple columns:**  
```sql
CREATE TABLE users (
    email VARCHAR(100), 
    phone VARCHAR(15), 
    CONSTRAINT unique_user UNIQUE (email, phone)
);
```

### **5️⃣ CHECK – Validate Data**  
✅ **Ensures a column meets a condition before inserting/updating.**  
✅ **Example:**  
```sql
CREATE TABLE products (
    id INT PRIMARY KEY, 
    price DECIMAL(10,2) CHECK (price > 0)
);
```  

### **6️⃣ DEFAULT – Auto-Fill Values**  
✅ **Sets a default value if none is provided.**  
✅ **Example:**  
```sql
CREATE TABLE users (
    id INT PRIMARY KEY, 
    status VARCHAR(20) DEFAULT 'Active'
);
```  

✅ **Now, if we insert without `status`, it defaults to `'Active'`.**  
```sql
INSERT INTO users (id) VALUES (1); 
SELECT * FROM users;  -- status = 'Active'
```

### **7️⃣ AUTO_INCREMENT – Auto-Generate IDs**  
✅ **Automatically assigns unique values (for primary keys).**  
✅ **Example:**  
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(50)
);
```  

---

## **🔹 SQL Language Categories – 4 Types 🚀**  
SQL is divided into **4 main language types**, each serving a specific purpose.  

### **1️⃣ DDL (Data Definition Language) – Structure 📌**  
✅ **Used to define, modify, or delete database objects (tables, schemas, indexes).**  
✅ **Examples:**  

| Command  | Purpose |
|----------|---------|
| `CREATE`  | Create a new table/database |
| `ALTER`   | Modify existing table structure |
| `DROP`    | Delete a table/database |
| `TRUNCATE` | Delete all rows but keep structure |

🔹 **Example:**  
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY, 
    name VARCHAR(50)
);
```  

### **2️⃣ DML (Data Manipulation Language) – Data 🚀**  
✅ **Used to insert, update, delete, and retrieve records.**  
✅ **Examples:**  

| Command  | Purpose |
|----------|---------|
| `INSERT` | Add new records |
| `UPDATE` | Modify existing records |
| `DELETE` | Remove records |
| `SELECT` | Retrieve data |

🔹 **Example:**  
```sql
INSERT INTO employees (id, name) VALUES (1, 'John');
UPDATE employees SET name = 'Jane' WHERE id = 1;
DELETE FROM employees WHERE id = 1;
SELECT * FROM employees;
```  

### **3️⃣ DCL (Data Control Language) – Permissions 🔒**  
✅ **Used to control access to the database.**  
✅ **Examples:**  

| Command  | Purpose |
|----------|---------|
| `GRANT`  | Give privileges to users |
| `REVOKE` | Remove privileges from users |

🔹 **Example:**  
```sql
GRANT SELECT, INSERT ON employees TO user1;
REVOKE INSERT ON employees FROM user1;
```  

### **4️⃣ TCL (Transaction Control Language) – Transactions 🔄**  
✅ **Used to manage transactions in a database.**  
✅ **Examples:**  

| Command  | Purpose |
|----------|---------|
| `COMMIT` | Save all changes permanently |
| `ROLLBACK` | Undo uncommitted changes |
| `SAVEPOINT` | Create checkpoints in a transaction |

🔹 **Example:**  
```sql
BEGIN;
UPDATE employees SET salary = 50000 WHERE id = 1;
SAVEPOINT before_salary_update;
ROLLBACK TO before_salary_update; -- Undo salary update
COMMIT; -- Finalize changes
```  

---

💡 **DDL = Structure, DML = Data, DCL = Permissions, TCL = Transactions.**  

