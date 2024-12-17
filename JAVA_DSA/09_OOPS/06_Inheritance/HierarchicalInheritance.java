// Parent class
class Animal {
    void sound() {
        System.out.println("Animals make sound");
    }
}

// Child class 1
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

// Child class 2
class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class HierarchicalInheritance {
    public static void main(String[] args) {
        // Creating objects of child classes
        Animal animal = new Animal(); // Parent class object
        Dog dog = new Dog();          // Child class 1 object
        Cat cat = new Cat();          // Child class 2 object

        // Calling method from Parent class
        animal.sound();  // Output: Animals make sound

        // Calling overridden methods in child classes
        dog.sound();     // Output: Dog barks
        cat.sound();     // Output: Cat meows
    }
}
