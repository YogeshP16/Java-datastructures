// Custom Exception Class
class CustomException extends Exception {
    // Constructor
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        // Example 1: ArithmeticException Handling
        // try --> find exception occurs or not
        // catch --> catch exception in try block and handle it 
        // throw --> manually trow an exception
        // throws --> we declare a mehtod that throw an exception
        try {
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("If error occurs or not --> finally will always execute." );
      
        }

//--------------------------------------------------------------------------------------------------------

        int x = 10;
        int y = 0;

        // Example 2: Division with Method and Throws
        try {
            divide(x, y);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("It always executes.");
        }

//----------------------------------------------------------------------------------------------
        // Example 3: Custom Exception
        try {
            String name = "Loki";
            if (name.equals("Loki")) {
                throw new CustomException("Hi Loki");
            }
        } catch (CustomException e) { // Catch Custom Exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("If error occurs or not --> finally will always execute.");
        }
    }

    // Method with Throws
    static int divide(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Don't divide by zero"); // Throw an Exception
        }
        return x / y;
    }
}
