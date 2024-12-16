package com.example.introToPackages;
public class User {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int result = cal.add(10, 20);
        System.out.println("Sum " + result);  // Sum 30

        int result1 = cal.sub(10, 20);
        System.out.println("sub " + result1);  // Sum -10
        
    }

}
