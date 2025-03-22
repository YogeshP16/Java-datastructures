public class CountDigits {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Number of digits in " + n + " is: " + countDigits(n));  // 5
        System.out.println(countDigitsII(n));  // 3
        System.out.println(sumDigits(n));      // 15
        System.out.println(reverseDigits(n));  // 54321
        System.out.println(isPal(n));          // false
    }

    // count digits
    static int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10; // Remove the last digit from n
            count++;    // Increment the count of digits
        }
        return count;
    }


    /*
    Given an integer num, return the number of digits in num that divide num.
    An integer val divides nums if nums % val == 0.
    */
    static int countDigitsII(int n){
        int count =0; int temp = n;
        while(temp >0){
            int lastDigit = temp % 10;
            if(lastDigit  != 0 && n % lastDigit == 0){
                count++;
            }
            temp /=10;
        }
        return count;
    }

    //  sum of digits
    static int sumDigits(int n){
        int sum =0;
        while(n >0){
            int lastDigit = n % 10;
            sum += lastDigit;
            n/=10;
        }
        return sum;
    }

    // Reverse Digits
    static int reverseDigits(int n){
        int rev =0;
        while(n>0){
            int lastDigit = n % 10;
            rev = rev * 10 + lastDigit;
            n/=10;
        }
        return rev;
    }

    // palindrome
    static boolean isPal(int n){
        int rev = 0;
        while(n>0){
            int lastDigit = n%10;
            rev = rev * 10 + lastDigit;
            n/=10;
        }

        return rev == n;
    }


}
