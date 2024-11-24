public class OO6_Increment_Decrement {
    public static void main(String[] args) {
        System.out.println("POST / PRE --> Increment / Decrement");

        System.out.println("Post inc");

        int i = 5;
        System.out.println(i++); // Outputs 5 (value is printed before increment)
        System.out.println(i);   // Outputs 6 (value after increment)

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


    }

}
