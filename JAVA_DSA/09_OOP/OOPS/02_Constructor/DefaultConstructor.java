

class Person1 {
    String name;
    int age;

    // No constructor defined, so default constructor is used
    // why we use --> automatic object creation, initialization of objects
    // default value for string is null, int--> 0, boolean --> false
}

public class DefaultConstructor {
    public static void main(String[] args) {
        Person1 p = new Person1();  // Using default constructor
        System.out.println("Name: " + p.name + ", Age: " + p.age); // Default values: null and 0
    }
}
