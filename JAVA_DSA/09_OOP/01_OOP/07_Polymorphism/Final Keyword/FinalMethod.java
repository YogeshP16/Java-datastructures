class Car0 {
    final void start() {
        System.out.println("Car is starting");
    }
}

class ElectricCar extends Car0 {
    // Trying to override the final method will result in a compile-time error
    // void start() {
    //     System.out.println("Electric Car is starting silently");
    // }
}

public class FinalMethod{
    public static void main(String[] args) {
        Car0 myCar = new ElectricCar();
        myCar.start();  // Outputs: Car is starting
    }
}

/*
The start() method in the Car class is declared as final, so it cannot be overridden by any subclass, including ElectricCar.
The start() method retains its behavior across all subclasses.
 */
