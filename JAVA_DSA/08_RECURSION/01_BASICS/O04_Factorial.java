public class O04_Factorial {

    public static void main(String[] args) {
        //fact(3);
        System.out.println(fact(5));
    }
    static int fact(int n){
        if (n<=1) return 1;
        return n * fact(n-1);  // 120
    }
}
