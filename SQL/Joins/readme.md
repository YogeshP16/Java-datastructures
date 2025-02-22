### **SQL Joins - Quick Reference**

**INNER JOIN**  
- **Use When:** Only need rows with matches in both tables.  
- **Clue:** Keywords like "only matching," "both present," or "common data."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    INNER JOIN TableB B ON A.common_column = B.common_column;
    ```  
- **Example:** Fetch employees and their department names (employees must have a valid department).

**LEFT JOIN**  
- **Use When:** Need all rows from the left table and matching rows from the right table.  
- **Clue:** Keywords like "all from left," "even if no match," or "include missing data."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    LEFT JOIN TableB B ON A.common_column = B.common_column;
    ```  
- **Example:** Fetch all employees, even those without a department.

**RIGHT JOIN**  
- **Use When:** Need all rows from the right table and matching rows from the left table.  
- **Clue:** Keywords like "all from right," "include all in the second table," or "include missing rows from the right."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    RIGHT JOIN TableB B ON A.common_column = B.common_column;
    ```  
- **Example:** Fetch all departments, even if there are no employees assigned to them.

**FULL OUTER JOIN**  
- **Use When:** Need all rows from both tables, whether or not they have a match.  
- **Clue:** Keywords like "include everything," "all from both sides," or "no data should be excluded."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    FULL JOIN TableB B ON A.common_column = B.common_column;
    ```  
- **Example:** Fetch all employees and all departments, even if they don’t match.

**CROSS JOIN**  
- **Use When:** Need a Cartesian Product of two tables.  
- **Clue:** Keywords like "all combinations" or "pair every row from Table A with every row from Table B."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    CROSS JOIN TableB B;
    ```  
- **Example:** Generate all combinations of employees and project IDs for assignment planning.

**SELF JOIN**  
- **Use When:** Need to join a table to itself.  
- **Clue:** Keywords like "compare rows in the same table" or "find parent-child relationships."  
- **Syntax:**
    ```sql
    SELECT A.column1, B.column2
    FROM TableA A
    INNER JOIN TableA B ON A.common_column = B.common_column;
    ```  
- **Example:** Find employees and their managers from the same employee table.

### **Tips to Identify the Right Join**  

| Join Type        | When to Use                                                                                 | Example Question Clue                                      |  
|-------------------|---------------------------------------------------------------------------------------------|
*/-----------------------------------------------------------|  
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
---

