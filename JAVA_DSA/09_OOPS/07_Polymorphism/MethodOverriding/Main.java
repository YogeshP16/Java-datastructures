

public class Main {
    public static void main(String[] args) {

        // Upcasting: Parent class reference, Child class object
        Shape obj = new Circle();  // Reference of type Shape (parent class), object of type Circle (child class)
        
        // Dynamic method dispatch:
        // This occurs when a parent class reference points to a child class object.
        // The actual method to be executed is determined at runtime based on the object's actual type (child or parent).
        obj.draw();  // Output: I drawn circle

        // No upcasting: Directly using the child class reference to call the overridden method
        Circle obj1 = new Circle();
        obj1.draw();   // Output: I drawn circle
        
    }
    // output
    // I drawn circle
    // I drawn circle

}


/*

Method override 
----------------
method in the subclass with the same name, same return type, and same parameter list as the method in the superclass. 

How Overriding works
-----------------------
Upcasting allows a subclass object to be referenced by a parent class variable.

Overriding allows the subclass to provide its own implementation of a method.

Runtime Polymorphism determines which method to call at runtime based on the object's actual type, 
not the reference type.

*/