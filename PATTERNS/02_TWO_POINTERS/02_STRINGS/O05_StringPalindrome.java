public class O05_StringPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPal(s);
        System.out.println(res); 
    }

    public static boolean isPal(String s) {
        // Convert to lowercase and remove non-alphanumeric characters, including spaces
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = s.length() - 1;

        // Check characters from both ends of the string
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch, not a palindrome
            }
            left++;
            right--; // Move right pointer inward
        }
        return true; // All characters match, it's a palindrome
    }
}
