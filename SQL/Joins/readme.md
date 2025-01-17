
---

### **1. INNER JOIN**  
**Use When:**  
- You only need rows where there is a match in both tables.  
- Unmatched rows from either table should be excluded.  
**Clue:**  
- Keywords like *"only matching,"* *"both present,"* or *"common data"* are used.  

**Syntax**
``` sql
SELECT A.column1, B.column2
FROM TableA A
INNER JOIN TableB B ON A.common_column = B.common_column;
``` 

**Example Use Case:**  
- Fetch employees and their department names (employees must have a valid department).  
```sql
SELECT e.name, d.name  
FROM employee e  
INNER JOIN department d ON e.dept_id = d.id;
```

---

### **2. LEFT JOIN**  
**Use When:**  
- You need all rows from the **left table** and matching rows from the right table.  
- Unmatched rows in the right table should appear as `NULL`.  

**Clue:**  
- Keywords like *"all from left,"* *"even if no match,"* or *"include missing data"* are used.  

**Syntax**
``` sql
SELECT A.column1, B.column2
FROM TableA A
LEFT JOIN TableB B ON A.common_column = B.common_column;
```

**Example Use Case:**  
- Fetch all employees, even those without a department.  
```sql
SELECT e.name, d.name  
FROM employee e  
LEFT JOIN department d ON e.dept_id = d.id;
```

---

### **3. RIGHT JOIN**  
**Use When:**  
- You need all rows from the **right table** and matching rows from the left table.  
- Unmatched rows in the left table should appear as `NULL`.  
**Clue:**  
- Keywords like *"all from right,"* *"include all in the second table,"* or *"include missing rows from the right"* are used.  

**Syntax**
``` sql
SELECT A.column1, B.column2
FROM TableA A
RIGHT JOIN TableB B ON A.common_column = B.common_column;
``` 

**Example Use Case:**  
- Fetch all departments, even if there are no employees assigned to them.  
```sql
SELECT e.name, d.name  
FROM employee e  
RIGHT JOIN department d ON e.dept_id = d.id;
```

---

### **4. FULL OUTER JOIN**  
**Use When:**  
- You need all rows from **both tables**, whether or not they have a match.  
- Unmatched rows from both sides should appear as `NULL`.  
**Clue:**  
- Keywords like *"include everything,"* *"all from both sides,"* or *"no data should be excluded"* are used.  

**Syntax**
``` sql
SELECT A.column1, B.column2
FROM TableA A
FULL JOIN TableB B ON A.common_column = B.common_column;
``` 

**Example Use Case:**  
- Fetch all employees and all departments, even if they don’t match.  
```sql
SELECT e.name, d.name  
FROM employee e  
FULL OUTER JOIN department d ON e.dept_id = d.id;
```

---

### **5. WHERE Clause with Joins**  
**Use When:**  
- You need to filter the results of a join based on specific conditions.  
**Clue:**  
- Keywords like *"only specific rows,"* *"filter conditions,"* or *"based on criteria"* are used.  

**Example Use Case:**  
- Fetch employees in departments located in 'New York'.  
```sql
SELECT e.name, d.location  
FROM employee e  
INNER JOIN department d ON e.dept_id = d.id  
WHERE d.location = 'New York';
```


### **5. CROSS JOIN**  
**Use When:**  
- You need a **Cartesian Product** of two tables, i.e., every row from the first table is paired with every row from the second table.  
- Typically used when you need all possible combinations of rows from two tables.  

**Clue:**  
- Keywords like *"all combinations"* or *"pair every row from Table A with every row from Table B"* are used.  
- Use cautiously as it can generate a large result set.

---

**Syntax**  
```sql
SELECT A.column1, B.column2
FROM TableA A
CROSS JOIN TableB B;
```  

**Example Use Case:**  
- Generate all combinations of employees and project IDs for assignment planning.  

```sql
SELECT e.name AS employee_name, p.project_id AS project_id
FROM employee e
CROSS JOIN project p;
```  

---

### **6. SELF JOIN**  
**Use When:**  
- You need to join a table to itself.  
- Commonly used when you need to compare rows in a table or find hierarchical relationships.  

**Clue:**  
- Keywords like *"compare rows in the same table"* or *"find parent-child relationships"* are used.  
- Alias the table to differentiate between instances of the same table.  

---

**Syntax**  
```sql
SELECT A.column1, B.column2
FROM TableA A
INNER JOIN TableA B
ON A.common_column = B.common_column;
```  

**Example Use Case:**  
- Find employees and their managers from the same employee table.  

```sql
SELECT e1.name AS employee_name, e2.name AS manager_name
FROM employee e1
LEFT JOIN employee e2
ON e1.manager_id = e2.emp_id;
```  

### **Tips to Identify the Right Join**  

| Join Type        | When to Use                                                                                 | Example Question Clue                                      |  
|-------------------|---------------------------------------------------------------------------------------------|-----------------------------------------------------------|  
| **INNER JOIN**    | Need only matching rows from both tables                                                   | "Only include related data" or "common rows from both."    |  
| **LEFT JOIN**     | Need all rows from the left table, even if no match in the right table                     | "Include all from the left," "Even if no department."      |  
| **RIGHT JOIN**    | Need all rows from the right table, even if no match in the left table                     | "Include all from the right," "Departments with no employees." |  
| **FULL OUTER JOIN** | Need all rows from both tables, with `NULL` for non-matching rows                         | "All data regardless of match," "Include unmatched rows."  |  

---

``` sql

    SELECT <column_list>
    FROM <table1>
    [JOIN_TYPE] <table2>
    ON <table1.column_name = table2.column_name>
    [WHERE <condition>]
    [GROUP BY <column_list>]
    [HAVING <condition>]
    [ORDER BY <column_list>];

```