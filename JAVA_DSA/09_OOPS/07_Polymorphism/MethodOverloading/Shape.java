public class Shape {

    
    // Compile-time Polymorphism (Static Polymorphism):
    // How it occurs --> when Method overloading --> Method have same name but different parameter(number, type, or order of parameters)
    // compiler only determines which method to invoke based on the arguments passed at compile time.
    void draw (int x){
        System.out.println("draw with " + x + " points");
    }

    void draw (int x, int y){
        System.out.println("draw with " + x + " points " + y);
    }

}
