public class Base {
    public static void main(String[] args) {
        int n = 5;

        // Print 0 to 4
        for(int i = 0; i < n; i++) {
            System.out.print(i + " ");  // Output: 0 1 2 3 4
        }
        System.out.println();

        // Print 1 to 5
        for(int i = 1; i <= n; i++) {
            System.out.print(i + " ");  // Output: 1 2 3 4 5
        }
        System.out.println();

        // Print Odd numbers
        for(int i = 1; i <= n; i += 2) {
            System.out.print(i + " ");  // Output: 1 3 5
        }
        System.out.println();

        // Print Even numbers
        for(int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");  // Output: 2 4
        }
        System.out.println();

        // Reverse order (descending)
        for(int i = n; i >= 1; i--) {
            System.out.print(i + " ");  // Output: 5 4 3 2 1
        }
        System.out.println();

//=========================================================================================
//  While Loops

        int i = 0;
        while(i < n){
            System.out.print(i + " "); // 0 1 2 3 4
            i++;
        }
        System.out.println();

        i = 1;
        while(i <= n){
            System.out.print(i + " ");  // 1 2 3 4 5
            i++;
        }
        System.out.println();

        // print odd

        i = 1;
        while(i <= n){
            System.out.print(i + " "); // 1 3 5
            i += 2;
        }
        System.out.println();

        // print even

        i = 2;
        while(i <= n){
            System.out.print(i + " "); // 2 4
            i += 2;
        }
        System.out.println();

        i = n;
        while(i >= 1){
            System.out.print(i + " ");  // 5 4 3 2 1
            i--;
        }
        System.out.println();


//==============================================================================
// Post - Pre Increment / Decrement

        int x = 10;
        int y = 20;

        // Post-increment: z is assigned x's value (10), then x is incremented to 11
        int z = x++;  //  // Assign current x (10) to z, THEN increment x
        System.out.println(x);  // 11
        System.out.println(z);  // 10 -> here z hold the x value not the icremented one

        // Pre-increment: x is incremented to 12, then its value is printed
        System.out.println(++x);  // 12

        // Post-decrement: y's value (20) is printed, then y is decremented to 19
        System.out.println(y--);  // 20

        // Pre-decrement: y is decremented to 18, then its value is printed
        System.out.println(--y);  // 18



        System.out.println("Post inc");

        int m = 5;
        System.out.println(m++); // Outputs 5 (value is printed before increment)
        System.out.println(m);   // Outputs 6 (value after increment)

        System.out.println("pre inc");
            
        int j = 5;
        System.out.println(++j); // Outputs 6 (value is incremented before printing)
        System.out.println(j);   // Outputs 6 (value after increment)

        System.out.println("post dec");

        int k = 5;
        System.out.println(k--); // Outputs 5 (value is printed before decrement)
        System.out.println(k);   // Outputs 4 (value after decrement)

        System.out.println("pre dec");

        int l = 5;
        System.out.println(--l); // Outputs 4 (value is decremented before printing)
        System.out.println(l);   // Outputs 4 (value after decrement)



//=====================================================================================


        


        
    }
}
