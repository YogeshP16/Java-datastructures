public class O01_SkipCharacters {
    public static void main(String[] args) {
        String s = "baccad";
        char target = 'a';
        System.out.println(skip(s, target));   // bccd

       
        
    }

    // iterative 
    static String skipp(String s , char target ){
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch != target){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    /*
    Base Case: If the string is empty (str.isEmpty()), return an empty string ("").

    Recursive Case:
    If the first character (str.charAt(0)) equals the target character (skipChar),
     skip it and recurse on the rest of the string (str.substring(1)).
    Otherwise, include the first character in the result and recurse on the rest of the string.
     */
    static String skip(String s,  char target){
        if(s.isEmpty()) return " ";

        char firstchar = s.charAt(0);   // starts from first character b

        if(firstchar == target){  // skip that character
            return skip(s.substring(1), target);
        }  else{
            return firstchar + skip(s.substring(1), target);
        }

    }


    
    

}
