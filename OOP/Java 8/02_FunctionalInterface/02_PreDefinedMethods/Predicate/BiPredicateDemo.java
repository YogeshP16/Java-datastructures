import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        
        // BiPredicate<T, U>: Takes two arguments (T, U) and returns a boolean value
        // Example: Checking if two integers are equal
        BiPredicate<Integer, Integer> checkEquals = (x, y) -> x.equals(y);
        
        // Using the BiPredicate to check if two numbers are equal
        System.out.println(checkEquals.test(10, 10));  // true
        System.out.println(checkEquals.test(10, 20));  // false

        BiPredicate<String, String> equals = (String s1, String s2) -> s1.equals(s2);
        System.out.println(equals.test("Yogesh", "Zeke"));
    }
}

