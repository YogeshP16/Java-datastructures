/*

Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3 


Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".

doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true


Given a string, count how many times a two-character substring appears in the string. 
The substring must be the same as the last two characters of the string, but don't count the occurrence at the very end.
last2("hixxhi") → 1
last2("xaxxaxaxx") → 1
last2("axxxaaxx") → 2
 */


public class O11_CountXX {
    public static void main(String[] args) {
        System.out.println(countXX("abcxx")); // Output: 1
        System.out.println(countXX("xxx"));   // Output: 2
        System.out.println(countXX("xxxx"));  // Output: 3

        System.out.println(doubleX("axxbb"));  // Output: true
        System.out.println(doubleX("axaxax")); // Output: false
        System.out.println(doubleX("xxxxx"));  // Output: true
        System.out.println(doubleX("axxbx"));  // Output: true


        System.out.println(last2("hixxhi"));  // Output: 1
        System.out.println(last2("xaxxaxaxx"));  // Output: 1
        System.out.println(last2("axxxaaxx"));  // Output: 2
        
    }
    
    public static int countXX(String str) {
        int count = 0;

        // Loop through the string and check for "xx"
        for (int i = 0; i < str.length() - 1; i++) {
            // Check if the substring from i to i+2 is "xx"
            if (str.substring(i, i + 2).equals("xx")) {
                count++;
            }
        }

        return count;
    }

    //-----------------------------------------------------------------------

    static boolean doubleX(String str) {
        for (int i = 0; i < str.length() - 1; i++) {

            // Check if we found "x" and it's followed by another "x"
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x') {
                return true;  // First instance of "x" followed by another "x"
            }
           // return false;
        }
        return false;  // No "x" followed by another "x"
         
    }

    //---------------------------------------------------------------------------
    public static int last2(String str) {
        // Screen out too-short string case.
        if (str.length() < 2) return 0;
        
        String lasttwocharacter = str.substring(str.length()-2);
        // Note: substring() with 1 value goes through the end of the string
        int count = 0;
        
        // Check each substring length 2 starting at i
        for (int i=0; i<str.length()-2; i++) {
          String sub = str.substring(i, i+2);
          if (sub.equals(lasttwocharacter)) {  // Use .equals() with strings
            count++;
          }
        }
      
        return count;
      }

}
