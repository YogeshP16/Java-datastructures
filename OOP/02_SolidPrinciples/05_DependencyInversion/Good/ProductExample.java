import java.util.List;
import java.util.ArrayList;

// Repository Interface
interface IProductRepository {
    List<Product> GetAllProduct();
}

// ProductRepository implementation
class ProductRepository implements IProductRepository {
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

// ProductService with DI
class ProductService {
    private IProductRepository repository;
    public ProductService(IProductRepository repository) { this.repository = repository; }
    public List<Product> GetProduct() { return repository.GetAllProduct(); }
}

// Main function
public class ProductExample {
    public static void main(String[] args) {
        ProductService service = new ProductService(new ProductRepository());
        service.GetProduct().forEach(System.out::println);
    }
}

/*
Product 1 - $100
Product 2 - $200
 */