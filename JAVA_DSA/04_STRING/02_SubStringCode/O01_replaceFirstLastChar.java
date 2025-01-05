

public class O01_replaceFirstLastChar {
    public static void main(String[] args) {
        
        System.out.println(frontBack("Code"));  // eodC
                
        }
        public static String frontBack(String str) {
            if(str.length() <= 1) return str;
            
            char first = str.charAt(0);
            char last = str.charAt(str.length()-1);
            String mid =  str.substring(1, str.length()-1);
            
            return  last + mid + first;
    }
      

}
