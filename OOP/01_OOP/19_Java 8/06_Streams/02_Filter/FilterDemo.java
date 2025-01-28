import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {

        /* -->  output
        Product [id=3, name=Apple, price=45000.0]
        Product [id=4, name=Oppo, price=50000.0]
        Product [id=5, name=Vivo, price=30000.0]
         */


        // filter product by price > 25000 without using stream API
        List<Product> list = new ArrayList<Product>();

        for(Product p :  getProduct()){
            if(p.getPrice() > 25000){
                list.add(p);
            }
        }

        for(Product productResult  : list){
            System.out.println(productResult);
        }

        System.out.println(); // for space

        // filter product by price > 25000 with using stream API
        List<Product> list1 = getProduct()
                            .stream().filter((product) -> product.getPrice() > 25000) // filter -> intermediate operation
                            .collect(Collectors.toList());  // terminal operation
                            
        for (Product result: list1) {
            System.out.println(result);
            
        }  

        System.out.println(); // for space

       // filter product by price > 25000 with using stream API and foreach 
        getProduct()
                .stream().filter((product) -> product.getPrice() > 25000)
                .forEach(System.out::println);
                
    }

    private static List<Product> getProduct(){

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Samsung", 25000));
        products.add(new Product(2, "Mi", 12000));
        products.add(new Product(3, "Apple", 45000));
        products.add(new Product(4, "Oppo", 50000));
        products.add(new Product(5, "Vivo", 30000));
        products.add(new Product(6, "Nokia", 15000));

        return products;
    }

}

class Product{

    private int id;
    private String name;
    private float price;

    // constructor
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getter setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }


}
