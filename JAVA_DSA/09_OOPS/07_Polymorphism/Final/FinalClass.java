package Final;

final class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// The following class would result in a compile-time error
// class Dog extends Animal {
//     void sound() {
//         System.out.println("Dog barks");
//     }
// }

public class FinalClass {  // it cannot be subclassed (i.e., no other class can extend it)
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Outputs: Animal makes a sound
    }
}
