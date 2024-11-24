

/*
Check if a number is an Armstrong number
An Armstrong number (or Narcissistic number) is a number that is equal to the sum of its digits each raised to the power of the number of digits.

Key concept: Calculate the sum of each digit raised to the power of the number of digits and compare it with the original number.

Approach:

Find the number of digits in the number.
Calculate the sum of each digit raised to the power of the number of digits.
Compare the sum with the original number.
Example:

153 → 1^3 + 5^3 + 3^3 = 153 → Armstrong number
123 → 1^3 + 2^3 + 3^3 = 36 → Not an Armstrong number
 */

public class O6_ArmStrongnumber {
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
