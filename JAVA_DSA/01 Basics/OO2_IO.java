/**
 * This class demonstrates basic input and output operations in Java using the Scanner class.
 * 
 * <p>
 * The program prompts the user to enter various types of data including an integer, float, double, string, and boolean.
 * It then reads these inputs and prints them back to the console.
 * </p>
 * 
 * <h2>What is it?</h2>
 * <p>
 * This is a simple Java program that showcases how to use the Scanner class to read different types of user inputs from the console.
 * </p>
 * 
 * <h2>What problem does it solve?</h2>
 * <p>
 * It provides a basic example of how to handle user input in a Java program, which is a common requirement in many applications.
 * </p>
 * 
 * <h2>How does it solve the problem?</h2>
 * <p>
 * The program uses the Scanner class to read inputs of various data types (int, float, double, String, and boolean) from the console.
 * It also demonstrates how to handle the newline character left in the input buffer after reading a numeric value.
 * </p>
 */
/* */


import java.util.Scanner;

public class OO2_IO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your input:");
        int input = sc.nextInt();

        System.out.println("Enter float:");
        float f = sc.nextFloat();

        System.out.println("Enter double:");
        double d = sc.nextDouble();

        sc.nextLine(); // Consume the newline character left by nextDouble()

        System.out.println("Enter string:");
        String str = sc.nextLine();

        System.out.println("Enter boolean:");
        boolean b = sc.nextBoolean();

        System.out.println("Integer: " + input);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);
        System.out.println("String: " + str);
        System.out.println("Boolean: " + b);

        sc.close();
    }
}

        
        
