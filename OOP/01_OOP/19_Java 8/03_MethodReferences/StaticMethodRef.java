import java.util.function.BiFunction;
import java.util.function.Function;

public class StaticMethodRef {

    // Static Method ref
    static int addition(int a, int b){
        return (a+b);
    }



    public static void main(String[] args) {

        // Method ref to static method
        // using lambda
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));  // 2.0

        // using method reference
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(4));  //2.0

//--------------------------------------------------------------------------------------
        // using lambda expression 
        // using Bifunction
        BiFunction<Integer, Integer, Integer> biFunctionLambda  = (a,b) -> StaticMethodRef.addition(a,b);
        System.out.println(biFunctionLambda.apply(10, 20)); // 30

        //using method ref
        BiFunction<Integer, Integer, Integer> biFunctionMethodref  =  StaticMethodRef::addition;
        System.out.println(biFunctionMethodref.apply(10, 20));  // 30


    }

}
