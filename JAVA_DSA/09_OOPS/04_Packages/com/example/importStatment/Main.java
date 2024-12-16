package com.example.importStatment;



import com.example.importStatment.a.ClassA;  // Importing from package a
import com.example.importStatment.b.ClassB;  // Importing from package b

public class Main {
    public static void main(String[] args) {
        // Using ClassA from package a
        ClassA classA = new ClassA();
        classA.displayA();               // Hello from ClassA in package a!
        
        // Using ClassB from package b
        ClassB classB = new ClassB();
        classB.displayB();               // Hello from ClassB in package b!
    }
}
