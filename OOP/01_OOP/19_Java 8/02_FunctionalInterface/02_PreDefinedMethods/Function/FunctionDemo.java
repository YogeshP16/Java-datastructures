import java.util.function.Function;

class FunctionImpl implements Function<String, Integer> {   // Function<T, R>  T -> input , R -> output
    // Function is a functional interface in the java.util.function package
    // It represents a function that takes an input of type T and returns a result of type R.

    @Override
    public Integer apply(String s) {
        return s.length();  // The apply method is implemented to return the length of the string.
    }
}

public class FunctionDemo {
    public static void main(String[] args) {

        // -> old way (using custom implementation)

        Function<String, Integer> fun = new FunctionImpl();  
        System.out.println(fun.apply("Yogesh"));  // 6
       
    }
}


/*
Function<T, R>:

It is a predefined functional interface in the java.util.function package.
T: Input type.
R: Output type.
It represents a function that accepts one argument of type T and produces a result of type R.
The abstract method in this interface is R apply(T t).

apply(T t):

This method is used to apply the function on the given argument t and return a result of type R.
 */