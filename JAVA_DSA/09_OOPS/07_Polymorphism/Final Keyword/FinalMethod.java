
class Animal {
    final void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Trying to override the final method will result in a compile-time error
    // void sound() {
    //     System.out.println("Dog barks");
    // }
}

public class FinalMethod {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();  // Outputs: Animal makes a sound
    }
}

/*
The sound() method in the Animal class is declared as final, so it cannot be overridden by any subclass, including the Dog class.
The sound() method retains its behavior across all subclasses.
 */
