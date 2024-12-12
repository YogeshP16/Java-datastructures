public class O03_PrintBoth {
    public static void main(String[] args) {
        printboth(3);
    }
    static void printboth(int n){
        if(n==0) return;
        System.out.print(n +" ");
        printboth(n-1);
        System.out.print(n + " ");   // 3 2 1 1 2 3 
    }

}
