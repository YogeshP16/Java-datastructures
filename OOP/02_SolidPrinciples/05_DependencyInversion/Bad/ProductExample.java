import java.util.List;
import java.util.ArrayList;

// ProductRepository directly instantiated inside ProductService (Bad example)
class ProductService {
    private ProductRepository repository = new ProductRepository(); // Direct instantiation (Bad)

    public List<Product> GetProduct() {
        return repository.GetAllProduct();
    }
}

// ProductRepository (no interface or abstraction)
class ProductRepository {
    public List<Product> GetAllProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 100));
        products.add(new Product("Product 2", 200));
        return products;
    }
}

// Product class
class Product {
    String name;
    int price;
    public Product(String name, int price) { this.name = name; this.price = price; }
    public String toString() { return name + " - $" + price; }
}

// Main function (bad practice)
public class ProductExample {
    public static void main(String[] args) {
        ProductService service = new ProductService();  // Bad: tight coupling with ProductRepository
        service.GetProduct().forEach(System.out::println);
    }
}


/*
Dependency Inversion -->  high-level modules should not depend on low-level modules, 
but both should depend on abstractions (interfaces).

here bad example:
 if the low-level module (like ProductRepository) depends on the high-level module (like ProductService), 
 it creates a tight coupling between them, not easy to test.

In good example;
 both the high-level module (like ProductService) and the low-level module (like ProductRepository)
 should depend on abstractions (like interfaces), provide loose coupling.
 
 */