import java.util.Scanner;

public class Base{
    public static void main(String[] args) {

        /*
        
        Datatypes
        byte b = 23;
        int i = 344335;
        float f = 2.3f;
        double d = 43442423;
        boolean bool = true;
        char c = 's';
        String str = "Hello world";

         */

        // Range of datatypes
        System.out.println("Range of byte: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("Range of int: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Range of float: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("Range of double: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("Range of boolean: " + Boolean.FALSE + " to " + Boolean.TRUE);
        System.out.println("Range of char: " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);
        
        /*
        Range of byte: -128 to 127
        Range of int: -2147483648 to 2147483647
        Range of float: 1.4E-45 to 3.4028235E38
        Range of double: 4.9E-324 to 1.7976931348623157E308
        Range of boolean: false to true
        Range of char: 0 to 65535
        */


        // input outputs
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
        boolean boo = sc.nextBoolean();

        System.out.println("Integer: " + input);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);
        System.out.println("String: " + str);
        System.out.println("Boolean: " + boo);
        
        

        sc.close();


        // Operators 
        int a = 10;
        int b = 20;

        // Arithmetic Operators
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Relational Operators
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // Logical Operators
        boolean x = true;
        boolean y = false;
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        // Bitwise Operators
        System.out.println("a & b: " + (a & b));
        System.out.println("a | b: " + (a | b));
        System.out.println("a ^ b: " + (a ^ b));
        System.out.println("~a: " + (~a));
        System.out.println("a << 2: " + (a << 2));
        System.out.println("a >> 2: " + (a >> 2));
        System.out.println("a >>> 2: " + (a >>> 2));

        // Assignment Operators
        int c = 30;
        c += 10;
        System.out.println("c += 10: " + c);
        c -= 10;
        System.out.println("c -= 10: " + c);
        c *= 10;
        System.out.println("c *= 10: " + c);
        c /= 10;
        System.out.println("c /= 10: " + c);
        c %= 10;
        System.out.println("c %= 10: " + c);

        
    }

}


