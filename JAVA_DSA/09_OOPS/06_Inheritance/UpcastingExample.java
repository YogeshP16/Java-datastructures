// Parent class representing a Building
class Building {
    int length, width, height;

    // Constructor to initialize dimensions of the Building
    Building(int l, int w, int h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    // Method to display the volume of the Building
    void displayVolume() {
        System.out.println("Volume: " + (length * width * height)); // Volume = length * width * height
    }
}

// Child class representing a Skyscraper, which is a specific type of Building
class Skyscraper extends Building {
    int floors; // Specific to Skyscraper, number of floors

    // Constructor to initialize Skyscraper dimensions and floors
    Skyscraper(int l, int w, int h, int floors) {
        super(l, w, h); // Call the Building constructor to initialize common properties
        this.floors = floors;
    }

    // Method to display the number of floors of the Skyscraper
    void displayFloors() {
        System.out.println("Floors: " + floors); // Display number of floors
    }
}

public class UpcastingExample {
    public static void main(String[] args) {
        // Upcasting: Parent reference (Building) points to a Child object (Skyscraper)
        Building b = new Skyscraper(30, 40, 100, 50); // Skyscraper object is being referenced by Building type
        
        b.displayVolume(); // Access Parent method: volume calculation works because it's in the Building class

        // b.displayFloors(); // Error: Building reference cannot access Skyscraper method
        
        // Downcasting: Convert the Parent reference back to a Child reference to access Child-specific methods
        Skyscraper s = (Skyscraper) b; // Downcast Building reference back to Skyscraper
        
        s.displayFloors(); // Access Child method: Now that it's downcasted to Skyscraper, we can call displayFloors()
    }
}
