import java.util.function.Function;

public class FunctionUsingLambda {
    public static void main(String[] args) {

         // Lambda expression to implement the Function interface
        // (String s) -> s.length() is the lambda that takes a string input and returns its length.
        
        Function<String, Integer> fun = (String s) -> s.length();
        System.out.println(fun.apply("Yogesh"));  // 6
    }

}
