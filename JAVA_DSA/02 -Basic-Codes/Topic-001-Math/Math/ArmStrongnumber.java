
// 153 → 1^3 + 5^3 + 3^3 = 153 → Armstrong number
// 123 → 1^3 + 2^3 + 3^3 = 36 → Not an Armstrong number


public class ArmStrongnumber {
    public static void main(String[] args) {
        int n=123;
        int orginal = n;
        int sum=0;
        
        while(n>0){
            int digit = n % 10;
            sum += digit * 3;
            n/=10;
        }

        if(sum == orginal){
            System.out.println("Armstrong");
        } else {
            System.out.println("Not an Armstrong");

        }
    }

}
