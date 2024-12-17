/*
 Why Child ch = new Parent(); Gives a Compilation Error
  -------------------------------------------------------
In Java, a parent class object cannot be assigned to a child class reference because the parent class
 does not have all the properties or behaviors of the child class.
This breaks the "IS-A" relationship required for assignment in Java inheritance.

Why Does This Happen?
----------------------
In inheritance, a child IS-A parent, but a parent IS-NOT a child.
A child reference expects access to both the parent and child-specific members, but a parent object does not have child-specific fields/methods.
Allowing this assignment would result in runtime inconsistencies and type mismatches.
 */


class Parent {
    void displayParent() {
        System.out.println("This is Parent class.");
    }
}

class Child extends Parent {
    void displayChild() {
        System.out.println("This is Child class.");
    }
}

public class Test {
    public static void main(String[] args) {
        // Invalid: Parent object cannot be referenced by Child
        // Child ch = new Parent(); // Compilation Error

        Parent p = new Child(); // Valid: Child object referenced by Parent  --> known as upcasting
        p.displayParent(); // Works: Parent method is accessible
        // p.displayChild(); // Error: Child method not accessible via Parent reference
    }
}
