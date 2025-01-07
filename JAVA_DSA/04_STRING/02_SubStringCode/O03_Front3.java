/*
Given a string, we'll say that the front is the first 3 chars of the string. 
If the string length is less than 3, the front is whatever is there. 
Return a new string which is 3 copies of the front.


front3("Java") → "JavJavJav"
front3("Chocolate") → "ChoChoCho"
front3("abc") → "abcabcabc"


Given a non-empty string like "Code" return a string like "CCoCodCode".


stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"

 */

public class O03_Front3 {
    public static void main(String[] args) {
        String str = "java";

        System.out.println(stringCopy(str));

        System.out.println(stringSplosion(str));
                
        }

        
        public static String stringCopy(String str){
            String front = str.length() < 3 ? str : str.substring(0,3);  // javjavjav
            return front + front + front;
        }

        //---------------------------------------------------------------------------
        
        public static String stringSplosion(String str) {  // jjajavjava
        String res ="";
        for(int i=0; i<str.length(); i++){
          res += str.substring(0, i+1);
        }
        return res;
       
        
      }

}


