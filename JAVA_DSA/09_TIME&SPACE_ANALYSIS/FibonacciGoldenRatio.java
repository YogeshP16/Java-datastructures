
public class FibonacciGoldenRatio {

    // Method to calculate Fibonacci number using Golden Ratio formula
    public static long fibonacci(int n) {
        // Golden ratio (phi)
        double phi = (1 + Math.sqrt(5)) / 2;
        
        // Binet's formula: F(n) = (phi^n - (1-phi)^n) / sqrt(5)
        return Math.round((Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        int n = 50; // Fibonacci number index
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}

// Fibonacci number at position 50 is: 12586269025
// you  can calculate high numbers in normal fib you cant get output for 50th number