class Main {
    public static void main(String[] args) {
        System.out.println("Hello There");

        int n = 111123;
        int digit = (int) Math.log10(n) + 1; // Correct usage of log10 for digit count
        System.out.println(digit);


        //swap
        int a= 10, b =20;
        a = a^b^(b=a);
        System.out.print("a: " + a + " ");
        System.out.print("b: " + b);

    }
}
