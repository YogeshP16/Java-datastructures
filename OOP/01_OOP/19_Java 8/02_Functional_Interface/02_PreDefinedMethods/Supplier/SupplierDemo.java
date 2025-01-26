import java.time.LocalDateTime;  
import java.util.function.Supplier;  

class SupplierImpl implements Supplier<LocalDateTime> {
    // Supplier is a functional interface that takes no arguments and returns a result.
    // It represents a function that supplies a result without requiring any input.
    
    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();  // The get method is implemented to return the current date and time.
    }
}

public class SupplierDemo {
    public static void main(String[] args) {

        // Creating an instance of the SupplierImpl class which implements the Supplier interface.
        // The Supplier interface doesn't take any input and returns a LocalDateTime object.
        Supplier<LocalDateTime> supplier = new SupplierImpl();
        
        // Calling the get() method to get the current date and time.
        System.out.println(supplier.get());  // This will print the current date and time (e.g., 2025-01-25T17:31:35.106479500)
    }
}

