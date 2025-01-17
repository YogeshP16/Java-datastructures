public class Memory {
    
    // A simple class to demonstrate objects in the heap
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        // Stack memory demonstration
        int x = 10;  // 'x' is a primitive variable, stored in Stack
        System.out.println("Value of x: " + x);

        // Create an object in the heap
        // 'person' is a reference variable, stored in Stack, while the object is in Heap
        Person person = new Person("John", 25); 
        person.display();

        // Modifying the object reference
        // The reference 'person' is now pointing to a new object in the Heap
        person = new Person("Jane", 30);  
        person.display();

        // Another primitive variable in Stack
        int y = 20;  // 'y' is also stored in Stack
        System.out.println("Value of y: " + y);
        
        // We can also demonstrate the garbage collection process here indirectly
        // by dereferencing the object and letting the JVM clean up the memory when the method ends.
        person = null;  // Dereferencing the object; it will be garbage collected when it's no longer referenced
    }
}
