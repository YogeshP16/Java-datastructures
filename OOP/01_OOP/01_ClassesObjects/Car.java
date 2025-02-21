class Car {
    // Instance variable with public access modifier
    public String model;
    
    // Instance variable with private access modifier
    private int year;

    // Constructor to initialize instance variables
    public Car(String model, int year) {
        this.model = model;  // Initializing public instance variable
        this.year = year;    // Initializing private instance variable
    }

    // Method to display car information
    public void displayInfo() {
        // Local variable inside the method
        // we cannot use access modifier inside local variable because it is temporary variable
        String color = "Red";  // Local variable

        // Accessing public and private instance variables
        System.out.println("Car Model: " + model);  // Accessible directly
        System.out.println("Year: " + year);        // Accessible directly (within the class)
        System.out.println("Car Color: " + color);  // Accessing local variable
    }

    // Getter for the private instance variable
    public int getYear() {
        return year;
    }

    // Setter for the private instance variable
    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {
        // Creating an object of the Car class
        Car myCar = new Car("Toyota", 2023);

        // Calling the method to display car information
        myCar.displayInfo();

        // Accessing private instance variable via getter
        System.out.println("Year (via getter): " + myCar.getYear());

        // Modifying the private instance variable via setter
        myCar.setYear(2024);
        System.out.println("Updated Year (via setter): " + myCar.getYear());
    }
}
