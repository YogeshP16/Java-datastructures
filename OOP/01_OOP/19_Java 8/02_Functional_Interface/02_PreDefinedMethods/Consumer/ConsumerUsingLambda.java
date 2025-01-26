import java.util.function.Consumer;

public class ConsumerUsingLambda {
    public static void main(String[] args) {

        // using lambda in consumer function
        
        Consumer<String> consumer = ( input) -> System.out.println(input);
        consumer.accept("hello world");
        
    }


}
