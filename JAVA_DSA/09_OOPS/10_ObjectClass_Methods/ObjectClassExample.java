public class ObjectClassExample {
    
    private int id;
    private String name;

    // Constructor
    public ObjectClassExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override toString() method to provide a custom string representation
    @Override
    public String toString() {
        return "ObjectClassExample [id=" + id + ", name=" + name + "]";
    }

    // Override equals() method to compare objects based on id and name
    @Override
    public boolean equals(Object obj) {
        return this.id == ((ObjectClassExample)obj).id;
    }
    

    // Override hashCode() method to generate a unique hash based on id and name
    @Override
    public int hashCode() {
        return 31 * id + name.hashCode(); // Hash based on fields
    }

    // Method to demonstrate finalize() (rarely used)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is being garbage collected!");
        super.finalize();  // Call the parent finalize
    }

    public static void main(String[] args) {
        // Create two objects
        ObjectClassExample obj1 = new ObjectClassExample(1, "Zeke");
        ObjectClassExample obj2 = new ObjectClassExample(1, "Zeke");

        // toString() method usage
        System.out.println("Object 1: " + obj1.toString());    // Object 1: ObjectClassExample [id=1, name=Zeke]

        // equals() method usage
        System.out.println("Are obj1 and obj2 equal? " + obj1.equals(obj2));  // Are obj1 and obj2 equal? true

        System.out.println(obj1 == obj2);  // Equals operator: ---> false

        // hashCode() method usage
        System.out.println("HashCode of obj1: " + obj1.hashCode());   // HashCode of obj1: 2781700
        System.out.println("HashCode of obj2: " + obj2.hashCode());   // HashCode of obj2: 2781700

        // instanceof usage
        if (obj1 instanceof ObjectClassExample) {
            System.out.println("obj1 is an instance of ObjectClassExample.");   // obj1 is an instance of ObjectClassExample.
        }

        // getClass() method usage  --> Returns the `Class` object associated with the runtime class of the object. 
        System.out.println("Class of obj1: " + obj1.getClass().getName());   // Class of obj1: ObjectClassExample

        // Demonstrating finalize() method (can be seen during garbage collection)
        obj1 = null;  // Making obj1 eligible for garbage collection
        System.gc();  // Requesting garbage collection   ---> Object is being garbage collected!
    }
}
