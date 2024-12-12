public class O08_ReverseNumber {
    public static void main(String[] args) {
        int n = 1234;
        int reversed = reverseNumber(n, 0); // Start with initial reversed number as 0
        System.out.println("Reversed number: " + reversed);
    }

    static int reverseNumber(int n, int reversed) {
        if (n == 0) {
            return reversed; // Base condition: when n is 0, return the reversed number
        }
        int lastDigit = n % 10;       // Get the last digit of n
        reversed = reversed * 10 + lastDigit; // Append the last digit to reversed
        return reverseNumber(n / 10, reversed); // Remove last digit and recurse   --> 4321
    }
}


/*
Step	Function Call	        n	    reversed	n % 10 (Last Digit)	New reversed (Accumulated)	Output
1	    reverseNumber(1234, 0)	1234	0	         4	                0 * 10 + 4 = 4	
2	    reverseNumber(123, 4)	123	    4	         3	                4 * 10 + 3 = 43	
3	    reverseNumber(12, 43)	12	    43	         2	                43 * 10 + 2 = 432	
4	    reverseNumber(1, 432)	1	    432	         1	                432 * 10 + 1 = 4321	
5	    reverseNumber(0, 4321)	0	    4321	     -	                4321	                        4321
 */