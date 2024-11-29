/*
Reverse a number
Key concept: Reverse the digits of the number.
Approach:

Extract the last digit using the modulus operator.
Append it to the reversed number.
Divide the original number by 10 and repeat until it becomes 0.
Example:

Input: 1234 → Output: 4321
 */

public class O3_ReverseNumber {
    public static void main(String[] args) {
        int n =123;
        int rev = 0;
        while(n>0){
            int lastdigit = n % 10;
            rev = rev * 10 + lastdigit;
            n/=10;

        }
        System.out.println(rev);   // 321

        System.out.println();

       

    }




}
