

/*
Find the sum of digits of a number
Key concept: Add all digits of a number.

Approach:

Extract each digit using the modulus operator.
Add the digit to a sum variable.
Divide the number by 10 and repeat until it becomes 0.
Example:

Input: 123 → Output: 1+2+3 = 6
 */

public class O4_SumofDigits {
    public static void main(String[] args) {
        int n =123;
        int sum =0;
        while (n>0){
            int lastdigit = n % 10;
            sum += lastdigit;
            n /= 10;
        }
        System.out.println(sum); //  6

    }

}
