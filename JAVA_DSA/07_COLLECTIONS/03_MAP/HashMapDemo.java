import java.util.HashMap;

public class HashMapDemo {
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

/*
HashCode of 'hello': 99162322
HashCode of Integer 1232234: 1232234
Value for 'loki': 90
Value for 'gm' (default 83): 83
Contains key 'siri': true
Contains key 'gm': false
Contains key 'siri' after removal: false
Size of map: 2
Size of map after clear: 0
 */
