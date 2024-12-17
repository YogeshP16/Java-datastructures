/*
 Why Parent obj = new Child(); Works
 ----------------------------------------------
Key Concept
----------
This is an example of upcasting in Java. Upcasting occurs when a child class object is referenced 
by a parent class reference.

It works because a Child IS-A Parent (the child class inherits from the parent class).

What Happens?
---------------
The parent reference (p) can only access members (fields and methods) defined in the parent class.
Any child-specific methods or variables are hidden unless explicitly downcasted.
 */

class Parent {
    int length, width, height;

    Parent(int l, int w, int h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    void displayVolume() {
        System.out.println("Volume: " + (length * width * height));
    }
}

class Child extends Parent {
    int weight;

    Child(int l, int w, int h, int wt) {
        super(l, w, h); // Call Parent constructor
        this.weight = wt;
    }

    void displayWeight() {
        System.out.println("Weight: " + weight);
    }
}

public class Upcasting {
    public static void main(String[] args) {
        Parent p = new Child(2, 3, 4, 10); // Upcasting
        p.displayVolume(); // Access Parent method

        // p.displayWeight(); // Error: Parent reference cannot access Child method

        // Downcasting to access Child-specific members
        Child c = (Child) p;
        c.displayWeight(); // Works
    }
}
