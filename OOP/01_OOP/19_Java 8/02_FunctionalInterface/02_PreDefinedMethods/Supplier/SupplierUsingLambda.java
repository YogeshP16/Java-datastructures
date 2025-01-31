// import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierUsingLambda {
    public static void main(String[] args) {

        // Supplier is a functional interface that takes no arguments and returns a result.
        // It represents a function that supplies a result without requiring any input.
        
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());  // 2025-01-25T17:33:45.268608200
    }

}
