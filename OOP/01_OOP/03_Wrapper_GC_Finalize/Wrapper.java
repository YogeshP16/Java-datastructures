public class Wrapper {
    public static void main(String[] args) {

        // In the case of primitives, you directly change their values.

        int x = 10;
        int y = 20;

        int temp = x;
        x = y;
        y = temp;
        System.out.println("After swap: x = " + x + ", y = " + y);
//--------------------------------------------------------------------------------------------------

        /*
        In the case of wrapper classes (Integer, Double, Character, etc.), 
        you're actually swapping references (the reference to the memory location of the object),
        but the objects themselves cannot be modified because they are immutable.
         */


        Integer a = 10;
        Integer b = 20;

    
        // Using a temporary variable to swap the reference not the actual value 
        Integer temp1 = a;
        a = b;
        b = temp1;
        System.out.println("After swap: a = " + a + ", b = " + b);

    }
}




