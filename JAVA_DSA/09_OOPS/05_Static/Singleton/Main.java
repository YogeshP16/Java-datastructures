package Singleton;

public class Main {
    public static void main(String[] args) {
        // Access Singleton instance using two different variables
        // all obj are pointing to the sameobjects 
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        // Check if both variables point to the same instance
        System.out.println("Instance 1: " + obj1);
        System.out.println("Instance 2: " + obj2);

        // Check equality of the two references
        if (obj1 == obj2) {
            System.out.println("Both variables point to the same Singleton instance.");
        } else {
            System.out.println("Different instances exist!");
        }
    }
}

/*
Instance 1: Singleton.Singleton@36baf30c
Instance 2: Singleton.Singleton@36baf30c
Both variables point to the same Singleton instance.
 */