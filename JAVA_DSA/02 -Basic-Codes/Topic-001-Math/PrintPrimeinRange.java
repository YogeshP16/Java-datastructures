

/*
Print all prime numbers in a range
Key concept: Check for prime numbers within a given range.

Approach:

Loop through numbers in the range.
For each number, check divisibility by integers from 2 to its square root.
If no divisor is found, it is a prime number.
Example:

Input: Range: 10-20 → Output: 11, 13, 17, 19
 */

public class O5_PrintPrimeinRange {
    public static void main(String[] args) {
        int start = 10, end = 20;
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i > 1) System.out.print(i +" ");
        }

    }

}
