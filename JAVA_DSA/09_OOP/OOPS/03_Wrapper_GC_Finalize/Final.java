public class Final {
    public static void main(String[] args) {
        final int X = 10;
        final int Y = 20;

    //  int temp = X;
    //  X = Y;  // Error: cannot assign a value to final variable 'X'
    //  Y = temp;  // Error: cannot assign a value to final variable 'Y'

        // You cannot swap X and Y because they are final
        System.out.println("X = " + X + ", Y = " + Y);
    }
}

