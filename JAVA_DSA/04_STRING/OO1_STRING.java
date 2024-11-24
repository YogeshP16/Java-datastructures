
/*
1. Strings in Java
------------------

What is a String?

A String is a sequence of characters. 
Strings in Java are represented by the java.lang.String class, which provides built-in methods for various operations.
Immutability: Strings are immutable, meaning any modification creates a new object rather than altering the existing one.

__________________________________________________________________________________________________________________________

2. Memory Management in Strings
----------------------------------

String Pool

The String Pool is a special area in the Heap memory where string literals are stored.
If a literal already exists in the pool, the reference is reused to save memory.

java

String s1 = "Hello"; // Stored in String Pool
String s2 = "Hello"; // References same object as s1
System.out.println(s1 == s2); // true

Heap Memory (Non-Pool)

Strings created using the new keyword are stored in Heap memory but not in the String Pool.

java

String s3 = new String("Hello");
System.out.println(s1 == s3); // false

Why Strings are Immutable:

Security: Prevents modification of sensitive data like usernames and passwords.
Performance: Enables reusability and caching via the String Pool.
Thread-Safety: Immutable strings are inherently thread-safe.

______________________________________________________________________________________________________________________

== (Reference Equality)
---------------------------

Compares memory locations (references).
Use for primitives or to check if two objects point to the same instance.
Example:

java

String s1 = "Hello";
String s2 = new String("Hello");

System.out.println(s1 == s2); // false (different memory locations)


equals() (Content Equality)

Compares content (logical equality).
Use for objects (e.g., Strings, custom classes) to compare values.
Example:

java

String s1 = "Hello";
String s2 = new String("Hello");

System.out.println(s1.equals(s2)); // true (same content)
Quick Rule:

Use == for memory or primitive checks.
Use equals() for content comparison.

 */


public class OO1_STRING {

    public static void main(String[] args) {

        // ways to create a string

        String s1 = "Hello";   // string literals --> stored in Heap but in string pool region
        System.out.println(s1);  
                                  
        String s2 = new String("Hello");   // new keyword     --> stored in Heap (NON _POOL)
        System.out.println(s2);     

        StringBuilder sb = new StringBuilder("Hello");          // String builder  (Mutable)
        System.out.println(sb);



        // Both s1 and s2 pointing to same object in string literals
        
        String str1 = "Hello";     // String literals stored in string pool
        String str2 = "Hello";

        // equals operator
        System.out.println(str1 == str2);  // it return TRUE both refernce are pointing to same memory location

         // using new keyword 
        String str3 = new String("Hello"); 
        System.out.println(str1 == str3);  // It return False  --> both reference pointing to different memory location

        // equals method
        System.out.println(str1.equals(str3));  // IT return TRUE --> it compare content("hello" == "hello")
        

    }
}
