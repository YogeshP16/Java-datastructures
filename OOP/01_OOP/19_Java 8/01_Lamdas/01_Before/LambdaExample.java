// Functional interfaace
// interface with one abstract method (Single abstract method)
// works with lambas
// can have n number of default, static methods

@FunctionalInterface
interface Shape {
    void draw();  // one abstract method

}


// we created polymorphism 
// shape interface implements circle, square

class square implements Shape{  // lambdas introduced to short this method in single line 
    @Override
    public void draw(){
        System.out.println("I drawn square");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("I drawn circle");
    }
}


public class LambdaExample{
    public static void main(String[] args) {
        Shape obj = new Circle();
        obj.draw();
        
    }
}



