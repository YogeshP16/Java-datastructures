public class A {
    
    static int objcount = 0;

    // Constructor increments the object count
    A() {
        objcount++;
    }

    // Static method to get the count of objects created
    static int getObjectCount() {
        return objcount;
    }
}

public class CountObjectsExample {
    public static void main(String[] args) {
        // Creating objects of A
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = new A();
        A obj4 = new A();

        // Printing the total object count
        System.out.println("Total object count: " + A.getObjectCount());
    }
}
