public class Base {
    public static void main(String[] args) {

        // Creating String using new keyword
        // Stored  in Heap
        String str1 = new String("Hello My Name is"); 
        
        // String literals -> Stored in string pool 
        String str2 = "YOGESH"; 

        // String Comparison -> Equals()
        System.out.println(str1.equals(str2));  // false
        System.out.println(str1 == str2);  // false

        // String Concat
        System.out.println(str1 + " " +str2);  // Hello My Name is YOGESH
        System.out.println(str1.concat(" ").concat(str2));   // Hello My Name is YOGESH

        // Traversal
        for(int i = 0; i < str1.length(); i++){
            System.out.print(str1.charAt(i) + " ");
        }

        // Manipulation
        System.out.print(str1.toUpperCase() );
        System.out.println(str1.toLowerCase());
        System.out.println(str1.length());
        System.out.println(str1.trim());  // remove leading, traiing spaces

        // String Conversion
        int num = 100;
        String str3 = String.valueOf(num);  // int to string
        int x = Integer.parseInt(str3);   // string to int

        System.out.println(str3); // 100 -> this one is string
        System.out.println(x); // 100

        // substring
        System.out.println(str1.substring(0, 9));  // Hello My
        System.out.println(str1.substring(9));  // Name is

        // String contains
        System.out.println(str1.contains(str3));      // false
        System.out.println(str1.contains("Name"));   // true
        System.out.println(str1.startsWith("H"));  // true
        System.out.println(str1.endsWith("name"));  // false


        // Splitting
        String sentence = "Hey how was your Day! I'm going 2 om? ";
        String[] str = sentence.split("\\s+");
        for (String s : str) {
            System.out.println(s);
        }


        // regex
        String text = "Sample text with numbers 123 and special characters !@#";
        boolean isAlphanumeric = text.matches("[a-zA-Z0-9]+");
        System.out.println(isAlphanumeric);

        // Check if string contains only digits
        System.out.println("12345".matches("\\d+"));  // true

        // Check if string contains only letters
        System.out.println("abcXYZ".matches("[a-zA-Z]+"));  // true


     



        
    }

}
