/*
 Operation	Code	Explanation

Length	                   s.length();	Returns the number of characters in the string.
Character at Index	       s.charAt(2);	Returns the character at index 2.
Concatenation	           s1 + s2; or s1.concat(s2);	Combines two strings.
Index of Char/Substr	   s.indexOf('o'); or s.indexOf("lo");	Returns the index of the first occurrence.
Substring	               s.substring(1, 4);	Returns a part of the string.
Replace	                   s.replace('l', 'x');	Replaces all occurrences of l with x.
Starts With  	           s.startsWith("He"); 
Ends With                  s.endsWith("ld");	Checks prefix/suffix.
Trim	                   s.trim();	Removes leading and trailing spaces.
Split	                   s.split(" ");	Splits the string into an array.
To Upper                   s.toUpperCase();
To Lower Case	           s.toLowerCase();	Converts case.
Equality	               s.equals("Hello");	Checks content equality.

 */


public class OO2_OPERATIONS {
    public static void main(String[] args) {

        String s1 ="Hello there, this is yogesh";
        String s2 = "Glad To Meet You";
        
        
        System.out.println(s1.length());              // 27
        System.out.println(s1.charAt(3));       // l
        System.out.println(s1 +" " +s2);              // Hello there, this is yogesh Glad To Meet You
        System.out.println(s1.indexOf("thi"));    // 13
        System.out.println(s1.substring(6));  // there, this is yogesh
        System.out.println(s1.substring(6, 17));  // there, this
        System.out.println(s1.replace('h', 'O')); // Hello tOere, tOis is yogesO
        System.out.println(s2.toLowerCase());          // glad to meet you
        System.out.println(s1.toUpperCase());          // HELLO THERE, THIS IS YOGESH
        System.out.println(s1.trim());

        // Stirng split

        String[] res = s1.split(" ");
        for (String str : res) {
            System.out.println(str);  //Hellothere,thisisyogesh
            
        }


        // String to Array
        String s = "lana del rey";
        String [] str = s.split(" ");
        System.out.println(str);



        // Array to String
        String [] words = {"hi", "this", "is", "Loki"};
        System.out.println(String.join(" ", words));   // hi this is Loki



        // String to character
        String str3 = "hellothere";
        char[] ch = str3.toCharArray();
        for (char c : ch) {
            System.out.print( c + " " );   // h e l l o t h e r e
            
        }
        System.out.println();

        

        // Character to String
        char[] chararray = {'h','e','l','l','o'};
        String str4 = new String(chararray);
        System.out.println(str4);                 // hello

        System.out.println();

    
        
        

        
    }
    




}
