
/*
Count digits in a number
Key concept: Find the total number of digits in a number.

Approach:

Initialize a counter to 0.
Divide the number by 10 repeatedly until it becomes 0.
Increment the counter in each iteration.
The counter value is the number of digits.
Example:

Input: 12345 → Output: 5 digits
 */
public class O2_CountDigits {
    public static void main(String[] args) {
        int n = 1234434;

        // Extract digits
        System.out.print("Extracted digits (in reverse order): ");
        while (n > 0) {
            int lastDigit = n % 10;
            System.out.print(lastDigit + " ");  // Extract digits in reverse order
            n /= 10;
        }
        System.out.println();

        // Count digits
        int num = 234234234;
        int count = 0;

        while (num > 0) {
           // int rem = num % 10; // Extract last digit (not used here, but optional)
            count++;            // Increment count
            num /= 10;          // Remove the last digit
        }

        System.out.println("Total number of digits: " + count);
    }
}

