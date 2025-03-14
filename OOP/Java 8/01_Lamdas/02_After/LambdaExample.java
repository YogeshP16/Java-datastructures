@FunctionalInterface
interface Shape {
    void draw();
}

public class LambdaExample {
    public static void main(String[] args) {
        
        // First way: Using lambda expressions to implement Shape
        Shape circle = () -> System.out.println("this is circle");
        Shape square = () -> System.out.println("this is square");

        circle.draw();
        square.draw();
        
        //-----------------------------------------------------------

        // Second way: Passing the lambda directly to the method
        print(() -> System.out.println("this is Rectangle"));
    }

    // Method that takes a Shape and calls its draw method
    private static void print(Shape shape) {
        shape.draw();
    }
}

/*
this is circle
this is square
this is Rectangle
 */