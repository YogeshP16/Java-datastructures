class Box {   // parent class or base class or Super classs

    // private members  --> related to access modifier
    //  cannot be accessed directly outside the Box class, even in a child class.
    private double length, width, height; 

    // here the constructor is public/ default so it can be called from outside the class.
    // The constructor initializes the private variables: length, width, and height.
    Box(double l, double w, double h) { // parameterized Constructor (parent class constructor)
        length = l; width = w; height = h;
    }

    void displayVolume() {
        System.out.println("Volume: " + (length * width * height));


        System.out.println(length);
    }

    
}
// Inheritance 
// Boxweight --> subclass
// extends --> used to create a child class (subclass) from a parent class (superclass).
class BoxWeight extends Box {  
    double weight;

    BoxWeight(double l, double w, double h, double wt) {
        // here super class used to call parant class constructor
        // how it access private variable --> super keyword does not bypass private access
        // It uses the parent class's public/protected constructor or methods
        // to work with private members indirectly
        super(l, w, h); // Calls parent constructor (calls base class constructor)
        weight = wt;
    }

    void displayWeight() {
        System.out.println("Weight: " + weight);

        // Error --> field box not visible --> becuz Superclass (Box)  varible names are private so cant access
       // System.out.println(length);   --> here accessing private variable length --> 
    }

    
}

public class Inheritance {
    public static void main(String[] args) {
        BoxWeight b = new BoxWeight(2, 3, 4, 5);
        b.displayVolume();  // From parent class
        b.displayWeight();  // From child class

        
    }
}
