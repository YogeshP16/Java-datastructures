
// Final class representing a Vehicle
final class Vehiclee {
    void honk() {
        System.out.println("Vehicle makes a honking sound");
    }
}

// The following class would result in a compile-time error
// class Car extends Vehicle {
//     void honk() {
//         System.out.println("Car honks");
//     }
// }

public class FinalClass {  // it cannot be subclassed (i.e., no other class can extend it)
    public static void main(String[] args) {
        Vehiclee vehicle = new Vehiclee();
        vehicle.honk();  // Outputs: Vehicle makes a honking sound
    }
}

