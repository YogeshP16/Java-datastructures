
/*Check if a string is a palindrome
This is similar to checking a number for a palindrome but works on strings instead.

Key concept: Compare the string with its reverse.

Approach:

Reverse the string.
Compare the reversed string with the original.
Example:

"madam" → Reverse it → "madam" → Same → Palindrome
"hello" → Reverse it → "olleh" → Not same → Not a palindrome */

public class O4_StringPalindrome {
    public static void main(String[] args) {
        String str  = " Hello";
        String rev = "";
        for(int i= str.length()-1; i>=0; i--){  //output ->  Hello: Not Palindrome
            rev += str.charAt(i);

        }
        System.out.println(rev);

        if(str.equals(rev)){
            System.out.println(str +": Palindrome");
        }else{
            System.out.println(str +": Not Palindrome");
        }
    }

}
