public class StaticBlock {
    // Static variable 'a' is initialized directly.
    static int a = 10;
    
    // Static variable 'b' will be initialized later in the static block.
    static int b;

    // Static block
    static {
        // This block executes when the class is loaded into memory.
        System.out.println("I am static block");

        // Initialize 'b' using 'a'. Since 'a' is already initialized, this works.
        b = a * 5; // b = 10 * 5 = 50
    }

    public static void main(String[] args) {
        // First access of static variables 'a' and 'b'.
        // Static block has already executed before main starts.
        System.out.println(StaticBlock.a + " " + StaticBlock.b); 
        // Output: 10 50

        // Modify the value of 'b' by adding 3 to it.
        StaticBlock.b += 3; // b = 50 + 3 = 53

        // Print the updated values of 'a' and 'b'.
        System.out.println(StaticBlock.a + " " + StaticBlock.b); 
        // Output: 10 53

        // Creating an object of the class 'StaticBlock'.
       // StaticBlock obj = new StaticBlock();
        
        // Accessing static variables after object creation.
        // Static variables are shared among all instances, so the values remain unchanged.
        System.out.println(StaticBlock.a + " " + StaticBlock.b); 
        // Output: 10 53
    }
}

