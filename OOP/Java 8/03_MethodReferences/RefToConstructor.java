import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class RefToConstructor {
    public static void main(String[] args) {
        // Create a list of fruits with duplicates
        List<String> fruits = Arrays.asList("apple", "grape", "mango", "banana", "cherry", "apple");

        // Using a lambda expression to convert the list into a set
        // Lambda expression creates a new HashSet from the given list, which removes duplicates
        Function<List<String>, Set<String>> setFunction = (fruit) -> new HashSet<>(fruit);
        System.out.println(setFunction.apply(fruits)); // Output: [banana, apple, cherry, grape, mango]

        // Converting the lambda expression to a method reference
        // HashSet::new refers to the HashSet constructor that accepts a collection
        // This method reference achieves the same result as the lambda expression
        Function<List<String>, Set<String>> setFunctionMethodRef = HashSet::new;
        System.out.println(setFunctionMethodRef.apply(fruits)); // Output: [banana, apple, cherry, grape, mango]
    }
}

