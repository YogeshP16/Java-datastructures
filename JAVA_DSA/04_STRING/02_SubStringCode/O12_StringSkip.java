/*
Given a string, if the string "del" appears starting at index 1, 
return a string where that "del" has been deleted. Otherwise, return the string unchanged.

delDel("adelbc") → "abc"
delDel("adelHello") → "aHello"
delDel("adedbc") → "adedbc"

Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"

Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".

altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"
 */

public class O12_StringSkip {
    public static void main(String[] args) {

        System.out.println(delDel("adelbc"));  // abc

        System.out.println(stringBits("Hello"));     // Output: "Hlo"
        System.out.println(stringBits("Hi"));        // Output: "H"
        System.out.println(stringBits("Heeololeo")); // Output: "Hello"

        System.out.println(altPairs("kitten"));        // Output: "kien"
        System.out.println(altPairs("Chocolate"));     // Output: "Chole"
        System.out.println(altPairs("CodingHorror"));  // Output: "Congrr"
                        
        }

        public static String delDel(String str) {
            if(str.length() >=4 && str.substring(1,4).equals("del")){
              return str.substring(0,1) + str.substring(4);
            }
            return str;
            
            
        }

        //---------------------------------------------------------------

        public static String stringBits(String str) {
            String res ="";
            for(int i=0; i< str.length(); i+=2){
            res = res + str.charAt(i);
            }
            return res;
        
        }
        //-----------------------------------------------------------
        
        public static String altPairs(String str) {
            StringBuilder result = new StringBuilder();
       
               // Step through the string in increments of 4
            for (int i = 0; i < str.length(); i += 4) {
                // Add the character at index i
                result.append(str.charAt(i));
    
                // If there's a character at index i + 1, add it as well
                if (i + 1 < str.length()) {
                    result.append(str.charAt(i + 1));
                }
            }
       
            return result.toString();
        }
       


      

}
