public class OO1_RECURSION {

    public static void main(String[] args) {
        print_N(8);
    
    }
    static void print_N(int n){
        if(n <= 0) return;
        print_N(n-1);
        System.out.print(n + " ");
    }

}
