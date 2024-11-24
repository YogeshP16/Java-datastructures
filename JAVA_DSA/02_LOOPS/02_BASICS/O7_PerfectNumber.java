

/*Check if a number is a perfect number
A perfect number is a positive integer that is equal to the sum of its proper divisors (divisors excluding the number itself).

Key concept: Find all divisors of the number, sum them, and compare it to the original number.

Approach:

Find the divisors of the number.
Sum the divisors and check if the sum equals the number.
Example:

6 → Divisors of 6: 1, 2, 3 → Sum: 1 + 2 + 3 = 6 → Perfect number
28 → Divisors of 28: 1, 2, 4, 7, 14 → Sum: 1 + 2 + 4 + 7 + 14 = 28 → Perfect number
12 → Divisors of 12: 1, 2, 3, 4, 6 → Sum: 1 + 2 + 3 + 4 + 6 = 16 → Not a perfect number. */

public class O7_PerfectNumber {
    public static void main(String[] args) {
        
        int num = 13;
        int sum = 0;
        for(int i=1; i <= num/2; i++){
            if(num % i ==0){
                sum+=i;
            }

        }
        if(sum == num){
            System.out.println("perfect num");
        } else {
            System.out.println("Not perfect num");
        }
    }

}
