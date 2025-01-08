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


Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. 
So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.

stringMatch("xxcaazz", "xxbaaz") → 3
stringMatch("abc", "abc") → 2
stringMatch("abc", "axc") → 0


Given a string, return a version where all the "x" have been removed. Except an "x" 
at the very start or end should not be removed.

stringX("xxHxix") → "xHix"
stringX("abxxxcd") → "abcd"
stringX("xabxxxcdx") → "xabcdx"
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

        System.out.println(stringMatch("xxcaazz", "xxbaaz"));  // Output: 3
        System.out.println(stringMatch("abc", "abc"));         // Output: 2
        System.out.println(stringMatch("abc", "axc"));         // Output: 0

        System.out.println(stringX("xxHxix"));     // Output: "xHix"
        System.out.println(stringX("abxxxcd"));    // Output: "abcd"
        System.out.println(stringX("xabxxxcdx"));  // Output: "xabcdx"
        
                
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
              //-------------------------------------------------------------------
        
              public static int stringMatch(String a, String b) {
                int count = 0;
                // Find the shorter length of the two strings
                int length = Math.min(a.length(), b.length());
        
                // Loop through both strings, comparing substrings of length 2
                for (int i = 0; i < length - 1; i++) {
                    String subA = a.substring(i, i + 2);  // Substring from string a
                    String subB = b.substring(i, i + 2);  // Substring from string b
        
                    if (subA.equals(subB)) {  // Check if substrings match
                        count++;
                    }
                }
                return count;
            }
        
            //------------------------------------------------------------------
            public static String stringX(String str) {
                if(str.length() <=1) {
                return str;
                }
                String s = str.charAt(0) == 'x' ? "x" : "";
                String e = str.charAt(str.length()-1) == 'x' ? "x" : "";
                
                
                StringBuilder res = new StringBuilder();
                
                for(int i =0; i< str.length(); i++){
                    if(str.charAt(i) != 'x'){
                        res.append(str.charAt(i));
                    }
                }
                 return s + res.toString() + e;
        
      }
      

}
