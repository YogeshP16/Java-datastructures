package packageB;

import packageA.ClassA; // Import ClassA from packageA

public class ClassB {
    public static void main(String[] args) {
        // Create an instance of ClassA (from packageA)
        ClassA person = new ClassA("Zen", 30, 80, 85);

        // Access the public field 'age' directly
        System.out.println("Age from ClassB: " + person.age);

        // Accessing private field 'name' through getter method
        System.out.println("Name from ClassB: " + person.getName());

        // Accessing protected field 'score' (not allowed here)
        // System.out.println("Score from ClassB: " + person.score); // Compile-time error

        // Accessing default field 'percentage' (not allowed here)
        // System.out.println("Percentage from ClassB: " + person.percentage); // Compile-time error
    }
}

/*
Age from ClassB: 30
Name from ClassB: Zen
 */