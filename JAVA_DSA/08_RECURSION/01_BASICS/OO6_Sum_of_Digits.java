public class OO6_Sum_of_Digits {
    public static void main(String[] args) {
        System.out.println(sumdigit(1234));
    }
    static int sumdigit(int n){
        if(n<=0) return 0;
        return (n%10) + sumdigit(n/10);  // 10
    }

    /* normal way from right to left extract
     n = 123;
     while (n > 0){
        int rem = n % 10
        n /= 10;
     }
     
     */

}
