package DynamicMethodDispatch;
class Machine {
    void operate() {
        System.out.println("Machine operates");
    }
}

class Car extends Machine {
    @Override
    void operate() {
        System.out.println("Car drives");
    }
}

class Airplane extends Machine {
    @Override
    void operate() {
        System.out.println("Airplane flies");
    }
}

public class DMD {
    public static void main(String[] args) {
        Machine machine1 = new Car();      // Upcasting: Machine reference, Car object
        Machine machine2 = new Airplane(); // Upcasting: Machine reference, Airplane object

        // Dynamic method dispatch
        machine1.operate();  // Outputs: Car drives (Car's operate() method is called)
        machine2.operate();  // Outputs: Airplane flies (Airplane's operate() method is called)
    }
}

/*
Upcasting: machine1 and machine2 are declared as Machine, but they refer to objects of type Car and Airplane, respectively.

Method Call: When operate() is called on machine1 and machine2, 
Java uses dynamic method dispatch to determine which operate() method to call based on the actual object type:

machine1.operate() calls the operate() method in the Car class, because the actual object is a Car.
machine2.operate() calls the operate() method in the Airplane class, because the actual object is an Airplane.
*/

