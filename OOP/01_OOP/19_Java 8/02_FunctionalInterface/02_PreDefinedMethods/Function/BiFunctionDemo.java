import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {

        // BiFunction<T, U, R>: Takes two arguments (T, U) and returns a result (R).
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> (a + b); // Adds two numbers

        BiFunction<Integer, Integer, Integer> sub = (a, b) -> (a - b); // Subtracts two numbers
        
        // Applying the BiFunction to two integers
        System.out.println(sum.apply(20, 40)); // 60
        System.out.println(sub.apply(34, 45)); // -11
    }
}

