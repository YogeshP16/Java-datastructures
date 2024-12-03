public class OO7_Product_of_digits {
    public static void main(String[] args) {
        System.out.println(prod(1234));
    }
    static int prod(int n){
        if( n % 10 == n) return n; // used for 1 digit 

        return (n % 10) * prod(n / 10); // 24
    }

}
