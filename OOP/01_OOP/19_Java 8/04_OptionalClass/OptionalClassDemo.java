import java.util.Optional;

public class OptionalClassDemo {
    public static void main(String[] args) {

        String str = null;  // A null value for demonstration.
        String str1 = "Yogesh";  // A valid string value.

        // Using empty() to create an Optional object that explicitly represents an empty value.
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);  // Output: Optional.empty

        // Using of() to create an Optional object. 
        // It requires a non-null value, otherwise, it throws a NullPointerException.
        Optional<String> ofOptional = Optional.of(str);  
        System.out.println(ofOptional);

        /* Output:
        Exception in thread "main" java.lang.NullPointerException
        at java.base/java.util.Objects.requireNonNull(Objects.java:208)
        at java.base/java.util.Optional.of(Optional.java:113)
        at OptionalClassDemo.main(OptionalClassDemo.java:11)
        */

        // Using ofNullable() to create an Optional object.
        // This method allows null values and does not throw an exception.
        // If the value is null, it creates an empty Optional.
        Optional<String> ofNullableOptional = Optional.ofNullable(str);  
        System.out.println(ofNullableOptional);  // Output: Optional.empty

        // To retrieve the value from an Optional, use the get() method.
        // Note: get() should only be used if you are sure the Optional contains a value, 
        // otherwise, it will throw NoSuchElementException for an empty Optional.
        Optional<String> obj = Optional.ofNullable(str1);
        System.out.println(obj.get());  // Output: Yogesh

        // orElse -> if value present return value else default value 
        Optional<String> obj1 = Optional.ofNullable(str1);
        String defaultvalue = obj1.orElse("zeke");
        System.out.println(defaultvalue);  

        //instance method
        if(obj.isPresent()){
            System.out.println(obj.get());
        } else{
            System.out.println("No value");
        }


    }
}

