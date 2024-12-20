
class Constructor {
    int id;
    String name;

    // Default Constructor  --> used to initialize objecct with default values
    Constructor() {
        this(0, "Default Name"); // Constructor chaining
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    Constructor(int id, String name) {
        this.id = id; // Using 'this'(used to refer current objects) to resolve field vs parameter conflict
        this.name = name;
        System.out.println("Parameterized Constructor Called");
    }

    // Constructor Overloading
    Constructor(int id) {
        this(id, "No Name"); // Constructor chaining
        System.out.println("Overloaded Constructor Called");
    }

    // Method to display object data
    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public static void main(String[] args) {
        // Creating objects using different constructors
        Constructor obj1 = new Constructor();         // Default Constructor
        Constructor obj2 = new Constructor(101);      // Overloaded Constructor
        Constructor obj3 = new Constructor(102, "John"); // Parameterized Constructor

        // Displaying object data
        obj1.display();
        obj2.display();
        obj3.display();
    }
}
/*
Parameterized Constructor Called
Default Constructor Called
Parameterized Constructor Called
Overloaded Constructor Called
Parameterized Constructor Called
ID: 0, Name: Default Name
ID: 101, Name: No Name
ID: 102, Name: John
 */
