/*
 * HashMap vs Hashtable
 * 
 * HashMap: --> key : Value pair
 * - Allows null keys and values.
 * - Not synchronized, making it faster than Hashtable for single-threaded use cases.
 * - Allows one null key and multiple null values.
 * 
 * Hashtable:
 * - Does not allow null keys or values.
 * - Synchronized, making it slower than HashMap.
 * - Thread-safe.
 * 
 * How numbers are converted into hash codes.
    // hashCode() is used to generate an integer representation for objects.
    // For example, String "hello" will generate a hash code.

    String str = "hello";
    int code = str.hashCode();   // hashCode() converts "hello" to a hash code integer.
    System.out.println("HashCode of 'hello': " + code);  // Output: 99162322

    // Integer objects also have their own hashCode method.
    Integer i = 1232234;
    int res = i.hashCode();     // Integer itself has the same value as its hash code.
    System.out.println("HashCode of Integer 1232234: " + res);  // Output: 1232234

* Internal workings of HashMap:
    // - Internally, HashMap uses an array of "buckets" (slots) to store entries (key-value pairs).
    // - Each bucket corresponds to an index determined by the hash code of the key.
    // - If there is a collision (two keys hash to the same index), HashMap handles it using either:
    //   1. Chaining (linked list of entries at the same bucket index).
    //   2. Open addressing (finding another empty slot using probing).

* Load factor in HashMap:
    // The load factor determines when to resize the internal array (rehashing).
    // - Default load factor is --> 0.75.
    // - If the map exceeds the threshold (load factor * current capacity), the map will resize.
    // - For example, with an initial capacity of 16 and load factor of 0.75, the map will resize
    //   when the number of entries exceeds 12 (16 * 0.75 = 12).

* Rehashing:
    // When the number of entries exceeds the threshold, the map's array size is doubled,
    // and all existing entries are rehashed to the new array.

* In HashMap, insertion and retrieval are typically O(1), but collisions can occur.
* Collision happens when two keys hash to the same index in the hash table.

* Resolving collisions:
    // 1. Chaining: Store multiple elements at the same index using a linked list.
    // 2. Open addressing: Find the next available index using probing.

* Chaining: Every index in the array holds a linked list of elements.
    // Example:
    // [4] --> [] --> [] --> []
    // [7] --> [] --> [] --> []

* Hash function: To convert a large number (hash code) into an index in the hash table:
    // Use modulo operation: hashCode % tableSize

* Hash function methods:
    // - Division method: h(k) = k % m
    // - Multiplication method: h(k) = (k * A) % m, where A is a constant.

* Table size and load factor:
    // - Load factor: n/m where n is the number of keys, and m is the table size.
    // - A higher load factor can increase the likelihood of collisions.

* Open addressing:
    // - Only one item per slot.
    // - When a collision occurs, we try to find the next available slot (probing).
    // - Techniques like linear probing or double hashing are used to resolve collisions.

    // Open addressing is typically more cache-efficient than chaining.
    // Chaining is more resilient to poor hash functions.
    

    */

 import java.util.HashMap;

 public class OO3_HASHMAP {
     public static void main(String[] args) {

        // How numbers are converted into hash codes.
        // hashCode() is used to generate an integer representation for objects.
        // For example, String "hello" will generate a hash code.

        String str = "hello";
        int code = str.hashCode();   // hashCode() converts "hello" to a hash code integer.
        System.out.println("HashCode of 'hello': " + code);  // Output: 99162322

        // Integer objects also have their own hashCode method.
        Integer i = 1232234;
        int res = i.hashCode();     // Integer itself has the same value as its hash code.
        System.out.println("HashCode of Integer 1232234: " + res);  // Output: 1232234
 
         // HashMap implementation in Java (faster than Hashtable for single-threaded use cases).
         HashMap<String, Integer> map = new HashMap<>();
 
         // Basic operations:
         map.put("loki", 90);  // Adds a key-value pair (key: "loki", value: 90)
         map.put("siri", 87);  // Adds a key-value pair (key: "siri", value: 87)
         map.put("skjdh", 76); // Adds a key-value pair (key: "skjdh", value: 76)
 
         // Retrieve a value based on the key.
         System.out.println("Value for 'loki': " + map.get("loki"));  // Output: 90
 
         // If the key does not exist, return a default value.
         System.out.println("Value for 'gm' (default 83): " + map.getOrDefault("gm", 83));  // Output: 83
 
         // Check if a key exists in the map.
         System.out.println("Contains key 'siri': " + map.containsKey("siri"));  // Output: true
         System.out.println("Contains key 'gm': " + map.containsKey("gm"));    // Output: false
 
         // Remove a key-value pair.
         map.remove("siri");  // Removes the entry with key "siri"
         System.out.println("Contains key 'siri' after removal: " + map.containsKey("siri"));  // Output: false
 
         // Get the size of the map (number of key-value pairs).
         System.out.println("Size of map: " + map.size());  // Output: 2
 
         // Clear all entries in the map.
         map.clear();  // Clears all entries.
         System.out.println("Size of map after clear: " + map.size());  // Output: 0
 
         
     }
 }
 