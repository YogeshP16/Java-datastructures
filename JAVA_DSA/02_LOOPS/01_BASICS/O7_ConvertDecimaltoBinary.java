
/* 
Convert decimal to binary
Key concept: Represent the decimal number in binary form.

Approach:

Divide the number by 2 repeatedly and store the remainders.
Read the remainders in reverse order to form the binary number.
Example:

Input: 10 → Output: 1010


 * Convert binary to decimal
Key concept: Convert a binary number into its decimal equivalent.

Approach:

Multiply each binary digit by 2 raised to the power of its position (starting from the right).
Add all results.
Example:

Input: 1010 → Output: 10
 */

 public class O7_ConvertDecimaltoBinary {
    public static void main(String[] args) {
        // Decimal to Binary Conversion
        int decimal = 10;
        String binary = "";

        int temp = decimal; // Temporary variable to preserve the original decimal value
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp /= 2; // Divide by 2, not 10
        }
        System.out.println("Binary of " + decimal + ": " + binary);

        System.out.println();

        // Binary to Decimal Conversion
        String bin = "1010";
        int deci = 0;
        for (int i = 0; i < bin.length(); i++) { // Loop should run from 0 to bin.length() - 1
            deci = deci * 2 + (bin.charAt(i) - '0'); // Subtract '0' to convert character to integer
        }
        System.out.println("Decimal of " + bin + ": " + deci);
    }
}
