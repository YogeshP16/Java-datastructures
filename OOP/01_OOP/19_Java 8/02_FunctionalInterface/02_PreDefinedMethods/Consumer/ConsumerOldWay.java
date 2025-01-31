import java.util.function.Consumer; 

class ConsumerImpl implements Consumer<String> {  
    // Consumer is a functional interface that accepts a single argument and returns no result.
    // It represents an operation that takes an argument and performs some action with it.

    @Override
    public void accept(String input) {
        System.out.println(input);  // This method accepts a String input and prints it.
    }
}

public class ConsumerOldWay {
    public static void main(String[] args) {

        // Old way: Using custom implementation of Consumer
        // Here, we are creating an object of the ConsumerImpl class which implements the Consumer interface.
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Hello World");  // This will print "Hello World" to the console.
    }
}
