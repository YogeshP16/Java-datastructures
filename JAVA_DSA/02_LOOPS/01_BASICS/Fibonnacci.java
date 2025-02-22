

/*
Print Fibonacci series up to n terms
Key concept: Generate a sequence where each number is the sum of the previous two numbers.

Approach:

Initialize the first two terms as 0 and 1.
Loop through n-2 terms, calculating the next term as the sum of the last two terms.
Print each term.
Example:

Input: 5 terms → Output: 0, 1, 1, 2, 3
 */

public class O6_Fibonnacci {

    public static void main(String[] args) {
        int n = 5;
        int x =0, y=1;
        System.out.print(x + " " + y + " ");
        for(int i = 2; i<=n; i++){
            int next = x+y;
            System.out.print( next + " ");
            x = y;
            y = next;
        }
        
    }

}
