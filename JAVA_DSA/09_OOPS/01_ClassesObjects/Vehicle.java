class Car { 
    
    //Attributes
    String brand;   // Data: The brand of the car
    String model;   // Data: The model of the car
    int year;       // Data: Manufacturing year

    // Behavior (Action)
    void drive() {
        System.out.println("Driving the car: " + brand + " " + model);
    }
}

public class Vehicle {
    public static void main(String[] args) {

        // Car myCar;       ----> declare reference to object
        // myCar = new Car; ----> allocate an object

        // Creating the object  ---> classname refvar = new classname();
        // Car   --> classname is the name of the class that is being instantiated.
        // myCar -->  variable of the class type being created 
        //            (keyword dynamically allocates(that is, allocates at run time)memory for an object 
        //             & returns a reference to it.)
        // new   --> new allocates memory for an object during run time.
        // Car() --> constructor
        Car myCar = new Car();

        // Assigning details
        myCar.brand = "Toyota";   // The dot operator links the name of the object with the name of an instance variable.
        myCar.model = "Corolla";
        myCar.year = 2020;

        // Action: Driving the car
        myCar.drive();
    }
}
