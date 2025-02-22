

/*
Check if a number is a palindrome
A palindrome number is a number that reads the same backward as forward.

Key concept: Reverse the number and compare it with the original.

Approach:

Convert the number to a string or reverse the digits mathematically.
Compare the reversed number with the original.
Example:

121 → Reverse it → 121 → Same as the original → Palindrome
123 → Reverse it → 321 → Not the same → Not a palindrome*/

public class O3_NumberPalindrome {

    public static void main(String[] args) {
        int n = 123;
        int orginal = n;
        int rev = 0;
        while (n> 0){
            int lastdigit = n % 10;
            rev = rev * 10 + lastdigit;
            n/=10;

        }
        if(orginal == rev){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not pal");
        }

        
    }
}
