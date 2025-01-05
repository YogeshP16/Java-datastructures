/*

Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.

backAround("cat") → "tcatt"
backAround("Hello") → "oHelloo"
backAround("a") → "aaa"

Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.

front22("kitten") → "kikittenki"
front22("Ha") → "HaHaHa"
front22("abc") → "ababcab"
 */

public class O04_backAround {
    public static void main(String[] args) {
        System.out.println(backAround("cat"));  // tcatt

        System.out.println(backAround2("kitten"));  // kikittenki
                
            }
        public static String backAround(String str) {
        char last = str.charAt(str.length()-1);
        char first = last;
        
        return first + str + last;  
      }

      //=----------------------------------------------------------------
      
      public static String backAround2(String str){

        if(str.isEmpty()){ return "";}
  
        if(str.length() == 1) { return str+str+str;}

        String first = str.substring(0,2);
        String last = first;
        return first + str + last;

      }

}
