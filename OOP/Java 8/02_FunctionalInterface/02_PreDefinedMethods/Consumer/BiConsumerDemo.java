import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        
        // BiConsumer<T, U>: Takes two arguments (T, U) and performs an operation (void return type)
        // Example: Adding two integers
        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println(a + b); 
        add.accept(23, 56);  // Output: 79

        // Example: Multiplying two integers
        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println(a * b); 
        multiply.accept(23, 56); // Output: 1288
    }
}
