package com.yogesh.importStatment;



import com.yogesh.importStatment.a.ClassA;
import com.yogesh.importStatment.b.ClassB;

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
