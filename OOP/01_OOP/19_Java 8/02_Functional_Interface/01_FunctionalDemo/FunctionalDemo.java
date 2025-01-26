@FunctionalInterface
interface Shape {
    void draw(); // interface with single abstract method -> by default it takes abstract
}


/* --> Traditional way to implement

class Circle implements Shape{
    public void draw(){
        System.out.println("this is cicle");
    }
}
*/

public class FunctionalDemo {
    public static void main(String[] args) {
        
        // New Way: Using lambda expressions to implement Shape
        Shape circle = () -> System.out.println("this is circle");
        Shape square = () -> System.out.println("this is square");

        circle.draw();
        square.draw();
        
       
    }

}

/*
this is circle
this is square
 */