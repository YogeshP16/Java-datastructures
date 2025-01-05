
public class O1_SwapTwoVariable {
    public static void main(String[] args) {
        int a=22, b=23;

        //using temp
        int temp = a;
        a=b;
        b=temp;
        System.out.println("after swap : "+ a +" "+  b); 

        //without temp
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("a: " + a + ", b: " + b);

        
    }



}
