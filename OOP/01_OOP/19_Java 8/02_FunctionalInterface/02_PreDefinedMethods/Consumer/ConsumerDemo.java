import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        // using lambda in consumer function
        
        Consumer<String> consumer = ( input) -> System.out.println(input);
        consumer.accept("hello world");
        
    }


}
