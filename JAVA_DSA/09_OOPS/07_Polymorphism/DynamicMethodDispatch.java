

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Animal animal1 = new Dog();  // Upcasting: Animal reference, Dog object
        Animal animal2 = new Cat();  // Upcasting: Animal reference, Cat object

        // Dynamic method dispatch
        animal1.sound();  // Outputs: Dog barks (Dog's sound() method is called)
        animal2.sound();  // Outputs: Cat meows (Cat's sound() method is called)
    }
}

/*
Upcasting: animal1 and animal2 are declared as Animal, but they refer to objects of type Dog and Cat, respectively.

Method Call: When sound() is called on animal1 and animal2, 
Java uses dynamic method dispatch to determine which sound() method to call based on the actual object type:

animal1.sound() calls the sound() method in the Dog class, because the actual object is a Dog.
animal2.sound() calls the sound() method in the Cat class, because the actual object is a Cat.
 */