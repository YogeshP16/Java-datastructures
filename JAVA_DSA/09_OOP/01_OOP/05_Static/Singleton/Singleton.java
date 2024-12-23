

public class Singleton {
    // 1. Private static variable to hold the single instance
    private static Singleton instance;

    // 2. Private constructor to restrict object creation from outside
    private Singleton() {
    }

    // 3. Public method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            // Create a new instance if it does not already exist
            instance = new Singleton();
        }
        return instance;
    }
}
