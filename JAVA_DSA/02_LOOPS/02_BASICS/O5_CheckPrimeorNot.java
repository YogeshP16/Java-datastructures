
/* prime number is a number greater than 1 that is divisible only by 1 and itself.

Key concept: Iterate through all numbers from 2 to the square root of the number to check if it has any divisors.

Approach:

If the number is less than or equal to 1, it’s not prime.
Iterate from 2 to the square root of the number and check if it divides the number evenly.
Example:

7 → Check divisibility by numbers from 2 to √7 → No divisors → Prime
10 → Check divisibility by numbers from 2 to √10 → Divisible by 2 and 5 → Not prime
 */

public class O5_CheckPrimeorNot {
    public static void main(String[] args) {
        int n = 123;

        if(n<=1) System.out.println("not prime");

        boolean isPrime =true;
        for(int i=2; i*i <= n; i++){
            if(i % n == 0){
                isPrime=false;
                break;
            }

        }
        if (isPrime){
            System.out.println("isprime");    // isprime
        } else{
            System.out.println("not isprime");
        }


    }
}
