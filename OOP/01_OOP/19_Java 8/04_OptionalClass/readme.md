### **Optional Class in Java**
- A container to handle `null` values safely and avoid `NullPointerException`.
- Act as a single value container that either contains value or doesn't.
- it is a final class we cannot extend, it is an utility class based in java util package
- these are static method to create optional
    - `of(value)`  -> internally provide null pointer exception
    - `ofNullable(value)` -> it doesnt throw exception
    - `empty()` --> Present in tostring method check empty or not

---

#### **2. Why use `Optional`?**
- Prevents unexpected `null` checks.
- Simplifies handling of missing values.

---

#### **3. Key Methods:**
| **Method**               | **Purpose**                             |
|---------------------------|-----------------------------------------|
| `of(value)`               | Wrap a non-`null` value.               |
| `ofNullable(value)`       | Wrap a value (can be `null`).          |
| `empty()`                 | Create an empty `Optional`.            |
| `isPresent()`             | Checks if a value is present.          |
| `ifPresent(consumer)`     | Executes if a value is present.        |
| `orElse(defaultValue)`    | Returns value or a default if `null`.  |
| `orElseGet(supplier)`     | Returns value or generates it.         |
| `orElseThrow(exception)`  | Throws an exception if value is absent.|

---



