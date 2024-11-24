

/*
 * Factorial of a number using loops
Key concept: Multiply all integers from 1 to the given number.

Approach:

Initialize a variable to store the result (start with 1).
Multiply the result with numbers from 1 to the input number using a loop.
Print the final result.
Example:

Input: 5 → Output: 5! = 1x2x3x4x5 = 120
 */

public class O1_Factorial {
    public static void main(String[] args) {
        int n = 4;
        int fact =1;
        for(int i=1; i<=n; i++){
            fact *= i;
        }
        System.out.println(fact);
    }

}
