/* */


import java.util.Scanner;

public class OO2_IO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter your input");
        int input = sc.nextInt();

        System.out.println("enter float");
        float f = sc.nextFloat();

        System.out.println("enter double");
        Double d = sc.nextDouble();

        System.out.println("str");
        String str = sc.nextLine();

        System.out.println("boolean");
        Boolean b = sc.nextBoolean();

       // char c = sc.CharAt(0);


        System.out.println (input);
        System.out.println(f);
        System.out.println(d);
        System.out.println(str);
        System.out.println(b);

        sc.close();

        
        
    }
}
