

public class OO4_Functions {

    public static void main(String[] args) {
        int a = 23;
        int b = 34;
        
        addition(a, b);  // void --> doesnt return anything

        System.out.println (add (a,b));  // int return type


        String s1 = "Okay";
        String s2 = "Loki";
        System.out.println(concat(s1,s2));

        
        
    }
    static void addition(int a, int b) { // Void method, does not return anything
        System.out.println("Sum: " + (a + b));
    }

    public static int add (int a, int b){   // here return type will be int;
        return a+b;

    }

    static String concat(String s1, String s2){  // return type will be String
        String s3 = s1+ " " +s2;
        return s3;
    }
    

}
