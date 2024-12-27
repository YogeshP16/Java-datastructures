public class FinalizeExample {
    public static void main(String[] args) {
        // Start a loop to create and destroy a large number of objects
        for (long i = 0; i < 10000000000L; i++) {
            // Create a new object
            MyObject obj = new MyObject();
            
            // Nullify the reference to make it eligible for garbage collection
            obj = null;
            
            // Request garbage collection explicitly
            // Note: It's not guaranteed to run immediately or at all, but it's a suggestion
            // gc --> it request jvm to initiatiate garbage collections
            System.gc();
            
            // Optional: Adding a delay so that garbage collection can happen
            // Thread.sleep(1); // Uncomment if you want to slow down the loop for observation
        }
    }
}

class MyObject {
    // Override finalize method to print a message when the object is about to be garbage collected
    // Super --> call base class constructor
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object destroyed by garbage collector");
    }
}



