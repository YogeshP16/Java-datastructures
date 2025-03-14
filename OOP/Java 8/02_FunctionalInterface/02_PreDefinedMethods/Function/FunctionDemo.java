import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        // Function is a functional interface in the java.util.function package
        // It represents a function that takes an input of type T and returns a result of type R.

        // Lambda expression to implement the Function interface
        // (String s) -> s.length() is the lambda that takes a string input and returns its length.
        
        Function<String, Integer> fun = (String s) -> s.length();
        System.out.println(fun.apply("Yogesh"));  // 6
    }

}
