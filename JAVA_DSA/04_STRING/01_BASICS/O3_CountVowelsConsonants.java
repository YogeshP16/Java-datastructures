
public class O3_CountVowelsConsonants {

    // Unique function to check if a character is a vowel
    public static boolean isVowel(char ch) {
        ch = (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch; // Convert to lowercase
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Count vowels
    public static int countVowels(String str) {
        int vowels = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                vowels++;
            }
        }
        return vowels;
    }

    // Count consonants
    public static int countConsonants(String str) {
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isVowel(ch) && ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                consonants++;
            }
        }
        return consonants;
    }

    // Replace vowels with '*'
    public static String replaceVowels(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result += isVowel(ch) ? '*' : ch;
        }
        return result;
    }

    // Print vowels in a string
    public static void printVowels(String str) {
        System.out.print("Vowels: ");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) {
                System.out.print(ch + " ");
            }
        }
        System.out.println();
    }

    // Check if a string contains only vowels
    public static boolean containsOnlyVowels(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isVowel(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Count each vowel type
    public static void countEachVowel(String str) {
        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'A') aCount++;
            else if (ch == 'e' || ch == 'E') eCount++;
            else if (ch == 'i' || ch == 'I') iCount++;
            else if (ch == 'o' || ch == 'O') oCount++;
            else if (ch == 'u' || ch == 'U') uCount++;
        }
        System.out.println("a: " + aCount);
        System.out.println("e: " + eCount);
        System.out.println("i: " + iCount);
        System.out.println("o: " + oCount);
        System.out.println("u: " + uCount);
    }
    public static void main(String[] args) {
        String str = "Educational";

        // Count vowels
        int vowels = countVowels(str);
        System.out.println("Vowels: " + vowels);

        // Count consonants
        int consonants = countConsonants(str);
        System.out.println("Consonants: " + consonants);

        // Replace vowels with '*'
        String replacedString = replaceVowels(str);
        System.out.println("Replaced String: " + replacedString);

        // Print vowels
        printVowels(str);

        // Check if string contains only vowels
        boolean onlyVowels = containsOnlyVowels(str);
        System.out.println("Contains only vowels: " + onlyVowels);

        // Count each vowel type
        countEachVowel(str);
    }
}


/*

Vowels: 6
Consonants: 5

Replaced String: *d*c*t**n*l

Vowels: E u a i o a 

Contains only vowels: false

a: 2
e: 1
i: 1
o: 1
u: 1
 */