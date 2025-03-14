// Functional Interface

import java.util.function.Function;

interface Printable { 
    void print(String msg);  // Single abstract method
}

public class InstanceMethodRefObj {

    // Instance method that converts a message to uppercase and prints it
    public void display(String msg) {
        msg = msg.toUpperCase();
        System.out.println(msg);
    }

    public static void main(String[] args) {

        // Using lambda expression
        InstanceMethodRefObj obj = new InstanceMethodRefObj();  // Create an instance of the class
        
        // Lambda expression that calls the display method of the instance
        Printable print = (msg) -> obj.display(msg);
        print.print("hello");  // Output: HELLO

        // Using Method Reference
        // Directly referencing the display method of the created object
        Printable printable = obj::display;
        printable.print("hello there");  // Output: HELLO THERE

//--------------------------------------------------------------------------------------------------

        // Method ref to instance  method of an arbitary obj
        // sometimes, we call method of argument in the lambda exp 
        // in the case, we can use a method ref to call an instance
        // method of an arbitary obj of a specific type
        // using lambda
        Function<String, String> function = (String input) -> input.toUpperCase();
        System.out.println(function.apply("hello hi how r u"));  // HELLO HI HOW R U

        // using method ref
        Function<String, String> funMethodRef = String::toUpperCase;
        System.out.println(funMethodRef.apply("hello hi how are u"));  // HELLO HI HOW ARE U
    

    }
}

